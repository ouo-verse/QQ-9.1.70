package com.tencent.mobileqq.qqlive.room.anchorcenter;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.verified.IQQLiveVerifyService;
import com.tencent.mobileqq.qqlive.callback.auth.IQQLiveGetRealNameAuthCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/anchorcenter/f;", "Lcom/tencent/mobileqq/mvvm/a;", "", "sceneType", "Lcom/tencent/mobileqq/qqlive/callback/auth/IQQLiveGetRealNameAuthCallback;", "callback", "", "j", "Lcom/tencent/mobileqq/qqlive/api/IQQLiveSDK;", "a", "Lcom/tencent/mobileqq/qqlive/api/IQQLiveSDK;", "sdk", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class f extends com.tencent.mobileqq.mvvm.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IQQLiveSDK sdk;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.sdk = com.tencent.mobileqq.qqlive.base.sdk.a.c(null);
        }
    }

    public final void j(int sceneType, @NotNull IQQLiveGetRealNameAuthCallback callback) {
        IQQLiveVerifyService qQLiveVerifyModule;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, sceneType, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        IQQLiveSDK iQQLiveSDK = this.sdk;
        if (iQQLiveSDK != null && (qQLiveVerifyModule = iQQLiveSDK.getQQLiveVerifyModule()) != null) {
            qQLiveVerifyModule.getRealNameAuthState(sceneType, callback);
        }
    }
}
