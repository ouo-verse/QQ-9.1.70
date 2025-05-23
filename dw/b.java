package dw;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    protected int f395058a;

    /* renamed from: b, reason: collision with root package name */
    protected int f395059b;

    /* renamed from: c, reason: collision with root package name */
    protected int f395060c;

    /* renamed from: d, reason: collision with root package name */
    protected int f395061d;

    /* renamed from: e, reason: collision with root package name */
    protected String f395062e;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(int i3, int i16, int i17, int i18, String str) {
        this.f395058a = i3;
        this.f395060c = i16;
        this.f395059b = i17;
        this.f395061d = i18;
        this.f395062e = str;
    }

    public static boolean a(b bVar, b bVar2) {
        if (bVar2 == null) {
            return false;
        }
        if (bVar == null) {
            return true;
        }
        int d16 = bVar2.d();
        int d17 = bVar.d();
        ju.a.t("CheckAvTipsItemLevelCanShow, lvNew[" + d16 + "], lvOld[" + d17 + "], idNew[" + bVar2.c() + "], idOld[" + bVar.c() + "]");
        if (d16 < d17) {
            return true;
        }
        if (d16 > d17) {
            return false;
        }
        if (bVar.b()) {
            return true;
        }
        if (bVar2.b() || bVar2.e() > bVar.e()) {
            return false;
        }
        return true;
    }

    public boolean b() {
        if (this.f395059b == 0) {
            return true;
        }
        return false;
    }

    public int c() {
        return this.f395058a;
    }

    public int d() {
        return this.f395060c;
    }

    public int e() {
        return this.f395059b;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof b) || c() != ((b) obj).c()) {
            return false;
        }
        return true;
    }

    public int f() {
        return this.f395061d;
    }

    public String g() {
        return this.f395062e;
    }

    public abstract int h();

    public void i(int i3) {
        this.f395059b = i3;
    }

    public void j(String str) {
        if (str != null) {
            this.f395062e = str;
        }
    }
}
