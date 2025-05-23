package com.sina.weibo.sdk.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: aq, reason: collision with root package name */
    private static char[] f61251aq = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();

    /* renamed from: ar, reason: collision with root package name */
    private static byte[] f61252ar = new byte[256];

    static {
        for (int i3 = 0; i3 < 256; i3++) {
            f61252ar[i3] = -1;
        }
        for (int i16 = 65; i16 <= 90; i16++) {
            f61252ar[i16] = (byte) (i16 - 65);
        }
        for (int i17 = 97; i17 <= 122; i17++) {
            f61252ar[i17] = (byte) ((i17 + 26) - 97);
        }
        for (int i18 = 48; i18 <= 57; i18++) {
            f61252ar[i18] = (byte) ((i18 + 52) - 48);
        }
        byte[] bArr = f61252ar;
        bArr[43] = 62;
        bArr[47] = 63;
    }

    public static int a(int i3, Context context) {
        return (int) ((i3 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static byte[] b(byte[] bArr) {
        boolean z16;
        int i3;
        byte[] bArr2 = new byte[((bArr.length + 2) / 3) * 4];
        int i16 = 0;
        int i17 = 0;
        while (i16 < bArr.length) {
            int i18 = (bArr[i16] & 255) << 8;
            int i19 = i16 + 1;
            boolean z17 = true;
            if (i19 < bArr.length) {
                i18 |= bArr[i19] & 255;
                z16 = true;
            } else {
                z16 = false;
            }
            int i26 = i18 << 8;
            int i27 = i16 + 2;
            if (i27 < bArr.length) {
                i26 |= bArr[i27] & 255;
            } else {
                z17 = false;
            }
            int i28 = i17 + 3;
            char[] cArr = f61251aq;
            int i29 = 64;
            if (z17) {
                i3 = i26 & 63;
            } else {
                i3 = 64;
            }
            bArr2[i28] = (byte) cArr[i3];
            int i36 = i26 >> 6;
            int i37 = i17 + 2;
            if (z16) {
                i29 = i36 & 63;
            }
            bArr2[i37] = (byte) cArr[i29];
            int i38 = i36 >> 6;
            bArr2[i17 + 1] = (byte) cArr[i38 & 63];
            bArr2[i17 + 0] = (byte) cArr[(i38 >> 6) & 63];
            i16 += 3;
            i17 += 4;
        }
        return bArr2;
    }

    public static String e(Context context, String str) {
        Signature[] signatureArr;
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 64);
            if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length > 0) {
                return d.a(signatureArr[0].toByteArray());
            }
            return null;
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
            return null;
        } catch (Exception e17) {
            e17.printStackTrace();
            return null;
        }
    }

    public static String f(Context context, String str) {
        String str2;
        com.sina.weibo.sdk.a.a b16 = com.sina.weibo.sdk.a.a.b();
        if (TextUtils.isEmpty(b16.f61221c)) {
            b16.b(context, str);
            str2 = "";
        } else {
            str2 = b16.f61221c;
        }
        return TextUtils.isEmpty(str2) ? com.sina.weibo.sdk.a.a.b().c(context, str) : str2;
    }

    public static Bundle g(String str) {
        try {
            return h(new URI(str).getQuery());
        } catch (URISyntaxException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private static Bundle h(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
                String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                try {
                    if (split.length == 2) {
                        bundle.putString(URLDecoder.decode(split[0], "UTF-8"), URLDecoder.decode(split[1], "UTF-8"));
                    } else if (split.length == 1) {
                        bundle.putString(URLDecoder.decode(split[0], "UTF-8"), "");
                    }
                } catch (UnsupportedEncodingException e16) {
                    e16.printStackTrace();
                }
            }
        }
        return bundle;
    }

    public static String r() {
        return Build.MANUFACTURER + "-" + DeviceInfoMonitor.getModel() + "_" + Build.VERSION.RELEASE + "_weibosdk_0041005000_android";
    }

    public static Bundle f(String str) {
        try {
            return h(new URL(str).getQuery());
        } catch (MalformedURLException e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
