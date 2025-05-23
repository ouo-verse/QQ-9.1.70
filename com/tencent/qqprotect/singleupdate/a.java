package com.tencent.qqprotect.singleupdate;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static char[] f363547a;

    /* renamed from: b, reason: collision with root package name */
    protected static MessageDigest f363548b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42307);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f363547a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        f363548b = null;
        try {
            f363548b = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
        } catch (NoSuchAlgorithmException unused) {
        }
    }

    private static void a(byte b16, StringBuffer stringBuffer) {
        char[] cArr = f363547a;
        char c16 = cArr[(b16 & 240) >> 4];
        char c17 = cArr[b16 & RegisterType.DOUBLE_HI];
        stringBuffer.append(c16);
        stringBuffer.append(c17);
    }

    public static String b(byte[] bArr) {
        return c(bArr, 0, bArr.length);
    }

    private static String c(byte[] bArr, int i3, int i16) {
        StringBuffer stringBuffer = new StringBuffer(i16 * 2);
        int i17 = i16 + i3;
        while (i3 < i17) {
            a(bArr[i3], stringBuffer);
            i3++;
        }
        return stringBuffer.toString();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0055 -> B:25:0x0088). Please report as a decompilation issue!!! */
    public static String d(File file) throws IOException {
        FileInputStream fileInputStream;
        String str = null;
        if (file != null && file.exists()) {
            try {
            } catch (IOException e16) {
                e16.printStackTrace();
            }
            if (file.length() > 0) {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = null;
                }
                try {
                    long length = file.length();
                    byte[] bArr = new byte[4096];
                    while (length > 0) {
                        long read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        if (read > length) {
                            read = length;
                        }
                        length -= read;
                        f363548b.update(ByteBuffer.wrap(bArr, 0, (int) read));
                    }
                    fileInputStream.close();
                    byte[] digest = f363548b.digest();
                    if (digest != null) {
                        str = b(digest);
                    }
                    fileInputStream.close();
                } catch (Throwable th6) {
                    th = th6;
                    try {
                        QLog.w("MD5FileUtil", 1, "getFileMD5String, EXCEPTION: " + th);
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return str;
                    } catch (Throwable th7) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e17) {
                                e17.printStackTrace();
                            }
                        }
                        throw th7;
                    }
                }
            }
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0073, code lost:
    
        if (r2 == null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0058, code lost:
    
        if (r2 == null) goto L48;
     */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0078: IF  (r2 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:51:0x007d (LINE:121), block:B:50:0x0078 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String e(String str) {
        FileInputStream fileInputStream;
        InputStream inputStream;
        MessageDigest messageDigest;
        int read;
        try {
            try {
                messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                fileInputStream = new FileInputStream(str);
            } catch (FileNotFoundException e16) {
                e = e16;
                fileInputStream = null;
            } catch (IOException e17) {
                e = e17;
                fileInputStream = null;
            } catch (NoSuchAlgorithmException e18) {
                e = e18;
                fileInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = null;
            }
            try {
                long length = new File(str).length();
                if (length > 10002432) {
                    length = 10002432;
                }
                byte[] bArr = new byte[4096];
                while (length > 0 && (read = fileInputStream.read(bArr)) != -1) {
                    if (read > length) {
                        read = (int) length;
                    }
                    length -= read;
                    messageDigest.update(bArr, 0, read);
                }
                fileInputStream.close();
                String b16 = b(messageDigest.digest());
                try {
                    fileInputStream.close();
                } catch (Exception unused) {
                }
                return b16;
            } catch (FileNotFoundException e19) {
                e = e19;
                e.printStackTrace();
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused2) {
                        return null;
                    }
                }
                return null;
            } catch (IOException e26) {
                e = e26;
                e.printStackTrace();
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return null;
            } catch (NoSuchAlgorithmException e27) {
                e = e27;
                e.printStackTrace();
            } catch (Throwable th6) {
                th = th6;
                th.printStackTrace();
            }
        } catch (Throwable th7) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused3) {
                }
            }
            throw th7;
        }
    }
}
