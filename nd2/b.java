package nd2;

import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.data.entitymanager.Interceptor;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b extends j {
    @Override // com.tencent.mobileqq.data.entitymanager.Interceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Class intercept(Interceptor.Chain<Class> chain) {
        if (CardProfile.tableName().equals(a(chain))) {
            return CardProfile.class;
        }
        return chain.proceed();
    }
}
