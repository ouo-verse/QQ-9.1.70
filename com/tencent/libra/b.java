package com.tencent.libra;

import android.graphics.Bitmap;
import com.tencent.libra.cache.BitmapPool;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ(\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/libra/b;", "", "Lcom/tencent/libra/cache/BitmapPool;", "bitmapPool", "", "width", "height", "Landroid/graphics/Bitmap$Config;", DownloadInfo.spKey_Config, "Landroid/graphics/Bitmap;", "a", "<init>", "()V", "libra-extension-base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f118583a = new b();

    b() {
    }

    @NotNull
    public final Bitmap a(@Nullable BitmapPool bitmapPool, int width, int height, @NotNull Bitmap.Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (bitmapPool != null) {
            return bitmapPool.get(width, height, config);
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, config);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "Bitmap.createBitmap(width, height, config)");
        return createBitmap;
    }
}
