package com.tencent.qzonehub.api.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IGifAntishakeApi;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes34.dex */
public class GifAntishakeApiImpl implements IGifAntishakeApi {
    private static final int HASH_SIZE = 8;
    private static int SIMILARITY_DHASH_ERROR_CODE = 16;
    private static final String TAG = "GifAntishakeApiImpl";

    public static Bitmap toGrayscale(Bitmap bitmap) {
        bitmap.getHeight();
        bitmap.getWidth();
        Bitmap createBitmap = Bitmap.createBitmap(9, 8, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    @Override // com.tencent.qzonehub.api.IGifAntishakeApi
    public String getDhash(Bitmap bitmap) {
        try {
            Bitmap grayscale = toGrayscale(Bitmap.createScaledBitmap(bitmap, 9, 8, true));
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < 8; i3++) {
                int i16 = 0;
                while (i16 < 8) {
                    int pixel = grayscale.getPixel(i16, i3);
                    i16++;
                    arrayList.add(Boolean.valueOf(pixel > grayscale.getPixel(i16, i3)));
                }
            }
            System.gc();
            int size = arrayList.size();
            String str = "";
            int i17 = 0;
            for (int i18 = 0; i18 < size; i18++) {
                if (((Boolean) arrayList.get(i18)).booleanValue()) {
                    i17 += (i18 % 8) ^ 2;
                }
                if (i18 % 8 == 7) {
                    str = String.format("%s%s", str, String.format("%02x", Integer.valueOf(i17)));
                    i17 = 0;
                }
            }
            return str;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getDhash failed t:", th5);
            return "";
        }
    }

    @Override // com.tencent.qzonehub.api.IGifAntishakeApi
    public int getDistance(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str.length() == str2.length()) {
            int i3 = 0;
            for (int i16 = 0; i16 < str.length(); i16++) {
                if (str.charAt(i16) != str2.charAt(i16)) {
                    i3++;
                }
            }
            return i3;
        }
        return SIMILARITY_DHASH_ERROR_CODE;
    }
}
