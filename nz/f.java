package nz;

import UserGrowth.stDramaFeed;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;

/* compiled from: P */
/* loaded from: classes38.dex */
public class f implements lz.a {

    /* renamed from: a, reason: collision with root package name */
    private stDramaFeed f421609a;

    /* renamed from: b, reason: collision with root package name */
    private String f421610b;

    /* renamed from: c, reason: collision with root package name */
    private String f421611c;

    /* renamed from: d, reason: collision with root package name */
    private int f421612d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f421613e;

    public String a() {
        return this.f421610b;
    }

    public int b() {
        return this.f421612d;
    }

    public String c() {
        stSimpleMetaFeed stsimplemetafeed;
        stSimpleMetaPerson stsimplemetaperson;
        stDramaFeed stdramafeed = this.f421609a;
        if (stdramafeed != null && (stsimplemetafeed = stdramafeed.feed) != null && (stsimplemetaperson = stsimplemetafeed.poster) != null) {
            return stsimplemetaperson.f25130id;
        }
        return "";
    }

    public void d(String str) {
        this.f421611c = str;
    }

    public void e(String str) {
        this.f421610b = str;
    }

    public void f(int i3) {
        this.f421612d = i3;
    }

    @Override // lz.a
    public boolean isChecked() {
        return this.f421613e;
    }

    @Override // lz.a
    public void setChecked(boolean z16) {
        this.f421613e = z16;
    }
}
