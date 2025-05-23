package com.tencent.mobileqq.zplan.minihome.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u00a2\u0006\u0004\b \u0010!J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0014R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0016\u0010\u001a\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/view/MiniHomeSampleOutlineView;", "Landroid/view/View;", "", "width", "height", "", "a", "Landroid/graphics/Canvas;", PM.CANVAS, "", "onDraw", "", "d", UserInfo.SEX_FEMALE, "stroke", "Landroid/graphics/Paint;", "e", "Landroid/graphics/Paint;", "paint", "f", "I", "cachedWidth", tl.h.F, "cachedHeight", "i", "[F", "points", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MiniHomeSampleOutlineView extends View {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final float stroke;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Paint paint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int cachedWidth;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int cachedHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float[] points;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MiniHomeSampleOutlineView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final float[] a(int width, int height) {
        if (width == this.cachedWidth && height == this.cachedHeight) {
            return this.points;
        }
        this.cachedWidth = width;
        this.cachedHeight = height;
        float f16 = this.stroke;
        float f17 = width - f16;
        float f18 = height - f16;
        float f19 = f16 / 2.0f;
        float f26 = (f17 / 2.0f) + f19;
        float f27 = f19 + f16;
        float f28 = (1.5f * f16) + f19;
        float f29 = (0.251f * f18) + f19;
        float f36 = (0.749f * f18) + f19;
        float f37 = (f18 + f19) - f16;
        float f38 = (f19 + f17) - (f16 * 0.5f);
        float[] fArr = {f26, f27, f28, f29, f28, f29, f28, f36, f28, f36, f26, f37, f26, f37, f38, f36, f38, f36, f38, f29, f38, f29, f26, f27};
        this.points = fArr;
        return fArr;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        float[] a16 = a(getWidth(), getHeight());
        float f16 = this.stroke / 2.0f;
        Paint paint = this.paint;
        canvas.drawLines(a16, 0, 24, paint);
        canvas.drawCircle(a16[0], a16[1], f16, paint);
        canvas.drawCircle(a16[4], a16[5], f16, paint);
        canvas.drawCircle(a16[8], a16[9], f16, paint);
        canvas.drawCircle(a16[12], a16[13], f16, paint);
        canvas.drawCircle(a16[16], a16[17], f16, paint);
        canvas.drawCircle(a16[20], a16[21], f16, paint);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MiniHomeSampleOutlineView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MiniHomeSampleOutlineView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniHomeSampleOutlineView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        float applyDimension = TypedValue.applyDimension(1, 1.8f, context.getResources().getDisplayMetrics());
        this.stroke = applyDimension;
        Paint paint = new Paint(1);
        paint.setColor(Color.rgb(0, 153, 255));
        paint.setStrokeWidth(applyDimension);
        this.paint = paint;
        this.cachedWidth = getWidth();
        this.cachedHeight = getHeight();
        this.points = new float[24];
    }
}
