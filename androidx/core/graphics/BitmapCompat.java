package androidx.core.graphics;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BitmapCompat {
    BitmapCompat() {
    }

    public static int getAllocationByteCount(@NonNull Bitmap bitmap) {
        return bitmap.getAllocationByteCount();
    }

    public static boolean hasMipMap(@NonNull Bitmap bitmap) {
        return bitmap.hasMipMap();
    }

    public static void setHasMipMap(@NonNull Bitmap bitmap, boolean z16) {
        bitmap.setHasMipMap(z16);
    }
}
