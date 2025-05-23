package l;

/* compiled from: P */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private String f413544a;

    /* renamed from: b, reason: collision with root package name */
    private String f413545b;

    /* renamed from: c, reason: collision with root package name */
    private int f413546c;

    /* renamed from: d, reason: collision with root package name */
    private String f413547d;

    /* renamed from: e, reason: collision with root package name */
    private String f413548e;

    public c(String str, String str2, String str3, int i3, String str4) {
        this.f413544a = str;
        this.f413545b = str2;
        this.f413547d = str3;
        this.f413546c = i3;
        this.f413548e = str4;
    }

    public String a() {
        return this.f413545b;
    }

    public String b() {
        return this.f413547d;
    }

    public String c() {
        return this.f413548e;
    }

    public String d() {
        return this.f413544a;
    }

    public int e() {
        return this.f413546c;
    }

    public String toString() {
        return "WParams{orgID='" + this.f413544a + "', appID='" + this.f413545b + "', type=" + this.f413546c + ", bizSeq='" + this.f413547d + "'}";
    }

    public c(String str, String str2, String str3, int i3) {
        this(str, str2, str3, i3, null);
    }
}
