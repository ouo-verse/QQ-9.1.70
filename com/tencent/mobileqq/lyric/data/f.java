package com.tencent.mobileqq.lyric.data;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final String f243159a;

    /* renamed from: b, reason: collision with root package name */
    public final int f243160b;

    /* renamed from: c, reason: collision with root package name */
    private final int f243161c;

    /* renamed from: d, reason: collision with root package name */
    public final int f243162d;

    /* renamed from: e, reason: collision with root package name */
    public final int f243163e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList<a> f243164f;

    /* renamed from: g, reason: collision with root package name */
    public e f243165g;

    /* renamed from: h, reason: collision with root package name */
    public e f243166h;

    public f(String str, int i3, int i16, ArrayList<a> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), arrayList);
            return;
        }
        this.f243165g = new e();
        this.f243166h = new e();
        this.f243160b = i3;
        this.f243161c = i16;
        this.f243162d = 0;
        this.f243163e = 0;
        this.f243159a = str;
        this.f243164f = arrayList;
    }

    public long a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        ArrayList<a> arrayList = this.f243164f;
        if (arrayList != null && arrayList.size() > 0) {
            a aVar = this.f243164f.get(r0.size() - 1);
            return aVar.f243137a + aVar.f243138b;
        }
        return 0L;
    }

    public long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        ArrayList<a> arrayList = this.f243164f;
        if (arrayList != null && arrayList.size() > 0) {
            return this.f243164f.get(0).f243137a;
        }
        return 0L;
    }

    public void c(Canvas canvas, int i3, int i16, Paint paint, Paint paint2, Paint paint3, int i17, float f16, float f17, int[] iArr, float[] fArr) {
        float f18;
        String substring;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, canvas, Integer.valueOf(i3), Integer.valueOf(i16), paint, paint2, paint3, Integer.valueOf(i17), Float.valueOf(f16), Float.valueOf(f17), iArr, fArr);
            return;
        }
        int i18 = this.f243161c;
        int i19 = i3 + i18;
        float f19 = f17 + i18;
        float f26 = i16;
        float f27 = f19 + f16;
        paint3.setShader(new LinearGradient(f19, f26, f27, f26, iArr, fArr, Shader.TileMode.CLAMP));
        if (i17 > 0) {
            f18 = f26;
            canvas.drawText(this.f243159a.substring(0, this.f243164f.get(i17 - 1).f243140d), i19, f18, paint2);
        } else {
            f18 = f26;
        }
        a aVar = this.f243164f.get(i17);
        if (i17 == this.f243164f.size() - 1) {
            String str = this.f243159a;
            substring = str.substring(aVar.f243139c, str.length());
        } else {
            substring = this.f243159a.substring(aVar.f243139c, aVar.f243140d);
        }
        canvas.drawText(substring, f19, f18, paint3);
        if (i17 < this.f243164f.size() - 1) {
            a aVar2 = this.f243164f.get(i17 + 1);
            String str2 = this.f243159a;
            canvas.drawText(str2.substring(aVar2.f243139c, str2.length()), f27, f18, paint);
        }
    }

    public void d(Canvas canvas, int i3, int i16, Paint paint, boolean z16) {
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, canvas, Integer.valueOf(i3), Integer.valueOf(i16), paint, Boolean.valueOf(z16));
            return;
        }
        if (z16) {
            i17 = this.f243161c;
        } else {
            i17 = this.f243160b;
        }
        canvas.drawText(this.f243159a, i3 + i17, i16, paint);
    }

    public void e(Canvas canvas, int i3, int i16, Paint paint, Paint paint2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, canvas, Integer.valueOf(i3), Integer.valueOf(i16), paint, paint2);
        } else {
            f(canvas, i3, i16, paint, paint2, null, null, 1);
        }
    }

    public void f(Canvas canvas, int i3, int i16, Paint paint, Paint paint2, Bitmap bitmap, Bitmap bitmap2, int i17) {
        Bitmap bitmap3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, canvas, Integer.valueOf(i3), Integer.valueOf(i16), paint, paint2, bitmap, bitmap2, Integer.valueOf(i17));
            return;
        }
        int i18 = i3 + this.f243160b;
        e eVar = this.f243165g;
        if (eVar != null && (bitmap3 = eVar.f243155a) != null && !bitmap3.isRecycled()) {
            e eVar2 = this.f243165g;
            canvas.drawBitmap(this.f243165g.f243155a, (Rect) null, new Rect((i18 - eVar2.f243158d) - eVar2.f243155a.getWidth(), (int) (i16 - paint.getTextSize()), i18 - this.f243165g.f243158d, (int) ((r1.f243155a.getHeight() + i16) - paint.getTextSize())), (Paint) null);
        }
        float f16 = i18 - i17;
        float f17 = i16 - i17;
        canvas.drawText(this.f243159a, f16, f17, paint2);
        float f18 = i18;
        canvas.drawText(this.f243159a, f18, f17, paint2);
        float f19 = i18 + i17;
        canvas.drawText(this.f243159a, f19, f17, paint2);
        float f26 = i16;
        canvas.drawText(this.f243159a, f19, f26, paint2);
        float f27 = i16 + i17;
        canvas.drawText(this.f243159a, f19, f27, paint2);
        canvas.drawText(this.f243159a, f18, f27, paint2);
        canvas.drawText(this.f243159a, f16, f27, paint2);
        canvas.drawText(this.f243159a, f16, f26, paint2);
        canvas.drawText(this.f243159a, f18, f26, paint);
    }

    public f(String str, int i3, int i16, int i17, int i18, ArrayList<a> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), arrayList);
            return;
        }
        this.f243165g = new e();
        this.f243166h = new e();
        this.f243160b = i3;
        this.f243161c = i16;
        this.f243162d = i17;
        this.f243163e = i18;
        this.f243159a = str;
        this.f243164f = arrayList;
    }
}
