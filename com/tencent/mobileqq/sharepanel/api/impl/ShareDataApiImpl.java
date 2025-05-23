package com.tencent.mobileqq.sharepanel.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.sharepanel.api.IShareDataApi;
import com.tencent.mobileqq.sharepanel.api.a;
import com.tencent.mobileqq.sharepanel.model.c;
import com.tencent.mobileqq.sharepanel.model.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J(\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006H\u0016J(\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/api/impl/ShareDataApiImpl;", "Lcom/tencent/mobileqq/sharepanel/api/IShareDataApi;", "Lcom/tencent/mobileqq/sharepanel/model/c;", "reqData", "", "bizData", "Lcom/tencent/mobileqq/sharepanel/api/a;", "Lcom/tencent/mobileqq/sharepanel/model/a;", "callback", "", "requestShareArkData", "Lcom/tencent/mobileqq/sharepanel/model/e;", "requestShareURL", "requestShareURL4XHS", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ShareDataApiImpl implements IShareDataApi {
    static IPatchRedirector $redirector_;

    public ShareDataApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.sharepanel.api.IShareDataApi
    public void requestShareArkData(@NotNull c reqData, @Nullable byte[] bizData, @NotNull a<com.tencent.mobileqq.sharepanel.model.a> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, reqData, bizData, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(reqData, "reqData");
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.sharepanel.repo.pb.a.f287583a.c(reqData, 1, bizData, callback);
    }

    @Override // com.tencent.mobileqq.sharepanel.api.IShareDataApi
    public void requestShareURL(@NotNull c reqData, @Nullable byte[] bizData, @NotNull a<e> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, reqData, bizData, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(reqData, "reqData");
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.sharepanel.repo.pb.a.f287583a.c(reqData, 2, bizData, callback);
    }

    @Override // com.tencent.mobileqq.sharepanel.api.IShareDataApi
    public void requestShareURL4XHS(@NotNull c reqData, @Nullable byte[] bizData, @NotNull a<e> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, reqData, bizData, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(reqData, "reqData");
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.sharepanel.repo.pb.a.f287583a.c(reqData, 3, bizData, callback);
    }
}
