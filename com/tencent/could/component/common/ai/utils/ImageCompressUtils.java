package com.tencent.could.component.common.ai.utils;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ImageCompressUtils {
    static IPatchRedirector $redirector_ = null;
    public static final int DEFAULT_LEVEL = 1;
    public static final int MINIMUM_LEVEL = 2;

    public ImageCompressUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static byte[] compressBitmap(Bitmap bitmap, int i3, int i16) {
        int i17;
        int i18;
        if (i16 == 2) {
            i18 = i3;
            i17 = 5;
        } else {
            i17 = 10;
            i18 = 1024;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                int i19 = 85;
                bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
                while (byteArrayOutputStream.toByteArray().length / 1024 > i18 && i19 > 5) {
                    byteArrayOutputStream.reset();
                    i19 -= i17;
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i19, byteArrayOutputStream);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } finally {
            }
        } catch (IOException e16) {
            Log.e("ImageCompressUtils", "compressBitmap io error: " + e16.getLocalizedMessage());
            return null;
        }
    }

    public static Bitmap createBitMapByUri(Context context, Uri uri, int i3, Point point) {
        int i16;
        if (i3 == 2 && point != null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inDither = true;
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            try {
                BitmapFactory.decodeStream(context.getContentResolver().openInputStream(uri), null, options);
                int i17 = options.outWidth;
                int i18 = options.outHeight;
                int i19 = point.x;
                i16 = Math.min(i17 / i19, i18 / i19);
            } catch (FileNotFoundException e16) {
                Log.e("ImageCompressUtils", "getCurrentSampleSize e: " + e16.getLocalizedMessage());
                i16 = 2;
            }
            if (i16 > 5) {
                i16 = 5;
            }
        } else {
            i16 = 2;
        }
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inPreferredConfig = Bitmap.Config.RGB_565;
        if (i3 == 2) {
            options2.inSampleSize = i16;
        }
        return BitmapFactory.decodeStream(context.getContentResolver().openInputStream(uri), null, options2);
    }

    public static byte[] doCompressYuvImage(YuvImage yuvImage, int i3) {
        int width = yuvImage.getWidth();
        int height = yuvImage.getHeight();
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                if (i3 == 1) {
                    yuvImage.compressToJpeg(new Rect(0, 0, width, height), 85, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
                if (i3 == 2) {
                    yuvImage.compressToJpeg(new Rect(0, 0, width, height), 85, byteArrayOutputStream);
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = Bitmap.Config.RGB_565;
                    options.inSampleSize = 2;
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size(), options);
                    byteArrayOutputStream.reset();
                    decodeByteArray.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
                    byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray2;
                }
                byteArrayOutputStream.close();
                return null;
            } finally {
            }
        } catch (IOException unused) {
            Log.e("ImageCompressUtils", "Compress error");
            return null;
        }
    }

    public static int getBitmapDegree(String str) {
        int attributeInt;
        try {
            attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
        } catch (IOException e16) {
            Log.e("ImageCompressUtils", "getBitmapDegree error : " + e16.getLocalizedMessage());
        }
        if (attributeInt != 3) {
            if (attributeInt != 6) {
                if (attributeInt == 8) {
                    return 270;
                }
                return 0;
            }
            return 90;
        }
        return 180;
    }

    public static String getDataColumn(Context context, Uri uri, String str, String[] strArr) {
        Cursor cursor = null;
        try {
            Cursor query = ContactsMonitor.query(context.getContentResolver(), uri, new String[]{"_data"}, str, strArr, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(query.getColumnIndexOrThrow("_data"));
                        query.close();
                        return string;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static String getPath(Context context, Uri uri) {
        Uri uri2 = null;
        if (DocumentsContract.isDocumentUri(context, uri)) {
            if (isExternalStorageDocument(uri)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(":");
                if ("primary".equalsIgnoreCase(split[0])) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            } else {
                if (isDownloadsDocument(uri)) {
                    return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                }
                if (isMediaDocument(uri)) {
                    String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                    String str = split2[0];
                    if ("image".equals(str)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(str)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return getDataColumn(context, uri2, "_id=?", new String[]{split2[1]});
                }
            }
        } else {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                return getDataColumn(context, uri, null, null);
            }
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static Bitmap rotateBitmapByDegree(Bitmap bitmap, int i3) {
        Bitmap bitmap2;
        if (i3 == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(i3);
        try {
            bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (OutOfMemoryError unused) {
            bitmap2 = null;
        }
        if (bitmap2 == null) {
            bitmap2 = bitmap;
        }
        if (bitmap != bitmap2) {
            bitmap.recycle();
        }
        return bitmap2;
    }
}
