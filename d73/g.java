package d73;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes21.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f393191a;

    /* renamed from: b, reason: collision with root package name */
    public final int f393192b;

    /* renamed from: c, reason: collision with root package name */
    private final int f393193c;

    /* renamed from: d, reason: collision with root package name */
    public final int f393194d;

    /* renamed from: e, reason: collision with root package name */
    public final int f393195e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList<a> f393196f;

    /* renamed from: g, reason: collision with root package name */
    public f f393197g;

    /* renamed from: h, reason: collision with root package name */
    public f f393198h;

    public g(String str, int i3, int i16, ArrayList<a> arrayList) {
        this.f393197g = new f();
        this.f393198h = new f();
        this.f393192b = i3;
        this.f393193c = i16;
        this.f393194d = 0;
        this.f393195e = 0;
        this.f393191a = str;
        this.f393196f = arrayList;
    }

    private void a(Canvas canvas, int i3, int i16, Paint paint) {
        Bitmap bitmap;
        int i17 = i3 + this.f393192b;
        f fVar = this.f393197g;
        if (fVar != null && (bitmap = fVar.f393187a) != null && !bitmap.isRecycled()) {
            f fVar2 = this.f393197g;
            canvas.drawBitmap(this.f393197g.f393187a, (Rect) null, new Rect((i17 - fVar2.f393190d) - fVar2.f393187a.getWidth(), (int) ((i16 - paint.getTextSize()) + 2.0f), i17 - this.f393197g.f393190d, (int) (((i16 + r4.f393187a.getHeight()) - paint.getTextSize()) + 2.0f)), (Paint) null);
        }
    }

    public void b(Canvas canvas, int i3, int i16, Paint paint, boolean z16) {
        int i17;
        if (z16) {
            i17 = this.f393193c;
        } else {
            i17 = this.f393192b;
        }
        int i18 = i3 + i17;
        float f16 = i18 - 1;
        float f17 = i16 - 1;
        canvas.drawText(this.f393191a, f16, f17, paint);
        float f18 = i18;
        canvas.drawText(this.f393191a, f18, f17, paint);
        float f19 = i18 + 1;
        canvas.drawText(this.f393191a, f19, f17, paint);
        float f26 = i16;
        canvas.drawText(this.f393191a, f19, f26, paint);
        float f27 = i16 + 1;
        canvas.drawText(this.f393191a, f19, f27, paint);
        canvas.drawText(this.f393191a, f18, f27, paint);
        canvas.drawText(this.f393191a, f16, f27, paint);
        canvas.drawText(this.f393191a, f16, f26, paint);
    }

    public long c() {
        ArrayList<a> arrayList = this.f393196f;
        if (arrayList != null && arrayList.size() > 0) {
            a aVar = this.f393196f.get(r0.size() - 1);
            return aVar.f393157a + aVar.f393158b;
        }
        return 0L;
    }

    public long d() {
        ArrayList<a> arrayList = this.f393196f;
        if (arrayList != null && arrayList.size() > 0) {
            return this.f393196f.get(0).f393157a;
        }
        return 0L;
    }

    public void e(Canvas canvas, int i3, int i16, Paint paint, Paint paint2, Paint paint3, int i17, float f16, float f17, int[] iArr, float[] fArr) {
        String substring;
        int i18 = this.f393193c;
        int i19 = i3 + i18;
        float f18 = f17 + i18;
        float f19 = i16;
        float f26 = f18 + f16;
        paint3.setShader(new LinearGradient(f18, f19, f26, f19, iArr, fArr, Shader.TileMode.CLAMP));
        if (i17 > 0) {
            canvas.drawText(this.f393191a.substring(0, this.f393196f.get(i17 - 1).f393160d), i19, f19, paint2);
        }
        a aVar = this.f393196f.get(i17);
        if (i17 == this.f393196f.size() - 1) {
            String str = this.f393191a;
            substring = str.substring(aVar.f393159c, str.length());
        } else {
            substring = this.f393191a.substring(aVar.f393159c, aVar.f393160d);
        }
        canvas.drawText(substring, f18, f19, paint3);
        if (i17 < this.f393196f.size() - 1) {
            a aVar2 = this.f393196f.get(i17 + 1);
            String str2 = this.f393191a;
            canvas.drawText(str2.substring(aVar2.f393159c, str2.length()), f26, f19, paint);
        }
    }

    public void f(Canvas canvas, int i3, int i16, Paint paint, boolean z16) {
        int i17;
        if (z16) {
            i17 = this.f393193c;
        } else {
            i17 = this.f393192b;
        }
        canvas.drawText(this.f393191a, i3 + i17, i16, paint);
    }

    public void g(Canvas canvas, int i3, int i16, Paint paint, Paint paint2, boolean z16) {
        a(canvas, i3, i16, paint);
        if (z16) {
            b(canvas, i3, i16, paint2, false);
        }
        f(canvas, i3, i16, paint, false);
    }

    public g(String str, int i3, int i16, int i17, int i18, ArrayList<a> arrayList) {
        this.f393197g = new f();
        this.f393198h = new f();
        this.f393192b = i3;
        this.f393193c = i16;
        this.f393194d = i17;
        this.f393195e = i18;
        this.f393191a = str;
        this.f393196f = arrayList;
    }
}
