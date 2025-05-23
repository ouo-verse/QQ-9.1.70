package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.concurrent.locks.Lock;

/* compiled from: P */
/* loaded from: classes.dex */
final class r {

    /* renamed from: a, reason: collision with root package name */
    private static final r.d f31849a = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static com.bumptech.glide.load.engine.q<Bitmap> a(r.d dVar, Drawable drawable, int i3, int i16) {
        Bitmap bitmap;
        Drawable current = drawable.getCurrent();
        boolean z16 = false;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (!(current instanceof Animatable)) {
            bitmap = b(dVar, current, i3, i16);
            z16 = true;
        } else {
            bitmap = null;
        }
        if (!z16) {
            dVar = f31849a;
        }
        return e.b(bitmap, dVar);
    }

    @Nullable
    private static Bitmap b(r.d dVar, Drawable drawable, int i3, int i16) {
        if (i3 == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            return null;
        }
        if (i16 == Integer.MIN_VALUE && drawable.getIntrinsicHeight() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
            }
            return null;
        }
        if (drawable.getIntrinsicWidth() > 0) {
            i3 = drawable.getIntrinsicWidth();
        }
        if (drawable.getIntrinsicHeight() > 0) {
            i16 = drawable.getIntrinsicHeight();
        }
        Lock f16 = ac.f();
        f16.lock();
        Bitmap bitmap = dVar.get(i3, i16, Bitmap.Config.ARGB_8888);
        try {
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, i3, i16);
            drawable.draw(canvas);
            canvas.setBitmap(null);
            return bitmap;
        } finally {
            f16.unlock();
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    class a extends r.e {
        a() {
        }

        @Override // r.e, r.d
        public void put(Bitmap bitmap) {
        }
    }
}
