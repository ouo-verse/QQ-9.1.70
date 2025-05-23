package com.tencent.biz.qqcircle.utils;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qcircle.api.impl.QCircleABTestApiImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public static final List<String> f92775a;

    /* renamed from: b, reason: collision with root package name */
    public static final List<String> f92776b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f92777c;

    /* renamed from: d, reason: collision with root package name */
    private static volatile IQCircleABTestApi f92778d;

    static {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        f92775a = copyOnWriteArrayList;
        f92776b = new CopyOnWriteArrayList();
        copyOnWriteArrayList.add("exp_comment_ai_recommend");
        copyOnWriteArrayList.add("exp_xsj_video_play_rate_gesture_new");
        copyOnWriteArrayList.add("exp_fullscreen_share");
        copyOnWriteArrayList.add("exp_icon");
        copyOnWriteArrayList.add("exp_comment2");
        copyOnWriteArrayList.add("exp_tapshareandhold");
        copyOnWriteArrayList.add("exp_sharebuttondifferent");
        copyOnWriteArrayList.add("exp_likepocketboard");
        copyOnWriteArrayList.add("exp_xsj_share_feed_auto_scroll_down_guidance");
    }

    protected static IQCircleABTestApi a() {
        if (f92778d == null) {
            synchronized (IQCircleABTestApi.class) {
                if (f92778d == null) {
                    f92778d = new QCircleABTestApiImpl();
                }
            }
        }
        return f92778d;
    }

    public static String b(String str) {
        IQCircleABTestApi a16 = a();
        if (a16 == null) {
            return null;
        }
        return a16.getAssignment(str);
    }

    public static Map<String, String> c(String str) {
        IQCircleABTestApi a16 = a();
        if (a16 == null) {
            return null;
        }
        return a16.getParams(str);
    }

    public static boolean d(String str) {
        IQCircleABTestApi a16 = a();
        if (a16 == null) {
            return false;
        }
        if (a16.isExperiment(str)) {
            return true;
        }
        a16.isContrast(str);
        return false;
    }

    public static boolean e(String str) {
        Map<String, String> c16 = c(str);
        if (c16 != null && !c16.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean f(String str, String str2) {
        IQCircleABTestApi a16 = a();
        if (a16 != null && a16.isExpHit(str, str2)) {
            return true;
        }
        return false;
    }

    public static boolean g() {
        return false;
    }

    public static boolean h(String str, long j3) {
        try {
            String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(str, "");
            if (TextUtils.isEmpty(loadAsString)) {
                return false;
            }
            RFWLog.d("QCircleABTestUtils", RFWLog.USR, "isTimeHitConfigTime " + loadAsString);
            String[] split = loadAsString.split("\\|");
            int length = split.length;
            for (int i3 = 0; i3 < length; i3++) {
                String str2 = split[i3];
                if (str2 != null) {
                    String[] split2 = str2.split(",");
                    if (split2.length == 2 && j3 > Long.parseLong(split2[0]) * 1000 && j3 < Long.parseLong(split2[1]) * 1000) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e16) {
            RFWLog.d("QCircleABTestUtils", RFWLog.USR, "isTimeHitConfigTime error:" + e16);
            return false;
        }
    }

    public static void i(String str) {
        IQCircleABTestApi a16 = a();
        if (a16 == null) {
            return;
        }
        a16.reportExpExposure(str);
    }

    public static void j() {
        if (!f92777c) {
            f92777c = true;
        }
    }

    public static void k() {
        f92777c = false;
    }
}
