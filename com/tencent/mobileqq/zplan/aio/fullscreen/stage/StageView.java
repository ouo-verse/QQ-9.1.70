package com.tencent.mobileqq.zplan.aio.fullscreen.stage;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\"\u0010\u0014\u001a\u00020\u00078\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/fullscreen/stage/StageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "v", "u", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/graphics/Rect;", CanvasView.ACTION_RECT, "setRect", "Lcom/tencent/mobileqq/zplan/aio/fullscreen/stage/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/zplan/aio/fullscreen/stage/d;", "player", BdhLogUtil.LogTag.Tag_Conn, "Landroid/graphics/Rect;", "p", "()Landroid/graphics/Rect;", "setOriginViewRect", "(Landroid/graphics/Rect;)V", "originViewRect", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class StageView extends AppCompatImageView {

    /* renamed from: C, reason: from kotlin metadata */
    public Rect originViewRect;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final d player;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageView(Context ctx, AttributeSet attrs) {
        super(ctx, attrs);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.player = new d();
        v();
        q();
    }

    private final void o() {
        setOriginViewRect(ge3.b.a(this));
    }

    private final void q() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.aio.fullscreen.stage.b
            @Override // java.lang.Runnable
            public final void run() {
                StageView.r(StageView.this);
            }
        }, 128, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(final StageView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final int M0 = (int) (((1 - ZPlanFeatureSwitch.f369852a.M0()) / 2) * ViewUtils.getScreenWidth());
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aio.fullscreen.stage.c
            @Override // java.lang.Runnable
            public final void run() {
                StageView.t(StageView.this, M0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(StageView this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewGroup.LayoutParams layoutParams = this$0.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.leftMargin = i3;
            marginLayoutParams.rightMargin = i3;
        }
    }

    public final Rect p() {
        Rect rect = this.originViewRect;
        if (rect != null) {
            return rect;
        }
        Intrinsics.throwUninitializedPropertyAccessException("originViewRect");
        return null;
    }

    public final void setOriginViewRect(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "<set-?>");
        this.originViewRect = rect;
    }

    public final void setRect(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        RectF rectF = new RectF();
        rectF.set(p());
        RectF rectF2 = new RectF();
        rectF2.set(rect);
        setPivotX(0.0f);
        setPivotY(0.0f);
        setScaleX(rectF2.width() / rectF.width());
        setScaleY(rectF2.height() / rectF.height());
        setTranslationX(rectF2.left - rectF.left);
        setTranslationY(rectF2.top - rectF.top);
    }

    private final void v() {
        setVisibility(0);
        u();
    }

    private final void u() {
        setScaleX(1.0f);
        setScaleY(1.0f);
        setTranslationX(0.0f);
        setTranslationY(0.0f);
        o();
    }
}
