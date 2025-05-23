package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import android.content.Context;
import android.view.View;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.ui.VasPagImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.libpag.PAGFile;
import org.libpag.PAGImageView;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\t\u001a\u00020\u0005H\u0014J\b\u0010\n\u001a\u00020\u0005H\u0014J\b\u0010\u000b\u001a\u00020\u0005H\u0014J\u0006\u0010\f\u001a\u00020\u0005J\u0006\u0010\r\u001a\u00020\u0005J\b\u0010\u000e\u001a\u00020\u0005H\u0014R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/WSVerticalItemAtPopGuideController;", "Lcom/tencent/biz/pubaccount/weishi/baseui/b;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "Lorg/libpag/PAGImageView;", "pagView", "", "y", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "g", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "w", "f", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/b;", "mVideoItemView", "Lcom/tencent/mobileqq/vas/ui/VasPagImageView;", "D", "Lcom/tencent/mobileqq/vas/ui/VasPagImageView;", "mPagAtPopGuide", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/b;)V", "E", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSVerticalItemAtPopGuideController extends com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> {

    /* renamed from: C, reason: from kotlin metadata */
    private final b mVideoItemView;

    /* renamed from: D, reason: from kotlin metadata */
    private VasPagImageView mPagAtPopGuide;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WSVerticalItemAtPopGuideController(Context context, b mVideoItemView) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mVideoItemView, "mVideoItemView");
        this.mVideoItemView = mVideoItemView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(WSVerticalItemAtPopGuideController this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b bVar = this$0.mVideoItemView;
        Intrinsics.checkNotNull(bVar, "null cannot be cast to non-null type com.tencent.biz.pubaccount.weishi.verticalvideo.holder.WSVerticalVideoOperationRightItemView");
        ((WSVerticalVideoOperationRightItemView) bVar).onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(PAGImageView pagView) {
        PAGFile Load = PagViewMonitor.Load(BaseApplicationImpl.getApplication().getResources().getAssets(), "wspag/ws_comment_at_pop_guide.pag");
        if (Load != null) {
            pagView.setVisibility(0);
            pagView.setComposition(Load);
            pagView.setRepeatCount(1);
            pagView.play();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
        w();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.fwl;
    }

    public final void w() {
        VasPagImageView vasPagImageView = this.mPagAtPopGuide;
        if (vasPagImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPagAtPopGuide");
            vasPagImageView = null;
        }
        vasPagImageView.api().postAction(new Function1<PAGImageView, Unit>() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.holder.WSVerticalItemAtPopGuideController$hideAtPopGuideView$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PAGImageView pAGImageView) {
                invoke2(pAGImageView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PAGImageView it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.pause();
                it.setCurrentFrame(0);
                it.setVisibility(8);
            }
        });
    }

    public final void z() {
        VasPagImageView vasPagImageView = this.mPagAtPopGuide;
        if (vasPagImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPagAtPopGuide");
            vasPagImageView = null;
        }
        vasPagImageView.api().postAction(new Function1<PAGImageView, Unit>() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.holder.WSVerticalItemAtPopGuideController$startAtPopGuideAnimation$1
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
                WSVerticalItemAtPopGuideController.this.y(it);
            }
        });
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        View p16 = p(R.id.f219502e);
        Intrinsics.checkNotNull(p16, "null cannot be cast to non-null type com.tencent.mobileqq.vas.ui.VasPagImageView");
        VasPagImageView vasPagImageView = (VasPagImageView) p16;
        this.mPagAtPopGuide = vasPagImageView;
        VasPagImageView vasPagImageView2 = null;
        if (vasPagImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPagAtPopGuide");
            vasPagImageView = null;
        }
        vasPagImageView.api().build();
        VasPagImageView vasPagImageView3 = this.mPagAtPopGuide;
        if (vasPagImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPagAtPopGuide");
        } else {
            vasPagImageView2 = vasPagImageView3;
        }
        vasPagImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.holder.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WSVerticalItemAtPopGuideController.x(WSVerticalItemAtPopGuideController.this, view);
            }
        });
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
    }
}
