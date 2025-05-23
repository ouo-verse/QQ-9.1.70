package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class m extends DynamicTextItem {
    public static final float C;
    public static final float D;
    public static final float E;
    public static final float F;
    public static final float G;
    public static final float H;
    public static final float I;
    public static final float J;
    float A;
    float B;

    /* renamed from: p, reason: collision with root package name */
    private StaticLayout f67094p;

    /* renamed from: q, reason: collision with root package name */
    private Bitmap f67095q;

    /* renamed from: r, reason: collision with root package name */
    private Bitmap f67096r;

    /* renamed from: s, reason: collision with root package name */
    private TextPaint f67097s;

    /* renamed from: t, reason: collision with root package name */
    private Paint f67098t;

    /* renamed from: u, reason: collision with root package name */
    private float f67099u;

    /* renamed from: v, reason: collision with root package name */
    private float f67100v;

    /* renamed from: w, reason: collision with root package name */
    float f67101w;

    /* renamed from: x, reason: collision with root package name */
    DrawFilter f67102x;

    /* renamed from: y, reason: collision with root package name */
    private RectF f67103y;

    /* renamed from: z, reason: collision with root package name */
    float f67104z;

    static {
        float f16 = BaseApplication.getContext().getResources().getDisplayMetrics().density;
        C = 2.0f * f16;
        D = 13.0f * f16;
        E = 1.0f * f16;
        float f17 = 5.0f * f16;
        F = f17;
        G = 15.0f * f16;
        H = f17;
        I = f17;
        J = f16 * 6.0f;
    }

    public m(int i3, List<String> list, Typeface typeface, Bitmap bitmap, Bitmap bitmap2) {
        super(i3, list);
        boolean z16;
        this.f67102x = new PaintFlagsDrawFilter(0, 3);
        this.f67103y = new RectF();
        TextPaint textPaint = new TextPaint();
        this.f67097s = textPaint;
        textPaint.setAntiAlias(true);
        this.f67097s.setTypeface(typeface);
        this.f67097s.setTextSize(BaseAIOUtils.f(20.0f, BaseApplication.getContext().getResources()));
        this.f67097s.setTextSkewX(-0.25f);
        this.f67097s.setColor(-6741743);
        try {
            Paint.class.getDeclaredMethod("setLetterSpacing", Float.TYPE).invoke(this.f67097s, Float.valueOf(0.4f));
            z16 = true;
        } catch (Exception e16) {
            e16.printStackTrace();
            z16 = false;
        }
        QLog.i(com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g.f67980d0, 1, "setLetterSpacing" + z16);
        Paint paint = new Paint();
        this.f67098t = paint;
        paint.setColor(-1);
        this.f67098t.setAntiAlias(true);
        this.f67098t.setStrokeWidth(2.0f);
        this.f67098t.setStyle(Paint.Style.STROKE);
        this.f67096r = bitmap;
        this.f67095q = bitmap2;
        if (list.isEmpty()) {
            return;
        }
        M(0, list.get(0));
    }

    private void Q(Canvas canvas) {
        float f16;
        canvas.save();
        canvas.translate(this.f67099u - this.f67096r.getWidth(), 0.0f);
        canvas.drawBitmap(this.f67096r, 0.0f, 0.0f, (Paint) null);
        canvas.restore();
        canvas.save();
        canvas.translate(this.A, this.B);
        canvas.drawBitmap(this.f67095q, 0.0f, 0.0f, (Paint) null);
        canvas.restore();
        canvas.save();
        if (this.A > 0.0f) {
            f16 = D;
        } else {
            f16 = D + ((this.f67099u - this.f67104z) * 0.5f);
        }
        canvas.translate(f16 - ((this.f67094p.getWidth() - this.f67101w) * 0.5f), H + this.f67096r.getHeight());
        canvas.save();
        float f17 = C;
        canvas.translate(-f17, -f17);
        this.f67097s.setColor(SupportMenu.CATEGORY_MASK);
        this.f67094p.draw(canvas);
        canvas.restore();
        canvas.save();
        canvas.translate(f17, f17);
        this.f67097s.setColor(-16776961);
        this.f67094p.draw(canvas);
        canvas.restore();
        this.f67097s.setColor(-1);
        this.f67094p.draw(canvas);
        if (super.H(0)) {
            float height = this.f67094p.getHeight();
            float width = this.f67094p.getWidth() / 2.0f;
            RectF rectF = this.f67103y;
            float f18 = this.f67101w;
            rectF.left = width - (f18 / 2.0f);
            rectF.top = -f17;
            rectF.right = width + (f18 / 2.0f);
            rectF.bottom = height + f17;
            canvas.drawRoundRect(rectF, 6.0f, 6.0f, j());
        }
        canvas.restore();
        canvas.save();
        canvas.translate(0.0f, this.f67100v - E);
        canvas.drawLine(0.0f, 0.0f, this.f67099u, 0.0f, this.f67098t);
        canvas.restore();
    }

    private void R(Canvas canvas) {
        canvas.save();
        canvas.translate(this.f67099u - this.f67096r.getWidth(), 0.0f);
        canvas.drawBitmap(this.f67096r, 0.0f, 0.0f, (Paint) null);
        canvas.restore();
        canvas.save();
        float height = this.f67096r.getHeight();
        float f16 = G;
        canvas.translate(0.0f, (height + f16) - (this.f67095q.getHeight() + I));
        canvas.drawBitmap(this.f67095q, 0.0f, 0.0f, (Paint) null);
        canvas.restore();
        canvas.save();
        canvas.translate(D - ((this.f67094p.getWidth() - this.f67101w) * 0.5f), f16 + this.f67096r.getHeight());
        canvas.save();
        float f17 = C;
        canvas.translate(-f17, -f17);
        this.f67097s.setColor(SupportMenu.CATEGORY_MASK);
        this.f67094p.draw(canvas);
        canvas.restore();
        canvas.save();
        canvas.translate(f17, f17);
        this.f67097s.setColor(-16776961);
        this.f67094p.draw(canvas);
        canvas.restore();
        this.f67097s.setColor(-1);
        this.f67094p.draw(canvas);
        if (super.H(0)) {
            float height2 = this.f67094p.getHeight();
            float width = this.f67094p.getWidth() / 2.0f;
            RectF rectF = this.f67103y;
            float f18 = this.f67101w;
            rectF.left = width - (f18 / 2.0f);
            rectF.top = -f17;
            rectF.right = width + (f18 / 2.0f);
            rectF.bottom = height2 + f17;
            canvas.drawRoundRect(rectF, 6.0f, 6.0f, j());
        }
        canvas.restore();
        canvas.save();
        canvas.translate(0.0f, this.f67100v - E);
        canvas.drawLine(0.0f, 0.0f, this.f67099u, 0.0f, this.f67098t);
        canvas.restore();
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public boolean F() {
        return true;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public void I(Canvas canvas) {
        canvas.setDrawFilter(this.f67102x);
        if (this.f67094p.getLineCount() == 1) {
            R(canvas);
        } else {
            Q(canvas);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public void M(int i3, String str) {
        super.M(i3, str);
        String k3 = super.k(i3);
        if (TextUtils.isEmpty(k3)) {
            k3 = "\u3000\u3000";
        }
        StaticLayout staticLayout = new StaticLayout(k3, this.f67097s, (int) this.f67097s.measureText(HardCodeUtil.qqStr(R.string.mu6)), Layout.Alignment.ALIGN_CENTER, 1.2f, 0.0f, false);
        this.f67094p = staticLayout;
        this.f67101w = 0.0f;
        int lineCount = staticLayout.getLineCount();
        for (int i16 = 0; i16 < lineCount; i16++) {
            this.f67101w = Math.max(this.f67094p.getLineWidth(i16), this.f67101w);
        }
        float f16 = this.f67101w;
        float f17 = C;
        float f18 = f16 + (f17 * 2.0f) + (D * 2.0f);
        this.f67104z = f18;
        if (lineCount == 1) {
            this.f67099u = f18;
            this.f67100v = this.f67094p.getHeight() + (f17 * 2.0f) + E + F + G + this.f67096r.getHeight();
            return;
        }
        float lineWidth = ((this.f67094p.getLineWidth(lineCount - 2) * 0.5f) + J + this.f67095q.getWidth()) * 2.0f;
        this.f67099u = Math.max(this.f67104z, lineWidth);
        float height = this.f67094p.getHeight() + (f17 * 2.0f) + E + F;
        float f19 = H;
        this.f67100v = height + f19 + this.f67096r.getHeight();
        float f26 = this.f67104z;
        this.A = lineWidth <= f26 ? (f26 - lineWidth) * 0.5f : 0.0f;
        this.B = ((this.f67094p.getLineBottom(r9) - this.f67097s.descent()) - this.f67095q.getHeight()) + this.f67096r.getHeight() + f19;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public int h() {
        return 0;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float m() {
        return this.f67100v;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public int o() {
        return 1;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float w() {
        return this.f67099u;
    }
}
