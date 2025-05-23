package com.tencent.open.base;

import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes22.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static char[] f340975a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};

    public static String a(byte[] bArr) {
        if (bArr != null && bArr.length == 16) {
            char[] cArr = new char[32];
            int i3 = 0;
            for (int i16 = 0; i16 < 16; i16++) {
                byte b16 = bArr[i16];
                int i17 = i3 + 1;
                char[] cArr2 = f340975a;
                cArr[i3] = cArr2[(b16 >>> 4) & 15];
                i3 = i17 + 1;
                cArr[i17] = cArr2[b16 & RegisterType.DOUBLE_HI];
            }
            return new String(cArr);
        }
        return "";
    }

    public static String b(File file) {
        if (file != null && file.exists() && file.length() > 0) {
            BufferedInputStream bufferedInputStream = null;
            try {
                try {
                    try {
                        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                        try {
                            String c16 = c(bufferedInputStream2);
                            try {
                                bufferedInputStream2.close();
                                return c16;
                            } catch (IOException e16) {
                                e16.printStackTrace();
                                return c16;
                            }
                        } catch (FileNotFoundException e17) {
                            e = e17;
                            bufferedInputStream = bufferedInputStream2;
                            e.printStackTrace();
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            return "";
                        } catch (OutOfMemoryError unused) {
                            bufferedInputStream = bufferedInputStream2;
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            return "";
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedInputStream = bufferedInputStream2;
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e18) {
                                    e18.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException e19) {
                        e = e19;
                    } catch (OutOfMemoryError unused2) {
                    }
                } catch (IOException e26) {
                    e26.printStackTrace();
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
        return "";
    }

    public static String c(InputStream inputStream) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            byte[] bArr = new byte[com.heytap.mcssdk.a.b.f36117k];
            int i3 = 0;
            while (true) {
                int read = inputStream.read(bArr, 0, com.heytap.mcssdk.a.b.f36117k);
                if (read == -1) {
                    break;
                }
                if (read > 0) {
                    messageDigest.update(bArr, 0, read);
                    i3 += read;
                }
            }
            if (i3 == 0) {
                return "";
            }
            return a(messageDigest.digest());
        } catch (IOException e16) {
            e16.printStackTrace();
            return "";
        } catch (NoSuchAlgorithmException e17) {
            e17.printStackTrace();
            return "";
        }
    }

    public static String d(String str) {
        byte[] e16 = e(str);
        if (e16 == null) {
            return "";
        }
        return a(e16);
    }

    public static byte[] e(String str) {
        try {
            try {
                try {
                    return MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(str.getBytes("UTF-8"));
                } catch (UnsupportedEncodingException e16) {
                    e16.printStackTrace();
                    QLog.e("andygzyu-MD5", 1, "toMD5Byte, source.getBytes crash!");
                    return null;
                }
            } catch (Exception e17) {
                e17.printStackTrace();
                QLog.e("andygzyu-MD5", 1, "toMD5Byte, MessageDigest.getInstance crash!");
                return null;
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    public static byte[] f(byte[] bArr) {
        try {
            return MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(bArr);
        } catch (Exception e16) {
            e16.printStackTrace();
            System.out.println("toMD5Byte, MessageDigest.getInstance crash!");
            return null;
        }
    }
}
