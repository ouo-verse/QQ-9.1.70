package me;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0014J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0014\u0010\u0019\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R$\u0010 \u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010(\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u00100\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00067"}, d2 = {"Lme/d;", "Lne/a;", "", UserInfo.SEX_FEMALE, "", tl.h.F, "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "u", "Landroid/view/View;", "containerView", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", HippyTKDListViewAdapter.X, "c", "onPaused", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "onViewHolderAttachedToWindow", "onViewHolderDetachedFromWindow", "E", "Ljava/lang/String;", "TAG", "Lcom/tencent/ad/tangram/util/AdExposureChecker;", "Lcom/tencent/ad/tangram/util/AdExposureChecker;", "getMAdExposureChecker", "()Lcom/tencent/ad/tangram/util/AdExposureChecker;", "setMAdExposureChecker", "(Lcom/tencent/ad/tangram/util/AdExposureChecker;)V", "mAdExposureChecker", "Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", "G", "Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", "getMCallBack", "()Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", "setMCallBack", "(Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;)V", "mCallBack", "Lyd/a;", "H", "Lyd/a;", "getMAdFeedData", "()Lyd/a;", "setMAdFeedData", "(Lyd/a;)V", "mAdFeedData", "", "I", "J", "mExposeTime", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d extends ne.a {

    /* renamed from: E, reason: from kotlin metadata */
    private final String TAG = "QZoneAdFeedExposeSection";

    /* renamed from: F, reason: from kotlin metadata */
    private AdExposureChecker mAdExposureChecker;

    /* renamed from: G, reason: from kotlin metadata */
    private AdExposureChecker.ExposureCallback mCallBack;

    /* renamed from: H, reason: from kotlin metadata */
    private yd.a mAdFeedData;

    /* renamed from: I, reason: from kotlin metadata */
    private long mExposeTime;

    private final void F() {
        this.mExposeTime = System.currentTimeMillis();
        QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
        if (qZoneAdFeedUtils.t().contains(yd.b.l(this.mAdFeedData))) {
            GdtLog.e(this.TAG, "[doOriginalExposureReport] cancel, has exposed");
            return;
        }
        if (yd.b.l(this.mAdFeedData).length() > 0) {
            com.tencent.gdtad.util.e.a(qZoneAdFeedUtils.t(), yd.b.l(this.mAdFeedData));
        }
        qe.a.f428878a.c(this.mAdFeedData, getActivity(), getMPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(yd.a aVar, d this$0, WeakReference weakReference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (weakReference == null) {
            return;
        }
        if (aVar != null) {
            qe.a.f428878a.a(aVar, this$0.getMPosition());
        }
        GdtLog.e(this$0.TAG, "[doEffectiveExposureReport], traceId: " + yd.b.l(aVar));
    }

    @Override // ne.a, vg.c
    public void c() {
        super.c();
        if (yd.b.l(this.mAdFeedData).length() > 0) {
            com.tencent.gdtad.util.e.b(com.tencent.gdtad.util.j.f109555a.e(), yd.b.l(this.mAdFeedData), Long.valueOf(System.currentTimeMillis()));
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
    @Override // ne.a
    /* renamed from: h, reason: from getter */
    public String getTAG() {
        return this.TAG;
    }

    @Override // ne.a, vg.c
    public void onDestroy() {
        super.onDestroy();
        AdExposureChecker adExposureChecker = this.mAdExposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.onActivityDestroy();
        }
    }

    @Override // ne.a, vg.c
    public void onPaused() {
        super.onPaused();
        AdExposureChecker adExposureChecker = this.mAdExposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.onActivityPause();
        }
        com.tencent.biz.qqcircle.immersive.utils.d.f90201a.j(yd.b.f(this.mAdFeedData), this.mExposeTime, System.currentTimeMillis());
    }

    @Override // ne.a, vg.c
    public void onViewHolderAttachedToWindow(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewHolderAttachedToWindow(holder);
        if (yd.b.l(this.mAdFeedData).length() > 0) {
            com.tencent.gdtad.util.e.b(com.tencent.gdtad.util.j.f109555a.e(), yd.b.l(this.mAdFeedData), Long.valueOf(System.currentTimeMillis()));
        }
        AdExposureChecker adExposureChecker = this.mAdExposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.onActivityResume();
        }
        F();
    }

    @Override // ne.a, vg.c
    public void onViewHolderDetachedFromWindow(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewHolderDetachedFromWindow(holder);
        com.tencent.biz.qqcircle.immersive.utils.d.f90201a.j(yd.b.f(this.mAdFeedData), this.mExposeTime, System.currentTimeMillis());
    }

    @Override // ne.a
    protected int q() {
        return R.id.nmu;
    }

    @Override // ne.a
    protected boolean u() {
        return false;
    }

    @Override // ne.a
    protected void x(CommonFeed feedData) {
        final yd.a h16 = xd.c.h(feedData);
        QLog.d(this.TAG, 1, "ad aid is " + yd.b.g(h16) + " traceId is " + yd.b.l(h16));
        this.mExposeTime = 0L;
        yd.a aVar = this.mAdFeedData;
        if (!Intrinsics.areEqual(aVar != null ? yd.b.l(aVar) : null, yd.b.l(h16))) {
            this.mAdExposureChecker = new AdExposureChecker(h16 != null ? h16.getGdtAd() : null, new WeakReference(getMRootView()));
            this.mCallBack = new AdExposureChecker.ExposureCallback() { // from class: me.c
                @Override // com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
                public final void onExposure(WeakReference weakReference) {
                    d.G(yd.a.this, this, weakReference);
                }
            };
            AdExposureChecker adExposureChecker = this.mAdExposureChecker;
            if (adExposureChecker != null) {
                adExposureChecker.setCallback(new WeakReference<>(this.mCallBack));
            }
        }
        this.mAdFeedData = h16;
        AdExposureChecker adExposureChecker2 = this.mAdExposureChecker;
        if (adExposureChecker2 != null) {
            adExposureChecker2.startCheck();
        }
        View mRootView = getMRootView();
        if (mRootView != null && QZoneAdFeedUtils.f55717a.J(mRootView, 0.01f)) {
            F();
        }
    }

    @Override // ne.a
    protected void z(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
    }
}
