package com.google.android.renderscript;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import m1.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u0082 J\u0011\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0082 JK\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0082 J3\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0082 J&\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\r\u001a\u00020\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007R\u0016\u0010\u0004\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001b"}, d2 = {"Lcom/google/android/renderscript/Toolkit;", "", "", "createNative", "nativeHandle", "", "destroyNative", "", "inputArray", "", "vectorSize", "sizeX", "sizeY", "radius", "outputArray", "Lcom/google/android/renderscript/Range2d;", "restriction", "nativeBlur", "Landroid/graphics/Bitmap;", "inputBitmap", "outputBitmap", "nativeBlurBitmap", "b", "a", "J", "<init>", "()V", "renderscript-toolkit_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class Toolkit {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static long nativeHandle;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final Toolkit f34531b;

    static {
        Toolkit toolkit = new Toolkit();
        f34531b = toolkit;
        System.loadLibrary("renderscript-toolkit");
        nativeHandle = toolkit.createNative();
    }

    Toolkit() {
    }

    public static /* synthetic */ Bitmap c(Toolkit toolkit, Bitmap bitmap, int i3, Range2d range2d, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 5;
        }
        if ((i16 & 4) != 0) {
            range2d = null;
        }
        return toolkit.b(bitmap, i3, range2d);
    }

    private final native long createNative();

    private final native void destroyNative(long nativeHandle2);

    private final native void nativeBlur(long nativeHandle2, byte[] inputArray, int vectorSize, int sizeX, int sizeY, int radius, byte[] outputArray, Range2d restriction);

    private final native void nativeBlurBitmap(long nativeHandle2, Bitmap inputBitmap, Bitmap outputBitmap, int radius, Range2d restriction);

    @JvmOverloads
    @NotNull
    public final Bitmap a(@NotNull Bitmap bitmap, int i3) {
        return c(this, bitmap, i3, null, 4, null);
    }

    @JvmOverloads
    @NotNull
    public final Bitmap b(@NotNull Bitmap inputBitmap, int radius, @Nullable Range2d restriction) {
        Intrinsics.checkNotNullParameter(inputBitmap, "inputBitmap");
        boolean z16 = false;
        b.c("blur", inputBitmap, false, 4, null);
        if (1 <= radius && 25 >= radius) {
            z16 = true;
        }
        if (z16) {
            b.d("blur", inputBitmap.getWidth(), inputBitmap.getHeight(), restriction);
            Bitmap outputBitmap = b.a(inputBitmap);
            long j3 = nativeHandle;
            Intrinsics.checkNotNullExpressionValue(outputBitmap, "outputBitmap");
            nativeBlurBitmap(j3, inputBitmap, outputBitmap, radius, restriction);
            return outputBitmap;
        }
        throw new IllegalArgumentException(("RenderScript Toolkit blur. The radius should be between 1 and 25. " + radius + " provided.").toString());
    }
}
