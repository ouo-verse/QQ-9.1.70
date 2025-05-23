package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0003B'\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0014J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0014R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/GuildW16H9FrameLayout;", "Landroid/widget/FrameLayout;", "", "a", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "Landroid/graphics/Canvas;", PM.CANVAS, "dispatchDraw", "Landroid/graphics/Paint;", "d", "Landroid/graphics/Paint;", "mPaint", "", "e", "[F", "mRadii", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "f", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildW16H9FrameLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint mPaint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private float[] mRadii;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildW16H9FrameLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final boolean a() {
        int length = this.mRadii.length;
        int i3 = 0;
        while (true) {
            boolean z16 = true;
            if (i3 >= length) {
                return true;
            }
            if (this.mRadii[i3] != 0.0f) {
                z16 = false;
            }
            if (!z16) {
                return false;
            }
            i3++;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (a()) {
            super.dispatchDraw(canvas);
            return;
        }
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        Path path = new Path();
        path.addRoundRect(new RectF(getPaddingLeft(), getPaddingTop(), width - getPaddingRight(), height - getPaddingBottom()), this.mRadii, Path.Direction.CW);
        float f16 = width;
        float f17 = height;
        canvas.saveLayer(new RectF(0.0f, 0.0f, f16, f17), null, 31);
        super.dispatchDraw(canvas);
        if (Build.VERSION.SDK_INT <= 27) {
            this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.drawPath(path, this.mPaint);
        } else {
            this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            Path path2 = new Path();
            path2.addRect(0.0f, 0.0f, f16, f17, Path.Direction.CW);
            path2.op(path, Path.Op.DIFFERENCE);
            canvas.drawPath(path2, this.mPaint);
        }
        canvas.restore();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int i3 = (int) (size / 1.7777778f);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("GuildW16H9FrameLayout", "[onMeasure] w:" + size + ",h:" + i3);
        }
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildW16H9FrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildW16H9FrameLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildW16H9FrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, up1.a.O8);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026leable.RoundCornerLayout)");
        int i16 = obtainStyledAttributes.getInt(up1.a.Q8, 0);
        int i17 = obtainStyledAttributes.getInt(up1.a.P8, 0);
        float f16 = i16;
        float f17 = obtainStyledAttributes.getInt(up1.a.S8, 0);
        float f18 = obtainStyledAttributes.getInt(up1.a.R8, 0);
        float f19 = i17;
        this.mRadii = new float[]{ViewUtils.dip2px(f16), ViewUtils.dip2px(f16), ViewUtils.dip2px(f17), ViewUtils.dip2px(f17), ViewUtils.dip2px(f18), ViewUtils.dip2px(f18), ViewUtils.dip2px(f19), ViewUtils.dip2px(f19)};
        obtainStyledAttributes.recycle();
    }
}
