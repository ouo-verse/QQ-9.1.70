package com.qzone.proxy.covercomponent.env;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.CustomListViewActivity;
import com.qzone.common.event.EventCenter;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.proxy.covercomponent.CoverComponentProxy;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.qzone.proxy.covercomponent.adapter.WebviewWrapper;
import com.qzone.proxy.covercomponent.ui.ICoverBaseView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.ui.c;
import com.qzone.publish.business.publishqueue.QZonePublishQueue;
import com.qzone.publish.business.task.IQueueTask;
import com.qzone.util.SystemTools;
import com.qzone.util.ToastUtil;
import com.qzone.util.an;
import com.qzone.util.x;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlayInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.webview.webso.e;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ListView;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.RDMEtraMsgCollector;
import cooperation.qzone.model.CoverCacheData;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewwrapper.IWebviewWrapper;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import pl.a;
import vo.d;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CoverEnv {
    public static final double COVER_RATI0_FRIEND = 1.1363636363636365d;
    public static final double COVER_RATIO = 1.4150943396226414d;
    public static final long MIN_UIN = 10000;
    public static final String TAG = "CoverEnv";

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class QzoneShowEnv {
        public static double getCutRateConfig() {
            return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QZONECOVER, QzoneCoverConst.SECONDARY_COVER_QZONE_SHOW_BG_IMAGE_CUT_RATE, 80) * 0.01d;
        }

        public static boolean getIsNeedReportDengTa() {
            return "1".equals(QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneCoverConst.SECONDARY_COVER_QZONE_SHOW_NEED_REPORT_DENGTA, "1"));
        }

        public static boolean isUseHechengtuAndEmptyWebviewConfig() {
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class RDMCollector {
        public static void addNoramlClickAction(String str, View view) {
            RDMEtraMsgCollector.getInstance().addNoramlClickAction(str, view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class Webso {
        public static String getHtmlData(String str) {
            return e.n(str);
        }

        public static boolean hasProxyParam(Uri uri) {
            return e.D(uri);
        }

        public static void startWebSoRequest(String str, Handler handler) {
            WebSoService.j().E(str, handler);
        }

        public static void startWebSoRequestWithCheck(String str, Handler handler) {
            WebSoService.j().G(str, handler);
        }

        public static void startWebSoRequest(String str, Handler handler, boolean z16) {
            WebSoService.j().F(str, handler, z16);
        }
    }

    public static boolean checkAppInstalled(Context context, String str) {
        return SystemTools.a(context, str);
    }

    public static VideoPlayInfo convertToVideoPlayInfo(BusinessFeedData businessFeedData, VideoInfo videoInfo) {
        return c.b(businessFeedData, videoInfo);
    }

    public static boolean equalsWithNullCheck(Object obj, Object obj2) {
        return Utils.p(obj, obj2);
    }

    public static Handler getBackgroundThreadHandler() {
        return QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).getHandler();
    }

    public static Handler getBusinessThreadHandler() {
        return QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).getHandler();
    }

    public static String getConfig(String str, String str2, String str3) {
        return QzoneConfig.getInstance().getConfig(str, str2, str3);
    }

    public static String getContentTypeFamousSpaceBgUrl(long j3) {
        return an.b(d.b().a(j3));
    }

    public static String getContentTypeFamousSpaceWebviewUrl(long j3) {
        return d.b().c(j3);
    }

    public static Context getContext() {
        return BaseApplication.getContext();
    }

    public static int getCoverFriendPaddingTop() {
        return (int) (-(getFinalCoverHeight() - (getFinalCoverHeight() / 1.1363636363636365d)));
    }

    public static String getCoverJumpUrlFromJce(long j3) {
        HashMap<String, String> hashMap;
        CoverCacheData coverFromCache = CoverComponentProxy.f50099g.getServiceInterface().getCoverFromCache(j3);
        if (coverFromCache == null || (hashMap = coverFromCache.mapExtInfo) == null || !hashMap.containsKey("jump_url")) {
            return null;
        }
        return coverFromCache.mapExtInfo.get("jump_url");
    }

    public static int getCoverPaddingTop() {
        return (int) (-(getFinalCoverHeight() - (getFinalCoverHeight() / 1.4150943396226414d)));
    }

    public static int getFinalCoverHeight() {
        return a.f426446a.i();
    }

    public static boolean getForceClosed() {
        return getIsBlackList();
    }

    public static boolean getIsBlackList() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QZONECOVER, QzoneConfig.SECONDARY_HTML_FORCE_CLOSE, 0) == 1;
    }

    public static long getLoginUin() {
        return LoginData.getInstance().getUin();
    }

    public static Handler getNormalThreadHandler() {
        return QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.YellowVipThread).getHandler();
    }

    public static String getQUA() {
        return QUA.getQUA3();
    }

    public static String getQzonePublishQueueVideoCoverTaskClientKey() {
        IQueueTask C = QZonePublishQueue.w().C();
        if (C != null) {
            return C.getClientKey();
        }
        return null;
    }

    public static Handler getRealTimeThreadHandler() {
        return QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).getHandler();
    }

    public static int getScreenWidth() {
        return a.f426446a.o(BaseApplicationImpl.getApplication());
    }

    public static boolean getShowCoverGuide(Context context) {
        return LocalMultiProcConfig.getBool(QzoneCoverConst.QZONE_COVER_SERVICE_TAG, QzoneCoverConst.COVER_SHOW_GUIDE, true);
    }

    public static String getStrangerCoverJumpUrlFromJce(long j3) {
        x6.a g16 = z5.a.f().g(j3);
        if (g16 == null || TextUtils.isEmpty(g16.jumpUrlForClickStrangerCover)) {
            return null;
        }
        return g16.jumpUrlForClickStrangerCover;
    }

    public static VideoInfo getVideoInfoFromCache(String str) {
        return i.H().I0(str);
    }

    public static IWebviewWrapper getWebviewInstance(Context context) {
        return new WebviewWrapper(context);
    }

    public static boolean isBestPerformanceDevice() {
        return QZoneHelper.isBestPerformanceDevice();
    }

    public static boolean isContentTypeFamousSpace(long j3) {
        return d.b().d(j3);
    }

    public static boolean isCoverFullScreen(String str) {
        return (str.equals(QzoneCoverConst.CoverStringType.COVER_TYPE_FULL_SCREEN) || str.equals(QzoneCoverConst.CoverStringType.COVER_TYPE_QZONE_SHOW_COVER)) && isSupportSuperCover();
    }

    public static boolean isDebugVersion() {
        return false;
    }

    public static boolean isDynamicCover(String str) {
        return QzoneCoverConst.CoverStringType.COVER_TYPE_PHOTOWALL.equals(str) || QzoneCoverConst.CoverStringType.COVER_TYPE_VIDEO_COVER.equals(str) || QzoneCoverConst.CoverStringType.COVER_TYPE_NEW_VIDEO_COVER.equals(str) || QzoneCoverConst.CoverStringType.COVER_TYPE_CUSTOM_DYNAMIC_ALBUM_COVER.equals(str);
    }

    public static boolean isGooglePlayVersion() {
        return false;
    }

    public static boolean isInQQ() {
        return true;
    }

    public static boolean isNeedDelayShow() {
        return isInQQ();
    }

    public static boolean isNetworkAvailable() {
        return i.H().l1();
    }

    public static boolean isQzoneShowShowAsSuperCover() {
        return isInQQ();
    }

    public static boolean isSupportQzoneBreeze() {
        return isSupportSuperCover() && !QZoneHelper.isInQzoneShowBreezeBlackList();
    }

    public static boolean isSupportQzoneShowCover() {
        return QZoneHelper.isBestPerformanceDevice() && !getForceClosed();
    }

    public static boolean isSupportSuperCover() {
        return x.e();
    }

    public static boolean isSupprtWebviewCover() {
        return isSupportQzoneShowCover();
    }

    public static boolean isUserHomeActivity(Activity activity) {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0016, code lost:
    
        if (r0.wifiAutoPlayFlag == 1) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isWifiAutoPlay() {
        boolean z16;
        x6.a g16 = z5.a.f().g(LoginData.getInstance().getUin());
        if (g16 != null) {
            z16 = true;
        }
        z16 = false;
        if (NetworkState.isWifiConn()) {
            return z16;
        }
        return false;
    }

    public static boolean isWifiConn() {
        return NetworkState.isWifiConn();
    }

    public static ICoverBaseView newDynamicCoverWrapperInstance(Context context, int i3, ViewGroup viewGroup) {
        return null;
    }

    public static void notifyCanPlayVideo() {
        EventCenter.getInstance().post("Personalize", 14, (Object[]) null);
    }

    public static n7.a obtainDbManager(Class<? extends IDBCacheDataWrapper> cls, long j3, String str) {
        return com.qzone.component.cache.database.c.g().e(cls, j3, str);
    }

    public static void playWith(Activity activity, VideoInfo videoInfo) {
        BusinessFeedData businessFeedData = new BusinessFeedData();
        businessFeedData.setVideoInfo(videoInfo);
        c.j(activity, videoInfo, null, 0, null, businessFeedData);
    }

    public static void report(String str, String str2, String str3, boolean z16, String... strArr) {
        ClickReport.r(str, str2, str3, z16, strArr);
    }

    public static void setShowCoverGuide(Context context, boolean z16) {
        LocalMultiProcConfig.putBool(QzoneCoverConst.QZONE_COVER_SERVICE_TAG, QzoneCoverConst.COVER_SHOW_GUIDE, z16);
    }

    public static void showToast(String str) {
        ToastUtil.r(str);
    }

    public static int dip2px(int i3) {
        return ViewUtils.dip2px(i3);
    }

    public static boolean isLowMemory() {
        MobileQQ application;
        ActivityManager activityManager;
        try {
            AppRuntime qZoneRuntime = LoginData.getInstance().getQZoneRuntime();
            if (qZoneRuntime == null || (application = qZoneRuntime.getApplication()) == null || (activityManager = (ActivityManager) application.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)) == null) {
                return false;
            }
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.lowMemory;
        } catch (Throwable th5) {
            QZLog.e(TAG, "check isLowMemory exception:", th5);
            return false;
        }
    }

    public static void showToastWithErrorIcon(String str) {
        ToastUtil.s(str, 4);
    }

    public static View getFooterRootView(Activity activity) {
        if (activity == null || !(activity instanceof CustomListViewActivity)) {
            return null;
        }
        return ((CustomListViewActivity) activity).I3();
    }

    public static boolean isListView(View view) {
        return view != null && (view instanceof ListView);
    }

    public static void notifyAdapter(Activity activity) {
    }

    public static void setDynamicCoverHierarchyChange(ICoverBaseView iCoverBaseView, ViewGroup viewGroup) {
    }

    public static void setDynamicCoverParentView(ICoverBaseView iCoverBaseView, ViewGroup viewGroup) {
    }

    public static void setDynamicCoverWebviewListener(ICoverBaseView iCoverBaseView, View.OnClickListener onClickListener) {
    }

    public static void setDynamicCoverWithData(ICoverBaseView iCoverBaseView, CoverCacheData coverCacheData) {
    }

    public static void handleWindowVisibilityChanged(Context context, int i3, ICoverBaseView iCoverBaseView) {
    }
}
