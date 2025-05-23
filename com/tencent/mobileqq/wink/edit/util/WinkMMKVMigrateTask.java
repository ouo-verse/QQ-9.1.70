package com.tencent.mobileqq.wink.edit.util;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.wink.b;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkMMKVMigrateTask implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    private final String f318492d;

    public WinkMMKVMigrateTask(String str) {
        this.f318492d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (TextUtils.isEmpty(this.f318492d)) {
            return;
        }
        QMMKV.migrateToSpAdapter(b.c(), this.f318492d, QMMKVFile.FILE_QCIRCLE);
        QMMKV.fromSpAdapter(b.c(), this.f318492d, QMMKVFile.FILE_QCIRCLE).edit().putBoolean("sp_has_migrate_" + this.f318492d, true).apply();
        w53.b.f("AECameraPrefsUtil", "WinkMMKVMigrateTask execute success, spname:" + this.f318492d);
    }
}
