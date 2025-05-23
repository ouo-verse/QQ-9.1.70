package com.tencent.mobileqq.activity.richmedia;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes10.dex */
public class FileUtils {
    private static final String TAG = "FileUtils";
    public static Context sContextObj = SdkContext.getInstance().getApplication();
    private static String RootBasePath = "/";

    public static boolean fileExists(String str) {
        if (str == null || !new File(str).exists()) {
            return false;
        }
        return true;
    }

    public static Bitmap loadBitmapFromNative(String str, boolean z16) {
        return loadBitmapFromNative(str, z16, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0042, code lost:
    
        if (com.tencent.sveffects.SLog.isEnable() == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:
    
        com.tencent.sveffects.SLog.e("FileUtils", "readFileContent", r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0069, code lost:
    
        if (com.tencent.sveffects.SLog.isEnable() == false) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String readFileContent(File file) {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        byte[] bArr;
        String str = null;
        try {
            int length = (int) file.length();
            byteArrayOutputStream = new ByteArrayOutputStream(length);
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    try {
                        bArr = new byte[12288];
                    } catch (Throwable th5) {
                        th = th5;
                        try {
                            if (SLog.isEnable()) {
                                SLog.e("FileUtils", "readFileContent", th);
                            }
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e16) {
                                    e = e16;
                                }
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return str;
                        } catch (Throwable th6) {
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e17) {
                                    if (SLog.isEnable()) {
                                        SLog.e("FileUtils", "readFileContent", e17);
                                    }
                                    throw th6;
                                }
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw th6;
                        }
                    }
                } catch (OutOfMemoryError unused) {
                    bArr = new byte[4096];
                }
                int i3 = 0;
                while (i3 < length) {
                    int read = fileInputStream.read(bArr);
                    byteArrayOutputStream.write(bArr, 0, read);
                    i3 += read;
                }
                str = byteArrayOutputStream.toString("utf-8");
                try {
                    byteArrayOutputStream.close();
                    fileInputStream.close();
                } catch (IOException e18) {
                    e = e18;
                }
            } catch (Throwable th7) {
                th = th7;
                fileInputStream = null;
            }
        } catch (Throwable th8) {
            th = th8;
            byteArrayOutputStream = null;
            fileInputStream = null;
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0077 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0097 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap loadBitmapFromNative(String str, boolean z16, Bitmap bitmap) {
        Bitmap bitmap2;
        FileInputStream fileInputStream;
        InputStream inputStream;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        if (bitmap != null) {
            options.inBitmap = bitmap;
        }
        InputStream inputStream2 = null;
        Bitmap bitmap3 = null;
        InputStream inputStream3 = null;
        try {
            try {
                String str2 = File.separator;
                if (!str.startsWith(str2)) {
                    try {
                        inputStream = sContextObj.getResources().getAssets().open("newbone" + str2 + str);
                    } catch (Exception unused) {
                        try {
                            fileInputStream = new FileInputStream(RootBasePath + str);
                        } catch (FileNotFoundException e16) {
                            e16.printStackTrace();
                            inputStream = null;
                            try {
                                bitmap3 = BitmapFactory.decodeStream(inputStream, null, options);
                                if (bitmap3 != null) {
                                }
                                if (inputStream != null) {
                                }
                            } catch (Exception e17) {
                                inputStream2 = inputStream;
                                e = e17;
                                bitmap2 = null;
                                e.printStackTrace();
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (IOException e18) {
                                        e18.printStackTrace();
                                    }
                                }
                                return bitmap2;
                            } catch (Throwable th5) {
                                inputStream3 = inputStream;
                                th = th5;
                                if (inputStream3 != null) {
                                    try {
                                        inputStream3.close();
                                    } catch (IOException e19) {
                                        e19.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                    try {
                        bitmap3 = BitmapFactory.decodeStream(inputStream, null, options);
                    } catch (OutOfMemoryError e26) {
                        e26.printStackTrace();
                    }
                    if (bitmap3 != null && z16) {
                        Matrix matrix = new Matrix();
                        matrix.preScale(1.0f, -1.0f);
                        bitmap3 = Bitmap.createBitmap(bitmap3, 0, 0, bitmap3.getWidth(), bitmap3.getHeight(), matrix, true);
                    }
                    if (inputStream != null) {
                        return bitmap3;
                    }
                    try {
                        inputStream.close();
                        return bitmap3;
                    } catch (IOException e27) {
                        e27.printStackTrace();
                        return bitmap3;
                    }
                }
                try {
                    fileInputStream = new FileInputStream(str);
                    inputStream = fileInputStream;
                } catch (FileNotFoundException e28) {
                    e28.printStackTrace();
                    inputStream = null;
                    bitmap3 = BitmapFactory.decodeStream(inputStream, null, options);
                    if (bitmap3 != null) {
                    }
                    if (inputStream != null) {
                    }
                }
                bitmap3 = BitmapFactory.decodeStream(inputStream, null, options);
                if (bitmap3 != null) {
                    Matrix matrix2 = new Matrix();
                    matrix2.preScale(1.0f, -1.0f);
                    bitmap3 = Bitmap.createBitmap(bitmap3, 0, 0, bitmap3.getWidth(), bitmap3.getHeight(), matrix2, true);
                }
                if (inputStream != null) {
                }
            } catch (Exception e29) {
                e = e29;
                bitmap2 = null;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
