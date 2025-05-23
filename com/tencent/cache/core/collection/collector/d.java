package com.tencent.cache.core.collection.collector;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class d<V> extends com.tencent.cache.core.collection.base.c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public com.tencent.cache.core.collection.base.d f98718a;

    /* renamed from: b, reason: collision with root package name */
    public Handler f98719b;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class a implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Object f98720d;

        public a(Object obj) {
            this.f98720d = obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, obj);
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Object obj = this.f98720d;
            if (obj instanceof com.tencent.cache.api.collection.b) {
                ((com.tencent.cache.api.collection.b) obj).clear();
            }
        }
    }

    public d(@NotNull String business, @NotNull String subBusiness) {
        Intrinsics.checkNotNullParameter(business, "business");
        Intrinsics.checkNotNullParameter(subBusiness, "subBusiness");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) business, (Object) subBusiness);
        } else {
            this.f98718a = new com.tencent.cache.core.collection.base.d(business, subBusiness, -1);
            this.f98719b = new Handler(Looper.getMainLooper());
        }
    }

    @Override // com.tencent.cache.core.collection.base.c
    public long a(@NotNull Object target, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, this, target, Long.valueOf(j3))).longValue();
        }
        Intrinsics.checkNotNullParameter(target, "target");
        return 0L;
    }

    @Override // com.tencent.cache.core.collection.base.c
    @NotNull
    public com.tencent.cache.core.collection.base.d c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.cache.core.collection.base.d) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f98718a;
    }

    @Override // com.tencent.cache.core.collection.base.c
    public void h(@NotNull Object target) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, target);
            return;
        }
        Intrinsics.checkNotNullParameter(target, "target");
        a aVar = new a(target);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            aVar.run();
        } else {
            this.f98719b.post(aVar);
        }
    }
}
