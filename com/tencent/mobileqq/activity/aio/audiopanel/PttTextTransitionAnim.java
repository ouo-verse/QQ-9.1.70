package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class PttTextTransitionAnim extends ImageView {
    String C;
    String D;
    String E;
    float F;
    float G;
    float H;
    int I;
    int J;
    int K;
    float L;
    float M;
    float N;
    int P;
    private boolean Q;

    /* renamed from: d, reason: collision with root package name */
    private Context f178286d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f178287e;

    /* renamed from: f, reason: collision with root package name */
    int f178288f;

    /* renamed from: h, reason: collision with root package name */
    int f178289h;

    /* renamed from: i, reason: collision with root package name */
    int f178290i;

    /* renamed from: m, reason: collision with root package name */
    float f178291m;

    public PttTextTransitionAnim(Context context) {
        this(context, null);
    }

    private void a() {
        int color;
        float f16;
        Paint paint = new Paint();
        this.f178287e = paint;
        paint.setAntiAlias(true);
        boolean isNowElderMode = SimpleUIUtil.isNowElderMode();
        this.Q = isNowElderMode;
        Paint paint2 = this.f178287e;
        if (isNowElderMode) {
            color = Color.parseColor("#666666");
        } else {
            color = getResources().getColor(R.color.skin_gray2_theme_version2);
        }
        paint2.setColor(color);
        Paint paint3 = this.f178287e;
        if (this.Q) {
            f16 = 22.0f;
        } else {
            f16 = 16.0f;
        }
        paint3.setTextSize(ViewUtils.dip2px(f16));
        this.I = 255;
        this.J = 0;
        this.L = 0.0f;
        this.M = 0.0f;
        this.N = 0.0f;
        this.C = this.f178286d.getString(R.string.f170273ky);
        this.D = this.f178286d.getString(R.string.f170275l0);
        this.E = this.f178286d.getString(R.string.f6m);
        this.F = this.f178287e.measureText(this.C);
        this.G = this.f178287e.measureText(this.D);
        this.H = this.f178287e.measureText(this.E);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.C != null && this.D != null && this.E != null) {
            canvas.save();
            this.f178287e.setAlpha(this.I);
            canvas.drawText(this.C, (this.f178288f + this.L) - (this.F / 2.0f), this.f178289h, this.f178287e);
            this.f178287e.setAlpha(this.J);
            canvas.drawText(this.D, (this.f178288f + this.M) - (this.G / 2.0f), this.f178289h, this.f178287e);
            this.f178287e.setAlpha(this.K);
            canvas.drawText(this.E, (this.f178288f + this.N) - (this.H / 2.0f), this.f178289h, this.f178287e);
            canvas.restore();
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int i19;
        super.onLayout(z16, i3, i16, i17, i18);
        if (this.Q) {
            i19 = 20;
        } else {
            i19 = 0;
        }
        int i26 = (i17 - i3) / 2;
        this.f178288f = i26;
        this.f178289h = ((i18 - i16) / 2) + i19;
        this.f178290i = (int) (i26 * 0.8d);
        if (QLog.isColorLevel()) {
            QLog.d("PttTextTransitionAnim", 2, "onLayout " + toString());
        }
    }

    public void setCurrentItem(int i3) {
        this.P = i3;
        if (i3 == 0) {
            this.f178291m = 0.0f;
            setProgress(0.0f);
        } else if (i3 == 1) {
            this.f178291m = 0.5f;
            setProgress(0.5f);
        } else {
            this.f178291m = 1.0f;
            setProgress(1.0f);
        }
    }

    public void setProgress(float f16) {
        if (f16 <= 0.5f) {
            float f17 = 0.5f - f16;
            this.I = ((int) (f17 * 255.0f)) * 2;
            this.J = ((int) (255.0f * f16)) * 2;
            this.K = 0;
            int i3 = this.f178290i;
            this.L = (-i3) * f16 * 2.0f;
            this.M = i3 * f17 * 2.0f;
        } else {
            this.I = 0;
            float f18 = 1.0f - f16;
            this.J = (int) (f18 * 255.0f * 2.0f);
            float f19 = f16 - 0.5f;
            this.K = (int) (255.0f * f19 * 2.0f);
            int i16 = this.f178290i;
            this.M = (-i16) * f19 * 2.0f;
            this.N = i16 * f18 * 2.0f;
        }
        invalidate();
    }

    public void setScrollDis(float f16, int i3) {
        setProgress(this.f178291m + ((f16 / i3) / 2.0f));
    }

    @Override // android.view.View
    public String toString() {
        return "PttTextTransitionAnim{ progress=" + this.f178291m + ", alphaVoiceChange=" + this.I + ", alphaPressToSpeak=" + this.J + ", alphaRecord=" + this.K + ", tranlateXVoiceChange=" + this.L + ", tranlateXPressToSpeak=" + this.M + ", tranlateXRecord=" + this.N + ", centerX=" + this.f178288f + ", centerY=" + this.f178289h + '}';
    }

    public PttTextTransitionAnim(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PttTextTransitionAnim(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.I = 255;
        this.J = 0;
        this.K = 0;
        this.P = -1;
        this.f178286d = context;
        a();
    }
}
