package com.tencent.mobileqq.qqlive.callback.auth;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.callback.BaseCallback;
import com.tencent.mobileqq.qqlive.data.auth.QQLiveRealNameAuthData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/callback/auth/IQQLiveGetRealNameAuthCallback;", "Lcom/tencent/mobileqq/qqlive/callback/BaseCallback;", "()V", "onFailed", "", "errorCode", "", "errorMsg", "", "onSuccess", "authData", "Lcom/tencent/mobileqq/qqlive/data/auth/QQLiveRealNameAuthData;", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public class IQQLiveGetRealNameAuthCallback implements BaseCallback {
    static IPatchRedirector $redirector_;

    public IQQLiveGetRealNameAuthCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.BaseCallback
    public void onFailed(int errorCode, @Nullable String errorMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, errorCode, (Object) errorMsg);
        }
    }

    public void onSuccess(@NotNull QQLiveRealNameAuthData authData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) authData);
        } else {
            Intrinsics.checkNotNullParameter(authData, "authData");
        }
    }
}
