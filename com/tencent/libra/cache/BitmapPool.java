package com.tencent.libra.cache;

import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/libra/cache/BitmapPool;", "", "get", "Landroid/graphics/Bitmap;", "width", "", "height", DownloadInfo.spKey_Config, "Landroid/graphics/Bitmap$Config;", "put", "", MimeHelper.IMAGE_SUBTYPE_BITMAP, "libra-extension-base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public interface BitmapPool {
    @NotNull
    Bitmap get(int width, int height, @NotNull Bitmap.Config config);

    void put(@NotNull Bitmap bitmap);
}
