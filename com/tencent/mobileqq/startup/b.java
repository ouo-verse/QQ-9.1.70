package com.tencent.mobileqq.startup;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0004R\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/startup/b;", "", "", "state", "", "b", "a", "", com.tencent.mobileqq.msf.core.net.r.a.f248963o, "d", "c", "I", "currentState", "<init>", "()V", "qqbase_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f289681a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int currentState;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37170);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f289681a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b(int state) {
        if (currentState == state) {
            return;
        }
        if (state >= 0 && state <= 4) {
            currentState = state;
            QLog.d("StartupState", 1, "Switch to state: " + state);
            return;
        }
        QLog.d("StartupState", 1, "Not support state: " + state);
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return currentState;
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 4;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        int i16 = currentState;
        if (i16 != 0 && i16 != 1) {
            if (i16 != 3) {
                i3 = i16;
            }
        } else {
            i3 = 2;
        }
        b(i3);
    }

    public final void d(boolean foreground) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 3;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, foreground);
        } else {
            if (currentState != 0) {
                return;
            }
            if (foreground) {
                i3 = 1;
            }
            b(i3);
        }
    }
}
