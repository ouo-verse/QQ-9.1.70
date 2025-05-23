package com.tencent.qcircle.cooperation.config;

import android.app.Application;
import android.os.Build;
import android.os.UserManager;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import uq3.j;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QFSMMKVMigrateTask implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    private final String f342438d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f342439e;

    public QFSMMKVMigrateTask(String str, boolean z16) {
        this.f342438d = str;
        this.f342439e = z16;
    }

    @Override // java.lang.Runnable
    public void run() {
        Application application;
        boolean isUserUnlocked;
        if (TextUtils.isEmpty(this.f342438d) || (application = RFWApplication.getApplication()) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            isUserUnlocked = ((UserManager) application.getSystemService(QCircleAlphaUserReporter.KEY_USER)).isUserUnlocked();
            if (!isUserUnlocked) {
                QLog.e("QFSMMKVMigrateTask", 1, "[run] is not user unlocked, return");
                return;
            }
        }
        j.e(application, this.f342438d, this.f342439e);
    }
}
