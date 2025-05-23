package h0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private Class<?> f403962a;

    /* renamed from: b, reason: collision with root package name */
    private Class<?> f403963b;

    /* renamed from: c, reason: collision with root package name */
    private Class<?> f403964c;

    public i() {
    }

    public void a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        this.f403962a = cls;
        this.f403963b = cls2;
        this.f403964c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (this.f403962a.equals(iVar.f403962a) && this.f403963b.equals(iVar.f403963b) && k.c(this.f403964c, iVar.f403964c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int hashCode = ((this.f403962a.hashCode() * 31) + this.f403963b.hashCode()) * 31;
        Class<?> cls = this.f403964c;
        if (cls != null) {
            i3 = cls.hashCode();
        } else {
            i3 = 0;
        }
        return hashCode + i3;
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f403962a + ", second=" + this.f403963b + '}';
    }

    public i(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        a(cls, cls2, cls3);
    }
}
