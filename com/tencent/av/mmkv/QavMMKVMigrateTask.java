package com.tencent.av.mmkv;

import android.text.TextUtils;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QavMMKVMigrateTask implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    private final String f73843d;

    /* renamed from: e, reason: collision with root package name */
    private final String f73844e;

    public QavMMKVMigrateTask(String str, int i3, String str2) {
        this.f73843d = str;
        this.f73844e = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (TextUtils.isEmpty(this.f73843d)) {
            return;
        }
        QLog.d("LocalMultiProcConfig_QavMMKVMigrateTask", 1, "QavMMKVMigrateTask start migrate :" + this.f73843d + " to " + this.f73844e);
        QMMKV.migrateToSpAdapter(MobileQQ.sMobileQQ, this.f73843d, 0, this.f73844e);
        QMMKV.fromSpAdapter(MobileQQ.sMobileQQ, this.f73843d, this.f73844e).edit().putBoolean("_qav_migrate_flag_", true).apply();
        QLog.d("LocalMultiProcConfig_QavMMKVMigrateTask", 1, "QavMMKVMigrateTask migrate succeed " + this.f73843d + " to " + this.f73844e);
    }
}
