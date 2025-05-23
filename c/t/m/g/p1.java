package c.t.m.g;

import android.os.Bundle;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class p1 {

    /* renamed from: a, reason: collision with root package name */
    public String f29923a;

    /* renamed from: b, reason: collision with root package name */
    public String f29924b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f29925c = true;

    public p1(String str, String str2) {
        this.f29923a = str;
        this.f29924b = str2;
    }

    public void a() {
    }

    public abstract boolean b(Bundle bundle);

    public String toString() {
        return "[name=" + this.f29923a + ",desc=" + this.f29924b + ",enabled=" + this.f29925c + "]";
    }

    public boolean a(Bundle bundle) {
        if (this.f29925c) {
            return b(bundle);
        }
        return false;
    }
}
