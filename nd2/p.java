package nd2;

import com.tencent.mobileqq.data.entitymanager.Interceptor;
import com.tencent.qidian.data.PubAccountNavigationMenu;

/* compiled from: P */
/* loaded from: classes16.dex */
public class p extends j {
    @Override // com.tencent.mobileqq.data.entitymanager.Interceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Class intercept(Interceptor.Chain<Class> chain) {
        if (PubAccountNavigationMenu.class.getSimpleName().equals(a(chain))) {
            return PubAccountNavigationMenu.class;
        }
        return chain.proceed();
    }
}
