package com.tencent.mobileqq.shortvideo.cover;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.image.URLDrawable;
import com.tencent.maxvideo.activity.CoverNative;
import com.tencent.mobileqq.shortvideo.util.b;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes18.dex */
public class RecordThumbnailUtils {
    /* JADX WARN: Removed duplicated region for block: B:66:0x0144 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(int i3, String str, int i16, int i17, String str2, int i18) {
        String str3;
        OutputStream outputStream;
        BufferedOutputStream bufferedOutputStream;
        int i19 = i16 * i17;
        byte[] bArr = new byte[(i19 * 3) / 2];
        int[] iArr = new int[i19];
        if (QLog.isColorLevel()) {
            QLog.d("RecordThumbnailUtils", 2, "getCover, mSourceDir = " + str);
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            String[] list = file.list();
            if (list != null && list.length > 0) {
                int length = list.length;
                int i26 = 0;
                while (true) {
                    if (i26 < length) {
                        String str4 = list[i26];
                        if (str4.endsWith(".vf")) {
                            str3 = str + File.separator + str4;
                            break;
                        }
                        i26++;
                    } else {
                        str3 = null;
                        break;
                    }
                }
                if (str3 == null) {
                    QLog.w("RecordThumbnailUtils", 2, "getCover, can not find vf file in the folder, dir = " + str);
                    return null;
                }
                long openFile = CoverNative.openFile(str3);
                if (openFile == 0) {
                    QLog.w("RecordThumbnailUtils", 2, "getCover, open vf file failed, vf = " + str3);
                    return null;
                }
                String str5 = str3;
                if (!CoverNative.getFrameYuv(openFile, null, i3, bArr, i16, i17)) {
                    QLog.w("RecordThumbnailUtils", 2, "getCover, get YUV data from vf file failed, vf = " + str5);
                    return null;
                }
                CoverNative.closeFile(openFile);
                b.a(iArr, bArr, i16, i17);
                try {
                    Bitmap createBitmap = Bitmap.createBitmap(iArr, i16, i17, Bitmap.Config.RGB_565);
                    if (createBitmap != null) {
                        if (i18 != 0 && !c(i18)) {
                            createBitmap = d(createBitmap, i18);
                        }
                        try {
                            try {
                                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(str2)));
                                if (createBitmap != null) {
                                    try {
                                        createBitmap.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream);
                                        bufferedOutputStream.flush();
                                    } catch (IOException e16) {
                                        e = e16;
                                        QLog.e("RecordThumbnailUtils", 2, "getCover, compress bitmap failed, outPath = " + str2 + ", exception = " + e);
                                        if (bufferedOutputStream != null) {
                                            try {
                                                bufferedOutputStream.close();
                                                return null;
                                            } catch (IOException unused) {
                                                return null;
                                            }
                                        }
                                        return null;
                                    }
                                }
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException unused2) {
                                }
                            } catch (IOException e17) {
                                e = e17;
                                bufferedOutputStream = null;
                            } catch (Throwable th5) {
                                th = th5;
                                outputStream = null;
                                if (outputStream != null) {
                                }
                                throw th;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            outputStream = null;
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException unused3) {
                                }
                            }
                            throw th;
                        }
                    } else {
                        QLog.w("RecordThumbnailUtils", 2, "getCover, createBitmap bitmap by YUV data failed, get empty bitmap, vf = " + str5);
                    }
                    return str2;
                } catch (Throwable unused4) {
                    QLog.w("RecordThumbnailUtils", 2, "getCover, createBitmap bitmap by YUV data failed, vf = " + str5);
                    return null;
                }
            }
            QLog.w("RecordThumbnailUtils", 2, "getCover, found empty folder, dir = " + str);
            return null;
        }
        QLog.w("RecordThumbnailUtils", 2, "getCover, vf folder is not exist or is illegal, dir = " + str);
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(String str, int i3, int i16, String str2, int i17, Bitmap.Config config) {
        int i18;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            Bitmap createBitmap = Bitmap.createBitmap(i3, i16, config);
            try {
                i18 = nativeGenCover(createBitmap, i3, i16);
            } catch (UnsatisfiedLinkError e16) {
                QLog.e("RecordThumbnailUtils", 2, "getNativeCover, createBitmap failed" + e16);
                i18 = -1;
            }
            if (QLog.isColorLevel()) {
                QLog.d("RecordThumbnailUtils", 2, "getNativeCover, nativeGenCover result = " + i18 + ",mSelectBitmap = " + createBitmap);
            }
            if (i18 != 0) {
                return a(0, str, i3, i16, str2, i17);
            }
            if (createBitmap != null) {
                if (i17 != 0 && !c(i17)) {
                    createBitmap = d(createBitmap, i17);
                }
                try {
                    try {
                        try {
                            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(new File(str2)));
                            if (createBitmap != null) {
                                try {
                                    createBitmap.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream2);
                                    bufferedOutputStream2.flush();
                                } catch (IOException e17) {
                                    e = e17;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    QLog.w("RecordThumbnailUtils", 2, "getNativeCover, compress bitmap failed, exception = " + e);
                                    if (bufferedOutputStream != null) {
                                        bufferedOutputStream.close();
                                    }
                                    if (QLog.isColorLevel()) {
                                    }
                                    return str2;
                                } catch (Throwable th5) {
                                    th = th5;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    if (bufferedOutputStream != null) {
                                        try {
                                            bufferedOutputStream.close();
                                        } catch (IOException unused) {
                                        }
                                    }
                                    throw th;
                                }
                            }
                            bufferedOutputStream2.close();
                        } catch (IOException e18) {
                            e = e18;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (IOException unused2) {
                }
            } else {
                QLog.w("RecordThumbnailUtils", 2, "getNativeCover, nativeGenCover ok,but mSelectBitmap is null ");
            }
            if (QLog.isColorLevel()) {
                QLog.d("RecordThumbnailUtils", 2, "getNativeCover, outPath = " + str2 + ",isExist = " + FileUtils.fileExistsAndNotEmpty(str2));
            }
            return str2;
        } catch (OutOfMemoryError unused3) {
            QLog.e("RecordThumbnailUtils", 2, "getNativeCover, OutOfMemoryError");
            URLDrawable.clearMemoryCache();
            System.gc();
            return null;
        } catch (Throwable unused4) {
            QLog.e("RecordThumbnailUtils", 2, "getNativeCover, createBitmap failed");
            return null;
        }
    }

    public static boolean c(int i3) {
        if (i3 == 180) {
            return true;
        }
        return false;
    }

    public static Bitmap d(Bitmap bitmap, int i3) {
        Matrix matrix = new Matrix();
        matrix.setRotate(i3, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
        try {
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private static native int nativeGenCover(Bitmap bitmap, int i3, int i16);
}
