package com.tencent.mobileqq.kandian.biz.common;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountConfigUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.base.utils.c;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.entity.n;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ReadInJoyHelper {

    /* renamed from: a, reason: collision with root package name */
    protected static boolean f239255a = true;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f239256b = false;

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f239257c = {"collectbox", "homepage", "messagebox_V3", "messagebox_pendant_V3", "commentpage", "recommend_friends", "accountpage", "topicvideo", "mytopic", "myhistory", "myfollow", "myfans", "mynotify"};

    /* renamed from: d, reason: collision with root package name */
    private static int f239258d = -1;

    /* renamed from: e, reason: collision with root package name */
    private static int f239259e = -1;

    /* renamed from: f, reason: collision with root package name */
    private static int f239260f = -1;

    /* renamed from: g, reason: collision with root package name */
    private static int f239261g = -1;

    /* renamed from: h, reason: collision with root package name */
    private static long f239262h = -1;

    /* renamed from: i, reason: collision with root package name */
    private static int f239263i = -1;

    /* renamed from: j, reason: collision with root package name */
    private static int f239264j = -1;

    /* renamed from: k, reason: collision with root package name */
    private static int f239265k = -1;

    /* renamed from: l, reason: collision with root package name */
    private static int f239266l = -1;

    /* renamed from: m, reason: collision with root package name */
    private static int f239267m = -1;

    /* renamed from: n, reason: collision with root package name */
    private static int f239268n = -1;

    /* renamed from: o, reason: collision with root package name */
    private static int f239269o = -1;

    /* renamed from: p, reason: collision with root package name */
    private static int f239270p = -1;

    /* renamed from: q, reason: collision with root package name */
    private static int f239271q = -1;

    /* renamed from: r, reason: collision with root package name */
    private static int f239272r = -1;

    /* renamed from: s, reason: collision with root package name */
    private static int f239273s = -1;

    /* renamed from: t, reason: collision with root package name */
    private static String f239274t = "try_stick_flag";

    /* renamed from: u, reason: collision with root package name */
    private static AtomicInteger f239275u = new AtomicInteger(0);

    /* renamed from: v, reason: collision with root package name */
    private static long f239276v = System.currentTimeMillis();

    /* renamed from: w, reason: collision with root package name */
    private static Map<String, Integer> f239277w = Collections.synchronizedMap(new HashMap());

    /* renamed from: x, reason: collision with root package name */
    private static Map<String, Boolean> f239278x = Collections.synchronizedMap(new HashMap());

    /* renamed from: y, reason: collision with root package name */
    private static boolean f239279y = false;

    /* renamed from: z, reason: collision with root package name */
    private static long f239280z = -1;
    private static long A = -1;
    private static int B = 0;
    private static int C = -1;

    public static int A(AppRuntime appRuntime) {
        int i3 = f239270p;
        if (i3 == 0 || i3 == 1) {
            return i3;
        }
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d(LogTag.TAG_READINJOY_TT_REPORT, 1, "getReadInjoyShareToWxAtSwitch() failed");
            return 0;
        }
        int i16 = b16.getInt("readinjoy_share_to_WX_at_switch", 0);
        f239270p = i16;
        return i16;
    }

    public static boolean B(AppRuntime appRuntime) {
        return true;
    }

    public static boolean C() {
        return f239256b;
    }

    public static void C0(QQAppInterface qQAppInterface, int i3, String str, int i16) {
        SharedPreferences.Editor edit = qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0).edit();
        edit.putInt("readinjoy_video_channel_info_channel_id", i3);
        edit.putString("readinjoy_video_channel_info_channel_name", str);
        edit.putInt("readinjoy_video_channel_info_channel_type", i16);
        edit.commit();
    }

    public static void G0(String str, QQAppInterface qQAppInterface) {
        boolean equals = "1".equals(str);
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0);
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean("readInJoy_subscribeAcc_gray_enable", equals);
        c.a(edit, true);
    }

    public static void H0(QQAppInterface qQAppInterface) {
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0);
        if (sharedPreferences == null) {
            f239255a = true;
            return;
        }
        f239255a = sharedPreferences.getBoolean("readInJoy_subscribeAcc_gray_enable", true);
        QLog.d("SPLASH_ConfigServlet", 1, "ReadinjoyFolderMerge config " + f239255a);
    }

    public static long I() {
        AppRuntime c16 = com.tencent.mobileqq.kandian.base.utils.b.c();
        if (c16 == null) {
            return -1L;
        }
        SharedPreferences b16 = c.b(c16, true, true);
        if (b16 == null) {
            QLog.d("ReadInJoyHelper", 1, "failed to  getVideoRealTimeLogDebug");
            return -1L;
        }
        return b16.getLong("readinjoy_video_real_time_debug_log", -1L);
    }

    public static boolean J(QQAppInterface qQAppInterface) {
        return qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0).getBoolean(AppConstants.Preferences.VIDEO_STRUCTMSG_PLAY_SWITCH, true);
    }

    public static void O0(QQAppInterface qQAppInterface, boolean z16) {
        SharedPreferences.Editor edit = qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0).edit();
        edit.putBoolean(AppConstants.Preferences.HOT_SHORTVIDEO_MULTI_VIDEO_SUPPORT, z16);
        edit.commit();
    }

    public static boolean R(int i3) {
        if (i3 != 124 && i3 != 125) {
            return false;
        }
        return true;
    }

    public static boolean S(AppInterface appInterface) {
        return f239255a;
    }

    public static boolean U(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
        if (runningAppProcesses == null) {
            return false;
        }
        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
        while (it.hasNext()) {
            String str = it.next().processName;
            if (str != null && str.endsWith(":readinjoy")) {
                return true;
            }
        }
        return false;
    }

    public static boolean V() {
        return W();
    }

    public static boolean W() {
        return false;
    }

    public static void Z0() {
        AppRuntime c16 = com.tencent.mobileqq.kandian.base.utils.b.c();
        if (c16 == null) {
            return;
        }
        SharedPreferences b16 = c.b(c16, true, true);
        if (b16 == null) {
            QLog.d("ReadInJoyHelper", 1, "failed to  updateVideoRealTimeLogDebug");
            return;
        }
        SharedPreferences.Editor edit = b16.edit();
        edit.putLong("readinjoy_video_real_time_debug_log", System.currentTimeMillis());
        c.a(edit, true);
    }

    public static void a1(QQAppInterface qQAppInterface, boolean z16) {
        SharedPreferences.Editor edit = qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0).edit();
        edit.putBoolean(AppConstants.Preferences.VIDEO_STRUCTMSG_PLAY_SWITCH, z16);
        edit.commit();
    }

    private static void b0(QQAppInterface qQAppInterface, Activity activity, Intent intent, int i3, DialogInterface.OnDismissListener onDismissListener) {
        BaseApplication.getContext().sendBroadcast(new Intent("notify_main_guide_clear"));
    }

    public static boolean c(final AppRuntime appRuntime) {
        int i3 = f239258d;
        if (i3 != -1) {
            return i3 == 1;
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper.1
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences b16 = c.b(AppRuntime.this, true, true);
                if (b16 == null) {
                    return;
                }
                ReadInJoyHelper.f239258d = b16.getBoolean("free_time_refresh_push", true) ? 1 : 0;
            }
        }, 8, null, true);
        return true;
    }

    public static void c0(String str, QQAppInterface qQAppInterface) {
        boolean equals = str.equals("1");
        SharedPreferences y16 = y(qQAppInterface, 1);
        if (y16 == null) {
            return;
        }
        SharedPreferences.Editor edit = y16.edit();
        edit.putBoolean("kandian_feeds", equals);
        c.a(edit, true);
    }

    public static boolean d(String str) {
        return true;
    }

    public static void d0(String str, QQAppInterface qQAppInterface) {
        boolean equals = str.equals("1");
        SharedPreferences y16 = y(qQAppInterface, 1);
        if (y16 == null) {
            return;
        }
        SharedPreferences.Editor edit = y16.edit();
        edit.putBoolean("merge_feeds", equals);
        c.a(edit, true);
    }

    public static boolean e(AppRuntime appRuntime) {
        Calendar calendar = Calendar.getInstance();
        int i3 = calendar.get(1);
        int i16 = calendar.get(2);
        int i17 = calendar.get(5);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        sb5.append(i16);
        sb5.append(i17);
        String sb6 = sb5.toString();
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_READINJOY_VIDEO, 1, "checkIsVideoFeedsGameAdComBarLocalConfigToday() failed");
            }
            return false;
        }
        String string = b16.getString("VIDEO_FEEDS_GAME_AD_COM_BAR_LOCAL_CONFIG_DATE", null);
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_READINJOY_TT_REPORT, 1, "checkIsVideoFeedsGameAdComBarLocalConfigToday localDate = " + string);
        }
        if (!TextUtils.isEmpty(sb6) && sb6.equals(string)) {
            return true;
        }
        SharedPreferences.Editor edit = b16.edit();
        edit.putString("VIDEO_FEEDS_GAME_AD_COM_BAR_LOCAL_CONFIG_DATE", sb6);
        c.a(edit, true);
        return false;
    }

    public static void e0(String str, QQAppInterface qQAppInterface) {
        boolean equals = str.equals("1");
        SharedPreferences y16 = y(qQAppInterface, 1);
        if (y16 == null) {
            return;
        }
        SharedPreferences.Editor edit = y16.edit();
        edit.putBoolean("share_to_news", equals);
        c.a(edit, true);
    }

    public static void f0(String str, QQAppInterface qQAppInterface) {
        boolean equals = str.equals("1");
        SharedPreferences y16 = y(qQAppInterface, 1);
        if (y16 == null) {
            return;
        }
        SharedPreferences.Editor edit = y16.edit();
        edit.putBoolean("synchronize_to_qzone", equals);
        c.a(edit, true);
    }

    public static boolean h(String str) {
        return false;
    }

    public static boolean i(String str) {
        for (String str2 : f239257c) {
            if (TextUtils.equals(str2, str)) {
                return true;
            }
        }
        return false;
    }

    public static void j(Activity activity, Intent intent, int i3, DialogInterface.OnDismissListener onDismissListener) {
        if (U(activity) && activity.getPackageName().equalsIgnoreCase("com.tencent.qqreadinjoy")) {
            intent.setClassName("com.tencent.qqreadinjoy", "com.tencent.qqreadinjoy.ReadInJoyStartActivity");
            activity.startActivityForResult(intent, -1);
        }
        b0(null, activity, intent, i3, onDismissListener);
    }

    public static void k0(int i3, int i16) {
        SharedPreferences b16;
        AppRuntime c16 = com.tencent.mobileqq.kandian.base.utils.b.c();
        if (c16 == null || (b16 = c.b(c16, true, true)) == null) {
            return;
        }
        SharedPreferences.Editor edit = b16.edit();
        edit.putInt("kandian_aio_msg_received_duration", i3);
        edit.putInt("kandian_aio_msg_send_duration", i16);
        c.a(edit, true);
        QLog.d("ReadInJoyHelper", 2, "update aio msg receive & send duration lastRecvMsgDuration : " + i3 + ", lastSendMsgDuration : " + i16);
    }

    public static Pair<Integer, Integer> l() {
        SharedPreferences b16 = c.b(com.tencent.mobileqq.kandian.base.utils.b.c(), true, true);
        if (b16 == null) {
            return new Pair<>(60, 60);
        }
        return new Pair<>(Integer.valueOf(b16.getInt("kandian_aio_msg_received_duration", 60)), Integer.valueOf(b16.getInt("kandian_aio_msg_send_duration", 60)));
    }

    public static Pair<Integer, Integer> o() {
        SharedPreferences b16 = c.b(com.tencent.mobileqq.kandian.base.utils.b.c(), true, true);
        if (b16 == null) {
            return null;
        }
        return new Pair<>(Integer.valueOf(b16.getInt("ExitAioIdleReportUinLimitS", -1)), Integer.valueOf(b16.getInt("ExitAioIdleReportUinLimitE", -1)));
    }

    public static void q0(int i3) {
        SharedPreferences b16;
        AppRuntime c16 = com.tencent.mobileqq.kandian.base.utils.b.c();
        if (c16 == null || (b16 = c.b(c16, true, true)) == null) {
            return;
        }
        SharedPreferences.Editor edit = b16.edit();
        edit.putInt("IdleExitAioRptCntForReport", i3);
        c.a(edit, true);
    }

    public static int s(AppRuntime appRuntime) {
        int i3 = C;
        if (i3 > 0) {
            return i3;
        }
        if (h("scroll_check_freq")) {
            QLog.d(LogTag.TAG_READINJOY_TT_REPORT, 1, "getKandianConfigAdExposureThreshold() using new threshold");
            C = u62.a.f438492u;
        } else {
            SharedPreferences b16 = c.b(appRuntime, true, true);
            if (b16 == null) {
                QLog.d(LogTag.TAG_READINJOY_TT_REPORT, 1, "getKandianConfigAdExposureThreshold() failed");
                return u62.a.f438491t;
            }
            C = b16.getInt("key_kandian_ad_exposure_threshold", u62.a.f438491t);
        }
        QLog.d(LogTag.TAG_READINJOY_TT_REPORT, 1, "getKandianConfigAdExposureThreshold() threshold = " + C);
        return C;
    }

    public static int u(QQAppInterface qQAppInterface) {
        n v3 = v(qQAppInterface);
        if (v3 == null) {
            return -1;
        }
        return v3.d() ? 1 : 0;
    }

    public static n v(QQAppInterface qQAppInterface) {
        ILebaHelperService iLebaHelperService = (ILebaHelperService) qQAppInterface.getRuntimeService(ILebaHelperService.class, "");
        if (iLebaHelperService == null) {
            QLog.d("ReadInJoyHelper", 1, "getKandianLebaViewItem lebaHelperService == null");
            return null;
        }
        List<n> lebaMgrList = iLebaHelperService.getLebaMgrList();
        if (lebaMgrList == null || lebaMgrList.isEmpty()) {
            iLebaHelperService.initLebaHelper();
            iLebaHelperService.reloadLebaItems(qQAppInterface);
            lebaMgrList = iLebaHelperService.getLebaMgrList();
        }
        if (lebaMgrList == null) {
            return null;
        }
        for (n nVar : lebaMgrList) {
            if (nVar != null && nVar.f240505b != null) {
                return nVar;
            }
        }
        return null;
    }

    public static int x(QQAppInterface qQAppInterface) {
        return qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0).getInt("readinjoy_video_channel_info_config_version" + qQAppInterface.getCurrentAccountUin(), -1);
    }

    public static void A0(QQAppInterface qQAppInterface, String str) {
        int i3;
        try {
            i3 = Integer.valueOf(str).intValue();
        } catch (Exception e16) {
            QLog.d("ReadInJoyHelper", 1, "updateReadInJoyFeedsGroupSetting failed " + e16.toString());
            i3 = 4;
        }
        SharedPreferences y16 = y(qQAppInterface, 1);
        if (y16 == null) {
            return;
        }
        SharedPreferences.Editor edit = y16.edit();
        edit.putInt("config_feeds_group_setting", i3);
        c.a(edit, true);
    }

    public static void B0(AppRuntime appRuntime, boolean z16) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d("ReadInJoyHelper", 1, "failed to update sp IndividualPushSwitch");
            return;
        }
        SharedPreferences.Editor edit = b16.edit();
        edit.putBoolean("readinjoy_individual_push_switch", z16);
        c.a(edit, true);
    }

    public static boolean D(AppRuntime appRuntime) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            return false;
        }
        return b16.getBoolean("qboss_splash_debug_switch", true);
    }

    public static void D0(QQAppInterface qQAppInterface, String str) {
        int i3;
        try {
            i3 = Integer.valueOf(str).intValue();
        } catch (Exception e16) {
            QLog.w("ReadInJoyHelper", 1, "updateReadInJoyPushMsgSwitch failed: " + e16.toString());
            i3 = 1;
        }
        SharedPreferences y16 = y(qQAppInterface, 1);
        if (y16 == null) {
            return;
        }
        SharedPreferences.Editor edit = y16.edit();
        edit.putInt("readinjoy_config_push_msg_switch", i3);
        c.a(edit, true);
    }

    public static int E(AppRuntime appRuntime) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d(LogTag.TAG_READINJOY_VIDEO, 1, "getVideoDynamicRecommendDurationLimit() failed");
            return -1;
        }
        int i3 = b16.getInt(PublicAccountConfigUtilImpl.CONFIG_VIDEO_DYNAMIC_RECOMMEND_DURATION_LIMIT, -1);
        QLog.d(LogTag.TAG_READINJOY_TT_REPORT, 1, "getVideoDynamicRecommendDurationLimit() result=" + i3);
        return i3;
    }

    public static void E0(QQAppInterface qQAppInterface, String str) {
        SharedPreferences y16 = y(qQAppInterface, 1);
        if (y16 == null) {
            return;
        }
        SharedPreferences.Editor edit = y16.edit();
        edit.putBoolean("config_smart_crop_pic_setting", "1".equals(str));
        c.a(edit, true);
    }

    public static float F(AppRuntime appRuntime) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d(LogTag.TAG_READINJOY_VIDEO, 1, "getVideoDynamicRecommendDurationPercent() failed");
            return -1.0f;
        }
        float f16 = b16.getFloat("video_dynamic_recommend_duration_rate", -1.0f);
        QLog.d(LogTag.TAG_READINJOY_TT_REPORT, 1, "getVideoDynamicRecommendDurationPercent() result=" + f16);
        return f16;
    }

    public static int G(AppRuntime appRuntime) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d(LogTag.TAG_READINJOY_VIDEO, 1, "getVideoDynamicRecommendOperator() failed");
            return -1;
        }
        int i3 = b16.getInt(PublicAccountConfigUtilImpl.CONFIG_VIDEO_DYNAMIC_RECOMMEND_OPERATOR, 0);
        QLog.d(LogTag.TAG_READINJOY_TT_REPORT, 1, "getVideoDynamicRecommendOperator() result=" + i3);
        return i3;
    }

    public static int H(AppRuntime appRuntime) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d(LogTag.TAG_READINJOY_VIDEO, 1, "getVideoDynamicRecommendStrategy() failed");
            return -1;
        }
        int i3 = b16.getInt(PublicAccountConfigUtilImpl.CONFIG_VIDEO_DYNAMIC_RECOMMEND_STRATEGY, -1);
        QLog.d(LogTag.TAG_READINJOY_TT_REPORT, 1, "getVideoDynamicRecommendStrategy() result=" + i3);
        return i3;
    }

    public static void I0(QQAppInterface qQAppInterface) {
        f239256b = false;
        QLog.d("SPLASH_ConfigServlet", 1, "ReadinjooyStopFunctionSwitch config:" + f239256b);
    }

    public static boolean K(AppRuntime appRuntime) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            return false;
        }
        return b16.getBoolean("readinjoy_viola_debug_switch", true);
    }

    public static void K0(AppRuntime appRuntime, String str, String str2) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d("ReadInJoyHelper", 1, "failed to update sp updateShowVideoToast");
            return;
        }
        SharedPreferences.Editor edit = b16.edit();
        edit.putString("readinjoy_self_fragment_feedback_" + str, str2);
        c.a(edit, true);
    }

    public static boolean L(AppRuntime appRuntime) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            return false;
        }
        return b16.getBoolean("READINJOY_VIOLA_JS_DEBUG_BUNDLE", false);
    }

    public static void L0(AppRuntime appRuntime, boolean z16) {
        String str;
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d("ReadInJoyHelper", 1, "failed to update sp updateShowRecommendReasonInTitle");
            return;
        }
        SharedPreferences.Editor edit = b16.edit();
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        edit.putString("readinjoy_show_recommend_reason_in_title_b", str);
        c.a(edit, true);
    }

    public static boolean M(AppRuntime appRuntime) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            return false;
        }
        return b16.getBoolean("READINJOY_VIOLA_JS_LOCAL_BUNDLE", false);
    }

    public static void M0(AppRuntime appRuntime, String str, String str2) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d("ReadInJoyHelper", 1, "failed to update sp updateShowVideoToast");
            return;
        }
        SharedPreferences.Editor edit = b16.edit();
        edit.putString("readinjoy_social_weburl_" + str, str2);
        c.a(edit, true);
    }

    public static boolean N(AppRuntime appRuntime) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            return false;
        }
        return b16.getBoolean("READINJOY_VIOLA_RECOMMEND_REASON", false);
    }

    public static void N0(AppRuntime appRuntime, boolean z16) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d("ReadInJoyHelper", 1, "failed to update sp updateViolaDebugSwitcher");
            return;
        }
        SharedPreferences.Editor edit = b16.edit();
        edit.putBoolean("qboss_splash_debug_switch", z16);
        c.a(edit, true);
    }

    public static boolean O(AppRuntime appRuntime) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d(LogTag.TAG_READINJOY_VIDEO, 1, "getWebRenderConfig() failed");
            return false;
        }
        boolean z16 = b16.getBoolean("web_native_render", false);
        QLog.d(LogTag.TAG_READINJOY_TT_REPORT, 1, "getWebRenderConfig() result=" + z16);
        return z16;
    }

    public static boolean P() {
        int intValue = ((Integer) c.c("readinjoy_video_is_download_async_io", 0)).intValue();
        if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyHelper", 1, "isDownloadAsyncIo,isDownloadAsyncIo:" + intValue);
        }
        return intValue == 1;
    }

    public static boolean Q() {
        int intValue = ((Integer) c.c("readinjoy_video_is_ff_probelist_switch", 0)).intValue();
        if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyHelper", 1, "isFFProbelistSwitch,isFFProbelistSwitch:" + intValue);
        }
        return intValue == 1;
    }

    public static void R0(AppRuntime appRuntime, int i3) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d(LogTag.TAG_READINJOY_VIDEO, 1, "updateVideoChannelCoverStyle() failed");
            return;
        }
        SharedPreferences.Editor edit = b16.edit();
        edit.putInt("video_channel_cover_style", i3);
        c.a(edit, true);
    }

    public static boolean T(AppRuntime appRuntime) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            return false;
        }
        return b16.getBoolean("readinjoy_video_enable_reprint_switch", false);
    }

    public static void T0(AppRuntime appRuntime, boolean z16) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d("ReadInJoyHelper", 1, "failed to update sp updateVideoColumnEntrySwitcher");
            return;
        }
        SharedPreferences.Editor edit = b16.edit();
        edit.putBoolean("readinjoy_viola_column_entry_switch", z16);
        c.a(edit, true);
    }

    public static void U0(AppRuntime appRuntime, float f16) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d(LogTag.TAG_READINJOY_VIDEO, 1, "updateVideoDynamicRecommendDurationPercent() failed");
            return;
        }
        QLog.d(LogTag.TAG_READINJOY_TT_REPORT, 1, "updateVideoDynamicRecommendDurationPercent() num=" + f16);
        SharedPreferences.Editor edit = b16.edit();
        edit.putFloat("video_dynamic_recommend_duration_rate", f16);
        c.a(edit, true);
    }

    public static void V0(AppRuntime appRuntime, int i3) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d(LogTag.TAG_READINJOY_VIDEO, 1, "updateVideoDynamicRecommendOperator() failed");
            return;
        }
        QLog.d(LogTag.TAG_READINJOY_TT_REPORT, 1, "updateVideoDynamicRecommendOperator() num=" + i3);
        SharedPreferences.Editor edit = b16.edit();
        edit.putInt(PublicAccountConfigUtilImpl.CONFIG_VIDEO_DYNAMIC_RECOMMEND_OPERATOR, i3);
        c.a(edit, true);
    }

    public static void W0(AppRuntime appRuntime, int i3) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d(LogTag.TAG_READINJOY_VIDEO, 1, "updateVideoDynamicRecommmendDurationLimit() failed");
            return;
        }
        QLog.d(LogTag.TAG_READINJOY_TT_REPORT, 1, "updateVideoDynamicRecommmendDurationLimit() num=" + i3);
        SharedPreferences.Editor edit = b16.edit();
        edit.putInt(PublicAccountConfigUtilImpl.CONFIG_VIDEO_DYNAMIC_RECOMMEND_DURATION_LIMIT, i3);
        c.a(edit, true);
    }

    public static boolean X(AppRuntime appRuntime) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            return false;
        }
        return "1".equals(b16.getString("readinjoy_show_recommend_reason_in_title_b", ""));
    }

    public static void X0(AppRuntime appRuntime, int i3) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d(LogTag.TAG_READINJOY_VIDEO, 1, "updateVideoDynamicRecommmendStrategy() failed");
            return;
        }
        QLog.d(LogTag.TAG_READINJOY_TT_REPORT, 1, "updateVideoDynamicRecommmendStrategy() num=" + i3);
        SharedPreferences.Editor edit = b16.edit();
        edit.putInt(PublicAccountConfigUtilImpl.CONFIG_VIDEO_DYNAMIC_RECOMMEND_STRATEGY, i3);
        c.a(edit, true);
    }

    public static boolean Y(AppRuntime appRuntime) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            return false;
        }
        return b16.getBoolean("readinjoy_viola_column_entry_switch", false);
    }

    public static void Y0(AppRuntime appRuntime, boolean z16) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d("ReadInJoyHelper", 1, "failed to update sp updateVideoMessageBoxSwitcher");
            return;
        }
        SharedPreferences.Editor edit = b16.edit();
        edit.putBoolean("readinjoy_viola_message_box_switch", z16);
        c.a(edit, true);
    }

    public static boolean Z(AppRuntime appRuntime) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            return false;
        }
        return b16.getBoolean("readinjoy_viola_message_box_switch", false);
    }

    public static void b1(AppRuntime appRuntime, boolean z16) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d("ReadInJoyHelper", 1, "failed to update sp updateViolaDebugSwitcher");
            return;
        }
        SharedPreferences.Editor edit = b16.edit();
        edit.putBoolean("readinjoy_viola_debug_switch", z16);
        c.a(edit, true);
    }

    public static void c1(AppRuntime appRuntime, int i3) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d(LogTag.TAG_READINJOY_VIDEO, 1, "updateViolaDiscoverConfig failed");
            return;
        }
        QLog.d(LogTag.TAG_READINJOY_TT_REPORT, 1, "updateViolaDiscoverConfig value=" + i3);
        SharedPreferences.Editor edit = b16.edit();
        edit.putBoolean("VIOLA_DYNAMIC_DISCOVER", i3 == 1);
        c.a(edit, true);
    }

    public static void d1(AppRuntime appRuntime, int i3) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d(LogTag.TAG_READINJOY_VIDEO, 1, "updateViolaDynamicConfig() failed");
            return;
        }
        QLog.d(LogTag.TAG_READINJOY_TT_REPORT, 1, "updateViolaDynamicConfig() value=" + i3);
        SharedPreferences.Editor edit = b16.edit();
        edit.putBoolean("VIOLA_DYNAMIC", i3 == 1);
        c.a(edit, true);
    }

    public static void e1(AppRuntime appRuntime, boolean z16) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d("ReadInJoyHelper", 1, "failed to update sp updateViolaDebugSwitcher");
            return;
        }
        SharedPreferences.Editor edit = b16.edit();
        edit.putBoolean("READINJOY_VIOLA_JS_DEBUG_BUNDLE", z16);
        c.a(edit, true);
    }

    public static String f(AppRuntime appRuntime) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d(LogTag.TAG_READINJOY_TT_REPORT, 1, "checkLastScanTTDate() failed");
            return null;
        }
        return b16.getString("KANDIAN_LAST_SCAN_TT_DATE", "");
    }

    public static void f1(AppRuntime appRuntime, boolean z16) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d("ReadInJoyHelper", 1, "failed to update sp updateViolaDebugSwitcher");
            return;
        }
        SharedPreferences.Editor edit = b16.edit();
        edit.putBoolean("READINJOY_VIOLA_JS_LOCAL_BUNDLE", z16);
        c.a(edit, true);
    }

    public static void g() {
        f239258d = -1;
        f239259e = -1;
        f239260f = -1;
        f239261g = -1;
        f239262h = -1L;
        f239263i = -1;
        f239264j = -1;
        f239266l = -1;
        f239265k = -1;
        f239273s = -1;
        f239272r = -1;
        f239269o = -1;
        C = -1;
    }

    public static void g1(AppRuntime appRuntime, int i3) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d(LogTag.TAG_READINJOY_VIDEO, 1, "updateViolaMessageBoxConfig failed");
            return;
        }
        QLog.d(LogTag.TAG_READINJOY_TT_REPORT, 1, "updateViolaMessageBoxConfig value=" + i3);
        SharedPreferences.Editor edit = b16.edit();
        edit.putBoolean("VIOLA_DYNAMIC_MESSAGE_BOX", i3 == 1);
        c.a(edit, true);
    }

    public static void h0(AppRuntime appRuntime, boolean z16) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d(LogTag.TAG_READINJOY_TT_REPORT, 1, "setKanDianReportTTSwitch() failed");
            return;
        }
        SharedPreferences.Editor edit = b16.edit();
        edit.putBoolean("KANDIAN_REPORT_TT_SWITCH", z16);
        c.a(edit, true);
    }

    public static void h1(AppRuntime appRuntime, boolean z16) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d("ReadInJoyHelper", 1, "failed to update sp updateViolaDebugSwitcher");
            return;
        }
        SharedPreferences.Editor edit = b16.edit();
        edit.putBoolean("READINJOY_VIOLA_RECOMMEND_REASON", z16);
        c.a(edit, true);
    }

    public static void i0(AppRuntime appRuntime, String str) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d(LogTag.TAG_READINJOY_TT_REPORT, 1, "setLastScanTTDate() failed");
            return;
        }
        SharedPreferences.Editor edit = b16.edit();
        edit.putString("KANDIAN_LAST_SCAN_TT_DATE", str);
        c.a(edit, true);
    }

    public static void i1(AppRuntime appRuntime, int i3) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d(LogTag.TAG_READINJOY_VIDEO, 1, "updateViolaWeishiAdConfig failed");
            return;
        }
        QLog.d(LogTag.TAG_READINJOY_TT_REPORT, 1, "updateViolaWeishiAdConfig value=" + i3);
        SharedPreferences.Editor edit = b16.edit();
        edit.putBoolean("VIOLA_DYNAMIC_WEISHI", i3 == 1);
        c.a(edit, true);
    }

    public static void j1(AppRuntime appRuntime, int i3) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d(LogTag.TAG_READINJOY_VIDEO, 1, "updateWebRenderConfig() failed");
            return;
        }
        QLog.d(LogTag.TAG_READINJOY_TT_REPORT, 1, "updateWebRenderConfig() value=" + i3);
        SharedPreferences.Editor edit = b16.edit();
        edit.putBoolean("web_native_render", i3 == 1);
        c.a(edit, true);
    }

    public static void k1(AppRuntime appRuntime, int i3) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d(LogTag.TAG_READINJOY_VIDEO, 1, "updateWebRenderModeConfig() failed");
            return;
        }
        QLog.d(LogTag.TAG_READINJOY_TT_REPORT, 1, "updateWebRenderModeConfig() value=" + i3);
        SharedPreferences.Editor edit = b16.edit();
        edit.putBoolean("web_native_render_mode_start", i3 == 1);
        c.a(edit, true);
    }

    public static void l1(AppRuntime appRuntime, String str) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d("ReadInJoyHelper", 1, "failed to update sp updateArkChannelConfig");
            return;
        }
        if (str == null) {
            str = "";
        }
        SharedPreferences.Editor edit = b16.edit();
        edit.putString("readinjoy_ark_channel_config", str);
        c.a(edit, true);
    }

    public static int m(AppRuntime appRuntime) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d(LogTag.TAG_READINJOY_VIDEO, 1, "getVideoFeedsAdConfigLocal() failed");
            return 60;
        }
        int i3 = b16.getInt("camera_capture_max_duration", 60);
        QLog.d(LogTag.TAG_READINJOY_VIDEO, 1, "getCameraCaptureMaxDuration() result=" + i3);
        return i3;
    }

    public static boolean n(AppRuntime appRuntime) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d(LogTag.TAG_READINJOY_VIDEO, 1, "getCanLoadStartWebRenderModeConfig() failed");
            return false;
        }
        boolean z16 = b16.getBoolean("web_native_render_mode_start", false);
        QLog.d(LogTag.TAG_READINJOY_TT_REPORT, 1, "getCanLoadStartWebRenderModeConfig() result=" + z16);
        return z16;
    }

    public static void n0(AppRuntime appRuntime, boolean z16) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d("ReadInJoyHelper", 1, "failed to update sp updateShowVideoToast");
            return;
        }
        SharedPreferences.Editor edit = b16.edit();
        edit.putBoolean("free_time_refresh_push", z16);
        c.a(edit, true);
        f239258d = z16 ? 1 : 0;
    }

    public static void o0(AppRuntime appRuntime, String str) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 != null && !TextUtils.isEmpty(str)) {
            QLog.d("ReadInJoyHelper", 1, "updateGallerySubChannelHidden() value" + str);
            try {
                int parseInt = Integer.parseInt(str);
                SharedPreferences.Editor edit = b16.edit();
                edit.putInt("gallery_sub_channel_hidden", parseInt);
                c.a(edit, true);
                return;
            } catch (Exception unused) {
                QLog.d("ReadInJoyHelper", 1, "updateGallerySubChannelHidden() Exception");
                return;
            }
        }
        QLog.d("ReadInJoyHelper", 1, "updateGallerySubChannelHidden() failed");
    }

    public static void p0(AppRuntime appRuntime, String str) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 != null && !TextUtils.isEmpty(str)) {
            QLog.d("ReadInJoyHelper", 1, "updateGallerySubChannelWaterFallHidden() value" + str);
            try {
                int parseInt = Integer.parseInt(str);
                SharedPreferences.Editor edit = b16.edit();
                edit.putInt("gallery_sub_channel_waterfall_hidden", parseInt);
                c.a(edit, true);
                return;
            } catch (Exception unused) {
                QLog.d("ReadInJoyHelper", 1, "updateGallerySubChannelWaterFallHidden() Exception");
                return;
            }
        }
        QLog.d("ReadInJoyHelper", 1, "updateGallerySubChannelWaterFallHidden() failed");
    }

    public static boolean q(AppRuntime appRuntime) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            return false;
        }
        return b16.getBoolean("readinjoy_video_videoinfo_switch", false);
    }

    public static boolean r(AppRuntime appRuntime) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d(LogTag.TAG_READINJOY_TT_REPORT, 1, "getKanDianReportTTSwitch() failed");
            return false;
        }
        return b16.getBoolean("KANDIAN_REPORT_TT_SWITCH", false);
    }

    public static void r0(AppRuntime appRuntime, boolean z16) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d("ReadInJoyHelper", 1, "failed to update sp updateInnerVideoInfoShowSwitcher");
            return;
        }
        SharedPreferences.Editor edit = b16.edit();
        edit.putBoolean("readinjoy_video_videoinfo_switch", z16);
        c.a(edit, true);
    }

    public static void s0(AppRuntime appRuntime, String str) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d(LogTag.TAG_READINJOY_TT_REPORT, 1, "updateKandianConfigDefaultBitRate() failed");
            return;
        }
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt <= 0) {
                QLog.d(LogTag.TAG_READINJOY_TT_REPORT, 1, "updateKandianConfigDefaultBitRate() bitrate <= 0");
                return;
            }
            SharedPreferences.Editor edit = b16.edit();
            edit.putInt("kandian_default_bit_rate", parseInt);
            c.a(edit, true);
            f239272r = parseInt;
        } catch (Exception unused) {
            QLog.d(LogTag.TAG_READINJOY_TT_REPORT, 1, "updateKandianConfigDefaultBitRate() parseInt failed");
        }
    }

    public static int t(AppRuntime appRuntime) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d(LogTag.TAG_READINJOY_TT_REPORT, 1, "getKandianConfigBadgeSwitch() failed");
            return -1;
        }
        int i3 = f239273s;
        if (i3 != -1) {
            return i3;
        }
        int i16 = b16.getInt("kandian_badge_switch", 0);
        f239273s = i16;
        return i16;
    }

    public static void t0(AppRuntime appRuntime, int i3) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d(LogTag.TAG_READINJOY_TT_REPORT, 1, "updateKandianConfigRedShowNum() failed");
            return;
        }
        SharedPreferences.Editor edit = b16.edit();
        edit.putInt("kandian_tabdot_show_num", i3);
        c.a(edit, true);
        f239259e = i3;
    }

    public static void u0(AppRuntime appRuntime, int i3) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d(LogTag.TAG_READINJOY_TT_REPORT, 1, "updateKandianConfigRedThreshold() failed");
            return;
        }
        SharedPreferences.Editor edit = b16.edit();
        edit.putInt("kandian_tabdot_threshold", i3);
        c.a(edit, true);
        f239260f = i3;
    }

    public static boolean v0(AppRuntime appRuntime, String str) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null || str == null) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyHelper", 2, "updateKandianMyTabPage, value = ", str);
        }
        SharedPreferences.Editor edit = b16.edit();
        edit.putString("kandian_my_tab_page", str);
        c.a(edit, true);
        return true;
    }

    public static long w(AppRuntime appRuntime) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            return 10L;
        }
        return b16.getLong("msg_info_pulse_report_z", 10L);
    }

    public static void w0(AppRuntime appRuntime, boolean z16) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d(LogTag.TAG_READINJOY_VIDEO, 1, "failed to update sp KandianVideoSocialSwitch");
            return;
        }
        SharedPreferences.Editor edit = b16.edit();
        edit.putBoolean("kandian_video_social_switch", z16);
        c.a(edit, true);
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_READINJOY_VIDEO, 2, "updateKandianVideoSocialSwitch():" + z16);
        }
    }

    public static void y0(AppRuntime appRuntime, boolean z16) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d("ReadInJoyHelper", 1, "failed to update sp READINJOY_SIMPLE_SWITCH_FM");
            return;
        }
        SharedPreferences.Editor edit = b16.edit();
        edit.putBoolean("READINJOY_SIMPLE_SWITCH_FM", z16);
        c.a(edit, true);
    }

    public static int z(AppRuntime appRuntime) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d("ReadInJoyHelper", 2, "updateReadInJoyWeiShiJumpTarget: sp == null");
            return 0;
        }
        return b16.getInt("SP_KEY_WEISHI_JUMP_TARGET", 0);
    }

    public static void z0(AppRuntime appRuntime, boolean z16) {
        SharedPreferences b16 = c.b(appRuntime, true, true);
        if (b16 == null) {
            QLog.d("ReadInJoyHelper", 1, "failed to update sp updateVideoColumnEntrySwitcher");
            return;
        }
        SharedPreferences.Editor edit = b16.edit();
        edit.putBoolean("readinjoy_video_enable_reprint_switch", z16);
        c.a(edit, true);
    }

    public static void F0(AppRuntime appRuntime, int i3) {
        SharedPreferences b16 = c.b(appRuntime, true, false);
        if (b16 == null) {
            QLog.d("ReadInJoyHelper", 1, "updateReadInJoyVideoJumpDefaultValue failed to update sp");
            return;
        }
        SharedPreferences.Editor edit = b16.edit();
        edit.putInt("readinjoy_video_jump_default_value", i3);
        c.a(edit, true);
    }

    public static void J0(AppRuntime appRuntime, boolean z16) {
        SharedPreferences b16 = c.b(appRuntime, true, false);
        if (b16 == null) {
            QLog.d("ReadInJoyHelper", 1, "failed to update sp subscribe list push config ");
            return;
        }
        SharedPreferences.Editor edit = b16.edit();
        edit.putBoolean("readinjoy_subscribe_list_push", z16);
        c.a(edit, true);
    }

    public static void P0(AppRuntime appRuntime, int i3) {
        SharedPreferences b16 = c.b(appRuntime, true, false);
        if (b16 == null) {
            QLog.d("ReadInJoyHelper", 1, "updateVideoChannelAutoPlaySwitchDefaultValue failed to update sp");
            return;
        }
        SharedPreferences.Editor edit = b16.edit();
        edit.putInt("video_channel_auto_play_switch", i3);
        c.a(edit, true);
    }

    public static void Q0(AppRuntime appRuntime, int i3) {
        SharedPreferences b16 = c.b(appRuntime, true, false);
        if (b16 == null) {
            QLog.d("ReadInJoyHelper", 1, "updateVideoChannelAutoPlaySwitchDefaultValueVideoFlow failed to update sp");
            return;
        }
        SharedPreferences.Editor edit = b16.edit();
        edit.putInt("video_channel_auto_play_switch_video_flow", i3);
        c.a(edit, true);
    }

    public static void S0(AppRuntime appRuntime, int i3) {
        SharedPreferences b16 = c.b(appRuntime, true, false);
        if (b16 == null) {
            QLog.d("ReadInJoyHelper", 1, "updateVideoChannelFeedsClickSwitchValue failed to update sp");
            return;
        }
        SharedPreferences.Editor edit = b16.edit();
        edit.putInt("key_video_channel_feeds_click_switch", i3);
        c.a(edit, true);
    }

    public static void a0(QQAppInterface qQAppInterface, Activity activity, Intent intent) {
        b0(qQAppInterface, activity, intent, -1, null);
    }

    public static void m0(AppRuntime appRuntime, int i3) {
        SharedPreferences b16 = c.b(appRuntime, true, false);
        if (b16 == null) {
            QLog.d("ReadInJoyHelper", 1, "updateCUKingCardDlgSwitch failed to update sp");
            return;
        }
        SharedPreferences.Editor edit = b16.edit();
        edit.putInt("CUKingCard_dlg_enable_switch", i3);
        c.a(edit, true);
    }

    public static long p() {
        long longValue = ((Long) c.c("readinjoy_video_ff_probesize", 0L)).longValue();
        if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyHelper", 1, "getFFProbesize,probesize:" + longValue);
        }
        return longValue;
    }

    public static String k(int i3) {
        if (i3 <= 99) {
            return String.valueOf(i3);
        }
        return "99+";
    }

    public static boolean l0(AppRuntime appRuntime, String str) {
        if (str == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            l1(appRuntime, str);
            String optString = jSONObject.optString("app");
            String optString2 = jSONObject.optString("ver", null);
            HashMap<String, String> hashMap = new HashMap<>();
            if (TextUtils.isEmpty(optString)) {
                hashMap.put("action", "configOff");
            } else {
                hashMap.put("action", "configOn");
                hashMap.put("appname", optString);
                hashMap.put("appver", optString2);
            }
            StatisticCollector.getInstance(appRuntime.getApplication()).collectPerformance(null, "actionReadInJoyArkConfig", true, 0L, 0L, hashMap, null);
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyHelper", 2, "parse json error ", e16);
            }
            return false;
        }
    }

    public static void x0(AppRuntime appRuntime, long j3, long j16, long j17) {
        SharedPreferences b16;
        if (appRuntime == null || (b16 = c.b(appRuntime, true, true)) == null) {
            return;
        }
        SharedPreferences.Editor edit = b16.edit();
        edit.putLong("msg_info_pulse_report_x", j3);
        edit.putLong("msg_info_pulse_report_y", j16);
        edit.putLong("msg_info_pulse_report_z", j17);
        c.a(edit, true);
        QLog.d("ReadInJoyHelper", 2, "update msg info pulse param x : " + j3 + ", y : " + j16 + ", z : " + j17);
    }

    @Deprecated
    public static SharedPreferences y(QQAppInterface qQAppInterface, int i3) {
        if (qQAppInterface == null || i3 == 2) {
            return null;
        }
        return BaseApplicationImpl.getApplication().getSharedPreferences(String.format("readinjoy_%s_%d", qQAppInterface.getAccount(), Integer.valueOf(i3)), i3 == 0 ? 4 : 0);
    }

    public static void j0() {
    }

    public static void b(JSONObject jSONObject) {
    }

    public static void g0(QQAppInterface qQAppInterface, int i3, long j3, int i16, int i17) {
    }
}
