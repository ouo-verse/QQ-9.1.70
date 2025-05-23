package cooperation.qwallet.plugin;

import android.content.Intent;
import com.qwallet.pay.s;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppService;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QWalletToolService extends AppService {
    public static final String TAG = "Q.qwallet.pay.QWalletPluginService";

    @Override // mqq.app.AppService, android.app.Service
    public void onCreate() {
        super.onCreate();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onCreate@" + hashCode());
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onDestroy@" + hashCode());
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onStartCommand@" + hashCode() + " flags:" + i3 + " startId:" + i16);
        }
        if ((i3 & 1) != 0) {
            return 2;
        }
        s.e().i(this, intent);
        return 2;
    }
}
