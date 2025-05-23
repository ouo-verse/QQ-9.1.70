package com.tencent.mobileqq.activity.aio.zhitu;

import android.graphics.Bitmap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class GifDecoder {

    /* renamed from: a, reason: collision with root package name */
    private int f180293a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f180294b = 0;

    /* renamed from: c, reason: collision with root package name */
    private Bitmap[] f180295c = new Bitmap[0];

    /* renamed from: d, reason: collision with root package name */
    private int[] f180296d = new int[0];

    /* renamed from: e, reason: collision with root package name */
    private boolean f180297e = false;

    private native boolean nativeBitmapIteratorHasNext(long j3);

    private native GifImage nativeBitmapIteratornext(long j3, long j16);

    private native void nativeClose(long j3);

    private native int nativeGetDelay(long j3, int i3);

    private native Bitmap nativeGetFrame(long j3, int i3);

    private native int nativeGetFrameCount(long j3);

    private native int nativeGetHeight(long j3);

    private native int nativeGetWidth(long j3);

    private native long nativeInit();

    private native boolean nativeLoad(long j3, String str);

    private native long nativeLoadUsingIterator(long j3, String str);
}
