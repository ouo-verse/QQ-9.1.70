package com.tencent.mobileqq.activity.aio.zhitu;

import android.graphics.Bitmap;
import java.io.FileNotFoundException;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes10.dex */
public class GifEncoder {

    /* renamed from: a, reason: collision with root package name */
    private long f180298a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f180299b = 1;

    /* renamed from: c, reason: collision with root package name */
    private int f180300c;

    /* renamed from: d, reason: collision with root package name */
    private int f180301d;

    private native void nativeClose(long j3);

    private native boolean nativeEncodeFrame(long j3, Bitmap bitmap, int i3);

    private native long nativeInit(int i3, int i16, String str, int i17, int i18);

    private native void nativeSetDither(long j3, boolean z16);

    private native void nativeSetThreadCount(long j3, int i3);

    public void a() {
        nativeClose(this.f180298a);
        this.f180298a = 0L;
    }

    public boolean b(Bitmap bitmap, int i3) {
        if (0 == this.f180298a) {
            return false;
        }
        if (bitmap.getWidth() == this.f180300c && bitmap.getHeight() == this.f180301d) {
            nativeEncodeFrame(this.f180298a, bitmap, i3);
            return true;
        }
        throw new RuntimeException(String.format(Locale.ENGLISH, "The size specified at initialization differs from the size of the image.\n expected:(%d, %d) actual:(%d,%d)", Integer.valueOf(this.f180300c), Integer.valueOf(this.f180301d), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())));
    }

    public void c(int i3, int i16, String str, int i17) throws FileNotFoundException {
        if (0 != this.f180298a) {
            a();
        }
        this.f180300c = i3;
        this.f180301d = i16;
        long nativeInit = nativeInit(i3, i16, str, i17, this.f180299b);
        this.f180298a = nativeInit;
        if (0 != nativeInit) {
        } else {
            throw new FileNotFoundException();
        }
    }
}
