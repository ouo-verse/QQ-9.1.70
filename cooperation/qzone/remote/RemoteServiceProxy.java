package cooperation.qzone.remote;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import cooperation.qzone.remote.IServiceHandler;
import cooperation.qzone.util.QZLog;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes28.dex */
public class RemoteServiceProxy {
    private static final String tag = "RemoteServiceProxy";
    private IActionListener mActionListener;
    protected volatile IServiceHandler serviceHandler;
    private String serviceName;
    protected Object sendLock = new Object();
    protected ConcurrentLinkedQueue<SendMsg> sendMsgQueue = new ConcurrentLinkedQueue<>();
    protected volatile long lastStartSerivceTime = -1;
    protected ServiceConnection conn = new ServiceConnection() { // from class: cooperation.qzone.remote.RemoteServiceProxy.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (QLog.isColorLevel()) {
                QLog.d(RemoteServiceProxy.tag, 2, " onServiceConnected service:" + componentName + ",mActionListener:" + RemoteServiceProxy.this.mActionListener);
            }
            RemoteServiceProxy.this.serviceHandler = IServiceHandler.Stub.asInterface(iBinder);
            if (RemoteServiceProxy.this.mActionListener != null) {
                SendMsg sendMsg = new SendMsg(ServiceConst.CMD_REGISTER_LISTENER);
                sendMsg.actionListener = RemoteServiceProxy.this.mActionListener;
                RemoteServiceProxy.this.sendMsg(sendMsg);
            }
            try {
                RemoteServiceProxy.this.onBaseServiceConnected();
            } catch (Throwable th5) {
                QZLog.d(RemoteServiceProxy.tag, 1, "[onServiceConnected] throwable: " + th5);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (QLog.isColorLevel()) {
                QLog.d(RemoteServiceProxy.tag, 2, " onServiceDisconnected " + componentName + ",mActionListener:" + RemoteServiceProxy.this.mActionListener);
            }
            RemoteServiceProxy.this.serviceHandler = null;
        }
    };

    public RemoteServiceProxy(String str) {
        this.serviceName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMsgToServiceInner(SendMsg sendMsg) {
        try {
            IServiceHandler iServiceHandler = this.serviceHandler;
            if (iServiceHandler != null) {
                iServiceHandler.sendMsg(sendMsg);
            } else {
                try {
                    sendFailedRespToApp(sendMsg, createWaiteRespTimeout(sendMsg, "main thread sendMsgToServiceFailed. serviceHandler is null."));
                } catch (Throwable th5) {
                    QLog.e(tag, 1, "", th5);
                }
            }
        } catch (Exception e16) {
            QLog.e(tag, 1, "", e16);
        }
    }

    protected void addMsgToSendQueue(SendMsg sendMsg) {
        this.sendMsgQueue.add(sendMsg);
    }

    protected RecvMsg createWaiteRespTimeout(SendMsg sendMsg, String str) {
        RecvMsg recvMsg = new RecvMsg(sendMsg.getRequestId(), sendMsg.getServiceCmd());
        recvMsg.setBusinessFail(1002, str);
        return recvMsg;
    }

    protected boolean isConnected() {
        if (this.serviceHandler != null) {
            return true;
        }
        return false;
    }

    protected void onBaseServiceConnected() {
        BaseThread baseThread = new BaseThread() { // from class: cooperation.qzone.remote.RemoteServiceProxy.2
            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                while (!RemoteServiceProxy.this.sendMsgQueue.isEmpty()) {
                    SendMsg poll = RemoteServiceProxy.this.sendMsgQueue.poll();
                    if (poll != null) {
                        try {
                            RemoteServiceProxy.this.sendMsgToService(poll);
                        } catch (Exception e16) {
                            RemoteServiceProxy.this.sendFailedRespToApp(poll, RemoteServiceProxy.this.createWaiteRespTimeout(poll, "sendMsgToServiceFailed\uff0c" + e16.toString()));
                        }
                    }
                }
            }
        };
        baseThread.setName("handleWaitSendProxyMsgThread");
        baseThread.start();
    }

    protected void sendFailedRespToApp(SendMsg sendMsg, RecvMsg recvMsg) {
        try {
            if (sendMsg.getActionListener() != null) {
                sendMsg.getActionListener().onRecvFromMsg(recvMsg);
            } else {
                IActionListener iActionListener = this.mActionListener;
                if (iActionListener != null) {
                    iActionListener.onRecvFromMsg(recvMsg);
                }
            }
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
    }

    public void sendMsg(SendMsg sendMsg) {
        try {
            synchronized (this.sendLock) {
                if (isConnected()) {
                    sendMsgToService(sendMsg);
                } else {
                    addMsgToSendQueue(sendMsg);
                    startBaseServiceConn();
                }
            }
        } catch (DeadObjectException unused) {
            addMsgToSendQueue(sendMsg);
        } catch (Exception e16) {
            if (this.serviceHandler == null) {
                addMsgToSendQueue(sendMsg);
            } else {
                e16.printStackTrace();
            }
        }
    }

    protected void sendMsgToService(final SendMsg sendMsg) throws RemoteException {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            ThreadManagerV2.post(new Runnable() { // from class: cooperation.qzone.remote.RemoteServiceProxy.3
                @Override // java.lang.Runnable
                public void run() {
                    RemoteServiceProxy.this.sendMsgToServiceInner(sendMsg);
                }
            }, 10, null, false);
        } else {
            sendMsgToServiceInner(sendMsg);
        }
    }

    public void setActionListener(IActionListener iActionListener) {
        this.mActionListener = iActionListener;
    }

    void startBaseService() {
        try {
            Intent intent = new Intent();
            intent.setClassName(BaseApplicationImpl.getApplication(), this.serviceName);
            intent.putExtra(PluginStatic.PARAM_USE_SKIN_ENGINE, 1);
            BaseApplicationImpl.getApplication().bindService(intent, this.conn, 1);
            if (QLog.isColorLevel()) {
                QLog.d(tag, 2, " start service finish");
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void startBaseServiceConn() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.lastStartSerivceTime != -1 && currentTimeMillis - this.lastStartSerivceTime <= 1000) {
            if (QLog.isColorLevel()) {
                QLog.d(tag, 2, "wait start " + this.serviceName + " service result, skiped...");
                return;
            }
            return;
        }
        this.lastStartSerivceTime = currentTimeMillis;
        startBaseService();
    }

    public void unbindBaseService() {
        try {
            BaseApplication.getContext().unbindService(this.conn);
            this.serviceHandler = null;
            if (QLog.isColorLevel()) {
                QLog.d(tag, 2, " unbindService service finished");
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
