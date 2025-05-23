package com.tencent.mobileqq.vas.adv.maskad;

import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.vas.adv.common.data.MaskAdvName;
import com.tencent.mobileqq.weather.api.IWeatherReportApi;
import com.tencent.open.agent.api.IOpenAuthTelemetryReportMgr;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rJ.\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004J\u0010\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004J&\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R2\u0010\u0005\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00040\u0004 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/maskad/MaskAdReportHelper;", "", "()V", "TAG", "", "mValidExpoReportedData", "", "kotlin.jvm.PlatformType", "", "clearExpoCache", "", "doValidExpo", "ad", "Lcom/tencent/gdtad/aditem/GdtAd;", IOpenAuthTelemetryReportMgr.KEY_REPORT_ACTION, "ext2", "ext3", "ext4", "ext6", "reportAdByUrl", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_URL, "reportWeatherHealthAction", "aid", "source", "Lcom/tencent/mobileqq/vas/adv/common/data/MaskAdvName;", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class MaskAdReportHelper {

    @NotNull
    private static final String TAG = "MaskAdReportHelper";

    @NotNull
    public static final MaskAdReportHelper INSTANCE = new MaskAdReportHelper();
    private static final Set<String> mValidExpoReportedData = Collections.synchronizedSet(new HashSet());

    MaskAdReportHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportAdByUrl$lambda$0(String str) {
        try {
            URLConnection openConnection = new URL(str).openConnection();
            Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.connect();
            QLog.i(TAG, 1, "reportAd rspCode" + httpURLConnection.getResponseCode());
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "reportAd error, url = " + str, th5);
        }
    }

    public final void clearExpoCache() {
        mValidExpoReportedData.clear();
    }

    public final void doValidExpo(@NotNull GdtAd ad5) {
        Intrinsics.checkNotNullParameter(ad5, "ad");
        if (!ad5.isValid()) {
            return;
        }
        String str = ad5.getTraceId() + util.base64_pad_url + ad5.getAId();
        Set<String> set = mValidExpoReportedData;
        if (set.contains(str)) {
            QLog.d(TAG, 2, "doValidExpo return:" + str);
            return;
        }
        GdtReporter.doCgiReport(ad5.getUrlForImpression());
        QLog.d(TAG, 2, "doValidExpo:" + str);
        set.add(str);
    }

    public final void reportAction(@NotNull String reportAction, @NotNull String ext2, @NotNull String ext3, @NotNull String ext4, @NotNull String ext6) {
        Intrinsics.checkNotNullParameter(reportAction, "reportAction");
        Intrinsics.checkNotNullParameter(ext2, "ext2");
        Intrinsics.checkNotNullParameter(ext3, "ext3");
        Intrinsics.checkNotNullParameter(ext4, "ext4");
        Intrinsics.checkNotNullParameter(ext6, "ext6");
        ((IWeatherReportApi) QRoute.api(IWeatherReportApi.class)).reportMaskAd(null, reportAction, ext2 + QbAddrData.DATA_SPLITER + ext3 + QbAddrData.DATA_SPLITER + ext4 + QbAddrData.DATA_SPLITER + AppSetting.getSubVersion() + QbAddrData.DATA_SPLITER + ext6);
    }

    public final void reportAdByUrl(@Nullable final String reportUrl) {
        boolean z16;
        if (reportUrl != null && reportUrl.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e(TAG, 1, "reportAd cancel, url is empty");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.adv.maskad.f
                @Override // java.lang.Runnable
                public final void run() {
                    MaskAdReportHelper.reportAdByUrl$lambda$0(reportUrl);
                }
            }, 128, null, false);
        }
    }

    public final void reportWeatherHealthAction(@NotNull String reportAction, @NotNull String ext6, @NotNull String aid, @NotNull MaskAdvName source) {
        String str;
        Intrinsics.checkNotNullParameter(reportAction, "reportAction");
        Intrinsics.checkNotNullParameter(ext6, "ext6");
        Intrinsics.checkNotNullParameter(aid, "aid");
        Intrinsics.checkNotNullParameter(source, "source");
        if (source != MaskAdvName.QQ_HEALTH && source != MaskAdvName.QQ_WEATHER) {
            return;
        }
        if (source == MaskAdvName.QQ_WEATHER) {
            str = "1";
        } else {
            str = "2";
        }
        reportAction(reportAction, aid, "", str, ext6);
    }
}
