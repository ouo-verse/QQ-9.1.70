package com.tencent.mobileqq.guild.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 G2\u00020\u0001:\u0001HB'\b\u0007\u0012\u0006\u0010A\u001a\u00020@\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010B\u0012\b\b\u0002\u0010D\u001a\u00020\u0002\u00a2\u0006\u0004\bE\u0010FJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0010J(\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H\u0014J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0014J\b\u0010\u0019\u001a\u00020\u0005H\u0014R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0004\u0010&R\u0016\u0010*\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010)R\u0016\u00102\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00101R\u0016\u00105\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010)R\u0016\u00107\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00101R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010=\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010<R\u0018\u0010?\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010<\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/ScanningView;", "Landroid/view/View;", "", "w", tl.h.F, "", "c", "b", "e", "r", "setGuildScanViewRoundRadius", "", "value", "setDuration", "setOffset", "setSlope", "", "setColorArray", "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "Landroid/graphics/Canvas;", PM.CANVAS, "draw", "onDraw", NodeProps.ON_DETACHED_FROM_WINDOW, "Landroid/graphics/Paint;", "d", "Landroid/graphics/Paint;", "mPaint", "Landroid/graphics/Path;", "Landroid/graphics/Path;", "mPath", "Landroid/graphics/LinearGradient;", "f", "Landroid/graphics/LinearGradient;", "mLinearGradient", "Landroid/animation/ValueAnimator;", "Landroid/animation/ValueAnimator;", "mValueAnimator", "i", UserInfo.SEX_FEMALE, "radius", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "[I", "colorArray", BdhLogUtil.LogTag.Tag_Conn, "duration", "D", "I", "repeatCount", "E", "roundMode", "lastRadius", "G", "lastRoundMode", "", "H", "Z", "autoPlay", "Ljava/lang/Float;", "configOffset", "J", "configSlope", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "K", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ScanningView extends View {

    /* renamed from: C, reason: from kotlin metadata */
    private float duration;

    /* renamed from: D, reason: from kotlin metadata */
    private int repeatCount;

    /* renamed from: E, reason: from kotlin metadata */
    private int roundMode;

    /* renamed from: F, reason: from kotlin metadata */
    private float lastRadius;

    /* renamed from: G, reason: from kotlin metadata */
    private int lastRoundMode;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean autoPlay;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private Float configOffset;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private Float configSlope;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint mPaint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Path mPath;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearGradient mLinearGradient;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ValueAnimator mValueAnimator;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float radius;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private int[] colorArray;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ScanningView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void b() {
        boolean z16;
        if (this.lastRadius == this.radius) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && this.lastRoundMode == this.roundMode) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        this.lastRadius = this.radius;
        this.lastRoundMode = this.roundMode;
        this.mPath.reset();
        int i3 = this.roundMode;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            Path path = this.mPath;
                            RectF rectF = new RectF(0.0f, 0.0f, width, height);
                            float f16 = this.radius;
                            path.addRoundRect(rectF, new float[]{0.0f, 0.0f, 0.0f, 0.0f, f16, f16, f16, f16}, Path.Direction.CW);
                            return;
                        }
                        return;
                    }
                    Path path2 = this.mPath;
                    RectF rectF2 = new RectF(0.0f, 0.0f, width, height);
                    float f17 = this.radius;
                    path2.addRoundRect(rectF2, new float[]{0.0f, 0.0f, f17, f17, f17, f17, 0.0f, 0.0f}, Path.Direction.CW);
                    return;
                }
                Path path3 = this.mPath;
                RectF rectF3 = new RectF(0.0f, 0.0f, width, height);
                float f18 = this.radius;
                path3.addRoundRect(rectF3, new float[]{f18, f18, f18, f18, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
                return;
            }
            Path path4 = this.mPath;
            RectF rectF4 = new RectF(0.0f, 0.0f, width, height);
            float f19 = this.radius;
            path4.addRoundRect(rectF4, new float[]{f19, f19, 0.0f, 0.0f, 0.0f, 0.0f, f19, f19}, Path.Direction.CW);
            return;
        }
        Path path5 = this.mPath;
        RectF rectF5 = new RectF(0.0f, 0.0f, width, height);
        float f26 = this.radius;
        path5.addRoundRect(rectF5, f26, f26, Path.Direction.CW);
    }

    private final void c(int w3, int h16) {
        final float floatValue;
        final float f16;
        Point point = new Point(0, 0);
        Point point2 = new Point(w3, 0);
        Point point3 = new Point(w3, h16);
        Point point4 = new Point(0, h16);
        this.mPath.moveTo(point.x, point.y);
        this.mPath.lineTo(point2.x, point2.y);
        this.mPath.lineTo(point3.x, point3.y);
        this.mPath.lineTo(point4.x, point4.y);
        this.mPath.close();
        Float f17 = this.configSlope;
        if (f17 == null) {
            floatValue = (h16 * 1.0f) / w3;
        } else {
            Intrinsics.checkNotNull(f17);
            floatValue = f17.floatValue();
        }
        Float f18 = this.configOffset;
        if (f18 != null) {
            Intrinsics.checkNotNull(f18);
            f16 = f18.floatValue();
        } else {
            f16 = (w3 * 1.0f) / 2;
        }
        float f19 = 2 * f16;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f - f19, w3 + f19);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(0f - offset * 2, w + offset * 2)");
        this.mValueAnimator = ofFloat;
        ValueAnimator valueAnimator = null;
        if (ofFloat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mValueAnimator");
            ofFloat = null;
        }
        ofFloat.setRepeatCount(this.repeatCount);
        ValueAnimator valueAnimator2 = this.mValueAnimator;
        if (valueAnimator2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mValueAnimator");
            valueAnimator2 = null;
        }
        valueAnimator2.setInterpolator(new LinearInterpolator());
        ValueAnimator valueAnimator3 = this.mValueAnimator;
        if (valueAnimator3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mValueAnimator");
            valueAnimator3 = null;
        }
        valueAnimator3.setDuration(this.duration);
        ValueAnimator valueAnimator4 = this.mValueAnimator;
        if (valueAnimator4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mValueAnimator");
            valueAnimator4 = null;
        }
        valueAnimator4.addListener(new b());
        ValueAnimator valueAnimator5 = this.mValueAnimator;
        if (valueAnimator5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mValueAnimator");
            valueAnimator5 = null;
        }
        valueAnimator5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.guild.widget.ag
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator6) {
                ScanningView.d(ScanningView.this, floatValue, f16, valueAnimator6);
            }
        });
        if (this.autoPlay) {
            ValueAnimator valueAnimator6 = this.mValueAnimator;
            if (valueAnimator6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mValueAnimator");
            } else {
                valueAnimator = valueAnimator6;
            }
            valueAnimator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ScanningView this$0, float f16, float f17, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        float f18 = floatValue + f17;
        LinearGradient linearGradient = new LinearGradient(floatValue, f16 * floatValue, f18, f16 * f18, this$0.colorArray, (float[]) null, Shader.TileMode.CLAMP);
        this$0.mLinearGradient = linearGradient;
        this$0.mPaint.setShader(linearGradient);
        this$0.invalidate();
    }

    @Override // android.view.View
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.roundMode != 0) {
            int save = canvas.save();
            b();
            canvas.clipPath(this.mPath);
            super.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.draw(canvas);
    }

    public final void e() {
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null) {
            if (valueAnimator == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mValueAnimator");
                valueAnimator = null;
            }
            valueAnimator.start();
            return;
        }
        this.autoPlay = true;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null) {
            if (valueAnimator == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mValueAnimator");
                valueAnimator = null;
            }
            valueAnimator.cancel();
        }
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        canvas.drawPath(this.mPath, this.mPaint);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        c(w3, h16);
    }

    public final void setColorArray(@NotNull int[] value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.colorArray = value;
    }

    public final void setDuration(float value) {
        this.duration = value;
    }

    public final void setGuildScanViewRoundRadius(int r16) {
        this.radius = ViewUtils.dpToPx(r16);
    }

    public final void setOffset(float value) {
        this.configOffset = Float.valueOf(value);
    }

    public final void setSlope(float value) {
        this.configSlope = Float.valueOf(value);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ScanningView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ScanningView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ScanningView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        List split$default;
        int[] intArray;
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPaint = new Paint();
        this.mPath = new Path();
        this.colorArray = new int[]{Color.parseColor("#00FFFFFF"), Color.parseColor("#1AFFFFFF"), Color.parseColor("#00FFFFFF")};
        this.duration = 1500.0f;
        this.roundMode = 1;
        this.lastRadius = -1.0f;
        this.lastRoundMode = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mobileqq.guild.api.j.M5);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026able.guild_scanning_view)");
        String string = obtainStyledAttributes.getString(com.tencent.mobileqq.guild.api.j.O5);
        if (string != null) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) string, new char[]{','}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList();
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(Color.parseColor((String) it.next())));
            }
            intArray = CollectionsKt___CollectionsKt.toIntArray(arrayList);
            this.colorArray = intArray;
        }
        this.duration = obtainStyledAttributes.getFloat(com.tencent.mobileqq.guild.api.j.P5, this.duration);
        this.repeatCount = obtainStyledAttributes.getInt(com.tencent.mobileqq.guild.api.j.R5, this.repeatCount);
        this.roundMode = obtainStyledAttributes.getInt(com.tencent.mobileqq.guild.api.j.S5, this.roundMode);
        this.radius = obtainStyledAttributes.getDimension(com.tencent.mobileqq.guild.api.j.T5, this.radius);
        this.autoPlay = obtainStyledAttributes.getBoolean(com.tencent.mobileqq.guild.api.j.N5, this.autoPlay);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(com.tencent.mobileqq.guild.api.j.Q5, 0);
        if (dimensionPixelOffset != 0) {
            this.configOffset = Float.valueOf(dimensionPixelOffset);
        }
        float f16 = obtainStyledAttributes.getFloat(com.tencent.mobileqq.guild.api.j.U5, 0.0f);
        if (!(f16 == 0.0f)) {
            this.configSlope = Float.valueOf(f16);
        }
        obtainStyledAttributes.recycle();
        setAlpha(0.0f);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/widget/ScanningView$b", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            ScanningView.this.setAlpha(1.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }
    }
}
