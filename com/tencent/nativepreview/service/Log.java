package com.tencent.nativepreview.service;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0017J&\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u000b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0017J&\u0010\u000b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0017J&\u0010\f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0001J\u001c\u0010\u000e\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0017J&\u0010\u000e\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u000f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0017J&\u0010\u000f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/nativepreview/service/Log;", "Lcom/tencent/nativepreview/service/ILogger;", "()V", "proxy", "d", "", "tag", "", "msg", "throwable", "", "e", "i", "setProxy", "v", "w", "native_preview_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class Log implements ILogger {
    static IPatchRedirector $redirector_;

    @NotNull
    public static final Log INSTANCE;

    @Nullable
    private static ILogger proxy;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(TVKEventId.PLAYER_STATE_SET_DECODE_MODE);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Log();
        }
    }

    Log() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.nativepreview.service.ILogger
    @Keep
    public void d(@Nullable String tag, @Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) tag, (Object) msg2);
            return;
        }
        ILogger iLogger = proxy;
        if (iLogger == null) {
            a.f337873a.d(tag, msg2);
        } else {
            Intrinsics.checkNotNull(iLogger);
            iLogger.d(tag, msg2);
        }
    }

    @Override // com.tencent.nativepreview.service.ILogger
    @Keep
    public void e(@Nullable String tag, @Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) tag, (Object) msg2);
            return;
        }
        ILogger iLogger = proxy;
        if (iLogger == null) {
            a.f337873a.e(tag, msg2);
        } else {
            Intrinsics.checkNotNull(iLogger);
            iLogger.e(tag, msg2);
        }
    }

    @Override // com.tencent.nativepreview.service.ILogger
    @Keep
    public void i(@Nullable String tag, @Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) tag, (Object) msg2);
            return;
        }
        ILogger iLogger = proxy;
        if (iLogger == null) {
            a.f337873a.i(tag, msg2);
        } else {
            Intrinsics.checkNotNull(iLogger);
            iLogger.i(tag, msg2);
        }
    }

    public final void setProxy(@NotNull ILogger proxy2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) proxy2);
        } else {
            Intrinsics.checkNotNullParameter(proxy2, "proxy");
            proxy = proxy2;
        }
    }

    @Override // com.tencent.nativepreview.service.ILogger
    @Keep
    public void v(@Nullable String tag, @Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) tag, (Object) msg2);
            return;
        }
        ILogger iLogger = proxy;
        if (iLogger == null) {
            a.f337873a.v(tag, msg2);
        } else {
            Intrinsics.checkNotNull(iLogger);
            iLogger.v(tag, msg2);
        }
    }

    @Override // com.tencent.nativepreview.service.ILogger
    @Keep
    public void w(@Nullable String tag, @Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) tag, (Object) msg2);
            return;
        }
        ILogger iLogger = proxy;
        if (iLogger == null) {
            a.f337873a.w(tag, msg2);
        } else {
            Intrinsics.checkNotNull(iLogger);
            iLogger.w(tag, msg2);
        }
    }

    @Override // com.tencent.nativepreview.service.ILogger
    public void d(@Nullable String tag, @Nullable String msg2, @Nullable Throwable throwable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, tag, msg2, throwable);
            return;
        }
        ILogger iLogger = proxy;
        if (iLogger == null) {
            a.f337873a.d(tag, msg2, throwable);
        } else {
            Intrinsics.checkNotNull(iLogger);
            iLogger.d(tag, msg2, throwable);
        }
    }

    @Override // com.tencent.nativepreview.service.ILogger
    public void e(@Nullable String tag, @Nullable String msg2, @Nullable Throwable throwable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, tag, msg2, throwable);
            return;
        }
        ILogger iLogger = proxy;
        if (iLogger == null) {
            a.f337873a.e(tag, msg2, throwable);
        } else {
            Intrinsics.checkNotNull(iLogger);
            iLogger.e(tag, msg2, throwable);
        }
    }

    @Override // com.tencent.nativepreview.service.ILogger
    public void i(@Nullable String tag, @Nullable String msg2, @Nullable Throwable throwable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, tag, msg2, throwable);
            return;
        }
        ILogger iLogger = proxy;
        if (iLogger == null) {
            a.f337873a.i(tag, msg2, throwable);
        } else {
            Intrinsics.checkNotNull(iLogger);
            iLogger.i(tag, msg2, throwable);
        }
    }

    @Override // com.tencent.nativepreview.service.ILogger
    public void v(@Nullable String tag, @Nullable String msg2, @Nullable Throwable throwable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, tag, msg2, throwable);
            return;
        }
        ILogger iLogger = proxy;
        if (iLogger == null) {
            a.f337873a.v(tag, msg2, throwable);
        } else {
            Intrinsics.checkNotNull(iLogger);
            iLogger.v(tag, msg2, throwable);
        }
    }

    @Override // com.tencent.nativepreview.service.ILogger
    public void w(@Nullable String tag, @Nullable String msg2, @Nullable Throwable throwable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, tag, msg2, throwable);
            return;
        }
        ILogger iLogger = proxy;
        if (iLogger == null) {
            a.f337873a.w(tag, msg2, throwable);
        } else {
            Intrinsics.checkNotNull(iLogger);
            iLogger.w(tag, msg2, throwable);
        }
    }
}
