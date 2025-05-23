package nd2;

import com.tencent.mobileqq.data.entitymanager.Interceptor;
import com.tencent.qidian.data.QidianInternalInfo;

/* compiled from: P */
/* loaded from: classes16.dex */
public class u extends j {
    @Override // com.tencent.mobileqq.data.entitymanager.Interceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Class intercept(Interceptor.Chain<Class> chain) {
        if (QidianInternalInfo.class.getSimpleName().equals(a(chain))) {
            return QidianInternalInfo.class;
        }
        return chain.proceed();
    }
}
