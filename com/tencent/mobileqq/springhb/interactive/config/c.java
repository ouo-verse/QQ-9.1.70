package com.tencent.mobileqq.springhb.interactive.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.springhb.interactive.api.InteractiveRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGFile;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\b\u0018\u0000 \u00172\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001d\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u0007\u001a\u00020\u0002H\u0096\u0001J\t\u0010\b\u001a\u00020\u0002H\u0096\u0001J\t\u0010\t\u001a\u00020\u0002H\u0096\u0001J\t\u0010\n\u001a\u00020\u0002H\u0096\u0001J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J\t\u0010\u000e\u001a\u00020\rH\u0096\u0001J\t\u0010\u000f\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u0010\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u0011\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0014\u001a\u00020\rH\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0016H\u0096\u0001J\t\u0010\u0018\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u001c\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u00d6\u0003R\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/springhb/interactive/config/c;", "Lcom/tencent/mobileqq/springhb/interactive/config/b;", "", "k", "", "getChatType", "d", "c", "f", "getId", "e", "Lorg/libpag/PAGFile;", "a", "", "i", "getSessionId", "getSource", "getType", "", h.F, "j", "g", "", "b", "toString", "hashCode", "", "other", "equals", "Lcom/tencent/mobileqq/springhb/interactive/api/InteractiveRecord;", "Lcom/tencent/mobileqq/springhb/interactive/api/InteractiveRecord;", "msg", "<init>", "(Lcom/tencent/mobileqq/springhb/interactive/api/InteractiveRecord;)V", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final /* data */ class c implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final InteractiveRecord msg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/springhb/interactive/config/c$a;", "", "Lcom/tencent/mobileqq/springhb/interactive/api/InteractiveRecord;", "msg", "Lcom/tencent/mobileqq/springhb/interactive/config/c;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.springhb.interactive.config.c$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @Nullable
        public final c a(@NotNull InteractiveRecord msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (c) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msg2);
            }
            Intrinsics.checkNotNullParameter(msg2, "msg");
            return new c(msg2);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21118);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c(@NotNull InteractiveRecord msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msg2);
        } else {
            this.msg = msg2;
        }
    }

    @Override // com.tencent.mobileqq.springhb.interactive.config.b
    @Nullable
    public PAGFile a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (PAGFile) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.msg.a();
    }

    @Override // com.tencent.mobileqq.springhb.interactive.config.b
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return this.msg.b();
    }

    @Override // com.tencent.mobileqq.springhb.interactive.config.b
    @NotNull
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.msg.c();
    }

    @Override // com.tencent.mobileqq.springhb.interactive.config.b
    @NotNull
    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.msg.d();
    }

    @Override // com.tencent.mobileqq.springhb.interactive.config.b
    @NotNull
    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.msg.e();
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if ((other instanceof c) && Intrinsics.areEqual(this.msg, ((c) other).msg)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.springhb.interactive.config.b
    @NotNull
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.msg.f();
    }

    @Override // com.tencent.mobileqq.springhb.interactive.config.b
    public double g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Double) iPatchRedirector.redirect((short) 17, (Object) this)).doubleValue();
        }
        return this.msg.g();
    }

    @Override // com.tencent.mobileqq.springhb.interactive.config.b
    public int getChatType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.msg.getChatType();
    }

    @Override // com.tencent.mobileqq.springhb.interactive.config.b
    @NotNull
    public String getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.msg.getId();
    }

    @Override // com.tencent.mobileqq.springhb.interactive.config.b
    @NotNull
    public String getSessionId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.msg.getSessionId();
    }

    @Override // com.tencent.mobileqq.springhb.interactive.config.b
    public int getSource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.msg.getSource();
    }

    @Override // com.tencent.mobileqq.springhb.interactive.config.b
    public int getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.msg.getType();
    }

    @Override // com.tencent.mobileqq.springhb.interactive.config.b
    public double h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Double) iPatchRedirector.redirect((short) 15, (Object) this)).doubleValue();
        }
        return this.msg.h();
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        return this.msg.hashCode();
    }

    @Override // com.tencent.mobileqq.springhb.interactive.config.b
    public long i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, (Object) this)).longValue();
        }
        return this.msg.i();
    }

    @Override // com.tencent.mobileqq.springhb.interactive.config.b
    public long j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Long) iPatchRedirector.redirect((short) 16, (Object) this)).longValue();
        }
        return this.msg.j();
    }

    @Override // com.tencent.mobileqq.springhb.interactive.config.b
    @NotNull
    public String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.msg.k();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return "InteractiveConfig(msg=" + this.msg + ")";
    }
}
