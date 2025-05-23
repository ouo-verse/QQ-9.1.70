package h91;

import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    private static final a f404583e = new a(1);

    /* renamed from: f, reason: collision with root package name */
    private static final a f404584f;

    /* renamed from: g, reason: collision with root package name */
    private static a f404585g;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f404586h;

    /* renamed from: a, reason: collision with root package name */
    private final int f404587a;

    /* renamed from: b, reason: collision with root package name */
    private final String f404588b;

    /* renamed from: c, reason: collision with root package name */
    private final String f404589c;

    /* renamed from: d, reason: collision with root package name */
    private final String f404590d;

    static {
        a aVar = new a(2);
        f404584f = aVar;
        f404585g = aVar;
        f404586h = false;
    }

    a(int i3) {
        this.f404587a = i3;
        this.f404588b = h(i3);
        this.f404590d = b(i3);
        if (i3 == 1) {
            this.f404589c = "test.ark.qq.com";
        } else {
            this.f404589c = "cgi.ark.qq.com";
        }
    }

    private static String b(int i3) {
        String f16 = f();
        if (i3 == 1) {
            return f16 + "/pddata/prd/arkapp/test";
        }
        return f16 + "/pddata/prd/arkapp";
    }

    public static a d() {
        if (!f404586h) {
            f404586h = true;
            QLog.i("ArkApp", 1, "ArkTemp.getCurrent sso env isTestEnv=false");
        }
        a aVar = f404584f;
        f404585g = aVar;
        return aVar;
    }

    private static String f() {
        return BaseApplication.getContext().getFilesDir().getAbsolutePath();
    }

    private static String h(int i3) {
        String f16 = f();
        if (i3 == 1) {
            return f16 + "/ArkAppTest";
        }
        return f16 + "/ArkApp";
    }

    public String a() {
        return this.f404588b + "/Debug";
    }

    public String c() {
        return this.f404588b + "/Crash";
    }

    public int e() {
        return this.f404587a;
    }

    public String g() {
        return this.f404588b;
    }

    public String i() {
        return this.f404590d + "/Dict";
    }
}
