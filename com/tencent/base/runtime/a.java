package com.tencent.base.runtime;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.j;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ml3.b;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b-\u0018\u0000 \u0004*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\tB\u0007\u00a2\u0006\u0004\b=\u0010>J\u000f\u0010\u0004\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0017J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\"\u0010\u0019\u001a\u00020\u00068\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001e\u001a\u00028\u00008\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u001a\u001a\u0004\b\u001b\u0010\u0005\"\u0004\b\u001c\u0010\u001dR\"\u0010$\u001a\u00020\f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010*\u001a\u00020\u000e8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\r\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u00100\u001a\u00020\u00108\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000f\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00106\u001a\u00020\u00128\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000b\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u0010<\u001a\u00020\b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0013\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;\u00a8\u0006?"}, d2 = {"Lcom/tencent/base/runtime/a;", "", "T", "Lcom/tencent/base/api/runtime/a;", h.F, "()Ljava/lang/Object;", "Landroidx/fragment/app/Fragment;", "c", "Lcom/tencent/mvi/api/runtime/a;", "a", "Landroid/app/Activity;", "f", "Landroidx/lifecycle/LifecycleOwner;", "d", "Lcom/tencent/mvi/base/route/j;", "e", "Lml3/b;", "b", "Lhx/a;", "g", "Landroidx/fragment/app/Fragment;", "k", "()Landroidx/fragment/app/Fragment;", "r", "(Landroidx/fragment/app/Fragment;)V", "mFragment", "Ljava/lang/Object;", "i", "p", "(Ljava/lang/Object;)V", "mBaseParam", "Landroidx/lifecycle/LifecycleOwner;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroidx/lifecycle/LifecycleOwner;", "t", "(Landroidx/lifecycle/LifecycleOwner;)V", "mLifecycleOwner", "Lcom/tencent/mvi/base/route/j;", "o", "()Lcom/tencent/mvi/base/route/j;", "u", "(Lcom/tencent/mvi/base/route/j;)V", "mVMMessenger", "Lml3/b;", "j", "()Lml3/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Lml3/b;)V", "mEmitterService", "Lhx/a;", "l", "()Lhx/a;", ReportConstant.COSTREPORT_PREFIX, "(Lhx/a;)V", "mLauncher", "Lcom/tencent/mvi/api/runtime/a;", DomainData.DOMAIN_NAME, "()Lcom/tencent/mvi/api/runtime/a;", "setMPoster", "(Lcom/tencent/mvi/api/runtime/a;)V", "mPoster", "<init>", "()V", "input-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes2.dex */
public final class a<T> extends com.tencent.base.api.runtime.a<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public Fragment mFragment;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public T mBaseParam;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public LifecycleOwner mLifecycleOwner;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public j mVMMessenger;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public b mEmitterService;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public hx.a mLauncher;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public com.tencent.mvi.api.runtime.a mPoster;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/base/runtime/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "input-base_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.base.runtime.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes2.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38498);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mvi.api.runtime.b
    @NotNull
    public com.tencent.mvi.api.runtime.a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (com.tencent.mvi.api.runtime.a) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return n();
    }

    @Override // com.tencent.mvi.api.runtime.b
    @NotNull
    public b b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (b) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return j();
    }

    @Override // com.tencent.mvi.api.runtime.b
    @NotNull
    public Fragment c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Fragment) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return k();
    }

    @Override // com.tencent.mvi.api.runtime.b
    @NotNull
    public LifecycleOwner d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (LifecycleOwner) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return m();
    }

    @Override // com.tencent.mvi.api.runtime.b
    @NotNull
    public j e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (j) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return o();
    }

    @Override // com.tencent.base.api.runtime.a
    @Deprecated(message = "Deprecated in Java", replaceWith = @ReplaceWith(expression = "getFragment().requireActivity()", imports = {}))
    @NotNull
    public Activity f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Activity) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        FragmentActivity requireActivity = k().requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "mFragment.requireActivity()");
        return requireActivity;
    }

    @Override // com.tencent.base.api.runtime.a
    @NotNull
    public hx.a g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (hx.a) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return l();
    }

    @Override // com.tencent.base.api.runtime.a
    @NotNull
    public T h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (T) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return i();
    }

    @NotNull
    public final T i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (T) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        T t16 = this.mBaseParam;
        if (t16 != null) {
            return t16;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mBaseParam");
        return (T) Unit.INSTANCE;
    }

    @NotNull
    public final b j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (b) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        b bVar = this.mEmitterService;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mEmitterService");
        return null;
    }

    @NotNull
    public final Fragment k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Fragment) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Fragment fragment = this.mFragment;
        if (fragment != null) {
            return fragment;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mFragment");
        return null;
    }

    @NotNull
    public final hx.a l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (hx.a) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        hx.a aVar = this.mLauncher;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mLauncher");
        return null;
    }

    @NotNull
    public final LifecycleOwner m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (LifecycleOwner) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
        if (lifecycleOwner != null) {
            return lifecycleOwner;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mLifecycleOwner");
        return null;
    }

    @NotNull
    public final com.tencent.mvi.api.runtime.a n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (com.tencent.mvi.api.runtime.a) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        com.tencent.mvi.api.runtime.a aVar = this.mPoster;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mPoster");
        return null;
    }

    @NotNull
    public final j o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (j) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        j jVar = this.mVMMessenger;
        if (jVar != null) {
            return jVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mVMMessenger");
        return null;
    }

    public final void p(@NotNull T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) t16);
        } else {
            Intrinsics.checkNotNullParameter(t16, "<set-?>");
            this.mBaseParam = t16;
        }
    }

    public final void q(@NotNull b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bVar);
        } else {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.mEmitterService = bVar;
        }
    }

    public final void r(@NotNull Fragment fragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) fragment);
        } else {
            Intrinsics.checkNotNullParameter(fragment, "<set-?>");
            this.mFragment = fragment;
        }
    }

    public final void s(@NotNull hx.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) aVar);
        } else {
            Intrinsics.checkNotNullParameter(aVar, "<set-?>");
            this.mLauncher = aVar;
        }
    }

    public final void t(@NotNull LifecycleOwner lifecycleOwner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) lifecycleOwner);
        } else {
            Intrinsics.checkNotNullParameter(lifecycleOwner, "<set-?>");
            this.mLifecycleOwner = lifecycleOwner;
        }
    }

    public final void u(@NotNull j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) jVar);
        } else {
            Intrinsics.checkNotNullParameter(jVar, "<set-?>");
            this.mVMMessenger = jVar;
        }
    }
}
