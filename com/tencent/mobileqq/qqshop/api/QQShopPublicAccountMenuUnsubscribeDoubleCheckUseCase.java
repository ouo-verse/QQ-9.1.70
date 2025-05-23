package com.tencent.mobileqq.qqshop.api;

import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@KeepClassConstructor
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqshop/api/QQShopPublicAccountMenuUnsubscribeDoubleCheckUseCase;", "Lcom/tencent/biz/pubaccount/recentcontact/b;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQShopPublicAccountMenuUnsubscribeDoubleCheckUseCase implements com.tencent.biz.pubaccount.recentcontact.b {
    static IPatchRedirector $redirector_;

    public QQShopPublicAccountMenuUnsubscribeDoubleCheckUseCase() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.biz.pubaccount.recentcontact.b
    public void a(@NotNull RecentContactInfo item) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        int i3 = item.chatType;
        String valueOf = String.valueOf(item.peerUin);
        if (i3 == 103 && Intrinsics.areEqual(valueOf, IPublicAccountUtil.UIN_FOR_SHOP)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return;
        }
        ((IQQShopApi) QRoute.api(IQQShopApi.class)).afterUnFollowQQShop(1);
    }
}
