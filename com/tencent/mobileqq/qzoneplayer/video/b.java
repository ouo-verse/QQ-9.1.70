package com.tencent.mobileqq.qzoneplayer.video;

import android.graphics.Point;
import android.graphics.RectF;

/* compiled from: P */
/* loaded from: classes35.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private float[] f279952a = new float[2];

    /* renamed from: b, reason: collision with root package name */
    private float[] f279953b = new float[2];

    /* renamed from: c, reason: collision with root package name */
    private float[] f279954c = new float[2];

    /* renamed from: d, reason: collision with root package name */
    private float[] f279955d = new float[2];

    /* renamed from: e, reason: collision with root package name */
    private float[] f279956e = new float[2];

    /* renamed from: f, reason: collision with root package name */
    private float[] f279957f = new float[2];

    /* renamed from: g, reason: collision with root package name */
    private float[] f279958g = new float[2];

    /* renamed from: h, reason: collision with root package name */
    private float[] f279959h = new float[2];

    /* renamed from: i, reason: collision with root package name */
    private float[] f279960i = new float[2];

    /* renamed from: j, reason: collision with root package name */
    private float[] f279961j = new float[2];

    /* renamed from: k, reason: collision with root package name */
    private float[] f279962k = new float[2];

    /* renamed from: l, reason: collision with root package name */
    private float[] f279963l = new float[2];

    /* renamed from: m, reason: collision with root package name */
    private float[] f279964m = new float[2];

    /* renamed from: n, reason: collision with root package name */
    private float[] f279965n = new float[2];

    /* renamed from: o, reason: collision with root package name */
    private float[] f279966o = new float[2];

    /* renamed from: p, reason: collision with root package name */
    private float[] f279967p = new float[2];

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public float[] f279968a;

        /* renamed from: b, reason: collision with root package name */
        public short[] f279969b;

        /* renamed from: c, reason: collision with root package name */
        public int f279970c = 0;

        /* renamed from: d, reason: collision with root package name */
        public int f279971d = 0;

        public a(float[] fArr, short[] sArr) {
            this.f279968a = fArr;
            this.f279969b = sArr;
        }
    }

    private void a(a aVar, float[][] fArr, RectF rectF, float f16) {
        float[] fArr2 = aVar.f279968a;
        short[] sArr = aVar.f279969b;
        int i3 = aVar.f279971d;
        int i16 = aVar.f279970c;
        int i17 = 0;
        for (float[] fArr3 : fArr) {
            int i18 = (i17 * 5) + i16;
            fArr2[i18 + 0] = fArr3[0];
            fArr2[i18 + 1] = fArr3[1];
            fArr2[i18 + 2] = f16;
            fArr2[i18 + 3] = (fArr3[0] - rectF.left) / rectF.width();
            fArr2[i18 + 4] = (fArr3[1] - rectF.bottom) / (-rectF.height());
            i17++;
        }
        int i19 = i16 / 5;
        sArr[i3 + 0] = (short) i19;
        short s16 = (short) (i19 + 1);
        sArr[i3 + 1] = s16;
        short s17 = (short) (i19 + 2);
        sArr[i3 + 2] = s17;
        sArr[i3 + 3] = s16;
        sArr[i3 + 4] = s17;
        sArr[i3 + 5] = (short) (i19 + 3);
    }

    private void b(a aVar, float[] fArr, float[] fArr2, float f16, float f17, int i3, RectF rectF, float f18) {
        int i16;
        int i17;
        int i18;
        float[] fArr3 = aVar.f279968a;
        short[] sArr = aVar.f279969b;
        int i19 = aVar.f279970c;
        int i26 = aVar.f279971d;
        int i27 = 0;
        int i28 = 0;
        while (i28 < i3) {
            int i29 = (i28 * 5) + i19 + (i28 > 0 ? 10 : i27);
            float f19 = f17 - f16;
            float f26 = i3;
            float f27 = f16 + ((i28 / f26) * f19);
            int i36 = i28 + 1;
            float f28 = f16 + (f19 * (i36 / f26));
            if (i28 == 0) {
                int i37 = i29 + 0;
                fArr3[i37] = fArr[i27];
                int i38 = i29 + 1;
                fArr3[i38] = fArr[1];
                fArr3[i29 + 2] = f18;
                fArr3[i29 + 3] = (fArr3[i37] - rectF.left) / rectF.width();
                fArr3[i29 + 4] = (fArr3[i38] - rectF.bottom) / (-rectF.height());
                int i39 = i29 + 5;
                float f29 = fArr[i27];
                float f36 = fArr2[i27];
                i16 = i28;
                double d16 = f27;
                i17 = i36;
                fArr3[i39] = f29 + (f36 * ((float) Math.cos(d16)));
                int i46 = i29 + 6;
                fArr3[i46] = fArr[1] + (fArr2[1] * ((float) Math.sin(d16)));
                fArr3[i29 + 7] = f18;
                fArr3[i29 + 8] = (fArr3[i39] - rectF.left) / rectF.width();
                fArr3[i29 + 9] = (fArr3[i46] - rectF.bottom) / (-rectF.height());
                i18 = 10;
            } else {
                i16 = i28;
                i17 = i36;
                i18 = 0;
            }
            int i47 = i29 + i18;
            int i48 = i47 + 0;
            double d17 = f28;
            fArr3[i48] = fArr[0] + (fArr2[0] * ((float) Math.cos(d17)));
            int i49 = i47 + 1;
            fArr3[i49] = fArr[1] + (fArr2[1] * ((float) Math.sin(d17)));
            fArr3[i47 + 2] = f18;
            fArr3[i47 + 3] = (fArr3[i48] - rectF.left) / rectF.width();
            fArr3[i47 + 4] = (fArr3[i49] - rectF.bottom) / (-rectF.height());
            int i56 = i19 / 5;
            int i57 = (i16 * 3) + i26;
            sArr[i57 + 0] = (short) i56;
            int i58 = i56 + i16;
            sArr[i57 + 1] = (short) (i58 + 1);
            sArr[i57 + 2] = (short) (i58 + 2);
            i28 = i17;
            i27 = 0;
        }
    }

    public a c(RectF rectF, RectF rectF2, Point point, int i3) {
        return d(rectF, rectF2, point, i3, 0.0f);
    }

    public a d(RectF rectF, RectF rectF2, Point point, int i3, float f16) {
        float f17 = rectF2.left;
        float f18 = rectF2.right;
        float f19 = rectF2.bottom;
        float f26 = rectF2.top;
        float f27 = rectF.left;
        float f28 = rectF.top;
        float f29 = rectF.right;
        float f36 = rectF.bottom;
        this.f279964m[0] = (f27 / point.x) * rectF2.width();
        this.f279964m[1] = (f27 / point.y) * (-rectF2.height());
        this.f279965n[0] = (f28 / point.x) * rectF2.width();
        this.f279965n[1] = (f28 / point.y) * (-rectF2.height());
        this.f279966o[0] = (f29 / point.x) * rectF2.width();
        this.f279966o[1] = (f29 / point.y) * (-rectF2.height());
        this.f279967p[0] = (f36 / point.x) * rectF2.width();
        this.f279967p[1] = (f36 / point.y) * (-rectF2.height());
        float[] fArr = this.f279952a;
        fArr[0] = f17;
        float[] fArr2 = this.f279964m;
        fArr[1] = f26 - fArr2[1];
        float[] fArr3 = this.f279953b;
        fArr3[0] = f17;
        float[] fArr4 = this.f279967p;
        fArr3[1] = fArr4[1] + f19;
        float[] fArr5 = this.f279954c;
        fArr5[0] = fArr2[0] + f17;
        fArr5[1] = f26;
        float[] fArr6 = this.f279955d;
        float[] fArr7 = this.f279965n;
        fArr6[0] = f18 - fArr7[0];
        fArr6[1] = f26;
        float[] fArr8 = this.f279956e;
        fArr8[0] = f18;
        fArr8[1] = f26 - fArr7[1];
        float[] fArr9 = this.f279957f;
        fArr9[0] = f18;
        float[] fArr10 = this.f279966o;
        fArr9[1] = f19 + fArr10[1];
        float[] fArr11 = this.f279958g;
        fArr11[0] = f17 + fArr4[0];
        fArr11[1] = f19;
        float[] fArr12 = this.f279959h;
        fArr12[0] = f18 - fArr10[0];
        fArr12[1] = f19;
        float[] fArr13 = this.f279960i;
        fArr13[0] = fArr5[0];
        fArr13[1] = fArr[1];
        float[] fArr14 = this.f279961j;
        fArr14[0] = fArr6[0];
        fArr14[1] = fArr8[1];
        float[] fArr15 = this.f279963l;
        fArr15[0] = fArr11[0];
        fArr15[1] = fArr3[1];
        float[] fArr16 = this.f279962k;
        fArr16[0] = fArr12[0];
        fArr16[1] = fArr9[1];
        int i16 = (i3 + 2) * 5;
        float[] fArr17 = new float[(i16 * 4) + 100];
        short[] sArr = new short[(i3 * 4 * 3) + 30];
        a aVar = new a(fArr17, sArr);
        a(aVar, new float[][]{this.f279960i, this.f279961j, this.f279963l, this.f279962k}, rectF2, f16);
        aVar.f279970c += 20;
        aVar.f279971d += 6;
        a(aVar, new float[][]{this.f279952a, this.f279960i, this.f279953b, this.f279963l}, rectF2, f16);
        aVar.f279970c += 20;
        aVar.f279971d += 6;
        a(aVar, new float[][]{this.f279961j, this.f279956e, this.f279962k, this.f279957f}, rectF2, f16);
        aVar.f279970c += 20;
        aVar.f279971d += 6;
        a(aVar, new float[][]{this.f279954c, this.f279960i, this.f279955d, this.f279961j}, rectF2, f16);
        aVar.f279970c += 20;
        aVar.f279971d += 6;
        a(aVar, new float[][]{this.f279963l, this.f279958g, this.f279962k, this.f279959h}, rectF2, f16);
        aVar.f279970c += 20;
        aVar.f279971d += 6;
        b(aVar, this.f279960i, this.f279964m, 3.1415927f, 1.5707964f, i3, rectF2, f16);
        aVar.f279970c += i16;
        int i17 = i3 * 3;
        aVar.f279971d += i17;
        b(aVar, this.f279961j, this.f279965n, 1.5707964f, 0.0f, i3, rectF2, f16);
        aVar.f279970c += i16;
        aVar.f279971d += i17;
        b(aVar, this.f279962k, this.f279966o, 4.712389f, 6.2831855f, i3, rectF2, f16);
        aVar.f279970c += i16;
        aVar.f279971d += i17;
        b(aVar, this.f279963l, this.f279967p, 3.1415927f, 4.712389f, i3, rectF2, f16);
        return new a(fArr17, sArr);
    }
}
