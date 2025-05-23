package com.tencent.image;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.ByteArrayInputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes7.dex */
public class MD5Util {
    static IPatchRedirector $redirector_;
    protected static char[] hexDigits;
    protected static MessageDigest messagedigest;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9818);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        messagedigest = null;
        try {
            messagedigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
        } catch (NoSuchAlgorithmException unused) {
        }
    }

    public MD5Util() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void appendHexPair(byte b16, StringBuffer stringBuffer) {
        char[] cArr = hexDigits;
        char c16 = cArr[(b16 & 240) >> 4];
        char c17 = cArr[b16 & RegisterType.DOUBLE_HI];
        stringBuffer.append(c16);
        stringBuffer.append(c17);
    }

    public static String bufferToHex(byte[] bArr) {
        return bufferToHex(bArr, 0, bArr.length);
    }

    public static byte[] byteArrayToMd5(String str) {
        if (str != null && str.length() != 0) {
            messagedigest.update(str.getBytes());
            return messagedigest.digest();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0033 A[Catch: IOException -> 0x0044, TRY_ENTER, TRY_LEAVE, TryCatch #0 {IOException -> 0x0044, blocks: (B:11:0x0033, B:29:0x0040, B:4:0x0004, B:6:0x0008, B:9:0x002b, B:17:0x0011, B:19:0x0015, B:20:0x001d, B:22:0x0021), top: B:3:0x0004, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b A[Catch: all -> 0x0038, FileNotFoundException -> 0x003a, TRY_LEAVE, TryCatch #3 {FileNotFoundException -> 0x003a, blocks: (B:4:0x0004, B:6:0x0008, B:9:0x002b, B:17:0x0011, B:19:0x0015, B:20:0x001d, B:22:0x0021), top: B:3:0x0004, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getMd5(Object obj) {
        InputStream byteArrayInputStream;
        String str;
        InputStream inputStream = null;
        try {
            try {
                try {
                    if (obj instanceof String) {
                        byteArrayInputStream = new FileInputStream((String) obj);
                    } else if (obj instanceof FileDescriptor) {
                        byteArrayInputStream = new FileInputStream((FileDescriptor) obj);
                    } else {
                        if (obj instanceof byte[]) {
                            byteArrayInputStream = new ByteArrayInputStream((byte[]) obj);
                        }
                        if (inputStream != null) {
                            str = "";
                        } else {
                            str = getStreamMD5String(inputStream);
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        return str;
                    }
                    inputStream = byteArrayInputStream;
                    if (inputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                    return str;
                } catch (FileNotFoundException e16) {
                    e16.printStackTrace();
                    if (inputStream == null) {
                        return "";
                    }
                    inputStream.close();
                    return "";
                }
            } catch (IOException e17) {
                e17.printStackTrace();
                return "";
            }
        } catch (Throwable th5) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e18) {
                    e18.printStackTrace();
                }
            }
            throw th5;
        }
    }

    public static String getStreamMD5String(InputStream inputStream) {
        String str = null;
        if (inputStream != null) {
            try {
                try {
                    long available = inputStream.available();
                    byte[] bArr = new byte[4096];
                    while (available > 0) {
                        long read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        if (read > available) {
                            read = available;
                        }
                        available -= read;
                        messagedigest.update(ByteBuffer.wrap(bArr, 0, (int) read));
                    }
                    inputStream.close();
                    byte[] digest = messagedigest.digest();
                    if (digest != null) {
                        str = bufferToHex(digest);
                    }
                    inputStream.close();
                } catch (Throwable th5) {
                    try {
                        th5.printStackTrace();
                        inputStream.close();
                    } catch (Throwable th6) {
                        try {
                            inputStream.close();
                        } catch (IOException e16) {
                            e16.printStackTrace();
                        }
                        throw th6;
                    }
                }
            } catch (IOException e17) {
                e17.printStackTrace();
            }
        }
        return str;
    }

    private static String bufferToHex(byte[] bArr, int i3, int i16) {
        StringBuffer stringBuffer = new StringBuffer(i16 * 2);
        int i17 = i16 + i3;
        while (i3 < i17) {
            appendHexPair(bArr[i3], stringBuffer);
            i3++;
        }
        return stringBuffer.toString();
    }
}
