package com.tencent.qphone.base.util;

import android.os.SystemClock;
import com.tencent.mobileqq.text.EmotcationConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MD5 {
    static final char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};
    private static final String TAG = "MD5";
    public static boolean isLoaded = false;
    public static int soLoadResultCode;
    private byte[] buffer = new byte[64];
    private byte[] digest = new byte[16];
    public String digestHexStr;

    static {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int msfLoadSo = StringUtils.msfLoadSo("MD5", StringUtils.MSF_LIB_BOOTV2);
        soLoadResultCode = msfLoadSo;
        isLoaded = StringUtils.getLoadResult(msfLoadSo);
        QLog.e("MD5", 1, "loadso msfbootV2 " + isLoaded + " resultCode=" + soLoadResultCode + " cost=" + (SystemClock.elapsedRealtime() - elapsedRealtime));
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r2 = r2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long b2iu(byte b16) {
        byte b17;
        if (b16 < 0) {
            b17 = b16 & 255;
        }
        return b17;
    }

    public static String byteHEX(byte b16) {
        char[] cArr = Digit;
        return new String(new char[]{cArr[(b16 >>> 4) & 15], cArr[b16 & RegisterType.DOUBLE_HI]});
    }

    public static byte[] getFileMd5(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            File file = new File(str);
            if (!file.exists()) {
                return null;
            }
            return getPartfileMd5(str, file.length());
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x004c -> B:19:0x004f). Please report as a decompilation issue!!! */
    public static byte[] getPartfileMd5(String str, long j3) {
        FileInputStream fileInputStream;
        File file;
        byte[] bArr = null;
        bArr = null;
        bArr = null;
        FileInputStream fileInputStream2 = null;
        if (str != null && str.length() != 0) {
            try {
                try {
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
                if (j3 >= 0) {
                    try {
                        fileInputStream = new FileInputStream(str);
                    } catch (Exception e17) {
                        e = e17;
                        fileInputStream = null;
                    } catch (Throwable th5) {
                        th = th5;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e18) {
                                e18.printStackTrace();
                            }
                        }
                        throw th;
                    }
                    try {
                        file = new File(str);
                    } catch (Exception e19) {
                        e = e19;
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return bArr;
                    }
                    if (file.exists()) {
                        long length = file.length();
                        if (j3 == 0 || length < j3) {
                            j3 = length;
                        }
                        bArr = toMD5Byte(fileInputStream, j3);
                        fileInputStream.close();
                        return bArr;
                    }
                    try {
                        fileInputStream.close();
                    } catch (IOException e26) {
                        e26.printStackTrace();
                    }
                    return null;
                }
            } catch (Throwable th6) {
                th = th6;
                fileInputStream2 = fileInputStream;
            }
        }
        return null;
    }

    public static byte[] sysGetBufferMd5(byte[] bArr, int i3, int i16) {
        if (bArr != null && i16 != 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bArr, i3, i16);
                return messageDigest.digest();
            } catch (NoSuchAlgorithmException e16) {
                e16.printStackTrace();
            }
        }
        return null;
    }

    public static byte[] sysGetStremMd5(InputStream inputStream, long j3) {
        if (inputStream != null) {
            long j16 = 0;
            if (j3 != 0) {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    byte[] bArr = new byte[16384];
                    int i3 = 16384;
                    while (j16 < j3) {
                        if (16384 + j16 > j3) {
                            i3 = (int) (j3 - j16);
                        }
                        i3 = inputStream.read(bArr, 0, i3);
                        if (i3 < 0) {
                            return null;
                        }
                        messageDigest.update(bArr, 0, i3);
                        j16 += i3;
                    }
                    try {
                        inputStream.close();
                    } catch (Exception unused) {
                    }
                    return messageDigest.digest();
                } catch (IOException e16) {
                    e16.printStackTrace();
                    return null;
                } catch (NoSuchAlgorithmException e17) {
                    e17.printStackTrace();
                }
            }
        }
        return null;
    }

    public static String toMD5(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        byte[] md5 = new MD5().getMD5(bArr, 0, bArr.length);
        StringBuilder sb5 = new StringBuilder(32);
        for (int i3 = 0; i3 < 16; i3++) {
            char[] cArr = Digit;
            sb5.append(cArr[(md5[i3] >>> 4) & 15]);
            sb5.append(cArr[md5[i3] & RegisterType.DOUBLE_HI]);
        }
        return sb5.toString();
    }

    public static byte[] toMD5Byte(byte[] bArr) {
        return toMD5Byte(bArr, 0, bArr.length);
    }

    native byte[] getBufferMd5(byte[] bArr);

    public byte[] getMD5(byte[] bArr, int i3, int i16) {
        if (bArr == null || i16 == 0 || i3 < 0) {
            return null;
        }
        byte[] sysGetBufferMd5 = sysGetBufferMd5(bArr, i3, i16);
        if (sysGetBufferMd5 != null) {
            this.digest = sysGetBufferMd5;
            return sysGetBufferMd5;
        }
        try {
            sysGetBufferMd5 = getBufferMd5(bArr);
        } catch (Exception e16) {
            QLog.d("MD5", 1, "getBufferMd5 Exception", e16);
        } catch (UnsatisfiedLinkError e17) {
            QLog.d("MD5", 1, "getBufferMd5 UnsatisfiedLinkError", e17);
        }
        if (sysGetBufferMd5 != null) {
            this.digest = sysGetBufferMd5;
            return sysGetBufferMd5;
        }
        return this.digest;
    }

    native byte[] getStremMd5(InputStream inputStream, long j3);

    public static byte[] toMD5Byte(byte[] bArr, int i3, int i16) {
        return new MD5().getMD5(bArr, i3, i16);
    }

    public static byte[] toMD5Byte(String str) {
        byte[] bytes;
        if (str == null) {
            return null;
        }
        try {
            bytes = str.getBytes("ISO8859_1");
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        return new MD5().getMD5(bytes, 0, bytes.length);
    }

    public static String toMD5(String str) {
        byte[] bytes;
        if (str == null) {
            return null;
        }
        try {
            bytes = str.getBytes("ISO8859_1");
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        byte[] md5 = new MD5().getMD5(bytes, 0, bytes.length);
        StringBuilder sb5 = new StringBuilder(32);
        if (md5 == null) {
            return "";
        }
        for (int i3 = 0; i3 < 16; i3++) {
            char[] cArr = Digit;
            sb5.append(cArr[(md5[i3] >>> 4) & 15]);
            sb5.append(cArr[md5[i3] & RegisterType.DOUBLE_HI]);
        }
        return sb5.toString();
    }

    public static byte[] toMD5Byte(InputStream inputStream, long j3) {
        return new MD5().getMD5(inputStream, j3);
    }

    public byte[] getMD5(InputStream inputStream, long j3) {
        if (inputStream != null && j3 >= 0) {
            try {
                long available = inputStream.available();
                if (j3 == 0 || (available != 0 && inputStream.available() < j3)) {
                    j3 = inputStream.available();
                }
                if (j3 == 0) {
                    return null;
                }
                byte[] sysGetStremMd5 = sysGetStremMd5(inputStream, j3);
                if (sysGetStremMd5 != null) {
                    this.digest = sysGetStremMd5;
                    return sysGetStremMd5;
                }
                try {
                    sysGetStremMd5 = getStremMd5(inputStream, j3);
                    inputStream.close();
                } catch (Exception e16) {
                    QLog.d("MD5", 1, "getBufferMd5 UnsatisfiedLinkError", e16);
                } catch (UnsatisfiedLinkError e17) {
                    QLog.d("MD5", 1, "getStremMd5 UnsatisfiedLinkError", e17);
                }
                if (sysGetStremMd5 != null) {
                    this.digest = sysGetStremMd5;
                    return sysGetStremMd5;
                }
                return this.digest;
            } catch (Exception e18) {
                e18.printStackTrace();
                try {
                    inputStream.close();
                } catch (IOException e19) {
                    e19.printStackTrace();
                }
            }
        }
        return null;
    }
}
