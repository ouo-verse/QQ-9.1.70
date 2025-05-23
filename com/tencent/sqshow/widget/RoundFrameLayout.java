package com.tencent.sqshow.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 '2\u00020\u0001:\u0001(B'\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010$\u001a\u00020\u0002\u00a2\u0006\u0004\b%\u0010&J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002J(\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0014J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0014R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006)"}, d2 = {"Lcom/tencent/sqshow/widget/RoundFrameLayout;", "Landroid/widget/FrameLayout;", "", "w", h.F, "", "f", "radius", "setRadius", "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "Landroid/graphics/Canvas;", PM.CANVAS, "dispatchDraw", "Landroid/graphics/RectF;", "d", "Landroid/graphics/RectF;", "mRectF", "Landroid/graphics/Rect;", "e", "Landroid/graphics/Rect;", "mRect", "Landroid/graphics/Path;", "Landroid/graphics/Path;", "mPath", "I", "mRadius", "Landroid/graphics/PaintFlagsDrawFilter;", "i", "Landroid/graphics/PaintFlagsDrawFilter;", "flagsDrawFilter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class RoundFrameLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final RectF mRectF;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Rect mRect;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Path mPath;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mRadius;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final PaintFlagsDrawFilter flagsDrawFilter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/sqshow/widget/RoundFrameLayout$a", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            outline.setRoundRect(RoundFrameLayout.this.mRect, RoundFrameLayout.this.mRadius);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundFrameLayout(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void f(int w3, int h16) {
        this.mPath.reset();
        this.mRectF.set(0.0f, 0.0f, w3, h16);
        Path path = this.mPath;
        RectF rectF = this.mRectF;
        int i3 = this.mRadius;
        path.addRoundRect(rectF, i3, i3, Path.Direction.CW);
        this.mRect.set(0, 0, w3, h16);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.save();
        canvas.setDrawFilter(this.flagsDrawFilter);
        canvas.clipPath(this.mPath);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        f(w3, h16);
    }

    public final void setRadius(int radius) {
        this.mRadius = radius;
        f(getWidth(), getHeight());
        postInvalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ RoundFrameLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundFrameLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRectF = new RectF();
        this.mRect = new Rect();
        this.mPath = new Path();
        this.mRadius = ViewUtils.dpToPx(16.0f);
        this.flagsDrawFilter = new PaintFlagsDrawFilter(0, 2);
        setClipToOutline(true);
        setOutlineProvider(new a());
    }
}
