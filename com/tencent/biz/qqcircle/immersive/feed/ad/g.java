package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.content.Context;
import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.inject.GdtThirdProcessorProxy;
import com.tencent.gdtad.statistics.GdtOriginalExposureReporter;
import com.tencent.gdtad.util.GdtAntiSpamReportHelper;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b!\u0010\"J.\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J6\u0010\r\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J8\u0010\u000e\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J,\u0010\u000f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ6\u0010\u0010\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u0011\u001a\u00020\nJ\u0006\u0010\u0012\u001a\u00020\nJ\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001f\u00a8\u0006$"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/ad/g;", "", "Lcom/tencent/gdtad/aditem/GdtAd;", "ad", "Landroid/view/View;", "view", "", "feedPosition", "Lcom/tencent/biz/qqcircle/beans/QCircleExtraTypeInfo;", "extraTypeInfo", "", "e", "antiSpamReportView", "c", "l", "i", "j", tl.h.F, "g", "Landroid/content/Context;", "context", "f", "Lcom/tencent/gdtad/inject/GdtThirdProcessorProxy;", "a", "Lcom/tencent/gdtad/inject/GdtThirdProcessorProxy;", "mProcessorProxy", "Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", "b", "Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", "mExposureCallback", "Lcom/tencent/ad/tangram/util/AdExposureChecker;", "Lcom/tencent/ad/tangram/util/AdExposureChecker;", "mExposureChecker", "<init>", "()V", "d", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class g {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final a f85706d = new a(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GdtThirdProcessorProxy mProcessorProxy = new GdtThirdProcessorProxy();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AdExposureChecker.ExposureCallback mExposureCallback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AdExposureChecker mExposureChecker;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/ad/g$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    private final void c(final GdtAd ad5, View view, int feedPosition, final View antiSpamReportView, final QCircleExtraTypeInfo extraTypeInfo) {
        final qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        String str;
        String str2 = null;
        if (ad5 != null) {
            adInfo = ad5.info;
        } else {
            adInfo = null;
        }
        if (adInfo == null) {
            QLog.e("QFSAdExposureChecker", 1, "origin expose cancel, adInfo is null");
            return;
        }
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo = adInfo.report_info;
        if (reportInfo != null && (pBStringField2 = reportInfo.exposure_url) != null && (str = pBStringField2.get()) != null) {
            str2 = com.tencent.biz.qqcircle.immersive.utils.j.f90213a.S(str, feedPosition);
        }
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo2 = adInfo.report_info;
        if (reportInfo2 != null && (pBStringField = reportInfo2.exposure_url) != null) {
            pBStringField.set(str2);
        }
        this.mExposureChecker = new AdExposureChecker(ad5, new WeakReference(view));
        this.mExposureCallback = new AdExposureChecker.ExposureCallback() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.f
            @Override // com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
            public final void onExposure(WeakReference weakReference) {
                g.d(GdtAd.this, antiSpamReportView, adInfo, this, extraTypeInfo, weakReference);
            }
        };
        AdExposureChecker adExposureChecker = this.mExposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.setCallback(new WeakReference<>(this.mExposureCallback));
        }
        AdExposureChecker adExposureChecker2 = this.mExposureChecker;
        if (adExposureChecker2 != null) {
            adExposureChecker2.startCheck();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(GdtAd gdtAd, View view, qq_ad_get.QQAdGetRsp.AdInfo adInfo, g this$0, QCircleExtraTypeInfo qCircleExtraTypeInfo, WeakReference weakReference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("QFSAdExposureChecker", 1, "exposure callback success, traceId: " + gdtAd.getTraceId());
        String adAntiSpamForExpoParams = GdtAntiSpamReportHelper.getAdAntiSpamForExpoParams(view);
        com.tencent.biz.qqcircle.immersive.utils.j jVar = com.tencent.biz.qqcircle.immersive.utils.j.f90213a;
        String str = adInfo.report_info.exposure_url.get();
        Intrinsics.checkNotNullExpressionValue(str, "adInfo.report_info.exposure_url.get()");
        String R = jVar.R(str, adAntiSpamForExpoParams);
        com.tencent.biz.qqcircle.immersive.utils.d dVar = com.tencent.biz.qqcircle.immersive.utils.d.f90201a;
        dVar.d(R);
        this$0.mProcessorProxy.c2sReportAsync(0, 4, adInfo);
        dVar.h(400, 6, qCircleExtraTypeInfo, 1);
    }

    private final void e(GdtAd ad5, View view, int feedPosition, QCircleExtraTypeInfo extraTypeInfo) {
        PBStringField pBStringField;
        String str;
        String S;
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo;
        PBStringField pBStringField2;
        String str2;
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo2;
        PBStringField pBStringField3;
        if (ad5 != null && ad5.isValid() && view != null) {
            com.tencent.biz.qqcircle.immersive.utils.j jVar = com.tencent.biz.qqcircle.immersive.utils.j.f90213a;
            if (jVar.f(ad5.getTraceId())) {
                QLog.e("QFSAdExposureChecker", 1, "ad has Exposed, cancel expose");
                return;
            }
            String traceId = ad5.getTraceId();
            if (traceId != null) {
                jVar.Q(traceId, ad5.getAId());
            }
            com.tencent.biz.qqcircle.immersive.utils.d dVar = com.tencent.biz.qqcircle.immersive.utils.d.f90201a;
            dVar.h(400, 1, extraTypeInfo, 1);
            qq_ad_get.QQAdGetRsp.AdInfo adInfo = ad5.info;
            if (adInfo != null) {
                try {
                    qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo3 = adInfo.report_info;
                    if (reportInfo3 != null && (pBStringField = reportInfo3.original_exposure_url) != null && (str = pBStringField.get()) != null) {
                        S = jVar.S(str, feedPosition);
                        if (adInfo != null && (reportInfo2 = adInfo.report_info) != null && (pBStringField3 = reportInfo2.original_exposure_url) != null) {
                            pBStringField3.set(S);
                        }
                        if (adInfo != null && (reportInfo = adInfo.report_info) != null && (pBStringField2 = reportInfo.original_exposure_url) != null && (str2 = pBStringField2.get()) != null) {
                            String replaceUrlMacros = GdtOriginalExposureReporter.replaceUrlMacros(str2, adInfo.product_type.get(), view.getContext(), adInfo.app_info.app_package_name.get());
                            Intrinsics.checkNotNullExpressionValue(replaceUrlMacros, "replaceUrlMacros(\n      \u2026t()\n                    )");
                            dVar.d(replaceUrlMacros);
                        }
                        dVar.f(ad5, 0, feedPosition);
                        return;
                    }
                } catch (Throwable th5) {
                    QLog.i("QFSAdExposureChecker", 1, "reportAdExpose failed, error is = ", th5);
                    return;
                }
            }
            S = null;
            if (adInfo != null) {
                pBStringField3.set(S);
            }
            if (adInfo != null) {
                String replaceUrlMacros2 = GdtOriginalExposureReporter.replaceUrlMacros(str2, adInfo.product_type.get(), view.getContext(), adInfo.app_info.app_package_name.get());
                Intrinsics.checkNotNullExpressionValue(replaceUrlMacros2, "replaceUrlMacros(\n      \u2026t()\n                    )");
                dVar.d(replaceUrlMacros2);
            }
            dVar.f(ad5, 0, feedPosition);
            return;
        }
        QLog.e("QFSAdExposureChecker", 1, "expose cancel, adInfo is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(g this$0, GdtAd gdtAd, View view, int i3, QCircleExtraTypeInfo qCircleExtraTypeInfo, View view2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e(gdtAd, view, i3, qCircleExtraTypeInfo);
        this$0.l(gdtAd, view, i3, view2, qCircleExtraTypeInfo);
    }

    private final void l(GdtAd ad5, View view, int feedPosition, View antiSpamReportView, QCircleExtraTypeInfo extraTypeInfo) {
        if (ad5 != null && ad5.isValid() && view != null) {
            c(ad5, view, feedPosition, antiSpamReportView, extraTypeInfo);
        } else {
            QLog.e("QFSAdExposureChecker", 1, "expose checker cancel, adInfo is null");
        }
    }

    public final void f(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AdExposureChecker adExposureChecker = this.mExposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.setCallback(null);
            adExposureChecker.onActivityDestroy();
        }
    }

    public final void g() {
        AdExposureChecker adExposureChecker = this.mExposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.onActivityPause();
        }
    }

    public final void h() {
        AdExposureChecker adExposureChecker = this.mExposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.onActivityResume();
        }
    }

    public final void i(@Nullable GdtAd ad5, @Nullable View view, int feedPosition, @Nullable QCircleExtraTypeInfo extraTypeInfo) {
        j(ad5, view, feedPosition, extraTypeInfo, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x001e, code lost:
    
        if (r10.getExperimentIntegerParam(123299, 1) == 1) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j(@Nullable final GdtAd ad5, @Nullable final View view, final int feedPosition, @Nullable final QCircleExtraTypeInfo extraTypeInfo, @Nullable final View antiSpamReportView) {
        boolean z16;
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.e
            @Override // java.lang.Runnable
            public final void run() {
                g.k(g.this, ad5, view, feedPosition, extraTypeInfo, antiSpamReportView);
            }
        });
        if (ad5 != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            com.tencent.biz.qqcircle.immersive.utils.ad.e.g(0);
        }
    }
}
