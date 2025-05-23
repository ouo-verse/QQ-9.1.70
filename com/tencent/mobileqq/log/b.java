package com.tencent.mobileqq.log;

import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.Utils;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u0007*\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/log/b;", "", "Lcom/tencent/smtt/export/external/interfaces/ConsoleMessage;", "newMsg", "Lcom/tencent/mobileqq/log/b$a;", "b", "other", "", "c", "a", "", "J", "getLastTs", "()J", "setLastTs", "(J)V", "lastTs", "Lcom/tencent/mobileqq/log/b$a;", "msg", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f241759a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long lastTs;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static a msg;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0082\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0013\u001a\u0004\b\u0012\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/log/b$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/smtt/export/external/interfaces/ConsoleMessage$MessageLevel;", "a", "Lcom/tencent/smtt/export/external/interfaces/ConsoleMessage$MessageLevel;", "()Lcom/tencent/smtt/export/external/interfaces/ConsoleMessage$MessageLevel;", "level", "b", "I", "()I", "lineNumber", "c", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "sourceId", "message", "<init>", "(Lcom/tencent/smtt/export/external/interfaces/ConsoleMessage$MessageLevel;ILjava/lang/String;Ljava/lang/String;)V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final /* data */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ConsoleMessage.MessageLevel level;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int lineNumber;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String sourceId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String message;

        public a(@NotNull ConsoleMessage.MessageLevel level, int i3, @Nullable String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(level, "level");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, level, Integer.valueOf(i3), str, str2);
                return;
            }
            this.level = level;
            this.lineNumber = i3;
            this.sourceId = str;
            this.message = str2;
        }

        @NotNull
        public final ConsoleMessage.MessageLevel a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ConsoleMessage.MessageLevel) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.level;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.lineNumber;
        }

        @Nullable
        public final String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.message;
        }

        @Nullable
        public final String d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.sourceId;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            if (this.level == aVar.level && this.lineNumber == aVar.lineNumber && Intrinsics.areEqual(this.sourceId, aVar.sourceId) && Intrinsics.areEqual(this.message, aVar.message)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
            }
            int hashCode2 = ((this.level.hashCode() * 31) + this.lineNumber) * 31;
            String str = this.sourceId;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = (hashCode2 + hashCode) * 31;
            String str2 = this.message;
            if (str2 != null) {
                i3 = str2.hashCode();
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (String) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            return "Msg(level=" + this.level + ", lineNumber=" + this.lineNumber + ", sourceId=" + this.sourceId + ", message=" + this.message + ")";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39367);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f241759a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final a b(ConsoleMessage newMsg) {
        if (newMsg == null) {
            return null;
        }
        ConsoleMessage.MessageLevel messageLevel = newMsg.messageLevel();
        Intrinsics.checkNotNullExpressionValue(messageLevel, "newMsg.messageLevel()");
        return new a(messageLevel, newMsg.lineNumber(), newMsg.sourceId(), newMsg.message());
    }

    private final boolean c(a aVar, ConsoleMessage consoleMessage) {
        if (consoleMessage != null && consoleMessage.messageLevel() == aVar.a() && consoleMessage.lineNumber() == aVar.b() && Utils.p(consoleMessage.sourceId(), aVar.d()) && Utils.p(consoleMessage.message(), aVar.c())) {
            return true;
        }
        return false;
    }

    public final boolean a(@Nullable ConsoleMessage newMsg) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) newMsg)).booleanValue();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - lastTs < 1000) {
            a aVar = msg;
            if (aVar != null && c(aVar, newMsg)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
        }
        msg = b(newMsg);
        lastTs = uptimeMillis;
        return false;
    }
}
