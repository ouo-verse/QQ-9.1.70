package ly1;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    public static b f415774c = new b(0, "\u4e0d\u63d0\u9192");

    /* renamed from: d, reason: collision with root package name */
    public static b f415775d = new b(1, "\u65e5\u7a0b\u5f00\u59cb\u65f6");

    /* renamed from: e, reason: collision with root package name */
    public static b f415776e = new b(2, "5\u5206\u949f\u524d");

    /* renamed from: f, reason: collision with root package name */
    public static b f415777f = new b(3, "15\u5206\u949f\u524d");

    /* renamed from: g, reason: collision with root package name */
    public static b f415778g = new b(4, "30\u5206\u949f\u524d");

    /* renamed from: h, reason: collision with root package name */
    public static b f415779h = new b(5, "1\u5c0f\u65f6\u524d");

    /* renamed from: a, reason: collision with root package name */
    private int f415780a;

    /* renamed from: b, reason: collision with root package name */
    private String f415781b;

    public b(int i3, String str) {
        this.f415780a = i3;
        this.f415781b = str;
    }

    public static b a(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                return null;
                            }
                            return f415779h;
                        }
                        return f415778g;
                    }
                    return f415777f;
                }
                return f415776e;
            }
            return f415775d;
        }
        return f415774c;
    }

    public String b() {
        return this.f415781b;
    }

    public int c() {
        return this.f415780a;
    }
}
