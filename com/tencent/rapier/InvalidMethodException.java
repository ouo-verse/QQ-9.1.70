package com.tencent.rapier;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00062\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\b"}, d2 = {"Lcom/tencent/rapier/InvalidMethodException;", "Ljava/io/IOException;", "", "description", "<init>", "(Ljava/lang/String;)V", "Companion", "a", "rapier_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class InvalidMethodException extends IOException {
    static IPatchRedirector $redirector_;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/rapier/InvalidMethodException$a;", "", "Lcom/tencent/rapier/InvalidMethodException;", "e", "a", "d", "c", "b", "<init>", "()V", "rapier_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.rapier.InvalidMethodException$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return;
            }
            iPatchRedirector.redirect((short) 7, (Object) this);
        }

        @NotNull
        public final InvalidMethodException a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (InvalidMethodException) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new InvalidMethodException("Service Method need a subclass of MessageNano, but find wrong number of arg");
        }

        @NotNull
        public final InvalidMethodException b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (InvalidMethodException) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return new InvalidMethodException("Methods need to declare method route");
        }

        @NotNull
        public final InvalidMethodException c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (InvalidMethodException) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return new InvalidMethodException("Methods need to declare service route");
        }

        @NotNull
        public final InvalidMethodException d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (InvalidMethodException) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return new InvalidMethodException("Service methods cannot return void.");
        }

        @NotNull
        public final InvalidMethodException e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (InvalidMethodException) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            return new InvalidMethodException("Method return type must not include a type variable or wildcard");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                return;
            }
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9025);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public InvalidMethodException(@NotNull String description) {
        Intrinsics.checkNotNullParameter(description, "description");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) description);
        }
    }
}
