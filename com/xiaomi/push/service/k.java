package com.xiaomi.push.service;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f389734a = {"com.mi.globalbrowser", "com.android.browser"};

    /* renamed from: b, reason: collision with root package name */
    private static String f389735b = null;

    /* renamed from: c, reason: collision with root package name */
    public static final b<String, String, String> f389736c;

    /* renamed from: d, reason: collision with root package name */
    public static final b<String, String, String> f389737d;

    /* renamed from: e, reason: collision with root package name */
    public static final b<String, String, String> f389738e;

    /* renamed from: f, reason: collision with root package name */
    public static final b<String, String, String> f389739f;

    /* renamed from: g, reason: collision with root package name */
    public static final b<String, String, String> f389740g;

    /* renamed from: h, reason: collision with root package name */
    public static final b<String, String, String> f389741h;

    /* renamed from: i, reason: collision with root package name */
    public static final b<String, String, String> f389742i;

    /* renamed from: j, reason: collision with root package name */
    public static final b<String, String, String> f389743j;

    /* renamed from: k, reason: collision with root package name */
    static Boolean f389744k;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class b<F, S, T> {

        /* renamed from: a, reason: collision with root package name */
        F f389745a;

        /* renamed from: b, reason: collision with root package name */
        S f389746b;

        /* renamed from: c, reason: collision with root package name */
        T f389747c;

        b(F f16, S s16, T t16) {
            this.f389745a = f16;
            this.f389746b = s16;
            this.f389747c = t16;
        }
    }

    static {
        String str = "getNotificationSettings";
        f389736c = new b<>(str, str, str);
        String str2 = "canSound";
        f389737d = new b<>("setSound", str2, str2);
        String str3 = "canVibrate";
        f389738e = new b<>("setVibrate", str3, str3);
        String str4 = "canLights";
        f389739f = new b<>("setLights", str4, str4);
        String str5 = "canShowOnKeyguard";
        f389740g = new b<>("setShowOnKeyguard", str5, str5);
        f389741h = new b<>(QZoneJsConstants.QZonePersonalizeJsConstants.FLOAT_METHOD_SETFLOAT, "canFloat", "canShowFloat");
        String str6 = "canShowBadge";
        f389742i = new b<>("setShowBadge", str6, str6);
        String str7 = "canShowOngoing";
        f389743j = new b<>("setShowOngoing", str7, str7);
    }

    public static int a(ContentResolver contentResolver) {
        try {
            return Settings.Global.getInt(contentResolver, "user_aggregate", 0);
        } catch (Exception e16) {
            jz4.c.m("get user aggregate failed, " + e16);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(Context context, String str) {
        return com.xiaomi.push.g.m(context, str);
    }

    public static int c(Context context, String str, String str2, b<String, String, String> bVar) {
        if (bVar != null) {
            try {
                Bundle e16 = e(context, bVar.f389746b, str, str2, null);
                if (e16 == null || !e16.containsKey(bVar.f389747c)) {
                    return -1;
                }
                return e16.getBoolean(bVar.f389747c) ? 1 : 0;
            } catch (Exception unused) {
                return -1;
            }
        }
        return -1;
    }

    public static Bundle d(Context context, String str, String str2) {
        try {
            return e(context, f389736c.f389746b, str, str2, null);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Bundle e(Context context, String str, String str2, String str3, Bundle bundle) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("package", str2);
            if (!TextUtils.isEmpty(str3)) {
                bundle2.putString("channel_id", str3);
            }
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            return context.getContentResolver().call(Uri.parse("content://statusbar.notification"), str, (String) null, bundle2);
        }
        throw new IllegalArgumentException("call notification provider failed!");
    }

    public static <T> T f(Notification notification, String str) {
        Bundle bundle = notification.extras;
        if (bundle != null) {
            try {
                return (T) bundle.get(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> T g(Object obj, String str, T t16) {
        T t17;
        T t18 = null;
        try {
        } catch (Exception e16) {
            jz4.c.m("get value error " + e16);
        }
        if (obj instanceof Notification) {
            t17 = f((Notification) obj, str);
        } else if (obj instanceof Map) {
            t17 = ((Map) obj).get(str);
        } else if (obj instanceof Bundle) {
            t17 = ((Bundle) obj).get(str);
        } else {
            jz4.c.m("not support get value from classType:" + obj);
            if (t18 == null) {
                return t18;
            }
            return t16;
        }
        t18 = t17;
        if (t18 == null) {
        }
    }

    public static String h(Notification notification) {
        CharSequence charSequence;
        Bundle bundle = notification.extras;
        if (bundle != null) {
            charSequence = bundle.getCharSequence(NotificationCompat.EXTRA_TITLE);
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence(NotificationCompat.EXTRA_TITLE_BIG);
            }
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("mipush.customTitle");
            }
        } else {
            charSequence = null;
        }
        if (charSequence != null) {
            return charSequence.toString();
        }
        return "";
    }

    public static String i(Object obj) {
        return (String) g(obj, "msg_busi_type", "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(Notification notification, int i3) {
        try {
            Bundle bundle = notification.extras;
            if (bundle != null) {
                bundle.putInt("miui.messageCount", i3);
            }
            Object d16 = com.xiaomi.push.y.d(notification, "extraNotification");
            if (d16 != null) {
                com.xiaomi.push.y.e(d16, "setMessageCount", Integer.valueOf(i3));
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void k(Notification notification, int i3, int i16) {
        if (notification != null) {
            if (notification.extras == null) {
                notification.extras = new Bundle();
            }
            notification.extras.putInt("is_priority", i3);
            notification.extras.putInt("mipush_class", i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void l(Notification notification, String str) {
        try {
            Bundle bundle = notification.extras;
            if (bundle != null) {
                bundle.putString(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, str);
            }
            Object d16 = com.xiaomi.push.y.d(notification, "extraNotification");
            if (d16 != null) {
                com.xiaomi.push.y.e(d16, "setTargetPkg", str);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void m(Notification notification, boolean z16) {
        try {
            Bundle bundle = notification.extras;
            if (bundle != null) {
                bundle.putBoolean("miui.enableFloat", z16);
            }
            Object d16 = com.xiaomi.push.y.d(notification, "extraNotification");
            if (d16 != null) {
                com.xiaomi.push.y.e(d16, "setEnableFloat", Boolean.valueOf(z16));
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void n(Context context, String str, Intent intent) {
        if (intent == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(str);
        }
        arrayList.addAll(Arrays.asList(f389734a));
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            String str2 = (String) arrayList.get(i3);
            if (!TextUtils.isEmpty(str2)) {
                Intent intent2 = new Intent(intent);
                intent2.setPackage(str2);
                try {
                    if (context.getPackageManager().resolveActivity(intent2, 65536) != null) {
                        intent.setPackage(str2);
                        break;
                    }
                    continue;
                } catch (Exception e16) {
                    jz4.c.m("can't match url intent. " + e16);
                }
            }
        }
        intent.setPackage(intent.getPackage());
    }

    public static void o(Map<String, String> map, Bundle bundle, String str) {
        if (map != null && bundle != null && !TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(map.get(str))) {
                bundle.remove(str);
                return;
            } else {
                bundle.putString(str, map.get(str));
                return;
            }
        }
        jz4.c.m("cp map to b fail:" + str);
    }

    public static boolean p() {
        if (f389744k == null) {
            if (Build.VERSION.SDK_INT >= 30) {
                Bundle f16 = f.f("com.xiaomi.xmsf", null);
                if (f16 != null && !f16.isEmpty()) {
                    f389744k = Boolean.TRUE;
                } else {
                    f389744k = Boolean.FALSE;
                }
            } else {
                f389744k = Boolean.FALSE;
            }
        }
        return f389744k.booleanValue();
    }

    public static boolean q(Notification.Builder builder, boolean z16) {
        int i3;
        if (Build.VERSION.SDK_INT >= 26) {
            if (z16) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            builder.setGroupAlertBehavior(i3);
            return true;
        }
        jz4.c.w("not support setGroupAlertBehavior");
        return false;
    }

    public static boolean r(ContentResolver contentResolver) {
        int a16 = a(contentResolver);
        if (a16 == 1 || a16 == 2) {
            return true;
        }
        return false;
    }

    public static boolean s(Context context, String str, String str2, b<String, String, String> bVar, boolean z16) {
        if (bVar != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putBoolean(bVar.f389747c, z16);
                e(context, bVar.f389745a, str, str2, bundle);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean t(Map<String, String> map) {
        return Boolean.parseBoolean((String) g(map, "not_suppress", "true"));
    }

    public static Notification.Action[] u(Notification notification) {
        Parcelable[] parcelableArray;
        Notification.Action[] actionArr = notification.actions;
        if (actionArr != null) {
            return actionArr;
        }
        Bundle bundle = notification.extras;
        if (bundle != null && (parcelableArray = bundle.getParcelableArray("mipush.customActions")) != null) {
            return (Notification.Action[]) Arrays.copyOf(parcelableArray, parcelableArray.length, Notification.Action[].class);
        }
        return null;
    }

    public static String v(Notification notification) {
        CharSequence charSequence;
        Bundle bundle = notification.extras;
        if (bundle != null) {
            charSequence = bundle.getCharSequence(NotificationCompat.EXTRA_TEXT);
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence(NotificationCompat.EXTRA_BIG_TEXT);
            }
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("mipush.customContent");
            }
        } else {
            charSequence = null;
        }
        if (charSequence != null) {
            return charSequence.toString();
        }
        return "";
    }

    public static void w(Notification notification, boolean z16) {
        try {
            Bundle bundle = notification.extras;
            if (bundle != null) {
                bundle.putBoolean("miui.enableKeyguard", z16);
            }
            Object d16 = com.xiaomi.push.y.d(notification, "extraNotification");
            if (d16 != null) {
                com.xiaomi.push.y.e(d16, "setEnableKeyguard", Boolean.valueOf(z16));
            }
        } catch (Exception unused) {
        }
    }

    public static String x(Notification notification) {
        Object d16;
        String str = null;
        try {
            Bundle bundle = notification.extras;
            if (bundle != null) {
                str = bundle.getString(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE);
            }
            if (TextUtils.isEmpty(str) && (d16 = com.xiaomi.push.y.d(notification, "extraNotification")) != null) {
                return (String) com.xiaomi.push.y.e(d16, "getTargetPkg", new Object[0]);
            }
            return str;
        } catch (Exception unused) {
            return str;
        }
    }
}
