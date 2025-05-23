package com.bumptech.glide.request;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.RequestCoordinator;

/* compiled from: P */
/* loaded from: classes.dex */
public class g implements RequestCoordinator, c {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final RequestCoordinator f31929a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f31930b;

    /* renamed from: c, reason: collision with root package name */
    private volatile c f31931c;

    /* renamed from: d, reason: collision with root package name */
    private volatile c f31932d;

    /* renamed from: e, reason: collision with root package name */
    @GuardedBy("requestLock")
    private RequestCoordinator.RequestState f31933e;

    /* renamed from: f, reason: collision with root package name */
    @GuardedBy("requestLock")
    private RequestCoordinator.RequestState f31934f;

    /* renamed from: g, reason: collision with root package name */
    @GuardedBy("requestLock")
    private boolean f31935g;

    public g(Object obj, @Nullable RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.f31933e = requestState;
        this.f31934f = requestState;
        this.f31930b = obj;
        this.f31929a = requestCoordinator;
    }

    @GuardedBy("requestLock")
    private boolean g() {
        RequestCoordinator requestCoordinator = this.f31929a;
        if (requestCoordinator != null && !requestCoordinator.e(this)) {
            return false;
        }
        return true;
    }

    @GuardedBy("requestLock")
    private boolean h() {
        RequestCoordinator requestCoordinator = this.f31929a;
        if (requestCoordinator != null && !requestCoordinator.d(this)) {
            return false;
        }
        return true;
    }

    @GuardedBy("requestLock")
    private boolean i() {
        RequestCoordinator requestCoordinator = this.f31929a;
        if (requestCoordinator != null && !requestCoordinator.b(this)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void a(c cVar) {
        synchronized (this.f31930b) {
            if (cVar.equals(this.f31932d)) {
                this.f31934f = RequestCoordinator.RequestState.SUCCESS;
                return;
            }
            this.f31933e = RequestCoordinator.RequestState.SUCCESS;
            RequestCoordinator requestCoordinator = this.f31929a;
            if (requestCoordinator != null) {
                requestCoordinator.a(this);
            }
            if (!this.f31934f.isComplete()) {
                this.f31932d.clear();
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean b(c cVar) {
        boolean z16;
        synchronized (this.f31930b) {
            if (i() && (cVar.equals(this.f31931c) || this.f31933e != RequestCoordinator.RequestState.SUCCESS)) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    @Override // com.bumptech.glide.request.c
    public void begin() {
        synchronized (this.f31930b) {
            this.f31935g = true;
            try {
                if (this.f31933e != RequestCoordinator.RequestState.SUCCESS) {
                    RequestCoordinator.RequestState requestState = this.f31934f;
                    RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                    if (requestState != requestState2) {
                        this.f31934f = requestState2;
                        this.f31932d.begin();
                    }
                }
                if (this.f31935g) {
                    RequestCoordinator.RequestState requestState3 = this.f31933e;
                    RequestCoordinator.RequestState requestState4 = RequestCoordinator.RequestState.RUNNING;
                    if (requestState3 != requestState4) {
                        this.f31933e = requestState4;
                        this.f31931c.begin();
                    }
                }
            } finally {
                this.f31935g = false;
            }
        }
    }

    @Override // com.bumptech.glide.request.c
    public boolean c(c cVar) {
        if (!(cVar instanceof g)) {
            return false;
        }
        g gVar = (g) cVar;
        if (this.f31931c == null) {
            if (gVar.f31931c != null) {
                return false;
            }
        } else if (!this.f31931c.c(gVar.f31931c)) {
            return false;
        }
        if (this.f31932d == null) {
            if (gVar.f31932d != null) {
                return false;
            }
        } else if (!this.f31932d.c(gVar.f31932d)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.request.c
    public void clear() {
        synchronized (this.f31930b) {
            this.f31935g = false;
            RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
            this.f31933e = requestState;
            this.f31934f = requestState;
            this.f31932d.clear();
            this.f31931c.clear();
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean d(c cVar) {
        boolean z16;
        synchronized (this.f31930b) {
            if (h() && cVar.equals(this.f31931c) && !isAnyResourceSet()) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean e(c cVar) {
        boolean z16;
        synchronized (this.f31930b) {
            if (g() && cVar.equals(this.f31931c) && this.f31933e != RequestCoordinator.RequestState.PAUSED) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void f(c cVar) {
        synchronized (this.f31930b) {
            if (!cVar.equals(this.f31931c)) {
                this.f31934f = RequestCoordinator.RequestState.FAILED;
                return;
            }
            this.f31933e = RequestCoordinator.RequestState.FAILED;
            RequestCoordinator requestCoordinator = this.f31929a;
            if (requestCoordinator != null) {
                requestCoordinator.f(this);
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public RequestCoordinator getRoot() {
        RequestCoordinator requestCoordinator;
        synchronized (this.f31930b) {
            RequestCoordinator requestCoordinator2 = this.f31929a;
            if (requestCoordinator2 != null) {
                requestCoordinator = requestCoordinator2.getRoot();
            } else {
                requestCoordinator = this;
            }
        }
        return requestCoordinator;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator, com.bumptech.glide.request.c
    public boolean isAnyResourceSet() {
        boolean z16;
        synchronized (this.f31930b) {
            if (!this.f31932d.isAnyResourceSet() && !this.f31931c.isAnyResourceSet()) {
                z16 = false;
            }
            z16 = true;
        }
        return z16;
    }

    @Override // com.bumptech.glide.request.c
    public boolean isCleared() {
        boolean z16;
        synchronized (this.f31930b) {
            if (this.f31933e == RequestCoordinator.RequestState.CLEARED) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    @Override // com.bumptech.glide.request.c
    public boolean isComplete() {
        boolean z16;
        synchronized (this.f31930b) {
            if (this.f31933e == RequestCoordinator.RequestState.SUCCESS) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    @Override // com.bumptech.glide.request.c
    public boolean isRunning() {
        boolean z16;
        synchronized (this.f31930b) {
            if (this.f31933e == RequestCoordinator.RequestState.RUNNING) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    public void j(c cVar, c cVar2) {
        this.f31931c = cVar;
        this.f31932d = cVar2;
    }

    @Override // com.bumptech.glide.request.c
    public void pause() {
        synchronized (this.f31930b) {
            if (!this.f31934f.isComplete()) {
                this.f31934f = RequestCoordinator.RequestState.PAUSED;
                this.f31932d.pause();
            }
            if (!this.f31933e.isComplete()) {
                this.f31933e = RequestCoordinator.RequestState.PAUSED;
                this.f31931c.pause();
            }
        }
    }
}
