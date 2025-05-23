package nd2;

import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.entitymanager.Interceptor;

/* compiled from: P */
/* loaded from: classes16.dex */
public class f extends j {
    @Override // com.tencent.mobileqq.data.entitymanager.Interceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Class intercept(Interceptor.Chain<Class> chain) {
        if (DataLineMsgRecord.tableName().equals(a(chain))) {
            return DataLineMsgRecord.class;
        }
        return chain.proceed();
    }
}
