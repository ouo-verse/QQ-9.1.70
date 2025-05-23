package com.tencent.mobileqq.login.fragment;

import com.tencent.mobileqq.login.y;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\n\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R%\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/login/fragment/w;", "Lcom/tencent/mobileqq/login/y;", "", "msg", "", "a", "", "loginSuccess", "b", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/login/fragment/BaseLoginFragment;", "kotlin.jvm.PlatformType", "Lmqq/util/WeakReference;", "getWeakFragment", "()Lmqq/util/WeakReference;", "weakFragment", "fragment", "<init>", "(Lcom/tencent/mobileqq/login/fragment/BaseLoginFragment;)V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class w implements y {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<BaseLoginFragment> weakFragment;

    public w(@NotNull BaseLoginFragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fragment);
        } else {
            this.weakFragment = new WeakReference<>(fragment);
        }
    }

    @Override // com.tencent.mobileqq.login.y
    public void a(@Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) msg2);
            return;
        }
        BaseLoginFragment baseLoginFragment = this.weakFragment.get();
        if (baseLoginFragment != null) {
            baseLoginFragment.showLoading(msg2);
        }
    }

    @Override // com.tencent.mobileqq.login.y
    public void b(boolean loginSuccess) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, loginSuccess);
            return;
        }
        BaseLoginFragment baseLoginFragment = this.weakFragment.get();
        if (baseLoginFragment != null) {
            baseLoginFragment.hideLoading();
        }
    }
}
