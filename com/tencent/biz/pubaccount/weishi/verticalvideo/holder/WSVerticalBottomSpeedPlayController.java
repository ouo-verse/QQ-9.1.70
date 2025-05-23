package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
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

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0003H\u0014J\b\u0010\u0007\u001a\u00020\u0003H\u0014J\b\u0010\t\u001a\u00020\bH\u0014J\b\u0010\n\u001a\u00020\u0003H\u0014J\u0006\u0010\u000b\u001a\u00020\u0003J\u0006\u0010\f\u001a\u00020\u0003J\u0016\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\bR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017\u00a8\u0006!"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/WSVerticalBottomSpeedPlayController;", "Lcom/tencent/biz/pubaccount/weishi/baseui/b;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "", "v", "g", tl.h.F, "f", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "w", "u", "", "speed", "bottomTipRes", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/vas/ui/VasPagImageView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/vas/ui/VasPagImageView;", "speedPagView", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "speedText", "E", "speedTipText", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", UserInfo.SEX_FEMALE, "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSVerticalBottomSpeedPlayController extends com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> {

    /* renamed from: C, reason: from kotlin metadata */
    private VasPagImageView speedPagView;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView speedText;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView speedTipText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WSVerticalBottomSpeedPlayController(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void v() {
        final PAGFile Load = PagViewMonitor.Load(b().getResources().getAssets(), "wspag/ws_speed_play.pag");
        VasPagImageView vasPagImageView = this.speedPagView;
        if (vasPagImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speedPagView");
            vasPagImageView = null;
        }
        vasPagImageView.api().postAction(new Function1<PAGImageView, Unit>() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.holder.WSVerticalBottomSpeedPlayController$playPagView$1
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
                it.setComposition(PAGFile.this);
                it.setRepeatCount(-1);
                it.play();
            }
        });
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.d0a;
    }

    public final void u() {
        this.f80410e.setVisibility(8);
        VasPagImageView vasPagImageView = this.speedPagView;
        if (vasPagImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speedPagView");
            vasPagImageView = null;
        }
        vasPagImageView.api().postAction(new Function1<PAGImageView, Unit>() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.holder.WSVerticalBottomSpeedPlayController$hideView$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PAGImageView pAGImageView) {
                invoke2(pAGImageView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PAGImageView it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.pause();
            }
        });
    }

    public final void w() {
        this.f80410e.setVisibility(0);
        v();
    }

    public final void x(String speed, int bottomTipRes) {
        Intrinsics.checkNotNullParameter(speed, "speed");
        TextView textView = this.speedText;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speedText");
            textView = null;
        }
        textView.setText(e().getString(R.string.x79, speed));
        TextView textView3 = this.speedTipText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speedTipText");
        } else {
            textView2 = textView3;
        }
        textView2.setText(e().getString(bottomTipRes));
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        View p16 = p(R.id.p6f);
        Intrinsics.checkNotNull(p16, "null cannot be cast to non-null type android.widget.TextView");
        this.speedText = (TextView) p16;
        View p17 = p(R.id.p6g);
        Intrinsics.checkNotNull(p17, "null cannot be cast to non-null type android.widget.TextView");
        this.speedTipText = (TextView) p17;
        View p18 = p(R.id.p5b);
        Intrinsics.checkNotNull(p18, "null cannot be cast to non-null type com.tencent.mobileqq.vas.ui.VasPagImageView");
        VasPagImageView vasPagImageView = (VasPagImageView) p18;
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
