package com.tencent.biz.qqcircle.drawer;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f84404a = false;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f84405b;

    public static ColorDrawable a(Context context) {
        if (context == null) {
            return null;
        }
        return new ColorDrawable(QFSQUIUtilsKt.c(context, R.color.qui_common_fill_standard_secondary, 0.5f));
    }

    private static boolean b() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_show_drawer_9060_two_gray", true)) {
            QLog.e("QFSDrawerUtils", 1, "[initDrawerExp] united config not enable show drawer");
            return false;
        }
        QLog.e("QFSDrawerUtils", 1, "[initDrawerExp], isHitExp:true");
        return true;
    }

    public static boolean c() {
        if (!f84404a) {
            synchronized (i.class) {
                if (!f84404a) {
                    f84405b = b();
                    f84404a = true;
                }
            }
        }
        return f84405b;
    }

    public static void d() {
        f84404a = false;
        f84405b = false;
    }
}
