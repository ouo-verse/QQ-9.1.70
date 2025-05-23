package ho;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.qzone.app.QZoneFeedAlertService;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.ak;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.reborn.base.QZoneShellActivity;
import com.qzone.reborn.feedpro.fragment.QzoneFeedProUserHomeFragment;
import com.qzone.reborn.feedx.fragment.QZoneFeedxFamousUserHomeFragment;
import com.qzone.reborn.feedx.fragment.QZoneFeedxUserHomeFragment;
import com.qzone.reborn.route.QZoneUserHomeBean;
import com.qzone.util.aq;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qroute.route.Navigator;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.QZoneLoginReportHelper;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes38.dex */
public class j implements a {
    private static boolean d(Context context, long j3) {
        long j16;
        boolean z16;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            Intent intent = activity.getIntent();
            Serializable serializableExtra = intent != null ? intent.getSerializableExtra("qzone_route_bean") : null;
            if (serializableExtra instanceof QZoneUserHomeBean) {
                QZoneUserHomeBean qZoneUserHomeBean = (QZoneUserHomeBean) serializableExtra;
                z16 = qZoneUserHomeBean.getLoginFrom() == 2;
                j16 = qZoneUserHomeBean.getUin();
                if (z16 || j3 != j16) {
                    return false;
                }
                QLog.d("QZoneUserHomeNativeLauncher", 1, "launchPersonalPage, isFromProfile, finish page, uin=" + j3);
                activity.finish();
                return true;
            }
        }
        j16 = 0;
        z16 = false;
        if (z16) {
        }
        return false;
    }

    protected String b(x6.a aVar, long j3, String str, boolean z16) {
        String str2;
        if (TextUtils.isEmpty(str) || aVar == null) {
            return str;
        }
        String replace = str.replace("{from_uin}", String.valueOf(j3)).replace("{uin}", String.valueOf(aVar.uin)).replace("{brand_flag}", String.valueOf(aVar.brandFlag));
        if (z16) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        return replace.replace("{is_famous_space}", str2);
    }

    public Intent c(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) QZoneShellActivity.class);
        long k3 = ef.d.k(str);
        QZoneUserHomeBean qZoneUserHomeBean = new QZoneUserHomeBean();
        String name = QZoneFeedxUserHomeFragment.class.getName();
        if (com.qzone.reborn.feedpro.utils.d.f54318a.b()) {
            name = QzoneFeedProUserHomeFragment.class.getName();
        }
        intent.putExtra("public_fragment_class", name);
        intent.putExtra("qqid", k3);
        intent.putExtra("qzone_route_bean", qZoneUserHomeBean);
        if (context instanceof Application) {
            intent.addFlags(268435456);
        }
        return intent;
    }

    public void f(Context context, long j3) {
        QZoneUserHomeBean qZoneUserHomeBean = new QZoneUserHomeBean();
        qZoneUserHomeBean.setUin(j3);
        qZoneUserHomeBean.setFamousSpace(true);
        g(context, qZoneUserHomeBean);
    }

    public void g(Context context, QZoneUserHomeBean qZoneUserHomeBean) {
        if (context != null && qZoneUserHomeBean != null && qZoneUserHomeBean.getUin() != 0) {
            RFWLog.d("QZoneUserHomeNativeLauncher", 1, "launchUserHome, uin: " + qZoneUserHomeBean.getUin() + ", context: " + context);
            jo.h.f410717a.h("page_launch_user_home").t("LAUNCH_CLICK");
            i.d(context, "/qzone/holder_page").withString("public_fragment_class", QZoneFeedxFamousUserHomeFragment.class.getName()).withLong("qqid", qZoneUserHomeBean.getUin()).withSerializable("qzone_route_bean", qZoneUserHomeBean).withLong(PerfTracer.PARAM_CLICK_TIME, System.currentTimeMillis()).request();
            return;
        }
        RFWLog.fatal("QZoneUserHomeNativeLauncher", 1, new RuntimeException("openUserHome fail: " + context));
    }

    public void h(Context context) {
        i.q(context, "https://h5.qzone.qq.com/vpage/admin?_proxy=1&clicktime=" + System.currentTimeMillis() + "&_wv=1");
    }

    public void i(Context context) {
        i.q(context, "https://h5.qzone.qq.com/v2/vip/hz/actMsgSet");
    }

    public void j(Context context, long j3) {
        i.q(context, "https://h5.qzone.qq.com/qzone/follow/{uin}/fans?_wv=1027&_proxy=1&loginuin={login_uin}".replace("{uin}", String.valueOf(j3)).replace("{login_uin}", LoginData.getInstance().getUinString()));
    }

    public void k(Context context, long j3) {
        String str = j3 + "";
        com.tencent.mobileqq.dt.api.b c16 = com.qzone.feed.utils.f.c();
        c16.i("10061");
        c16.n(str);
        c16.v("pid:{pid}|cid:{cid}|qzone_appid:{qzone_appid}|own_uin:{own_uin}".replace("{own_uin}", str).replace("{pid}", "0").replace("{cid}", "null").replace("{qzone_appid}", String.valueOf(1)));
        com.qzone.feed.utils.f.a(context, c16);
    }

    public void l(Context context, long j3) {
        String replace = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_MSG_LIST_URL, QzoneConfig.DefaultValue.MSG_LIST_URL).replace("{uin}", String.valueOf(j3));
        String str = Build.MANUFACTURER;
        String j16 = yo.f.j(replace, "{manu}", str);
        if (!j16.contains("manu")) {
            j16 = j16 + "&manu=" + str;
        }
        i.q(context, j16);
    }

    public void m(Context context, long j3) {
        QZoneUserHomeBean qZoneUserHomeBean = new QZoneUserHomeBean();
        qZoneUserHomeBean.setUin(j3);
        n(context, qZoneUserHomeBean);
    }

    public void p(Context context, long j3, int i3) {
        try {
            int i16 = 0;
            RFWLog.d("QZoneUserHomeNativeLauncher", 1, "launchProfilePage, uin: " + j3 + ", profileEntryType: " + i3);
            if (j3 != LoginData.getInstance().getUin()) {
                i16 = aq.b(j3) ? 60 : 61;
            }
            AllInOne allInOne = new AllInOne(String.valueOf(j3), i16);
            allInOne.profileEntryType = i3;
            ProfileUtils.openProfileCard(context, allInOne);
        } catch (Throwable th5) {
            QZLog.e("QZoneUserHomeNativeLauncher", "jump to qq profile card failed!", th5);
        }
    }

    public void r(Context context, long j3) {
        QZoneUserHomeBean qZoneUserHomeBean = new QZoneUserHomeBean();
        qZoneUserHomeBean.setUin(j3);
        t(context, qZoneUserHomeBean);
    }

    public void t(Context context, QZoneUserHomeBean qZoneUserHomeBean) {
        if (context != null && qZoneUserHomeBean != null && qZoneUserHomeBean.getUin() != 0) {
            if (lg.a.f414452a.b(qZoneUserHomeBean)) {
                g(context, qZoneUserHomeBean);
                RFWLog.d("QZoneUserHomeNativeLauncher", 1, "launchFamousUserHome, uin: " + qZoneUserHomeBean.getUin() + ", context: " + context);
                return;
            }
            a(context, qZoneUserHomeBean);
            return;
        }
        RFWLog.fatal("QZoneUserHomeNativeLauncher", 1, new RuntimeException("openUserHome fail: " + context));
    }

    public void u(Context context) {
        yo.d.d(QZoneConfigHelper.E0(), context, null);
    }

    public void v(Context context, long j3) {
        if (y6.b.f(j3)) {
            yo.d.d(yo.f.b(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_USERHOME_FRIEND_SETTING, "https://h5.qzone.qq.com/friend/setting/{UIN}/friendsetting?_wv=3&hostuin={HOST_UIN}&qua={qua}&_proxy=1").replace("{UIN}", String.valueOf(j3)).replace("{HOST_UIN}", LoginData.getInstance().getUinString()), "isFromQZone", "1"), context, null);
            LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_HOMEPAGE_GUEST, 1, 0);
        } else {
            yo.d.d(yo.f.w(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_QZONE_SETTING_MAIN_PAGE, QzoneConfig.DefaultValue.DEFAULT_QZONE_SETTING_MAIN_PAGE), LoginData.getInstance().getUin()), context, null);
            LpReportInfo_pf00064.allReport(308, 9, 15);
        }
    }

    public void w(Activity activity, long j3) {
        vo.c.T(activity, j3, "QzHomePageNavigationBar");
        ClickReport.e(1, "getMainPage", 308, 13, 11);
    }

    public void x(Context context, long j3) {
        i.q(context, "https://h5.qzone.qq.com/qzone/visitor/{uin}?uin={login_uin}&hostuin={host_uin}&_proxy=1&_wv=3".replace("{uin}", String.valueOf(j3)).replace("{host_uin}", String.valueOf(j3)).replace("{login_uin}", LoginData.getInstance().getUinString()));
        QZoneFeedAlertService.getInstance().clearSingleUnreadCount(3);
    }

    private void a(Context context, QZoneUserHomeBean qZoneUserHomeBean) {
        RFWLog.d("QZoneUserHomeNativeLauncher", 1, "launchUserHome, uin: " + qZoneUserHomeBean.getUin() + ", context: " + context);
        jo.h.f410717a.h("page_launch_user_home").t("LAUNCH_CLICK");
        String name = QZoneFeedxUserHomeFragment.class.getName();
        if (com.qzone.reborn.feedpro.utils.d.f54318a.b()) {
            name = QzoneFeedProUserHomeFragment.class.getName();
        }
        Navigator withLong = i.d(context, "/qzone/holder_page").withString("public_fragment_class", name).withLong("qqid", qZoneUserHomeBean.getUin()).withSerializable("qzone_route_bean", qZoneUserHomeBean).withLong(PerfTracer.PARAM_CLICK_TIME, System.currentTimeMillis());
        if (qZoneUserHomeBean.getLoginFrom() > 0) {
            Intent intent = new Intent();
            QZoneLoginReportHelper.addLoginInfo(intent, qZoneUserHomeBean.getLoginFrom());
            if (intent.getExtras() != null) {
                withLong.withAll(intent.getExtras());
            }
        }
        withLong.request();
    }

    public void o(Context context, long j3) {
        p(context, j3, 7);
    }

    public void e(Context context, x6.a aVar) {
        String i3;
        if (aVar == null) {
            return;
        }
        String config = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_USERHOME_DYNAMIC_SETTING_URL, "https://h5.qzone.qq.com/specialcare/setting?_wv=3&uin={uin}&hostuin={hostuin}&isstar={isstar}");
        if (TextUtils.isEmpty(config)) {
            return;
        }
        String i16 = yo.f.i(yo.f.i(config, "{uin}", LoginData.getInstance().getUin()), "{hostuin}", aVar.uin);
        if (aVar.isStarSpaceUser()) {
            i3 = yo.f.i(i16, "{isstar}", 1L);
        } else {
            i3 = yo.f.i(i16, "{isstar}", 0L);
        }
        i.q(context, i3);
    }

    public void n(Context context, QZoneUserHomeBean qZoneUserHomeBean) {
        if (context != null && qZoneUserHomeBean != null) {
            long uin = qZoneUserHomeBean.getUin();
            if (com.qzone.reborn.feedpro.utils.d.f54318a.b()) {
                if (d(context, uin)) {
                    return;
                }
                o(context, uin);
                return;
            }
            com.qzone.reborn.util.k kVar = com.qzone.reborn.util.k.f59549a;
            if (kVar.c() && !kVar.g()) {
                p(context, uin, 7);
                return;
            } else if (lg.a.f414452a.b(qZoneUserHomeBean)) {
                g(context, qZoneUserHomeBean);
                return;
            } else {
                t(context, qZoneUserHomeBean);
                return;
            }
        }
        RFWLog.fatal("QZoneUserHomeNativeLauncher", 1, new RuntimeException("launchPersonalPage fail: " + context));
    }

    public void s(Context context, User user) {
        if (context != null && user != null) {
            if (lg.a.f414452a.a(user)) {
                f(context, user.uin);
                return;
            } else {
                r(context, user.uin);
                return;
            }
        }
        RFWLog.fatal("QZoneUserHomeNativeLauncher", 1, new RuntimeException("launchPersonalPage fail: " + context));
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void q(Context context, x6.a aVar, boolean z16) {
        String str;
        String str2;
        if (aVar == null) {
            return;
        }
        String str3 = aVar.uin + "";
        String str4 = aVar.qzoneName;
        String str5 = aVar.nickName;
        String str6 = aVar.spaceDesc;
        String str7 = aVar.share_bg_url;
        if (TextUtils.isEmpty(str7)) {
            str7 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_USERHOME_MORE_MENU_SHARE_BACKGROUND_URL, "https://qzonestyle.gtimg.cn/aoi/sola/20170808105528_mupoTSBZ1C.png");
        }
        String str8 = str7;
        ImageLoader.getInstance().loadImage(str8, (ImageLoader.ImageLoadListener) null, (ImageLoader.Options) null);
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "WhoseQzone", "\u7684\u7a7a\u95f4");
        String config2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "Fans", "\u7c89\u4e1d");
        String config3 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "Visitor", "\u8bbf\u5ba2");
        String config4 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ComeToFollowMe", "\u5927\u5bb6\u5feb\u6765\u5173\u6ce8\u6211\u5427");
        long j3 = aVar.fansCount;
        int i3 = aVar.visitorCount;
        if (TextUtils.isEmpty(str4)) {
            str4 = str5 + config;
        }
        String str9 = str4;
        String str10 = config2 + j3 + config3 + i3;
        if (j3 <= 0 && i3 > 0.0d) {
            str2 = config3 + i3;
        } else if (j3 > 0 && i3 <= 0.0d) {
            str2 = config2 + j3;
        } else {
            str = (j3 > 0 || ((double) i3) > 0.0d) ? str10 : config4;
            long j16 = aVar.uin;
            String str11 = str;
            String b16 = b(aVar, j16, QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_JUMPQZONE, QzoneConfig.SECONDARY_FAMOUS_HOME_SHARE_QRCODE, "https://mp.qzone.qq.com/u/{uin}?uin={uin}&is_famous_space={is_famous_space}&brand_flag={brand_flag}"), z16);
            String replace = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_JUMPQZONE, QzoneConfig.SECONDARY_FAMOUS_HOME_SHARE_FACE_URL, "https://q.qlogo.cn/openurl/{uin}/{uin}/100?rf=qz_hybrid&c={base62}&_offline=1&max_age=19830212").replace("{uin}", String.valueOf(aVar.uin)).replace("{base62}", com.tencent.mobileqq.util.h.c().a("qz_hybrid@" + aVar.uin));
            String b17 = b(aVar, j16, QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_FAMOUS_HOME_SHARE_H5, "https://mp.qzone.qq.com/u/{uin}?uin={uin}&is_famous_space={is_famous_space}&brand_flag={brand_flag}"), z16);
            if (QZLog.isColorLevel()) {
                QZLog.d("QzoneHomePage", 2, "shareToFriends, shareUin=" + str3 + ", title=" + str9 + ", detailUrl=" + b17);
            }
            Intent N = ak.N(context);
            N.putExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_UIN, str3);
            N.putExtra("title", str9);
            N.putExtra("summary", str11);
            N.putExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, str5);
            N.putExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_DESCPTION, str6);
            N.putExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_FANS_COUNT, j3);
            N.putExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_VISITOR_COUNT, i3);
            N.putExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_THUMB_PHOTO_URL, replace);
            N.putExtra("detail_url", b17);
            N.putExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_H5_DETAIL_URL, b17);
            N.putExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_BACKGROUND_URL, str8);
            N.putExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_QRCODE_URL, b16);
            N.putExtra("brand_flag", aVar.brandFlag);
            N.putExtra("cmd", QZoneJsConstants.METHOD_FAMOUST_SHOW_DIALOG);
            if (context == null) {
                context.startActivity(N);
                return;
            }
            return;
        }
        str = str2;
        long j162 = aVar.uin;
        String str112 = str;
        String b162 = b(aVar, j162, QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_JUMPQZONE, QzoneConfig.SECONDARY_FAMOUS_HOME_SHARE_QRCODE, "https://mp.qzone.qq.com/u/{uin}?uin={uin}&is_famous_space={is_famous_space}&brand_flag={brand_flag}"), z16);
        String replace2 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_JUMPQZONE, QzoneConfig.SECONDARY_FAMOUS_HOME_SHARE_FACE_URL, "https://q.qlogo.cn/openurl/{uin}/{uin}/100?rf=qz_hybrid&c={base62}&_offline=1&max_age=19830212").replace("{uin}", String.valueOf(aVar.uin)).replace("{base62}", com.tencent.mobileqq.util.h.c().a("qz_hybrid@" + aVar.uin));
        String b172 = b(aVar, j162, QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_FAMOUS_HOME_SHARE_H5, "https://mp.qzone.qq.com/u/{uin}?uin={uin}&is_famous_space={is_famous_space}&brand_flag={brand_flag}"), z16);
        if (QZLog.isColorLevel()) {
        }
        Intent N2 = ak.N(context);
        N2.putExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_UIN, str3);
        N2.putExtra("title", str9);
        N2.putExtra("summary", str112);
        N2.putExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, str5);
        N2.putExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_DESCPTION, str6);
        N2.putExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_FANS_COUNT, j3);
        N2.putExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_VISITOR_COUNT, i3);
        N2.putExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_THUMB_PHOTO_URL, replace2);
        N2.putExtra("detail_url", b172);
        N2.putExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_H5_DETAIL_URL, b172);
        N2.putExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_BACKGROUND_URL, str8);
        N2.putExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_QRCODE_URL, b162);
        N2.putExtra("brand_flag", aVar.brandFlag);
        N2.putExtra("cmd", QZoneJsConstants.METHOD_FAMOUST_SHOW_DIALOG);
        if (context == null) {
        }
    }
}
