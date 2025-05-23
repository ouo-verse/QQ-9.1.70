package nd2;

import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.entitymanager.Interceptor;

/* compiled from: P */
/* loaded from: classes16.dex */
public class e extends j {
    @Override // com.tencent.mobileqq.data.entitymanager.Interceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Class intercept(Interceptor.Chain<Class> chain) {
        if (ConversationInfo.getConversationInfoTableName().equals(a(chain))) {
            return ConversationInfo.class;
        }
        return chain.proceed();
    }
}
