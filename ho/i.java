package ho;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.publish.ui.activity.QZonePublishMoodRealActivity;
import com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity;
import com.qzone.reborn.albumx.qzonex.activity.QZonePublishXMoodRealActivity;
import com.qzone.reborn.base.QZoneCommonUploadActivity;
import com.qzone.reborn.base.QZoneShellActivity;
import com.qzone.reborn.base.QZoneShellInQZoneProcessActivity;
import com.qzone.reborn.base.QZoneTransparentShellActivity;
import com.qzone.reborn.comment.activity.QZoneCommentPanelActivity;
import com.qzone.reborn.feedpro.activity.QzoneFriendFeedProActivity;
import com.qzone.reborn.feedx.activity.QZoneFriendFeedXActivity;
import com.qzone.reborn.qzmoment.activity.QZMShellFolderActivity;
import com.qzone.reborn.route.QZoneSchemeBean;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.Navigator;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.report.QZonePushReporter;
import cooperation.qzone.report.lp.QZoneLoginReportHelper;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes38.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f405433a = false;

    /* renamed from: b, reason: collision with root package name */
    private static final Map<Class<? extends a>, a> f405434b;

    /* renamed from: c, reason: collision with root package name */
    private static final Map<String, b> f405435c;

    static {
        HashMap hashMap = new HashMap();
        f405434b = hashMap;
        hashMap.put(jn.b.class, new jn.b());
        hashMap.put(j.class, new j());
        hashMap.put(d.class, new d());
        hashMap.put(l.class, new l());
        hashMap.put(k.class, new k());
        hashMap.put(rk.e.class, new rk.e());
        hashMap.put(ck.c.class, new ck.c());
        hashMap.put(ck.a.class, new ck.a());
        hashMap.put(ad.a.class, new ad.a());
        hashMap.put(ad.b.class, new ad.b());
        hashMap.put(fl.a.class, new fl.a());
        hashMap.put(e.class, new e());
        hashMap.put(ka.a.class, new ka.a());
        hashMap.put(oi.b.class, new oi.b());
        hashMap.put(vb.b.class, new vb.b());
        hashMap.put(c.class, new c());
        hashMap.put(bo.b.class, new bo.b());
        hashMap.put(m.class, new m());
        hashMap.put(n.class, new n());
        hashMap.put(ie.a.class, new ie.a());
        HashMap hashMap2 = new HashMap();
        f405435c = hashMap2;
        hashMap2.put("moment", new jn.c());
        hashMap2.put("intimate", new ck.d());
        hashMap2.put(QCircleScheme.Q_CIRCLE_ACTION_OPEN_QQPUBLISH, new tm.a());
        hashMap2.put("groupalbum", new oi.d());
        hashMap2.put("moodlist", new f());
        hashMap2.put("passivityfeed", new wm.a());
        hashMap2.put("specialfriend", new wm.b());
        hashMap2.put("album", new ka.b());
        hashMap2.put(QZoneHelper.QZoneUploadPhotoConstants.DEFAULT_UPLOAD_SR_BY_OPR, new bo.c());
        hashMap2.put("fake_business", new io.a());
    }

    private static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Uri.parse(str).getBooleanQueryParameter("vendorpush", false);
    }

    public static ad.a c() {
        return (ad.a) t(ad.a.class);
    }

    public static Navigator d(Context context, String str) {
        boolean L1;
        if (!f405433a) {
            n();
        }
        if (context == null) {
            context = BaseApplication.getContext();
        }
        Navigator createNavigator = QRoute.createNavigator(context, str);
        if (context instanceof Application) {
            createNavigator.withFlags(268435456);
        }
        if (!AppSetting.isPublicVersion()) {
            L1 = gd.a.f401926a.c("KEY_USE_QQ_OPEN_AND_CLOSE_ANIMATION", false);
        } else {
            L1 = com.qzone.reborn.configx.g.f53821a.b().L1();
        }
        if (L1) {
            createNavigator.withString(QBaseActivity.KEY_TYPE_ACTIVITY_ANIMATION, "aio");
        }
        return createNavigator;
    }

    public static c e() {
        return (c) t(c.class);
    }

    public static m f() {
        return (m) t(m.class);
    }

    public static d g() {
        return (d) t(d.class);
    }

    public static n h() {
        return (n) t(n.class);
    }

    public static ie.a i() {
        return (ie.a) t(ie.a.class);
    }

    public static e j() {
        return (e) t(e.class);
    }

    public static ad.b k() {
        return (ad.b) t(ad.b.class);
    }

    public static rk.e l() {
        return (rk.e) t(rk.e.class);
    }

    public static oi.c m() {
        return (oi.c) t(oi.c.class);
    }

    public static void n() {
        QRoute.registerRouter("/qzone/holder_page", QZoneShellActivity.class);
        QRoute.registerRouter("/qzone/holder_page_in_qzone_process", QZoneShellInQZoneProcessActivity.class);
        QRoute.registerRouter("/qzone/gallery_page", QZoneShellActivity.class);
        QRoute.registerRouter("/qzone/friend_feed", QZoneFriendFeedXActivity.class);
        QRoute.registerRouter("/qzone/friend_feed_pro", QzoneFriendFeedProActivity.class);
        QRoute.registerRouter("/qzone/aio_msg_list", QZoneShellActivity.class);
        QRoute.registerRouter("/qzone/qzm_folder_page", QZMShellFolderActivity.class);
        QRoute.registerRouter("/qzone/comment_panel", QZoneCommentPanelActivity.class);
        QRoute.registerRouter("/qzone/forward_panel", QZoneCommentPanelActivity.class);
        QRoute.registerRouter("/qzone/common_upload_page", QZoneCommonUploadActivity.class);
        QRoute.registerRouter("/qzone/holder_page_transparent", QZoneTransparentShellActivity.class);
        QRoute.registerRouter("/qzone/publish_mood", QZonePublishMoodRealActivity.class);
        QRoute.registerRouter("/qzone/publish_mood_new", QZonePublishXMoodRealActivity.class);
        QRoute.registerRouter("/qzone/upload_photo", QZoneUploadPhotoRealActivity.class);
        f405433a = true;
    }

    public static ck.c o() {
        return (ck.c) t(ck.c.class);
    }

    public static boolean p(Context context, String str) {
        QZoneSchemeBean convertSchemeToBean = new QZoneSchemeBean().convertSchemeToBean(str);
        b bVar = f405435c.get(convertSchemeToBean.getBusinessAction());
        QLog.i("QZoneRouter", 1, "schemeLauncher   | scheme = " + str + " | launcher = " + bVar);
        if (bVar == null) {
            return false;
        }
        return bVar.a(context, convertSchemeToBean);
    }

    public static void r(Context context, String str, Map<String, String> map) {
        q(context, a(str, map));
    }

    public static <T extends a> T t(Class<T> cls) {
        T t16 = (T) f405434b.get(cls);
        if (t16 != null) {
            return t16;
        }
        try {
            return cls.newInstance();
        } catch (IllegalAccessException | InstantiationException e16) {
            RFWLog.fatal("QZoneRouter", 1, e16);
            throw new RuntimeException(cls.getName() + " not in sLauncherMap, please register!");
        }
    }

    public static fl.a u() {
        return (fl.a) t(fl.a.class);
    }

    public static bo.b v() {
        return (bo.b) t(bo.b.class);
    }

    public static g w() {
        return (g) t(g.class);
    }

    public static vb.b x() {
        return (vb.b) t(vb.b.class);
    }

    public static ka.a y() {
        return (ka.a) t(ka.a.class);
    }

    public static j z() {
        return (j) t(j.class);
    }

    public static void q(Context context, String str) {
        s(context, str, false);
    }

    public static void s(Context context, String str, boolean z16) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (z16) {
                try {
                    str = URLDecoder.decode(str, "UTF-8");
                } catch (Exception e16) {
                    QLog.e("QZoneRouter", 1, "decode exception is " + e16);
                }
            }
            QLog.i("QZoneRouter", 1, "launchScheme: " + str);
            if (HttpUtil.isValidUrl(str)) {
                yo.d.c(str, context);
                QLog.i("QZoneRouter", 1, "launch url: " + str);
                return;
            }
            if (b(str)) {
                if (!AppSetting.isPublicVersion()) {
                    QLog.i("QZoneRouter", 1, "launch from vendor push scheme: " + str);
                }
                QZoneLoginReportHelper.reportLoginFromMQQPush();
                QZonePushReporter.reportPushEvent(new QZonePushReporter.QZonePushEventValueBuilder().setPushChannel("2").setDisplayType("2").setEventCodeType1(QZonePushReporter.EVENT_CODE_TYPE1_PUSH).setEventCodeType2("click"));
            }
            if (yo.e.a(context, str)) {
                QLog.i("QZoneRouter", 1, "jump active feed activity first");
                return;
            }
            if (p(context, str)) {
                QZoneLoginReportHelper.reportLoginFromSchema(str);
                return;
            }
            RFWLog.w("QZoneRouter", 1, "scheme\u3010" + str + "\u3011 not business register in sSchemeLauncherMap, please register!");
            yo.d.c(str, context);
            return;
        }
        QLog.i("QZoneRouter", 1, "context or scheme is empty: " + str);
    }

    private static String a(String str, Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return str;
        }
        String str2 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            str2 = ContainerUtils.FIELD_DELIMITER;
        }
        StringBuilder sb5 = new StringBuilder(str);
        sb5.append(str2);
        boolean z16 = true;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (z16) {
                z16 = false;
            } else {
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb5.append(entry.getKey());
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(entry.getValue());
        }
        return sb5.toString();
    }
}
