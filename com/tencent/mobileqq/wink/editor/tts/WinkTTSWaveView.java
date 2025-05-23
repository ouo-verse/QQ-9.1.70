package com.tencent.mobileqq.wink.editor.tts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkTTSWaveView extends View {
    private static final int N = ViewUtils.dip2px(2.0f);
    private static final int P = ViewUtils.dip2px(4.0f);
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private Paint I;
    private Paint J;
    private Paint K;
    private RectF L;
    private int[] M;

    /* renamed from: d, reason: collision with root package name */
    private float f322553d;

    /* renamed from: e, reason: collision with root package name */
    private float f322554e;

    /* renamed from: f, reason: collision with root package name */
    private float f322555f;

    /* renamed from: h, reason: collision with root package name */
    private int f322556h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f322557i;

    /* renamed from: m, reason: collision with root package name */
    private int f322558m;

    public WinkTTSWaveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f322553d = 0.0f;
        this.f322554e = 0.0f;
        this.f322555f = 0.0f;
        this.f322557i = new Paint();
        this.I = new Paint();
        this.J = new Paint();
        this.K = new Paint();
        this.L = new RectF();
        this.M = new int[]{ViewUtils.dip2px(10.6f), ViewUtils.dip2px(9.65f), ViewUtils.dip2px(23.16f), ViewUtils.dip2px(9.65f), ViewUtils.dip2px(14.47f), ViewUtils.dip2px(18.33f)};
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public void a(int i3, int i16, int i17, int i18) {
        this.C = i16;
        if (i16 == 0) {
            this.C = 60000;
        }
        this.f322558m = i3;
        this.f322556h = 0;
        this.F = i17;
        this.D = i18;
        int i19 = i17 - (0 * 2);
        this.G = i19;
        int i26 = this.C;
        if (i3 >= i26) {
            this.E = i17;
        } else {
            this.E = ((int) (((i3 * 1.0f) / i26) * i19)) + (0 * 2);
        }
        this.I.setAntiAlias(true);
        this.J.setAntiAlias(true);
        this.K.setAntiAlias(true);
        this.K.setFilterBitmap(true);
        this.K.setDither(true);
        int i27 = this.f322558m;
        int i28 = this.C;
        if (i27 < i28) {
            this.H = (int) (((((i27 * 1.0f) / i28) * this.G) + (this.f322556h * 2)) / P);
        } else {
            this.H = (int) ((this.E * 1.0f) / P);
        }
        this.f322557i.setAntiAlias(true);
        requestLayout();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (canvas == null) {
            ms.a.f("WinkTTSWaveView", "draw:canvas is null.");
            return;
        }
        canvas.save();
        int color = getContext().getResources().getColor(R.color.ber);
        int i3 = this.F;
        int i16 = P;
        int max = Math.max(Math.min(0, this.H), (int) Math.ceil(1.0d / i16));
        int min = Math.min((i3 / i16) + max, this.H);
        RectF rectF = this.L;
        rectF.left = N;
        rectF.top = 0.0f;
        rectF.bottom = this.D;
        rectF.right = i16;
        while (max < min) {
            int i17 = this.M[(max + 3) % 6];
            RectF rectF2 = this.L;
            float f16 = (this.D - i17) / 2;
            rectF2.top = f16;
            rectF2.bottom = f16 + i17;
            this.I.setColor(color);
            canvas.drawRect(this.L, this.I);
            RectF rectF3 = this.L;
            float f17 = rectF3.left;
            int i18 = P;
            rectF3.left = f17 + i18;
            rectF3.right += i18;
            max++;
        }
        canvas.restore();
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        setMeasuredDimension(View.MeasureSpec.getSize(i3), this.D);
    }
}
