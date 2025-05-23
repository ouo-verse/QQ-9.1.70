package com.tencent.thread.monitor.plugin.api;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"defaultLogger", "Lcom/tencent/thread/monitor/plugin/api/ILog;", "getDefaultLogger", "()Lcom/tencent/thread/monitor/plugin/api/ILog;", "plugincode_debug"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class ILogKt {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final ILog defaultLogger;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7923);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            defaultLogger = new ILog() { // from class: com.tencent.thread.monitor.plugin.api.ILogKt$defaultLogger$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        iPatchRedirector.redirect((short) 5, (Object) this);
                    }
                }

                @Override // com.tencent.thread.monitor.plugin.api.ILog
                public void d(@NotNull String tag, @NotNull String msg2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, (Object) this, (Object) tag, (Object) msg2);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(tag, "tag");
                    Intrinsics.checkNotNullParameter(msg2, "msg");
                    Log.d(tag, msg2);
                }

                @Override // com.tencent.thread.monitor.plugin.api.ILog
                public void e(@NotNull String tag, @NotNull String msg2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) tag, (Object) msg2);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(tag, "tag");
                    Intrinsics.checkNotNullParameter(msg2, "msg");
                    Log.e(tag, msg2);
                }

                @Override // com.tencent.thread.monitor.plugin.api.ILog
                public void i(@NotNull String tag, @NotNull String msg2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, (Object) tag, (Object) msg2);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(tag, "tag");
                    Intrinsics.checkNotNullParameter(msg2, "msg");
                    Log.i(tag, msg2);
                }

                @Override // com.tencent.thread.monitor.plugin.api.ILog
                public void e(@NotNull String tag, @NotNull String msg2, @NotNull Throwable tr5) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, tag, msg2, tr5);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(tag, "tag");
                    Intrinsics.checkNotNullParameter(msg2, "msg");
                    Intrinsics.checkNotNullParameter(tr5, "tr");
                    Log.e(tag, msg2, tr5);
                }
            };
        }
    }

    @NotNull
    public static final ILog getDefaultLogger() {
        return defaultLogger;
    }
}
