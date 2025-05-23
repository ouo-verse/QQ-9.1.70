package com.tencent.biz.pubaccount.weishi.util;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.inject.GdtThirdProcessorProxy;
import com.tencent.gdtad.statistics.GdtOriginalExposureReporter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tencent.gdt.access;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J$\u0010\u000f\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010J\u001e\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001aR&\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u001cj\b\u0012\u0004\u0012\u00020\u0010`\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/util/f;", "", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "Landroid/view/View;", "view", "", "b", "Landroid/content/Context;", "context", "d", "c", "ad", "Ltencent/gdt/access$UserActionReportInfo;", "userActionReportInfo", "g", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_URL, "e", "", "operationType", "businessType", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "info", tl.h.F, "Lcom/tencent/gdtad/inject/GdtThirdProcessorProxy;", "Lcom/tencent/gdtad/inject/GdtThirdProcessorProxy;", "mProcessorProxy", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "mExposedAdSet", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f81762a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final GdtThirdProcessorProxy mProcessorProxy = new GdtThirdProcessorProxy();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static HashSet<String> mExposedAdSet = new HashSet<>();

    f() {
    }

    private final void d(GdtAd gdtAd, Context context) {
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).preLoadAfterAdLoaded(context, gdtAd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(String reportUrl) {
        Intrinsics.checkNotNullParameter(reportUrl, "$reportUrl");
        try {
            URLConnection openConnection = new URL(reportUrl).openConnection();
            Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.connect();
            QLog.i("WSAdReportUtils", 1, "reportAd rspCode" + httpURLConnection.getResponseCode());
        } catch (Throwable th5) {
            QLog.i("WSAdReportUtils", 1, "reportAd error, url = " + reportUrl, th5);
        }
    }

    public final void e(final String reportUrl) {
        Intrinsics.checkNotNullParameter(reportUrl, "reportUrl");
        if (TextUtils.isEmpty(reportUrl)) {
            QLog.e("WSAdReportUtils", 1, "reportAd cancel, url is empty");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.util.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.f(reportUrl);
                }
            }, 128, null, false);
        }
    }

    public final void h(int operationType, int businessType, qq_ad_get.QQAdGetRsp.AdInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        mProcessorProxy.c2sReportAsync(operationType, businessType, info);
    }

    public final void g(GdtAd ad5, View view, access.UserActionReportInfo userActionReportInfo) {
        boolean contains;
        PBStringField pBStringField;
        String str;
        if (ad5 != null && ad5.isValid() && view != null) {
            if (mExposedAdSet.size() > 200) {
                mExposedAdSet.clear();
            }
            contains = CollectionsKt___CollectionsKt.contains(mExposedAdSet, ad5.getTraceId());
            if (contains) {
                return;
            }
            d(ad5, view.getContext());
            String traceId = ad5.getTraceId();
            if (traceId != null) {
                mExposedAdSet.add(traceId);
            }
            qq_ad_get.QQAdGetRsp.AdInfo adInfo = ad5.info;
            if (adInfo != null) {
                try {
                    qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo = adInfo.report_info;
                    if (reportInfo != null && (pBStringField = reportInfo.original_exposure_url) != null && (str = pBStringField.get()) != null) {
                        f fVar = f81762a;
                        String replaceUrlMacros = GdtOriginalExposureReporter.replaceUrlMacros(str, adInfo.product_type.get(), view.getContext(), adInfo.app_info.app_package_name.get());
                        Intrinsics.checkNotNullExpressionValue(replaceUrlMacros, "replaceUrlMacros(\n      \u2026                        )");
                        fVar.e(replaceUrlMacros);
                    }
                } catch (Throwable th5) {
                    QLog.i("WSAdReportUtils", 1, "reportAdExpose failed, error is = ", th5);
                    return;
                }
            }
            if (userActionReportInfo != null) {
                f fVar2 = f81762a;
                String str2 = userActionReportInfo.exposure_url.get();
                Intrinsics.checkNotNullExpressionValue(str2, "it.exposure_url.get()");
                fVar2.e(str2);
                return;
            }
            return;
        }
        QLog.e("WSAdReportUtils", 1, "expose cancel, adInfo is null");
    }

    public final void c(GdtAd gdtAd, View view) {
        if (gdtAd == null || !gdtAd.isValid()) {
            QLog.d("WSAdReportUtils", 1, "ad is inValid, cancel open landing page");
        }
        b(gdtAd, view);
    }

    private final void b(GdtAd gdtAd, View view) {
        Context context = view != null ? view.getContext() : null;
        GdtHandler.Params params = new GdtHandler.Params();
        params.f108486ad = gdtAd;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        params.activity = new WeakReference<>((Activity) context);
        Bundle bundle = new Bundle();
        params.extra = bundle;
        bundle.putString(LaunchParam.KEY_REF_ID, "biz_src_gzh_weishi");
        params.directPlay = true;
        params.videoCeilingSupportedIfNotInstalled = true;
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(params);
        mProcessorProxy.c2sReportAsync(1, 0, gdtAd != null ? gdtAd.info : null);
    }
}
