package cooperation.qzone;

import android.text.TextUtils;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QZoneMMKVMigrateTask implements Runnable {
    public static final String MIGRATE_FLAG = "_migrate_flag_";
    private static final String TAG = "LocalMultiProcConfig_QZoneMMKVMigrateTask";
    private final String mMmkvFileName;
    private final int mOldSpMode;
    private final String mOldSpName;

    public QZoneMMKVMigrateTask(String str, int i3, String str2) {
        this.mOldSpName = str;
        this.mOldSpMode = i3;
        this.mMmkvFileName = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (TextUtils.isEmpty(this.mOldSpName)) {
            return;
        }
        QLog.d(TAG, 1, "QZoneMMKVMigrateTask start migrate :" + this.mOldSpName + " to " + this.mMmkvFileName);
        QMMKV.migrateToSpAdapter(MobileQQ.sMobileQQ, this.mOldSpName, this.mOldSpMode, this.mMmkvFileName);
        QMMKV.fromSpAdapter(MobileQQ.sMobileQQ, this.mOldSpName, this.mMmkvFileName).edit().putBoolean("_migrate_flag_", true).apply();
        QLog.d(TAG, 1, "QZoneMMKVMigrateTask migrate succeed " + this.mOldSpName + " to " + this.mMmkvFileName);
    }
}
