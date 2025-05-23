package com.tencent.qqmini.minigame.utils;

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
/* loaded from: classes23.dex */
public class MD5FileUtil {
    protected static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    protected static MessageDigest messagedigest;

    static {
        messagedigest = null;
        try {
            messagedigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
        } catch (NoSuchAlgorithmException unused) {
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

    public static boolean checkPassword(String str, String str2) {
        return getMD5String(str).equals(str2);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0055 -> B:25:0x0072). Please report as a decompilation issue!!! */
    public static String getFileMD5String(File file) throws IOException {
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
                        messagedigest.update(ByteBuffer.wrap(bArr, 0, (int) read));
                    }
                    fileInputStream.close();
                    byte[] digest = messagedigest.digest();
                    if (digest != null) {
                        str = bufferToHex(digest);
                    }
                    fileInputStream.close();
                } catch (Throwable th6) {
                    th = th6;
                    try {
                        th.printStackTrace();
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
    public static String getFileMd5BigFile(String str) {
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
                String bufferToHex = bufferToHex(messageDigest.digest());
                try {
                    fileInputStream.close();
                } catch (Exception unused) {
                }
                return bufferToHex;
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

    public static String getMD5String(String str) {
        return getMD5String(str.getBytes());
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

    public static String getMD5String(byte[] bArr) {
        messagedigest.update(bArr);
        return bufferToHex(messagedigest.digest());
    }
}
