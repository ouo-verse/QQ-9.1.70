package com.tencent.lyric.data;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.Log;
import com.tencent.lyric.widget.LyricViewInternalPractice;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final String f147077a;

    /* renamed from: b, reason: collision with root package name */
    private final int f147078b;

    /* renamed from: c, reason: collision with root package name */
    private final int f147079c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList<b> f147080d;

    /* renamed from: e, reason: collision with root package name */
    public long f147081e;

    /* renamed from: f, reason: collision with root package name */
    public long f147082f;

    public f(String str, int i3, int i16, ArrayList<b> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), arrayList);
            return;
        }
        this.f147081e = 0L;
        this.f147082f = 0L;
        this.f147078b = i3;
        this.f147079c = i16;
        this.f147077a = str;
        this.f147080d = arrayList;
        if (arrayList != null && arrayList.size() > 0) {
            this.f147081e = arrayList.get(0).f147062a;
            b bVar = arrayList.get(arrayList.size() - 1);
            this.f147082f = bVar.f147062a + bVar.f147063b;
        }
    }

    private float f(Paint paint, float f16) {
        return f16 + paint.getFontMetrics().bottom;
    }

    private float g(Paint paint, float f16) {
        return f(paint, f16) + 10.0f;
    }

    public void a(Canvas canvas, int i3, int i16, Paint paint, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, canvas, Integer.valueOf(i3), Integer.valueOf(i16), paint, Boolean.valueOf(z16));
        }
    }

    public void b(Canvas canvas, int i3, int i16, Paint paint, int i17, boolean z16) {
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, canvas, Integer.valueOf(i3), Integer.valueOf(i16), paint, Integer.valueOf(i17), Boolean.valueOf(z16));
            return;
        }
        if (z16) {
            i18 = this.f147079c;
        } else {
            i18 = this.f147078b;
        }
        int i19 = i3 + i18;
        float f16 = i19 - i17;
        float f17 = i16 - i17;
        canvas.drawText(this.f147077a, f16, f17, paint);
        float f18 = i19;
        canvas.drawText(this.f147077a, f18, f17, paint);
        float f19 = i19 + i17;
        canvas.drawText(this.f147077a, f19, f17, paint);
        float f26 = i16;
        canvas.drawText(this.f147077a, f19, f26, paint);
        float f27 = i16 + i17;
        canvas.drawText(this.f147077a, f19, f27, paint);
        canvas.drawText(this.f147077a, f18, f27, paint);
        canvas.drawText(this.f147077a, f16, f27, paint);
        canvas.drawText(this.f147077a, f16, f26, paint);
    }

    public void c(Canvas canvas, Paint paint, float f16, float f17, float f18, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, canvas, paint, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Boolean.valueOf(z16));
            return;
        }
        if (z16 && paint != null) {
            Path path = new Path();
            path.moveTo(f16, f18);
            path.lineTo(f17, f18);
            canvas.drawPath(path, paint);
        }
    }

    public long d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        ArrayList<b> arrayList = this.f147080d;
        if (arrayList != null && arrayList.size() > 0) {
            b bVar = this.f147080d.get(r0.size() - 1);
            return bVar.f147062a + bVar.f147063b;
        }
        return 0L;
    }

    public long e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        ArrayList<b> arrayList = this.f147080d;
        if (arrayList != null && arrayList.size() > 0) {
            return this.f147080d.get(0).f147062a;
        }
        return 0L;
    }

    public void h(Canvas canvas, int i3, int i16, Paint paint, Paint paint2, Paint paint3, int i17, float f16, float f17, int[] iArr, float[] fArr, Paint paint4, boolean z16, int i18) {
        float f18;
        float f19;
        float f26;
        int i19;
        String substring;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, canvas, Integer.valueOf(i3), Integer.valueOf(i16), paint, paint2, paint3, Integer.valueOf(i17), Float.valueOf(f16), Float.valueOf(f17), iArr, fArr, paint4, Boolean.valueOf(z16), Integer.valueOf(i18));
            return;
        }
        int i26 = this.f147079c;
        int i27 = i3 + i26;
        float f27 = f17 + i26;
        float f28 = i16;
        float f29 = f27 + f16;
        paint3.setShader(new LinearGradient(f27, f28, f29, f28, iArr, fArr, Shader.TileMode.CLAMP));
        if (i17 > 0) {
            float f36 = i27;
            canvas.drawText(this.f147077a.substring(0, this.f147080d.get(i17 - 1).f147065d), f36, f28, paint2);
            f18 = f29;
            f19 = f28;
            f26 = f27;
            i19 = i27;
            c(canvas, paint4, f36, f36 + paint2.measureText(this.f147077a), g(paint2, f28), z16);
        } else {
            f18 = f29;
            f19 = f28;
            f26 = f27;
            i19 = i27;
        }
        b bVar = this.f147080d.get(i17);
        if (i17 == this.f147080d.size() - 1) {
            String str = this.f147077a;
            substring = str.substring(bVar.f147064c, str.length());
        } else {
            substring = this.f147077a.substring(bVar.f147064c, bVar.f147065d);
        }
        if (i18 == com.tencent.lyric.util.d.f147093c) {
            canvas.drawText(substring, f26, f19, paint);
        }
        canvas.drawText(substring, f26, f19, paint3);
        float f37 = i19;
        c(canvas, paint4, f37, f37 + paint3.measureText(this.f147077a), g(paint3, f19), z16);
        if (i17 < this.f147080d.size() - 1) {
            b bVar2 = this.f147080d.get(i17 + 1);
            String str2 = this.f147077a;
            canvas.drawText(str2.substring(bVar2.f147064c, str2.length()), f18, f19, paint);
            c(canvas, paint4, f37, paint.measureText(this.f147077a) + f37, g(paint, f19), z16);
        }
    }

    public void i(Canvas canvas, int i3, int i16, Paint paint, boolean z16) {
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, canvas, Integer.valueOf(i3), Integer.valueOf(i16), paint, Boolean.valueOf(z16));
            return;
        }
        if (z16) {
            i17 = this.f147079c;
        } else {
            i17 = this.f147078b;
        }
        canvas.drawText(this.f147077a, i3 + i17, i16, paint);
    }

    public void j(Canvas canvas, int i3, int i16, Paint paint, boolean z16, int i17) {
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, canvas, Integer.valueOf(i3), Integer.valueOf(i16), paint, Boolean.valueOf(z16), Integer.valueOf(i17));
            return;
        }
        if (z16) {
            i18 = this.f147079c;
        } else {
            i18 = this.f147078b;
        }
        Log.d("SentenceUI", "alpha " + i17);
        paint.setAlpha(i17);
        canvas.drawText(this.f147077a, (float) (i3 + i18), (float) i16, paint);
    }

    public void k(Canvas canvas, int i3, int i16, Paint paint, boolean z16, boolean z17, Paint paint2) {
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, canvas, Integer.valueOf(i3), Integer.valueOf(i16), paint, Boolean.valueOf(z16), Boolean.valueOf(z17), paint2);
            return;
        }
        if (z16) {
            i17 = this.f147079c;
        } else {
            i17 = this.f147078b;
        }
        float f16 = i3 + i17;
        float f17 = i16;
        canvas.drawText(this.f147077a, f16, f17, paint);
        c(canvas, paint2, f16, f16 + paint.measureText(this.f147077a), g(paint, f17), z17);
    }

    public void l(Canvas canvas, float f16, float f17, boolean z16, Bitmap bitmap, Paint paint, Paint paint2, int i3, a aVar, boolean z17) {
        ArrayList<b> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, canvas, Float.valueOf(f16), Float.valueOf(f17), Boolean.valueOf(z16), bitmap, paint, paint2, Integer.valueOf(i3), aVar, Boolean.valueOf(z17));
            return;
        }
        if (bitmap == null || bitmap.isRecycled() || aVar == null || (arrayList = this.f147080d) == null || arrayList.size() <= 0) {
            return;
        }
        float width = (f16 + (z16 ? this.f147079c : this.f147078b)) - (bitmap.getWidth() / 2.0f);
        float ceil = ((float) Math.ceil(f17 + paint2.getFontMetrics().ascent)) - bitmap.getHeight();
        for (int i16 = 0; i16 < this.f147080d.size(); i16++) {
            if (this.f147080d.get(i16) != null) {
                if (aVar.r(i3, i16)) {
                    canvas.drawBitmap(bitmap, width, ceil, paint2);
                }
                width += paint.measureText(this.f147077a.substring(this.f147080d.get(i16).f147064c, this.f147080d.get(i16).f147065d));
                if (i16 == this.f147080d.size() - 1 && z17 && aVar.s(i3)) {
                    canvas.drawBitmap(bitmap, width, ceil, paint2);
                }
            }
        }
    }

    public void m(Canvas canvas, float f16, float f17, boolean z16, Bitmap bitmap, Paint paint) {
        float width;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, canvas, Float.valueOf(f16), Float.valueOf(f17), Boolean.valueOf(z16), bitmap, paint);
            return;
        }
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        if (z16) {
            width = this.f147079c;
        } else {
            width = ((this.f147078b + f16) - bitmap.getWidth()) - 20.0f;
        }
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        canvas.drawBitmap(bitmap, width, ((float) Math.ceil(f17 + fontMetrics.ascent)) - ((bitmap.getHeight() - ((float) Math.ceil(fontMetrics.descent - fontMetrics.ascent))) / 2.0f), (Paint) null);
    }

    public void n(Canvas canvas, int[] iArr, int i3, int i16, int i17, Paint paint, Paint paint2, Paint paint3, Paint paint4, boolean z16, float f16, boolean z17, Paint paint5) {
        int i18;
        int i19;
        float f17;
        float f18;
        f fVar = this;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, fVar, canvas, iArr, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), paint, paint2, paint3, paint4, Boolean.valueOf(z16), Float.valueOf(f16), Boolean.valueOf(z17), paint5);
            return;
        }
        if (iArr == null) {
            return;
        }
        int i26 = i16 + (z16 ? fVar.f147079c : fVar.f147078b);
        Paint.FontMetrics fontMetrics = paint2.getFontMetrics();
        float ceil = (float) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        float f19 = i17;
        float ceil2 = ((float) Math.ceil(fontMetrics.ascent + f19)) - (((ceil + f16) - ((float) Math.ceil(fontMetrics.descent - fontMetrics.ascent))) / 2.0f);
        int i27 = i3;
        int i28 = 0;
        int i29 = i26;
        while (i28 < fVar.f147080d.size()) {
            b bVar = fVar.f147080d.get(i28);
            String substring = fVar.f147077a.substring(bVar.f147064c, bVar.f147065d);
            float measureText = paint2.measureText(substring);
            if (iArr[i27] != LyricViewInternalPractice.a.f147243b) {
                float f26 = i29;
                f17 = ceil;
                f18 = ceil2;
                i18 = i29;
                i19 = i28;
                canvas.drawRect(f26, ceil2, f26 + measureText, ceil2 + ceil + f16, paint);
                canvas.drawText(substring, f26, f19, paint2);
            } else {
                i18 = i29;
                i19 = i28;
                f17 = ceil;
                f18 = ceil2;
                if (z16) {
                    canvas.drawText(substring, i18, f19, paint3);
                } else {
                    canvas.drawText(substring, i18, f19, paint4);
                }
            }
            i29 = (int) (i18 + measureText);
            i28 = i19 + 1;
            i27++;
            fVar = this;
            ceil = f17;
            ceil2 = f18;
        }
        c(canvas, paint5, i26, i29, g(paint2, f19), z17);
    }

    public void o(Canvas canvas, int i3, int i16, Paint paint, Paint paint2, boolean z16, boolean z17, Paint paint3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, canvas, Integer.valueOf(i3), Integer.valueOf(i16), paint, paint2, Boolean.valueOf(z16), Boolean.valueOf(z17), paint3);
            return;
        }
        a(canvas, i3, i16, paint, false);
        if (z16) {
            b(canvas, i3, i16, paint2, 1, false);
        }
        k(canvas, i3, i16, paint, false, z17, paint3);
    }

    public void p(Canvas canvas, int i3, int i16, Paint paint, Paint paint2, boolean z16, boolean z17, Paint paint3, Bitmap bitmap, Bitmap bitmap2, Paint paint4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, canvas, Integer.valueOf(i3), Integer.valueOf(i16), paint, paint2, Boolean.valueOf(z16), Boolean.valueOf(z17), paint3, bitmap, bitmap2, paint4);
            return;
        }
        a(canvas, i3, i16, paint, false);
        if (z16) {
            b(canvas, i3, i16, paint2, 1, false);
        }
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            m(canvas, i3, i16, false, bitmap2, paint4);
        }
        k(canvas, i3, i16, paint, false, z17, paint3);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return String.format("SentenceUI -> mNormalOffsetX:%d, mHighLightOffsetX:%d", Integer.valueOf(this.f147078b), Integer.valueOf(this.f147079c));
    }
}
