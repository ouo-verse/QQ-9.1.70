package com.tencent.mobileqq.widget.qus;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b\u0017\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0014R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/widget/qus/FloatingRoundCorneredLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "", "a", "", "radius", "setCornerRadius", "Landroid/graphics/Canvas;", PM.CANVAS, "dispatchDraw", "Landroid/graphics/Paint;", "d", "Landroid/graphics/Paint;", "mPaint", "e", UserInfo.SEX_FEMALE, "cornerRadius", "Landroid/graphics/Path;", "f", "Landroid/graphics/Path;", "clipPath", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class FloatingRoundCorneredLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint mPaint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float cornerRadius;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Path clipPath;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatingRoundCorneredLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPaint = new Paint();
        this.clipPath = new Path();
        a(context);
    }

    private final void a(Context context) {
        this.cornerRadius = 8 * context.getResources().getDisplayMetrics().density;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        canvas.save();
        this.clipPath.reset();
        this.clipPath.moveTo(this.cornerRadius, 0.0f);
        float f16 = width;
        this.clipPath.lineTo(f16 - this.cornerRadius, 0.0f);
        this.clipPath.quadTo(f16, 0.0f, f16, this.cornerRadius);
        float f17 = height;
        this.clipPath.lineTo(f16, f17);
        this.clipPath.lineTo(0.0f, f17);
        this.clipPath.lineTo(0.0f, this.cornerRadius);
        this.clipPath.quadTo(0.0f, 0.0f, this.cornerRadius, 0.0f);
        canvas.clipPath(this.clipPath);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public final void setCornerRadius(float radius) {
        boolean z16;
        if (this.cornerRadius == radius) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        this.cornerRadius = radius;
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatingRoundCorneredLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPaint = new Paint();
        this.clipPath = new Path();
        a(context);
    }
}
