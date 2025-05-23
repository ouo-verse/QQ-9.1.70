package com.tencent.biz.qui.quipolarlight;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quipolarlight.render.PolarImageRender;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014B\u001b\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u0013\u0010\u0017B#\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u0013\u0010\u001aJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0014R\u0016\u0010\b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0007R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/biz/qui/quipolarlight/QUIPolarLightView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "stopAnimation", NodeProps.ON_DETACHED_FROM_WINDOW, "com/tencent/biz/qui/quipolarlight/QUIPolarLightView$polarRenderCallback$1", "Lcom/tencent/biz/qui/quipolarlight/QUIPolarLightView$polarRenderCallback$1;", "polarRenderCallback", "Lcom/tencent/biz/qui/quipolarlight/render/PolarImageRender;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qui/quipolarlight/render/PolarImageRender;", "l", "()Lcom/tencent/biz/qui/quipolarlight/render/PolarImageRender;", "setPolarLightRender", "(Lcom/tencent/biz/qui/quipolarlight/render/PolarImageRender;)V", "polarLightRender", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "a", "QUIPolarLight_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class QUIPolarLightView extends AppCompatImageView {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private PolarImageRender polarLightRender;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QUIPolarLightView$polarRenderCallback$1 polarRenderCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QUIPolarLightView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.polarRenderCallback = new QUIPolarLightView$polarRenderCallback$1(this);
        this.polarLightRender = new PolarImageRender();
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final PolarImageRender getPolarLightRender() {
        return this.polarLightRender;
    }

    public final void m() {
        this.polarLightRender.u(this.polarRenderCallback);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.polarLightRender.v();
    }

    public final void setPolarLightRender(@NotNull PolarImageRender polarImageRender) {
        Intrinsics.checkNotNullParameter(polarImageRender, "<set-?>");
        this.polarLightRender = polarImageRender;
    }

    public final void stopAnimation() {
        this.polarLightRender.v();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QUIPolarLightView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.polarRenderCallback = new QUIPolarLightView$polarRenderCallback$1(this);
        this.polarLightRender = new PolarImageRender();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QUIPolarLightView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.polarRenderCallback = new QUIPolarLightView$polarRenderCallback$1(this);
        this.polarLightRender = new PolarImageRender();
    }
}
