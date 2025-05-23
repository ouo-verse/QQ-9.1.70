package com.tencent.luggage.wxa.pb;

import android.graphics.Bitmap;
import com.tencent.luggage.wxa.tn.d;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements AppBrandSimpleImageLoader.j {

    /* renamed from: a, reason: collision with root package name */
    public final int f137483a;

    /* renamed from: b, reason: collision with root package name */
    public final int f137484b;

    public b(int i3, int i16) {
        this.f137483a = i3;
        this.f137484b = i16;
    }

    @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.j
    public Bitmap b(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if (bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return bitmap;
        }
        if (bitmap.getWidth() == bitmap.getHeight()) {
            int i3 = this.f137483a;
            float f16 = i3;
            if (this.f137484b > 0 && i3 > 0) {
                f16 = (i3 * bitmap.getWidth()) / this.f137484b;
            }
            Bitmap a16 = d.a(bitmap, false, f16);
            Intrinsics.checkNotNullExpressionValue(a16, "getRoundedCornerBitmap(bitmap, false, fRoundpx)");
            return a16;
        }
        int min = (int) Math.min(bitmap.getWidth(), bitmap.getHeight());
        if (min <= 0) {
            min = (int) Math.max(bitmap.getWidth(), bitmap.getHeight());
        }
        Bitmap a17 = d.a(bitmap, min, min, true);
        Intrinsics.checkNotNullExpressionValue(a17, "getCenterCropBitmap(bitm\u2026newWidth, newWidth, true)");
        int i16 = this.f137483a;
        float f17 = i16;
        if (this.f137484b > 0 && i16 > 0) {
            f17 = (i16 * a17.getWidth()) / this.f137484b;
        }
        Bitmap a18 = d.a(a17, false, f17);
        Intrinsics.checkNotNullExpressionValue(a18, "getRoundedCornerBitmap(result, false, fRoundpx)");
        return a18;
    }

    @Override // com.tencent.luggage.wxa.pb.a
    public String b() {
        return "RoundedCornerIcon_" + this.f137483a;
    }
}
