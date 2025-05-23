package oicq.wlogin_sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import java.util.Random;
import oicq.wlogin_sdk.listener.PrivacyListener;
import oicq.wlogin_sdk.persistence.c;
import oicq.wlogin_sdk.persistence.d;
import oicq.wlogin_sdk.report.event.EventConstant;
import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f423003a = "";

    /* renamed from: b, reason: collision with root package name */
    public static byte[] f423004b = new byte[0];

    public static byte[] a(Context context) {
        byte[] bArr = f423004b;
        if (bArr == null || bArr.length == 0) {
            b(context);
        }
        return f423004b;
    }

    public static void b(Context context) {
        String str;
        if (context == null) {
            return;
        }
        PrivacyListener privacyListener = util.privacyListener;
        if (privacyListener != null) {
            str = privacyListener.getAndroidID(context);
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            util.LOGI("AndroidIDUtils get empty android_id from system", "");
            oicq.wlogin_sdk.report.c.b.a(new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_ANDROID_ID_NULL, "", ""));
            c cVar = (c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO");
            str = cVar.f422789b.getString(util.RANDOM_ANDROID_ID, null);
            if (TextUtils.isEmpty(str)) {
                StringBuilder sb5 = new StringBuilder();
                for (int i3 = 0; i3 < 16; i3++) {
                    sb5.append(new Random().nextInt(10));
                }
                str = sb5.toString();
                d dVar = (d) cVar.edit();
                dVar.putString(util.RANDOM_ANDROID_ID, str);
                dVar.f422793b.commit();
            }
        }
        f423003a = str;
        f423004b = MD5.toMD5Byte(str);
    }

    public static void c(Context context) {
        f423003a = "";
        f423004b = new byte[0];
        d dVar = (d) ((c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).edit();
        dVar.putString(util.RANDOM_ANDROID_ID, null);
        dVar.f422793b.commit();
    }
}
