package hr3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.qmethod.pandoraex.core.o;
import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\f"}, d2 = {"Lhr3/a;", "", "", "srcWidth", "srcHeight", "b", "Landroid/graphics/Bitmap;", "srcImg", "", "a", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f406095a = new a();

    a() {
    }

    private final int b(int srcWidth, int srcHeight) {
        int coerceAtLeast;
        int coerceAtMost;
        int i3;
        int i16;
        if (srcWidth % 2 == 1) {
            srcWidth++;
        }
        if (srcHeight % 2 == 1) {
            srcHeight++;
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(srcWidth, srcHeight);
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(srcWidth, srcHeight);
        float f16 = coerceAtMost / coerceAtLeast;
        if (f16 <= 1 && f16 > 0.5625d) {
            if (coerceAtLeast < 1664) {
                return 1;
            }
            if (coerceAtLeast < 4990) {
                i16 = 2;
            } else if (4991 <= coerceAtLeast && 10239 >= coerceAtLeast) {
                i16 = 4;
            } else {
                i3 = coerceAtLeast / 1280;
            }
            return i16;
        }
        double d16 = f16;
        if (d16 <= 0.5625d && d16 > 0.5d) {
            i3 = coerceAtLeast / 1280;
            if (i3 == 0) {
                return 1;
            }
        } else {
            return (int) Math.ceil(coerceAtLeast / (1280.0d / d16));
        }
        return i3;
    }

    @NotNull
    public final byte[] a(@NotNull Bitmap srcImg) {
        Bitmap bitmap;
        OutOfMemoryError e16;
        Intrinsics.checkParameterIsNotNull(srcImg, "srcImg");
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    srcImg.compress(Bitmap.CompressFormat.JPEG, 60, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    CloseableKt.closeFinally(byteArrayOutputStream, null);
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
                    options.inSampleSize = b(options.outWidth, options.outHeight);
                    options.inJustDecodeBounds = false;
                    bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
                    if (bitmap != null) {
                        try {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            try {
                                o.a("Compress", "Compress result=" + bitmap.compress(Bitmap.CompressFormat.JPEG, 60, byteArrayOutputStream));
                                byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                                CloseableKt.closeFinally(byteArrayOutputStream, null);
                                if (!srcImg.isRecycled()) {
                                    srcImg.recycle();
                                }
                                if (!bitmap.isRecycled()) {
                                    bitmap.recycle();
                                }
                                Intrinsics.checkExpressionValueIsNotNull(byteArray2, "ByteArrayOutputStream().\u2026e.recycle()\n            }");
                                return byteArray2;
                            } finally {
                            }
                        } catch (OutOfMemoryError e17) {
                            e16 = e17;
                            o.d("Compress", "Compress fail, oom!", e16);
                            if (!srcImg.isRecycled()) {
                                srcImg.recycle();
                            }
                            if (bitmap != null && !bitmap.isRecycled()) {
                                bitmap.recycle();
                            }
                            return new byte[0];
                        }
                    } else {
                        return new byte[0];
                    }
                } finally {
                    try {
                        throw th;
                    } finally {
                    }
                }
            } catch (OutOfMemoryError e18) {
                bitmap = null;
                e16 = e18;
            }
        } catch (Throwable th5) {
            o.d("Compress", "Compress fail, unknown error!", th5);
            return new byte[0];
        }
    }
}
