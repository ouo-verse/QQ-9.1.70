package com.tencent.mobileqq.mini.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.minigame.utils.PathUtil;
import com.tencent.mobileqq.utils.StringUtil;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ImageUtil {
    public static final float BITMAP_QUALITY_COMPRESS_HEIGHT_BOUNDARY = 4000.0f;
    public static final float BITMAP_QUALITY_COMPRESS_WIDTH_BOUNDARY = 1440.0f;
    public static final int DEFAULT_FILE_BUFFER_SIZE = 8192;
    public static final int SIZE_1KB = 1024;
    public static final String TAG = "ImageUtil";

    public static Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap createBitmap;
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        if (drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
            createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        } else {
            createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static Drawable getDrawable(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = new ColorDrawable(0);
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mPlayGifImage = true;
        if (PathUtil.isNetworkUrl(str)) {
            return URLDrawable.getDrawable(str, obtain);
        }
        return URLDrawable.getFileDrawable(MiniAppFileManager.getInstance().getAbsolutePath(str), obtain);
    }

    public static int getExifOrientation(String str) {
        ExifInterface exifInterface;
        int attributeInt;
        if (isPngFile(str)) {
            return 0;
        }
        try {
            exifInterface = new ExifInterface(str);
        } catch (IOException unused) {
            exifInterface = null;
        }
        if (exifInterface == null || (attributeInt = exifInterface.getAttributeInt("Orientation", -1)) == -1) {
            return 0;
        }
        if (attributeInt == 3) {
            return 180;
        }
        if (attributeInt != 6) {
            return attributeInt != 8 ? 0 : 270;
        }
        return 90;
    }

    public static Bitmap getLocalBitmap(String str) {
        FileInputStream fileInputStream;
        Throwable th5;
        BufferedInputStream bufferedInputStream;
        Bitmap bitmap = null;
        try {
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        if (StringUtil.isEmpty(str)) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(str);
            try {
                bufferedInputStream = new BufferedInputStream(fileInputStream, 8192);
            } catch (FileNotFoundException unused) {
                bufferedInputStream = null;
            } catch (OutOfMemoryError unused2) {
                bufferedInputStream = null;
            } catch (Throwable th6) {
                th5 = th6;
                bufferedInputStream = null;
            }
        } catch (FileNotFoundException unused3) {
            bufferedInputStream = null;
            fileInputStream = null;
        } catch (OutOfMemoryError unused4) {
            bufferedInputStream = null;
            fileInputStream = null;
        } catch (Throwable th7) {
            fileInputStream = null;
            th5 = th7;
            bufferedInputStream = null;
        }
        try {
            bitmap = BitmapFactory.decodeStream(bufferedInputStream);
            fileInputStream.close();
            bufferedInputStream.close();
        } catch (FileNotFoundException unused5) {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            return bitmap;
        } catch (OutOfMemoryError unused6) {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            return bitmap;
        } catch (Throwable th8) {
            th5 = th8;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e17) {
                    e17.printStackTrace();
                    throw th5;
                }
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            throw th5;
        }
        return bitmap;
    }

    public static boolean isPngFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.endsWith("png") || str.endsWith("PNG");
    }

    public static Bitmap rotaingImageView(int i3, Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i3);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }
}
