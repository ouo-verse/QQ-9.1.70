package nd2;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.entitymanager.Interceptor;

/* compiled from: P */
/* loaded from: classes16.dex */
public class n extends j {
    @Override // com.tencent.mobileqq.data.entitymanager.Interceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Class intercept(Interceptor.Chain<Class> chain) {
        if (a(chain).startsWith("mr_")) {
            return MessageRecord.class;
        }
        return chain.proceed();
    }
}
