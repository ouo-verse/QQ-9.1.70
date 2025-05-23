package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.View;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.biz.pubaccount.weishi.download.WSPagDownloadUtil;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.ui.VasPagImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.libpag.PAGImageView;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0005\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0003H\u0014J\b\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\t\u001a\u00020\u0003H\u0014J\u0006\u0010\n\u001a\u00020\u0003R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/WSVerticalItemSpeedPlayGuideController;", "Lcom/tencent/biz/pubaccount/weishi/baseui/b;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "", "g", tl.h.F, "f", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "v", "Lcom/tencent/mobileqq/vas/ui/VasPagImageView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/vas/ui/VasPagImageView;", "speedPagView", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;", "D", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;", "fragment", "Landroid/content/Context;", "context", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/b;", "itemView", "<init>", "(Landroid/content/Context;Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/b;)V", "E", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSVerticalItemSpeedPlayGuideController extends com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> {

    /* renamed from: C, reason: from kotlin metadata */
    private VasPagImageView speedPagView;

    /* renamed from: D, reason: from kotlin metadata */
    private final WSVerticalPageFragment fragment;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WSVerticalItemSpeedPlayGuideController(Context context, b itemView) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.fragment = itemView.f82125i;
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.d1j;
    }

    public final void v() {
        if (WSPagDownloadUtil.f()) {
            if (!WSPagDownloadUtil.e("https://isee.weishi.qq.com/delivory/8.6.6/ws_video_speed_guide.pag")) {
                WSPagDownloadUtil.g("https://isee.weishi.qq.com/delivory/8.6.6/ws_video_speed_guide.pag");
                return;
            }
            if (c() == null || this.fragment == null) {
                return;
            }
            com.tencent.biz.pubaccount.weishi.verticalvideo.utils.b.l();
            WSVerticalPageFragment wSVerticalPageFragment = this.fragment;
            String from = wSVerticalPageFragment.getFrom();
            Intrinsics.checkNotNullExpressionValue(from, "from");
            String playScene = wSVerticalPageFragment.getPlayScene();
            Intrinsics.checkNotNullExpressionValue(playScene, "playScene");
            stSimpleMetaFeed e16 = c().e();
            Intrinsics.checkNotNullExpressionValue(e16, "data.itemInfo");
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.b.a(from, playScene, e16, wSVerticalPageFragment.getPresenter().h0());
            VasPagImageView vasPagImageView = this.speedPagView;
            if (vasPagImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("speedPagView");
                vasPagImageView = null;
            }
            vasPagImageView.api().postAction(new Function1<PAGImageView, Unit>() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.holder.WSVerticalItemSpeedPlayGuideController$playPagView$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PAGImageView pAGImageView) {
                    invoke2(pAGImageView);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(PAGImageView it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.addListener(new a(WSVerticalItemSpeedPlayGuideController.this));
                    it.setComposition(PagViewMonitor.Load(WSPagDownloadUtil.b("https://isee.weishi.qq.com/delivory/8.6.6/ws_video_speed_guide.pag")));
                    it.setRepeatCount(1);
                    it.play();
                }

                @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/biz/pubaccount/weishi/verticalvideo/holder/WSVerticalItemSpeedPlayGuideController$playPagView$2$a", "Lorg/libpag/PAGImageView$PAGImageViewListener;", "Lorg/libpag/PAGImageView;", "p0", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "onAnimationUpdate", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
                /* loaded from: classes32.dex */
                public static final class a implements PAGImageView.PAGImageViewListener {

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ WSVerticalItemSpeedPlayGuideController f82090d;

                    a(WSVerticalItemSpeedPlayGuideController wSVerticalItemSpeedPlayGuideController) {
                        this.f82090d = wSVerticalItemSpeedPlayGuideController;
                    }

                    @Override // org.libpag.PAGImageView.PAGImageViewListener
                    public void onAnimationEnd(PAGImageView p06) {
                        VasPagImageView vasPagImageView;
                        vasPagImageView = this.f82090d.speedPagView;
                        if (vasPagImageView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("speedPagView");
                            vasPagImageView = null;
                        }
                        vasPagImageView.setVisibility(8);
                    }

                    @Override // org.libpag.PAGImageView.PAGImageViewListener
                    public void onAnimationCancel(PAGImageView p06) {
                    }

                    @Override // org.libpag.PAGImageView.PAGImageViewListener
                    public void onAnimationRepeat(PAGImageView p06) {
                    }

                    @Override // org.libpag.PAGImageView.PAGImageViewListener
                    public void onAnimationStart(PAGImageView p06) {
                    }

                    @Override // org.libpag.PAGImageView.PAGImageViewListener
                    public void onAnimationUpdate(PAGImageView p06) {
                    }
                }
            });
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        View p16 = p(R.id.p5c);
        Intrinsics.checkNotNull(p16, "null cannot be cast to non-null type com.tencent.mobileqq.vas.ui.VasPagImageView");
        VasPagImageView vasPagImageView = (VasPagImageView) p16;
        this.speedPagView = vasPagImageView;
        if (vasPagImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speedPagView");
            vasPagImageView = null;
        }
        vasPagImageView.api().build();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
    }
}
