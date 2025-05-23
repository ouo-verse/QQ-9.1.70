package com.bumptech.glide.request;

/* compiled from: P */
/* loaded from: classes.dex */
public interface RequestCoordinator {

    /* compiled from: P */
    /* loaded from: classes.dex */
    public enum RequestState {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);

        private final boolean isComplete;

        RequestState(boolean z16) {
            this.isComplete = z16;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isComplete() {
            return this.isComplete;
        }
    }

    void a(c cVar);

    boolean b(c cVar);

    boolean d(c cVar);

    boolean e(c cVar);

    void f(c cVar);

    RequestCoordinator getRoot();

    boolean isAnyResourceSet();
}
