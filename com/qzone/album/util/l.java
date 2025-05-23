package com.qzone.album.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes39.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private static final String f44390a = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getAbsolutePath() + "/dcim/Camera/");

    public static Bitmap a(Bitmap bitmap) {
        try {
            if (bitmap.getWidth() >= bitmap.getHeight()) {
                return Bitmap.createBitmap(bitmap, (bitmap.getWidth() / 2) - (bitmap.getHeight() / 2), 0, bitmap.getHeight(), bitmap.getHeight());
            }
            return Bitmap.createBitmap(bitmap, 0, (bitmap.getHeight() / 2) - (bitmap.getWidth() / 2), bitmap.getWidth(), bitmap.getWidth());
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static boolean c(Bitmap bitmap, String str) {
        File file = new File(str);
        boolean z16 = false;
        if (file.exists() || bitmap == null) {
            return false;
        }
        OutputStream outputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                file.createNewFile();
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
                    bitmap.compress(compressFormat, 100, bufferedOutputStream2);
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                    z16 = true;
                    outputStream = compressFormat;
                } catch (Exception e17) {
                    e = e17;
                    bufferedOutputStream = bufferedOutputStream2;
                    e.printStackTrace();
                    outputStream = bufferedOutputStream;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                            outputStream = bufferedOutputStream;
                        } catch (IOException e18) {
                            e18.printStackTrace();
                            outputStream = bufferedOutputStream;
                        }
                    }
                    return z16;
                } catch (Throwable th5) {
                    th = th5;
                    outputStream = bufferedOutputStream2;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e26) {
                e = e26;
            }
            return z16;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static String d(Context context, Bitmap bitmap) {
        String str = f44390a + UUID.randomUUID().toString() + ".jpg";
        if (context != null) {
            str = context.getCacheDir().getAbsolutePath() + File.separator + UUID.randomUUID().toString() + ".jpg";
        }
        return e(bitmap, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(Context context, String str) {
        Bitmap bitmap;
        Bitmap a16;
        try {
            bitmap = BitmapFactory.decodeStream(new BufferedInputStream(new FileInputStream(str)));
        } catch (FileNotFoundException e16) {
            e16.printStackTrace();
            bitmap = null;
            return bitmap != null ? null : null;
        } catch (OutOfMemoryError e17) {
            e17.printStackTrace();
            System.gc();
            bitmap = null;
            if (bitmap != null) {
            }
        }
        if (bitmap != null && (a16 = a(bitmap)) != null) {
            return d(context, a16);
        }
    }

    private static String e(Bitmap bitmap, String str) {
        if (bitmap != null && !TextUtils.isEmpty(str)) {
            if (c(bitmap, str)) {
                return str;
            }
            bitmap.recycle();
        }
        return null;
    }
}
