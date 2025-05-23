package com.qzone.feed.gift.util;

import android.os.Build;
import android.text.TextUtils;
import com.qzone.feed.business.service.QZoneFeedService;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellDecorateInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.utils.IQzoneZipCacheHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedGiftUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final float f47229a = FeedGlobalEnv.g().getScreenWidth() / 720.0f;

    /* renamed from: b, reason: collision with root package name */
    private static int f47230b = QzoneConfig.getInstance().getConfig("QZoneSetting", "feedGiftSwitch", 1);

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return ((IQzoneZipCacheHelper) QRoute.api(IQzoneZipCacheHelper.class)).getBasePath("feed_gift", String.valueOf(str.hashCode()));
    }

    public static boolean b() {
        return "HUAWEI".equalsIgnoreCase(Build.MANUFACTURER) && Build.VERSION.SDK_INT >= 24;
    }

    public static boolean c() {
        return f47230b == 1;
    }

    public static void d(final String str, final QzoneZipCacheHelperCallBack qzoneZipCacheHelperCallBack) {
        if (TextUtils.isEmpty(str)) {
            qzoneZipCacheHelperCallBack.onResult(false);
        } else {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.feed.gift.util.FeedGiftUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    IQzoneZipCacheHelper iQzoneZipCacheHelper = (IQzoneZipCacheHelper) QRoute.api(IQzoneZipCacheHelper.class);
                    String str2 = str;
                    qzoneZipCacheHelperCallBack.onResult(iQzoneZipCacheHelper.checkAndDownLoadFileIfNeeded(null, str2, "feed_gift", String.valueOf(str2.hashCode()), -1, qzoneZipCacheHelperCallBack));
                }
            });
        }
    }

    public static void e(int i3) {
        LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(91, 14, i3), false, false);
    }

    public static void f(final BusinessFeedData businessFeedData) {
        CellDecorateInfo cellDecorateInfo;
        if (businessFeedData == null || (cellDecorateInfo = businessFeedData.cellDecorateInfo) == null || cellDecorateInfo.cellGiftData == null) {
            return;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.feed.gift.util.FeedGiftUtil.2
            @Override // java.lang.Runnable
            public void run() {
                QZoneFeedService.U().Z0(BusinessFeedData.this, false);
            }
        });
    }
}
