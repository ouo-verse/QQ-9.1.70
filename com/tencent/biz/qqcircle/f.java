package com.tencent.biz.qqcircle;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSMuteSwitchChangeEvent;
import com.tencent.biz.richframework.download.RFWDownloadStrategy;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.engineer.test.api.RFWTestMock;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.QCircleConfig;
import feedcloud.FeedCloudWrite$PushBoxBasic;
import feedcloud.FeedCloudWrite$PushBoxBasicDrawInfo;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleFeedBase$StBusiInfoData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class f {

    /* renamed from: c, reason: collision with root package name */
    private static volatile f f84417c = null;

    /* renamed from: d, reason: collision with root package name */
    public static String f84418d = "sp_qqcirlce_business";

    /* renamed from: e, reason: collision with root package name */
    public static String f84419e = "tab_busi_info_data";

    /* renamed from: f, reason: collision with root package name */
    public static String f84420f = "qcircle_auth_tip_action_url";

    /* renamed from: g, reason: collision with root package name */
    public static String f84421g = "qcircle_is_authenticated";

    /* renamed from: h, reason: collision with root package name */
    public static String f84422h = "qcircle_medal_guide_bubble_status";

    /* renamed from: i, reason: collision with root package name */
    public static String f84423i = "key_qcircle_publish_incentive_promote_toast_flag";

    /* renamed from: j, reason: collision with root package name */
    public static String f84424j = "qcircle_publish_qcircle_tab_guide_flag";

    /* renamed from: k, reason: collision with root package name */
    public static String f84425k = "qcircle_mix_feed_main_page_show_tips";

    /* renamed from: l, reason: collision with root package name */
    public static String f84426l = "qcircle_diff_push_effect_last_show_tip_version";

    /* renamed from: m, reason: collision with root package name */
    public static String f84427m = "qcircle_rec_expt_info";

    /* renamed from: n, reason: collision with root package name */
    public static String f84428n = "qcircle_rec_expt_info_rsp";

    /* renamed from: o, reason: collision with root package name */
    public static String f84429o = "qcircle_comment_is_first_do_dislike";

    /* renamed from: p, reason: collision with root package name */
    public static String f84430p = "qcircle_publish_animation_lasttime";

    /* renamed from: q, reason: collision with root package name */
    public static String f84431q = "qcircle_publish_animation_count";

    /* renamed from: a, reason: collision with root package name */
    private String f84432a;

    /* renamed from: b, reason: collision with root package name */
    private Boolean f84433b;

    f() {
    }

    public static SharedPreferences C() {
        return uq3.g.b(D(), true, false, false);
    }

    public static String D() {
        return f84418d + HostDataTransUtils.getAccount();
    }

    public static String E() {
        return uq3.k.b().h(f84427m, null);
    }

    public static String F() {
        return uq3.k.b().h(f84428n, null);
    }

    public static boolean G(String str, boolean z16) {
        SharedPreferences I = I();
        if (I == null) {
            return z16;
        }
        return I.getBoolean(str, z16);
    }

    public static String H() {
        return uq3.c.b1("qqcircle", "qqcircle_server_error_toast_text", "\u7f51\u7edc\u5f00\u5c0f\u5dee\u4e86\uff0c\u7a0d\u540e\u518d\u8bd5\u8bd5\u5427");
    }

    public static SharedPreferences I() {
        return uq3.g.a("QCIRCLE_PLUGIN_SHARE", false, false);
    }

    public static int J() {
        return uq3.k.a().e("sp_key_template_carousel_index", 0);
    }

    public static boolean L() {
        return uq3.k.a().c(uq3.f.f439806a, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void M() {
        QCircleConfig.getInstance().preloadSplash();
    }

    public static void O() {
        QLog.d("QCirclePluginConfig", 4, "release");
        f84417c = new f();
    }

    public static void W(String str) {
        uq3.k.b().p(f84427m, str);
    }

    public static void X(String str) {
        uq3.k.b().p(f84428n, str);
    }

    public static void Z(boolean z16) {
        uq3.k.b().j("qfs_enable_auto_trigger_float_window", z16);
    }

    public static void a0(boolean z16) {
        uq3.k.b().j("sp_key_is_open_default_mute", z16);
        tb0.a.f435779d.c(z16);
        SimpleEventBus.getInstance().dispatchEvent(new QFSMuteSwitchChangeEvent(z16));
    }

    public static void b0() {
        uq3.k.a().j(uq3.f.f439806a, false);
    }

    public static boolean c() {
        boolean c16 = uq3.k.b().c("qfs_enable_auto_trigger_float_window", true);
        QLog.d("QCirclePluginConfig", 1, "enableAutoTriggerFloatWindow:" + c16);
        return c16;
    }

    public static boolean d() {
        return uq3.c.b1("qqcircle", "qqcircle_enable_decorate_manager_key", "1").equals("1");
    }

    public static boolean e() {
        return uq3.k.b().c("sp_key_is_open_default_mute", false);
    }

    public static void e0(int i3) {
        uq3.k.a().m("sp_key_template_carousel_index", i3);
    }

    public static boolean f() {
        return uq3.c.b1("qqcircle", "qqcircle_video_automuted_switch_show", "1").equals("1");
    }

    public static boolean g() {
        return uq3.c.b1("qqcircle", "qqcircle_enable_personal_recycle_view_trans_dispatch_event", "1").equals("1");
    }

    public static void g0(String str, boolean z16) {
        SharedPreferences I = I();
        if (I == null) {
            return;
        }
        SharedPreferences.Editor edit = I.edit();
        edit.putBoolean(str, z16);
        edit.apply();
    }

    public static boolean h() {
        return uq3.c.b1("qqcircle", "secondary_key_tag_hotest_tab_name_enable", "0").equals("0");
    }

    public static boolean i() {
        return uq3.c.b1("qqcircle", "secondary_key_poly_tag_preload_enable", "1").equals("1");
    }

    public static boolean j() {
        return uq3.c.b1("qqcircle", "qqcircle_enable_preload_req_add_listener_together", "1").equals("1");
    }

    public static boolean k() {
        return uq3.c.b1("qqcircle", "qqcircle_enable_show_comment_keyboard_emoj", "0").equals("1");
    }

    public static int n() {
        return uq3.c.X0("qqcircle", "qcircle_comment_first_expand_count", 3).intValue();
    }

    public static String o() {
        return uq3.c.b1("qqcircle", "qqcircle_recommend_emotion_list", "277,63,2,182,66,13,5,76,4,6,12,175,282,318,317,49,67,64,1,9,10,39,107,271,78,272,174,36,30");
    }

    public static int p() {
        return uq3.c.X0("qqcircle", "qcircle_comment_next_expand_count", 10).intValue();
    }

    public static RFWDownloadStrategy r() {
        return vq3.a.a();
    }

    public static String s() {
        return uq3.c.b1("qqcircle", "qqcircle_local_default_tab_type_order", "1,8,6");
    }

    public static f v() {
        if (f84417c == null) {
            synchronized (f.class) {
                if (f84417c == null) {
                    f84417c = new f();
                }
            }
        }
        return f84417c;
    }

    public static String x() {
        return uq3.c.b1("qqcircle", "qqcircle_mainpage_avatar_decorate_selection_url", "https://m.xsj.qq.com/h5/avatar-pendant/index?_wv=3&_wwv=1");
    }

    public int A() {
        return C().getInt(f84431q, 0);
    }

    public String B() {
        return C().getString(f84430p, "");
    }

    public boolean K() {
        Boolean bool = this.f84433b;
        if (bool != null) {
            return bool.booleanValue();
        }
        SharedPreferences C = C();
        if (C != null) {
            Boolean valueOf = Boolean.valueOf(C.getBoolean(f84429o, true));
            this.f84433b = valueOf;
            return valueOf.booleanValue();
        }
        return false;
    }

    public void N() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.e
            @Override // java.lang.Runnable
            public final void run() {
                f.M();
            }
        });
    }

    public void P(String str) {
        SharedPreferences C = C();
        if (C != null && str != null) {
            C.edit().putString(f84420f, str).apply();
        }
    }

    public void Q(String str) {
        this.f84432a = str;
        SharedPreferences C = C();
        if (C != null) {
            C.edit().putString(f84426l, this.f84432a).apply();
        }
    }

    public void R(int i3) {
        QCircleConfig.getInstance().saveFuleCount(i3);
    }

    public void S(String str) {
        C().edit().putBoolean(f84423i + str, true).apply();
    }

    public void T(int i3) {
        SharedPreferences C = C();
        if (C != null) {
            C.edit().putInt(f84421g + "_" + HostDataTransUtils.getAccount(), i3).apply();
        }
    }

    public void U(int i3) {
        SharedPreferences C = C();
        if (C != null) {
            C.edit().putInt(f84422h + "_" + HostDataTransUtils.getAccount(), i3).apply();
        }
    }

    public void V(String str) {
        SharedPreferences C = C();
        C.edit().putString(f84430p, str).apply();
        SharedPreferences.Editor edit = C.edit();
        String str2 = f84431q;
        edit.putInt(str2, C.getInt(str2, 0) + 1).apply();
    }

    public void Y(byte[] bArr) {
        SharedPreferences C = C();
        if (C != null) {
            C.edit().putString(f84419e, new String(Base64.encode(bArr, 0))).apply();
        }
    }

    public void b(List<FeedCloudWrite$PushBoxBasic> list) {
        if (list == null) {
            return;
        }
        int t16 = v().t();
        Iterator<FeedCloudWrite$PushBoxBasic> it = list.iterator();
        while (it.hasNext()) {
            List<FeedCloudWrite$PushBoxBasicDrawInfo> list2 = it.next().drawBoxInfo.get();
            if (list2 != null) {
                for (FeedCloudWrite$PushBoxBasicDrawInfo feedCloudWrite$PushBoxBasicDrawInfo : list2) {
                    if (feedCloudWrite$PushBoxBasicDrawInfo != null) {
                        t16 = (int) (t16 + feedCloudWrite$PushBoxBasicDrawInfo.count.get());
                    }
                }
            }
        }
        v().R(t16);
    }

    public void c0(boolean z16) {
        this.f84433b = Boolean.valueOf(z16);
        SharedPreferences C = C();
        if (C != null) {
            C.edit().putBoolean(f84429o, z16).apply();
        }
    }

    public void d0() {
        SharedPreferences C = C();
        if (C != null) {
            C.edit().putBoolean(f84425k, false).apply();
        }
    }

    public boolean f0() {
        SharedPreferences C = C();
        if (C == null) {
            return true;
        }
        return C.getBoolean(f84425k, true);
    }

    public String l() {
        SharedPreferences C = C();
        if (C == null) {
            return "";
        }
        return C.getString(f84420f, "");
    }

    public QQCircleFeedBase$StBusiInfoData m() {
        SharedPreferences C = C();
        if (C != null) {
            try {
                String string = C.getString(f84419e, "");
                if (!TextUtils.isEmpty(string)) {
                    byte[] decode = Base64.decode(string.getBytes(), 0);
                    QQCircleFeedBase$StBusiInfoData qQCircleFeedBase$StBusiInfoData = new QQCircleFeedBase$StBusiInfoData();
                    qQCircleFeedBase$StBusiInfoData.mergeFrom(decode);
                    QLog.d("QCirclePluginConfig", 2, "getBusiInfoData() success!");
                    return qQCircleFeedBase$StBusiInfoData;
                }
            } catch (Exception e16) {
                QLog.e("QCirclePluginConfig", 1, "getBusiInfoData() Exception:", e16.toString());
                return null;
            } catch (OutOfMemoryError e17) {
                QLog.e("QCirclePluginConfig", 1, "getBusiInfoData() OOM:", e17.toString());
            }
        }
        return null;
    }

    public String q() {
        if (this.f84432a == null) {
            this.f84432a = C().getString(f84426l, "");
        }
        return this.f84432a;
    }

    @RFWTestMock(id = "QFS_PUSH_COUNT")
    public int t() {
        return QCircleConfig.getInstance().getFuleCount();
    }

    public boolean u(String str) {
        return C().getBoolean(f84423i + str, false);
    }

    public int w() {
        SharedPreferences C = C();
        if (C == null) {
            return 0;
        }
        return C.getInt(f84421g + "_" + HostDataTransUtils.getAccount(), 0);
    }

    public int y() {
        SharedPreferences C = C();
        if (C == null) {
            return 0;
        }
        return C.getInt(f84422h + "_" + HostDataTransUtils.getAccount(), 0);
    }

    public boolean z() {
        if (com.tencent.qcircle.cooperation.config.debug.c.g()) {
            return true;
        }
        return QCircleConfig.getInstance().getNeedShowSplash();
    }
}
