package com.tencent.mobileqq.aio.input.at.common.launch;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.aio.input.at.common.c;
import com.tencent.mobileqq.aio.input.at.common.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001\u0005B\u0007\u00a2\u0006\u0004\b&\u0010'R\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00138\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0014\u001a\u0004\b\f\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\u00020\u00198\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010%\u001a\u00028\u00008\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b \u0010\"\"\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/common/launch/a;", "Lcom/tencent/mobileqq/aio/input/at/common/c;", "T", "", "Landroid/view/View;", "a", "Landroid/view/View;", "()Landroid/view/View;", "f", "(Landroid/view/View;)V", "anchor", "Landroid/content/Context;", "b", "Landroid/content/Context;", "c", "()Landroid/content/Context;", h.F, "(Landroid/content/Context;)V", "context", "Lcom/tencent/mobileqq/aio/input/at/common/a;", "Lcom/tencent/mobileqq/aio/input/at/common/a;", "()Lcom/tencent/mobileqq/aio/input/at/common/a;", "g", "(Lcom/tencent/mobileqq/aio/input/at/common/a;)V", "configuration", "Lcom/tencent/mobileqq/aio/input/at/common/e;", "d", "Lcom/tencent/mobileqq/aio/input/at/common/e;", "()Lcom/tencent/mobileqq/aio/input/at/common/e;", "i", "(Lcom/tencent/mobileqq/aio/input/at/common/e;)V", "dialogListener", "e", "Lcom/tencent/mobileqq/aio/input/at/common/c;", "()Lcom/tencent/mobileqq/aio/input/at/common/c;", "j", "(Lcom/tencent/mobileqq/aio/input/at/common/c;)V", "params", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a<T extends c> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public View anchor;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public Context context;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public com.tencent.mobileqq.aio.input.at.common.a<T> configuration;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public e dialogListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public T params;

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\b\u001a\u00020\u0007J\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\nJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u000e\u001a\u00020\rJ\u001b\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0010\u001a\u00028\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/common/launch/a$a;", "Lcom/tencent/mobileqq/aio/input/at/common/c;", "T", "", "Landroid/view/View;", "anchor", "a", "Landroid/content/Context;", "context", "d", "Lcom/tencent/mobileqq/aio/input/at/common/a;", "configuration", "c", "Lcom/tencent/mobileqq/aio/input/at/common/e;", "dialogListener", "e", "params", "f", "(Lcom/tencent/mobileqq/aio/input/at/common/c;)Lcom/tencent/mobileqq/aio/input/at/common/launch/a$a;", "Lcom/tencent/mobileqq/aio/input/at/common/launch/a;", "b", "Lcom/tencent/mobileqq/aio/input/at/common/launch/a;", "createParams", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.at.common.launch.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C7255a<T extends c> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final a<T> createParams;

        public C7255a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.createParams = new a<>();
            }
        }

        @NotNull
        public final C7255a<T> a(@NotNull View anchor) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (C7255a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) anchor);
            }
            Intrinsics.checkNotNullParameter(anchor, "anchor");
            this.createParams.f(anchor);
            return this;
        }

        @NotNull
        public final a<T> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (a) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.createParams;
        }

        @NotNull
        public final C7255a<T> c(@NotNull com.tencent.mobileqq.aio.input.at.common.a<T> configuration) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (C7255a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) configuration);
            }
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            this.createParams.g(configuration);
            return this;
        }

        @NotNull
        public final C7255a<T> d(@NotNull Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (C7255a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            this.createParams.h(context);
            return this;
        }

        @NotNull
        public final C7255a<T> e(@NotNull e dialogListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (C7255a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) dialogListener);
            }
            Intrinsics.checkNotNullParameter(dialogListener, "dialogListener");
            this.createParams.i(dialogListener);
            return this;
        }

        @NotNull
        public final C7255a<T> f(@NotNull T params) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (C7255a) iPatchRedirector.redirect((short) 6, (Object) this, (Object) params);
            }
            Intrinsics.checkNotNullParameter(params, "params");
            this.createParams.j(params);
            return this;
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final View a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        View view = this.anchor;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("anchor");
        return null;
    }

    @NotNull
    public final com.tencent.mobileqq.aio.input.at.common.a<T> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.aio.input.at.common.a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        com.tencent.mobileqq.aio.input.at.common.a<T> aVar = this.configuration;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("configuration");
        return null;
    }

    @NotNull
    public final Context c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Context) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        Context context = this.context;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("context");
        return null;
    }

    @NotNull
    public final e d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (e) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        e eVar = this.dialogListener;
        if (eVar != null) {
            return eVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dialogListener");
        return null;
    }

    @NotNull
    public final T e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (T) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        T t16 = this.params;
        if (t16 != null) {
            return t16;
        }
        Intrinsics.throwUninitializedPropertyAccessException("params");
        return null;
    }

    public final void f(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.anchor = view;
        }
    }

    public final void g(@NotNull com.tencent.mobileqq.aio.input.at.common.a<T> aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
        } else {
            Intrinsics.checkNotNullParameter(aVar, "<set-?>");
            this.configuration = aVar;
        }
    }

    public final void h(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
        } else {
            Intrinsics.checkNotNullParameter(context, "<set-?>");
            this.context = context;
        }
    }

    public final void i(@NotNull e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) eVar);
        } else {
            Intrinsics.checkNotNullParameter(eVar, "<set-?>");
            this.dialogListener = eVar;
        }
    }

    public final void j(@NotNull T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) t16);
        } else {
            Intrinsics.checkNotNullParameter(t16, "<set-?>");
            this.params = t16;
        }
    }
}
