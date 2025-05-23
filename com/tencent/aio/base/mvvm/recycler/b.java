package com.tencent.aio.base.mvvm.recycler;

import android.util.LruCache;
import com.tencent.aio.exception.AIOException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/aio/base/mvvm/recycler/b;", "", "", "key", "Lcom/tencent/aio/main/businesshelper/e;", "a", "helper", "", "b", "Landroid/util/LruCache;", "Lcom/tencent/aio/base/mvvm/recycler/c;", "Landroid/util/LruCache;", "caches", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final LruCache<String, c> caches;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/base/mvvm/recycler/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.base.mvvm.recycler.b$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29114);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.caches = new LruCache<>(1000);
        }
    }

    @Nullable
    public final com.tencent.aio.main.businesshelper.e a(@NotNull String key) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (com.tencent.aio.main.businesshelper.e) iPatchRedirector.redirect((short) 1, (Object) this, (Object) key);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        c cVar = this.caches.get(key);
        Object obj2 = null;
        if (cVar != null) {
            obj = cVar.b();
        } else {
            obj = null;
        }
        if (obj == null) {
            this.caches.remove(key);
        }
        if (com.tencent.aio.base.a.f69150c.a()) {
            com.tencent.aio.base.log.a.f69187b.d("HelperRecycler", "getHelper key " + key + " value " + obj);
        }
        if (obj instanceof com.tencent.aio.main.businesshelper.e) {
            obj2 = obj;
        }
        return (com.tencent.aio.main.businesshelper.e) obj2;
    }

    public final void b(@NotNull String key, @NotNull com.tencent.aio.main.businesshelper.e helper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) key, (Object) helper);
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(helper, "helper");
        if (helper instanceof com.tencent.aio.helper.c) {
            c a16 = c.INSTANCE.a(((com.tencent.aio.helper.c) helper).l(), helper);
            if (a16.c()) {
                this.caches.put(key, a16);
                return;
            }
            return;
        }
        throw new AIOException("please cache ICanRecycle");
    }
}
