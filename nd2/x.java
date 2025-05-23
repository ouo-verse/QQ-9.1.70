package nd2;

import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.entitymanager.Interceptor;

/* compiled from: P */
/* loaded from: classes16.dex */
public class x extends j {
    @Override // com.tencent.mobileqq.data.entitymanager.Interceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Class intercept(Interceptor.Chain<Class> chain) {
        if (RecentUser.TABLE_NAME.equals(a(chain))) {
            return RecentUser.class;
        }
        return chain.proceed();
    }
}
