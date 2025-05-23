package com.tencent.mobileqq.qqecommerce.base.publicaccount;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ecommerce.base.publicaccount.api.IECPublicAccountManager;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.EcommerceMsgDetailSource;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.IEcommerceMsgCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/base/publicaccount/b;", "Lcom/tencent/ecommerce/base/publicaccount/api/IECPublicAccountManager;", "", "openAccountProfilePage", "<init>", "()V", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b implements IECPublicAccountManager {
    @Override // com.tencent.ecommerce.base.publicaccount.api.IECPublicAccountManager
    public void openAccountProfilePage() {
        if (QLog.isColorLevel()) {
            QLog.d("ECPublicAccountManager", 2, "openAccountProfilePage: ");
        }
        IEcommerceMsgCenter iEcommerceMsgCenter = (IEcommerceMsgCenter) QRoute.api(IEcommerceMsgCenter.class);
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication()");
        iEcommerceMsgCenter.launchDetailPage(application, EcommerceMsgDetailSource.ECOMMERCE_SDK);
    }
}
