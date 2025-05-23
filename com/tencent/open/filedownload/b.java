package com.tencent.open.filedownload;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {

    /* renamed from: e, reason: collision with root package name */
    public String f341566e;

    /* renamed from: f, reason: collision with root package name */
    public String f341567f;

    /* renamed from: g, reason: collision with root package name */
    public String f341568g;

    /* renamed from: h, reason: collision with root package name */
    public long f341569h;

    /* renamed from: i, reason: collision with root package name */
    public String f341570i;

    /* renamed from: j, reason: collision with root package name */
    public int f341571j;

    /* renamed from: a, reason: collision with root package name */
    public String f341562a = "6000";

    /* renamed from: b, reason: collision with root package name */
    public String f341563b = "0";

    /* renamed from: c, reason: collision with root package name */
    public String f341564c = "0";

    /* renamed from: d, reason: collision with root package name */
    public String f341565d = "default_via";

    /* renamed from: k, reason: collision with root package name */
    public int f341572k = 1;

    public static b a(b bVar) {
        b bVar2 = new b();
        if (bVar == null) {
            return bVar2;
        }
        bVar2.f341566e = bVar.f341566e;
        bVar2.f341567f = bVar.f341567f;
        bVar2.f341568g = bVar.f341568g;
        bVar2.f341569h = bVar.f341569h;
        bVar2.f341570i = bVar.f341570i;
        bVar2.f341571j = bVar.f341571j;
        bVar2.f341572k = bVar.f341572k;
        bVar2.f341564c = bVar.f341564c;
        bVar2.f341563b = bVar.f341563b;
        bVar2.f341562a = bVar.f341562a;
        bVar2.f341565d = bVar.f341565d;
        return bVar2;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("pageId=" + this.f341562a);
        sb5.append("\nmoduleId=" + this.f341563b);
        sb5.append("\npositionId=" + this.f341564c);
        sb5.append("\nvia=" + this.f341565d);
        sb5.append("\nurl=" + this.f341566e);
        sb5.append("\npackageName=" + this.f341567f);
        sb5.append("\niconUrl=" + this.f341568g);
        sb5.append("\nlength=" + this.f341569h);
        sb5.append("\nname=" + this.f341570i);
        sb5.append("\nprogress=" + this.f341571j);
        sb5.append("\nstate=" + this.f341572k);
        return sb5.toString();
    }
}
