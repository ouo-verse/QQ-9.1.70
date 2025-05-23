package bg2;

import com.tencent.ecommerce.base.account.api.INVViewModelInitialization;
import com.tencent.mobileqq.qqecommerce.biz.hr.api.IECHRAccessHelper;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"Lbg2/a;", "Lcom/tencent/ecommerce/base/account/api/INVViewModelInitialization;", "", "init", "<init>", "()V", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a implements INVViewModelInitialization {
    @Override // com.tencent.ecommerce.base.account.api.INVViewModelInitialization
    public void init() {
        ((IECHRAccessHelper) QRoute.api(IECHRAccessHelper.class)).ensureNVViewMVPEnvironment();
    }
}
