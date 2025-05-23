package com.tencent.mobileqq.perf.memory.collect;

import android.os.Debug;
import com.tencent.cache.api.memory.b;
import com.tencent.cache.api.memory.c;
import com.tencent.cache.api.memory.d;
import com.tencent.cache.api.memory.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerMsg;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0003\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0019\u001a\u0004\b\u000b\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/perf/memory/collect/a;", "", "Lcom/tencent/cache/api/memory/d;", "a", "Lcom/tencent/cache/api/memory/d;", "c", "()Lcom/tencent/cache/api/memory/d;", "g", "(Lcom/tencent/cache/api/memory/d;)V", "pss", "Lcom/tencent/cache/api/memory/b;", "b", "Lcom/tencent/cache/api/memory/b;", "()Lcom/tencent/cache/api/memory/b;", "e", "(Lcom/tencent/cache/api/memory/b;)V", ResourceAttributes.TelemetrySdkLanguageValues.JAVA, "Lcom/tencent/cache/api/memory/e;", "Lcom/tencent/cache/api/memory/e;", "d", "()Lcom/tencent/cache/api/memory/e;", h.F, "(Lcom/tencent/cache/api/memory/e;)V", TVKPlayerMsg.PLAYER_CHOICE_SYSTEM, "Lcom/tencent/cache/api/memory/c;", "Lcom/tencent/cache/api/memory/c;", "()Lcom/tencent/cache/api/memory/c;", "f", "(Lcom/tencent/cache/api/memory/c;)V", "native", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public d pss;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public b java;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e system;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c native;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002J%\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/perf/memory/collect/a$a;", "", "Lcom/tencent/mobileqq/perf/memory/collect/a;", "a", "Landroid/os/Debug$MemoryInfo;", "memoryInfo", "", "needFixGraphic", "b", "(Landroid/os/Debug$MemoryInfo;Z)Lcom/tencent/mobileqq/perf/memory/collect/a;", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.perf.memory.collect.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        public static /* synthetic */ a c(Companion companion, Debug.MemoryInfo memoryInfo, boolean z16, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                memoryInfo = null;
            }
            if ((i3 & 2) != 0) {
                z16 = false;
            }
            return companion.b(memoryInfo, z16);
        }

        @NotNull
        public final a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            a aVar = new a();
            com.tencent.cache.api.memory.a aVar2 = com.tencent.cache.api.memory.a.f98606b;
            aVar.g(com.tencent.cache.api.memory.a.d(aVar2, null, false, 3, null));
            aVar.e(aVar2.a());
            return aVar;
        }

        @NotNull
        public final a b(@Nullable Debug.MemoryInfo memoryInfo, boolean needFixGraphic) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (a) iPatchRedirector.redirect((short) 3, this, memoryInfo, Boolean.valueOf(needFixGraphic));
            }
            a aVar = new a();
            com.tencent.cache.api.memory.a aVar2 = com.tencent.cache.api.memory.a.f98606b;
            aVar.g(aVar2.c(memoryInfo, needFixGraphic));
            aVar.e(aVar2.a());
            aVar.h(aVar2.f());
            aVar.f(aVar2.b());
            return aVar;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30239);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final b a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        b bVar = this.java;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException(ResourceAttributes.TelemetrySdkLanguageValues.JAVA);
        return null;
    }

    @Nullable
    public final c b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (c) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.native;
    }

    @NotNull
    public final d c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (d) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        d dVar = this.pss;
        if (dVar != null) {
            return dVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pss");
        return null;
    }

    @Nullable
    public final e d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (e) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.system;
    }

    public final void e(@NotNull b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bVar);
        } else {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.java = bVar;
        }
    }

    public final void f(@Nullable c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) cVar);
        } else {
            this.native = cVar;
        }
    }

    public final void g(@NotNull d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) dVar);
        } else {
            Intrinsics.checkNotNullParameter(dVar, "<set-?>");
            this.pss = dVar;
        }
    }

    public final void h(@Nullable e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) eVar);
        } else {
            this.system = eVar;
        }
    }
}
