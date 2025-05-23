package nd2;

import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.mobileqq.data.entitymanager.Interceptor;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ae extends j {
    @Override // com.tencent.mobileqq.data.entitymanager.Interceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Class intercept(Interceptor.Chain<Class> chain) {
        if (TroopBarData.class.getSimpleName().equals(a(chain))) {
            return TroopBarData.class;
        }
        return chain.proceed();
    }
}
