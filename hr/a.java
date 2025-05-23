package hr;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public String f405988a;

    /* renamed from: b, reason: collision with root package name */
    public String f405989b;

    /* renamed from: c, reason: collision with root package name */
    public String f405990c;

    /* renamed from: d, reason: collision with root package name */
    public String f405991d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f405992e;

    /* renamed from: f, reason: collision with root package name */
    public String f405993f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f405994g;

    /* renamed from: h, reason: collision with root package name */
    private String f405995h;

    /* renamed from: i, reason: collision with root package name */
    private int f405996i = 5;

    /* renamed from: j, reason: collision with root package name */
    private float f405997j = 0.05f;

    /* renamed from: k, reason: collision with root package name */
    public double f405998k = 1.0d;

    /* renamed from: l, reason: collision with root package name */
    @Deprecated
    public int f405999l = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f406000m = 0;

    public a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f405988a = str;
            return;
        }
        throw new IllegalStateException("FacePackage'id can not be null.");
    }

    public int a() {
        return this.f405996i;
    }

    public abstract int b();

    public float c() {
        return this.f405997j;
    }

    public abstract String d(int i3);

    public abstract String e();

    /* JADX WARN: Removed duplicated region for block: B:20:0x00ee A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(String str) {
        boolean z16;
        if (TextUtils.isEmpty(str)) {
            hd0.c.g("FacePackage", "config json is empty.");
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f405996i = jSONObject.getInt("amount");
                this.f405997j = Float.valueOf(jSONObject.getString("spacing")).floatValue();
                this.f405998k = jSONObject.optDouble("scale", 1.0d);
            } catch (Exception e16) {
                hd0.c.g("FacePackage", "parse config json error : " + str + ", exception : " + e16.toString());
            }
            if (this.f405996i >= 1) {
                float f16 = this.f405997j;
                if (f16 >= 0.0f && f16 < 0.5d) {
                    this.f405995h = str;
                    z16 = true;
                    if (z16) {
                        hd0.c.i("FacePackage", "config json is illegal, use default value, type : %s", e());
                        if ("NormalFacePackage".equals(e())) {
                            if ("1".equals(this.f405988a)) {
                                this.f405996i = 5;
                                this.f405997j = 0.05f;
                            } else {
                                this.f405996i = 5;
                                this.f405997j = 0.05f;
                            }
                        } else if ("LocationFacePackage".equals(e())) {
                            this.f405996i = 4;
                            this.f405997j = 0.1f;
                        } else {
                            throw new IllegalStateException("unknown face package, type:" + e());
                        }
                        this.f405995h = null;
                        return;
                    }
                    return;
                }
            }
            hd0.c.i("FacePackage", "config json is illegal : %s", str);
        }
        z16 = false;
        if (z16) {
        }
    }
}
