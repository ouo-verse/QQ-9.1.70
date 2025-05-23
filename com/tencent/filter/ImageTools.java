package com.tencent.filter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public class ImageTools {
    static IPatchRedirector $redirector_ = null;
    public static final int BLURBORDER_RADIUS = 2;
    public static final int SMOOTHBORDER_RADIUS = 11;

    public ImageTools() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void formatAlphaBitmap(Bitmap bitmap) {
        PaintSelection.FormatAlphaBitmap(bitmap);
    }

    public static boolean hasAlphaBitmap(Bitmap bitmap) {
        return PaintSelection.HasAlphaBitmap(bitmap);
    }

    public static void processBitmap(Bitmap bitmap, Bitmap bitmap2) {
        PaintSelection.ProcessBitmap(bitmap, bitmap2);
    }

    public static void reverseBitmapAlpha(Bitmap bitmap) {
        PaintSelection.reverseBitmapAlpha(bitmap);
    }

    public static Bitmap toColorRedscale(Bitmap bitmap) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.set(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 70.0f, 0.0f, 1.0f, 0.0f, 0.0f, -30.0f, 0.0f, 0.0f, 1.0f, 0.0f, -30.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
            paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            return createBitmap;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static Bitmap toGrayscale(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    public static Bitmap toRoundCorner(Bitmap bitmap, int i3) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        float f16 = i3;
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, f16, f16, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    public static Bitmap toGrayscale(Bitmap bitmap, int i3) {
        return toRoundCorner(toGrayscale(bitmap), i3);
    }

    public static BitmapDrawable toRoundCorner(BitmapDrawable bitmapDrawable, int i3) {
        return new BitmapDrawable(toRoundCorner(bitmapDrawable.getBitmap(), i3));
    }
}
