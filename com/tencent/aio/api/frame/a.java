package com.tencent.aio.api.frame;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import ml3.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0014\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\n\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0010\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001e\u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u0015\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/aio/api/frame/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroidx/lifecycle/LifecycleOwner;", "a", "Landroidx/lifecycle/LifecycleOwner;", "d", "()Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lts/a;", "b", "Lts/a;", "()Lts/a;", "activityLauncher", "Lml3/b;", "c", "Lml3/b;", "()Lml3/b;", "e", "(Lml3/b;)V", "emitterService", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "()Lkotlinx/coroutines/CoroutineScope;", "lifeScope", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Lts/a;Lml3/b;Lkotlinx/coroutines/CoroutineScope;)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ts.a activityLauncher;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b emitterService;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope lifeScope;

    public a(@NotNull LifecycleOwner lifecycleOwner, @NotNull ts.a activityLauncher, @NotNull b emitterService, @NotNull CoroutineScope lifeScope) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(activityLauncher, "activityLauncher");
        Intrinsics.checkNotNullParameter(emitterService, "emitterService");
        Intrinsics.checkNotNullParameter(lifeScope, "lifeScope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, lifecycleOwner, activityLauncher, emitterService, lifeScope);
            return;
        }
        this.lifecycleOwner = lifecycleOwner;
        this.activityLauncher = activityLauncher;
        this.emitterService = emitterService;
        this.lifeScope = lifeScope;
    }

    @NotNull
    public final ts.a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ts.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.activityLauncher;
    }

    @NotNull
    public final b b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.emitterService;
    }

    @NotNull
    public final CoroutineScope c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (CoroutineScope) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.lifeScope;
    }

    @NotNull
    public final LifecycleOwner d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (LifecycleOwner) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.lifecycleOwner;
    }

    public final void e(@NotNull b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
        } else {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.emitterService = bVar;
        }
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, other)).booleanValue();
        }
        if (this != other) {
            if (other instanceof a) {
                a aVar = (a) other;
                if (!Intrinsics.areEqual(this.lifecycleOwner, aVar.lifecycleOwner) || !Intrinsics.areEqual(this.activityLauncher, aVar.activityLauncher) || !Intrinsics.areEqual(this.emitterService, aVar.emitterService) || !Intrinsics.areEqual(this.lifeScope, aVar.lifeScope)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        int i18 = 0;
        if (lifecycleOwner != null) {
            i3 = lifecycleOwner.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = i3 * 31;
        ts.a aVar = this.activityLauncher;
        if (aVar != null) {
            i16 = aVar.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        b bVar = this.emitterService;
        if (bVar != null) {
            i17 = bVar.hashCode();
        } else {
            i17 = 0;
        }
        int i27 = (i26 + i17) * 31;
        CoroutineScope coroutineScope = this.lifeScope;
        if (coroutineScope != null) {
            i18 = coroutineScope.hashCode();
        }
        return i27 + i18;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "FramesConfig(lifecycleOwner=" + this.lifecycleOwner + ", activityLauncher=" + this.activityLauncher + ", emitterService=" + this.emitterService + ", lifeScope=" + this.lifeScope + ")";
    }
}
