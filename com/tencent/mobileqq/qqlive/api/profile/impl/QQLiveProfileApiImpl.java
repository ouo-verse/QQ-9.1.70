package com.tencent.mobileqq.qqlive.api.profile.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.profile.IQQLiveProfileApi;
import com.tencent.mobileqq.qqlive.api.profile.QQProfile;
import com.tencent.mobileqq.qqlive.base.ipc.QQLiveClientQIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/profile/impl/QQLiveProfileApiImpl;", "Lcom/tencent/mobileqq/qqlive/api/profile/IQQLiveProfileApi;", "()V", "getQQProfile", "Lcom/tencent/mobileqq/qqlive/api/profile/QQProfile;", "uin", "", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class QQLiveProfileApiImpl implements IQQLiveProfileApi {
    static IPatchRedirector $redirector_;

    public QQLiveProfileApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.profile.IQQLiveProfileApi
    @Nullable
    public QQProfile getQQProfile(@NotNull String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QQProfile) iPatchRedirector.redirect((short) 2, (Object) this, (Object) uin);
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        return QQLiveClientQIPCModule.INSTANCE.c().getQQProfile(uin);
    }
}
