package nd2;

import com.tencent.mobileqq.data.entitymanager.Interceptor;
import com.tencent.mobileqq.gamecenter.message.UinToTinyId;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ag extends j {
    @Override // com.tencent.mobileqq.data.entitymanager.Interceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Class intercept(Interceptor.Chain<Class> chain) {
        if (UinToTinyId.getTinyTableName().equals(a(chain))) {
            return UinToTinyId.class;
        }
        return chain.proceed();
    }
}
