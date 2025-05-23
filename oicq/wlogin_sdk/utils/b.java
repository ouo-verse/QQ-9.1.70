package oicq.wlogin_sdk.utils;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.thumbplayer.libloader.TPFromApkLibraryLoader;
import oicq.wlogin_sdk.listener.PrivacyListener;
import oicq.wlogin_sdk.listener.QimeiListener;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static QimeiListener f423005a;

    /* renamed from: b, reason: collision with root package name */
    public static byte[] f423006b = new byte[0];

    /* renamed from: c, reason: collision with root package name */
    public static byte[] f423007c = new byte[0];

    public static String a(Context context) {
        String str;
        String str2;
        PrivacyListener privacyListener = util.privacyListener;
        if (privacyListener != null) {
            str = privacyListener.getDeviceModel();
            if (!TextUtils.isEmpty(str)) {
                util.LOGI("device model = " + str, "");
                return str;
            }
        } else {
            str = null;
        }
        try {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass(TPFromApkLibraryLoader.ANDROID_OS_SYSTEM_PROPERTIES_CLASS_NAME);
                str2 = (String) loadClass.getMethod("get", String.class).invoke(loadClass, new String("ro.vivo.market.name"));
            } catch (IllegalArgumentException e16) {
                throw e16;
            } catch (Exception unused) {
                str2 = "";
            }
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
        } catch (Exception e17) {
            util.printException(e17);
        }
        util.LOGI("vivo device model = " + str, "");
        return str;
    }

    public static byte[] b(Context context) {
        String a16 = a(context);
        if (TextUtils.isEmpty(a16)) {
            return new byte[0];
        }
        return a16.getBytes();
    }

    public static byte[] c(Context context) {
        byte[] bArr = f423006b;
        if (bArr != null && bArr.length != 0) {
            return bArr;
        }
        QimeiListener qimeiListener = f423005a;
        if (qimeiListener == null) {
            util.LOGI(util.LOG_TAG_QIMEI + "get listener = null", "");
            return new byte[0];
        }
        String qimei = qimeiListener.getQimei(context);
        if (TextUtils.isEmpty(qimei)) {
            util.LOGI(util.LOG_TAG_QIMEI + "get isEmpty", "");
            return new byte[0];
        }
        util.LOGI(util.LOG_TAG_QIMEI + "get length = " + qimei.length(), "");
        byte[] bytes = qimei.getBytes();
        f423006b = bytes;
        return bytes;
    }

    public static byte[] d(Context context) {
        byte[] bArr = f423007c;
        if (bArr != null && bArr.length != 0) {
            return bArr;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager.getSimState() == 5) {
                byte[] bytes = telephonyManager.getSimOperatorName().getBytes();
                f423007c = bytes;
                return bytes;
            }
        } catch (Throwable th5) {
            util.printThrowable(th5, "");
        }
        return new byte[0];
    }
}
