package com.tencent.sqshow.zootopia.nativeui.view.color.picker;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import ca4.a;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.sqshow.zootopia.utils.i;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import tl.h;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 S2\u00020\u0001:\u0002\f\rB#\u0012\b\u0010L\u001a\u0004\u0018\u00010K\u0012\b\u0010N\u001a\u0004\u0018\u00010M\u0012\u0006\u0010O\u001a\u00020\u0005\u00a2\u0006\u0004\bP\u0010QB\u001f\b\u0017\u0012\b\u0010L\u001a\u0004\u0018\u00010K\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010M\u00a2\u0006\u0004\bP\u0010RJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J(\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0014J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J\u000e\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u000eJ\u0006\u0010!\u001a\u00020\u000eJ\u000e\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010%R\u0016\u0010'\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010&R\u0016\u0010(\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010&R\u0016\u0010)\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010&R\u0016\u0010*\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010&R\u0016\u0010,\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010&R\u0016\u0010.\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010&R\u0016\u00100\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010&R\u0016\u00102\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010&R\u0016\u00103\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010&R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u00109\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00106R\u0016\u0010;\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010:R\u0018\u0010=\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00106R\u0016\u0010?\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010&R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010&R\u0016\u0010J\u001a\u00020H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010<\u00a8\u0006T"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/color/picker/MultiHuePickerView;", "Landroid/view/View;", "", "g", h.F, "", "heightMeasureSpec", "i", "widthMeasureSpec", "j", "Landroid/view/MotionEvent;", "event", "a", "b", "", "f", "Landroid/graphics/Canvas;", PM.CANVAS, "c", "d", "", NodeProps.COLORS, "setColors", "onMeasure", "w", "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "", "onTouchEvent", "onDraw", "fraction", "setCurrentFraction", "e", "Lcom/tencent/sqshow/zootopia/nativeui/view/color/picker/MultiHuePickerView$b;", "onColorChangeListener", "setOnColorChangedListener", "Lcom/tencent/sqshow/zootopia/nativeui/view/color/picker/MultiHuePickerView$b;", UserInfo.SEX_FEMALE, "width", "height", "barWidth", "barHeight", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "thumbWidth", BdhLogUtil.LogTag.Tag_Conn, "thumbHeight", "D", "currentThumbOffset", "E", "barStartX", "barStartY", "Landroid/graphics/Paint;", "G", "Landroid/graphics/Paint;", "barPaint", "H", "thumbPaint", "I", "currentColor", "J", "shadowPaint", "K", NodeProps.SHADOW_RADIUS, "L", "[I", "Landroid/animation/ArgbEvaluator;", "M", "Landroid/animation/ArgbEvaluator;", "argbEvaluator", "N", "mFraction", "", "P", WadlProxyConsts.LAST_UPDATE_TIME, "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MultiHuePickerView extends View {
    private static int R;

    /* renamed from: C, reason: from kotlin metadata */
    private float thumbHeight;

    /* renamed from: D, reason: from kotlin metadata */
    private float currentThumbOffset;

    /* renamed from: E, reason: from kotlin metadata */
    private float barStartX;

    /* renamed from: F, reason: from kotlin metadata */
    private float barStartY;

    /* renamed from: G, reason: from kotlin metadata */
    private Paint barPaint;

    /* renamed from: H, reason: from kotlin metadata */
    private Paint thumbPaint;

    /* renamed from: I, reason: from kotlin metadata */
    private int currentColor;

    /* renamed from: J, reason: from kotlin metadata */
    private Paint shadowPaint;

    /* renamed from: K, reason: from kotlin metadata */
    private float shadowRadius;

    /* renamed from: L, reason: from kotlin metadata */
    private int[] colors;

    /* renamed from: M, reason: from kotlin metadata */
    private final ArgbEvaluator argbEvaluator;

    /* renamed from: N, reason: from kotlin metadata */
    private float mFraction;

    /* renamed from: P, reason: from kotlin metadata */
    private long lastUpdateTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private b onColorChangeListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float width;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float height;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float barWidth;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float barHeight;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float thumbWidth;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/color/picker/MultiHuePickerView$b;", "", "", "fraction", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface b {
        void a(float fraction);
    }

    public MultiHuePickerView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
    }

    private final void a(MotionEvent event) {
        float x16 = (int) event.getX();
        this.currentThumbOffset = x16;
        float f16 = this.thumbWidth;
        float f17 = 2;
        if (x16 <= f16 / f17) {
            this.currentThumbOffset = (f16 / f17) + 1;
        }
        float f18 = this.currentThumbOffset;
        float f19 = this.barWidth;
        if (f18 >= (f16 / f17) + f19) {
            this.currentThumbOffset = f19 + (f16 / f17);
        }
    }

    private final void b() {
        if (this.colors.length == 0) {
            return;
        }
        float f16 = 1;
        float length = 1.0f / (r0.length - f16);
        float f17 = f();
        if (f17 == 1.0f) {
            int[] iArr = this.colors;
            this.currentColor = iArr[iArr.length - 1];
            return;
        }
        this.mFraction = f17;
        int[] iArr2 = this.colors;
        float length2 = (f17 % length) * (iArr2.length - f16);
        int i3 = (int) (f17 / length);
        Object evaluate = this.argbEvaluator.evaluate(length2, Integer.valueOf(iArr2[i3]), Integer.valueOf(iArr2[i3 + 1]));
        Intrinsics.checkNotNull(evaluate, "null cannot be cast to non-null type kotlin.Int");
        this.currentColor = ((Integer) evaluate).intValue();
    }

    private final void c(Canvas canvas) {
        if (this.colors.length < 2) {
            return;
        }
        Paint paint = this.barPaint;
        if (paint != null) {
            float f16 = this.barStartX;
            float f17 = this.barStartY;
            float f18 = this.barHeight;
            float f19 = 2;
            paint.setShader(new LinearGradient(f16, (f18 / f19) + f17, this.barWidth + f16, f17 + (f18 / f19), this.colors, (float[]) null, Shader.TileMode.CLAMP));
        }
        float f26 = this.barStartX;
        float f27 = this.barStartY;
        RectF rectF = new RectF(f26, f27, this.barWidth + f26, this.barHeight + f27);
        float f28 = this.barHeight;
        float f29 = 2;
        float f36 = f28 / f29;
        float f37 = f28 / f29;
        Paint paint2 = this.barPaint;
        Intrinsics.checkNotNull(paint2);
        canvas.drawRoundRect(rectF, f36, f37, paint2);
    }

    private final void d(Canvas canvas) {
        float f16 = (this.barWidth * this.mFraction) + (this.thumbWidth / 2.0f);
        this.currentThumbOffset = f16;
        Paint paint = this.shadowPaint;
        if (paint != null) {
            canvas.drawCircle(f16, this.height / 2, i.d(10.5f), paint);
        }
        Paint paint2 = this.thumbPaint;
        if (paint2 != null) {
            canvas.drawCircle(this.currentThumbOffset, this.height / 2, i.d(10.5f), paint2);
        }
    }

    private final float f() {
        return (this.currentThumbOffset - (this.thumbWidth / 2.0f)) / this.barWidth;
    }

    private final int i(int heightMeasureSpec) {
        int coerceAtLeast;
        int coerceAtLeast2;
        int mode = View.MeasureSpec.getMode(heightMeasureSpec);
        int size = View.MeasureSpec.getSize(heightMeasureSpec);
        if (mode == Integer.MIN_VALUE) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast((int) (this.thumbHeight + (i.a(this.shadowRadius) * 2)), (int) this.barHeight);
            return coerceAtLeast;
        }
        if (mode != 1073741824) {
            return size;
        }
        coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(Math.max((int) this.thumbHeight, (int) this.barHeight), size);
        return coerceAtLeast2;
    }

    private final int j(int widthMeasureSpec) {
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        if (mode == Integer.MIN_VALUE) {
            return 200;
        }
        if (mode != 1073741824) {
            return 0;
        }
        return size;
    }

    /* renamed from: e, reason: from getter */
    public final float getMFraction() {
        return this.mFraction;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        c(canvas);
        d(canvas);
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(j(widthMeasureSpec), i(heightMeasureSpec));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        boolean z16;
        b bVar;
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action == 0) {
            a(event);
            R = 1;
        } else if (action == 1) {
            a(event);
        } else {
            if (action != 2) {
                z16 = false;
            } else {
                a(event);
                z16 = a.f30527a.a(this.lastUpdateTime);
                if (z16) {
                    this.lastUpdateTime = System.currentTimeMillis();
                }
            }
            b();
            if (z16 && (bVar = this.onColorChangeListener) != null) {
                bVar.a(this.mFraction);
            }
            invalidate();
            return true;
        }
        z16 = true;
        b();
        if (z16) {
            bVar.a(this.mFraction);
        }
        invalidate();
        return true;
    }

    public final void setColors(int[] colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.colors = colors;
        invalidate();
    }

    public final void setCurrentFraction(float fraction) {
        this.mFraction = fraction;
        invalidate();
    }

    public final void setOnColorChangedListener(b onColorChangeListener) {
        Intrinsics.checkNotNullParameter(onColorChangeListener, "onColorChangeListener");
        this.onColorChangeListener = onColorChangeListener;
    }

    public MultiHuePickerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.shadowRadius = 4.0f;
        this.colors = new int[0];
        this.argbEvaluator = new ArgbEvaluator();
        g();
        h();
    }

    private final void g() {
        R = 0;
        Paint paint = new Paint();
        this.barPaint = paint;
        paint.setAntiAlias(true);
        Paint paint2 = this.barPaint;
        if (paint2 != null) {
            paint2.setStrokeCap(Paint.Cap.ROUND);
        }
        Paint paint3 = new Paint();
        this.thumbPaint = paint3;
        paint3.setAntiAlias(true);
        Paint paint4 = this.thumbPaint;
        if (paint4 != null) {
            paint4.setStrokeCap(Paint.Cap.ROUND);
        }
        Paint paint5 = this.thumbPaint;
        if (paint5 != null) {
            paint5.setColor(-1);
        }
        Paint paint6 = new Paint();
        this.shadowPaint = paint6;
        paint6.setColor(Color.parseColor("#662E3C83"));
        Paint paint7 = this.shadowPaint;
        if (paint7 == null) {
            return;
        }
        paint7.setMaskFilter(new BlurMaskFilter(i.d(this.shadowRadius), BlurMaskFilter.Blur.SOLID));
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        float f16 = w3;
        this.width = f16;
        float f17 = h16;
        this.height = f17;
        float f18 = this.thumbHeight;
        this.thumbWidth = f18;
        this.barWidth = f16 - f18;
        float f19 = 2;
        this.barStartX = f18 / f19;
        this.barStartY = (f17 / f19) - (this.barHeight / f19);
        super.onSizeChanged(w3, h16, oldw, oldh);
    }

    private final void h() {
        this.barHeight = i.e(12);
        this.thumbHeight = i.e(27);
    }

    public MultiHuePickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public /* synthetic */ MultiHuePickerView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }
}
