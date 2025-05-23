package i0;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class c {

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static class b extends c {

        /* renamed from: a, reason: collision with root package name */
        private volatile boolean f406984a;

        b() {
            super();
        }

        @Override // i0.c
        public void b(boolean z16) {
            this.f406984a = z16;
        }

        @Override // i0.c
        public void c() {
            if (!this.f406984a) {
            } else {
                throw new IllegalStateException("Already released");
            }
        }
    }

    @NonNull
    public static c a() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(boolean z16);

    public abstract void c();

    c() {
    }
}
