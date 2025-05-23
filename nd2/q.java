package nd2;

import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.entitymanager.Interceptor;

/* compiled from: P */
/* loaded from: classes16.dex */
public class q extends j {
    @Override // com.tencent.mobileqq.data.entitymanager.Interceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Class intercept(Interceptor.Chain<Class> chain) {
        if (QCallRecent.TABLE_NAME.equals(a(chain))) {
            return QCallRecent.class;
        }
        return chain.proceed();
    }
}
