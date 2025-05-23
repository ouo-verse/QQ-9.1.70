package com.tencent.mobileqq.vas.adv.maskad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.ad.tangram.util.AdAppDeeplinkLauncher;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.adv.maskad.config.MaskAdConfigBean;
import com.tencent.mobileqq.vas.adv.maskad.config.MaskAdConfigParser;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsJvmKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u001a\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001a\u0010\u001a\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001b\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001c\u001a\u00020\u0012J\u000e\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u000bJ\u000e\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u000bJ\u0010\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u000bH\u0002J\u0010\u0010\"\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u000bH\u0002J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u000bH\u0002J\u0018\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000bH\u0002J\b\u0010&\u001a\u00020\u0016H\u0002J\u0010\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u000fH\u0002J\u0010\u0010)\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u000fH\u0002J\u0010\u0010*\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/maskad/MaskAdClickHelper;", "", "()V", "KEY_MASK_AD_CLICK_TIMESTAMPS", "", "KEY_MASK_AD_CLICK_TIME_DAY_FREQUENCY", "KEY_MASK_AD_CLICK_TIME_HOUR_FREQUENCY", "KEY_MASK_AD_CLICK_TIME_LAST_DAY", "KEY_MASK_AD_CLICK_TIME_LAST_HOUR", "TAG", "TIMESTAMP_CACHE_MAX_SIZE", "", "TIME_DAY", "TIME_HOUR", "TIME_MINUTE", "", "mMaxCacheTimeStampNum", "checkIsNeedAddClickArea", "", "ad", "Lcom/tencent/gdtad/aditem/GdtAd;", "doOpenBrowserActivity", "", "gdtAd", "context", "Landroid/content/Context;", "doOpenDeepLink", "handleTianShuAdClick", "isClickValid", "isImageAd", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_AD_TYPE, "isMaskAd", "isMatchFilterClickDayRule", "frequency", "isMatchFilterClickHourRule", "isMatchFilterClickMinuteRule", "isMatchFilterClickSecondRule", "duration", "updateClickTimeInfoCache", "updateDayClickTimeFrequency", "clickTime", "updateHourClickTimeFrequency", "updateSecondClickTimeStamps", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class MaskAdClickHelper {

    @NotNull
    public static final MaskAdClickHelper INSTANCE = new MaskAdClickHelper();

    @NotNull
    private static final String KEY_MASK_AD_CLICK_TIMESTAMPS = "mask_ad_click_timestamps_";

    @NotNull
    private static final String KEY_MASK_AD_CLICK_TIME_DAY_FREQUENCY = "mask_ad_click_time_day_frequency_";

    @NotNull
    private static final String KEY_MASK_AD_CLICK_TIME_HOUR_FREQUENCY = "mask_ad_click_time_hour_frequency_";

    @NotNull
    private static final String KEY_MASK_AD_CLICK_TIME_LAST_DAY = "mask_ad_click_time_last_day_";

    @NotNull
    private static final String KEY_MASK_AD_CLICK_TIME_LAST_HOUR = "mask_ad_click_time_last_hour_";

    @NotNull
    private static final String TAG = "MaskAdClickHelper";
    private static final int TIMESTAMP_CACHE_MAX_SIZE = 60;
    private static final int TIME_DAY = 86400000;
    private static final int TIME_HOUR = 3600000;
    private static final long TIME_MINUTE = 60000;
    private static int mMaxCacheTimeStampNum;

    MaskAdClickHelper() {
    }

    private final void doOpenBrowserActivity(GdtAd gdtAd, Context context) {
        String str;
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        if (gdtAd != null) {
            str = gdtAd.getUrlForLandingPage();
        } else {
            str = null;
        }
        intent.putExtra("url", str);
        try {
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            ((Activity) context).startActivity(intent);
        } catch (Throwable th5) {
            GdtLog.e(TAG, "maskAd show h5", th5);
        }
    }

    private final void doOpenDeepLink(GdtAd gdtAd, Context context) {
        Bundle bundle = new Bundle();
        bundle.putString("big_brother_source_key", AdDownloadConstants.DOWNLOAD_SOURCE_AD);
        bundle.putString(LaunchParam.KEY_REF_ID, "biz_src_gzh_weather");
        AdAppDeeplinkLauncher.Params params = new AdAppDeeplinkLauncher.Params();
        String str = null;
        if (gdtAd != null && gdtAd.isValid()) {
            str = gdtAd.getAppDeeplink(null);
        }
        params.deeplink = str;
        params.addflags = 268435456;
        params.extrasForIntent = bundle;
        AdAppDeeplinkLauncher.Result launch = AdAppDeeplinkLauncher.launch((Activity) context, params);
        Intrinsics.checkNotNullExpressionValue(launch, "launch(context as Activity?, deeplinkParams)");
        if (launch.isSuccess()) {
            return;
        }
        doOpenBrowserActivity(gdtAd, context);
    }

    private final boolean isMatchFilterClickDayRule(int frequency) {
        if (frequency == 0) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() / 86400000;
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_VAS)");
        long decodeLong = from.decodeLong(KEY_MASK_AD_CLICK_TIME_LAST_DAY + VasUtil.getCurrentUin(), 0L);
        int decodeInt = from.decodeInt(KEY_MASK_AD_CLICK_TIME_DAY_FREQUENCY + VasUtil.getCurrentUin(), 0);
        if (decodeLong != currentTimeMillis || decodeInt < frequency) {
            return false;
        }
        QLog.e(TAG, 1, "is match click filter day rule, totalFrequency :" + decodeInt + " ,ruleFrequency:" + frequency);
        return true;
    }

    private final boolean isMatchFilterClickHourRule(int frequency) {
        if (frequency == 0) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() / 3600000;
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_VAS)");
        long decodeLong = from.decodeLong(KEY_MASK_AD_CLICK_TIME_LAST_HOUR + VasUtil.getCurrentUin(), 0L);
        int decodeInt = from.decodeInt(KEY_MASK_AD_CLICK_TIME_HOUR_FREQUENCY + VasUtil.getCurrentUin(), 0);
        if (decodeLong != currentTimeMillis || decodeInt < frequency) {
            return false;
        }
        QLog.e(TAG, 1, "is match click filter hour rule, totalFrequency :" + decodeInt + " ,ruleFrequency:" + frequency);
        return true;
    }

    private final boolean isMatchFilterClickMinuteRule(int frequency) {
        return isMatchFilterClickSecondRule(60000L, frequency);
    }

    private final boolean isMatchFilterClickSecondRule(long duration, int frequency) {
        TreeSet sortedSetOf;
        SortedSet sortedSet;
        List drop;
        Object first;
        if (duration == 0 || frequency == 0) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_VAS)");
        String str = KEY_MASK_AD_CLICK_TIMESTAMPS + VasUtil.getCurrentUin();
        sortedSetOf = SetsKt__SetsJVMKt.sortedSetOf(new String[0]);
        Set<String> decodeStringSet = from.decodeStringSet(str, sortedSetOf);
        Intrinsics.checkNotNullExpressionValue(decodeStringSet, "entity.decodeStringSet(K\u2026rentUin(), sortedSetOf())");
        sortedSet = CollectionsKt___CollectionsJvmKt.toSortedSet(decodeStringSet);
        if (sortedSet.size() >= frequency) {
            drop = CollectionsKt___CollectionsKt.drop(sortedSet, sortedSet.size() - frequency);
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) drop);
            Intrinsics.checkNotNullExpressionValue(first, "validTimeStamps.first()");
            if (currentTimeMillis - Long.parseLong((String) first) > duration) {
                return false;
            }
            QLog.e(TAG, 1, "is match click filter second rule, durantion :" + duration + ", frequency :" + frequency + ", cached timeStamps size: " + sortedSet.size());
            return true;
        }
        return false;
    }

    private final void updateClickTimeInfoCache() {
        long currentTimeMillis = System.currentTimeMillis();
        updateSecondClickTimeStamps(currentTimeMillis);
        updateHourClickTimeFrequency(currentTimeMillis);
        updateDayClickTimeFrequency(currentTimeMillis);
    }

    private final void updateDayClickTimeFrequency(long clickTime) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_VAS)");
        long j3 = clickTime / 86400000;
        long decodeLong = from.decodeLong(KEY_MASK_AD_CLICK_TIME_LAST_DAY + VasUtil.getCurrentUin(), 0L);
        int decodeInt = from.decodeInt(KEY_MASK_AD_CLICK_TIME_DAY_FREQUENCY + VasUtil.getCurrentUin(), 0);
        int i3 = 1;
        if (decodeLong == j3) {
            i3 = 1 + decodeInt;
        }
        from.encodeLong(KEY_MASK_AD_CLICK_TIME_LAST_DAY + VasUtil.getCurrentUin(), j3);
        from.encodeInt(KEY_MASK_AD_CLICK_TIME_DAY_FREQUENCY + VasUtil.getCurrentUin(), i3);
    }

    private final void updateHourClickTimeFrequency(long clickTime) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_VAS)");
        long j3 = clickTime / 3600000;
        long decodeLong = from.decodeLong(KEY_MASK_AD_CLICK_TIME_LAST_HOUR + VasUtil.getCurrentUin(), 0L);
        int decodeInt = from.decodeInt(KEY_MASK_AD_CLICK_TIME_HOUR_FREQUENCY + VasUtil.getCurrentUin(), 0);
        int i3 = 1;
        if (decodeLong == j3) {
            i3 = 1 + decodeInt;
        }
        from.encodeLong(KEY_MASK_AD_CLICK_TIME_LAST_HOUR + VasUtil.getCurrentUin(), j3);
        from.encodeInt(KEY_MASK_AD_CLICK_TIME_HOUR_FREQUENCY + VasUtil.getCurrentUin(), i3);
    }

    private final void updateSecondClickTimeStamps(long clickTime) {
        TreeSet sortedSetOf;
        SortedSet sortedSet;
        List drop;
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_VAS)");
        String str = KEY_MASK_AD_CLICK_TIMESTAMPS + VasUtil.getCurrentUin();
        sortedSetOf = SetsKt__SetsJVMKt.sortedSetOf(new String[0]);
        Set<String> decodeStringSet = from.decodeStringSet(str, sortedSetOf);
        Intrinsics.checkNotNullExpressionValue(decodeStringSet, "entity.decodeStringSet(K\u2026rentUin(), sortedSetOf())");
        sortedSet = CollectionsKt___CollectionsJvmKt.toSortedSet(decodeStringSet);
        sortedSet.add(String.valueOf(clickTime));
        if (sortedSet.size() > mMaxCacheTimeStampNum) {
            drop = CollectionsKt___CollectionsKt.drop(sortedSet, sortedSet.size() - mMaxCacheTimeStampNum);
            sortedSet = CollectionsKt___CollectionsJvmKt.toSortedSet(drop);
        }
        from.encodeStringSet(KEY_MASK_AD_CLICK_TIMESTAMPS + VasUtil.getCurrentUin(), sortedSet);
    }

    public final boolean checkIsNeedAddClickArea(@Nullable GdtAd ad5) {
        List<qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ActionAreaItem> list;
        if (ad5 != null) {
            list = ad5.getActionAreaItems();
        } else {
            list = null;
        }
        if (list != null) {
            return true;
        }
        return false;
    }

    public final void handleTianShuAdClick(@Nullable GdtAd gdtAd, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String str = null;
        if (gdtAd != null) {
            str = gdtAd.getAppDeeplink(null);
        }
        if (!TextUtils.isEmpty(str)) {
            doOpenDeepLink(gdtAd, context);
        } else {
            doOpenBrowserActivity(gdtAd, context);
        }
    }

    public final boolean isClickValid() {
        boolean z16;
        MaskAdConfigBean maskAdConfigBean = (MaskAdConfigBean) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MaskAdConfigParser.GROUP_ID);
        if (maskAdConfigBean == null) {
            maskAdConfigBean = new MaskAdConfigBean();
        }
        long maskAdClickSecondDuration = maskAdConfigBean.getMaskAdClickSecondDuration();
        int maskAdClickSecondFrequency = maskAdConfigBean.getMaskAdClickSecondFrequency();
        int maskAdClickMinuteFrequency = maskAdConfigBean.getMaskAdClickMinuteFrequency();
        int maskAdClickHourFrequency = maskAdConfigBean.getMaskAdClickHourFrequency();
        int maskAdClickDayFrequency = maskAdConfigBean.getMaskAdClickDayFrequency();
        mMaxCacheTimeStampNum = Math.min(Math.max(maskAdClickSecondFrequency, maskAdClickMinuteFrequency), 60);
        if (!isMatchFilterClickSecondRule(maskAdClickSecondDuration, maskAdClickSecondFrequency) && !isMatchFilterClickMinuteRule(maskAdClickMinuteFrequency) && !isMatchFilterClickHourRule(maskAdClickHourFrequency) && !isMatchFilterClickDayRule(maskAdClickDayFrequency)) {
            z16 = true;
        } else {
            z16 = false;
        }
        updateClickTimeInfoCache();
        return z16;
    }

    public final boolean isImageAd(int adType) {
        if (adType != 50 && adType != 49) {
            return false;
        }
        return true;
    }

    public final boolean isMaskAd(int adType) {
        if (adType != 50 && adType != 49 && adType != 36 && adType != 35) {
            return false;
        }
        return true;
    }
}
