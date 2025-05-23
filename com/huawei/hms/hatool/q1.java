package com.huawei.hms.hatool;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.UserManager;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* compiled from: P */
/* loaded from: classes2.dex */
public class q1 {

    /* renamed from: c, reason: collision with root package name */
    private static q1 f37202c = new q1();

    /* renamed from: a, reason: collision with root package name */
    private boolean f37203a = false;

    /* renamed from: b, reason: collision with root package name */
    private Context f37204b = q0.i();

    q1() {
    }

    public static q1 b() {
        return f37202c;
    }

    @TargetApi(24)
    public boolean a() {
        boolean z16;
        if (!this.f37203a) {
            Context context = this.f37204b;
            if (context == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                UserManager userManager = (UserManager) context.getSystemService(QCircleAlphaUserReporter.KEY_USER);
                if (userManager != null) {
                    z16 = userManager.isUserUnlocked();
                } else {
                    this.f37203a = false;
                }
            } else {
                z16 = true;
            }
            this.f37203a = z16;
        }
        return this.f37203a;
    }
}
