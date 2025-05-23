package com.tencent.sqshow.zootopia.nativeui.view.color.picker;

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
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.sqshow.zootopia.utils.i;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import tl.h;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 N2\u00020\u0001:\u0002\r\u0011B#\u0012\b\u0010G\u001a\u0004\u0018\u00010F\u0012\b\u0010I\u001a\u0004\u0018\u00010H\u0012\u0006\u0010J\u001a\u00020\u0006\u00a2\u0006\u0004\bK\u0010LB\u001f\b\u0017\u0012\b\u0010G\u001a\u0004\u0018\u00010F\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010H\u00a2\u0006\u0004\bK\u0010MJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J(\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0014J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J\u000e\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0006J\u000e\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001fR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\"R\u0016\u0010%\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010$R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010$R\u0016\u0010'\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010$R\u0016\u0010(\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010$R\u0016\u0010*\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010$R\u0016\u0010,\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010$R\u0016\u0010.\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010$R\u0016\u00100\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010$R\u0016\u00101\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010$R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00107\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00104R\u0016\u0010\u001d\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00108R\u0016\u0010:\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010$R\u0018\u0010<\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00104R\u0016\u0010>\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010$R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u00109\u00a8\u0006O"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/color/picker/HuePickerView;", "Landroid/view/View;", "", "e", "f", "g", "", "heightMeasureSpec", h.F, "widthMeasureSpec", "i", "Landroid/view/MotionEvent;", "event", "a", "", "update", "isUpAction", "b", "Landroid/graphics/Canvas;", PM.CANVAS, "c", "d", "onMeasure", "w", "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "onTouchEvent", "onDraw", "currentColor", "setCurrentColor", "Lcom/tencent/sqshow/zootopia/nativeui/view/color/picker/HuePickerView$b;", "onHueChangeListener", "setOnHueChangedListener", "Lcom/tencent/sqshow/zootopia/nativeui/view/color/picker/HuePickerView$b;", "", UserInfo.SEX_FEMALE, "width", "height", "barWidth", "barHeight", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "thumbWidth", BdhLogUtil.LogTag.Tag_Conn, "thumbHeight", "D", "currentThumbOffset", "E", "barStartX", "barStartY", "Landroid/graphics/Paint;", "G", "Landroid/graphics/Paint;", "barPaint", "H", "thumbPaint", "I", "J", "currentHue", "K", "shadowPaint", "L", NodeProps.SHADOW_RADIUS, "", "M", "[I", NodeProps.COLORS, "", "N", WadlProxyConsts.LAST_UPDATE_TIME, "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "P", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class HuePickerView extends View {
    private static int Q;

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
    private float currentHue;

    /* renamed from: K, reason: from kotlin metadata */
    private Paint shadowPaint;

    /* renamed from: L, reason: from kotlin metadata */
    private float shadowRadius;

    /* renamed from: M, reason: from kotlin metadata */
    private int[] colors;

    /* renamed from: N, reason: from kotlin metadata */
    private long lastUpdateTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private b onHueChangeListener;

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

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/color/picker/HuePickerView$b;", "", "", "hue", "", "update", "isUpAction", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface b {
        void a(float hue, boolean update, boolean isUpAction);
    }

    public HuePickerView(Context context) {
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

    private final void b(boolean update, boolean isUpAction) {
        float f16 = ((this.currentThumbOffset - (this.thumbWidth / 2.0f)) / this.barWidth) * 360;
        b bVar = this.onHueChangeListener;
        if (bVar != null) {
            bVar.a(f16, update, isUpAction);
        }
        this.currentColor = Color.HSVToColor(new float[]{f16, 1.0f, 1.0f});
        this.currentHue = f16;
    }

    private final void c(Canvas canvas) {
        LinearGradient linearGradient;
        Paint paint = this.barPaint;
        if (paint != null) {
            int[] iArr = this.colors;
            if (iArr != null) {
                float f16 = this.barStartX;
                float f17 = this.barStartY;
                float f18 = this.barHeight;
                float f19 = 2;
                linearGradient = new LinearGradient(f16, (f18 / f19) + f17, this.barWidth + f16, f17 + (f18 / f19), iArr, (float[]) null, Shader.TileMode.CLAMP);
            } else {
                linearGradient = null;
            }
            paint.setShader(linearGradient);
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
        float f16 = 2;
        float f17 = ((this.barWidth * this.currentHue) / 360.0f) + (this.thumbWidth / f16);
        this.currentThumbOffset = f17;
        Paint paint = this.shadowPaint;
        if (paint != null) {
            canvas.drawCircle(f17, this.height / f16, i.d(10.5f), paint);
        }
        Paint paint2 = this.thumbPaint;
        if (paint2 != null) {
            canvas.drawCircle(this.currentThumbOffset, this.height / f16, i.d(10.5f), paint2);
        }
    }

    private final void e() {
        f();
        Q = 0;
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

    private final int h(int heightMeasureSpec) {
        int coerceAtLeast;
        int coerceAtLeast2;
        int mode = View.MeasureSpec.getMode(heightMeasureSpec);
        int size = View.MeasureSpec.getSize(heightMeasureSpec);
        if (mode == Integer.MIN_VALUE) {
            float f16 = this.thumbHeight;
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i.b(2), (int) this.barHeight);
            return (int) (f16 + coerceAtLeast);
        }
        if (mode != 1073741824) {
            return size;
        }
        coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(Math.max((int) this.thumbHeight, (int) this.barHeight), size);
        return coerceAtLeast2;
    }

    private final int i(int widthMeasureSpec) {
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

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        c(canvas);
        d(canvas);
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(i(widthMeasureSpec), h(heightMeasureSpec));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        boolean z16;
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        boolean z17 = false;
        if (action == 0) {
            a(event);
            Q = 1;
            z16 = false;
            z17 = true;
        } else if (action == 1) {
            a(event);
            z16 = true;
            z17 = true;
        } else if (action != 2) {
            z16 = false;
        } else {
            a(event);
            boolean a16 = a.f30527a.a(this.lastUpdateTime);
            if (a16) {
                this.lastUpdateTime = System.currentTimeMillis();
            }
            z17 = a16;
            z16 = false;
        }
        b(z17, z16);
        invalidate();
        return true;
    }

    public final void setCurrentColor(int currentColor) {
        this.currentColor = da4.a.f393479a.b(currentColor);
        float[] fArr = new float[3];
        Color.RGBToHSV(Color.red(currentColor), Color.green(currentColor), Color.blue(currentColor), fArr);
        this.currentHue = fArr[0];
        invalidate();
    }

    public final void setOnHueChangedListener(b onHueChangeListener) {
        Intrinsics.checkNotNullParameter(onHueChangeListener, "onHueChangeListener");
        this.onHueChangeListener = onHueChangeListener;
    }

    public HuePickerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.shadowRadius = 4.0f;
        e();
        g();
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

    private final void f() {
        int[] iArr = new int[13];
        this.colors = iArr;
        float[] fArr = {0.0f, 1.0f, 1.0f};
        Intrinsics.checkNotNull(iArr);
        int length = iArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            float f16 = (i3 * 30) % 360;
            fArr[0] = f16;
            if (f16 == 360.0f) {
                fArr[0] = 359.0f;
            }
            int[] iArr2 = this.colors;
            Intrinsics.checkNotNull(iArr2);
            iArr2[i3] = Color.HSVToColor(fArr);
        }
    }

    private final void g() {
        this.barHeight = i.e(12);
        this.thumbHeight = i.e(27);
    }

    public HuePickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public /* synthetic */ HuePickerView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }
}
