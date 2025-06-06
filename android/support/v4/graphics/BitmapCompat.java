package android.support.v4.graphics;

import android.graphics.Bitmap;
import android.support.annotation.RequiresApi;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BitmapCompat {
    static final BitmapCompatBaseImpl IMPL = new BitmapCompatApi19Impl();

    /* compiled from: P */
    @RequiresApi(18)
    /* loaded from: classes.dex */
    static class BitmapCompatApi18Impl extends BitmapCompatBaseImpl {
        BitmapCompatApi18Impl() {
        }

        @Override // android.support.v4.graphics.BitmapCompat.BitmapCompatBaseImpl
        public boolean hasMipMap(Bitmap bitmap) {
            return bitmap.hasMipMap();
        }

        @Override // android.support.v4.graphics.BitmapCompat.BitmapCompatBaseImpl
        public void setHasMipMap(Bitmap bitmap, boolean z16) {
            bitmap.setHasMipMap(z16);
        }
    }

    /* compiled from: P */
    @RequiresApi(19)
    /* loaded from: classes.dex */
    static class BitmapCompatApi19Impl extends BitmapCompatApi18Impl {
        BitmapCompatApi19Impl() {
        }

        @Override // android.support.v4.graphics.BitmapCompat.BitmapCompatBaseImpl
        public int getAllocationByteCount(Bitmap bitmap) {
            return bitmap.getAllocationByteCount();
        }
    }

    BitmapCompat() {
    }

    public static int getAllocationByteCount(Bitmap bitmap) {
        return IMPL.getAllocationByteCount(bitmap);
    }

    public static boolean hasMipMap(Bitmap bitmap) {
        return IMPL.hasMipMap(bitmap);
    }

    public static void setHasMipMap(Bitmap bitmap, boolean z16) {
        IMPL.setHasMipMap(bitmap, z16);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class BitmapCompatBaseImpl {
        BitmapCompatBaseImpl() {
        }

        public int getAllocationByteCount(Bitmap bitmap) {
            return bitmap.getByteCount();
        }

        public boolean hasMipMap(Bitmap bitmap) {
            return false;
        }

        public void setHasMipMap(Bitmap bitmap, boolean z16) {
        }
    }
}
