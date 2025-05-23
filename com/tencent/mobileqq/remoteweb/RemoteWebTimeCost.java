package com.tencent.mobileqq.remoteweb;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/remoteweb/RemoteWebTimeCost;", "", "", "status", "I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "REMOTE_ACTIVITY_ON_CREATE", "SHOW_PRESENTATION", "BEFORE_CREATE_WEB_VIEW", "CREATE_WEB_VIEW", "BEFORE_LOAD_URL", "REBUILD_WEB_VIEW", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class RemoteWebTimeCost {
    private static final /* synthetic */ RemoteWebTimeCost[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final RemoteWebTimeCost BEFORE_CREATE_WEB_VIEW;
    public static final RemoteWebTimeCost BEFORE_LOAD_URL;
    public static final RemoteWebTimeCost CREATE_WEB_VIEW;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final RemoteWebTimeCost REBUILD_WEB_VIEW;
    public static final RemoteWebTimeCost REMOTE_ACTIVITY_ON_CREATE;
    public static final RemoteWebTimeCost SHOW_PRESENTATION;
    private final int status;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/remoteweb/RemoteWebTimeCost$a;", "", "", "findValue", "Lcom/tencent/mobileqq/remoteweb/RemoteWebTimeCost;", "a", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.remoteweb.RemoteWebTimeCost$a, reason: from kotlin metadata */
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
        public final RemoteWebTimeCost a(int findValue) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (RemoteWebTimeCost) iPatchRedirector.redirect((short) 2, (Object) this, findValue);
            }
            for (RemoteWebTimeCost remoteWebTimeCost : RemoteWebTimeCost.values()) {
                if (remoteWebTimeCost.status == findValue) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return remoteWebTimeCost;
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

    private static final /* synthetic */ RemoteWebTimeCost[] $values() {
        return new RemoteWebTimeCost[]{REMOTE_ACTIVITY_ON_CREATE, SHOW_PRESENTATION, BEFORE_CREATE_WEB_VIEW, CREATE_WEB_VIEW, BEFORE_LOAD_URL, REBUILD_WEB_VIEW};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39667);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        REMOTE_ACTIVITY_ON_CREATE = new RemoteWebTimeCost("REMOTE_ACTIVITY_ON_CREATE", 0, 1);
        SHOW_PRESENTATION = new RemoteWebTimeCost("SHOW_PRESENTATION", 1, 2);
        BEFORE_CREATE_WEB_VIEW = new RemoteWebTimeCost("BEFORE_CREATE_WEB_VIEW", 2, 3);
        CREATE_WEB_VIEW = new RemoteWebTimeCost("CREATE_WEB_VIEW", 3, 4);
        BEFORE_LOAD_URL = new RemoteWebTimeCost("BEFORE_LOAD_URL", 4, 5);
        REBUILD_WEB_VIEW = new RemoteWebTimeCost("REBUILD_WEB_VIEW", 5, 6);
        $VALUES = $values();
        INSTANCE = new Companion(null);
    }

    RemoteWebTimeCost(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.status = i16;
        }
    }

    public static RemoteWebTimeCost valueOf(String str) {
        return (RemoteWebTimeCost) Enum.valueOf(RemoteWebTimeCost.class, str);
    }

    public static RemoteWebTimeCost[] values() {
        return (RemoteWebTimeCost[]) $VALUES.clone();
    }

    public final int status() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.status;
    }
}
