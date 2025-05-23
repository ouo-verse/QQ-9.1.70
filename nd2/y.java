package nd2;

import com.tencent.mobileqq.data.RoamDate;
import com.tencent.mobileqq.data.entitymanager.Interceptor;

/* compiled from: P */
/* loaded from: classes16.dex */
public class y extends j {
    @Override // com.tencent.mobileqq.data.entitymanager.Interceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Class intercept(Interceptor.Chain<Class> chain) {
        if ("MessageRoamDate".equals(a(chain))) {
            return RoamDate.class;
        }
        return chain.proceed();
    }
}
