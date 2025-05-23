package b0;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: P */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private final Set<com.bumptech.glide.request.c> f27604a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b, reason: collision with root package name */
    private final List<com.bumptech.glide.request.c> f27605b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private boolean f27606c;

    public boolean a(@Nullable com.bumptech.glide.request.c cVar) {
        boolean z16 = true;
        if (cVar == null) {
            return true;
        }
        boolean remove = this.f27604a.remove(cVar);
        if (!this.f27605b.remove(cVar) && !remove) {
            z16 = false;
        }
        if (z16) {
            cVar.clear();
        }
        return z16;
    }

    public void b() {
        Iterator it = h0.k.i(this.f27604a).iterator();
        while (it.hasNext()) {
            a((com.bumptech.glide.request.c) it.next());
        }
        this.f27605b.clear();
    }

    public void c() {
        this.f27606c = true;
        for (com.bumptech.glide.request.c cVar : h0.k.i(this.f27604a)) {
            if (cVar.isRunning() || cVar.isComplete()) {
                cVar.clear();
                this.f27605b.add(cVar);
            }
        }
    }

    public void d() {
        this.f27606c = true;
        for (com.bumptech.glide.request.c cVar : h0.k.i(this.f27604a)) {
            if (cVar.isRunning()) {
                cVar.pause();
                this.f27605b.add(cVar);
            }
        }
    }

    public void e() {
        for (com.bumptech.glide.request.c cVar : h0.k.i(this.f27604a)) {
            if (!cVar.isComplete() && !cVar.isCleared()) {
                cVar.clear();
                if (!this.f27606c) {
                    cVar.begin();
                } else {
                    this.f27605b.add(cVar);
                }
            }
        }
    }

    public void f() {
        this.f27606c = false;
        for (com.bumptech.glide.request.c cVar : h0.k.i(this.f27604a)) {
            if (!cVar.isComplete() && !cVar.isRunning()) {
                cVar.begin();
            }
        }
        this.f27605b.clear();
    }

    public void g(@NonNull com.bumptech.glide.request.c cVar) {
        this.f27604a.add(cVar);
        if (!this.f27606c) {
            cVar.begin();
            return;
        }
        cVar.clear();
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.f27605b.add(cVar);
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f27604a.size() + ", isPaused=" + this.f27606c + "}";
    }
}
