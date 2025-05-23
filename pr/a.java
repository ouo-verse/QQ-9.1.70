package pr;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f427044a = -1;

    /* renamed from: b, reason: collision with root package name */
    private int f427045b;

    /* renamed from: c, reason: collision with root package name */
    private String f427046c;

    /* renamed from: d, reason: collision with root package name */
    private String f427047d;

    /* renamed from: e, reason: collision with root package name */
    private int f427048e;

    /* renamed from: f, reason: collision with root package name */
    private int f427049f;

    /* renamed from: g, reason: collision with root package name */
    private int f427050g;

    a(int i3, String str) {
        this.f427045b = i3;
        this.f427046c = str;
    }

    public static a i(String str) {
        return new a(0, str);
    }

    public static a j(String str) {
        return new a(1, str);
    }

    public int a() {
        return this.f427050g;
    }

    public int b() {
        return this.f427049f;
    }

    public String c() {
        return this.f427046c;
    }

    public int d() {
        return this.f427044a;
    }

    public String e() {
        return this.f427047d;
    }

    public int f() {
        return this.f427048e;
    }

    public boolean g() {
        return this.f427045b == 0;
    }

    public boolean h() {
        return this.f427045b == 1;
    }

    public a k(int i3) {
        this.f427050g = i3;
        return this;
    }

    public a l(int i3) {
        this.f427044a = i3;
        return this;
    }

    public a m(int i3, int i16) {
        this.f427048e = i3;
        this.f427049f = i16;
        return this;
    }

    public a n(String str) {
        this.f427047d = str;
        return this;
    }

    public String toString() {
        return "[type : " + this.f427045b + ", path : " + this.f427046c + ", requestCode : " + this.f427044a + ", thumbPath : " + this.f427047d + ", width : " + this.f427048e + ", height : " + this.f427049f + ", duration: " + this.f427050g + "]";
    }
}
