package com.tencent.biz.qqcircle.utils;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes5.dex */
public class f {
    public static boolean a(String str) {
        if (str == null || !new File(str).exists()) {
            return false;
        }
        return true;
    }

    public static boolean b(byte[] bArr, String str) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str));
                try {
                    fileOutputStream2.write(bArr);
                    fileOutputStream2.flush();
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e16) {
                        RFWLog.e("FileUtils", RFWLog.USR, "[saveByteArrayToFile] fos close error:" + e16);
                    }
                    return true;
                } catch (Exception e17) {
                    e = e17;
                    fileOutputStream = fileOutputStream2;
                    RFWLog.e("FileUtils", RFWLog.USR, "[saveByteArrayToFile] error:" + e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e18) {
                            RFWLog.e("FileUtils", RFWLog.USR, "[saveByteArrayToFile] fos close error:" + e18);
                        }
                    }
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e19) {
                            RFWLog.e("FileUtils", RFWLog.USR, "[saveByteArrayToFile] fos close error:" + e19);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e26) {
            e = e26;
        }
    }
}
