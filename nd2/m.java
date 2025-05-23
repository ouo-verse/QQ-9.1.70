package nd2;

import com.dataline.mpfile.MpfileTaskRecord;
import com.tencent.mobileqq.data.entitymanager.Interceptor;

/* compiled from: P */
/* loaded from: classes16.dex */
public class m extends j {
    @Override // com.tencent.mobileqq.data.entitymanager.Interceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Class intercept(Interceptor.Chain<Class> chain) {
        if (MpfileTaskRecord.tableName().equals(a(chain))) {
            return MpfileTaskRecord.class;
        }
        return chain.proceed();
    }
}
