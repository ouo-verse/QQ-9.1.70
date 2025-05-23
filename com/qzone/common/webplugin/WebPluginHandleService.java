package com.qzone.common.webplugin;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.qzone.common.webplugin.WebPluginHandleService;
import com.qzone.preview.service.ServiceCmdDispatcher;
import com.qzone.preview.service.base.AbstractBaseService;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.IActionListener;
import cooperation.qzone.remote.RecvMsg;
import cooperation.qzone.remote.SendMsg;
import cooperation.qzone.remote.ServiceConst;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import e8.e;
import e8.f;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes39.dex */
public class WebPluginHandleService extends AbstractBaseService implements RemoteHandleConst {

    /* renamed from: d, reason: collision with root package name */
    private volatile ServiceCmdDispatcher f46161d;

    /* renamed from: f, reason: collision with root package name */
    private RemoteCallbackList<IActionListener> f46163f;

    /* renamed from: e, reason: collision with root package name */
    private AtomicInteger f46162e = new AtomicInteger(1);

    /* renamed from: h, reason: collision with root package name */
    protected e f46164h = new a();

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean t(RecvMsg recvMsg) {
        boolean z16;
        RemoteCallbackList<IActionListener> remoteCallbackList = this.f46163f;
        z16 = false;
        int i3 = 0;
        z16 = false;
        z16 = false;
        if (remoteCallbackList != null) {
            try {
                int beginBroadcast = remoteCallbackList.beginBroadcast();
                boolean z17 = false;
                while (i3 < beginBroadcast) {
                    try {
                        this.f46163f.getBroadcastItem(i3).onRecvFromMsg(recvMsg);
                        i3++;
                        z17 = true;
                    } catch (RemoteException e16) {
                        e = e16;
                        z16 = z17;
                        QZLog.e("exception", "ActionHandler onRecvFromMsg", e);
                        return z16;
                    } catch (Exception e17) {
                        e = e17;
                        z16 = z17;
                        QZLog.e("exception", "notifyCallback ", e);
                        return z16;
                    }
                }
                this.f46163f.finishBroadcast();
                z16 = z17;
            } catch (RemoteException e18) {
                e = e18;
            } catch (Exception e19) {
                e = e19;
            }
        }
        return z16;
    }

    @Override // android.app.Service
    public void onDestroy() {
        RemoteCallbackList<IActionListener> remoteCallbackList = this.f46163f;
        if (remoteCallbackList != null) {
            remoteCallbackList.kill();
            this.f46163f = null;
        }
        if (this.f46161d != null) {
            this.f46161d.destroy();
            this.f46161d = null;
        }
        f.a().b().o(this.f46164h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements e {
        a() {
        }

        @Override // e8.e
        public void a(final e.a aVar) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.common.webplugin.b
                @Override // java.lang.Runnable
                public final void run() {
                    WebPluginHandleService.a.this.c(aVar);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(e.a aVar) {
            if (aVar == null || aVar.f395860j) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable(RemoteHandleConst.PARAM_SONG, aVar.f395852b);
            bundle.putInt(RemoteHandleConst.PARAM_CURREN_TTIME, aVar.f395859i);
            bundle.putInt("param.duration", aVar.f395858h);
            bundle.putInt(RemoteHandleConst.PARAM_PLAY_MODE_RANDOM, aVar.f395861k);
            bundle.putInt(RemoteHandleConst.PARAM_STATE, aVar.f395854d);
            bundle.putBoolean(RemoteHandleConst.PARAM_NEED_PALY_TIPS, aVar.f395862l);
            RecvMsg recvMsg = new RecvMsg(WebPluginHandleService.this.f46162e.incrementAndGet(), RemoteHandleConst.CMD_NOTIFY_STATE_CALLBACK);
            recvMsg.extraData.putParcelable("data", bundle);
            WebPluginHandleService.this.t(recvMsg);
        }
    }

    /* loaded from: classes39.dex */
    class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private int f46166a;

        /* renamed from: b, reason: collision with root package name */
        private String f46167b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f46168c;

        /* renamed from: d, reason: collision with root package name */
        private IActionListener f46169d;

        b() {
            super(QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).getLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IActionListener iActionListener;
            if (message.what != this.f46166a) {
                return;
            }
            RecvMsg recvMsg = new RecvMsg(this.f46166a, this.f46167b);
            Object obj = message.obj;
            if (obj instanceof Parcelable) {
                recvMsg.extraData.putParcelable("data", (Parcelable) obj);
            } else if (obj instanceof Serializable) {
                recvMsg.extraData.putSerializable("data", (Serializable) obj);
            } else if (obj instanceof SmartParcelable) {
                recvMsg.extraData.putParcelable("data", ParcelableWrapper.obtain((SmartParcelable) obj));
            }
            if (WebPluginHandleService.this.t(recvMsg) || !this.f46168c || (iActionListener = this.f46169d) == null) {
                return;
            }
            try {
                iActionListener.onRecvFromMsg(recvMsg);
            } catch (RemoteException e16) {
                QZLog.w(e16);
            }
        }

        b(WebPluginHandleService webPluginHandleService, SendMsg sendMsg) {
            this();
            this.f46166a = sendMsg.getRequestId();
            this.f46167b = sendMsg.getServiceCmd();
            this.f46168c = sendMsg.isNeedCallback();
            this.f46169d = sendMsg.actionListener;
        }
    }

    public void v(IActionListener iActionListener) throws RemoteException {
        RemoteCallbackList<IActionListener> remoteCallbackList;
        if (iActionListener == null || (remoteCallbackList = this.f46163f) == null) {
            return;
        }
        remoteCallbackList.unregister(iActionListener);
    }

    @Override // com.qzone.preview.service.base.AbstractBaseService
    public void handleRequest(SendMsg sendMsg) {
        if (sendMsg == null) {
            return;
        }
        String serviceCmd = sendMsg.getServiceCmd();
        if (ServiceConst.CMD_REGISTER_LISTENER.equals(serviceCmd)) {
            try {
                u(sendMsg.actionListener);
                return;
            } catch (RemoteException e16) {
                QZLog.w(e16);
                return;
            }
        }
        if (ServiceConst.CMD_UNREGISTER_LISTENER.equals(serviceCmd)) {
            try {
                v(sendMsg.actionListener);
                return;
            } catch (RemoteException e17) {
                QZLog.w(e17);
                return;
            }
        }
        b bVar = sendMsg.isNeedCallback() ? new b(this, sendMsg) : null;
        if (this.f46161d == null) {
            synchronized (this) {
                if (this.f46161d == null) {
                    ServiceCmdDispatcher serviceCmdDispatcher = new ServiceCmdDispatcher();
                    serviceCmdDispatcher.loadMethods(new WebPluginHandleLogic(), WebPluginHandleLogic.class);
                    this.f46161d = serviceCmdDispatcher;
                }
            }
        }
        if (this.f46161d != null) {
            this.f46161d.dispatchCmd(serviceCmd, sendMsg, bVar);
        }
    }

    public void u(IActionListener iActionListener) throws RemoteException {
        if (iActionListener == null) {
            return;
        }
        if (this.f46163f == null) {
            synchronized (this) {
                if (this.f46163f == null) {
                    this.f46163f = new RemoteCallbackList<>();
                }
            }
        }
        this.f46163f.register(iActionListener);
        try {
            f.a().b().g(this.f46164h);
        } catch (Exception e16) {
            QLog.e("AbstractBaseService", 1, e16, new Object[0]);
        }
    }
}
