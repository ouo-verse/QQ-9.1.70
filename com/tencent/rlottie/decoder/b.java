package com.tencent.rlottie.decoder;

import android.content.Context;
import android.util.Log;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<byte[]> f365223a;

    /* renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<byte[]> f365224b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13545);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f365223a = new ThreadLocal<>();
            f365224b = new ThreadLocal<>();
        }
    }

    public static boolean a(String str) {
        boolean z16 = true;
        if (str != null && str.trim().length() != 0) {
            File file = new File(str);
            if (!file.exists()) {
                return true;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                boolean z17 = true;
                for (int i3 = 0; i3 < listFiles.length; i3++) {
                    if (listFiles[i3].isDirectory()) {
                        if (a(listFiles[i3].getAbsolutePath()) && z17) {
                            z17 = true;
                        }
                        z17 = false;
                    } else if (!listFiles[i3].delete()) {
                        Log.e("AXrFileReader", "delete fail, path:" + listFiles[i3].getAbsolutePath());
                        z17 = false;
                    }
                }
                z16 = z17;
            }
            file.delete();
        }
        return z16;
    }

    public static String b(File file) {
        int i3;
        try {
            byte[] bArr = new byte[8192];
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, read);
            }
            byte[] digest = messageDigest.digest();
            StringBuilder sb5 = new StringBuilder(digest.length * 2);
            for (byte b16 : digest) {
                int i16 = b16 & 255;
                if (i16 < 16) {
                    sb5.append("0");
                }
                sb5.append(Integer.toHexString(i16));
            }
            return sb5.toString();
        } catch (UnsupportedEncodingException e16) {
            throw new RuntimeException("UnsupportedEncodingException", e16);
        } catch (IOException e17) {
            e17.printStackTrace();
            return "";
        } catch (NoSuchAlgorithmException e18) {
            throw new RuntimeException("NoSuchAlgorithmException", e18);
        }
    }

    public static String c(Context context, String str) {
        return d("lottie_cache_assets_" + str, context, str, 0);
    }

    private static String d(String str, Context context, @Nullable String str2, int i3) {
        File file = null;
        File h16 = com.tencent.rlottie.a.b(null).h(str);
        if (h16 != null && h16.exists()) {
            try {
                return g(new FileInputStream(h16));
            } catch (FileNotFoundException unused) {
            }
        }
        try {
            if (a.a(str)) {
                file = com.tencent.rlottie.a.b(null).m(str, e(context, str2, i3));
                return g(new FileInputStream(file));
            }
        } catch (Exception unused2) {
            if (file != null && file.exists()) {
                file.delete();
            }
        }
        return f(context, str2, i3);
    }

    private static InputStream e(Context context, @Nullable String str, int i3) {
        InputStream openRawResource;
        try {
            if (str != null) {
                openRawResource = context.getAssets().open(str);
            } else {
                openRawResource = context.getResources().openRawResource(i3);
            }
            return openRawResource;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private static String f(Context context, String str, int i3) {
        return g(e(context, str, i3));
    }

    private static String g(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        ThreadLocal<byte[]> threadLocal = f365223a;
        byte[] bArr = threadLocal.get();
        if (bArr == null) {
            bArr = new byte[65536];
            threadLocal.set(bArr);
        }
        try {
            try {
                ThreadLocal<byte[]> threadLocal2 = f365224b;
                byte[] bArr2 = threadLocal2.get();
                if (bArr2 == null) {
                    bArr2 = new byte[4096];
                    threadLocal2.set(bArr2);
                }
                int i3 = 0;
                while (true) {
                    int read = inputStream.read(bArr2, 0, bArr2.length);
                    if (read >= 0) {
                        int i16 = i3 + read;
                        if (bArr.length < i16) {
                            byte[] bArr3 = new byte[bArr.length * 2];
                            System.arraycopy(bArr, 0, bArr3, 0, i3);
                            f365223a.set(bArr3);
                            bArr = bArr3;
                        }
                        if (read > 0) {
                            System.arraycopy(bArr2, 0, bArr, i3, read);
                            i3 = i16;
                        }
                    } else {
                        try {
                            break;
                        } catch (Throwable unused) {
                        }
                    }
                }
                inputStream.close();
                return new String(bArr, 0, i3);
            } catch (Throwable unused2) {
                return null;
            }
        } catch (Throwable unused3) {
            inputStream.close();
            return null;
        }
    }
}
