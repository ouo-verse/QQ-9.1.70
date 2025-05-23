package com.tencent.biz.qqcircle.utils;

import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;

/* compiled from: P */
/* loaded from: classes5.dex */
public class cj {
    public static boolean a(long j3) {
        if (j3 != 10022 && j3 != 10023 && j3 != 10028) {
            return true;
        }
        return false;
    }

    public static void b(boolean z16, long j3, String str) {
        c(z16, j3, str, 0, QCircleToast.f91644d);
    }

    public static void c(boolean z16, long j3, String str, int i3, int i16) {
        d(z16, j3, str, i3, i16, true);
    }

    public static void d(boolean z16, long j3, String str, int i3, int i16, boolean z17) {
        if (!QCirclePluginUtil.isAppOnForeground() || !QCirclePluginUtil.isInQCircleNew()) {
            return;
        }
        if (uq3.l.b().a(j3)) {
            QCircleToast.l(i16, str, i3, false, z17);
        } else if (!z16 && a(j3)) {
            QCircleToast.l(i16, str, i3, false, z17);
        }
    }
}
