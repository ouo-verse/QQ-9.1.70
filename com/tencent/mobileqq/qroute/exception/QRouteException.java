package com.tencent.mobileqq.qroute.exception;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qroute/exception/QRouteException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "errorCode", "", "message", "", "throwable", "", "(ILjava/lang/String;Ljava/lang/Throwable;)V", "getErrorCode", "()I", "QRoute_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes17.dex */
public final class QRouteException extends RuntimeException {
    static IPatchRedirector $redirector_;
    private final int errorCode;

    @JvmOverloads
    public QRouteException(int i3) {
        this(i3, null, null, 6, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, i3);
    }

    public final int getErrorCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
        }
        return this.errorCode;
    }

    @JvmOverloads
    public QRouteException(int i3, @NotNull String str) {
        this(i3, str, null, 4, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) str);
    }

    public /* synthetic */ QRouteException(int i3, String str, Throwable th5, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? null : th5);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, th5, Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QRouteException(int i3, @NotNull String message, @Nullable Throwable th5) {
        super("errorCode: " + i3 + ", " + message, th5);
        Intrinsics.checkParameterIsNotNull(message, "message");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.errorCode = i3;
        } else {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), message, th5);
        }
    }
}
