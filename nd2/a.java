package nd2;

import com.tencent.mobileqq.data.entitymanager.Interceptor;
import com.tencent.qidian.data.BmqqAccountType;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a extends j {
    @Override // com.tencent.mobileqq.data.entitymanager.Interceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Class intercept(Interceptor.Chain<Class> chain) {
        if (BmqqAccountType.class.getSimpleName().equals(a(chain))) {
            return BmqqAccountType.class;
        }
        return chain.proceed();
    }
}
