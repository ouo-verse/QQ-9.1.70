package com.tencent.mobileqq.opr.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Size;
import android.webkit.URLUtil;
import com.tencent.mobileqq.opr.utils.log.OprLogger;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0010\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u0012\u0010\b\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u001a\u001e\u0010\u000e\u001a\u00020\r*\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b\u001a\f\u0010\u000f\u001a\u00020\u0006*\u0004\u0018\u00010\u0004\u001a\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0004*\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u00a8\u0006\u0013"}, d2 = {"", "", "width", "height", "Landroid/graphics/Bitmap;", "a", "Landroid/util/Size;", "size", "d", "", "path", "Landroid/graphics/Bitmap$CompressFormat;", "format", "", "b", "e", "Landroid/graphics/Bitmap$Config;", DownloadInfo.spKey_Config, "f", "opr_debug"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class a {
    @Nullable
    public static final Bitmap a(@Nullable byte[] bArr, int i3, int i16) {
        boolean z16;
        if (bArr != null) {
            int i17 = 0;
            if (bArr.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                int i18 = i3 * i16;
                int[] iArr = new int[i18];
                int i19 = i18 - 1;
                if (i19 >= 0) {
                    while (true) {
                        int i26 = i17 + 1;
                        int i27 = i17 * 3;
                        iArr[i17] = (bArr[i27 + 2] & 255) | ((bArr[i27] & 255) << 16) | (-16777216) | ((bArr[i27 + 1] & 255) << 8);
                        if (i26 > i19) {
                            break;
                        }
                        i17 = i26;
                    }
                }
                return Bitmap.createBitmap(iArr, i3, i16, Bitmap.Config.ARGB_8888);
            }
            return null;
        }
        return null;
    }

    public static final boolean b(@Nullable Bitmap bitmap, @NotNull String path, @NotNull Bitmap.CompressFormat format) {
        boolean z16;
        File file;
        File parentFile;
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(format, "format");
        if (bitmap == null || bitmap.isRecycled()) {
            return false;
        }
        if (path.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || (parentFile = (file = new File(path)).getParentFile()) == null) {
            return false;
        }
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            return false;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                if (!bitmap.compress(format, 100, fileOutputStream)) {
                    OprLogger.e("[opr]BitmapUtil", "save bitmap failed on compress bitmap");
                    CloseableKt.closeFinally(fileOutputStream, null);
                    return false;
                }
                fileOutputStream.flush();
                CloseableKt.closeFinally(fileOutputStream, null);
                return true;
            } finally {
            }
        } catch (Throwable th5) {
            OprLogger.e("[opr]BitmapUtil", "save bitmap to " + ((Object) file.getAbsolutePath()) + " exception", th5);
            return false;
        }
    }

    public static /* synthetic */ boolean c(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            compressFormat = Bitmap.CompressFormat.JPEG;
        }
        return b(bitmap, str, compressFormat);
    }

    @NotNull
    public static final Bitmap d(@NotNull Bitmap bitmap, @NotNull Size size) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        Intrinsics.checkNotNullParameter(size, "size");
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, size.getWidth(), size.getHeight(), true);
        Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "createScaledBitmap(this,\u2026width, size.height, true)");
        return createScaledBitmap;
    }

    @NotNull
    public static final Size e(@Nullable Bitmap bitmap) {
        int width;
        int i3 = 0;
        if (bitmap == null) {
            width = 0;
        } else {
            width = bitmap.getWidth();
        }
        if (bitmap != null) {
            i3 = bitmap.getHeight();
        }
        return new Size(width, i3);
    }

    @Nullable
    public static final Bitmap f(@NotNull String str, @NotNull Bitmap.Config config) {
        boolean z16;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(config, "config");
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || URLUtil.isNetworkUrl(str)) {
            return null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = config;
            return BitmapFactory.decodeFile(str, options);
        } catch (Throwable th5) {
            OprLogger.e("[opr]BitmapUtil", "decode bitmap from file:" + str + ", exception", th5);
            return null;
        }
    }

    public static /* synthetic */ Bitmap g(String str, Bitmap.Config config, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return f(str, config);
    }
}
