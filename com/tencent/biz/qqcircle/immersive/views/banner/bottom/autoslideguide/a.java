package com.tencent.biz.qqcircle.immersive.views.banner.bottom.autoslideguide;

import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import uq3.c;
import uq3.k;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f90600a;

    public static String a() {
        return f90600a;
    }

    public static boolean b(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, String str) {
        boolean E6 = c.E6();
        boolean d56 = c.d5();
        boolean c16 = k.a().c("key_has_show_auto_slide_guide", false);
        QLog.d("QFSAutoSlideGuideUtils", 1, "isEnableAutoSlide:" + d56 + " isShowSwitch:" + E6 + " pos:" + i3 + " hasShowGuide:" + c16);
        if (c16 || d56 || !E6 || i3 < 10 || i3 > 14 || !"pg_xsj_explore_page".equals(str)) {
            return false;
        }
        return true;
    }

    public static void c(String str) {
        if (f90600a == null) {
            QLog.d("QFSAutoSlideGuideUtils", 1, "set first feed id: " + str);
            f90600a = str;
        }
    }

    public static void d(boolean z16) {
        k.a().j("key_has_show_auto_slide_guide", z16);
        QLog.i("QFSAutoSlideGuideUtils", 1, "[setHasShowedAutoSlideGuideView] = " + z16);
    }
}
