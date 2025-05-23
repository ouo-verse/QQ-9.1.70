package com.tencent.biz.pubaccount.weishi.util;

import NS_KING_SOCIALIZE_META.stMetaUgcImage;
import UserGrowth.stImgReplacement;
import UserGrowth.stSimpleMetaFeed;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.weishi.cache.WeiShiCacheManager;
import com.tencent.biz.pubaccount.weishi.push.IWSPushBaseStrategy;
import com.tencent.biz.pubaccount.weishi.push.WSPushPreloadModel;
import com.tencent.biz.pubaccount.weishi.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi.report.WSStatisticsBaseCollector;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.utils.preference.PreferenceManager;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.dv;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import cooperation.qzone.LocalMultiProcConfig;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes32.dex */
public class bb {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f81753a = false;

    /* renamed from: b, reason: collision with root package name */
    private static long f81754b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static String f81755c = "";

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface c {
        void a(String str, int i3);

        void b(Activity activity);

        void c(String str, int i3);

        void d(String str, int i3);

        void e(String str, int i3);
    }

    private static stImgReplacement A(stSimpleMetaFeed stsimplemetafeed, boolean z16) {
        ArrayList<stImgReplacement> arrayList = stsimplemetafeed.imgReplacements;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        if (!z16 && stsimplemetafeed.imgReplacements.size() > 1) {
            return stsimplemetafeed.imgReplacements.get(1);
        }
        return stsimplemetafeed.imgReplacements.get(0);
    }

    private static String B(stSimpleMetaFeed stsimplemetafeed, boolean z16) {
        stImgReplacement A = A(stsimplemetafeed, z16);
        if (A != null) {
            return b(A.photo_rgb);
        }
        return "";
    }

    public static dv C() {
        AppRuntime h16 = h();
        if (!(h16 instanceof QQAppInterface)) {
            return null;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) h16;
        int i3 = QQManagerFactory.WEISHI_MANAGER;
        if (qQAppInterface.getManager(i3) instanceof dv) {
            return (dv) qQAppInterface.getManager(i3);
        }
        return null;
    }

    public static boolean E() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f81754b <= 500) {
            x.c("WeishiUtils", "click too fast");
            f81754b = currentTimeMillis;
            return true;
        }
        f81754b = currentTimeMillis;
        return false;
    }

    public static boolean F() {
        AppRuntime h16 = h();
        if (h16 == null) {
            return false;
        }
        return ((IPublicAccountDataManager) h16.getRuntimeService(IPublicAccountDataManager.class, "all")).isFollowedUin(Long.valueOf(AppConstants.WEISHI_UIN_LONGVALUE));
    }

    public static boolean G() {
        QQAppInterface t16 = t();
        return (t16 == null || t16.getMessageFacade() == null || t16.getMessageFacade().G() == null || t16.getMessageFacade().G().R(AppConstants.WEISHI_UIN, 1008) <= 0) ? false : true;
    }

    public static boolean H() {
        QQAppInterface t16 = t();
        if (t16 != null) {
            return t16.mAutomator.isInRealActionLoginB();
        }
        return true;
    }

    public static boolean I(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.endsWith("jpg") || str.endsWith(MimeHelper.IMAGE_SUBTYPE_JPEG) || str.endsWith("JPG") || str.endsWith("JPEG");
    }

    public static boolean J() {
        return z() != null;
    }

    public static boolean K(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.endsWith("png") || str.endsWith("PNG");
    }

    public static boolean L(int i3) {
        String f16 = f();
        return WeiShiCacheManager.O().Z(i3) && (TextUtils.isEmpty(f16) || TextUtils.equals(f16, WeiShiCacheManager.P(i3)));
    }

    public static boolean M(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.endsWith("webp") || str.endsWith("WEBP");
    }

    public static void O(Context context) {
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, IPublicAccountDetailActivity.ROUTE_NAME);
        Bundle extra = activityURIRequest.extra();
        extra.putString("uin", String.valueOf(AppConstants.WEISHI_UIN_LONGVALUE));
        extra.putInt("uintype", 1008);
        extra.putInt("source", 119);
        QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
    }

    public static void Q() {
        dv C = C();
        if (C != null) {
            stSimpleMetaFeed stsimplemetafeed = new stSimpleMetaFeed();
            stsimplemetafeed.f25129id = C.d();
            stsimplemetafeed.feed_desc = C.c();
            ry.a.h(stsimplemetafeed, "H5Biz");
        }
    }

    public static String R(String str) {
        try {
            if (TextUtils.isEmpty(str) || !str.contains("@{uid:") || !str.contains(",nick:") || !str.contains("}")) {
                return str;
            }
            int indexOf = str.indexOf("@{uid:");
            int indexOf2 = str.indexOf(",nick:");
            int indexOf3 = str.indexOf("}");
            return R(str.replace(str.substring(indexOf, indexOf3 + 1), "@" + URLDecoder.decode(str.substring(indexOf2 + 6, indexOf3) + " ")));
        } catch (Exception e16) {
            e16.printStackTrace();
            return str;
        }
    }

    public static void S(stSimpleMetaFeed stsimplemetafeed, String str, dv dvVar) {
        x.j("WeishiUtils", "[saveLastFeedInfoTruly] isFollowedWSPublicAccount:" + F());
    }

    public static void T(String str) {
        LocalMultiProcConfig.putString4Uin("key_weishi_nickname", str, o());
    }

    public static void U(String str) {
        LocalMultiProcConfig.putString4Uin("key_qq_connect_person_id", str, o());
    }

    public static void W(String str) {
        if (TextUtils.isEmpty(str)) {
            com.tencent.biz.pubaccount.weishi.report.e.f81527b = "";
            com.tencent.biz.pubaccount.weishi.report.e.f81526a = "";
            ai.p(WSStatisticsBaseCollector.KEY_REF_PAGE_ID, "");
        } else {
            if (TextUtils.equals(com.tencent.biz.pubaccount.weishi.report.e.f81526a, str)) {
                return;
            }
            String str2 = com.tencent.biz.pubaccount.weishi.report.e.f81526a;
            com.tencent.biz.pubaccount.weishi.report.e.f81527b = str2;
            ai.p(WSStatisticsBaseCollector.KEY_REF_PAGE_ID, str2);
            com.tencent.biz.pubaccount.weishi.report.e.f81526a = str;
        }
    }

    public static void X() {
        ty.g.f437886a.p(null);
    }

    public static int Y(String str, int i3) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return Integer.parseInt(str);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return i3;
    }

    public static long Z(String str, long j3) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return Long.parseLong(str);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return j3;
    }

    public static String b(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith(RelationNTPushServiceImpl.PRE_HEX_STRING)) {
            String substring = str.substring(2);
            if (!TextUtils.isEmpty(substring)) {
                return "#" + substring;
            }
            return "";
        }
        return "";
    }

    public static URL c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new URL(str);
        } catch (MalformedURLException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static Uri d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Uri.parse(str);
    }

    public static String f() {
        return g(z());
    }

    public static AppRuntime h() {
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (application != null) {
            return application.getRuntime();
        }
        return null;
    }

    public static String j(stSimpleMetaFeed stsimplemetafeed, boolean z16) {
        return k(n(stsimplemetafeed, z16));
    }

    public static String k(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (I(str)) {
            return "jpg";
        }
        if (K(str)) {
            return "png";
        }
        if (!M(str)) {
            return "";
        }
        return "webp";
    }

    private static stMetaUgcImage l(stSimpleMetaFeed stsimplemetafeed, boolean z16) {
        ArrayList<stMetaUgcImage> arrayList = stsimplemetafeed.images;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        if (!z16 && stsimplemetafeed.images.size() > 1) {
            return stsimplemetafeed.images.get(1);
        }
        return stsimplemetafeed.images.get(0);
    }

    private static String m(stSimpleMetaFeed stsimplemetafeed, boolean z16) {
        stMetaUgcImage l3 = l(stsimplemetafeed, z16);
        if (l3 != null) {
            return b(l3.photo_rgb);
        }
        return "";
    }

    public static String n(stSimpleMetaFeed stsimplemetafeed, boolean z16) {
        String str;
        String str2;
        if (stsimplemetafeed == null) {
            return "";
        }
        ArrayList<stImgReplacement> arrayList = stsimplemetafeed.imgReplacements;
        if (arrayList == null || arrayList.size() <= 0) {
            str = "";
        } else {
            if (!z16 && stsimplemetafeed.imgReplacements.size() > 1) {
                str = stsimplemetafeed.imgReplacements.get(1).img;
            } else {
                str = stsimplemetafeed.imgReplacements.get(0).img;
            }
            x.b("WeishiUtils", "\u4f7f\u7528webp\u56fe\u7247\u8d44\u6e90\uff1a" + str);
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        ArrayList<stMetaUgcImage> arrayList2 = stsimplemetafeed.images;
        if (arrayList2 != null && arrayList2.size() > 0) {
            if (!z16 && stsimplemetafeed.images.size() > 1) {
                str2 = stsimplemetafeed.images.get(1).url;
            } else {
                str2 = stsimplemetafeed.images.get(0).url;
            }
            str = str2;
            x.b("WeishiUtils", "\u4f7f\u7528\u670d\u52a1\u5668\u9ed8\u8ba4\u7684\u56fe\u7247\u683c\u5f0f\u8d44\u6e90\uff1a" + str);
        }
        return !TextUtils.isEmpty(str) ? str : "";
    }

    public static long o() {
        AppRuntime h16 = h();
        if (h16 != null) {
            return h16.getLongAccountUin();
        }
        return 0L;
    }

    public static int p(int i3, boolean z16) {
        if (z16) {
            if (i3 == 2) {
                return 1;
            }
            if (i3 == 4) {
                return 3;
            }
            return i3;
        }
        if (i3 == 1) {
            return 2;
        }
        if (i3 == 3) {
            return 4;
        }
        return i3;
    }

    public static String q() {
        return LocalMultiProcConfig.getString4Uin("key_qq_connect_person_id", "", o());
    }

    public static boolean s(WSRedDotPushMsg wSRedDotPushMsg) {
        WSPushPreloadModel wSPushPreloadModel;
        IWSPushBaseStrategy iWSPushBaseStrategy = wSRedDotPushMsg.mStrategyInfo;
        if (!(iWSPushBaseStrategy instanceof WSPushStrategyInfo) || (wSPushPreloadModel = ((WSPushStrategyInfo) iWSPushBaseStrategy).mWSPushPreloadModel) == null) {
            return false;
        }
        return wSPushPreloadModel.f81335d;
    }

    public static QQAppInterface t() {
        AppRuntime h16 = h();
        if (h16 instanceof QQAppInterface) {
            return (QQAppInterface) h16;
        }
        return null;
    }

    public static String u() {
        try {
            BaseApplicationImpl application = BaseApplicationImpl.getApplication();
            return InstalledAppListMonitor.getPackageInfo(application.getPackageManager(), application.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String v() {
        return "";
    }

    public static String w() {
        QQAppInterface t16 = t();
        if (t16 == null) {
            return "0";
        }
        return PreferenceManager.getDefaultPreference(t16.getApplication(), Long.parseLong(t16.getCurrentAccountUin())).getString("key_weishi_newest_feed_from", "0");
    }

    public static String x(int i3) {
        return com.tencent.biz.pubaccount.weishi.report.f.g(i3);
    }

    public static String y() {
        String account;
        AppRuntime h16 = h();
        return (h16 == null || (account = h16.getAccount()) == null) ? "" : account;
    }

    public static WSRedDotPushMsg z() {
        return ty.g.f437886a.i();
    }

    public static boolean D(float f16, float f17) {
        return ((double) Math.abs(f16 - f17)) < 1.0E-13d;
    }

    public static String i(stSimpleMetaFeed stsimplemetafeed) {
        return j(stsimplemetafeed, false);
    }

    public static void P(List<stSimpleMetaFeed> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (stSimpleMetaFeed stsimplemetafeed : list) {
            stsimplemetafeed.feed_desc = R(stsimplemetafeed.feed_desc);
        }
    }

    public static void V(BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16) {
        if (appInfo != null) {
            x.b("WSRedDotLog", "saveRedDotAppInfo appInfo = " + appInfo.iNewFlag.get());
            x.b("WSRedDotLog", "saveRedDotAppInfo hasWsRedDot = " + z16);
            LocalMultiProcConfig.putBooleanAsync("wsRedDot", z16);
        }
    }

    public static void e(Context context, String str, String str2, String str3, int i3, c cVar) {
        if (cVar != null) {
            if (com.tencent.biz.qqstory.utils.l.c(context)) {
                if (!TextUtils.isEmpty(str)) {
                    x.l("815", "\u8d70\u6253\u5f00shemeUrl:" + str);
                    cVar.c(str, i3);
                    return;
                }
                if (!TextUtils.isEmpty(str3)) {
                    x.l("833", "\u8d70\u6253\u5f00\u5c0f\u7a0b\u5e8f:" + str3);
                    cVar.e(str3, i3);
                    return;
                }
                if (!TextUtils.isEmpty(str2)) {
                    x.l("815", "\u8d70\u6253\u5f00h5Url:" + str2);
                    cVar.d(str2, i3);
                    return;
                }
                x.l("815", "\u8d70\u6253\u5f00\u515c\u5e95:" + str);
                cVar.c("weishi://main", i3);
                return;
            }
            if (!TextUtils.isEmpty(str3)) {
                x.l("833", "\u8d70\u6253\u5f00\u5c0f\u7a0b\u5e8f:" + str3);
                cVar.e(str3, i3);
                return;
            }
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (com.tencent.biz.pubaccount.weishi.util.a.c(activity)) {
                    cVar.b(activity);
                    return;
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                x.l("815", "\u8d70\u8df3\u8f6ch5Url:" + str2);
                cVar.d(str2, i3);
                return;
            }
            x.l("815", "\u8d70\u4e0b\u8f7d\uff0cshemeUrl:" + str);
            cVar.a(str, i3);
            return;
        }
        throw new RuntimeException("downloadOpenWeishiGoH5 must not be null!");
    }

    public static String g(WSRedDotPushMsg wSRedDotPushMsg) {
        if (wSRedDotPushMsg != null) {
            return wSRedDotPushMsg.mFeedIds;
        }
        dv C = C();
        if (C != null) {
            return C.d();
        }
        return "";
    }

    public static String r(stSimpleMetaFeed stsimplemetafeed, boolean z16) {
        if (stsimplemetafeed == null) {
            return "";
        }
        String B = B(stsimplemetafeed, z16);
        return !TextUtils.isEmpty(B) ? B : m(stsimplemetafeed, z16);
    }

    public static void N(Context context, String str) {
        if (context == null) {
            return;
        }
        com.tencent.biz.pubaccount.weishi.z.h(context, "https://isee.weishi.qq.com/ws/weishi-qq/personality_setting/index.html?from=" + str);
    }

    public static void a(View view, int i3, int i16) {
        if (view == null) {
            return;
        }
        int visibility = view.getVisibility();
        if (view.getTag(-1) != null && view.getAnimation() != null) {
            visibility = ((Integer) view.getTag(-1)).intValue();
        }
        view.setTag(-1, Integer.valueOf(i3));
        if (visibility == i3) {
            return;
        }
        if (i3 == 0) {
            view.setVisibility(0);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(i16);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setAnimationListener(new a(view));
            view.clearAnimation();
            view.startAnimation(alphaAnimation);
            return;
        }
        if (i3 == 8 || i3 == 4) {
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation2.setDuration(i16);
            alphaAnimation2.setFillAfter(true);
            alphaAnimation2.setAnimationListener(new b(view));
            view.clearAnimation();
            view.startAnimation(alphaAnimation2);
        }
    }

    public static <T> List<T> a0(List<T> list, int i3, int i16) {
        if (list != null && i3 >= 0 && i16 <= list.size() && i3 <= i16) {
            return list.subList(i3, i16);
        }
        return new ArrayList();
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f81756d;

        a(View view) {
            this.f81756d = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f81756d.setTag(-1, null);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f81757d;

        b(View view) {
            this.f81757d = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (this.f81757d.getTag(-1) == null || ((Integer) this.f81757d.getTag(-1)).intValue() != 8) {
                return;
            }
            this.f81757d.clearAnimation();
            this.f81757d.setVisibility(8);
            this.f81757d.setTag(-1, null);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
