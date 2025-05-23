package cooperation.qzone.remote.logic;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.IActionListener;
import cooperation.qzone.remote.RecvMsg;
import cooperation.qzone.remote.RemoteServiceProxy;
import cooperation.qzone.remote.SendMsg;
import cooperation.qzone.remote.ServiceConst;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes28.dex */
public class RemoteHandleManager {
    static final String TAG = "RemoteHandleManager";
    private static RemoteHandleManager mInstance;
    private RemoteRequestSender mSender;
    private RemoteServiceProxy serviceProxy;
    private static Object lock = new Object();
    private static Object serviceLock = new Object();
    private CopyOnWriteArrayList<WeakReference<WebEventListener>> mWebEventListeners = new CopyOnWriteArrayList<>();
    IActionListener mActionListener = new IActionListener.Stub() { // from class: cooperation.qzone.remote.logic.RemoteHandleManager.1
        @Override // cooperation.qzone.remote.IActionListener
        public void onRecvFromMsg(RecvMsg recvMsg) throws RemoteException {
            WebEventListener webEventListener;
            if (recvMsg != null && !TextUtils.isEmpty(recvMsg.getServiceCmd()) && RemoteHandleManager.this.mWebEventListeners != null) {
                Iterator it = RemoteHandleManager.this.mWebEventListeners.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference != null && (webEventListener = (WebEventListener) weakReference.get()) != null) {
                        webEventListener.onWebEvent(recvMsg.getServiceCmd(), recvMsg.extraData);
                    }
                }
            }
        }
    };
    private AtomicInteger mReqestId = new AtomicInteger(1);

    public RemoteHandleManager() {
        getServiceProxy();
    }

    public static RemoteHandleManager getInstance() {
        if (mInstance == null) {
            synchronized (lock) {
                if (mInstance == null) {
                    mInstance = new RemoteHandleManager();
                }
            }
        }
        return mInstance;
    }

    public void addWebEventListener(WebEventListener webEventListener) {
        CopyOnWriteArrayList<WeakReference<WebEventListener>> copyOnWriteArrayList;
        if (webEventListener != null && (copyOnWriteArrayList = this.mWebEventListeners) != null) {
            Iterator<WeakReference<WebEventListener>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference<WebEventListener> next = it.next();
                if (next != null) {
                    WebEventListener webEventListener2 = next.get();
                    if (webEventListener2 == null) {
                        this.mWebEventListeners.remove(next);
                    } else if (webEventListener2 == webEventListener) {
                        return;
                    }
                }
            }
            this.mWebEventListeners.add(new WeakReference<>(webEventListener));
        }
    }

    public void destroy() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "----destroy----");
        }
        RemoteServiceProxy remoteServiceProxy = this.serviceProxy;
        if (remoteServiceProxy != null) {
            remoteServiceProxy.unbindBaseService();
        }
    }

    public RemoteRequestSender getSender() {
        if (this.mSender == null) {
            this.mSender = new RemoteRequestSender(this);
        }
        return this.mSender;
    }

    public RemoteServiceProxy getServiceProxy() {
        RemoteServiceProxy remoteServiceProxy = this.serviceProxy;
        if (remoteServiceProxy != null) {
            return remoteServiceProxy;
        }
        synchronized (serviceLock) {
            if (this.serviceProxy == null) {
                RemoteServiceProxy remoteServiceProxy2 = new RemoteServiceProxy(ServiceConst.INTENT_WEBPLUGIN_SERVICE);
                this.serviceProxy = remoteServiceProxy2;
                remoteServiceProxy2.setActionListener(this.mActionListener);
            }
        }
        return this.serviceProxy;
    }

    public void removeWebEventListener(WebEventListener webEventListener) {
        CopyOnWriteArrayList<WeakReference<WebEventListener>> copyOnWriteArrayList;
        if (webEventListener != null && (copyOnWriteArrayList = this.mWebEventListeners) != null) {
            Iterator<WeakReference<WebEventListener>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference<WebEventListener> next = it.next();
                if (next != null) {
                    WebEventListener webEventListener2 = next.get();
                    if (webEventListener2 == null) {
                        this.mWebEventListeners.remove(next);
                    } else if (webEventListener2 == webEventListener) {
                        this.mWebEventListeners.remove(next);
                    }
                }
            }
        }
    }

    protected int sendData(String str, Bundle bundle, long j3, boolean z16) {
        SendMsg sendMsg = new SendMsg(str);
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (bundle.size() > 0) {
            sendMsg.extraData.putAll(bundle);
        }
        int incrementAndGet = this.mReqestId.incrementAndGet();
        sendMsg.setRequestId(incrementAndGet);
        if (j3 > 0) {
            sendMsg.setTimeout(j3);
        }
        sendMsg.setNeedCallback(z16);
        if (z16) {
            sendMsg.actionListener = this.mActionListener;
        }
        try {
            if (getServiceProxy() != null) {
                getServiceProxy().sendMsg(sendMsg);
            } else {
                QLog.e(TAG, 1, "sendData getServiceProxy()== null cmd= " + str);
            }
            return incrementAndGet;
        } catch (Exception e16) {
            e16.printStackTrace();
            throw new RuntimeException("sendMsg is fail", e16);
        }
    }

    public int sendData(String str, Bundle bundle, boolean z16) {
        try {
            return sendData(str, bundle, 0L, z16);
        } catch (Exception e16) {
            e16.printStackTrace();
            return -1;
        }
    }
}
