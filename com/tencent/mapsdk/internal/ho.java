package com.tencent.mapsdk.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.map.tools.net.NetUtil;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ho {
    private static a A = null;
    private static final String B;
    private static final String C;
    private static String D = null;
    private static String E = null;
    private static String F = null;
    private static String G = null;
    private static String H = null;
    private static String I = null;
    private static String J = null;
    private static int K = 0;
    private static String L = null;
    private static String M = null;
    private static float N = 0.0f;
    private static final int O = 100;
    private static final int P = 4000000;
    private static final int Q = 53500000;
    private static final int R = 73670000;
    private static final int S = 135100000;
    private static final int T = -85000000;
    private static final int U = 85000000;
    private static final int V = -180000000;
    private static final int W = 180000000;
    private static int X = 0;
    private static int Y = 0;
    private static float Z = 0.0f;

    /* renamed from: a, reason: collision with root package name */
    public static final File f148693a;

    /* renamed from: aa, reason: collision with root package name */
    private static final int f148694aa = 20;

    /* renamed from: ab, reason: collision with root package name */
    private static final double f148695ab = 6378137.0d;

    /* renamed from: ac, reason: collision with root package name */
    private static final double f148696ac = 4.007501668557849E7d;

    /* renamed from: ad, reason: collision with root package name */
    private static final double f148697ad = 0.017453292519943295d;

    /* renamed from: ae, reason: collision with root package name */
    private static final double f148698ae = 2.68435456E8d;

    /* renamed from: b, reason: collision with root package name */
    public static final File f148699b;

    /* renamed from: c, reason: collision with root package name */
    public static final File f148700c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f148701d = "tencentmap/mapsdk_vector/";

    /* renamed from: e, reason: collision with root package name */
    public static final int f148702e = -1;

    /* renamed from: f, reason: collision with root package name */
    public static final int f148703f = 0;

    /* renamed from: g, reason: collision with root package name */
    public static final int f148704g = 1;

    /* renamed from: h, reason: collision with root package name */
    public static final int f148705h = 2;

    /* renamed from: i, reason: collision with root package name */
    public static int f148706i = 0;

    /* renamed from: j, reason: collision with root package name */
    public static int f148707j = 0;

    /* renamed from: k, reason: collision with root package name */
    public static int f148708k = 0;

    /* renamed from: l, reason: collision with root package name */
    public static int f148709l = 0;

    /* renamed from: m, reason: collision with root package name */
    public static final int f148710m = 1;

    /* renamed from: n, reason: collision with root package name */
    public static final int f148711n = 2;

    /* renamed from: o, reason: collision with root package name */
    public static final int f148712o = 3;

    /* renamed from: p, reason: collision with root package name */
    public static int f148713p = 0;

    /* renamed from: q, reason: collision with root package name */
    public static int f148714q = 0;

    /* renamed from: r, reason: collision with root package name */
    public static int f148715r = 0;

    /* renamed from: s, reason: collision with root package name */
    public static int f148716s = 0;

    /* renamed from: t, reason: collision with root package name */
    public static int f148717t = 0;

    /* renamed from: u, reason: collision with root package name */
    private static final String f148718u = "Tencent";

    /* renamed from: v, reason: collision with root package name */
    private static final String f148719v = "MapSDK";

    /* renamed from: w, reason: collision with root package name */
    private static final String f148720w = "Caches";

    /* renamed from: x, reason: collision with root package name */
    private static String f148721x;

    /* renamed from: y, reason: collision with root package name */
    private static String f148722y;

    /* renamed from: z, reason: collision with root package name */
    private static String f148723z;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        final boolean f148724a;

        /* synthetic */ a(boolean z16, byte b16) {
            this(z16);
        }

        private String a() {
            if (!this.f148724a && ho.G != null) {
                return ho.G;
            }
            return "";
        }

        private String b() {
            if (!this.f148724a && ho.H != null) {
                return ho.H;
            }
            return "";
        }

        private static String c() {
            return NetUtil.STR_UserAgent;
        }

        private String d() {
            if (!this.f148724a && ho.L != null) {
                return ho.L;
            }
            return "";
        }

        private String e() {
            if (!this.f148724a) {
                return ho.M;
            }
            return "";
        }

        private int f() {
            if (!this.f148724a) {
                return ho.K;
            }
            return 0;
        }

        private String g() {
            if (!this.f148724a && ho.F != null) {
                return ho.F;
            }
            return "";
        }

        private static int h() {
            return ho.X;
        }

        private String i() {
            if (!this.f148724a && ho.I != null) {
                return ho.I;
            }
            return "";
        }

        private static String j() {
            String str = ho.f148723z;
            if (str != null && !TextUtils.isEmpty(str) && !str.equals(ho.J)) {
                return str;
            }
            if (ho.J != null) {
                return ho.J;
            }
            return "";
        }

        private static String k() {
            return ho.B;
        }

        private static String l() {
            if (ho.E != null) {
                return ho.E;
            }
            return "";
        }

        private static String m() {
            return ho.C;
        }

        private static float n() {
            return ho.N;
        }

        private static float o() {
            return ho.Z;
        }

        private static String p() {
            String str = ho.f148722y;
            if (str == null || str.equals(ho.f148721x)) {
                return ho.f148721x;
            }
            return str;
        }

        a(boolean z16) {
            this.f148724a = z16;
        }
    }

    static {
        File file = new File("", f148718u);
        f148693a = file;
        File file2 = new File(file, f148719v);
        f148699b = file2;
        f148700c = new File(file2, f148720w);
        f148721x = null;
        f148722y = null;
        f148723z = null;
        String str = tf.f150443j;
        B = str;
        C = str;
        D = null;
        E = null;
        F = null;
        G = null;
        H = null;
        I = null;
        J = null;
        K = 0;
        L = null;
        M = "undefined";
        N = 1.0f;
        f148706i = 2;
        f148707j = 0;
        f148708k = 0;
        f148709l = 0;
        f148713p = 2;
        f148714q = 4000000;
        f148715r = Q;
        f148716s = R;
        f148717t = S;
        X = 0;
        Y = 160;
        Z = 0.0f;
    }

    private static Date J() {
        return Calendar.getInstance().getTime();
    }

    private static String K() {
        if (Q().f148724a) {
            return "";
        }
        return M;
    }

    private static void L() {
        int i3 = Y;
        if (i3 <= 120) {
            f148713p = 1;
            return;
        }
        if (i3 <= 160) {
            f148713p = 2;
        } else if (i3 <= 240) {
            f148713p = 3;
        } else {
            M();
        }
    }

    private static void M() {
        int i3 = X;
        if (i3 > 153600) {
            f148713p = 3;
        } else if (i3 < 153600) {
            f148713p = 1;
        } else {
            f148713p = 2;
        }
    }

    private static String N() {
        return f148718u;
    }

    private static String O() {
        return f148719v;
    }

    private static String P() {
        return f148720w;
    }

    private static a Q() {
        a aVar = A;
        if (aVar != null) {
            return aVar;
        }
        return new a(false, 0 == true ? 1 : 0);
    }

    private static a R() {
        return new a(false, 0 == true ? 1 : 0);
    }

    private static float a(int i3) {
        return i3 / 255.0f;
    }

    public static float b() {
        Q();
        return N;
    }

    public static String c() {
        Q();
        return NetUtil.STR_UserAgent;
    }

    public static String d() {
        String str;
        return (Q().f148724a || (str = G) == null) ? "" : str;
    }

    public static String e() {
        String str;
        if (!Q().f148724a && (str = H) != null) {
            return str;
        }
        return "";
    }

    public static int f() {
        Q();
        return X;
    }

    public static String g() {
        String str;
        if (!Q().f148724a && (str = I) != null) {
            return str;
        }
        return "";
    }

    public static String h() {
        String str;
        if (!Q().f148724a && (str = L) != null) {
            return str;
        }
        return "";
    }

    public static String i() {
        Q();
        return B;
    }

    public static int j() {
        if (Q().f148724a) {
            return 0;
        }
        return K;
    }

    public static String k() {
        Q();
        String str = E;
        if (str == null) {
            return "";
        }
        return str;
    }

    public static String l() {
        String str;
        if (!Q().f148724a && (str = F) != null) {
            return str;
        }
        return "";
    }

    public static String m() {
        Q();
        String str = f148723z;
        if (str != null && !TextUtils.isEmpty(str) && !str.equals(J)) {
            return str;
        }
        String str2 = J;
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    public static String n() {
        Q();
        return C;
    }

    public static float o() {
        Q();
        return Z;
    }

    public static int p() {
        return 687865856;
    }

    public static void q() {
        f148716s = R;
        f148717t = S;
        f148715r = Q;
        f148714q = 4000000;
    }

    public static void r() {
        A = null;
        f148723z = null;
        f148722y = null;
    }

    public static String a() {
        Q();
        String str = f148722y;
        return (str == null || str.equals(f148721x)) ? f148721x : str;
    }

    private static String c(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb5 = new StringBuilder();
            for (byte b16 : digest) {
                sb5.append(Integer.toHexString(b16 & 255));
                sb5.append("");
            }
            return sb5.toString();
        } catch (Exception unused) {
            return str;
        }
    }

    private static String b(String str) throws PatternSyntaxException {
        return Pattern.compile("[^a-zA-Z0-9]").matcher(str).replaceAll("").trim();
    }

    private static String[] d(String str) {
        String[] strArr = new String[3];
        try {
            JSONObject jSONObject = new JSONObject(str);
            strArr[0] = jSONObject.optString("version");
            strArr[1] = jSONObject.optString("data");
            strArr[2] = jSONObject.optString("otherDistrict");
        } catch (JSONException unused) {
        }
        return strArr;
    }

    private static void b(DisplayMetrics displayMetrics) {
        Y = displayMetrics.densityDpi;
        L();
    }

    private static String a(String str) {
        return str == null ? "" : str.replace(ContainerUtils.FIELD_DELIMITER, "").replace("#", "").replace(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, "");
    }

    private static String b(Context context) {
        ApplicationInfo applicationInfo;
        if (context == null) {
            return "";
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
            applicationInfo = null;
        }
        try {
            return URLEncoder.encode((applicationInfo != null ? applicationInfo.loadLabel(packageManager) : "can't find app name").toString(), "utf-8");
        } catch (Exception unused) {
            return "can't find app name";
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        kt.f149081d = f148700c;
        f148722y = str;
        f148723z = str2;
        M = str3;
        if (X == 0 && context != null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            X = displayMetrics.widthPixels * displayMetrics.heightPixels;
            if (Build.VERSION.SDK_INT < 24) {
                a(displayMetrics);
            } else {
                Y = displayMetrics.densityDpi;
                L();
            }
        }
        if (L == null) {
            try {
                String b16 = ht.b();
                L = b16;
                String a16 = a(b16);
                L = a16;
                L = URLEncoder.encode(a16, "utf-8");
            } catch (Exception unused) {
            }
        }
        if (K == 0) {
            K = Build.VERSION.SDK_INT;
        }
        if (J == null) {
            try {
                String packageName = context.getPackageName();
                J = packageName;
                String a17 = a(packageName);
                J = a17;
                J = URLEncoder.encode(a17, "utf-8");
            } catch (Exception unused2) {
            }
        }
        if (D == null) {
            try {
                String h16 = ht.h(context);
                D = h16;
                String a18 = a(h16);
                D = a18;
                D = URLEncoder.encode(a18, "utf-8");
            } catch (Exception unused3) {
            }
        }
        if (E == null) {
            try {
                String e16 = ht.e(context);
                E = e16;
                String a19 = a(e16);
                E = a19;
                E = URLEncoder.encode(a19, "utf-8");
            } catch (Exception unused4) {
            }
        }
        if (F == null) {
            try {
                String i3 = ht.i(context);
                F = i3;
                String a26 = a(i3);
                F = a26;
                F = URLEncoder.encode(a26, "utf-8");
            } catch (Exception unused5) {
            }
        }
        if (G == null) {
            try {
                String f16 = ht.f(context);
                G = f16;
                String a27 = a(f16);
                G = a27;
                G = URLEncoder.encode(a27, "utf-8");
            } catch (Exception unused6) {
            }
        }
        if (TextUtils.isEmpty(H)) {
            try {
                String g16 = ht.g(context);
                H = g16;
                String a28 = a(g16);
                H = a28;
                H = URLEncoder.encode(a28, "utf-8");
            } catch (Exception unused7) {
            }
        }
        if (I == null) {
            try {
                String netTypeStr = NetUtil.getNetTypeStr(context);
                I = netTypeStr;
                String a29 = a(netTypeStr);
                I = a29;
                I = URLEncoder.encode(a29, "utf-8");
            } catch (Exception unused8) {
            }
        }
        if (f148721x == null) {
            try {
                String a36 = ht.a(context, "TencentMapSDK");
                f148721x = a36;
                f148721x = URLEncoder.encode(a36, "utf-8");
            } catch (Exception unused9) {
            }
        }
        if (N == 1.0f) {
            N = 320.0f / context.getResources().getDisplayMetrics().densityDpi;
        }
        Z = context.getResources().getDisplayMetrics().density;
    }

    public static int b(String str, String str2) {
        if (hs.a(str2)) {
            return 1;
        }
        if (hs.a(str)) {
            return -1;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int length = split.length;
        if (length > split2.length) {
            length = split2.length;
        }
        for (int i3 = 0; i3 < length; i3++) {
            String str3 = split2[i3];
            String str4 = split[i3];
            if (TextUtils.isEmpty(str3)) {
                str3 = "0";
            }
            if (TextUtils.isEmpty(str4)) {
                str4 = "0";
            }
            if (Integer.valueOf(str3).intValue() < Integer.valueOf(str4).intValue()) {
                return 1;
            }
            if (Integer.valueOf(str3).intValue() > Integer.valueOf(str4).intValue()) {
                return -1;
            }
        }
        if (split.length > split2.length) {
            return 1;
        }
        return split.length == split2.length ? 0 : -1;
    }

    public static String a(String str, String str2) {
        String b16;
        if (hs.a(str)) {
            str = "";
        }
        if (hs.a(str2)) {
            str2 = "";
        }
        StringBuilder sb5 = new StringBuilder(256);
        sb5.append("key=");
        sb5.append(a());
        sb5.append("&pid=");
        sb5.append(m());
        sb5.append("&key2=");
        sb5.append(str);
        sb5.append("&pid2=");
        sb5.append(str2);
        sb5.append("&psv=");
        sb5.append(k());
        sb5.append("&ver=");
        Q();
        sb5.append(C);
        sb5.append("&pf=");
        Q();
        sb5.append("androidsdk&hm=");
        sb5.append(h());
        sb5.append("&suid=");
        sb5.append(d());
        sb5.append("&os=");
        sb5.append(j());
        sb5.append("&dip=");
        sb5.append(l());
        sb5.append("&nt=");
        sb5.append(g());
        sb5.append("&channel=1&output=json");
        String str3 = M;
        if (!TextUtils.isEmpty(str3)) {
            try {
                b16 = URLEncoder.encode(str3, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                b16 = b(str3);
            }
            sb5.append("&cuid=");
            sb5.append(b16);
            sb5.append("&uuid=");
            sb5.append(b16);
        }
        return sb5.toString();
    }

    public static String a(String str, String str2, String str3) {
        StringBuilder sb5 = new StringBuilder(256);
        if (!TextUtils.isEmpty(G)) {
            sb5.append("&suid=");
            sb5.append(d());
        }
        if (!TextUtils.isEmpty(H)) {
            sb5.append("&duid=");
            sb5.append(e());
        }
        if (!TextUtils.isEmpty(J)) {
            sb5.append("&appid=");
            sb5.append(m());
            sb5.append("&pid=");
            sb5.append(m());
        }
        String str4 = B;
        if (!TextUtils.isEmpty(str4)) {
            sb5.append("&sdkver=");
            Q();
            sb5.append(str4);
            sb5.append("&ver=");
            Q();
            sb5.append(C);
        }
        if (!TextUtils.isEmpty(str)) {
            sb5.append("&ui=");
            sb5.append(str);
        }
        if (!TextUtils.isEmpty(M)) {
            sb5.append("&appsuid=");
            try {
                sb5.append(URLEncoder.encode(M, "UTF-8"));
            } catch (UnsupportedEncodingException unused) {
                sb5.append(b(M));
            }
            sb5.append("&cuid=");
            sb5.append(M);
        }
        sb5.append("&api_key=" + a());
        sb5.append("&key=" + a());
        if (!TextUtils.isEmpty(str2)) {
            sb5.append("&key2=");
            sb5.append(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            sb5.append("&pid2=");
            sb5.append(str3);
        }
        if (!TextUtils.isEmpty(k())) {
            sb5.append("&psv=");
            sb5.append(k());
        }
        Q();
        if (!TextUtils.isEmpty(NetUtil.STR_UserAgent)) {
            sb5.append("&pf=");
            Q();
            sb5.append(NetUtil.STR_UserAgent);
        }
        if (!TextUtils.isEmpty(h())) {
            sb5.append("&hm=");
            sb5.append(h());
        }
        sb5.append("&os=");
        sb5.append(j());
        if (!TextUtils.isEmpty(l())) {
            sb5.append("&dip=");
            sb5.append(l());
        }
        if (!TextUtils.isEmpty(g())) {
            sb5.append("&nt=");
            sb5.append(g());
        }
        if (!TextUtils.isEmpty(ht.a())) {
            sb5.append("&sessionid=");
            sb5.append(ht.a());
        }
        return sb5.toString();
    }

    private static String a(byte[] bArr, String str) {
        StringBuilder sb5 = new StringBuilder();
        for (byte b16 : bArr) {
            sb5.append(Integer.toHexString(b16 & 255));
            sb5.append(str);
        }
        return sb5.toString();
    }

    private static void a(DisplayMetrics displayMetrics) {
        Field field;
        try {
            field = displayMetrics.getClass().getField("densityDpi");
        } catch (NoSuchFieldException | SecurityException unused) {
            field = null;
        }
        if (field != null) {
            try {
                Y = field.getInt(displayMetrics);
                L();
                return;
            } catch (IllegalAccessException e16) {
                e16.printStackTrace();
                return;
            } catch (IllegalArgumentException e17) {
                e17.printStackTrace();
                return;
            }
        }
        M();
    }

    private static void a(Context context) {
        if (context == null) {
            return;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        X = displayMetrics.widthPixels * displayMetrics.heightPixels;
        if (Build.VERSION.SDK_INT < 24) {
            a(displayMetrics);
        } else {
            Y = displayMetrics.densityDpi;
            L();
        }
    }

    public static double a(double d16, double d17) {
        return (d16 * 6.698324247899813d) / Math.cos(d17 * 0.017453292519943295d);
    }

    private static boolean a(Context context, byte[] bArr, String str) {
        File fileStreamPath = context.getFileStreamPath("tecentmap");
        if (!fileStreamPath.exists()) {
            fileStreamPath.mkdirs();
        }
        String str2 = fileStreamPath.getPath() + "/" + str;
        return (TextUtils.isEmpty(str2) ? 0 : ku.a(bArr, new File(str2))) != 0;
    }

    private static byte[] a(Context context, String str) {
        InputStream b16 = ku.b(context.getFileStreamPath("tecentmap").getPath() + "/" + str);
        byte[] b17 = ku.b(b16);
        ku.a((Closeable) b16);
        return b17;
    }

    public static void a(boolean z16) {
        A = new a(z16, (byte) 0);
    }
}
