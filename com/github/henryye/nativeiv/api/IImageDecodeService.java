package com.github.henryye.nativeiv.api;

import android.graphics.Bitmap;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.tencent.luggage.wxa.i.d;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface IImageDecodeService {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface a {
        IBitmap a(String str, Object obj, d dVar, ImageDecodeConfig imageDecodeConfig);

        void a(int i3, int i16);

        void a(b bVar);

        boolean a();

        void destroy();

        void forceSetUseType(BitmapType bitmapType);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface b {

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public enum a {
            OK,
            NOT_EXIST,
            PRE_DECODE_ERROR,
            DECODE_ERROR,
            UNSUPPORTED_IMG_FORMAT,
            HUGE_SIZE,
            IO_ERROR,
            OUT_OF_MEMORY,
            LEGACY_MODE,
            TIME_COST_HUGE,
            NATIVE_DECODE_ERROR,
            THROW_EXCEPTION
        }

        void a(String str, a aVar, com.tencent.luggage.wxa.e.a aVar2);

        void a(String str, Object obj, c cVar, ImageDecodeConfig imageDecodeConfig);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface c {
        void a(String str, Object obj);
    }

    @Keep
    void addDecodeEventListener(@NonNull b bVar);

    @Keep
    void addImageStreamFetcher(@NonNull d dVar, boolean z16);

    @Keep
    String encodeToBase64(Bitmap bitmap, int i3, float f16);

    @Keep
    byte[] encodeToBuffer(Bitmap bitmap, int i3, float f16);

    @Keep
    void forceSetUseType(BitmapType bitmapType);

    @Keep
    Bitmap getBitmap(int i3, int i16);

    @Keep
    void init();

    @Keep
    void loadBitmapAsync(Object obj, ImageDecodeConfig imageDecodeConfig);

    @Keep
    void loadBitmapAsync(String str);

    @Keep
    void loadBitmapAsync(String str, ImageDecodeConfig imageDecodeConfig);

    @Keep
    IBitmap loadBitmapSync(Object obj, ImageDecodeConfig imageDecodeConfig);

    @Keep
    IBitmap loadBitmapSync(String str);

    @Keep
    IBitmap loadBitmapSync(String str, ImageDecodeConfig imageDecodeConfig);

    @Keep
    void release();

    @Keep
    void releaseBitmap(Bitmap bitmap);

    @Keep
    void removeDecodeEventListener(@NonNull b bVar);

    @Keep
    void removeImageStreamFetcher(@NonNull d dVar, boolean z16);

    @Keep
    void setBitmapDecodeSlave(a aVar);

    @Keep
    void setIdKeyReportDelegate(com.tencent.luggage.wxa.h.c cVar);

    @Keep
    void setKvReportDelegate(com.tencent.luggage.wxa.h.d dVar);

    @Keep
    void setMaxDecodeDimension(int i3, int i16);

    @Keep
    void setNetworkTimeout(int i3, int i16);
}
