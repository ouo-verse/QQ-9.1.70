package p04;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes25.dex */
public class d extends a {
    private n04.a d(@Nullable Drawable drawable, int i3) {
        Bitmap bitmap;
        if (drawable instanceof StateListDrawable) {
            Drawable current = drawable.getCurrent();
            if ((current instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) current).getBitmap()) != null) {
                return new n04.a(i3, bitmap.getWidth(), bitmap.getHeight(), l04.d.a(bitmap));
            }
            return null;
        }
        return null;
    }

    @Override // p04.a
    @Nullable
    public n04.a a(@Nullable Drawable drawable) {
        return d(drawable, 0);
    }

    @Override // p04.a
    @Nullable
    public n04.a b(@Nullable Drawable drawable) {
        return d(drawable, 1);
    }
}
