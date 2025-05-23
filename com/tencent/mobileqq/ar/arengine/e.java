package com.tencent.mobileqq.ar.arengine;

/* compiled from: P */
/* loaded from: classes11.dex */
public abstract class e extends n {

    /* renamed from: c, reason: collision with root package name */
    private int f198172c;

    /* renamed from: d, reason: collision with root package name */
    private int f198173d;

    public e(int i3, int i16) {
        this(i3, i16, 5);
    }

    public static boolean c(e eVar) {
        if (eVar != null && eVar.b()) {
            return true;
        }
        return false;
    }

    public abstract boolean b();

    public e(int i3, int i16, int i17) {
        this.f198172c = i3;
        this.f198173d = i16;
    }
}
