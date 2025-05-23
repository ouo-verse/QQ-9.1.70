package com.tencent.mobileqq.qwallet.hb.detail;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB1\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0012\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/detail/HbSkinCurveView;", "Landroid/view/View;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "onDraw", "Landroid/graphics/Paint;", "d", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Path;", "e", "Landroid/graphics/Path;", "path", "Landroid/graphics/RectF;", "f", "Landroid/graphics/RectF;", "rectF", "", tl.h.F, "I", "lastRectFWidth", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "i", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class HbSkinCurveView extends View {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Path path;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RectF rectF;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int lastRectFWidth;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HbSkinCurveView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        super.onDraw(canvas);
        if (getWidth() != this.lastRectFWidth) {
            this.rectF = new RectF(getWidth() * (-1.0f), getHeight() - (getWidth() * 3.0f), getWidth() + (getWidth() * 1.0f), getHeight());
            this.lastRectFWidth = getWidth();
            this.path.reset();
        }
        RectF rectF = this.rectF;
        if (rectF != null) {
            this.path.arcTo(rectF, 60.0f, 120.0f, true);
            if (canvas != null) {
                canvas.drawPath(this.path, this.paint);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HbSkinCurveView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HbSkinCurveView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ HbSkinCurveView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HbSkinCurveView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.parseColor("#CCD39939"));
        paint.setStrokeWidth(ViewUtils.dip2px(6.0f));
        this.paint = paint;
        this.path = new Path();
    }
}
