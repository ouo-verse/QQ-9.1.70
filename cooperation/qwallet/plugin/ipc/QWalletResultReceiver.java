package cooperation.qwallet.plugin.ipc;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QWalletResultReceiver extends ResultReceiver {
    private static Handler handler;
    private static QWalletResultReceiver instance;

    public QWalletResultReceiver(Handler handler2) {
        super(handler2);
    }

    public static void clear() {
        instance = null;
        handler = null;
    }

    public static QWalletResultReceiver getInstance() {
        if (instance == null) {
            if (Looper.myLooper() != null) {
                handler = new Handler(Looper.myLooper());
            }
            instance = new QWalletResultReceiver(handler);
        }
        return instance;
    }

    @Override // android.os.ResultReceiver
    protected void onReceiveResult(int i3, Bundle bundle) {
        super.onReceiveResult(i3, bundle);
        BaseReq req = BaseReq.getReq(bundle);
        if (req != null) {
            req.onReceive();
        }
    }
}
