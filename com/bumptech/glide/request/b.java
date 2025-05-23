package com.bumptech.glide.request;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.RequestCoordinator;

/* compiled from: P */
/* loaded from: classes.dex */
public final class b implements RequestCoordinator, c {

    /* renamed from: a, reason: collision with root package name */
    private final Object f31923a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final RequestCoordinator f31924b;

    /* renamed from: c, reason: collision with root package name */
    private volatile c f31925c;

    /* renamed from: d, reason: collision with root package name */
    private volatile c f31926d;

    /* renamed from: e, reason: collision with root package name */
    @GuardedBy("requestLock")
    private RequestCoordinator.RequestState f31927e;

    /* renamed from: f, reason: collision with root package name */
    @GuardedBy("requestLock")
    private RequestCoordinator.RequestState f31928f;

    public b(Object obj, @Nullable RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.f31927e = requestState;
        this.f31928f = requestState;
        this.f31923a = obj;
        this.f31924b = requestCoordinator;
    }

    @GuardedBy("requestLock")
    private boolean g(c cVar) {
        if (!cVar.equals(this.f31925c) && (this.f31927e != RequestCoordinator.RequestState.FAILED || !cVar.equals(this.f31926d))) {
            return false;
        }
        return true;
    }

    @GuardedBy("requestLock")
    private boolean h() {
        RequestCoordinator requestCoordinator = this.f31924b;
        if (requestCoordinator != null && !requestCoordinator.e(this)) {
            return false;
        }
        return true;
    }

    @GuardedBy("requestLock")
    private boolean i() {
        RequestCoordinator requestCoordinator = this.f31924b;
        if (requestCoordinator != null && !requestCoordinator.d(this)) {
            return false;
        }
        return true;
    }

    @GuardedBy("requestLock")
    private boolean j() {
        RequestCoordinator requestCoordinator = this.f31924b;
        if (requestCoordinator != null && !requestCoordinator.b(this)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void a(c cVar) {
        synchronized (this.f31923a) {
            if (cVar.equals(this.f31925c)) {
                this.f31927e = RequestCoordinator.RequestState.SUCCESS;
            } else if (cVar.equals(this.f31926d)) {
                this.f31928f = RequestCoordinator.RequestState.SUCCESS;
            }
            RequestCoordinator requestCoordinator = this.f31924b;
            if (requestCoordinator != null) {
                requestCoordinator.a(this);
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean b(c cVar) {
        boolean z16;
        synchronized (this.f31923a) {
            if (j() && g(cVar)) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    @Override // com.bumptech.glide.request.c
    public void begin() {
        synchronized (this.f31923a) {
            RequestCoordinator.RequestState requestState = this.f31927e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
            if (requestState != requestState2) {
                this.f31927e = requestState2;
                this.f31925c.begin();
            }
        }
    }

    @Override // com.bumptech.glide.request.c
    public boolean c(c cVar) {
        if (!(cVar instanceof b)) {
            return false;
        }
        b bVar = (b) cVar;
        if (!this.f31925c.c(bVar.f31925c) || !this.f31926d.c(bVar.f31926d)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.request.c
    public void clear() {
        synchronized (this.f31923a) {
            RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
            this.f31927e = requestState;
            this.f31925c.clear();
            if (this.f31928f != requestState) {
                this.f31928f = requestState;
                this.f31926d.clear();
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean d(c cVar) {
        boolean z16;
        synchronized (this.f31923a) {
            if (i() && g(cVar)) {
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
        synchronized (this.f31923a) {
            if (h() && g(cVar)) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void f(c cVar) {
        synchronized (this.f31923a) {
            if (!cVar.equals(this.f31926d)) {
                this.f31927e = RequestCoordinator.RequestState.FAILED;
                RequestCoordinator.RequestState requestState = this.f31928f;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState != requestState2) {
                    this.f31928f = requestState2;
                    this.f31926d.begin();
                }
                return;
            }
            this.f31928f = RequestCoordinator.RequestState.FAILED;
            RequestCoordinator requestCoordinator = this.f31924b;
            if (requestCoordinator != null) {
                requestCoordinator.f(this);
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public RequestCoordinator getRoot() {
        RequestCoordinator requestCoordinator;
        synchronized (this.f31923a) {
            RequestCoordinator requestCoordinator2 = this.f31924b;
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
        synchronized (this.f31923a) {
            if (!this.f31925c.isAnyResourceSet() && !this.f31926d.isAnyResourceSet()) {
                z16 = false;
            }
            z16 = true;
        }
        return z16;
    }

    @Override // com.bumptech.glide.request.c
    public boolean isCleared() {
        boolean z16;
        synchronized (this.f31923a) {
            RequestCoordinator.RequestState requestState = this.f31927e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.CLEARED;
            if (requestState == requestState2 && this.f31928f == requestState2) {
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
        synchronized (this.f31923a) {
            RequestCoordinator.RequestState requestState = this.f31927e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.SUCCESS;
            if (requestState != requestState2 && this.f31928f != requestState2) {
                z16 = false;
            }
            z16 = true;
        }
        return z16;
    }

    @Override // com.bumptech.glide.request.c
    public boolean isRunning() {
        boolean z16;
        synchronized (this.f31923a) {
            RequestCoordinator.RequestState requestState = this.f31927e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
            if (requestState != requestState2 && this.f31928f != requestState2) {
                z16 = false;
            }
            z16 = true;
        }
        return z16;
    }

    public void k(c cVar, c cVar2) {
        this.f31925c = cVar;
        this.f31926d = cVar2;
    }

    @Override // com.bumptech.glide.request.c
    public void pause() {
        synchronized (this.f31923a) {
            RequestCoordinator.RequestState requestState = this.f31927e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
            if (requestState == requestState2) {
                this.f31927e = RequestCoordinator.RequestState.PAUSED;
                this.f31925c.pause();
            }
            if (this.f31928f == requestState2) {
                this.f31928f = RequestCoordinator.RequestState.PAUSED;
                this.f31926d.pause();
            }
        }
    }
}
