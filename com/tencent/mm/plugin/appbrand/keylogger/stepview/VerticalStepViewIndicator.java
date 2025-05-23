package com.tencent.mm.plugin.appbrand.keylogger.stepview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.luggage.wxa.k0.d;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class VerticalStepViewIndicator extends View {
    public List C;
    public Paint D;
    public Paint E;
    public int F;
    public int G;
    public PathEffect H;
    public int I;
    public Path J;
    public a K;
    public Rect L;
    public int M;
    public boolean N;

    /* renamed from: a, reason: collision with root package name */
    public final String f152215a;

    /* renamed from: b, reason: collision with root package name */
    public int f152216b;

    /* renamed from: c, reason: collision with root package name */
    public float f152217c;

    /* renamed from: d, reason: collision with root package name */
    public float f152218d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f152219e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f152220f;

    /* renamed from: g, reason: collision with root package name */
    public Drawable f152221g;

    /* renamed from: h, reason: collision with root package name */
    public Drawable f152222h;

    /* renamed from: i, reason: collision with root package name */
    public float f152223i;

    /* renamed from: j, reason: collision with root package name */
    public float f152224j;

    /* renamed from: k, reason: collision with root package name */
    public float f152225k;

    /* renamed from: l, reason: collision with root package name */
    public List f152226l;

    /* renamed from: m, reason: collision with root package name */
    public float f152227m;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        void a();
    }

    public VerticalStepViewIndicator(Context context) {
        this(context, null);
    }

    public final void a() {
        this.J = new Path();
        this.H = new DashPathEffect(new float[]{8.0f, 8.0f, 8.0f, 8.0f}, 1.0f);
        this.C = new ArrayList();
        this.D = new Paint();
        this.E = new Paint();
        this.D.setAntiAlias(true);
        this.D.setColor(this.F);
        this.D.setStyle(Paint.Style.STROKE);
        this.D.setStrokeWidth(2.0f);
        this.E.setAntiAlias(true);
        this.E.setColor(this.G);
        this.E.setStyle(Paint.Style.STROKE);
        this.E.setStrokeWidth(2.0f);
        this.D.setPathEffect(this.H);
        this.E.setStyle(Paint.Style.FILL);
        float f16 = this.f152216b;
        this.f152217c = 0.05f * f16;
        this.f152218d = 0.28f * f16;
        this.f152227m = f16 * 0.85f;
        this.f152219e = ContextCompat.getDrawable(getContext(), R.drawable.o3w);
        this.f152220f = ContextCompat.getDrawable(getContext(), R.drawable.o3u);
        this.f152221g = ContextCompat.getDrawable(getContext(), R.drawable.o3x);
        this.f152222h = ContextCompat.getDrawable(getContext(), R.drawable.o3v);
        this.N = true;
    }

    public List<Float> getCircleCenterPointPositionList() {
        return this.C;
    }

    public float getCircleRadius() {
        return this.f152218d;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.i(this.f152215a, "onDraw");
        a aVar = this.K;
        if (aVar != null) {
            aVar.a();
        }
        this.D.setColor(this.F);
        this.E.setColor(this.G);
        int i3 = 0;
        while (i3 < this.C.size() - 1) {
            float floatValue = ((Float) this.C.get(i3)).floatValue();
            int i16 = i3 + 1;
            float floatValue2 = ((Float) this.C.get(i16)).floatValue();
            if (i3 < this.I) {
                if (this.N) {
                    float f16 = this.f152224j;
                    float f17 = this.f152218d;
                    canvas.drawRect(f16, (floatValue2 + f17) - 10.0f, this.f152225k, (floatValue - f17) + 10.0f, this.E);
                } else {
                    float f18 = this.f152224j;
                    float f19 = this.f152218d;
                    canvas.drawRect(f18, (floatValue + f19) - 10.0f, this.f152225k, (floatValue2 - f19) + 10.0f, this.E);
                }
            } else if (this.N) {
                this.J.moveTo(this.f152223i, floatValue2 + this.f152218d);
                this.J.lineTo(this.f152223i, floatValue - this.f152218d);
                canvas.drawPath(this.J, this.D);
            } else {
                this.J.moveTo(this.f152223i, floatValue + this.f152218d);
                this.J.lineTo(this.f152223i, floatValue2 - this.f152218d);
                canvas.drawPath(this.J, this.D);
            }
            i3 = i16;
        }
        if (this.C.size() <= 0) {
            return;
        }
        float floatValue3 = ((Float) this.C.get(0)).floatValue();
        float f26 = this.f152223i;
        float f27 = this.f152218d;
        this.L = new Rect((int) (f26 - f27), (int) (floatValue3 - f27), (int) (f26 + f27), (int) (floatValue3 + f27));
        d.a(this.f152226l.get(0));
        throw null;
    }

    @Override // android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        Log.i(this.f152215a, "onMeasure");
        int i17 = this.f152216b;
        this.M = 0;
        int size = this.f152226l.size();
        if (size > 0) {
            this.M = (int) (getPaddingTop() + getPaddingBottom() + (this.f152218d * 2.0f * size) + ((size - 1) * this.f152227m));
        }
        if (View.MeasureSpec.getMode(i3) != 0) {
            i17 = Math.min(i17, View.MeasureSpec.getSize(i3));
        }
        setMeasuredDimension(i17, this.M);
    }

    @Override // android.view.View
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        Log.i(this.f152215a, MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED);
        float width = getWidth() / 2;
        this.f152223i = width;
        float f16 = this.f152217c / 2.0f;
        this.f152224j = width - f16;
        this.f152225k = width + f16;
        for (int i19 = 0; i19 < this.f152226l.size(); i19++) {
            if (this.N) {
                List list = this.C;
                float f17 = this.M;
                float f18 = this.f152218d;
                float f19 = i19;
                list.add(Float.valueOf(f17 - ((f18 + ((f19 * f18) * 2.0f)) + (f19 * this.f152227m))));
            } else {
                List list2 = this.C;
                float f26 = this.f152218d;
                float f27 = i19;
                list2.add(Float.valueOf(f26 + (f27 * f26 * 2.0f) + (f27 * this.f152227m)));
            }
        }
        a aVar = this.K;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void setAttentionIcon(Drawable drawable) {
        this.f152220f = drawable;
    }

    public void setComplectingPosition(int i3) {
        this.I = i3;
        requestLayout();
    }

    public void setCompleteIcon(Drawable drawable) {
        this.f152219e = drawable;
    }

    public void setCompletedLineColor(int i3) {
        this.G = i3;
    }

    public void setDefaultIcon(Drawable drawable) {
        this.f152221g = drawable;
    }

    public void setIndicatorLinePaddingProportion(float f16) {
        this.f152227m = f16 * this.f152216b;
    }

    public void setOnDrawListener(a aVar) {
        this.K = aVar;
    }

    public void setSteps(List<Object> list) {
        if (list == null) {
            this.f152226l = new ArrayList();
        } else {
            this.f152226l = list;
            requestLayout();
        }
    }

    public void setUnCompletedLineColor(int i3) {
        this.F = i3;
    }

    public VerticalStepViewIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VerticalStepViewIndicator(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f152215a = getClass().getSimpleName();
        this.f152216b = (int) TypedValue.applyDimension(1, 40.0f, getResources().getDisplayMetrics());
        this.f152226l = new ArrayList();
        this.F = ContextCompat.getColor(getContext(), R.color.cxo);
        this.G = -1;
        a();
    }
}
