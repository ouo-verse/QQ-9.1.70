package com.tencent.ams.fusion.widget.animatorview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AnimatorUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "AnimatorUtils";

    public AnimatorUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Bitmap convertGrayBitmap(Bitmap bitmap) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_4444);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0.0f);
            paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            return createBitmap;
        } catch (Throwable th5) {
            Logger.w(TAG, "convertGrayBitmap failed: " + th5.getMessage());
            return bitmap;
        }
    }

    public static int convertGrayColor(int i3) {
        int alpha = Color.alpha(i3);
        int red = (((Color.red(i3) * 38) + (Color.green(i3) * 75)) + (Color.blue(i3) * 15)) >> 7;
        return red | (alpha << 24) | (red << 16) | (red << 8);
    }

    public static Drawable convertGrayDrawable(Drawable drawable) {
        try {
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_4444);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            return new BitmapDrawable(convertGrayBitmap(createBitmap));
        } catch (Throwable th5) {
            Logger.w(TAG, "convertGrayDrawable failed: " + th5.getMessage());
            return drawable;
        }
    }

    public static int getAlphaForColor(int i3) {
        return (i3 >> 24) & 255;
    }

    public static int getColorWithAlpha(int i3, int i16) {
        return (Math.min(255, Math.max(0, i3)) << 24) + (i16 & 16777215);
    }

    public static Rect getRectFromView(View view) {
        if (view == null) {
            return new Rect();
        }
        Rect rect = new Rect();
        rect.left = view.getLeft();
        rect.top = view.getTop();
        rect.right = view.getRight();
        rect.bottom = view.getBottom();
        return rect;
    }

    public static int getTransitionColor(float f16, int i3, int i16) {
        float f17 = ((i3 >> 24) & 255) / 255.0f;
        float pow = (float) Math.pow(((i3 >> 16) & 255) / 255.0f, 2.2d);
        float pow2 = (float) Math.pow(((i3 >> 8) & 255) / 255.0f, 2.2d);
        float pow3 = (float) Math.pow((i3 & 255) / 255.0f, 2.2d);
        float pow4 = (float) Math.pow(((i16 >> 16) & 255) / 255.0f, 2.2d);
        float f18 = f17 + (((((i16 >> 24) & 255) / 255.0f) - f17) * f16);
        float pow5 = pow2 + ((((float) Math.pow(((i16 >> 8) & 255) / 255.0f, 2.2d)) - pow2) * f16);
        float pow6 = pow3 + (f16 * (((float) Math.pow((i16 & 255) / 255.0f, 2.2d)) - pow3));
        return (Math.round(((float) Math.pow(pow + ((pow4 - pow) * f16), 0.45454545454545453d)) * 255.0f) << 16) | (Math.round(f18 * 255.0f) << 24) | (Math.round(((float) Math.pow(pow5, 0.45454545454545453d)) * 255.0f) << 8) | Math.round(((float) Math.pow(pow6, 0.45454545454545453d)) * 255.0f);
    }

    public static boolean isInDebug(Context context) {
        try {
            if ((context.getApplicationInfo().flags & 2) == 0) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
