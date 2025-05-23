package com.tencent.mobileqq.opr.utils.log;

import android.util.Log;
import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qne.delegate.Level;
import com.tencent.qne.delegate.b;
import io.github.landerlyoung.jenny.NativeFieldProxy;
import io.github.landerlyoung.jenny.NativeMethodProxy;
import io.github.landerlyoung.jenny.NativeProxy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@NativeProxy(allFields = true, allMethods = true)
@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007J$\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007J$\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007J$\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007J$\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007J$\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007J\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0001\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/opr/utils/log/OprLogger;", "", "", "tag", "msg", "", "v", "d", "i", "w", "e", "", "throwable", "Lcom/tencent/qne/delegate/b;", "delegate", "init$opr_debug", "(Lcom/tencent/qne/delegate/b;)V", "init", "realLogger", "Lcom/tencent/qne/delegate/b;", "<init>", "()V", "opr_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class OprLogger {
    static IPatchRedirector $redirector_;

    @NotNull
    public static final OprLogger INSTANCE;

    @NativeFieldProxy(getter = false, setter = false)
    @Nullable
    private static b realLogger;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10980);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new OprLogger();
        }
    }

    OprLogger() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void d(@NotNull String tag, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        d(tag, msg2, null);
    }

    public static /* synthetic */ void d$default(String str, String str2, Throwable th5, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            th5 = null;
        }
        d(str, str2, th5);
    }

    @JvmStatic
    public static final void e(@NotNull String tag, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        e(tag, msg2, null);
    }

    public static /* synthetic */ void e$default(String str, String str2, Throwable th5, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            th5 = null;
        }
        e(str, str2, th5);
    }

    @JvmStatic
    public static final void i(@NotNull String tag, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        i(tag, msg2, null);
    }

    public static /* synthetic */ void i$default(String str, String str2, Throwable th5, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            th5 = null;
        }
        i(str, str2, th5);
    }

    @JvmStatic
    public static final void v(@NotNull String tag, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        v(tag, msg2, null);
    }

    public static /* synthetic */ void v$default(String str, String str2, Throwable th5, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            th5 = null;
        }
        v(str, str2, th5);
    }

    @JvmStatic
    public static final void w(@NotNull String tag, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        w(tag, msg2, null);
    }

    public static /* synthetic */ void w$default(String str, String str2, Throwable th5, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            th5 = null;
        }
        w(str, str2, th5);
    }

    @NativeMethodProxy(enabled = false)
    public final void init$opr_debug(@NotNull b delegate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) delegate);
        } else {
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            realLogger = delegate;
        }
    }

    @JvmStatic
    public static final void d(@NotNull String tag, @NotNull String msg2, @Nullable Throwable throwable) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        b bVar = realLogger;
        if (bVar == null) {
            Log.d(tag, msg2, throwable);
        } else {
            if (bVar == null) {
                return;
            }
            bVar.a(Level.DEBUG, tag, msg2, throwable);
        }
    }

    @JvmStatic
    public static final void e(@NotNull String tag, @NotNull String msg2, @Nullable Throwable throwable) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        b bVar = realLogger;
        if (bVar == null) {
            Log.e(tag, msg2, throwable);
        } else {
            if (bVar == null) {
                return;
            }
            bVar.a(Level.ERROR, tag, msg2, throwable);
        }
    }

    @JvmStatic
    public static final void i(@NotNull String tag, @NotNull String msg2, @Nullable Throwable throwable) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        b bVar = realLogger;
        if (bVar == null) {
            Log.i(tag, msg2, throwable);
        } else {
            if (bVar == null) {
                return;
            }
            bVar.a(Level.INFO, tag, msg2, throwable);
        }
    }

    @JvmStatic
    public static final void v(@NotNull String tag, @NotNull String msg2, @Nullable Throwable throwable) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        b bVar = realLogger;
        if (bVar == null) {
            Log.v(tag, msg2, throwable);
        } else {
            if (bVar == null) {
                return;
            }
            bVar.a(Level.VERBOSE, tag, msg2, throwable);
        }
    }

    @JvmStatic
    public static final void w(@NotNull String tag, @NotNull String msg2, @Nullable Throwable throwable) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        b bVar = realLogger;
        if (bVar == null) {
            Log.w(tag, msg2, throwable);
        } else {
            if (bVar == null) {
                return;
            }
            bVar.a(Level.WARN, tag, msg2, throwable);
        }
    }
}
