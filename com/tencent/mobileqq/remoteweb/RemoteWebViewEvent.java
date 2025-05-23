package com.tencent.mobileqq.remoteweb;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/remoteweb/RemoteWebViewEvent;", "", "", "status", "I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "UNKNOWN", "ON_BEFORE_INIT_WEB_VIEW", "ON_BEFORE_LOAD_URL", "ON_PAGE_STARTED", "ON_PAGE_FINISH", "ON_PAGE_SCROLL_EVENT", "ON_FULL_SCREEN_EVENT", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class RemoteWebViewEvent {
    private static final /* synthetic */ RemoteWebViewEvent[] $VALUES;
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final RemoteWebViewEvent ON_BEFORE_INIT_WEB_VIEW;
    public static final RemoteWebViewEvent ON_BEFORE_LOAD_URL;
    public static final RemoteWebViewEvent ON_FULL_SCREEN_EVENT;
    public static final RemoteWebViewEvent ON_PAGE_FINISH;
    public static final RemoteWebViewEvent ON_PAGE_SCROLL_EVENT;
    public static final RemoteWebViewEvent ON_PAGE_STARTED;

    @NotNull
    public static final String OPEN_FULL_SCREEN = "openFullScreen";

    @NotNull
    public static final String SCROLL_VALUES = "scrollValues";
    public static final RemoteWebViewEvent UNKNOWN;
    private final int status;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/remoteweb/RemoteWebViewEvent$a;", "", "", "findValue", "Lcom/tencent/mobileqq/remoteweb/RemoteWebViewEvent;", "a", "", "OPEN_FULL_SCREEN", "Ljava/lang/String;", "SCROLL_VALUES", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.remoteweb.RemoteWebViewEvent$a, reason: from kotlin metadata */
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

        @NotNull
        public final RemoteWebViewEvent a(int findValue) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (RemoteWebViewEvent) iPatchRedirector.redirect((short) 2, (Object) this, findValue);
            }
            for (RemoteWebViewEvent remoteWebViewEvent : RemoteWebViewEvent.values()) {
                if (remoteWebViewEvent.status == findValue) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return remoteWebViewEvent;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static final /* synthetic */ RemoteWebViewEvent[] $values() {
        return new RemoteWebViewEvent[]{UNKNOWN, ON_BEFORE_INIT_WEB_VIEW, ON_BEFORE_LOAD_URL, ON_PAGE_STARTED, ON_PAGE_FINISH, ON_PAGE_SCROLL_EVENT, ON_FULL_SCREEN_EVENT};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39675);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        UNKNOWN = new RemoteWebViewEvent("UNKNOWN", 0, -9999);
        ON_BEFORE_INIT_WEB_VIEW = new RemoteWebViewEvent("ON_BEFORE_INIT_WEB_VIEW", 1, 0);
        ON_BEFORE_LOAD_URL = new RemoteWebViewEvent("ON_BEFORE_LOAD_URL", 2, 1);
        ON_PAGE_STARTED = new RemoteWebViewEvent("ON_PAGE_STARTED", 3, 2);
        ON_PAGE_FINISH = new RemoteWebViewEvent("ON_PAGE_FINISH", 4, 3);
        ON_PAGE_SCROLL_EVENT = new RemoteWebViewEvent("ON_PAGE_SCROLL_EVENT", 5, 4);
        ON_FULL_SCREEN_EVENT = new RemoteWebViewEvent("ON_FULL_SCREEN_EVENT", 6, 5);
        $VALUES = $values();
        INSTANCE = new Companion(null);
    }

    RemoteWebViewEvent(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.status = i16;
        }
    }

    public static RemoteWebViewEvent valueOf(String str) {
        return (RemoteWebViewEvent) Enum.valueOf(RemoteWebViewEvent.class, str);
    }

    public static RemoteWebViewEvent[] values() {
        return (RemoteWebViewEvent[]) $VALUES.clone();
    }

    public final int status() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.status;
    }
}
