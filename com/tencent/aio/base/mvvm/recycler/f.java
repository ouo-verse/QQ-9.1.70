package com.tencent.aio.base.mvvm.recycler;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.SoftReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016R$\u0010\n\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00020\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/aio/base/mvvm/recycler/f;", "Lcom/tencent/aio/base/mvvm/recycler/c;", "", "b", "resource", "", "a", "Ljava/lang/ref/SoftReference;", "kotlin.jvm.PlatformType", "Ljava/lang/ref/SoftReference;", "softHost", "cache", "<init>", "(Ljava/lang/Object;)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class f extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private SoftReference<Object> softHost;

    public f(@NotNull Object cache) {
        Intrinsics.checkNotNullParameter(cache, "cache");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, cache);
        } else {
            this.softHost = new SoftReference<>(cache);
        }
    }

    @Override // com.tencent.aio.base.mvvm.recycler.c
    public void a(@NotNull Object resource) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, resource);
        } else {
            Intrinsics.checkNotNullParameter(resource, "resource");
            this.softHost = new SoftReference<>(resource);
        }
    }

    @Override // com.tencent.aio.base.mvvm.recycler.c
    @Nullable
    public Object b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.softHost.get();
    }
}
