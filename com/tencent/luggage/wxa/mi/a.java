package com.tencent.luggage.wxa.mi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.util.Log;
import com.tencent.luggage.wxa.tn.n;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a implements AppBrandSimpleImageLoader.i {

    /* renamed from: a, reason: collision with root package name */
    public int f134594a;

    /* renamed from: b, reason: collision with root package name */
    public int f134595b;

    /* renamed from: c, reason: collision with root package name */
    public int f134596c;

    /* renamed from: d, reason: collision with root package name */
    public int f134597d;

    public a(int i3, int i16, int i17, int i18) {
        this.f134594a = i3;
        this.f134595b = i16;
        this.f134596c = i17;
        this.f134597d = i18;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0059, code lost:
    
        r13.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0089, code lost:
    
        if (r13 == null) goto L38;
     */
    @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap a(InputStream inputStream) {
        InputStream bufferedInputStream;
        try {
            try {
                if (this.f134596c >= 0 && this.f134597d >= 0) {
                    if (!inputStream.markSupported()) {
                        if (inputStream instanceof FileInputStream) {
                            bufferedInputStream = new n((FileInputStream) inputStream);
                        } else if (!inputStream.markSupported()) {
                            bufferedInputStream = new BufferedInputStream(inputStream);
                        }
                        inputStream = bufferedInputStream;
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inMutable = true;
                    BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(inputStream, false);
                    int i3 = this.f134594a;
                    int i16 = this.f134595b;
                    Bitmap decodeRegion = newInstance.decodeRegion(new Rect(i3, i16, this.f134596c + i3, this.f134597d + i16), options);
                    newInstance.recycle();
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                    return decodeRegion;
                }
                return null;
            } catch (IOException e16) {
                w.b("MicroMsg.AppBrand.BitmapRegionDecoderImpl", "%s", Log.getStackTraceString(e16));
            } catch (IllegalArgumentException e17) {
                w.b("MicroMsg.AppBrand.BitmapRegionDecoderImpl", "%s", Log.getStackTraceString(e17));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                return null;
            } catch (OutOfMemoryError e18) {
                w.b("MicroMsg.AppBrand.BitmapRegionDecoderImpl", "%s", Log.getStackTraceString(e18));
                if (inputStream != null) {
                    inputStream.close();
                }
                return null;
            }
        } catch (Throwable th5) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
            throw th5;
        }
    }

    @Override // com.tencent.luggage.wxa.pb.a
    public String b() {
        return String.format("Decoder_x%s_y%s_w%s_h%s", Integer.valueOf(this.f134594a), Integer.valueOf(this.f134595b), Integer.valueOf(this.f134596c), Integer.valueOf(this.f134597d));
    }
}
