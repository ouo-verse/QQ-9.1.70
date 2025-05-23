package com.tencent.ams.xsad.rewarded.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;

/* compiled from: P */
/* loaded from: classes3.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Throwable, java.io.IOException] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0014 -> B:9:0x003f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap a(Context context, String str) {
        Throwable th5;
        InputStream inputStream;
        Bitmap bitmap = null;
        bitmap = null;
        bitmap = null;
        ?? r06 = null;
        try {
        } catch (IOException e16) {
            e16.printStackTrace();
            context = e16;
        }
        try {
            try {
                inputStream = context.getAssets().open(str);
            } catch (Exception e17) {
                e = e17;
                inputStream = null;
            } catch (Throwable th6) {
                th5 = th6;
                if (r06 != null) {
                }
                throw th5;
            }
            try {
                bitmap = BitmapFactory.decodeStream(inputStream);
                context = inputStream;
                if (inputStream != null) {
                    inputStream.close();
                    context = inputStream;
                }
            } catch (Exception e18) {
                e = e18;
                c.e("RewardedAdUtils", "bitmapFromAssets error." + e.toString());
                context = inputStream;
                if (inputStream != null) {
                    inputStream.close();
                    context = inputStream;
                }
                return bitmap;
            }
            return bitmap;
        } catch (Throwable th7) {
            th5 = th7;
            r06 = context;
            if (r06 != null) {
                try {
                    r06.close();
                } catch (IOException e19) {
                    e19.printStackTrace();
                }
            }
            throw th5;
        }
    }

    public static int b(Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static Activity c(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        return c(((ContextWrapper) context).getBaseContext());
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0049: MOVE (r1 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:74), block:B:30:0x0049 */
    /* JADX WARN: Removed duplicated region for block: B:33:0x004c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String d(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileInputStream fileInputStream3 = null;
        if (!file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[4096];
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                fileInputStream = new FileInputStream(file);
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr, 0, 4096);
                        if (read != -1) {
                            messageDigest.update(bArr, 0, read);
                        } else {
                            try {
                                break;
                            } catch (IOException unused) {
                            }
                        }
                    } catch (Exception e16) {
                        e = e16;
                        c.b("RewardedAdUtils", "getFileMD5 failed! ", e);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        return null;
                    }
                }
                fileInputStream.close();
                return f(messageDigest.digest(), "");
            } catch (Exception e17) {
                e = e17;
                fileInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (fileInputStream3 != null) {
                }
                throw th;
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

    public static boolean e(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                    if (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static String f(byte[] bArr, String str) {
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

    public static String g(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.reset();
            messageDigest.update(str.getBytes());
            return f(messageDigest.digest(), "");
        } catch (Exception e16) {
            c.b("RewardedAdUtils", "Md5 encode failed! ", e16);
            return "";
        }
    }
}
