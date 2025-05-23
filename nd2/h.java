package nd2;

import com.tencent.biz.pubaccount.ecshopassit.EcShopData;
import com.tencent.mobileqq.data.entitymanager.Interceptor;

/* compiled from: P */
/* loaded from: classes16.dex */
public class h extends j {
    @Override // com.tencent.mobileqq.data.entitymanager.Interceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Class intercept(Interceptor.Chain<Class> chain) {
        if (EcShopData.TABLE_NAME.equals(a(chain))) {
            return EcShopData.class;
        }
        return chain.proceed();
    }
}
