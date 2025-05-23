package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import com.xiaomi.push.ae;
import com.xiaomi.push.df;
import com.xiaomi.push.dg;
import com.xiaomi.push.dh;
import com.xiaomi.push.di;
import com.xiaomi.push.g;
import com.xiaomi.push.gf;
import com.xiaomi.push.gs;
import com.xiaomi.push.hb;
import com.xiaomi.push.hz;
import com.xiaomi.push.ij;
import com.xiaomi.push.service.h;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    public static long f389835a;

    /* renamed from: b, reason: collision with root package name */
    private static final LinkedList<Pair<Integer, hb>> f389836b = new LinkedList<>();

    /* renamed from: c, reason: collision with root package name */
    private static ExecutorService f389837c = ProxyExecutors.newCachedThreadPool();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a implements Callable<Bitmap> {

        /* renamed from: d, reason: collision with root package name */
        private String f389841d;

        /* renamed from: e, reason: collision with root package name */
        private Context f389842e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f389843f;

        public a(String str, Context context, boolean z16) {
            this.f389842e = context;
            this.f389841d = str;
            this.f389843f = z16;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap call() {
            if (!TextUtils.isEmpty(this.f389841d)) {
                if (this.f389841d.startsWith("http")) {
                    h.c d16 = h.d(this.f389842e, this.f389841d, this.f389843f);
                    if (d16 != null) {
                        return d16.f389726a;
                    }
                    jz4.c.m("Failed get online picture/icon resource");
                    return null;
                }
                Bitmap b16 = h.b(this.f389842e, this.f389841d);
                if (b16 == null) {
                    jz4.c.m("Failed get online picture/icon resource");
                    return b16;
                }
                return b16;
            }
            jz4.c.m("Failed get online picture/icon resource cause picUrl is empty");
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        Notification f389844a;

        /* renamed from: b, reason: collision with root package name */
        long f389845b = 0;
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f389846a;

        /* renamed from: b, reason: collision with root package name */
        public long f389847b = 0;

        /* renamed from: c, reason: collision with root package name */
        public boolean f389848c = false;
    }

    private static void A(Context context, String str, dh dhVar, Map<String, String> map) {
        int b16 = b(context, str, "mipush_small_notification");
        int b17 = b(context, str, "mipush_notification");
        if (hz.j(context)) {
            if (b16 > 0 && b17 > 0) {
                dhVar.setSmallIcon(b16);
                dhVar.setLargeIcon(l(context, b17));
                return;
            } else {
                S(context, str, dhVar, map);
                return;
            }
        }
        if (b16 > 0) {
            dhVar.setSmallIcon(b16);
        } else {
            S(context, str, dhVar, map);
        }
        if (b17 > 0) {
            dhVar.setLargeIcon(l(context, b17));
        }
    }

    public static void B(Context context, String str, String str2, String str3) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            j e16 = j.e(context, str);
            List<StatusBarNotification> y16 = e16.y();
            if (ij.d(y16)) {
                return;
            }
            LinkedList linkedList = new LinkedList();
            for (StatusBarNotification statusBarNotification : y16) {
                Notification notification = statusBarNotification.getNotification();
                if (notification != null && !TextUtils.isEmpty(String.valueOf(statusBarNotification.getId()))) {
                    int id5 = statusBarNotification.getId();
                    String h16 = k.h(notification);
                    String v3 = k.v(notification);
                    if (!TextUtils.isEmpty(h16) && !TextUtils.isEmpty(v3) && K(h16, str2) && K(v3, str3)) {
                        linkedList.add(statusBarNotification);
                        e16.m(id5);
                    }
                }
            }
            C(context, linkedList);
        }
    }

    public static void C(Context context, LinkedList<? extends Object> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            af.d(context, "category_clear_notification", "clear_notification", linkedList.size(), "");
        }
    }

    private static void D(Intent intent) {
        if (intent == null) {
            return;
        }
        intent.setFlags(intent.getFlags() & (-2) & (-3) & (-65) & (-129));
    }

    @TargetApi(16)
    private static void E(dh dhVar, Context context, String str, hb hbVar, byte[] bArr, int i3) {
        PendingIntent h16;
        PendingIntent h17;
        PendingIntent h18;
        PendingIntent h19;
        Map<String, String> m342a = hbVar.m375a().m342a();
        if (!TextUtils.equals("3", m342a.get("notification_style_type")) && !TextUtils.equals("4", m342a.get("notification_style_type"))) {
            if (V(m342a)) {
                for (int i16 = 1; i16 <= 3; i16++) {
                    String str2 = m342a.get(String.format("cust_btn_%s_n", Integer.valueOf(i16)));
                    if (!TextUtils.isEmpty(str2) && (h19 = h(context, str, hbVar, bArr, i3, i16)) != null) {
                        dhVar.addAction(0, str2, h19);
                    }
                }
                return;
            }
            if (!TextUtils.isEmpty(m342a.get("notification_style_button_left_name")) && (h18 = h(context, str, hbVar, bArr, i3, 1)) != null) {
                dhVar.addAction(0, m342a.get("notification_style_button_left_name"), h18);
            }
            if (!TextUtils.isEmpty(m342a.get("notification_style_button_mid_name")) && (h17 = h(context, str, hbVar, bArr, i3, 2)) != null) {
                dhVar.addAction(0, m342a.get("notification_style_button_mid_name"), h17);
            }
            if (!TextUtils.isEmpty(m342a.get("notification_style_button_right_name")) && (h16 = h(context, str, hbVar, bArr, i3, 3)) != null) {
                dhVar.addAction(0, m342a.get("notification_style_button_right_name"), h16);
            }
        }
    }

    private static boolean F(Context context, hb hbVar, String str) {
        if (hbVar != null && hbVar.m375a() != null && hbVar.m375a().m342a() != null && !TextUtils.isEmpty(str)) {
            if (!Boolean.parseBoolean(hbVar.m375a().m342a().get("use_clicked_activity")) || !ap.b(context, i(str))) {
                return false;
            }
            return true;
        }
        jz4.c.m("should clicked activity params are null.");
        return false;
    }

    public static boolean G(Context context, String str) {
        return com.xiaomi.push.g.o(context, str);
    }

    public static boolean H(Context context, String str, boolean z16) {
        if (!hz.i() || z16 || !G(context, str)) {
            return false;
        }
        return true;
    }

    private static boolean I(gs gsVar) {
        if (gsVar == null) {
            return false;
        }
        String m341a = gsVar.m341a();
        if (TextUtils.isEmpty(m341a) || m341a.length() != 22 || "satuigmo".indexOf(m341a.charAt(0)) < 0) {
            return false;
        }
        return true;
    }

    public static boolean J(hb hbVar) {
        gs m375a = hbVar.m375a();
        if (I(m375a) && m375a.l()) {
            return true;
        }
        return false;
    }

    private static boolean K(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !str2.contains(str)) {
            return false;
        }
        return true;
    }

    public static boolean L(Map<String, String> map) {
        if (map != null && map.containsKey("notify_foreground")) {
            return "1".equals(map.get("notify_foreground"));
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0076, code lost:
    
        r1 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0074, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0050, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) == false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String[] M(Context context, gs gsVar) {
        String str;
        String m349c = gsVar.m349c();
        String d16 = gsVar.d();
        Map<String, String> m342a = gsVar.m342a();
        if (m342a != null) {
            int intValue = Float.valueOf((context.getResources().getDisplayMetrics().widthPixels / context.getResources().getDisplayMetrics().density) + 0.5f).intValue();
            if (intValue <= 320) {
                String str2 = m342a.get("title_short");
                if (!TextUtils.isEmpty(str2)) {
                    m349c = str2;
                }
                str = m342a.get("description_short");
            } else if (intValue > 360) {
                String str3 = m342a.get("title_long");
                if (!TextUtils.isEmpty(str3)) {
                    m349c = str3;
                }
                str = m342a.get("description_long");
            }
        }
        return new String[]{m349c, d16};
    }

    private static int N(Map<String, String> map) {
        if (map == null) {
            return 3;
        }
        String str = map.get("channel_importance");
        if (TextUtils.isEmpty(str)) {
            return 3;
        }
        try {
            jz4.c.z("importance=" + str);
            return Integer.parseInt(str);
        } catch (Exception e16) {
            jz4.c.B("parsing channel importance error: " + e16);
            return 3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x015b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Intent O(Context context, String str, Map<String, String> map, int i3) {
        Intent launchIntentForPackage;
        String str2;
        Intent intent;
        Intent intent2;
        if (map == null) {
            return null;
        }
        if (i3 != 0) {
            return j(context, str, map, i3);
        }
        if (!map.containsKey("notify_effect")) {
            return null;
        }
        String str3 = map.get("notify_effect");
        String str4 = map.get("intent_flag");
        int i16 = -1;
        try {
            if (!TextUtils.isEmpty(str4)) {
                i16 = Integer.parseInt(str4);
            }
        } catch (NumberFormatException e16) {
            jz4.c.B("Cause by intent_flag: " + e16.getMessage());
        }
        if (r.f389774a.equals(str3)) {
            try {
                launchIntentForPackage = InstalledAppListMonitor.getLaunchIntentForPackage(context.getPackageManager(), str);
            } catch (Exception e17) {
                jz4.c.B("Cause: " + e17.getMessage());
            }
        } else {
            if (r.f389775b.equals(str3)) {
                if (map.containsKey("intent_uri")) {
                    String str5 = map.get("intent_uri");
                    if (str5 != null) {
                        try {
                            intent2 = Intent.parseUri(str5, 1);
                            try {
                                intent2.setPackage(str);
                            } catch (URISyntaxException e18) {
                                e = e18;
                                jz4.c.B("Cause: " + e.getMessage());
                                launchIntentForPackage = intent2;
                                if (launchIntentForPackage != null) {
                                }
                                return null;
                            }
                        } catch (URISyntaxException e19) {
                            e = e19;
                            intent2 = null;
                        }
                        launchIntentForPackage = intent2;
                    }
                } else if (map.containsKey(PictureConst.KEY_CLASSNAME)) {
                    String str6 = map.get(PictureConst.KEY_CLASSNAME);
                    intent = new Intent();
                    intent.setComponent(new ComponentName(str, str6));
                }
                launchIntentForPackage = null;
            } else {
                if (r.f389776c.equals(str3) && (str2 = map.get("web_uri")) != null) {
                    String trim = str2.trim();
                    if (!trim.startsWith("http://") && !trim.startsWith("https://")) {
                        trim = "http://" + trim;
                    }
                    try {
                        String protocol2 = new URL(trim).getProtocol();
                        if ("http".equals(protocol2) || "https".equals(protocol2)) {
                            intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
                            try {
                                intent.setData(Uri.parse(trim));
                                k.n(context, str, intent);
                            } catch (MalformedURLException e26) {
                                e = e26;
                                jz4.c.B("Cause: " + e.getMessage());
                                launchIntentForPackage = intent;
                                if (launchIntentForPackage != null) {
                                }
                                return null;
                            }
                        }
                    } catch (MalformedURLException e27) {
                        e = e27;
                        intent = null;
                    }
                }
                launchIntentForPackage = null;
            }
            launchIntentForPackage = intent;
        }
        if (launchIntentForPackage != null) {
            if (i16 >= 0) {
                launchIntentForPackage.setFlags(i16);
            }
            D(launchIntentForPackage);
            launchIntentForPackage.addFlags(268435456);
            try {
                if (context.getPackageManager().resolveActivity(launchIntentForPackage, 65536) != null) {
                    return launchIntentForPackage;
                }
                if (Build.VERSION.SDK_INT >= 30 && !hz.j(context) && r.f389776c.equals(str3)) {
                    return launchIntentForPackage;
                }
                jz4.c.m("not resolve activity:" + launchIntentForPackage);
            } catch (Exception e28) {
                jz4.c.B("Cause: " + e28.getMessage());
            }
        }
        return null;
    }

    public static String P(hb hbVar) {
        if (J(hbVar)) {
            return "E100002";
        }
        if (Y(hbVar)) {
            return "E100000";
        }
        if (U(hbVar)) {
            return "E100001";
        }
        if (Z(hbVar)) {
            return "E100003";
        }
        return "";
    }

    public static void Q(Context context, String str) {
        hz.j(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void R(Context context, String str, int i3) {
        context.getSharedPreferences("pref_notify_type", 0).edit().putInt(str, i3).commit();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void S(Context context, String str, dh dhVar, Map<String, String> map) {
        boolean z16;
        int b16;
        if (!hz.j(context)) {
            String v3 = v(map, "fcm_icon_uri");
            String v16 = v(map, "fcm_icon_color");
            if (!TextUtils.isEmpty(v3) && !TextUtils.isEmpty(v16) && (b16 = b(context, str, v3)) > 0) {
                dhVar.setSmallIcon(b16);
                dhVar.f(v16);
                z16 = true;
                if (z16) {
                    dhVar.setSmallIcon(Icon.createWithResource(str, k.b(context, str)));
                    return;
                }
                return;
            }
        }
        z16 = false;
        if (z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean T(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).contains(str);
    }

    public static boolean U(hb hbVar) {
        gs m375a = hbVar.m375a();
        if (I(m375a) && m375a.f389178b == 1 && !J(hbVar)) {
            return true;
        }
        return false;
    }

    private static boolean V(Map<String, String> map) {
        if (map == null) {
            jz4.c.m("meta extra is null");
            return false;
        }
        return "6".equals(map.get("notification_style_type"));
    }

    private static int W(Map<String, String> map) {
        if (map == null) {
            return 0;
        }
        String str = map.get("notification_priority");
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            jz4.c.z("priority=" + str);
            return Integer.parseInt(str);
        } catch (Exception e16) {
            jz4.c.B("parsing notification priority error: " + e16);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void X(Context context, String str) {
        context.getSharedPreferences("pref_notify_type", 0).edit().remove(str).commit();
    }

    public static boolean Y(hb hbVar) {
        gs m375a = hbVar.m375a();
        if (I(m375a) && m375a.f389178b == 0 && !J(hbVar)) {
            return true;
        }
        return false;
    }

    public static boolean Z(hb hbVar) {
        if (hbVar.a() == gf.Registration) {
            return true;
        }
        return false;
    }

    static int a(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).getInt(str, Integer.MAX_VALUE);
    }

    public static boolean a0(hb hbVar) {
        if (!J(hbVar) && !Y(hbVar) && !U(hbVar)) {
            return false;
        }
        return true;
    }

    private static int b(Context context, String str, String str2) {
        if (str.equals(context.getPackageName())) {
            return context.getResources().getIdentifier(str2, "drawable", str);
        }
        return 0;
    }

    private static int c(Context context, String str, Map<String, String> map, int i3) {
        ComponentName a16;
        Intent O = O(context, str, map, i3);
        if (O != null && (a16 = ap.a(context, O)) != null) {
            return a16.hashCode();
        }
        return 0;
    }

    private static int d(Map<String, String> map) {
        String str;
        if (map == null) {
            str = null;
        } else {
            str = map.get("timeout");
        }
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    private static Notification e(Notification notification) {
        Object d16 = com.xiaomi.push.y.d(notification, "extraNotification");
        if (d16 != null) {
            com.xiaomi.push.y.e(d16, "setCustomizedIcon", Boolean.TRUE);
        }
        return notification;
    }

    private static PendingIntent f(Context context, hb hbVar, String str, byte[] bArr, int i3) {
        return g(context, hbVar, str, bArr, i3, 0, F(context, hbVar, str));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static PendingIntent g(Context context, hb hbVar, String str, byte[] bArr, int i3, int i16, boolean z16) {
        int i17;
        String str2;
        Intent intent;
        String protocol2;
        if (Y(hbVar)) {
            i17 = 1000;
        } else if (J(hbVar)) {
            i17 = 3000;
        } else {
            i17 = -1;
        }
        gs m375a = hbVar.m375a();
        if (m375a != null) {
            str2 = m375a.m341a();
        } else {
            str2 = "";
        }
        boolean J = J(hbVar);
        if (m375a != null && !TextUtils.isEmpty(m375a.f389181e)) {
            Intent intent2 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
            intent2.setData(Uri.parse(m375a.f389181e));
            try {
                protocol2 = new URL(m375a.f389181e).getProtocol();
            } catch (MalformedURLException unused) {
                jz4.c.m("meet URL exception : " + m375a.f389181e);
                intent2.setPackage(str);
            }
            if (!"http".equals(protocol2) && !"https".equals(protocol2)) {
                intent2.setPackage(str);
                intent2.addFlags(268435456);
                intent2.putExtra("messageId", str2);
                intent2.putExtra("eventMessageType", i17);
                if (Build.VERSION.SDK_INT < 31) {
                    return PendingIntent.getActivity(context, 0, intent2, 167772160);
                }
                return PendingIntent.getActivity(context, 0, intent2, 134217728);
            }
            k.n(context, str, intent2);
            intent2.addFlags(268435456);
            intent2.putExtra("messageId", str2);
            intent2.putExtra("eventMessageType", i17);
            if (Build.VERSION.SDK_INT < 31) {
            }
        } else {
            if (J) {
                intent = new Intent();
                intent.setComponent(new ComponentName("com.xiaomi.xmsf", "com.xiaomi.mipush.sdk.PushMessageHandler"));
                intent.putExtra("mipush_payload", bArr);
                intent.putExtra("mipush_notified", true);
                intent.addCategory(String.valueOf(i3));
                intent.addCategory(String.valueOf(str2));
            } else {
                intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
                intent.setComponent(new ComponentName(str, "com.xiaomi.mipush.sdk.PushMessageHandler"));
                intent.putExtra("mipush_payload", bArr);
                intent.putExtra("mipush_notified", true);
                intent.addCategory(String.valueOf(i3));
                intent.addCategory(String.valueOf(str2));
            }
            intent.putExtra("notification_click_button", i16);
            intent.putExtra("messageId", str2);
            intent.putExtra("eventMessageType", i17);
            if (!J && z16) {
                Intent intent3 = new Intent();
                intent3.setComponent(i(str));
                intent3.addFlags(276824064);
                intent3.putExtra("mipush_serviceIntent", intent);
                intent3.addCategory(String.valueOf(i3));
                intent3.addCategory(String.valueOf(str2));
                intent3.addCategory(String.valueOf(i16));
                w(context, intent3, hbVar, m375a, str2, i16);
                if (Build.VERSION.SDK_INT >= 31) {
                    return PendingIntent.getActivity(context, 0, intent3, 167772160);
                }
                return PendingIntent.getActivity(context, 0, intent3, 134217728);
            }
            w(context, intent, hbVar, m375a, str2, i16);
            if (Build.VERSION.SDK_INT >= 31) {
                return PendingIntent.getService(context, 0, intent, 167772160);
            }
            return PendingIntent.getService(context, 0, intent, 134217728);
        }
    }

    private static PendingIntent h(Context context, String str, hb hbVar, byte[] bArr, int i3, int i16) {
        Map<String, String> m342a = hbVar.m375a().m342a();
        if (m342a == null) {
            return null;
        }
        boolean F = F(context, hbVar, str);
        if (F) {
            return g(context, hbVar, str, bArr, i3, i16, F);
        }
        Intent j3 = j(context, str, m342a, i16);
        if (j3 == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return PendingIntent.getActivity(context, 0, j3, 167772160);
        }
        return PendingIntent.getActivity(context, 0, j3, 134217728);
    }

    public static ComponentName i(String str) {
        return new ComponentName(str, "com.xiaomi.mipush.sdk.NotificationClickedActivity");
    }

    public static Intent j(Context context, String str, Map<String, String> map, int i3) {
        if (V(map)) {
            return k(context, str, map, String.format("cust_btn_%s_ne", Integer.valueOf(i3)), String.format("cust_btn_%s_iu", Integer.valueOf(i3)), String.format("cust_btn_%s_ic", Integer.valueOf(i3)), String.format("cust_btn_%s_wu", Integer.valueOf(i3)));
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return null;
                    }
                    return k(context, str, map, "notification_colorful_button_notify_effect", "notification_colorful_button_intent_uri", "notification_colorful_button_intent_class", "notification_colorful_button_web_uri");
                }
                return k(context, str, map, "notification_style_button_right_notify_effect", "notification_style_button_right_intent_uri", "notification_style_button_right_intent_class", "notification_style_button_right_web_uri");
            }
            return k(context, str, map, "notification_style_button_mid_notify_effect", "notification_style_button_mid_intent_uri", "notification_style_button_mid_intent_class", "notification_style_button_mid_web_uri");
        }
        return k(context, str, map, "notification_style_button_left_notify_effect", "notification_style_button_left_intent_uri", "notification_style_button_left_intent_class", "notification_style_button_left_web_uri");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Intent k(Context context, String str, Map<String, String> map, String str2, String str3, String str4, String str5) {
        Intent launchIntentForPackage;
        Intent intent;
        Intent intent2;
        String str6 = map.get(str2);
        if (TextUtils.isEmpty(str6)) {
            return null;
        }
        if (r.f389774a.equals(str6)) {
            try {
                launchIntentForPackage = InstalledAppListMonitor.getLaunchIntentForPackage(context.getPackageManager(), str);
            } catch (Exception e16) {
                jz4.c.B("Cause: " + e16.getMessage());
            }
        } else {
            if (r.f389775b.equals(str6)) {
                if (map.containsKey(str3)) {
                    String str7 = map.get(str3);
                    if (str7 != null) {
                        try {
                            intent2 = Intent.parseUri(str7, 1);
                        } catch (URISyntaxException e17) {
                            e = e17;
                            intent2 = null;
                        }
                        try {
                            intent2.setPackage(str);
                        } catch (URISyntaxException e18) {
                            e = e18;
                            jz4.c.B("Cause: " + e.getMessage());
                            launchIntentForPackage = intent2;
                            if (launchIntentForPackage != null) {
                            }
                            return null;
                        }
                        launchIntentForPackage = intent2;
                    }
                } else if (map.containsKey(str4)) {
                    String str8 = map.get(str4);
                    intent = new Intent();
                    intent.setComponent(new ComponentName(str, str8));
                }
                launchIntentForPackage = null;
            } else {
                if (r.f389776c.equals(str6)) {
                    String str9 = map.get(str5);
                    if (!TextUtils.isEmpty(str9)) {
                        String trim = str9.trim();
                        if (!trim.startsWith("http://") && !trim.startsWith("https://")) {
                            trim = "http://" + trim;
                        }
                        try {
                            String protocol2 = new URL(trim).getProtocol();
                            if ("http".equals(protocol2) || "https".equals(protocol2)) {
                                intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
                                try {
                                    intent.setData(Uri.parse(trim));
                                    k.n(context, str, intent);
                                } catch (MalformedURLException e19) {
                                    e = e19;
                                    jz4.c.B("Cause: " + e.getMessage());
                                    launchIntentForPackage = intent;
                                    if (launchIntentForPackage != null) {
                                    }
                                    return null;
                                }
                            }
                        } catch (MalformedURLException e26) {
                            e = e26;
                            intent = null;
                        }
                    }
                }
                launchIntentForPackage = null;
            }
            launchIntentForPackage = intent;
        }
        if (launchIntentForPackage != null) {
            launchIntentForPackage.addFlags(268435456);
            try {
                if (context.getPackageManager().resolveActivity(launchIntentForPackage, 65536) != null) {
                    return launchIntentForPackage;
                }
                if (Build.VERSION.SDK_INT >= 30 && !hz.j(context) && r.f389776c.equals(str6)) {
                    return launchIntentForPackage;
                }
                jz4.c.m("not resolve activity:" + launchIntentForPackage + "for buttons");
            } catch (Exception e27) {
                jz4.c.B("Cause: " + e27.getMessage());
            }
        }
        return null;
    }

    private static Bitmap l(Context context, int i3) {
        return n(context.getResources().getDrawable(i3));
    }

    private static Bitmap m(Context context, String str, boolean z16) {
        Future submit = f389837c.submit(new a(str, context, z16));
        try {
            try {
                try {
                    Bitmap bitmap = (Bitmap) submit.get(180L, TimeUnit.SECONDS);
                    return bitmap == null ? bitmap : bitmap;
                } catch (InterruptedException e16) {
                    jz4.c.q(e16);
                    submit.cancel(true);
                    return null;
                } catch (TimeoutException e17) {
                    jz4.c.q(e17);
                    submit.cancel(true);
                    return null;
                }
            } catch (ExecutionException e18) {
                jz4.c.q(e18);
                submit.cancel(true);
                return null;
            }
        } finally {
            submit.cancel(true);
        }
    }

    public static Bitmap n(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int i3 = 1;
        if (intrinsicWidth <= 0) {
            intrinsicWidth = 1;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicHeight > 0) {
            i3 = intrinsicHeight;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    private static RemoteViews o(Context context, hb hbVar, byte[] bArr) {
        gs m375a = hbVar.m375a();
        String t16 = t(hbVar);
        if (m375a != null && m375a.m342a() != null) {
            Map<String, String> m342a = m375a.m342a();
            String str = m342a.get("layout_name");
            String str2 = m342a.get("layout_value");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(t16);
                    int identifier = resourcesForApplication.getIdentifier(str, TtmlNode.TAG_LAYOUT, t16);
                    if (identifier == 0) {
                        return null;
                    }
                    RemoteViews remoteViews = new RemoteViews(t16, identifier);
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        if (jSONObject.has("text")) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("text");
                            Iterator keys = jSONObject2.keys();
                            while (keys.hasNext()) {
                                String str3 = (String) keys.next();
                                String string = jSONObject2.getString(str3);
                                int identifier2 = resourcesForApplication.getIdentifier(str3, "id", t16);
                                if (identifier2 > 0) {
                                    remoteViews.setTextViewText(identifier2, string);
                                }
                            }
                        }
                        if (jSONObject.has("image")) {
                            JSONObject jSONObject3 = jSONObject.getJSONObject("image");
                            Iterator keys2 = jSONObject3.keys();
                            while (keys2.hasNext()) {
                                String str4 = (String) keys2.next();
                                String string2 = jSONObject3.getString(str4);
                                int identifier3 = resourcesForApplication.getIdentifier(str4, "id", t16);
                                int identifier4 = resourcesForApplication.getIdentifier(string2, "drawable", t16);
                                if (identifier3 > 0) {
                                    remoteViews.setImageViewResource(identifier3, identifier4);
                                }
                            }
                        }
                        if (jSONObject.has("time")) {
                            JSONObject jSONObject4 = jSONObject.getJSONObject("time");
                            Iterator keys3 = jSONObject4.keys();
                            while (keys3.hasNext()) {
                                String str5 = (String) keys3.next();
                                String string3 = jSONObject4.getString(str5);
                                if (string3.length() == 0) {
                                    string3 = "yy-MM-dd hh:mm";
                                }
                                int identifier5 = resourcesForApplication.getIdentifier(str5, "id", t16);
                                if (identifier5 > 0) {
                                    remoteViews.setTextViewText(identifier5, new SimpleDateFormat(string3).format(new Date(System.currentTimeMillis())));
                                }
                            }
                        }
                        return remoteViews;
                    } catch (JSONException e16) {
                        jz4.c.q(e16);
                        return null;
                    }
                } catch (PackageManager.NameNotFoundException e17) {
                    jz4.c.q(e17);
                }
            }
        }
        return null;
    }

    @TargetApi(16)
    private static dh p(Context context, hb hbVar, byte[] bArr, String str, int i3) {
        PendingIntent h16;
        Bitmap m3;
        String t16 = t(hbVar);
        Map<String, String> m342a = hbVar.m375a().m342a();
        String str2 = m342a.get("notification_style_type");
        hz.j(context);
        if ("2".equals(str2)) {
            dh dhVar = new dh(context);
            if (TextUtils.isEmpty(m342a.get("notification_bigPic_uri"))) {
                m3 = null;
            } else {
                m3 = m(context, m342a.get("notification_bigPic_uri"), false);
            }
            if (m3 == null) {
                jz4.c.m("can not get big picture.");
                return dhVar;
            }
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle(dhVar);
            bigPictureStyle.bigPicture(m3);
            bigPictureStyle.setSummaryText(str);
            bigPictureStyle.bigLargeIcon((Bitmap) null);
            dhVar.setStyle(bigPictureStyle);
            return dhVar;
        }
        if ("1".equals(str2)) {
            dh dhVar2 = new dh(context);
            dhVar2.setStyle(new Notification.BigTextStyle().bigText(str));
            return dhVar2;
        }
        if ("4".equals(str2) && hz.i()) {
            dg dgVar = new dg(context, t16);
            if (!TextUtils.isEmpty(m342a.get("notification_banner_image_uri"))) {
                dgVar.G(m(context, m342a.get("notification_banner_image_uri"), false));
            }
            if (!TextUtils.isEmpty(m342a.get("notification_banner_icon_uri"))) {
                dgVar.I(m(context, m342a.get("notification_banner_icon_uri"), false));
            }
            dgVar.l(m342a);
            return dgVar;
        }
        if ("3".equals(str2) && hz.i()) {
            di diVar = new di(context, i3, t16);
            if (!TextUtils.isEmpty(m342a.get("notification_colorful_button_text")) && (h16 = h(context, t16, hbVar, bArr, i3, 4)) != null) {
                diVar.I(m342a.get("notification_colorful_button_text"), h16).J(m342a.get("notification_colorful_button_bg_color"));
            }
            if (!TextUtils.isEmpty(m342a.get("notification_colorful_bg_color"))) {
                diVar.L(m342a.get("notification_colorful_bg_color"));
            } else if (!TextUtils.isEmpty(m342a.get("notification_colorful_bg_image_uri"))) {
                diVar.H(m(context, m342a.get("notification_colorful_bg_image_uri"), false));
            }
            diVar.l(m342a);
            return diVar;
        }
        return new dh(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:147:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x029b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x03fa  */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v4 */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static b q(Context context, hb hbVar, byte[] bArr, RemoteViews remoteViews, PendingIntent pendingIntent, int i3) {
        dh dhVar;
        int i16;
        Bitmap m3;
        boolean z16;
        Bitmap m16;
        String str;
        boolean z17;
        boolean z18;
        long currentTimeMillis;
        String str2;
        boolean z19;
        int i17;
        String str3;
        Notification notification;
        Bitmap b16;
        b bVar = new b();
        gs m375a = hbVar.m375a();
        String t16 = t(hbVar);
        Map<String, String> m342a = m375a.m342a();
        String[] M = M(context, m375a);
        if (remoteViews != null) {
            dhVar = new dh(context);
            dhVar.setCustomContentView(remoteViews);
        } else if (m342a != null && m342a.containsKey("notification_style_type")) {
            dhVar = p(context, hbVar, bArr, M[1], i3);
        } else {
            dhVar = new dh(context);
        }
        dh dhVar2 = dhVar;
        E(dhVar2, context, hbVar.b(), hbVar, bArr, i3);
        dhVar2.setContentTitle(M[0]);
        dhVar2.setContentText(M[1]);
        long currentTimeMillis2 = System.currentTimeMillis();
        dhVar2.setWhen(currentTimeMillis2);
        String v3 = v(m342a, "notification_show_when");
        if (TextUtils.isEmpty(v3)) {
            if (Build.VERSION.SDK_INT >= 24) {
                dhVar2.setShowWhen(true);
            }
        } else {
            dhVar2.setShowWhen(Boolean.parseBoolean(v3));
        }
        dhVar2.setContentIntent(pendingIntent);
        A(context, t16, dhVar2, m342a);
        int i18 = Build.VERSION.SDK_INT;
        if (m342a == null) {
            i16 = 1;
            m3 = null;
        } else {
            i16 = 1;
            m3 = m(context, m342a.get("notification_small_icon_uri"), true);
        }
        if (m3 != null) {
            Object[] objArr = new Object[i16];
            objArr[0] = m3;
            Object g16 = com.xiaomi.push.y.g("android.graphics.drawable.Icon", "createWithBitmap", objArr);
            if (g16 != null) {
                Object[] objArr2 = new Object[i16];
                objArr2[0] = g16;
                com.xiaomi.push.y.e(dhVar2, "setSmallIcon", objArr2);
                Bundle bundle = new Bundle();
                bundle.putBoolean("miui.isGrayscaleIcon", i16);
                dhVar2.addExtras(bundle);
            } else {
                jz4.c.m("failed te get small icon with url:" + m342a.get("notification_small_icon_uri"));
            }
        } else {
            jz4.c.m("failed to get small icon url:" + v(m342a, "notification_small_icon_uri"));
        }
        dhVar2.f(v(m342a, "notification_small_icon_color"));
        String v16 = v(m342a, "__dynamic_icon_uri");
        boolean z26 = Boolean.parseBoolean(v(m342a, "__adiom")) || !hz.i();
        if (!TextUtils.isEmpty(v16) && z26) {
            if (v16.startsWith("http")) {
                h.c d16 = h.d(context, v16, true);
                if (d16 != null) {
                    b16 = d16.f389726a;
                    bVar.f389845b = d16.f389727b;
                } else {
                    b16 = null;
                }
            } else {
                b16 = h.b(context, v16);
            }
            if (b16 != null) {
                dhVar2.setLargeIcon(b16);
                z16 = true;
                m16 = m342a != null ? null : m(context, m342a.get("notification_large_icon_uri"), true);
                if (m16 != null) {
                    dhVar2.setLargeIcon(m16);
                }
                if (m342a != null || i18 < 24) {
                    str = null;
                    z17 = false;
                } else {
                    String str4 = m342a.get("notification_group");
                    z17 = Boolean.parseBoolean(m342a.get("notification_is_summary"));
                    boolean parseBoolean = Boolean.parseBoolean(m342a.get("notification_group_disable_default"));
                    if (TextUtils.isEmpty(str4) && (hz.i() || !parseBoolean)) {
                        str4 = t(hbVar);
                    }
                    String str5 = str4;
                    com.xiaomi.push.y.e(dhVar2, "setGroupSummary", Boolean.valueOf(z17));
                    String str6 = m342a.get("notification_style_type");
                    if ("com.xiaomi.xmsf".equals(context.getPackageName()) && ("4".equals(str6) || "3".equals(str6))) {
                        str = t(hbVar) + "_custom_" + currentTimeMillis2;
                        z18 = true;
                        dhVar2.setAutoCancel(true);
                        currentTimeMillis = System.currentTimeMillis();
                        if (m342a != null && m342a.containsKey(RemoteMessageConst.Notification.TICKER)) {
                            dhVar2.setTicker(m342a.get(RemoteMessageConst.Notification.TICKER));
                        }
                        if (currentTimeMillis - f389835a > 10000) {
                            f389835a = currentTimeMillis;
                            i17 = m375a.f389177a;
                            if (T(context, t16)) {
                                i17 = a(context, t16);
                            }
                            dhVar2.setDefaults(i17);
                            if (m342a != null && (i17 & 1) != 0) {
                                String str7 = m342a.get("sound_uri");
                                if (!TextUtils.isEmpty(str7)) {
                                    z19 = z16;
                                    StringBuilder sb5 = new StringBuilder();
                                    str2 = "com.xiaomi.xmsf";
                                    sb5.append("android.resource://");
                                    sb5.append(t16);
                                    if (str7.startsWith(sb5.toString())) {
                                        dhVar2.setDefaults(i17 ^ 1);
                                        dhVar2.setSound(Uri.parse(str7));
                                    }
                                }
                            }
                            str2 = "com.xiaomi.xmsf";
                            z19 = z16;
                        } else {
                            str2 = "com.xiaomi.xmsf";
                            z19 = z16;
                            i17 = -100;
                        }
                        if (m342a != null || i18 < 26) {
                            str3 = "0";
                            if (m342a != null && i18 < 26) {
                                com.xiaomi.push.y.e(dhVar2, "setPriority", Integer.valueOf(W(m342a)));
                            }
                        } else {
                            j e16 = j.e(context, t16);
                            if (d(m342a) > 0) {
                                str3 = "0";
                                com.xiaomi.push.y.e(dhVar2, "setTimeoutAfter", Long.valueOf(r0 * 1000));
                            } else {
                                str3 = "0";
                            }
                            e.h(m375a);
                            String str8 = m342a.get("channel_id");
                            if (!TextUtils.isEmpty(str8) || context.getApplicationInfo().targetSdkVersion >= 26) {
                                String s16 = s(context, t16, m342a);
                                int N = N(m342a);
                                int i19 = m375a.f389177a;
                                String str9 = m342a.get("channel_description");
                                String str10 = m342a.get("sound_uri");
                                String str11 = m342a.get("channel_perm");
                                bb.f(context, m342a, dhVar2, currentTimeMillis2);
                                com.xiaomi.push.y.e(dhVar2, "setChannelId", e.d(e16, str8, s16, str9, i19, N, str10, str11));
                                if (i17 == -100 && k.t(m342a)) {
                                    k.q(dhVar2, z17);
                                }
                                if ("pulldown".equals(k.i(m342a)) && k.t(m342a) && Objects.equals(m342a.get("pull_down_pop_type"), str3)) {
                                    k.q(dhVar2, z17);
                                }
                                if (QQWinkConstants.TAB_TTS.equals(k.i(m342a)) && k.t(m342a)) {
                                    k.q(dhVar2, z17);
                                }
                            }
                            String str12 = m342a.get("background_color");
                            if (!TextUtils.isEmpty(str12)) {
                                try {
                                    int parseInt = Integer.parseInt(str12);
                                    dhVar2.setOngoing(true);
                                    dhVar2.setColor(parseInt);
                                    com.xiaomi.push.y.e(dhVar2, "setColorized", Boolean.TRUE);
                                } catch (Exception e17) {
                                    jz4.c.q(e17);
                                }
                            }
                        }
                        if (str != null) {
                            if (!z18) {
                                str = g.d().f(context, dhVar2, str);
                            }
                            com.xiaomi.push.y.e(dhVar2, "setGroup", str);
                        }
                        if (hz.r() && str2.equals(context.getPackageName())) {
                            com.xiaomi.push.y.g("miui.util.NotificationHelper", "setTargetPkg", context, dhVar2, t(hbVar));
                        }
                        notification = dhVar2.getNotification();
                        if (z19 && hz.i()) {
                            e(notification);
                        }
                        if (m342a != null) {
                            if (notification.extras == null) {
                                notification.extras = new Bundle();
                            }
                            if (!TextUtils.isEmpty(m342a.get("enable_keyguard"))) {
                                k.w(notification, Boolean.parseBoolean(m342a.get("enable_keyguard")));
                            }
                            if (!TextUtils.isEmpty(m342a.get("enable_float"))) {
                                k.m(notification, Boolean.parseBoolean(m342a.get("enable_float")));
                            }
                            if (!TextUtils.isEmpty(m342a.get("float_small_win")) && str3.equals(m342a.get("float_small_win")) && com.xiaomi.push.g.q(context, t16)) {
                                k.m(notification, false);
                            }
                            int a16 = ij.a(m342a.get("section_is_prr"), -1);
                            int a17 = ij.a(m342a.get("section_prr_cl"), -1);
                            if (a16 >= 0 && a17 >= 0) {
                                k.k(notification, a16, a17);
                            }
                        }
                        bVar.f389844a = notification;
                        return bVar;
                    }
                    str = str5;
                }
                z18 = false;
                dhVar2.setAutoCancel(true);
                currentTimeMillis = System.currentTimeMillis();
                if (m342a != null) {
                    dhVar2.setTicker(m342a.get(RemoteMessageConst.Notification.TICKER));
                }
                if (currentTimeMillis - f389835a > 10000) {
                }
                if (m342a != null) {
                }
                str3 = "0";
                if (m342a != null) {
                    com.xiaomi.push.y.e(dhVar2, "setPriority", Integer.valueOf(W(m342a)));
                }
                if (str != null) {
                }
                if (hz.r()) {
                    com.xiaomi.push.y.g("miui.util.NotificationHelper", "setTargetPkg", context, dhVar2, t(hbVar));
                }
                notification = dhVar2.getNotification();
                if (z19) {
                    e(notification);
                }
                if (m342a != null) {
                }
                bVar.f389844a = notification;
                return bVar;
            }
        }
        z16 = false;
        if (m342a != null) {
        }
        if (m16 != null) {
        }
        if (m342a != null) {
        }
        str = null;
        z17 = false;
        z18 = false;
        dhVar2.setAutoCancel(true);
        currentTimeMillis = System.currentTimeMillis();
        if (m342a != null) {
        }
        if (currentTimeMillis - f389835a > 10000) {
        }
        if (m342a != null) {
        }
        str3 = "0";
        if (m342a != null) {
        }
        if (str != null) {
        }
        if (hz.r()) {
        }
        notification = dhVar2.getNotification();
        if (z19) {
        }
        if (m342a != null) {
        }
        bVar.f389844a = notification;
        return bVar;
    }

    public static c r(Context context, hb hbVar, byte[] bArr) {
        int i3;
        Map<String, String> map;
        String str;
        int i16;
        c cVar = new c();
        g.b f16 = com.xiaomi.push.g.f(context, t(hbVar), true);
        gs m375a = hbVar.m375a();
        String str2 = null;
        if (m375a != null) {
            i3 = m375a.c();
            map = m375a.m342a();
        } else {
            i3 = 0;
            map = null;
        }
        final int e16 = ij.e(t(hbVar), i3);
        if (hz.j(context) && f16 == g.b.NOT_ALLOWED) {
            if (m375a != null) {
                df.a(context.getApplicationContext()).g(hbVar.b(), P(hbVar), m375a.m341a(), "10:" + t(hbVar));
            }
            jz4.c.m("Do not notify because user block " + t(hbVar) + "\u2018s notification");
            return cVar;
        }
        hz.j(context);
        RemoteViews o16 = o(context, hbVar, bArr);
        PendingIntent f17 = f(context, hbVar, hbVar.b(), bArr, e16);
        if (f17 == null) {
            if (m375a != null) {
                df.a(context.getApplicationContext()).g(hbVar.b(), P(hbVar), m375a.m341a(), "11");
            }
            jz4.c.m("The click PendingIntent is null. ");
            return cVar;
        }
        b q16 = q(context, hbVar, bArr, o16, f17, e16);
        cVar.f389847b = q16.f389845b;
        cVar.f389846a = t(hbVar);
        Notification notification = q16.f389844a;
        if (hz.i()) {
            if (!TextUtils.isEmpty(m375a.m341a())) {
                notification.extras.putString("message_id", m375a.m341a());
            }
            notification.extras.putString("local_paid", hbVar.m376a());
            k.o(map, notification.extras, "msg_busi_type");
            k.o(map, notification.extras, "disable_notification_flags");
            if (m375a.m347b() == null) {
                str = null;
            } else {
                str = m375a.m347b().get("score_info");
            }
            if (!TextUtils.isEmpty(str)) {
                notification.extras.putString("score_info", str);
            }
            notification.extras.putString("pushUid", v(m375a.f24766a, "n_stats_expose"));
            if (Y(hbVar)) {
                i16 = 1000;
            } else if (J(hbVar)) {
                i16 = 3000;
            } else {
                i16 = -1;
            }
            notification.extras.putString("eventMessageType", String.valueOf(i16));
            notification.extras.putString(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, t(hbVar));
        }
        if (m375a.m342a() != null) {
            str2 = m375a.m342a().get("message_count");
        }
        if (hz.i() && str2 != null) {
            try {
                k.j(notification, Integer.parseInt(str2));
            } catch (NumberFormatException e17) {
                df.a(context.getApplicationContext()).i(hbVar.b(), P(hbVar), m375a.m341a(), "8");
                jz4.c.B("fail to set message count. " + e17);
            }
        }
        String t16 = t(hbVar);
        k.l(notification, t16);
        final j e18 = j.e(context, t16);
        hz.j(context);
        hz.j(context);
        e18.n(e16, notification);
        cVar.f389848c = true;
        jz4.c.m("notification: " + m375a.m341a() + " is notifyied");
        if (hz.i() && hz.j(context)) {
            g.d().h(context, e16, notification);
            bb.e(context, t16, e16, m375a.m341a(), notification);
        }
        if (J(hbVar)) {
            df.a(context.getApplicationContext()).f(hbVar.b(), P(hbVar), m375a.m341a(), 3002, null);
        }
        if (Y(hbVar)) {
            df.a(context.getApplicationContext()).f(hbVar.b(), P(hbVar), m375a.m341a(), 1002, null);
        }
        if (Build.VERSION.SDK_INT < 26) {
            String m341a = m375a.m341a();
            com.xiaomi.push.ae b16 = com.xiaomi.push.ae.b(context);
            int d16 = d(m375a.m342a());
            if (d16 > 0 && !TextUtils.isEmpty(m341a)) {
                final String str3 = "n_timeout_" + m341a;
                b16.m(str3);
                b16.n(new ae.a() { // from class: com.xiaomi.push.service.x.1
                    @Override // com.xiaomi.push.ae.a
                    public String e() {
                        return str3;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        e18.m(e16);
                    }
                }, d16);
            }
        }
        Pair<Integer, hb> pair = new Pair<>(Integer.valueOf(e16), hbVar);
        LinkedList<Pair<Integer, hb>> linkedList = f389836b;
        synchronized (linkedList) {
            linkedList.add(pair);
            if (linkedList.size() > 100) {
                linkedList.remove();
            }
        }
        return cVar;
    }

    private static String s(Context context, String str, Map<String, String> map) {
        if (map != null && !TextUtils.isEmpty(map.get("channel_name"))) {
            return map.get("channel_name");
        }
        return com.xiaomi.push.g.n(context, str);
    }

    public static String t(hb hbVar) {
        gs m375a;
        if ("com.xiaomi.xmsf".equals(hbVar.f389250b) && (m375a = hbVar.m375a()) != null && m375a.m342a() != null) {
            String str = m375a.m342a().get("miui_package_name");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return hbVar.f389250b;
    }

    public static String u(Map<String, String> map, int i3) {
        String str;
        if (i3 == 0) {
            str = "notify_effect";
        } else if (V(map)) {
            str = String.format("cust_btn_%s_ne", Integer.valueOf(i3));
        } else if (i3 == 1) {
            str = "notification_style_button_left_notify_effect";
        } else if (i3 == 2) {
            str = "notification_style_button_mid_notify_effect";
        } else if (i3 == 3) {
            str = "notification_style_button_right_notify_effect";
        } else if (i3 == 4) {
            str = "notification_colorful_button_notify_effect";
        } else {
            str = null;
        }
        if (map == null || str == null) {
            return null;
        }
        return map.get(str);
    }

    private static String v(Map<String, String> map, String str) {
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    private static void w(Context context, Intent intent, hb hbVar, gs gsVar, String str, int i3) {
        if (hbVar != null && gsVar != null && !TextUtils.isEmpty(str)) {
            String u16 = u(gsVar.m342a(), i3);
            if (!TextUtils.isEmpty(u16)) {
                if (r.f389774a.equals(u16) || r.f389775b.equals(u16) || r.f389776c.equals(u16)) {
                    intent.putExtra("messageId", str);
                    intent.putExtra("local_paid", hbVar.f24804a);
                    if (!TextUtils.isEmpty(hbVar.f389250b)) {
                        intent.putExtra(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, hbVar.f389250b);
                    }
                    intent.putExtra("job_key", v(gsVar.m342a(), "jobkey"));
                    intent.putExtra(i3 + "_target_component", c(context, hbVar.f389250b, gsVar.m342a(), i3));
                }
            }
        }
    }

    public static void x(Context context, String str) {
        y(context, str, -1);
    }

    public static void y(Context context, String str, int i3) {
        z(context, str, i3, -1);
    }

    public static void z(Context context, String str, int i3, int i16) {
        int hashCode;
        if (context != null && !TextUtils.isEmpty(str) && i3 >= -1) {
            j e16 = j.e(context, str);
            List<StatusBarNotification> y16 = e16.y();
            if (ij.d(y16)) {
                return;
            }
            LinkedList linkedList = new LinkedList();
            boolean z16 = false;
            if (i3 == -1) {
                z16 = true;
                hashCode = 0;
            } else {
                hashCode = ((str.hashCode() / 10) * 10) + i3;
            }
            Iterator<StatusBarNotification> it = y16.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                StatusBarNotification next = it.next();
                if (!TextUtils.isEmpty(String.valueOf(next.getId()))) {
                    int id5 = next.getId();
                    if (z16) {
                        linkedList.add(next);
                        e16.m(id5);
                    } else if (hashCode == id5) {
                        aj.b(context, next, i16);
                        linkedList.add(next);
                        e16.m(id5);
                        break;
                    }
                }
            }
            C(context, linkedList);
        }
    }
}
