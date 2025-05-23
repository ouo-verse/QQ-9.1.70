package com.tencent.qqnt.notification.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0003\n\u0007\u0004J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/notification/trace/a;", "", "Lcom/tencent/qqnt/notification/trace/a$b;", "totalConfig", "c", "Lcom/tencent/qqnt/notification/trace/a$a;", "notificationConfig", "b", "Lcom/tencent/qqnt/notification/trace/a$c;", "vibratorConfig", "a", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/qqnt/notification/trace/a$a;", "", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.notification.trace.a$a, reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public interface InterfaceC9664a {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/notification/trace/a$b;", "", "a", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public interface b {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/notification/trace/a$b$a;", "Lcom/tencent/qqnt/notification/trace/a$b;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "()Z", "open", "<init>", "(Z)V", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.qqnt.notification.trace.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes24.dex */
        public static final /* data */ class C9665a implements b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            private final boolean open;

            public C9665a(boolean z16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, z16);
                } else {
                    this.open = z16;
                }
            }

            public final boolean a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                return this.open;
            }

            public boolean equals(@Nullable Object other) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
                }
                if (this == other) {
                    return true;
                }
                if ((other instanceof C9665a) && this.open == ((C9665a) other).open) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
                }
                boolean z16 = this.open;
                if (z16) {
                    return 1;
                }
                return z16 ? 1 : 0;
            }

            @NotNull
            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (String) iPatchRedirector.redirect((short) 5, (Object) this);
                }
                return "NewMessageNotification(open=" + this.open + ")";
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/qqnt/notification/trace/a$c;", "", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public interface c {
    }

    @NotNull
    a a(@NotNull c vibratorConfig);

    @NotNull
    a b(@NotNull InterfaceC9664a notificationConfig);

    @NotNull
    a c(@NotNull b totalConfig);
}
