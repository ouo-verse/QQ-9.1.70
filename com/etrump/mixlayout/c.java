package com.etrump.mixlayout;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.style.CharacterStyle;
import com.etrump.mixlayout.api.IETFontAdapter;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private f f32689a;

    /* renamed from: b, reason: collision with root package name */
    private String f32690b;

    /* renamed from: c, reason: collision with root package name */
    private CharacterStyle f32691c;

    /* renamed from: d, reason: collision with root package name */
    private int f32692d;

    /* renamed from: e, reason: collision with root package name */
    private int f32693e;

    /* renamed from: f, reason: collision with root package name */
    private int f32694f;

    /* renamed from: g, reason: collision with root package name */
    private int f32695g;

    /* renamed from: h, reason: collision with root package name */
    private int f32696h;

    /* renamed from: i, reason: collision with root package name */
    private int f32697i;

    /* renamed from: j, reason: collision with root package name */
    private int f32698j;

    /* renamed from: k, reason: collision with root package name */
    private int f32699k;

    public c(String str) {
        this.f32692d = -1;
        this.f32697i = -1;
        this.f32698j = 0;
        this.f32699k = 0;
        this.f32690b = str;
        this.f32695g = -1;
        this.f32696h = 0;
    }

    private void a(ETEngine eTEngine) {
        ETFont d16 = this.f32689a.d();
        if (d16 != null && eTEngine != null) {
            String str = this.f32690b;
            if (str != null && str.length() != 0) {
                Paint.FontMetrics fontMetrics = new Paint.FontMetrics();
                eTEngine.native_getFontMetrics(fontMetrics, d16);
                this.f32697i = (int) Math.abs(fontMetrics.descent);
                return;
            }
            this.f32697i = 0;
            return;
        }
        this.f32697i = 0;
    }

    private void d(Canvas canvas, Paint paint, ETFont eTFont, int i3, int i16, int i17) {
        if (paint == null) {
            paint = new Paint();
        }
        Paint paint2 = paint;
        paint2.reset();
        paint2.setColor(eTFont.getColor());
        paint2.setStrokeWidth(eTFont.getSize() / 12);
        float f16 = (i16 + i17) - 3;
        canvas.drawLine(i3, f16, this.f32693e + i3, f16, paint2);
    }

    private void w(Canvas canvas, int i3, int i16, Paint paint) {
        IETFontAdapter.INSTANCE.getInstance().systemDrawSpan(canvas, i3, i16, paint, this.f32691c, g());
    }

    private void x(Canvas canvas, Paint paint, ETFont eTFont, int i3, int i16) {
        if (paint == null) {
            paint = new Paint();
        }
        paint.reset();
        paint.setColor(eTFont.getColor());
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setTextSize(eTFont.getSize());
        canvas.drawText(this.f32690b, i3, i16 - ((int) paint.getFontMetrics().ascent), paint);
    }

    public i[] b(ETEngine eTEngine, int i3, int i16, int i17, int i18) {
        int i19 = this.f32696h;
        int i26 = 0;
        if (2 != i19 && 1 != i19) {
            ETFont d16 = this.f32689a.d();
            Paint paint = new Paint();
            paint.setTextSize(d16.getSize());
            int length = this.f32690b.length();
            int[] iArr = new int[length];
            eTEngine.native_getTextWidths(this.f32690b, d16, paint, iArr);
            i[] iVarArr = new i[length];
            while (i26 < length) {
                int i27 = iArr[i26] + i3;
                Rect rect = new Rect(i3, i16, i27, i16 + i17);
                i iVar = new i();
                iVar.f32745b = i18;
                iVar.f32744a = String.valueOf(this.f32690b.charAt(i26));
                iVar.f32746c = rect;
                iVarArr[i26] = iVar;
                i26++;
                i3 = i27;
            }
            return iVarArr;
        }
        Rect rect2 = new Rect(i3, i16, this.f32693e + i3, i17 + i16);
        i iVar2 = new i();
        iVar2.f32744a = this.f32690b;
        iVar2.f32746c = rect2;
        iVar2.f32745b = i18;
        return new i[]{iVar2};
    }

    public void c(Canvas canvas, int i3, int i16, int i17) {
        ETFont d16;
        if (canvas != null && this.f32689a != null) {
            Paint paint = new Paint();
            if (this.f32691c == null && (d16 = this.f32689a.d()) != null && this.f32689a.h()) {
                d(canvas, paint, d16, i3, i16, i17);
            }
        }
    }

    public void e(ETEngine eTEngine, Bitmap bitmap, ETDecoration eTDecoration, int i3, int i16) {
        String str;
        if (eTEngine != null && bitmap != null && this.f32689a != null && (str = this.f32690b) != null && str.length() != 0 && this.f32696h == 0) {
            ETFont d16 = this.f32689a.d();
            if (eTDecoration == null) {
                eTEngine.native_drawText(this.f32690b, bitmap, i3, i16, d16);
            } else if (1 == eTDecoration.getDecorationType()) {
                eTDecoration.drawFrameText(this.f32698j, this.f32699k, bitmap, i3, i16, d16);
            }
        }
    }

    public int f(ETEngine eTEngine) {
        if (this.f32697i < 0) {
            a(eTEngine);
        }
        return this.f32697i;
    }

    public int g() {
        ETFont d16 = this.f32689a.d();
        if (d16 != null) {
            return d16.getSize();
        }
        return 16;
    }

    public int h() {
        return this.f32694f;
    }

    public int i() {
        return this.f32695g;
    }

    public String j() {
        if (this.f32696h == 0) {
            return this.f32690b;
        }
        return null;
    }

    public CharacterStyle k() {
        return this.f32691c;
    }

    public int l() {
        return this.f32692d;
    }

    public String m() {
        if (1 == this.f32696h) {
            return this.f32690b;
        }
        return null;
    }

    public int n() {
        return this.f32693e;
    }

    public void o(int i3) {
        this.f32694f = i3;
    }

    public void p(int i3) {
        this.f32695g = i3;
    }

    public void q(int i3) {
        if (this.f32696h == 0) {
            this.f32698j = i3;
            this.f32699k = i3 + this.f32690b.length();
        } else {
            this.f32698j = 0;
            this.f32699k = 0;
        }
    }

    public void r(f fVar) {
        this.f32689a = fVar;
    }

    public void s(String str) {
        this.f32690b = str;
    }

    public void t(int i3) {
        this.f32696h = i3;
    }

    public void u(int i3) {
        this.f32693e = i3;
    }

    public void v(Canvas canvas, int i3, int i16, int i17) {
        if (canvas != null && this.f32689a != null) {
            Paint paint = new Paint();
            if (this.f32689a.g()) {
                paint.setColor(this.f32689a.b());
                paint.setStyle(Paint.Style.FILL);
                canvas.drawRect(new Rect(i3, i16, this.f32693e + i3, i16 + i17), paint);
            }
            if (this.f32691c != null) {
                w(canvas, i3, (i16 + i17) - this.f32694f, paint);
                return;
            }
            ETFont d16 = this.f32689a.d();
            if (d16 == null) {
                return;
            }
            if (this.f32689a.h()) {
                d(canvas, paint, d16, i3, i16, i17);
            }
            if (this.f32690b != null && this.f32696h == 1) {
                x(canvas, paint, d16, i3, i16);
            }
        }
    }

    public c(CharacterStyle characterStyle, int i3) {
        this.f32692d = -1;
        this.f32697i = -1;
        this.f32698j = 0;
        this.f32699k = 0;
        this.f32691c = characterStyle;
        IETFontAdapter.Companion companion = IETFontAdapter.INSTANCE;
        this.f32693e = companion.getInstance().getSpanWidth(characterStyle);
        this.f32694f = companion.getInstance().getSpanHeight(characterStyle);
        this.f32692d = i3;
        this.f32696h = 2;
    }
}
