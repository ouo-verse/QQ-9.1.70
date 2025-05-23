package com.tencent.mobileqq.emosm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.emosm.web.IPCConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public class Client implements IPCConstants {
    public static final String TAG = "Q.emoji.web.Client";
    boolean mIsBound;
    Messenger mService = null;
    final Messenger mMessenger = new Messenger(new b(Looper.getMainLooper()));
    private ServiceConnection mConnection = new a();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                Client client = Client.this;
                client.mIsBound = true;
                client.mService = new Messenger(iBinder);
                if (QLog.isColorLevel()) {
                    QLog.i(Client.TAG, 2, "ServiceConnection Attached.");
                }
                ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).onBindSuc();
                Message obtain = Message.obtain((Handler) null, 1);
                Client client2 = Client.this;
                obtain.replyTo = client2.mMessenger;
                client2.mService.send(obtain);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(Client.TAG, 2, e16.getMessage());
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Client client = Client.this;
            client.mService = null;
            client.onDisconnectWithService();
            if (QLog.isColorLevel()) {
                QLog.i(Client.TAG, 2, "Disconnected.");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != 4) {
                if (i3 != 5) {
                    super.handleMessage(message);
                    return;
                }
                Client.this.onPushMsgFromServer(message.getData());
                if (QLog.isColorLevel()) {
                    QLog.i(Client.TAG, 2, "resp from server MSG_SERVER_DOWNLOAD_STATE");
                    return;
                }
                return;
            }
            Client.this.onRespFromServer(message.getData());
            if (QLog.isColorLevel()) {
                QLog.i(Client.TAG, 2, "resp from server MSG_CLIENT_RESP");
            }
        }
    }

    public void doBindService(Context context, Class<?> cls) {
        try {
            context.bindService(new Intent(context, cls), this.mConnection, 1);
            this.mIsBound = true;
        } catch (SecurityException e16) {
            this.mIsBound = false;
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, e16.getMessage());
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "Binding...");
        }
    }

    public void doUnbindService(Context context) {
        if (this.mIsBound) {
            if (this.mService != null) {
                try {
                    Message obtain = Message.obtain((Handler) null, 2);
                    obtain.replyTo = this.mMessenger;
                    this.mService.send(obtain);
                } catch (RemoteException unused) {
                }
            }
            try {
                context.unbindService(this.mConnection);
            } catch (IllegalArgumentException unused2) {
            }
            this.mService = null;
            this.mIsBound = false;
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "Unbinding.");
            }
        }
    }

    public boolean isClientBinded() {
        if (this.mService == null) {
            return false;
        }
        return true;
    }

    void onDisconnectWithService() {
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).onDisconnectWithService();
    }

    void onPushMsgFromServer(Bundle bundle) {
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).onPushMsgFromServer(bundle);
    }

    public boolean onReqToServer(Bundle bundle) {
        boolean z16 = false;
        if (this.mService != null) {
            try {
                Message obtain = Message.obtain(null, 3, 0, 0);
                obtain.replyTo = this.mMessenger;
                obtain.setData(bundle);
                this.mService.send(obtain);
                z16 = true;
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "req to server");
                }
            } catch (RemoteException unused) {
                this.mService = null;
            }
        }
        return z16;
    }

    void onRespFromServer(Bundle bundle) {
        try {
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).onRespFromClient(bundle);
        } catch (IllegalArgumentException unused) {
            try {
                QLog.e(TAG, 2, "onRespFromServer bundle error:" + bundle);
            } catch (Throwable unused2) {
                QLog.e(TAG, 2, "print error");
            }
        }
    }
}
