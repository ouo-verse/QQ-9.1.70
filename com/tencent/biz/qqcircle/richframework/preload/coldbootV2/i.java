package com.tencent.biz.qqcircle.richframework.preload.coldbootV2;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.utils.l;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f91988a;

    public static boolean a() {
        d();
        return b("exp_qfs_eevee_fluency_9_0_60_B");
    }

    private static boolean b(String str) {
        if (l.g()) {
            return true;
        }
        return TextUtils.equals(((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).getAssignment("exp_qfs_eevee_fluency_9_0_60"), str);
    }

    public static void c() {
        f91988a = false;
    }

    public static void d() {
        if (!f91988a) {
            ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).reportExpExposure("exp_qfs_eevee_fluency_9_0_60");
            f91988a = true;
        }
    }
}
