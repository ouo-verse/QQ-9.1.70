package no0;

import androidx.collection.ArraySet;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes6.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private final Set<ye1.a> f420570a = new ArraySet();

    public void a(Collection<? extends ye1.a> collection) {
        if (collection != null) {
            this.f420570a.addAll(collection);
        }
    }

    public void b(ye1.a aVar) {
        if (aVar != null) {
            this.f420570a.add(aVar);
        }
    }

    public void c(Set<IGProUserInfo> set) {
        if (!this.f420570a.isEmpty()) {
            Iterator<E> it = new ArraySet(this.f420570a).iterator();
            while (it.hasNext()) {
                ((ye1.a) it.next()).a(set);
            }
        }
    }

    public void d(boolean z16, String str, IGProUserInfo iGProUserInfo, int i3, int i16) {
        if (!this.f420570a.isEmpty()) {
            Iterator<E> it = new ArraySet(this.f420570a).iterator();
            while (it.hasNext()) {
                ((ye1.a) it.next()).e(z16, str, iGProUserInfo, i3, i16);
            }
        }
    }

    public void e(boolean z16) {
        if (!this.f420570a.isEmpty()) {
            Iterator<E> it = new ArraySet(this.f420570a).iterator();
            while (it.hasNext()) {
                ((ye1.a) it.next()).g(z16);
            }
        }
    }

    public void f(boolean z16, int i3, List<IGProUserInfo> list) {
        if (!this.f420570a.isEmpty()) {
            Iterator<E> it = new ArraySet(this.f420570a).iterator();
            while (it.hasNext()) {
                ((ye1.a) it.next()).d(z16, i3, list);
            }
        }
    }

    public void g() {
        if (!this.f420570a.isEmpty()) {
            Iterator<E> it = new ArraySet(this.f420570a).iterator();
            while (it.hasNext()) {
                ((ye1.a) it.next()).f();
            }
        }
    }

    public void h() {
        if (!this.f420570a.isEmpty()) {
            Iterator<E> it = new ArraySet(this.f420570a).iterator();
            while (it.hasNext()) {
                ((ye1.a) it.next()).b();
            }
        }
    }

    public void i() {
        this.f420570a.clear();
    }
}
