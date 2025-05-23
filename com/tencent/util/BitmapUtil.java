package com.tencent.util;

import android.R;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.StateListDrawable;
import android.media.ExifInterface;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public class BitmapUtil {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "BitmapUtil";

    public BitmapUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Bitmap decodeFile(String str) {
        return decodeFile(str, null);
    }

    public static Bitmap getBitmapFromView(View view) {
        redrawView(view);
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            if (width == 0 || height == 0) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            view.draw(new Canvas(createBitmap));
            return createBitmap;
        } catch (Exception | OutOfMemoryError unused) {
            return null;
        }
    }

    public static int getPictureRotate(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt != 3) {
                if (attributeInt != 6) {
                    if (attributeInt != 8) {
                        return 0;
                    }
                    return 270;
                }
                return 90;
            }
            return 180;
        } catch (IOException e16) {
            QLog.e(TAG, 1, "getPictureRotate failed", e16);
            return 0;
        }
    }

    public static Bitmap getShadowBitmap(Bitmap bitmap) {
        Paint paint = new Paint();
        paint.setMaskFilter(new BlurMaskFilter(1.0f, BlurMaskFilter.Blur.NORMAL));
        Bitmap extractAlpha = bitmap.extractAlpha(paint, new int[2]);
        Bitmap createBitmap = Bitmap.createBitmap(extractAlpha.getWidth(), extractAlpha.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas();
        canvas.setBitmap(createBitmap);
        canvas.drawBitmap(extractAlpha, 0.0f, 0.0f, paint);
        canvas.drawBitmap(bitmap, -r1[0], -r1[1], (Paint) null);
        extractAlpha.recycle();
        return createBitmap;
    }

    public static Bitmap getTopBitmap(Bitmap bitmap, int i3, int i16) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i17 = i3 / width;
        int i18 = i16 / height;
        if (i18 > i17) {
            int i19 = ((i16 - ((i3 * height) / width)) / 2) / height;
            return null;
        }
        if (i18 < i17) {
            int i26 = ((i3 - ((i16 * width) / height)) / 2) / width;
            return null;
        }
        return null;
    }

    public static Bitmap mergeBitmap(Bitmap bitmap, Bitmap bitmap2, int i3, int i16, int i17) {
        int max;
        int max2;
        if (bitmap == null) {
            return null;
        }
        if (bitmap2 == null) {
            return bitmap;
        }
        if (i17 == 0) {
            max = bitmap.getWidth();
            max2 = bitmap.getHeight() + bitmap2.getHeight();
        } else {
            max = Math.max(bitmap.getWidth(), bitmap2.getWidth());
            max2 = Math.max(bitmap.getHeight(), bitmap2.getHeight());
        }
        Bitmap createBitmap = Bitmap.createBitmap(max, max2, bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, new Matrix(), null);
        canvas.drawBitmap(bitmap2, i3, i16, (Paint) null);
        return createBitmap;
    }

    private static void redrawView(View view) {
        if (view == null) {
            return;
        }
        if (view instanceof ViewGroup) {
            view.destroyDrawingCache();
            view.invalidate();
            int i3 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i3 < viewGroup.getChildCount()) {
                    redrawView(viewGroup.getChildAt(i3));
                    i3++;
                } else {
                    return;
                }
            }
        } else {
            view.destroyDrawingCache();
            view.invalidate();
        }
    }

    public static Bitmap rotateBitmap(int i3, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(i3);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static StateListDrawable setClickStateHalfAlpha(Resources resources, Bitmap bitmap, Bitmap bitmap2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        BitmapDrawable bitmapDrawable = null;
        if (bitmap == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable2 = new BitmapDrawable(resources, bitmap);
        if (bitmap2 != null) {
            bitmapDrawable = new BitmapDrawable(resources, bitmap2);
        }
        if (bitmapDrawable != null) {
            stateListDrawable.addState(new int[]{R.attr.state_pressed, R.attr.state_enabled}, bitmapDrawable);
        }
        stateListDrawable.addState(new int[]{R.attr.state_focused}, bitmapDrawable2);
        stateListDrawable.addState(new int[0], bitmapDrawable2);
        return stateListDrawable;
    }

    public static Bitmap decodeFile(String str, BitmapFactory.Options options) {
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        int pictureRotate = getPictureRotate(str);
        if (pictureRotate == 0) {
            return decodeFile;
        }
        try {
            return rotateBitmap(pictureRotate, decodeFile);
        } catch (IllegalArgumentException e16) {
            QLog.e(TAG, 1, "rotateBitmap failed", e16);
            return decodeFile;
        }
    }
}
