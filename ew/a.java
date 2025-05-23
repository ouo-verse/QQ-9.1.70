package ew;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f397247a;

    /* renamed from: b, reason: collision with root package name */
    public final String f397248b;

    /* renamed from: c, reason: collision with root package name */
    public final String f397249c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f397250d;

    /* renamed from: e, reason: collision with root package name */
    public int f397251e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f397252f = 0;

    public a(int i3, String str, String str2, boolean z16) {
        this.f397247a = i3;
        this.f397248b = str;
        this.f397249c = str2;
        this.f397250d = z16;
    }

    public void a(int i3, int i16) {
        this.f397252f = i16;
        this.f397251e = i3;
    }

    public String toString() {
        return "{uinType: " + this.f397247a + ", uin: " + this.f397248b + ", extraUin: " + this.f397249c + ", isRound: " + this.f397250d + "}";
    }
}
