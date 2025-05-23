package com.tencent.nativepreview.service;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\t\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010\t\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\n\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010\n\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\u000b\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010\u000b\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\f\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010\f\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/nativepreview/service/a;", "Lcom/tencent/nativepreview/service/ILogger;", "", "tag", "msg", "", "e", "", "throwable", "w", "i", "d", "v", "<init>", "()V", "native_preview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes21.dex */
public final class a implements ILogger {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f337873a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15247);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            f337873a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.nativepreview.service.ILogger
    public void d(@Nullable String tag, @Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) tag, (Object) msg2);
            return;
        }
        if (msg2 == null) {
            msg2 = "";
        }
        android.util.Log.d(tag, msg2);
    }

    @Override // com.tencent.nativepreview.service.ILogger
    public void e(@Nullable String tag, @Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) tag, (Object) msg2);
            return;
        }
        if (msg2 == null) {
            msg2 = "";
        }
        android.util.Log.e(tag, msg2);
    }

    @Override // com.tencent.nativepreview.service.ILogger
    public void i(@Nullable String tag, @Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) tag, (Object) msg2);
            return;
        }
        if (msg2 == null) {
            msg2 = "";
        }
        android.util.Log.i(tag, msg2);
    }

    @Override // com.tencent.nativepreview.service.ILogger
    public void v(@Nullable String tag, @Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) tag, (Object) msg2);
            return;
        }
        if (msg2 == null) {
            msg2 = "";
        }
        android.util.Log.v(tag, msg2);
    }

    @Override // com.tencent.nativepreview.service.ILogger
    public void w(@Nullable String tag, @Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) tag, (Object) msg2);
            return;
        }
        if (msg2 == null) {
            msg2 = "";
        }
        android.util.Log.w(tag, msg2);
    }

    @Override // com.tencent.nativepreview.service.ILogger
    public void d(@Nullable String tag, @Nullable String msg2, @Nullable Throwable throwable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, tag, msg2, throwable);
            return;
        }
        if (msg2 == null) {
            msg2 = "";
        }
        android.util.Log.d(tag, msg2, throwable);
    }

    @Override // com.tencent.nativepreview.service.ILogger
    public void e(@Nullable String tag, @Nullable String msg2, @Nullable Throwable throwable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, tag, msg2, throwable);
            return;
        }
        if (msg2 == null) {
            msg2 = "";
        }
        android.util.Log.e(tag, msg2, throwable);
    }

    @Override // com.tencent.nativepreview.service.ILogger
    public void i(@Nullable String tag, @Nullable String msg2, @Nullable Throwable throwable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, tag, msg2, throwable);
            return;
        }
        if (msg2 == null) {
            msg2 = "";
        }
        android.util.Log.i(tag, msg2, throwable);
    }

    @Override // com.tencent.nativepreview.service.ILogger
    public void v(@Nullable String tag, @Nullable String msg2, @Nullable Throwable throwable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, tag, msg2, throwable);
            return;
        }
        if (msg2 == null) {
            msg2 = "";
        }
        android.util.Log.v(tag, msg2, throwable);
    }

    @Override // com.tencent.nativepreview.service.ILogger
    public void w(@Nullable String tag, @Nullable String msg2, @Nullable Throwable throwable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, tag, msg2, throwable);
            return;
        }
        if (msg2 == null) {
            msg2 = "";
        }
        android.util.Log.w(tag, msg2, throwable);
    }
}
