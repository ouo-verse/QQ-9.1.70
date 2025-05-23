package nd2;

import com.tencent.mobileqq.data.QCallRecord;
import com.tencent.mobileqq.data.entitymanager.Interceptor;

/* compiled from: P */
/* loaded from: classes16.dex */
public class r extends j {
    @Override // com.tencent.mobileqq.data.entitymanager.Interceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Class intercept(Interceptor.Chain<Class> chain) {
        if (a(chain).startsWith("qc_")) {
            return QCallRecord.class;
        }
        return chain.proceed();
    }
}
