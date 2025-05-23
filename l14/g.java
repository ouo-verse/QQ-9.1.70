package l14;

import android.content.SharedPreferences;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
class g {

    /* renamed from: a, reason: collision with root package name */
    private final String f413682a;

    /* renamed from: b, reason: collision with root package name */
    private final String f413683b;

    /* renamed from: c, reason: collision with root package name */
    private long f413684c;

    /* renamed from: d, reason: collision with root package name */
    private long f413685d;

    /* renamed from: e, reason: collision with root package name */
    private long f413686e;

    public g(String str, String str2) {
        this.f413684c = 0L;
        this.f413685d = 0L;
        this.f413686e = 0L;
        this.f413682a = str;
        this.f413683b = str2;
    }

    private String b() {
        return this.f413682a + "max_java_heap_" + this.f413683b;
    }

    private String d() {
        return this.f413682a + "max_pss_" + this.f413683b;
    }

    private String f() {
        return this.f413682a + "max_vss_" + this.f413683b;
    }

    public long a() {
        return this.f413686e;
    }

    public long c() {
        return this.f413684c;
    }

    public long e() {
        return this.f413685d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f413684c == gVar.f413684c && this.f413685d == gVar.f413685d && this.f413686e == gVar.f413686e && TextUtils.equals(this.f413682a, gVar.f413682a) && TextUtils.equals(this.f413683b, gVar.f413683b)) {
            return true;
        }
        return false;
    }

    public void g(long j3, long j16, long j17) {
        this.f413684c = j3;
        this.f413685d = j16;
        this.f413686e = j17;
    }

    public boolean h() {
        if (this.f413684c > 0 && this.f413685d > 0 && this.f413686e > 0) {
            return true;
        }
        return false;
    }

    public void i(SharedPreferences sharedPreferences) {
        this.f413684c = sharedPreferences.getLong(d(), 0L);
        this.f413685d = sharedPreferences.getLong(f(), 0L);
        this.f413686e = sharedPreferences.getLong(b(), 0L);
    }

    public void j(JSONObject jSONObject) throws JSONException {
        jSONObject.put(this.f413682a + "pss", this.f413684c);
        jSONObject.put(this.f413682a + "vss", this.f413685d);
        jSONObject.put(this.f413682a + "java_heap", this.f413686e);
    }

    public void k(SharedPreferences.Editor editor) {
        editor.putLong(d(), this.f413684c);
        editor.putLong(f(), this.f413685d);
        editor.putLong(b(), this.f413686e);
    }

    public void l(SharedPreferences.Editor editor, long j3, long j16, long j17) {
        if (j3 > this.f413684c) {
            this.f413684c = j3;
            editor.putLong(d(), this.f413684c);
        }
        if (j16 > this.f413685d) {
            this.f413685d = j16;
            editor.putLong(f(), this.f413685d);
        }
        if (j17 > this.f413686e) {
            this.f413686e = j17;
            editor.putLong(b(), this.f413686e);
        }
    }

    public g(g gVar) {
        this.f413684c = 0L;
        this.f413685d = 0L;
        this.f413686e = 0L;
        this.f413682a = gVar.f413682a;
        this.f413683b = gVar.f413683b;
        this.f413684c = gVar.f413684c;
        this.f413685d = gVar.f413685d;
        this.f413686e = gVar.f413686e;
    }
}
