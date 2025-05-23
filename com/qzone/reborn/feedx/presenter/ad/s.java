package com.qzone.reborn.feedx.presenter.ad;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.module.feedcomponent.ui.common.SuperLikeView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellRecommAction;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.proxy.feedcomponent.ui.SuperLikeAnimator$Event;
import com.qzone.reborn.feedx.presenter.ad.basepresenter.a;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.tencent.ad.tangram.views.button.AdAppDownloadButtonController;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ad.views.AdDownloadButton;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00042\u00020\u0001:\u0001:B\u0007\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0014J\b\u0010\r\u001a\u00020\fH\u0014J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\u0012\u0010\u001a\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0010H\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010\u0005R\u0018\u00100\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010\u001fR\u0018\u00103\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u00102R\u0016\u00104\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0005R\u0018\u00107\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u00106\u00a8\u0006;"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/s;", "Lcom/qzone/reborn/feedx/presenter/ad/basepresenter/a;", "", "W", "X", "Z", "a0", "U", "V", "b0", "", "k", "", ReportConstant.COSTREPORT_PREFIX, "", HippyTKDListViewAdapter.X, "Landroid/view/View;", "containerView", BdhLogUtil.LogTag.Tag_Conn, "c", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "L", "K", "M", "N", "v", NodeProps.ON_CLICK, "Lcom/tencent/gdtad/aditem/GdtAd;", "Lcom/tencent/gdtad/aditem/GdtAd;", "mAd", "Landroid/view/ViewStub;", "Landroid/view/ViewStub;", "mOperationViewStub", "Landroid/widget/LinearLayout;", "P", "Landroid/widget/LinearLayout;", "mOperationLayout", "Lcom/qzone/module/feedcomponent/ui/common/SuperLikeView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/qzone/module/feedcomponent/ui/common/SuperLikeView;", "mPraiseIcon", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/ImageView;", "mForwardIcon", ExifInterface.LATITUDE_SOUTH, "mIsOperationInflate", "T", "mDownloadBtnViewStub", "Lcom/tencent/mobileqq/ad/views/AdDownloadButton;", "Lcom/tencent/mobileqq/ad/views/AdDownloadButton;", "mDownloadBtn", "mIsDownloadBtnInflate", "Lcom/tencent/ad/tangram/views/button/AdAppDownloadButtonController;", "Lcom/tencent/ad/tangram/views/button/AdAppDownloadButtonController;", "mDownloadBtnController", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class s extends com.qzone.reborn.feedx.presenter.ad.basepresenter.a {

    /* renamed from: M, reason: from kotlin metadata */
    private GdtAd mAd;

    /* renamed from: N, reason: from kotlin metadata */
    private ViewStub mOperationViewStub;

    /* renamed from: P, reason: from kotlin metadata */
    private LinearLayout mOperationLayout;

    /* renamed from: Q, reason: from kotlin metadata */
    private SuperLikeView mPraiseIcon;

    /* renamed from: R, reason: from kotlin metadata */
    private ImageView mForwardIcon;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean mIsOperationInflate;

    /* renamed from: T, reason: from kotlin metadata */
    private ViewStub mDownloadBtnViewStub;

    /* renamed from: U, reason: from kotlin metadata */
    private AdDownloadButton mDownloadBtn;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean mIsDownloadBtnInflate;

    /* renamed from: W, reason: from kotlin metadata */
    private AdAppDownloadButtonController mDownloadBtnController;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/feedx/presenter/ad/s$b", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v3) {
            EventCollector.getInstance().onViewClickedBefore(v3);
            s.this.U();
            EventCollector.getInstance().onViewClicked(v3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/feedx/presenter/ad/s$c", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v3) {
            EventCollector.getInstance().onViewClickedBefore(v3);
            SuperLikeView superLikeView = s.this.mPraiseIcon;
            if (superLikeView != null) {
                s sVar = s.this;
                superLikeView.setSelected(!superLikeView.isSelected());
                ((vg.a) sVar).f441565h.getAdData().setPraised(superLikeView.isSelected());
                AccessibilityUtil.s(superLikeView, com.qzone.util.l.a(superLikeView.isSelected() ? R.string.f2202468l : R.string.f2202368k));
            }
            EventCollector.getInstance().onViewClicked(v3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U() {
        gf.b bVar = (gf.b) j(gf.b.class);
        if (bVar != null) {
            bVar.P4(this.f441565h);
        }
    }

    private final void V() {
        if (this.mIsDownloadBtnInflate) {
            return;
        }
        ViewStub viewStub = (ViewStub) this.f441562d.findViewById(R.id.nmj);
        this.mDownloadBtnViewStub = viewStub;
        if (viewStub != null) {
            viewStub.inflate();
        }
        this.mDownloadBtn = (AdDownloadButton) this.f441562d.findViewById(R.id.mlr);
        this.mIsDownloadBtnInflate = true;
    }

    private final void W() {
        if (QZoneAdFeedDataExtKt.isNativeAdStyleA(this.f441565h)) {
            X();
        } else if (QZoneAdFeedDataExtKt.isNativeAdStyleB(this.f441565h)) {
            Z();
        }
    }

    private final void X() {
        a0();
        LinearLayout linearLayout = this.mOperationLayout;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        ImageView imageView = this.mForwardIcon;
        if (imageView != null) {
            imageView.setOnClickListener(new b());
        }
        SuperLikeView superLikeView = this.mPraiseIcon;
        if (superLikeView != null) {
            superLikeView.setSelected(this.f441565h.getAdData().getIsPraised());
        }
        SuperLikeView superLikeView2 = this.mPraiseIcon;
        if (superLikeView2 != null) {
            superLikeView2.setOnEventBack(new SuperLikeView.OnEventBack() { // from class: com.qzone.reborn.feedx.presenter.ad.r
                @Override // com.qzone.module.feedcomponent.ui.common.SuperLikeView.OnEventBack
                public final void onEventBack(SuperLikeAnimator$Event superLikeAnimator$Event, View view) {
                    s.Y(superLikeAnimator$Event, view);
                }
            });
        }
        SuperLikeView superLikeView3 = this.mPraiseIcon;
        if (superLikeView3 != null) {
            superLikeView3.setOnClickListener(new c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(SuperLikeAnimator$Event superLikeAnimator$Event, View view) {
        if (superLikeAnimator$Event == SuperLikeAnimator$Event.CLICK) {
            view.performClick();
        }
    }

    private final void Z() {
        O();
    }

    private final void a0() {
        if (this.mIsOperationInflate) {
            return;
        }
        ViewStub viewStub = (ViewStub) this.f441562d.findViewById(R.id.nml);
        this.mOperationViewStub = viewStub;
        if (viewStub != null) {
            viewStub.inflate();
        }
        this.mOperationLayout = (LinearLayout) this.f441562d.findViewById(R.id.mlz);
        this.mPraiseIcon = (SuperLikeView) this.f441562d.findViewById(R.id.f162782mm0);
        this.mForwardIcon = (ImageView) this.f441562d.findViewById(R.id.mls);
        this.mIsDownloadBtnInflate = true;
    }

    private final void b0() {
        AdDownloadButton adDownloadButton;
        V();
        GdtAd gdtAd = this.mAd;
        if (gdtAd != null && (adDownloadButton = this.mDownloadBtn) != null) {
            adDownloadButton.setAd(gdtAd);
        }
        AdAppDownloadButtonController.Params params = new AdAppDownloadButtonController.Params();
        params.clickParams = GdtHandler.toParams(QZoneAdFeedUtils.f55717a.s(i(), this.mAd));
        AdDownloadButton adDownloadButton2 = this.mDownloadBtn;
        if (adDownloadButton2 != null) {
            adDownloadButton2.update(0, 100);
        }
        AdAppDownloadButtonController adAppDownloadButtonController = new AdAppDownloadButtonController(params);
        this.mDownloadBtnController = adAppDownloadButtonController;
        adAppDownloadButtonController.registerView(new WeakReference<>(this.mDownloadBtn));
        AdDownloadButton adDownloadButton3 = this.mDownloadBtn;
        if (adDownloadButton3 != null) {
            adDownloadButton3.setVisibility(0);
        }
        AdDownloadButton adDownloadButton4 = this.mDownloadBtn;
        if (adDownloadButton4 != null) {
            adDownloadButton4.setOnAdBtnClickListener(new d());
        }
    }

    @Override // com.qzone.reborn.feedx.presenter.ad.basepresenter.a
    public boolean K() {
        return !QZoneAdFeedUtils.f55717a.g(this.f441565h);
    }

    @Override // com.qzone.reborn.feedx.presenter.ad.basepresenter.a
    public boolean L() {
        return QZoneAdFeedUtils.f55717a.V(this.f441565h);
    }

    @Override // com.qzone.reborn.feedx.presenter.ad.basepresenter.a
    public void M() {
        a.C0466a mAdFeedBottomData = getMAdFeedBottomData();
        CellRecommAction recommAction = this.f441565h.getRecommAction();
        String str = recommAction != null ? recommAction.buttonText : null;
        if (str == null) {
            str = "";
        }
        mAdFeedBottomData.b(str);
    }

    @Override // com.qzone.reborn.feedx.presenter.ad.basepresenter.a
    public void N() {
        GdtAd gdtAd = this.mAd;
        if (TextUtils.equals(gdtAd != null ? gdtAd.getTraceId() : null, QZoneAdFeedDataExtKt.getTraceId(this.f441565h))) {
            return;
        }
        this.mAd = GdtFeedUtilForQZone.E(this.f441565h);
        LinearLayout linearLayout = this.mOperationLayout;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        AdDownloadButton adDownloadButton = this.mDownloadBtn;
        if (adDownloadButton != null) {
            adDownloadButton.setVisibility(8);
        }
        LinearLayout mAdBottomRightLayout = getMAdBottomRightLayout();
        if (mAdBottomRightLayout != null) {
            mAdBottomRightLayout.setVisibility(8);
        }
        QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
        if (qZoneAdFeedUtils.l(this.f441565h)) {
            b0();
        } else if (qZoneAdFeedUtils.j(this.f441565h)) {
            W();
        } else {
            O();
        }
    }

    @Override // vg.a, vg.c
    public void c() {
        AdAppDownloadButtonController adAppDownloadButtonController = this.mDownloadBtnController;
        if (adAppDownloadButtonController != null) {
            adAppDownloadButtonController.onViewResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneAdGdtFeedBottomRightPresenter";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        int id5;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null && ((id5 = v3.getId()) == R.id.f162783mm1 || id5 == R.id.f162786mm4)) {
            QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
            Activity mActivity = this.C;
            Intrinsics.checkNotNullExpressionValue(mActivity, "mActivity");
            BusinessFeedData mFeedData = this.f441565h;
            Intrinsics.checkNotNullExpressionValue(mFeedData, "mFeedData");
            qZoneAdFeedUtils.H(mActivity, v3, mFeedData, FeedElement.RECOMM_ACTION_LEFT_TEXT, 8, this.f441567m, null);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // vg.a, vg.c
    public void onDestroy() {
        AdAppDownloadButtonController adAppDownloadButtonController = this.mDownloadBtnController;
        if (adAppDownloadButtonController != null) {
            adAppDownloadButtonController.unregisterView(new WeakReference<>(this.mDownloadBtn));
        }
        this.mDownloadBtnController = null;
    }

    @Override // com.qzone.reborn.feedx.presenter.ad.basepresenter.a, vg.a
    protected int s() {
        return R.id.nmm;
    }

    @Override // com.qzone.reborn.feedx.presenter.ad.basepresenter.a, vg.a
    protected boolean x() {
        return false;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/qzone/reborn/feedx/presenter/ad/s$d", "Lcom/tencent/mobileqq/ad/views/AdDownloadButton$a;", "", "onCancelClick", "", "status", NodeProps.ON_CLICK, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class d implements AdDownloadButton.a {
        d() {
        }

        @Override // com.tencent.mobileqq.ad.views.AdDownloadButton.a
        public void onCancelClick() {
            AdAppDownloadButtonController adAppDownloadButtonController = s.this.mDownloadBtnController;
            if (adAppDownloadButtonController != null) {
                adAppDownloadButtonController.onCancelClick(10067);
            }
        }

        @Override // com.tencent.mobileqq.ad.views.AdDownloadButton.a
        public void onClick(int status) {
            int i3 = status == 5 ? 10068 : 10066;
            AdAppDownloadButtonController adAppDownloadButtonController = s.this.mDownloadBtnController;
            if (adAppDownloadButtonController != null) {
                adAppDownloadButtonController.onClick(i3);
            }
        }
    }

    @Override // vg.a
    protected void C(View containerView) {
    }
}
