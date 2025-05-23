package com.tencent.mobileqq.weather.mvvm;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.weather.data.o;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0004H\u0002J \u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u0006J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0004J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\bR8\u0010\u001d\u001a&\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00040\u0004 \u001a*\u0012\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u001b0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/weather/mvvm/h;", "", "Lcooperation/vip/pb/TianShuAccess$AdItem;", "adItem", "", "type", "", "reportActionId", "", tl.h.F, "Lcom/tencent/mobileqq/tianshu/data/TianShuReportData;", "c", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_URL, "d", "Lcom/tencent/mobileqq/tianshu/data/TianShuGetAdvCallback;", "tianShuGetAdvCallback", "posId", "needCount", "i", "Lcom/tencent/mobileqq/weather/data/o;", "dataItem", "reportLog", "g", "f", "b", "", "kotlin.jvm.PlatformType", "", "Ljava/util/Set;", "mExpoReportedData", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f313416a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Set<String> mExpoReportedData;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33398);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f313416a = new h();
            mExpoReportedData = Collections.synchronizedSet(new HashSet());
        }
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final TianShuReportData c(TianShuAccess.AdItem adItem, String type, int reportActionId) {
        long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        TianShuReportData tianShuReportData = new TianShuReportData();
        tianShuReportData.mTraceId = com.tencent.open.adapter.a.f().l() + "_" + seconds;
        tianShuReportData.mActionId = reportActionId;
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mItemId = String.valueOf(adItem.iAdId.get());
        tianShuReportData.mItemType = type;
        tianShuReportData.mOperTime = seconds;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mAppId = "tianshu.66";
        tianShuReportData.mPageId = "tianshu.66";
        tianShuReportData.mModuleId = "";
        return tianShuReportData;
    }

    private final void d(final String reportUrl) {
        if (TextUtils.isEmpty(reportUrl)) {
            QLog.d("WeatherTianShuManager", 1, "reportUrl is empty");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.weather.mvvm.g
                @Override // java.lang.Runnable
                public final void run() {
                    h.e(reportUrl);
                }
            }, 128, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(String reportUrl) {
        boolean z16;
        Intrinsics.checkNotNullParameter(reportUrl, "$reportUrl");
        try {
            URL url = new URL(reportUrl);
            URLConnection openConnection = url.openConnection();
            Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.d("WeatherTianShuManager", 2, "exposure rspCode ", Integer.valueOf(responseCode), ",request C2S isSuccess:", Boolean.valueOf(z16), ",url:", url);
        } catch (Exception e16) {
            QLog.e("WeatherTianShuManager", 2, e16, new Object[0]);
        }
    }

    private final void h(TianShuAccess.AdItem adItem, String type, int reportActionId) {
        if (adItem != null) {
            ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(f313416a.c(adItem, type, reportActionId));
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            mExpoReportedData.clear();
        }
    }

    public final void f(@NotNull o dataItem, @NotNull String reportLog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) dataItem, (Object) reportLog);
            return;
        }
        Intrinsics.checkNotNullParameter(dataItem, "dataItem");
        Intrinsics.checkNotNullParameter(reportLog, "reportLog");
        h(dataItem.b(), dataItem.m(), 102);
        d(dataItem.j());
        QLog.d("WeatherTianShuManager", 1, "reportClick,", reportLog);
    }

    public final void g(@NotNull o dataItem, @NotNull String reportLog) {
        PBUInt32Field pBUInt32Field;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) dataItem, (Object) reportLog);
            return;
        }
        Intrinsics.checkNotNullParameter(dataItem, "dataItem");
        Intrinsics.checkNotNullParameter(reportLog, "reportLog");
        TianShuAccess.AdItem b16 = dataItem.b();
        if (b16 != null) {
            pBUInt32Field = b16.iAdId;
        } else {
            pBUInt32Field = null;
        }
        String valueOf = String.valueOf(pBUInt32Field);
        if (!TextUtils.isEmpty(valueOf)) {
            Set<String> set = mExpoReportedData;
            if (!set.contains(valueOf)) {
                h(dataItem.b(), dataItem.m(), 101);
                d(dataItem.k());
                set.add(valueOf);
                QLog.d("WeatherTianShuManager", 1, "reportExpose,", reportLog);
                return;
            }
        }
        QLog.d("WeatherTianShuManager", 1, "reportExpose return:", valueOf);
    }

    public final void i(@NotNull TianShuGetAdvCallback tianShuGetAdvCallback, int posId, int needCount) {
        List<TianShuAdPosItemData> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, tianShuGetAdvCallback, Integer.valueOf(posId), Integer.valueOf(needCount));
            return;
        }
        Intrinsics.checkNotNullParameter(tianShuGetAdvCallback, "tianShuGetAdvCallback");
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        tianShuAdPosItemData.mPosId = posId;
        tianShuAdPosItemData.mNeedCnt = needCount;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(tianShuAdPosItemData);
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).requestAdv(listOf, tianShuGetAdvCallback);
    }
}
