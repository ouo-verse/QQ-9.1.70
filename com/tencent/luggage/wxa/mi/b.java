package com.tencent.luggage.wxa.mi;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.luggage.wxa.tn.d;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements AppBrandSimpleImageLoader.j {

    /* renamed from: a, reason: collision with root package name */
    public int f134598a;

    /* renamed from: b, reason: collision with root package name */
    public int f134599b;

    /* renamed from: c, reason: collision with root package name */
    public int f134600c;

    /* renamed from: d, reason: collision with root package name */
    public int f134601d;

    public b(int i3, int i16, int i17, int i18) {
        boolean z16;
        if (i17 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.luggage.wxa.er.a.a(z16);
        com.tencent.luggage.wxa.er.a.a(i18 == 0);
        this.f134598a = i3;
        this.f134599b = i16;
        this.f134600c = i17;
        this.f134601d = i18;
    }

    @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.j
    public Bitmap b(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i3 = this.f134598a;
        int i16 = this.f134599b;
        int i17 = i3 < 0 ? 0 : i3 > width ? width : i3;
        int i18 = i16 < 0 ? 0 : i16 > height ? height : i16;
        int i19 = (this.f134600c + i3) - i17;
        int i26 = (this.f134601d + i16) - i18;
        if (i17 + i19 > width) {
            i19 = width - i17;
        }
        if (i18 + i26 > height) {
            i26 = height - i18;
        }
        if (i19 > 0 && i26 > 0) {
            Bitmap a16 = d.a(i19, i26, Bitmap.Config.ARGB_8888);
            new Canvas(a16).drawBitmap(bitmap, new Rect(i17, i18, i17 + i19, i18 + i26), new Rect(0, 0, i19, i26), (Paint) null);
            return a16;
        }
        return d.a(1, 1, Bitmap.Config.ARGB_8888);
    }

    @Override // com.tencent.luggage.wxa.pb.a
    public String b() {
        return String.format("Transformation_x%s_y%s_w%s_h%s", Integer.valueOf(this.f134598a), Integer.valueOf(this.f134599b), Integer.valueOf(this.f134600c), Integer.valueOf(this.f134601d));
    }
}
