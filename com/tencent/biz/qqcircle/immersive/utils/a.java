package com.tencent.biz.qqcircle.immersive.utils;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.cq;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {
    public static boolean a() {
        return com.tencent.biz.qqcircle.utils.k.g("exp_guess_search_feed_item_optimize", "exp_guess_search_feed_item_optimize_B");
    }

    public static boolean b() {
        return com.tencent.biz.qqcircle.utils.k.g("exp_xsj_reconstruction_of_the_continuous_viewing_experience_for_feed_element", "exp_xsj_reconstruction_of_the_continuous_viewing_experience_for_feed_element_B");
    }

    public static boolean c() {
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch() || bz.o() || !com.tencent.biz.qqcircle.utils.k.h("exp_xsj_share_to_short_video_mutual_connection_users") || uq3.o.Y1("qqcircle_diable_share_to_mutual_follow", false)) {
            return false;
        }
        return true;
    }

    public static boolean d() {
        boolean o16 = bz.o();
        QLog.d("QFSABTestConfigUtils", 1, "[isFullScreenShare] isLandscape =" + o16);
        if (o16 && e()) {
            return true;
        }
        return false;
    }

    public static boolean e() {
        if (!uq3.o.M0()) {
            return false;
        }
        return com.tencent.biz.qqcircle.utils.l.d("exp_fullscreen_share");
    }

    public static boolean f(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, t40.a aVar) {
        if (i3 != 0 || feedCloudMeta$StFeed == null || !cq.f92752a.s(feedCloudMeta$StFeed) || aVar == null || aVar.getInitBean() == null || aVar.getInitBean().getExtraTypeInfo() == null || aVar.getInitBean().getExtraTypeInfo().sourceType != 90) {
            return false;
        }
        return true;
    }

    public static boolean g() {
        return true;
    }

    public static boolean h(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("#")) {
            return true;
        }
        return false;
    }
}
