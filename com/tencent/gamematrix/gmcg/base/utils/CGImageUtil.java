package com.tencent.gamematrix.gmcg.base.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGImageUtil {
    public static byte[] bmpToByteArray(Bitmap bitmap, boolean z16) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        if (z16) {
            bitmap.recycle();
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return byteArray;
    }

    public static byte[] bmpToByteArrayInMaxSize(Bitmap bitmap, int i3, boolean z16) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        for (int i16 = 100; byteArrayOutputStream.toByteArray().length > i3 && i16 != 10; i16 -= 10) {
            byteArrayOutputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.JPEG, i16, byteArrayOutputStream);
        }
        if (z16) {
            bitmap.recycle();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] defaultBmpToByteArray(Context context, int i3, int i16) {
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), i3);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeResource, i16, i16, true);
        decodeResource.recycle();
        return bmpToByteArray(createScaledBitmap, true);
    }

    public static void loadBase64ImageSaveToPath(String str, String str2) {
        try {
            byte[] decode = Base64.decode(str, 0);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            fileOutputStream.write(decode);
            fileOutputStream.close();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static Bitmap loadImageWithSize(String str, int i3) {
        InputStream fileInputStream;
        try {
            if (str.startsWith("http")) {
                fileInputStream = new URL(str).openStream();
            } else {
                fileInputStream = new FileInputStream(str);
            }
            Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream);
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeStream, i3, i3, true);
            if (createScaledBitmap != decodeStream) {
                decodeStream.recycle();
            }
            return createScaledBitmap;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static Bitmap rotaImageView(int i3, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(i3);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (createBitmap.equals(bitmap)) {
            return createBitmap;
        }
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static String saveImageToLocal(Context context, int i3) {
        Bitmap bitmap = ((BitmapDrawable) context.getResources().getDrawable(i3)).getBitmap();
        String str = context.getCacheDir() + File.separator + "icon.png";
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.close();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return str;
    }
}
