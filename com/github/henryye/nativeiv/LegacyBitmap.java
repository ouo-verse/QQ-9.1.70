package com.github.henryye.nativeiv;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.Keep;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.tencent.luggage.wxa.f.c;
import com.tencent.luggage.wxa.j.b;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes2.dex */
public class LegacyBitmap implements IBitmap<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    public Bitmap f32863a = null;

    /* renamed from: b, reason: collision with root package name */
    public long f32864b = -1;

    public final BitmapFactory.Options a(ImageDecodeConfig imageDecodeConfig) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = imageDecodeConfig.mConfig;
        options.inPremultiplied = imageDecodeConfig.mPremultiplyAlpha;
        return options;
    }

    @Override // com.github.henryye.nativeiv.bitmap.IBitmap
    public void decodeInputStream(InputStream inputStream, ImageDecodeConfig imageDecodeConfig, c cVar) {
        long a16 = b.a();
        this.f32863a = a(inputStream, imageDecodeConfig, cVar);
        this.f32864b = b.a(a16);
    }

    @Override // com.github.henryye.nativeiv.bitmap.IBitmap
    public long getDecodeTime() {
        return this.f32864b;
    }

    @Override // com.github.henryye.nativeiv.bitmap.IBitmap
    @Keep
    public BitmapType getType() {
        return BitmapType.Legacy;
    }

    @Override // com.github.henryye.nativeiv.bitmap.IBitmap
    @Keep
    public void recycle() {
        Bitmap bitmap = this.f32863a;
        if (bitmap != null) {
            bitmap.recycle();
        }
    }

    @Override // com.github.henryye.nativeiv.bitmap.IBitmap
    @Keep
    public Bitmap provide() {
        return this.f32863a;
    }

    public Bitmap a(InputStream inputStream, ImageDecodeConfig imageDecodeConfig, c cVar) {
        Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, a(imageDecodeConfig));
        if (decodeStream == null || decodeStream.getConfig() == Bitmap.Config.ARGB_8888) {
            return decodeStream;
        }
        com.tencent.luggage.wxa.h.b.d("Ni.LegacyBitmap", "hy: config not argb-8888", new Object[0]);
        Bitmap createBitmap = Bitmap.createBitmap(decodeStream.getWidth(), decodeStream.getHeight(), Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawBitmap(decodeStream, 0.0f, 0.0f, (Paint) null);
        decodeStream.recycle();
        return createBitmap;
    }
}
