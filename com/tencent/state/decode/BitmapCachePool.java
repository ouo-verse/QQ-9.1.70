package com.tencent.state.decode;

import android.graphics.Bitmap;
import androidx.core.util.Pools;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\tJ\u001a\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u0012\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/state/decode/BitmapCachePool;", "", DownloadInfo.spKey_Config, "Landroid/graphics/Bitmap$Config;", "(Landroid/graphics/Bitmap$Config;)V", "BITMAP_POOL", "Landroidx/core/util/Pools$SynchronizedPool;", "Landroid/graphics/Bitmap;", "clearPool", "", "obtainBitmapWithSize", "width", "", "height", "obtainTileBitmap", "recycleBitmap", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes33.dex */
public final class BitmapCachePool {
    private static final int POOL_SIZE = 12;
    private static final String TAG = "BitmapCachePool";
    private final Pools.SynchronizedPool<Bitmap> BITMAP_POOL;
    private final Bitmap.Config config;

    public BitmapCachePool(Bitmap.Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        this.BITMAP_POOL = new Pools.SynchronizedPool<>(12);
    }

    private final Bitmap obtainBitmapWithSize(int width, int height) {
        Bitmap acquire = this.BITMAP_POOL.acquire();
        ArrayList arrayList = new ArrayList();
        while (acquire != null && (acquire.getWidth() != width || acquire.getHeight() != height)) {
            arrayList.add(acquire);
            acquire = this.BITMAP_POOL.acquire();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            recycleBitmap((Bitmap) it.next());
        }
        return acquire;
    }

    public final void clearPool() {
        Bitmap acquire = this.BITMAP_POOL.acquire();
        while (acquire != null) {
            acquire.recycle();
            acquire = this.BITMAP_POOL.acquire();
        }
    }

    public final Bitmap obtainTileBitmap(int width, int height) {
        Bitmap obtainBitmapWithSize = obtainBitmapWithSize(width, height);
        return obtainBitmapWithSize != null ? obtainBitmapWithSize : BitmapUtils.INSTANCE.createBitmap(width, height, this.config);
    }

    private final void recycleBitmap(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        try {
            this.BITMAP_POOL.release(bitmap);
        } catch (Throwable unused) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "release bitmap error: " + bitmap, null, 4, null);
        }
    }
}
