package com.tencent.mobileqq.app.message.messageclean;

import android.app.usage.StorageStats;
import android.app.usage.StorageStatsManager;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.UserHandle;
import android.os.storage.StorageManager;
import android.util.Pair;
import com.tencent.aelight.camera.api.IAEPath;
import com.tencent.av.utils.QavCacheClearHelper;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionPreloadManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.ad.api.IAdFileApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.api.IGameCenterWidgetMgrApi;
import com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi;
import com.tencent.mobileqq.intervideo.groupvideo.clearcache.api.ICacheClear;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendLocalCache;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qcircle.api.IQCircleRFWApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.splashad.config.ThemeSplashHelper;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.storage.StorageReport;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi;
import com.tencent.mobileqq.wink.api.IWinkAPI;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qidian.api.IQidianManagerApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.IMiniBoxService;
import com.tencent.qzonehub.api.utils.IQzoneOfflineCacheHelper;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes11.dex */
public class q {
    static IPatchRedirector $redirector_;

    @Deprecated
    public static void a(QQAppInterface qQAppInterface, QBaseFragment qBaseFragment, Runnable runnable) {
        ((IRecentUserProxyService) qQAppInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentForwardCache().clearRecentUser();
        QQSettingMsgHistoryActivity.I2(qBaseFragment.getActivity(), qQAppInterface);
        StorageReport.k().A(true);
        runnable.run();
        ea.G3(qQAppInterface.getCurrentUin());
        QQSettingMsgHistoryActivity.H2();
        ThemeSplashHelper.i();
        FileUtils.deleteDirectory(com.tencent.mobileqq.qqexpand.utils.e.c());
    }

    @Deprecated
    public static void b(QQAppInterface qQAppInterface, QBaseFragment qBaseFragment) {
        ((IQzoneOfflineCacheHelper) QRoute.api(IQzoneOfflineCacheHelper.class)).clearQZoneAppCache();
        ((IQWalletApi) QRoute.api(IQWalletApi.class)).clearQWalletCache();
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actCleanCacheData", true, 0L, 0L, null, null);
        FileUtils.delete(BaseApplication.getContext().getFilesDir() + "/minigame", false);
        FileUtils.delete(BaseApplication.getContext().getExternalCacheDir() + "/superplayer", false);
        FileUtils.delete(AppConstants.PATH_CUSTOM_HEAD_ROOT, false);
        QLog.deleteExpireLogFileActively();
        ((IQCircleRFWApi) QRoute.api(IQCircleRFWApi.class)).clearQCircleCache();
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).cleanZPlanCache(qQAppInterface.getApplicationContext());
        ((IWinkAPI) QRoute.api(IWinkAPI.class)).cleanCache();
        ((IQQGameCommApi) QRoute.api(IQQGameCommApi.class)).clearQQGameDownloadFile();
        ((IQQGameStrategyApi) QRoute.api(IQQGameStrategyApi.class)).clearDraftCache();
        new com.tencent.qqmini.minigame.screenrecord.a(BaseApplication.getContext()).b();
        ((IMiniBoxService) QRoute.api(IMiniBoxService.class)).clearAllCache(true);
        ((IAEPath) QRoute.api(IAEPath.class)).clearAECache();
        ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).cleanMaskAdCache();
        ((IAdFileApi) QRoute.api(IAdFileApi.class)).cleanAdFileCache();
        ((ICacheClear) QRoute.api(ICacheClear.class)).cleanCache(qQAppInterface.getApplicationContext());
        QavCacheClearHelper.c();
        ((IPublicAccountImageCollectionPreloadManager) QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).clearAllCache();
        ((IMatchFriendLocalCache) QRoute.api(IMatchFriendLocalCache.class)).cleanCache(qQAppInterface.getApplicationContext());
        ((IQidianManagerApi) qQAppInterface.getRuntimeService(IQidianManagerApi.class, "")).clearQidianCache();
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).clearCache();
        ((IGameCenterWidgetMgrApi) QRoute.api(IGameCenterWidgetMgrApi.class)).clearImgCache();
    }

    public static String c(long j3) {
        Pair<String, String> d16 = d(j3);
        return ((String) d16.first) + ((String) d16.second);
    }

    public static Pair<String, String> d(long j3) {
        float baseNumber = FileUtils.getBaseNumber();
        double d16 = j3;
        float f16 = baseNumber * baseNumber;
        if (d16 < f16 * 0.05d) {
            return new Pair<>("0", " MB");
        }
        double baseNumberThreshold = FileUtils.getBaseNumberThreshold();
        if (((float) j3) < f16) {
            DecimalFormat decimalFormat = new DecimalFormat("0.#");
            decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
            return new Pair<>(decimalFormat.format((r11 / baseNumber) / baseNumber), " MB");
        }
        if (d16 < f16 * baseNumber * baseNumberThreshold) {
            DecimalFormat decimalFormat2 = new DecimalFormat("0");
            decimalFormat2.setRoundingMode(RoundingMode.DOWN);
            return new Pair<>(decimalFormat2.format((r11 / baseNumber) / baseNumber), " MB");
        }
        DecimalFormat decimalFormat3 = new DecimalFormat("0.#");
        decimalFormat3.setRoundingMode(RoundingMode.HALF_UP);
        return new Pair<>(decimalFormat3.format(((r11 / baseNumber) / baseNumber) / baseNumber), " GB");
    }

    public static String e(long j3) {
        long baseNumber = (int) FileUtils.getBaseNumber();
        return String.valueOf((j3 / baseNumber) / baseNumber);
    }

    public static String f(long j3) {
        return g(j3, FileUtils.getBaseNumber());
    }

    public static String g(long j3, float f16) {
        if (j3 > 0 && f16 > 0.0f) {
            float f17 = (float) j3;
            if (f17 < f16) {
                return j3 + "B";
            }
            float f18 = f16 * f16;
            if (f17 < f18) {
                return String.format("%.1f", Float.valueOf(f17 / f16)) + "K";
            }
            if (f17 < f18 * f16) {
                return String.format("%.1f", Float.valueOf((f17 / f16) / f16)) + "M";
            }
            return String.format("%.1f", Float.valueOf(((f17 / f16) / f16) / f16)) + "G";
        }
        return "";
    }

    public static long h(boolean z16) {
        BaseApplicationImpl baseApplicationImpl;
        StorageStatsManager storageStatsManager;
        UserHandle userHandleForUid;
        UUID uuid;
        StorageStats queryStatsForPackage;
        long dataBytes;
        long appBytes;
        if (Build.VERSION.SDK_INT >= 26 && (baseApplicationImpl = BaseApplicationImpl.sApplication) != null && (storageStatsManager = (StorageStatsManager) baseApplicationImpl.getSystemService("storagestats")) != null) {
            try {
                ApplicationInfo applicationInfo = baseApplicationImpl.getPackageManager().getApplicationInfo(BaseApplicationImpl.sApplication.getPackageName(), 128);
                userHandleForUid = UserHandle.getUserHandleForUid(applicationInfo.uid);
                uuid = StorageManager.UUID_DEFAULT;
                queryStatsForPackage = storageStatsManager.queryStatsForPackage(uuid, applicationInfo.packageName, userHandleForUid);
                if (z16) {
                    appBytes = queryStatsForPackage.getAppBytes();
                    return appBytes;
                }
                dataBytes = queryStatsForPackage.getDataBytes();
                return dataBytes;
            } catch (Exception e16) {
                QLog.e("FileCleanUtils", 1, "[getQQSpaceSize]: " + e16.getMessage());
            }
        }
        return 0L;
    }
}
