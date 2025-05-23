package com.tencent.aelight.camera.ae.gif.giftext;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.aelight.camera.ae.font.AEFontManager;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEGIFOutlineTextView extends View {
    private Canvas C;
    private String D;
    private float E;
    private float F;
    private float G;
    private String H;
    private boolean I;
    private boolean J;

    /* renamed from: d, reason: collision with root package name */
    private TextPaint f65342d;

    /* renamed from: e, reason: collision with root package name */
    private TextPaint f65343e;

    /* renamed from: f, reason: collision with root package name */
    private int f65344f;

    /* renamed from: h, reason: collision with root package name */
    private Rect f65345h;

    /* renamed from: i, reason: collision with root package name */
    private String f65346i;

    /* renamed from: m, reason: collision with root package name */
    private Bitmap f65347m;

    public AEGIFOutlineTextView(Context context) {
        super(context);
        this.f65342d = new TextPaint();
        this.f65343e = new TextPaint();
        this.f65344f = 0;
        this.f65345h = new Rect();
        this.f65346i = "";
        this.E = 0.0f;
        this.F = 0.0f;
        this.G = 0.0f;
        this.H = "#00FFFFFF";
        this.I = false;
        this.J = true;
    }

    private void a(String str, Paint paint, int i3, int i16, int i17) {
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        while (true) {
            if (rect.width() + i17 <= i3 * 1.0f && rect.height() + i17 <= i16 * 1.0f) {
                return;
            }
            paint.setTextSize(paint.getTextSize() - 2.0f);
            paint.getTextBounds(str, 0, str.length(), rect);
        }
    }

    private void b(Canvas canvas, String str, float f16, float f17, Paint paint) {
        canvas.drawText(str, f16, f17, paint);
    }

    private void f() {
        Typeface e16 = AEFontManager.d().e(this.D);
        this.f65342d.setTypeface(e16);
        this.f65343e.setTypeface(e16);
    }

    public Bitmap c() {
        return this.f65347m;
    }

    public float d() {
        return this.f65342d.getTextSize();
    }

    public float e() {
        return this.f65342d.getStrokeWidth();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        f();
        this.f65343e.setTextSize(this.f65342d.getTextSize());
        this.f65343e.setStyle(Paint.Style.STROKE);
        this.f65343e.setStrokeWidth(this.f65344f);
        this.f65342d.setAntiAlias(true);
        this.f65343e.setAntiAlias(true);
        TextPaint textPaint = this.f65342d;
        String str = this.f65346i;
        textPaint.getTextBounds(str, 0, str.length(), this.f65345h);
        if (this.J) {
            this.f65342d.setShadowLayer(this.E, this.F, this.G, Color.parseColor(this.H));
        } else {
            this.f65342d.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        }
        float height = this.f65345h.height();
        int indexOf = this.f65346i.indexOf("\r\n");
        if (indexOf < 0) {
            if (TextUtils.isEmpty(this.f65346i)) {
                return;
            }
            a(this.f65346i, this.f65343e, getWidth(), getHeight(), this.f65344f);
            this.f65342d.setTextSize(this.f65343e.getTextSize());
            float abs = (height / 2.0f) + ((Math.abs(this.f65342d.ascent()) - this.f65342d.descent()) / 2.0f);
            if (this.I) {
                b(this.C, this.f65346i, (getWidth() - this.f65343e.measureText(this.f65346i)) / 2.0f, ((getHeight() - height) / 2.0f) + abs, this.f65343e);
            }
            b(this.C, this.f65346i, (getWidth() - this.f65342d.measureText(this.f65346i)) / 2.0f, ((getHeight() - height) / 2.0f) + abs, this.f65342d);
        } else {
            String substring = this.f65346i.substring(0, indexOf);
            String substring2 = this.f65346i.substring(indexOf + 2);
            a(substring, this.f65343e, getWidth(), getHeight() / 2, this.f65344f);
            this.f65342d.setTextSize(this.f65343e.getTextSize());
            float f16 = height / 2.0f;
            float abs2 = f16 + ((Math.abs(this.f65342d.ascent()) - this.f65342d.descent()) / 2.0f);
            if (this.I) {
                b(this.C, substring, (getWidth() - this.f65343e.measureText(substring)) / 2.0f, ((getHeight() * 0.35f) - f16) + abs2, this.f65343e);
            }
            b(this.C, substring, (getWidth() - this.f65342d.measureText(substring)) / 2.0f, ((getHeight() * 0.35f) - f16) + abs2, this.f65342d);
            if (this.I) {
                b(this.C, substring2, (getWidth() - this.f65343e.measureText(substring2)) / 2.0f, ((getHeight() * 0.75f) - f16) + abs2, this.f65343e);
            }
            b(this.C, substring2, (getWidth() - this.f65342d.measureText(substring2)) / 2.0f, ((getHeight() * 0.75f) - f16) + abs2, this.f65342d);
        }
        canvas.drawBitmap(this.f65347m, 0.0f, 0.0f, this.f65342d);
    }

    public void setFontId(String str) {
        this.D = str;
    }

    public void setOutlineColor(String str) {
        this.f65343e.setColor(Color.parseColor(str));
    }

    public void setOutlineWidth(int i3) {
        this.f65344f = i3;
    }

    public void setShadow(boolean z16) {
        this.J = z16;
    }

    public void setShadowParam(float f16, float f17, float f18, String str) {
        this.E = f16;
        this.F = f17;
        this.G = f18;
        this.H = str;
    }

    public void setStroke(boolean z16) {
        this.I = z16;
    }

    public void setText(String str) {
        this.f65346i = str.trim();
        Bitmap bitmap = this.f65347m;
        if (bitmap != null) {
            bitmap.eraseColor(0);
            invalidate();
        }
    }

    public void setTextColor(String str) {
        this.f65342d.setColor(Color.parseColor(str));
    }

    public void setTextSize(float f16) {
        this.f65342d.setTextSize(f16);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        if (i3 == i17 && i16 == i18) {
            return;
        }
        Bitmap bitmap = this.f65347m;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f65347m.recycle();
        }
        this.f65347m = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        this.C = new Canvas(this.f65347m);
    }

    public AEGIFOutlineTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f65342d = new TextPaint();
        this.f65343e = new TextPaint();
        this.f65344f = 0;
        this.f65345h = new Rect();
        this.f65346i = "";
        this.E = 0.0f;
        this.F = 0.0f;
        this.G = 0.0f;
        this.H = "#00FFFFFF";
        this.I = false;
        this.J = true;
    }

    public AEGIFOutlineTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f65342d = new TextPaint();
        this.f65343e = new TextPaint();
        this.f65344f = 0;
        this.f65345h = new Rect();
        this.f65346i = "";
        this.E = 0.0f;
        this.F = 0.0f;
        this.G = 0.0f;
        this.H = "#00FFFFFF";
        this.I = false;
        this.J = true;
    }
}
