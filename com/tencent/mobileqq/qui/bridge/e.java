package com.tencent.mobileqq.qui.bridge;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010\t\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J9\u0010\f\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b0\n\"\u0004\u0018\u00010\u000bH\u0016\u00a2\u0006\u0004\b\f\u0010\rJ9\u0010\u000e\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b0\n\"\u0004\u0018\u00010\u000bH\u0016\u00a2\u0006\u0004\b\u000e\u0010\rJ9\u0010\u000f\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b0\n\"\u0004\u0018\u00010\u000bH\u0016\u00a2\u0006\u0004\b\u000f\u0010\rJ\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\u0012\u0010\u0014\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0013H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/qui/bridge/e;", "Ltd0/b;", "", "tag", "", "var2", "msg", "", "i", "w", "", "", "b", "(Ljava/lang/String;I[Ljava/lang/Object;)V", "d", "e", "", "isColorLevel", "isDevelopLevel", "", "a", "<init>", "()V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class e implements td0.b {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // td0.b
    @NotNull
    public String a(@Nullable Throwable e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this, (Object) e16);
        }
        String stackTraceString = QLog.getStackTraceString(e16);
        Intrinsics.checkNotNullExpressionValue(stackTraceString, "getStackTraceString(e)");
        return stackTraceString;
    }

    @Override // td0.b
    public void b(@Nullable String tag, int var2, @NotNull Object... msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, tag, Integer.valueOf(var2), msg2);
        } else {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.d(tag, var2, Arrays.copyOf(msg2, msg2.length));
        }
    }

    @Override // td0.b
    public void d(@Nullable String tag, int var2, @NotNull Object... msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, tag, Integer.valueOf(var2), msg2);
        } else {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.d(tag, var2, Arrays.copyOf(msg2, msg2.length));
        }
    }

    @Override // td0.b
    public void e(@Nullable String tag, int var2, @NotNull Object... msg2) {
        Throwable th5;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, tag, Integer.valueOf(var2), msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        int length = msg2.length;
        while (true) {
            if (i3 < length) {
                Object obj = msg2[i3];
                if (obj instanceof Throwable) {
                    th5 = (Throwable) obj;
                    break;
                }
                i3++;
            } else {
                th5 = null;
                break;
            }
        }
        QLog.e(tag, var2, th5, Arrays.copyOf(msg2, msg2.length));
    }

    @Override // td0.b
    public void i(@Nullable String tag, int var2, @Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, tag, Integer.valueOf(var2), msg2);
        } else {
            QLog.i(tag, var2, msg2);
        }
    }

    @Override // td0.b
    public boolean isColorLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return QLog.isColorLevel();
    }

    @Override // td0.b
    public boolean isDevelopLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return QLog.isDevelopLevel();
    }

    @Override // td0.b
    public void w(@Nullable String tag, int var2, @Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, tag, Integer.valueOf(var2), msg2);
        } else {
            QLog.w(tag, var2, msg2);
        }
    }
}
