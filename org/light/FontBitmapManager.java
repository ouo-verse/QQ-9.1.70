package org.light;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes29.dex */
public class FontBitmapManager {
    private static final String FONT_STYLE_ITALIC = "italic";
    private static final String FONT_STYLE_NORMAL = "normal";
    private static final String FONT_STYLE_OBLIQUE = "oblique";
    private static final String FONT_WEIGHT_BOLD = "bold";
    private static final String FONT_WEIGHT_NORMAL = "normal";
    static final String NAME = "FontBitmapManager";
    private static final String TAG = "FontBitmapManager";
    private final Map<String, Typeface> loadedTypefaceMap = new HashMap();

    private int typeFaceStyleFromW3CFont(int i3, int i16) {
        int i17;
        if (i3 == 1 || i3 == 2) {
            i17 = 2;
        } else {
            i17 = 0;
        }
        if (i16 == 1) {
            if (i17 != 2) {
                return 1;
            }
            return 3;
        }
        return i17;
    }

    private Typeface typefaceFromW3CFontParameters(int i3, int i16, String str) {
        if (this.loadedTypefaceMap.containsKey(str) && this.loadedTypefaceMap.get(str) != null) {
            return this.loadedTypefaceMap.get(str);
        }
        return Typeface.create(str, typeFaceStyleFromW3CFont(i3, i16));
    }

    public FontBitmap createBitmap(int i3, int i16, String str, String str2, float f16, boolean z16, float f17) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        Paint paint = new Paint(1);
        if (new File(str).exists()) {
            paint.setTypeface(Typeface.createFromFile(str));
        } else {
            paint.setTypeface(typefaceFromW3CFontParameters(i3, i16, "android_system_default"));
        }
        paint.setTextSize(f16);
        paint.setColor(SupportMenu.CATEGORY_MASK);
        if (z16) {
            paint.setStyle(Paint.Style.FILL);
        } else {
            paint.setStyle(Paint.Style.STROKE);
            if (f17 > 0.0f) {
                paint.setStrokeWidth(f17);
            }
        }
        float f18 = -paint.ascent();
        int measureText = (int) (paint.measureText(str2) + 0.5f);
        int descent = (int) (paint.descent() + f18 + 0.5f);
        if (measureText <= 0 || descent <= 0) {
            return null;
        }
        FontBitmap fontBitmap = new FontBitmap();
        Bitmap createBitmap = Bitmap.createBitmap(measureText, descent, Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawText(str2, 0.0f, f18, paint);
        fontBitmap.bitmap = createBitmap;
        fontBitmap.ascent = paint.ascent();
        fontBitmap.descent = paint.descent();
        return fontBitmap;
    }

    public int getTextLineHeight(String str, String str2, int i3, String str3, String str4) {
        int i16;
        int i17;
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
            return 0;
        }
        if (!"normal".equals(str)) {
            if ("italic".equals(str)) {
                i16 = 1;
            } else if (FONT_STYLE_OBLIQUE.equals(str)) {
                i16 = 2;
            }
            if (!"normal".equals(str2) && "bold".equals(str2)) {
                i17 = 1;
            } else {
                i17 = 0;
            }
            Paint paint = new Paint(1);
            paint.setTypeface(typefaceFromW3CFontParameters(i16, i17, str3));
            paint.setTextSize(i3);
            Rect rect = new Rect();
            paint.getTextBounds(str4, 0, str4.length(), rect);
            return rect.height();
        }
        i16 = 0;
        if (!"normal".equals(str2)) {
            i17 = 1;
            Paint paint2 = new Paint(1);
            paint2.setTypeface(typefaceFromW3CFontParameters(i16, i17, str3));
            paint2.setTextSize(i3);
            Rect rect2 = new Rect();
            paint2.getTextBounds(str4, 0, str4.length(), rect2);
            return rect2.height();
        }
        i17 = 0;
        Paint paint22 = new Paint(1);
        paint22.setTypeface(typefaceFromW3CFontParameters(i16, i17, str3));
        paint22.setTextSize(i3);
        Rect rect22 = new Rect();
        paint22.getTextBounds(str4, 0, str4.length(), rect22);
        return rect22.height();
    }

    public float measureText(int i3, int i16, String str, String str2, float f16, boolean z16, float f17) {
        if (TextUtils.isEmpty(str2)) {
            return 0.0f;
        }
        Paint paint = new Paint(1);
        if (new File(str).exists()) {
            paint.setTypeface(Typeface.createFromFile(str));
        } else {
            paint.setTypeface(typefaceFromW3CFontParameters(i3, i16, "android_system_default"));
        }
        paint.setTextSize(f16);
        if (z16) {
            paint.setStyle(Paint.Style.FILL);
        } else {
            paint.setStyle(Paint.Style.STROKE);
            if (f17 > 0.0f) {
                paint.setStrokeWidth(f17);
            }
        }
        return paint.measureText(str2);
    }

    public void saveImage(Bitmap bitmap) {
        File file = new File(Environment.getExternalStorageDirectory(), "FontBitmap");
        if (!file.exists()) {
            file.mkdir();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(file, System.currentTimeMillis() + ".jpg"));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e16) {
            e16.printStackTrace();
        } catch (IOException e17) {
            e17.printStackTrace();
        }
    }
}
