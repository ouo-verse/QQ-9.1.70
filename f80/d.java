package f80;

import android.text.TextUtils;
import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.biz.qqcircle.immersive.bean.QFSSearchInfo;
import com.tencent.biz.qqcircle.immersive.utils.j;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.statistics.GdtOriginalExposureReporter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B+\u0012\b\u0010\r\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002R\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010!\u00a8\u0006%"}, d2 = {"Lf80/d;", "", "", "f", "d", "j", "l", "i", h.F, "g", "Lcom/tencent/gdtad/aditem/GdtAd;", "a", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "", "b", "I", "adPosition", "Landroid/view/View;", "c", "Landroid/view/View;", "feedWrapper", "Lcom/tencent/biz/qqcircle/immersive/bean/QFSSearchInfo;", "Lcom/tencent/biz/qqcircle/immersive/bean/QFSSearchInfo;", "searchInfo", "", "e", "Ljava/lang/String;", "tag", "Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", "Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", "mExposureCallback", "Lcom/tencent/ad/tangram/util/AdExposureChecker;", "Lcom/tencent/ad/tangram/util/AdExposureChecker;", "mExposureChecker", "<init>", "(Lcom/tencent/gdtad/aditem/GdtAd;ILandroid/view/View;Lcom/tencent/biz/qqcircle/immersive/bean/QFSSearchInfo;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GdtAd gdtAd;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int adPosition;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View feedWrapper;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QFSSearchInfo searchInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tag;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AdExposureChecker.ExposureCallback mExposureCallback;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AdExposureChecker mExposureChecker;

    public d(@Nullable GdtAd gdtAd, int i3, @NotNull View feedWrapper, @Nullable QFSSearchInfo qFSSearchInfo) {
        Intrinsics.checkNotNullParameter(feedWrapper, "feedWrapper");
        this.gdtAd = gdtAd;
        this.adPosition = i3;
        this.feedWrapper = feedWrapper;
        this.searchInfo = qFSSearchInfo;
        this.tag = "ItemViewAdExpose";
    }

    private final void d() {
        final qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        GdtAd gdtAd = this.gdtAd;
        if (gdtAd != null) {
            adInfo = gdtAd.info;
        } else {
            adInfo = null;
        }
        if (adInfo == null) {
            QLog.e(this.tag, 1, "origin expose cancel, adInfo is null");
            return;
        }
        this.mExposureChecker = new AdExposureChecker(gdtAd, new WeakReference(this.feedWrapper));
        this.mExposureCallback = new AdExposureChecker.ExposureCallback() { // from class: f80.c
            @Override // com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
            public final void onExposure(WeakReference weakReference) {
                d.e(qq_ad_get.QQAdGetRsp.AdInfo.this, weakReference);
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
    public static final void e(qq_ad_get.QQAdGetRsp.AdInfo adInfo, WeakReference weakReference) {
        com.tencent.biz.qqcircle.immersive.utils.d dVar = com.tencent.biz.qqcircle.immersive.utils.d.f90201a;
        String str = adInfo.report_info.exposure_url.get();
        Intrinsics.checkNotNullExpressionValue(str, "adInfo.report_info.exposure_url.get()");
        dVar.d(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00a7 A[Catch: all -> 0x0037, TRY_LEAVE, TryCatch #0 {all -> 0x0037, blocks: (B:54:0x0020, B:56:0x0024, B:58:0x0028, B:60:0x002e, B:15:0x003d, B:17:0x0041, B:19:0x0045, B:21:0x004b, B:23:0x0055, B:25:0x0059, B:27:0x005d, B:29:0x0062, B:31:0x0066, B:33:0x006a, B:35:0x006f, B:37:0x0073, B:39:0x0077, B:41:0x007d, B:42:0x00a0, B:44:0x00a7), top: B:53:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void f() {
        boolean z16;
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        PBStringField pBStringField;
        String str;
        String S;
        GdtAd gdtAd;
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo;
        PBStringField pBStringField2;
        String str2;
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo2;
        PBStringField pBStringField3;
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo3;
        PBStringField pBStringField4;
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo4;
        PBStringField pBStringField5;
        String str3;
        GdtAd gdtAd2 = this.gdtAd;
        if (gdtAd2 != null) {
            if (gdtAd2 != null && !gdtAd2.isValid()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                GdtAd gdtAd3 = this.gdtAd;
                String str4 = null;
                if (gdtAd3 != null) {
                    adInfo = gdtAd3.info;
                } else {
                    adInfo = null;
                }
                if (adInfo != null) {
                    try {
                        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo5 = adInfo.report_info;
                        if (reportInfo5 != null && (pBStringField = reportInfo5.original_exposure_url) != null && (str = pBStringField.get()) != null) {
                            S = j.f90213a.S(str, this.adPosition);
                            if (adInfo != null && (reportInfo4 = adInfo.report_info) != null && (pBStringField5 = reportInfo4.exposure_url) != null && (str3 = pBStringField5.get()) != null) {
                                str4 = j.f90213a.S(str3, this.adPosition);
                            }
                            if (adInfo != null && (reportInfo3 = adInfo.report_info) != null && (pBStringField4 = reportInfo3.original_exposure_url) != null) {
                                pBStringField4.set(S);
                            }
                            if (adInfo != null && (reportInfo2 = adInfo.report_info) != null && (pBStringField3 = reportInfo2.exposure_url) != null) {
                                pBStringField3.set(str4);
                            }
                            if (adInfo != null && (reportInfo = adInfo.report_info) != null && (pBStringField2 = reportInfo.original_exposure_url) != null && (str2 = pBStringField2.get()) != null) {
                                com.tencent.biz.qqcircle.immersive.utils.d dVar = com.tencent.biz.qqcircle.immersive.utils.d.f90201a;
                                String replaceUrlMacros = GdtOriginalExposureReporter.replaceUrlMacros(str2, adInfo.product_type.get(), this.feedWrapper.getContext(), adInfo.app_info.app_package_name.get());
                                Intrinsics.checkNotNullExpressionValue(replaceUrlMacros, "replaceUrlMacros(\n      \u2026t()\n                    )");
                                dVar.d(replaceUrlMacros);
                            }
                            d();
                            gdtAd = this.gdtAd;
                            if (gdtAd == null) {
                                com.tencent.biz.qqcircle.immersive.utils.d.f90201a.f(gdtAd, 0, this.adPosition);
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th5) {
                        QLog.w(this.tag, 1, "reportAdExpose failed, error is = ", th5);
                        return;
                    }
                }
                S = null;
                if (adInfo != null) {
                    str4 = j.f90213a.S(str3, this.adPosition);
                }
                if (adInfo != null) {
                    pBStringField4.set(S);
                }
                if (adInfo != null) {
                    pBStringField3.set(str4);
                }
                if (adInfo != null) {
                    com.tencent.biz.qqcircle.immersive.utils.d dVar2 = com.tencent.biz.qqcircle.immersive.utils.d.f90201a;
                    String replaceUrlMacros2 = GdtOriginalExposureReporter.replaceUrlMacros(str2, adInfo.product_type.get(), this.feedWrapper.getContext(), adInfo.app_info.app_package_name.get());
                    Intrinsics.checkNotNullExpressionValue(replaceUrlMacros2, "replaceUrlMacros(\n      \u2026t()\n                    )");
                    dVar2.d(replaceUrlMacros2);
                }
                d();
                gdtAd = this.gdtAd;
                if (gdtAd == null) {
                }
            }
        }
        QLog.e(this.tag, 1, "expose cancel, adInfo is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f();
    }

    public final void g() {
        AdExposureChecker adExposureChecker = this.mExposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.setCallback(null);
            adExposureChecker.onActivityDestroy();
        }
    }

    public final void h() {
        AdExposureChecker adExposureChecker = this.mExposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.onActivityPause();
        }
    }

    public final void i() {
        AdExposureChecker adExposureChecker = this.mExposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.onActivityResume();
        }
    }

    public final void j() {
        QFSSearchInfo qFSSearchInfo;
        String str;
        String traceId;
        GdtAd gdtAd;
        ConcurrentHashMap b16;
        if (this.gdtAd != null && (qFSSearchInfo = this.searchInfo) != null) {
            Intrinsics.checkNotNull(qFSSearchInfo);
            ConcurrentHashMap b17 = qFSSearchInfo.b();
            Intrinsics.checkNotNullExpressionValue(b17, "searchInfo!!.exposedAds");
            GdtAd gdtAd2 = this.gdtAd;
            if (gdtAd2 != null) {
                str = gdtAd2.getTraceId();
            } else {
                str = null;
            }
            if (b17.containsKey(str)) {
                return;
            }
            GdtAd gdtAd3 = this.gdtAd;
            if (gdtAd3 != null && (traceId = gdtAd3.getTraceId()) != null && (gdtAd = this.gdtAd) != null) {
                long aId = gdtAd.getAId();
                QFSSearchInfo qFSSearchInfo2 = this.searchInfo;
                if (qFSSearchInfo2 != null && (b16 = qFSSearchInfo2.b()) != null) {
                    b16.put(traceId, Long.valueOf(aId));
                }
                j.f90213a.Q(traceId, aId);
            }
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: f80.b
                @Override // java.lang.Runnable
                public final void run() {
                    d.k(d.this);
                }
            });
        }
    }

    public final void l() {
        String str;
        GdtAd gdtAd = this.gdtAd;
        if (gdtAd != null) {
            str = gdtAd.getTraceId();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: f80.a
            @Override // java.lang.Runnable
            public final void run() {
                d.m(d.this);
            }
        });
    }
}
