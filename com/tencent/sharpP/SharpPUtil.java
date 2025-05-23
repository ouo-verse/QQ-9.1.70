package com.tencent.sharpP;

import android.graphics.Bitmap;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* loaded from: classes25.dex */
public final class SharpPUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String SHARPP_TAG = "SHARPP";
    public static final String TAG = "SharpPUtil";
    public static final String soLibName = "libSharpPDec.so";

    SharpPUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Bitmap decodeSharpPByFilePath(String str) {
        SharpPDecoder sharpPDecoder = new SharpPDecoder();
        int parseHeader = sharpPDecoder.parseHeader(str);
        if (parseHeader != 0) {
            Log.d(TAG, "status: " + parseHeader);
            return null;
        }
        int sharpPType = sharpPDecoder.getSharpPType();
        if (3 == sharpPType || 4 == sharpPType) {
            return null;
        }
        try {
            return sharpPDecoder.decodeSharpP2PNG2(str, 4, 1000);
        } catch (UnsatisfiedLinkError e16) {
            Log.e(TAG, "sharpP so link error, missing native method.");
            e16.printStackTrace();
            return null;
        }
    }

    public static boolean isSharpPFile(File file) {
        StringBuilder sb5;
        FileInputStream fileInputStream;
        byte[] bArr = new byte[6];
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    fileInputStream.read(bArr);
                } catch (IOException e16) {
                    e = e16;
                    fileInputStream2 = fileInputStream;
                    Log.d(TAG, "isSharpPFile Exception: " + e.getMessage());
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e17) {
                            e = e17;
                            sb5 = new StringBuilder();
                            sb5.append("isSharpPFile close Exception: ");
                            sb5.append(e.getMessage());
                            Log.d(TAG, sb5.toString());
                            String str = new String(bArr);
                            Log.d(TAG, "fileTag: " + str);
                            return str.equals(SHARPP_TAG);
                        }
                    }
                    String str2 = new String(bArr);
                    Log.d(TAG, "fileTag: " + str2);
                    return str2.equals(SHARPP_TAG);
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e18) {
                            Log.d(TAG, "isSharpPFile close Exception: " + e18.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (IOException e19) {
                e = e19;
            }
            try {
                fileInputStream.close();
            } catch (IOException e26) {
                e = e26;
                sb5 = new StringBuilder();
                sb5.append("isSharpPFile close Exception: ");
                sb5.append(e.getMessage());
                Log.d(TAG, sb5.toString());
                String str22 = new String(bArr);
                Log.d(TAG, "fileTag: " + str22);
                return str22.equals(SHARPP_TAG);
            }
            String str222 = new String(bArr);
            Log.d(TAG, "fileTag: " + str222);
            return str222.equals(SHARPP_TAG);
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
