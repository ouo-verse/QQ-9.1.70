package nd2;

import com.tencent.mobileqq.data.entitymanager.Interceptor;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ad extends j {
    @Override // com.tencent.mobileqq.data.entitymanager.Interceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Class intercept(Interceptor.Chain<Class> chain) {
        if (TroopAIOAppInfo.class.getSimpleName().equals(a(chain))) {
            return TroopAIOAppInfo.class;
        }
        return chain.proceed();
    }
}
