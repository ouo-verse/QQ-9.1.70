package nd2;

import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import com.tencent.mobileqq.data.entitymanager.Interceptor;

/* compiled from: P */
/* loaded from: classes16.dex */
public class af extends j {
    @Override // com.tencent.mobileqq.data.entitymanager.Interceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Class intercept(Interceptor.Chain<Class> chain) {
        if (a(chain).startsWith("TroopFileTansferItemEntity")) {
            return TroopFileTansferItemEntity.class;
        }
        return chain.proceed();
    }
}
