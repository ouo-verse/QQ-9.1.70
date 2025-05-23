package com.tencent.biz.qqcircle.immersive.datacardcover.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqcircle.immersive.datacardcover.widget.QFSPersonalCoverRegionView;
import com.tencent.biz.qqcircle.immersive.datacardcover.widget.QFSPersonalCoverSelectLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001.B\u0019\u0012\u0006\u0010(\u001a\u00020'\u0012\b\u0010*\u001a\u0004\u0018\u00010)\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J(\u0010\u0011\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0014J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0014R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0017R\u0016\u0010\u001d\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u001c\u0010$\u001a\n !*\u0004\u0018\u00010 0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010&\u001a\n !*\u0004\u0018\u00010 0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010#\u00a8\u0006/"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverRegionView;", "Landroid/view/View;", "", "", "g", "Landroid/graphics/Canvas;", PM.CANVAS, "e", "f", "d", "c", "j", "", "w", h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "onDraw", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Rect;", "Landroid/graphics/Rect;", "regionRect", "topShadeRect", "bottomShadeRect", "i", "I", "regionBorderColor", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "shadeColor", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "Landroid/animation/ValueAnimator;", "regionBorderColorAnim", "D", "shadeColorAnim", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "E", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPersonalCoverRegionView extends View {
    private static final int F = Color.parseColor("#ffffffff");
    private static final int G = Color.parseColor("#00ffffff");
    private static final int H = Color.parseColor("#4d000000");
    private static final int I = Color.parseColor("#ff000000");

    /* renamed from: C, reason: from kotlin metadata */
    private final ValueAnimator regionBorderColorAnim;

    /* renamed from: D, reason: from kotlin metadata */
    private final ValueAnimator shadeColorAnim;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Rect regionRect;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Rect topShadeRect;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Rect bottomShadeRect;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int regionBorderColor;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int shadeColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSPersonalCoverRegionView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.paint = new Paint(1);
        this.regionRect = new Rect();
        this.topShadeRect = new Rect();
        this.bottomShadeRect = new Rect();
        int i3 = F;
        this.regionBorderColor = i3;
        int i16 = H;
        this.shadeColor = i16;
        ValueAnimator ofArgb = ValueAnimator.ofArgb(i3, G);
        ofArgb.setDuration(200L);
        ofArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: k40.j
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                QFSPersonalCoverRegionView.h(QFSPersonalCoverRegionView.this, valueAnimator);
            }
        });
        this.regionBorderColorAnim = ofArgb;
        ValueAnimator ofArgb2 = ValueAnimator.ofArgb(i16, I);
        ofArgb2.setDuration(200L);
        ofArgb2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: k40.k
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                QFSPersonalCoverRegionView.i(QFSPersonalCoverRegionView.this, valueAnimator);
            }
        });
        this.shadeColorAnim = ofArgb2;
    }

    private final void d(Canvas canvas) {
        Paint paint = this.paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(this.shadeColor);
        canvas.drawRect(this.bottomShadeRect, this.paint);
    }

    private final void e(Canvas canvas) {
        Paint paint = this.paint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3.0f);
        paint.setColor(this.regionBorderColor);
        canvas.drawRect(this.regionRect, this.paint);
    }

    private final void f(Canvas canvas) {
        Paint paint = this.paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(this.shadeColor);
        canvas.drawRect(this.topShadeRect, this.paint);
    }

    private final void g() {
        if (this.regionBorderColorAnim.isRunning()) {
            this.regionBorderColorAnim.end();
        }
        if (this.shadeColorAnim.isRunning()) {
            this.shadeColorAnim.end();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(QFSPersonalCoverRegionView this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        this$0.regionBorderColor = ((Integer) animatedValue).intValue();
        this$0.postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(QFSPersonalCoverRegionView this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        this$0.shadeColor = ((Integer) animatedValue).intValue();
        this$0.postInvalidate();
    }

    public void c() {
        g();
        this.regionBorderColorAnim.start();
        this.shadeColorAnim.start();
    }

    public void j() {
        g();
        this.regionBorderColorAnim.reverse();
        this.shadeColorAnim.reverse();
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        e(canvas);
        f(canvas);
        d(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        Rect rect = this.regionRect;
        rect.left = 0;
        QFSPersonalCoverSelectLayout.Companion companion = QFSPersonalCoverSelectLayout.INSTANCE;
        int a16 = (h16 / 2) - (companion.a() / 2);
        rect.top = a16;
        rect.right = w3;
        rect.bottom = a16 + companion.a();
        Rect rect2 = this.topShadeRect;
        rect2.left = 0;
        rect2.top = 0;
        rect2.right = w3;
        Rect rect3 = this.regionRect;
        rect2.bottom = rect3.top;
        Rect rect4 = this.bottomShadeRect;
        rect4.left = 0;
        rect4.top = rect3.bottom;
        rect4.right = w3;
        rect4.bottom = h16;
        QLog.d("QFSPersonalCoverRegionView", 1, "onSizeChanged, regionRect:" + rect3 + ", topRect:" + rect2 + ", bottomRect:" + rect4);
    }
}
