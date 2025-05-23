package com.tencent.hlyyb.downloader.g.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.util.Base64;
import com.tencent.assistant.sdk.remote.SDKConst;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: P */
/* loaded from: classes7.dex */
public class g {
    public static int a(Context context) {
        PackageInfo packageInfo;
        if (context == null) {
            return 0;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, SDKConst.SELF_PACKAGENAME, 0)) == null) {
                return 0;
            }
            return packageInfo.versionCode;
        } catch (Throwable unused) {
        }
        return 0;
    }

    public static String b(String str) {
        return new String(Base64.decode(str, 0));
    }

    public static String c(String str, int i3) {
        String str2 = "";
        for (int i16 = 0; i16 < str.length(); i16++) {
            char charAt = str.charAt(i16);
            if (charAt >= 'a' && charAt <= 'z') {
                charAt = (char) (charAt + (i3 % 26));
                if (charAt < 'a') {
                    charAt = (char) (charAt + 26);
                }
                if (charAt <= 'z') {
                    str2 = str2 + charAt;
                }
                charAt = (char) (charAt - 26);
                str2 = str2 + charAt;
            } else {
                if (charAt >= 'A' && charAt <= 'Z') {
                    charAt = (char) (charAt + (i3 % 26));
                    if (charAt < 'A') {
                        charAt = (char) (charAt + 26);
                    }
                    if (charAt <= 'Z') {
                    }
                    charAt = (char) (charAt - 26);
                }
                str2 = str2 + charAt;
            }
        }
        return str2;
    }

    public static String d(byte[] bArr) {
        String str = "";
        if (bArr == null) {
            return "";
        }
        for (byte b16 : bArr) {
            str = str + Integer.toString((b16 & 255) + 256, 16).substring(1);
        }
        return str.toUpperCase();
    }

    public static boolean e(Context context, boolean z16) {
        try {
            return ((AudioManager) context.getSystemService("audio")).isMusicActive();
        } catch (Throwable unused) {
            return z16;
        }
    }

    public static String f(String str) {
        return Base64.encodeToString(str.getBytes(), 0);
    }

    public static String g(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.reset();
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            for (byte b16 : digest) {
                String hexString = Integer.toHexString(b16 & 255);
                if (hexString.length() == 1) {
                    sb5.append("0");
                }
                sb5.append(hexString);
            }
        } catch (NoSuchAlgorithmException e16) {
            e16.printStackTrace();
        }
        return sb5.toString();
    }

    public static void h(Context context, boolean z16) {
        SharedPreferences sharedPreferences;
        if (context != null && (sharedPreferences = context.getSharedPreferences("TMAssistantSDKSharedPreference", 4)) != null) {
            sharedPreferences.edit().putBoolean("autoDeleteEnabled", z16).commit();
        }
    }

    public static String i(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Exception unused) {
            fileInputStream = null;
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            byte[] bArr = new byte[1024];
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            int i3 = 0;
            while (i3 != -1) {
                i3 = fileInputStream.read(bArr);
                if (i3 > 0) {
                    messageDigest.update(bArr, 0, i3);
                }
            }
            String d16 = d(messageDigest.digest());
            try {
                fileInputStream.close();
            } catch (Exception unused2) {
            }
            return d16;
        } catch (Exception unused3) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception unused4) {
                }
            }
            return null;
        } catch (Throwable th6) {
            th = th6;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception unused5) {
                }
            }
            throw th;
        }
    }
}
