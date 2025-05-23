package com.tencent.mobileqq.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/* compiled from: P */
/* loaded from: classes20.dex */
public class bl {

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f306630a;

        /* renamed from: b, reason: collision with root package name */
        public int f306631b;

        /* renamed from: c, reason: collision with root package name */
        public int f306632c;

        /* renamed from: d, reason: collision with root package name */
        public int f306633d;

        /* renamed from: e, reason: collision with root package name */
        public int f306634e;

        a() {
        }
    }

    public static Bitmap a(int i3, Bitmap[] bitmapArr) {
        if (bitmapArr == null || bitmapArr.length <= 0) {
            return null;
        }
        Bitmap[] bitmapArr2 = new Bitmap[bitmapArr.length];
        int i16 = 0;
        for (Bitmap bitmap : bitmapArr) {
            if (bitmap != null) {
                bitmapArr2[i16] = bitmap;
                i16++;
            }
        }
        if (i16 < 1) {
            return null;
        }
        if (i16 == 1) {
            return bitmapArr[0];
        }
        a[] aVarArr = new a[i16];
        for (int i17 = 0; i17 < i16; i17++) {
            aVarArr[i17] = new a();
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setFilterBitmap(true);
        RectF rectF = new RectF();
        Rect rect = new Rect();
        Bitmap createBitmap = Bitmap.createBitmap(i3, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawARGB(0, 0, 0, 0);
        if (i16 == 2) {
            a aVar = aVarArr[0];
            aVar.f306630a = 0;
            aVar.f306631b = 0;
            int i18 = i3 / 2;
            aVar.f306632c = i18 - 1;
            aVar.f306633d = i3;
            aVar.f306634e = 1;
            a aVar2 = aVarArr[1];
            aVar2.f306630a = i18 + 1;
            aVar2.f306631b = 0;
            aVar2.f306632c = i3;
            aVar2.f306633d = i3;
            aVar2.f306634e = 1;
        } else if (i16 == 3) {
            a aVar3 = aVarArr[0];
            aVar3.f306630a = 0;
            aVar3.f306631b = 0;
            int i19 = i3 / 2;
            int i26 = i19 - 1;
            aVar3.f306632c = i26;
            aVar3.f306633d = i3;
            aVar3.f306634e = 1;
            a aVar4 = aVarArr[1];
            int i27 = i19 + 1;
            aVar4.f306630a = i27;
            aVar4.f306631b = 0;
            aVar4.f306632c = i3;
            aVar4.f306633d = i26;
            aVar4.f306634e = 2;
            a aVar5 = aVarArr[2];
            aVar5.f306630a = i27;
            aVar5.f306631b = i27;
            aVar5.f306632c = i3;
            aVar5.f306633d = i3;
            aVar5.f306634e = 2;
        } else if (i16 >= 4) {
            a aVar6 = aVarArr[0];
            aVar6.f306630a = 0;
            aVar6.f306631b = 0;
            int i28 = i3 / 2;
            int i29 = i28 - 1;
            aVar6.f306632c = i29;
            aVar6.f306633d = i29;
            aVar6.f306634e = 2;
            a aVar7 = aVarArr[1];
            int i36 = i28 + 1;
            aVar7.f306630a = i36;
            aVar7.f306631b = 0;
            aVar7.f306632c = i3;
            aVar7.f306633d = i29;
            aVar7.f306634e = 2;
            a aVar8 = aVarArr[2];
            aVar8.f306630a = i36;
            aVar8.f306631b = i36;
            aVar8.f306632c = i3;
            aVar8.f306633d = i3;
            aVar8.f306634e = 2;
            a aVar9 = aVarArr[3];
            aVar9.f306630a = 0;
            aVar9.f306631b = i36;
            aVar9.f306632c = i29;
            aVar9.f306633d = i3;
            aVar9.f306634e = 2;
        }
        for (int i37 = 0; i37 < i16 && i37 < 4; i37++) {
            int width = bitmapArr2[i37].getWidth();
            int height = bitmapArr2[i37].getHeight();
            if (aVarArr[i37].f306634e == 1) {
                int i38 = width / 4;
                rect.set(i38, 0, i38 * 3, height);
            } else {
                rect.set(0, 0, width, height);
            }
            a aVar10 = aVarArr[i37];
            rectF.set(aVar10.f306630a, aVar10.f306631b, aVar10.f306632c, aVar10.f306633d);
            canvas.drawBitmap(bitmapArr2[i37], rect, rectF, paint);
        }
        return createBitmap;
    }
}
