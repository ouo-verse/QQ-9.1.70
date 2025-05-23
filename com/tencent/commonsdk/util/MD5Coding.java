package com.tencent.commonsdk.util;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: P */
/* loaded from: classes5.dex */
public class MD5Coding {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "MD5Coding";

    public MD5Coding() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static byte[] encode(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String encode2HexStr(byte[] bArr) {
        return HexUtil.bytes2HexStr(encode(bArr));
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x004b, code lost:
    
        if (r4 == null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0038, code lost:
    
        if (r4 == null) goto L36;
     */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0050: MOVE (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:81), block:B:36:0x0050 */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0053 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] encodeFile(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        MessageDigest messageDigest;
        FileInputStream fileInputStream3 = null;
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
                if (fileInputStream3 != null) {
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                byte[] digest = messageDigest.digest();
                try {
                    fileInputStream.close();
                } catch (IOException unused) {
                }
                return digest;
            } catch (FileNotFoundException e19) {
                e = e19;
                Log.e(TAG, "[encodeFile]: ", e);
            } catch (IOException e26) {
                e = e26;
                Log.e(TAG, "[encodeFile]: ", e);
            } catch (NoSuchAlgorithmException e27) {
                e = e27;
                Log.e(TAG, "[encodeFile]: ", e);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused2) {
                        return null;
                    }
                }
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            fileInputStream3 = fileInputStream2;
            if (fileInputStream3 != null) {
                try {
                    fileInputStream3.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    public static String encodeFile2HexStr(String str) {
        return HexUtil.bytes2HexStr(encodeFile(str));
    }

    public static String encodeHexStr(String str) {
        try {
            return HexUtil.bytes2HexStr(encode(str.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
