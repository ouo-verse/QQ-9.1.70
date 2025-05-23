package com.tencent.mobileqq.qcoroutine.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u001e\u001a\u00020\u0018\u0012\u0006\u0010#\u001a\u00020\u001f\u0012\b\b\u0002\u0010'\u001a\u00020$\u00a2\u0006\u0004\b(\u0010)R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001e\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0017\u0010#\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b \u0010\"R\u0017\u0010'\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b\n\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/qcoroutine/api/d;", "", "Lcom/tencent/mobileqq/qcoroutine/api/a;", "a", "Lcom/tencent/mobileqq/qcoroutine/api/a;", "()Lcom/tencent/mobileqq/qcoroutine/api/a;", "g", "(Lcom/tencent/mobileqq/qcoroutine/api/a;)V", "callback", "", "b", "J", "c", "()J", tl.h.F, "(J)V", "delay", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "f", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setCancel", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "isCancel", "", "d", "Ljava/lang/String;", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "name", "Lcom/tencent/mobileqq/qcoroutine/api/i;", "e", "Lcom/tencent/mobileqq/qcoroutine/api/i;", "()Lcom/tencent/mobileqq/qcoroutine/api/i;", "type", "", "Z", "()Z", "canAutoRetrieve", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/qcoroutine/api/i;Z)V", "QCoroutine_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public abstract class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a callback;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long delay;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicBoolean isCancel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String name;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final i type;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean canAutoRetrieve;

    public d(@NotNull String name, @NotNull i type, boolean z16) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, name, type, Boolean.valueOf(z16));
            return;
        }
        this.name = name;
        this.type = type;
        this.canAutoRetrieve = z16;
        this.isCancel = new AtomicBoolean(false);
    }

    @Nullable
    public final a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (a) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.callback;
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.canAutoRetrieve;
    }

    public final long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.delay;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.name;
    }

    @NotNull
    public final i e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (i) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.type;
    }

    @NotNull
    public final AtomicBoolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (AtomicBoolean) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.isCancel;
    }

    public final void g(@Nullable a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            this.callback = aVar;
        }
    }

    public final void h(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
        } else {
            this.delay = j3;
        }
    }

    public final void i(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.name = str;
        }
    }

    public /* synthetic */ d(String str, i iVar, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, iVar, (i3 & 4) != 0 ? true : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            return;
        }
        iPatchRedirector.redirect((short) 12, this, str, iVar, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
    }
}
