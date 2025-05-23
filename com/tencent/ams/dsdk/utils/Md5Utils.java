package com.tencent.ams.dsdk.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;

/* compiled from: P */
/* loaded from: classes3.dex */
public class Md5Utils {
    static IPatchRedirector $redirector_ = null;
    private static final int BUFFER_LEN = 262144;
    private static final String TAG = "Md5Utils";

    public Md5Utils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String toHexString(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        for (byte b16 : bArr) {
            int i3 = b16 & 255;
            if (i3 < 16) {
                sb5.append("0" + Integer.toHexString(i3));
                sb5.append(str);
            } else {
                sb5.append(Integer.toHexString(i3));
                sb5.append(str);
            }
        }
        return sb5.toString();
    }

    public static String toMd5(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.reset();
            messageDigest.update(str.getBytes());
            return toHexString(messageDigest.digest(), "");
        } catch (Exception e16) {
            DLog.e(TAG, "Md5 encode failed! ", e16);
            return "";
        }
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0071: MOVE (r1 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:47:0x0071 */
    public static String toMd5(File file) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        MessageDigest messageDigest;
        RandomAccessFile randomAccessFile3 = null;
        if (file == null) {
            return null;
        }
        try {
            if (!file.isFile()) {
                DLog.d(TAG, "toMd5, is not file.");
                return null;
            }
            try {
                messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                randomAccessFile2 = new RandomAccessFile(file, "r");
            } catch (Exception e16) {
                e = e16;
                randomAccessFile2 = null;
            } catch (Throwable th5) {
                th = th5;
                if (randomAccessFile3 != null) {
                    try {
                        randomAccessFile3.close();
                    } catch (IOException e17) {
                        DLog.e(TAG, "close error.", e17);
                    }
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[262144];
                while (true) {
                    int read = randomAccessFile2.read(bArr);
                    if (read != -1) {
                        messageDigest.update(bArr, 0, read);
                    } else {
                        try {
                            break;
                        } catch (IOException e18) {
                            DLog.e(TAG, "close error.", e18);
                        }
                    }
                }
                randomAccessFile2.close();
                return toHexString(messageDigest.digest(), "");
            } catch (Exception e19) {
                e = e19;
                DLog.e(TAG, "file to md5 error. file: " + file, e);
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (IOException e26) {
                        DLog.e(TAG, "close error.", e26);
                    }
                }
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            randomAccessFile3 = randomAccessFile;
        }
    }
}
