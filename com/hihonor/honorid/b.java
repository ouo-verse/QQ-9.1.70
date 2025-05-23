package com.hihonor.honorid;

import com.hihonor.honorid.UseCase;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final c f36254a;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class a implements UseCase.a {
        public a(UseCase.a aVar, b bVar) {
        }
    }

    /* compiled from: P */
    /* renamed from: com.hihonor.honorid.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class RunnableC0255b implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        UseCase f36255d;

        RunnableC0255b(UseCase useCase) {
            this.f36255d = useCase;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f36255d.a();
        }
    }

    public b(c cVar) {
        this.f36254a = cVar;
    }

    public <T extends UseCase.RequestValues> void a(UseCase<T> useCase, T t16, UseCase.a aVar) {
        useCase.d(t16);
        useCase.c(new a(aVar, this));
        this.f36254a.execute(new RunnableC0255b(useCase));
    }
}
