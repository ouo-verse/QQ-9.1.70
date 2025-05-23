package com.tencent.mobileqq.login.fragment;

import android.os.Bundle;
import com.qq.e.comm.constants.TangramHippyConstants;
import com.tencent.mobileqq.login.aa;
import com.tencent.mobileqq.login.aj;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u0012\u0006\u0010\u0010\u001a\u00020\f\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016R\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00120\u00120\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/login/fragment/v;", "Lcom/tencent/mobileqq/login/aa;", "", "uin", "Landroid/os/Bundle;", "bundle", "", "c", "Lcom/tencent/mobileqq/login/aj;", "failedInfo", "b", "a", "", "I", "getLoginType", "()I", TangramHippyConstants.LOGIN_TYPE, "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/login/fragment/BaseLoginFragment;", "kotlin.jvm.PlatformType", "Lmqq/util/WeakReference;", "weakFragment", "fragment", "<init>", "(Lcom/tencent/mobileqq/login/fragment/BaseLoginFragment;I)V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class v implements aa {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int loginType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<BaseLoginFragment> weakFragment;

    public v(@NotNull BaseLoginFragment fragment, int i3) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fragment, i3);
        } else {
            this.loginType = i3;
            this.weakFragment = new WeakReference<>(fragment);
        }
    }

    @Override // com.tencent.mobileqq.login.aa
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        BaseLoginFragment baseLoginFragment = this.weakFragment.get();
        if (baseLoginFragment != null) {
            baseLoginFragment.Jh(this.loginType);
        }
    }

    @Override // com.tencent.mobileqq.login.aa
    public void b(@Nullable aj failedInfo) {
        BaseLoginFragment baseLoginFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) failedInfo);
        } else if (failedInfo != null && (baseLoginFragment = this.weakFragment.get()) != null) {
            baseLoginFragment.Kh(this.loginType, failedInfo);
        }
    }

    @Override // com.tencent.mobileqq.login.aa
    public void c(@Nullable String uin, @Nullable Bundle bundle) {
        BaseLoginFragment baseLoginFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) uin, (Object) bundle);
        } else if (uin != null && (baseLoginFragment = this.weakFragment.get()) != null) {
            baseLoginFragment.Lh(this.loginType, uin, bundle);
        }
    }
}
