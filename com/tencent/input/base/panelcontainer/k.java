package com.tencent.input.base.panelcontainer;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00042\u00020\u0001:\u0003\u0004\u0005\u0006B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/input/base/panelcontainer/k;", "Lcom/tencent/mvi/api/ability/d;", "<init>", "()V", "a", "b", "c", "input-base_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public class k implements com.tencent.mvi.api.ability.d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/input/base/panelcontainer/k$a;", "", "", "CURRENT_HEIGHT", "Ljava/lang/String;", "CURRENT_PANEL_ID", "IS_SHOW_PANEL", "NORMAL_PANEL_HEIGHT", "<init>", "()V", "input-base_debug"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.tencent.input.base.panelcontainer.k$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/input/base/panelcontainer/k$b;", "Lcom/tencent/input/base/panelcontainer/k;", "<init>", "()V", "input-base_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes7.dex */
    public static final class b extends k {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public static final b f116864b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33227);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f116864b = new b();
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/input/base/panelcontainer/k$c;", "Lcom/tencent/input/base/panelcontainer/k;", "Landroid/os/Bundle;", "c", "Landroid/os/Bundle;", "a", "()Landroid/os/Bundle;", "args", "<init>", "()V", "input-base_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes7.dex */
    public static final class c extends k {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public static final c f116865b;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final Bundle args;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33260);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f116865b = new c();
                args = new Bundle();
            }
        }

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @NotNull
        public final Bundle a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bundle) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return args;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33264);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
