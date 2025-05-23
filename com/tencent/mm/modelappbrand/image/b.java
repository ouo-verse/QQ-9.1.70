package com.tencent.mm.modelappbrand.image;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b implements AppBrandSimpleImageLoader.j {
    public static Bitmap a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth > 0 && intrinsicHeight > 0) {
            try {
                Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                return createBitmap;
            } catch (OutOfMemoryError unused) {
            }
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.pb.a
    public String b() {
        return "RoundedBitmap";
    }

    @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.j
    public Bitmap b(Bitmap bitmap) {
        if (bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return bitmap;
        }
        RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(z.j(), bitmap);
        create.setCircular(true);
        Bitmap a16 = a(create);
        if (a16 != bitmap) {
            bitmap.recycle();
        }
        return a16;
    }
}
