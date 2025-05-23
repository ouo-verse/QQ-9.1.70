package com.tencent.mobileqq.remoteweb;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/remoteweb/RemoteBusinessEvent;", "", "", "status", "I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "UNKNOWN", "ON_PAUSE", "ON_RESUME", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class RemoteBusinessEvent {
    private static final /* synthetic */ RemoteBusinessEvent[] $VALUES;
    static IPatchRedirector $redirector_;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final RemoteBusinessEvent ON_PAUSE;
    public static final RemoteBusinessEvent ON_RESUME;
    public static final RemoteBusinessEvent UNKNOWN;
    private final int status;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/remoteweb/RemoteBusinessEvent$a;", "", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.remoteweb.RemoteBusinessEvent$a, reason: from kotlin metadata */
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

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static final /* synthetic */ RemoteBusinessEvent[] $values() {
        return new RemoteBusinessEvent[]{UNKNOWN, ON_PAUSE, ON_RESUME};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39408);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        UNKNOWN = new RemoteBusinessEvent("UNKNOWN", 0, 0);
        ON_PAUSE = new RemoteBusinessEvent("ON_PAUSE", 1, 1);
        ON_RESUME = new RemoteBusinessEvent("ON_RESUME", 2, 2);
        $VALUES = $values();
        INSTANCE = new Companion(null);
    }

    RemoteBusinessEvent(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.status = i16;
        }
    }

    public static RemoteBusinessEvent valueOf(String str) {
        return (RemoteBusinessEvent) Enum.valueOf(RemoteBusinessEvent.class, str);
    }

    public static RemoteBusinessEvent[] values() {
        return (RemoteBusinessEvent[]) $VALUES.clone();
    }

    public final int status() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.status;
    }
}
