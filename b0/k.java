package b0;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: P */
/* loaded from: classes.dex */
public final class k implements f {

    /* renamed from: d, reason: collision with root package name */
    private final Set<e0.h<?>> f27607d = Collections.newSetFromMap(new WeakHashMap());

    public void d() {
        this.f27607d.clear();
    }

    @NonNull
    public List<e0.h<?>> i() {
        return h0.k.i(this.f27607d);
    }

    public void j(@NonNull e0.h<?> hVar) {
        this.f27607d.add(hVar);
    }

    public void k(@NonNull e0.h<?> hVar) {
        this.f27607d.remove(hVar);
    }

    @Override // b0.f
    public void onDestroy() {
        Iterator it = h0.k.i(this.f27607d).iterator();
        while (it.hasNext()) {
            ((e0.h) it.next()).onDestroy();
        }
    }

    @Override // b0.f
    public void onStart() {
        Iterator it = h0.k.i(this.f27607d).iterator();
        while (it.hasNext()) {
            ((e0.h) it.next()).onStart();
        }
    }

    @Override // b0.f
    public void onStop() {
        Iterator it = h0.k.i(this.f27607d).iterator();
        while (it.hasNext()) {
            ((e0.h) it.next()).onStop();
        }
    }
}
