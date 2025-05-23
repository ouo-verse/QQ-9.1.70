package com.github.henryye.nativeiv.comm;

import android.graphics.Rect;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.luggage.wxa.f.c;
import com.tencent.luggage.wxa.j.b;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: P */
@Keep
/* loaded from: classes2.dex */
class NativeImage implements IBitmap<NativeBitmapStruct> {
    private static final String TAG = "Ni.NativeImage";
    private a factory;
    private NativeImageJni jni;
    private NativeBitmapStruct mNativeBitmapStruct = null;
    private long lastDecodeUsing = -1;

    public NativeImage(NativeImageJni nativeImageJni, a aVar) {
        this.jni = nativeImageJni;
        this.factory = aVar;
        synchronized (this) {
            aVar.a(this);
        }
    }

    @Override // com.github.henryye.nativeiv.bitmap.IBitmap
    public synchronized void decodeInputStream(InputStream inputStream, ImageDecodeConfig imageDecodeConfig, c cVar) throws IOException {
        if (this.factory == null) {
            return;
        }
        long a16 = b.a();
        if (inputStream == null) {
            com.tencent.luggage.wxa.h.b.d(TAG, "hy: non stream, mark as request clear", new Object[0]);
            recycle();
        }
        ByteBuffer a17 = com.tencent.luggage.wxa.j.a.a(inputStream, false);
        int a18 = com.tencent.luggage.wxa.g.a.a(imageDecodeConfig.mConfig);
        try {
            if (a17 != null) {
                CommNativeBitmapStruct a19 = this.jni.a(a17, a18, imageDecodeConfig.mPremultiplyAlpha);
                if (a19 != null) {
                    this.mNativeBitmapStruct = a19.convertToCommonStruct();
                } else {
                    com.tencent.luggage.wxa.h.b.b(TAG, "hy: decode failed!!", new Object[0]);
                }
                a17.clear();
                return;
            }
            com.tencent.luggage.wxa.h.b.d(TAG, "hy: decode error!", new Object[0]);
            recycle();
            throw new IOException("decode error!");
        } finally {
            this.lastDecodeUsing = b.a(a16);
        }
    }

    public void decodeInputStreamRegion(InputStream inputStream, Rect rect, ImageDecodeConfig imageDecodeConfig, c cVar) throws IOException {
        throw new IOException("Stub!");
    }

    @NonNull
    public synchronized com.tencent.luggage.wxa.f.a dump() {
        com.tencent.luggage.wxa.f.a aVar;
        aVar = new com.tencent.luggage.wxa.f.a();
        NativeBitmapStruct nativeBitmapStruct = this.mNativeBitmapStruct;
        if (nativeBitmapStruct != null) {
            aVar.f125081a = nativeBitmapStruct.width;
            aVar.f125082b = nativeBitmapStruct.height;
            aVar.f125083c = true;
            aVar.f125084d = Integer.valueOf(nativeBitmapStruct.glFormat);
            aVar.f125085e = this.lastDecodeUsing;
        }
        return aVar;
    }

    @Override // com.github.henryye.nativeiv.bitmap.IBitmap
    public long getDecodeTime() {
        return this.lastDecodeUsing;
    }

    @Override // com.github.henryye.nativeiv.bitmap.IBitmap
    @Keep
    public BitmapType getType() {
        return BitmapType.Native;
    }

    @Override // com.github.henryye.nativeiv.bitmap.IBitmap
    @Keep
    public synchronized void recycle() {
        NativeBitmapStruct nativeBitmapStruct = this.mNativeBitmapStruct;
        if (nativeBitmapStruct != null) {
            long j3 = nativeBitmapStruct.ptr;
            if (j3 != -1) {
                this.jni.a(j3);
                this.mNativeBitmapStruct = null;
            }
        }
        a aVar = this.factory;
        if (aVar != null) {
            aVar.b(this);
            this.factory = null;
        }
    }

    public void forceSet(NativeBitmapStruct nativeBitmapStruct) {
        this.mNativeBitmapStruct = nativeBitmapStruct;
    }

    @Override // com.github.henryye.nativeiv.bitmap.IBitmap
    @Nullable
    @Keep
    public NativeBitmapStruct provide() {
        return this.mNativeBitmapStruct;
    }
}
