package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import h0.k;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: P */
/* loaded from: classes.dex */
class a implements b0.e {

    /* renamed from: a, reason: collision with root package name */
    private final Set<b0.f> f31875a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b, reason: collision with root package name */
    private boolean f31876b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f31877c;

    @Override // b0.e
    public void a(@NonNull b0.f fVar) {
        this.f31875a.remove(fVar);
    }

    @Override // b0.e
    public void b(@NonNull b0.f fVar) {
        this.f31875a.add(fVar);
        if (this.f31877c) {
            fVar.onDestroy();
        } else if (this.f31876b) {
            fVar.onStart();
        } else {
            fVar.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f31877c = true;
        Iterator it = k.i(this.f31875a).iterator();
        while (it.hasNext()) {
            ((b0.f) it.next()).onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        this.f31876b = true;
        Iterator it = k.i(this.f31875a).iterator();
        while (it.hasNext()) {
            ((b0.f) it.next()).onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        this.f31876b = false;
        Iterator it = k.i(this.f31875a).iterator();
        while (it.hasNext()) {
            ((b0.f) it.next()).onStop();
        }
    }
}
