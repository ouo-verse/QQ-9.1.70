package com.tencent.mobileqq.gallery.picocr;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.qq.taf.jce.HexUtil;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.ocr.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes12.dex */
public class d {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String a(String str) {
        System.currentTimeMillis();
        try {
            return HexUtil.bytes2HexStr(MD5.getFileMd5(str));
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
            return "";
        } catch (UnsatisfiedLinkError unused) {
            File file = new File(str);
            if (!file.exists()) {
                return "";
            }
            try {
                String d16 = com.tencent.qqprotect.singleupdate.a.d(file);
                if (d16 == null) {
                    return "";
                }
                return d16;
            } catch (IOException unused2) {
                return "";
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x009e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(Bitmap bitmap, String str, int[] iArr) {
        FileOutputStream fileOutputStream;
        int[] iArr2 = {60, 40, 20};
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i3 = 0;
        boolean z16 = false;
        while (i3 < 3) {
            z16 = c(bitmap, byteArrayOutputStream, iArr2[i3]);
            if (z16 && byteArrayOutputStream.size() < 6750000) {
                break;
            }
            i3++;
        }
        if (i3 >= 3) {
            z16 = c(bitmap, byteArrayOutputStream, 10);
        }
        FileOutputStream fileOutputStream2 = null;
        if (!z16) {
            if (QLog.isColorLevel()) {
                QLog.e(d.class.getName(), 2, "compressBmpToFixedSize fail!");
            }
            return null;
        }
        iArr[0] = bitmap.getWidth();
        iArr[1] = bitmap.getHeight();
        String g16 = e.g(new File(str).getName(), false);
        try {
            fileOutputStream = new FileOutputStream(new File(g16));
        } catch (Exception unused) {
            fileOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            if (fileOutputStream2 != null) {
            }
            throw th;
        }
        try {
            try {
                fileOutputStream.write(byteArrayOutputStream.toByteArray());
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                return g16;
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e17) {
                        e17.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception unused2) {
            if (QLog.isColorLevel()) {
                QLog.e(d.class.getName(), 2, "compressBmpToFixedSize save fail!");
            }
            if (fileOutputStream == null) {
                return null;
            }
            try {
                fileOutputStream.close();
                return null;
            } catch (Exception e18) {
                e18.printStackTrace();
                return null;
            }
        }
    }

    private static boolean c(Bitmap bitmap, ByteArrayOutputStream byteArrayOutputStream, int i3) {
        try {
            byteArrayOutputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.JPEG, i3, byteArrayOutputStream);
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(d.class.getName(), 2, "doCompress Exception:", e16);
            }
            byteArrayOutputStream.reset();
            return false;
        } catch (OutOfMemoryError e17) {
            if (QLog.isColorLevel()) {
                QLog.e(d.class.getName(), 2, "doCompress OutOfMemoryError:", e17);
            }
            byteArrayOutputStream.reset();
            return false;
        }
    }

    public static Bitmap d(String str, BitmapFactory.Options options, int i3, int i16) {
        Bitmap bitmap;
        try {
            bitmap = SafeBitmapFactory.safeDecode(str, options);
        } catch (OutOfMemoryError unused) {
            if (QLog.isColorLevel()) {
                QLog.i("PicOrcUtils", 2, "retry:" + i3 + ", sampleSize:" + options.inSampleSize);
            }
            bitmap = null;
        }
        if (bitmap == null && i3 < i16) {
            options.inSampleSize *= 2;
            return d(str, options, i3 + 1, i16);
        }
        return bitmap;
    }
}
