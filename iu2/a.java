package iu2;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f408755a;

    /* renamed from: b, reason: collision with root package name */
    private String f408756b;

    /* renamed from: c, reason: collision with root package name */
    private int f408757c;

    public a(int i3, String str) {
        this.f408755a = i3;
        this.f408756b = str;
    }

    public int a() {
        return this.f408755a;
    }

    public int b() {
        return this.f408757c;
    }

    public String c() {
        return this.f408756b;
    }

    public boolean d() {
        int a16 = a();
        if (a16 == 113 || a16 == 300 || a16 == 502 || a16 == 220 || a16 == 221 || a16 == 504 || a16 == 505) {
            return false;
        }
        switch (a16) {
            case 201:
            case 202:
            case 203:
            case 204:
            case 205:
                return false;
            default:
                switch (a16) {
                    case 401:
                    case 402:
                    case 403:
                        return false;
                    default:
                        return true;
                }
        }
    }

    public void e(int i3) {
        this.f408757c = i3;
    }

    public String toString() {
        return this.f408755a + "-" + this.f408756b;
    }

    public a(int i3, String str, int i16) {
        this(i3, str);
        this.f408757c = i16;
    }
}
