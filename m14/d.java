package m14;

import com.tencent.rmonitor.base.plugin.listener.IBaseListener;

/* compiled from: P */
/* loaded from: classes25.dex */
public class d<T extends IBaseListener> implements b {

    /* renamed from: a, reason: collision with root package name */
    private final Class<T> f416007a;

    /* renamed from: b, reason: collision with root package name */
    private final i04.b<T> f416008b;

    public d(Class<T> cls, i04.b<T> bVar) {
        this.f416007a = cls;
        this.f416008b = bVar;
    }

    @Override // m14.b
    public boolean a(Object obj) {
        if (this.f416007a.isInstance(obj)) {
            this.f416008b.a(this.f416007a.cast(obj));
            return true;
        }
        return false;
    }

    @Override // m14.b
    public boolean b(Object obj) {
        if (this.f416007a.isInstance(obj)) {
            this.f416008b.e(this.f416007a.cast(obj));
            return true;
        }
        return false;
    }
}
