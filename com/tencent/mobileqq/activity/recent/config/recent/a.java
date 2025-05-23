package com.tencent.mobileqq.activity.recent.config.recent;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.IFeatureServiceProxy;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Boolean f185369a;

    public static void a(RecentBaseData recentBaseData) {
        if (recentBaseData != null && MobileQQ.sMobileQQ != null && d() && recentBaseData.mExtraInfoColor == -881592) {
            recentBaseData.mExtraInfoColor = MobileQQ.sMobileQQ.getResources().getColor(R.color.qui_common_feedback_error);
        }
    }

    public static void b(RecentBaseData recentBaseData) {
        if (recentBaseData != null && MobileQQ.sMobileQQ != null && d()) {
            recentBaseData.mExtraInfoColor = MobileQQ.sMobileQQ.getResources().getColor(R.color.qui_common_feedback_error);
        }
    }

    public static void c(RecentBaseData recentBaseData) {
        if (recentBaseData != null && d()) {
            recentBaseData.mMsgExtroInfo = "";
            recentBaseData.mExtraInfoColor = 0;
        }
    }

    public static boolean d() {
        Boolean bool = f185369a;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(((IFeatureServiceProxy) QRoute.api(IFeatureServiceProxy.class)).isFeatureSwitchOn("is_recent_highlight_opt_enabled", false));
        f185369a = valueOf;
        return valueOf.booleanValue();
    }
}
