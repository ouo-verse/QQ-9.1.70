package nd2;

import com.tencent.mobileqq.confess.ConfessConvInfo;
import com.tencent.mobileqq.data.entitymanager.Interceptor;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d extends j {
    @Override // com.tencent.mobileqq.data.entitymanager.Interceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Class intercept(Interceptor.Chain<Class> chain) {
        if (ConfessConvInfo.getConversationInfoTableName().equals(a(chain))) {
            return ConfessConvInfo.class;
        }
        return chain.proceed();
    }
}
