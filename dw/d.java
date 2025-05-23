package dw;

import android.graphics.drawable.Drawable;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d extends b {

    /* renamed from: f, reason: collision with root package name */
    protected String f395071f;

    /* renamed from: g, reason: collision with root package name */
    protected int f395072g;

    /* renamed from: h, reason: collision with root package name */
    protected Drawable f395073h;

    /* renamed from: i, reason: collision with root package name */
    protected int f395074i;

    public d(int i3, int i16, int i17, int i18, String str) {
        super(i3, i16, i17, i18, str);
        this.f395071f = null;
        this.f395072g = 0;
        this.f395074i = -1;
    }

    @Override // dw.b
    public int h() {
        return 1;
    }

    public Drawable k() {
        return this.f395073h;
    }

    public int l() {
        return this.f395072g;
    }

    public String m() {
        return this.f395071f;
    }

    public int n() {
        return this.f395074i;
    }

    public void o(Drawable drawable) {
        this.f395073h = drawable;
    }

    public void p(int i3) {
        this.f395072g = i3;
    }

    public d(int i3, int i16, int i17, int i18, String str, int i19, String str2) {
        super(i3, i16, i17, i18, str);
        this.f395074i = -1;
        this.f395071f = str2;
        this.f395072g = i19;
    }

    public d(int i3, int i16, int i17, int i18, String str, int i19, int i26) {
        super(i3, i16, i17, i18, str);
        this.f395071f = null;
        this.f395074i = i26;
        this.f395072g = i19;
    }
}
