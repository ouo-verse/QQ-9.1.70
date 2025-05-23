package com.tencent.zplan.encode.utils;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\bJ\u001e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/zplan/encode/utils/e;", "", "", "width", "rowIndex", "colIndex", "c", "size", "", "d", "b", "", "pixels", "height", "a", "[B", "alphaPixels", "<init>", "()V", "base_util_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes38.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f385508a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static byte[] alphaPixels;

    e() {
    }

    private final int c(int width, int rowIndex, int colIndex) {
        return ((rowIndex * width) + colIndex) * 4;
    }

    public final void d(int size) {
        alphaPixels = new byte[size];
    }

    public final void b() {
        alphaPixels = null;
    }

    public final byte[] a(byte[] pixels, int height, int width) {
        Intrinsics.checkParameterIsNotNull(pixels, "pixels");
        byte[] bArr = alphaPixels;
        if (bArr == null) {
            Log.d("RGBAUtils", Intrinsics.stringPlus("alphaPixels is null: ", Boolean.valueOf(bArr == null)));
            return pixels;
        }
        if (pixels.length < 4 || pixels.length % 4 != 0) {
            return pixels;
        }
        if (height > 0) {
            int i3 = 0;
            while (true) {
                int i16 = i3 + 1;
                if (width > 0) {
                    int i17 = 0;
                    while (true) {
                        int i18 = i17 + 1;
                        e eVar = f385508a;
                        int c16 = eVar.c(width, i3, i17);
                        byte b16 = pixels[c16 + 3];
                        byte b17 = pixels[c16 + 0];
                        byte b18 = pixels[c16 + 1];
                        byte b19 = pixels[c16 + 2];
                        int i19 = (width * i16 * 4) + (width * i3 * 4) + (i17 * 4);
                        bArr[i19 + 3] = b16;
                        bArr[i19 + 0] = b17;
                        bArr[i19 + 1] = b18;
                        bArr[i19 + 2] = b19;
                        int c17 = eVar.c(width * 2, i3, i17);
                        bArr[c17 + 3] = b16;
                        bArr[c17 + 0] = b16;
                        bArr[c17 + 1] = b16;
                        bArr[c17 + 2] = b16;
                        if (i18 >= width) {
                            break;
                        }
                        i17 = i18;
                    }
                }
                if (i16 >= height) {
                    break;
                }
                i3 = i16;
            }
        }
        return bArr;
    }
}
