package c10;

import UserGrowth.stCollection;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final stCollection f30230a;

    /* renamed from: b, reason: collision with root package name */
    private final int f30231b;

    public a(stCollection stcollection, int i3) {
        this.f30230a = stcollection;
        this.f30231b = i3;
    }

    public String a() {
        stCollection stcollection = this.f30230a;
        if (stcollection != null) {
            return stcollection.cover;
        }
        return "";
    }

    public stCollection b() {
        return this.f30230a;
    }

    public String c() {
        stCollection stcollection = this.f30230a;
        if (stcollection != null) {
            return stcollection.subTitle;
        }
        return "";
    }

    public String d() {
        stCollection stcollection = this.f30230a;
        if (stcollection != null) {
            return stcollection.name;
        }
        return "";
    }
}
