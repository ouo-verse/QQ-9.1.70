package dw;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e extends b {

    /* renamed from: f, reason: collision with root package name */
    boolean f395075f;

    /* renamed from: g, reason: collision with root package name */
    boolean f395076g;

    public e(int i3, int i16, int i17, int i18, String str, boolean z16) {
        super(i3, i16, i17, i18, str);
        this.f395076g = false;
        this.f395075f = z16;
    }

    @Override // dw.b
    public int h() {
        return 2;
    }

    public boolean k() {
        return this.f395076g;
    }

    public boolean l() {
        return this.f395075f;
    }

    public void m(boolean z16) {
        this.f395076g = z16;
    }
}
