package com.qzone.reborn.feedx.presenter.ad;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.GdtAdFeedUtil;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\t\u001a\u00020\bH\u0014J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0014\u0010\u0019\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R$\u0010!\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010)\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u00100\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0016\u00103\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00102\u00a8\u00066"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/f;", "Lvg/a;", "", "I", "", "k", "", ReportConstant.COSTREPORT_PREFIX, "", HippyTKDListViewAdapter.X, "Landroid/view/View;", "containerView", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "c", "onPaused", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "onViewHolderAttachedToWindow", "onViewHolderDetachedFromWindow", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "TAG", "Lcom/tencent/ad/tangram/util/AdExposureChecker;", "G", "Lcom/tencent/ad/tangram/util/AdExposureChecker;", "getMAdExposureChecker", "()Lcom/tencent/ad/tangram/util/AdExposureChecker;", "setMAdExposureChecker", "(Lcom/tencent/ad/tangram/util/AdExposureChecker;)V", "mAdExposureChecker", "Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", "H", "Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", "getMCallBack", "()Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", "setMCallBack", "(Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;)V", "mCallBack", "Lcom/tencent/gdtad/aditem/GdtAd;", "Lcom/tencent/gdtad/aditem/GdtAd;", "getMAd", "()Lcom/tencent/gdtad/aditem/GdtAd;", "setMAd", "(Lcom/tencent/gdtad/aditem/GdtAd;)V", "mAd", "", "J", "mExposeTime", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class f extends vg.a {

    /* renamed from: F, reason: from kotlin metadata */
    private final String TAG = "QZoneAdFeedExposePresenter";

    /* renamed from: G, reason: from kotlin metadata */
    private AdExposureChecker mAdExposureChecker;

    /* renamed from: H, reason: from kotlin metadata */
    private AdExposureChecker.ExposureCallback mCallBack;

    /* renamed from: I, reason: from kotlin metadata */
    private GdtAd mAd;

    /* renamed from: J, reason: from kotlin metadata */
    private long mExposeTime;

    private final void I() {
        boolean contains;
        this.mExposeTime = System.currentTimeMillis();
        GdtAd gdtAd = new GdtAd(GdtFeedUtilForQZone.f(this.f441565h));
        QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
        contains = CollectionsKt___CollectionsKt.contains(qZoneAdFeedUtils.t(), gdtAd.getTraceId());
        if (contains) {
            GdtLog.e(this.TAG, "[doOriginalExposureReport] cancel, has exposed");
            return;
        }
        String traceId = gdtAd.getTraceId();
        if (traceId != null) {
            com.tencent.gdtad.util.e.a(qZoneAdFeedUtils.t(), traceId);
        }
        GdtAdFeedUtil.doOriginalExposureReport(this.f441565h, this.f441562d.getContext(), this.f441567m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(f this$0, GdtAd adData, WeakReference weakReference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adData, "$adData");
        if (weakReference == null) {
            return;
        }
        GdtAdFeedUtil.doEffectiveExposureReport(this$0.f441565h, this$0.f441567m, 0);
        GdtLog.e(this$0.TAG, "[doEffectiveExposureReport], traceId: " + adData.getTraceId());
    }

    @Override // vg.a
    protected void A(BusinessFeedData feedData) {
        final GdtAd gdtAd = new GdtAd(GdtFeedUtilForQZone.f(this.f441565h));
        QLog.d(this.TAG, 1, "ad aid is " + gdtAd.getAId() + " traceId is " + gdtAd.getTraceId());
        this.mExposeTime = 0L;
        GdtAd gdtAd2 = this.mAd;
        if (!Intrinsics.areEqual(gdtAd2 != null ? gdtAd2.getTraceId() : null, gdtAd.getTraceId())) {
            this.mAdExposureChecker = new AdExposureChecker(gdtAd, new WeakReference(this.f441563e));
            this.mCallBack = new AdExposureChecker.ExposureCallback() { // from class: com.qzone.reborn.feedx.presenter.ad.e
                @Override // com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
                public final void onExposure(WeakReference weakReference) {
                    f.J(f.this, gdtAd, weakReference);
                }
            };
            AdExposureChecker adExposureChecker = this.mAdExposureChecker;
            if (adExposureChecker != null) {
                adExposureChecker.setCallback(new WeakReference<>(this.mCallBack));
            }
        }
        this.mAd = gdtAd;
        AdExposureChecker adExposureChecker2 = this.mAdExposureChecker;
        if (adExposureChecker2 != null) {
            adExposureChecker2.startCheck();
        }
        QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
        View mRootView = this.f441563e;
        Intrinsics.checkNotNullExpressionValue(mRootView, "mRootView");
        if (qZoneAdFeedUtils.J(mRootView, 0.01f)) {
            I();
        }
    }

    @Override // vg.a, vg.c
    public void c() {
        String traceId;
        super.c();
        GdtAd gdtAd = this.mAd;
        if (gdtAd != null && (traceId = gdtAd.getTraceId()) != null) {
            com.tencent.gdtad.util.e.b(com.tencent.gdtad.util.j.f109555a.e(), traceId, Long.valueOf(System.currentTimeMillis()));
        }
        AdExposureChecker adExposureChecker = this.mAdExposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.onActivityResume();
        }
        if (this.mExposeTime != 0) {
            this.mExposeTime = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k, reason: from getter */
    public String getTAG() {
        return this.TAG;
    }

    @Override // vg.a, vg.c
    public void onDestroy() {
        super.onDestroy();
        AdExposureChecker adExposureChecker = this.mAdExposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.onActivityDestroy();
        }
    }

    @Override // vg.a, vg.c
    public void onPaused() {
        super.onPaused();
        AdExposureChecker adExposureChecker = this.mAdExposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.onActivityPause();
        }
        com.tencent.biz.qqcircle.immersive.utils.d.f90201a.j(QZoneAdFeedUtils.f55717a.o(this.f441565h, "imp_stay_report_url"), this.mExposeTime, System.currentTimeMillis());
    }

    @Override // vg.a, vg.c
    public void onViewHolderAttachedToWindow(RecyclerView.ViewHolder holder) {
        String traceId;
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewHolderAttachedToWindow(holder);
        GdtAd gdtAd = this.mAd;
        if (gdtAd != null && (traceId = gdtAd.getTraceId()) != null) {
            com.tencent.gdtad.util.e.b(com.tencent.gdtad.util.j.f109555a.e(), traceId, Long.valueOf(System.currentTimeMillis()));
        }
        AdExposureChecker adExposureChecker = this.mAdExposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.onActivityResume();
        }
        I();
    }

    @Override // vg.a, vg.c
    public void onViewHolderDetachedFromWindow(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewHolderDetachedFromWindow(holder);
        com.tencent.biz.qqcircle.immersive.utils.d.f90201a.j(QZoneAdFeedUtils.f55717a.o(this.f441565h, "imp_stay_report_url"), this.mExposeTime, System.currentTimeMillis());
    }

    @Override // vg.a
    protected int s() {
        return R.id.nmu;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    protected void C(View containerView) {
    }
}
