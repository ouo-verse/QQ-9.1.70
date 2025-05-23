package com.tencent.mobileqq.app.automator;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/app/automator/a;", "", "a", "QAutomator_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0002\"\u00020\u0001H\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u0007\u001a\u00020\u00042\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0002\"\u00020\u0001H\u0007\u00a2\u0006\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/app/automator/a$a;", "", "", "stepIds", "", "a", "([Ljava/lang/Object;)Ljava/lang/String;", "b", "C_LINEAR_POSTFIX", "Ljava/lang/String;", "C_LINEAR_PREFIX", "C_PARALL_POSTFIX", "C_PARALL_PREFIX", "<init>", "()V", "QAutomator_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.app.automator.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes11.dex */
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

        @JvmStatic
        @NotNull
        public final String a(@NotNull Object... stepIds) {
            String joinToString$default;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) stepIds);
            }
            Intrinsics.checkNotNullParameter(stepIds, "stepIds");
            joinToString$default = ArraysKt___ArraysKt.joinToString$default(stepIds, ",", "{", "}", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
            return joinToString$default;
        }

        @JvmStatic
        @NotNull
        public final String b(@NotNull Object... stepIds) {
            String joinToString$default;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) stepIds);
            }
            Intrinsics.checkNotNullParameter(stepIds, "stepIds");
            joinToString$default = ArraysKt___ArraysKt.joinToString$default(stepIds, ",", "[", "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
            return joinToString$default;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43156);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new Companion(null);
        }
    }
}
