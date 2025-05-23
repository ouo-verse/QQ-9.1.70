package nd2;

import com.tencent.mobileqq.data.entitymanager.Interceptor;
import com.tencent.qidian.data.QidianCorpInfo;

/* compiled from: P */
/* loaded from: classes16.dex */
public class s extends j {
    @Override // com.tencent.mobileqq.data.entitymanager.Interceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Class intercept(Interceptor.Chain<Class> chain) {
        if (QidianCorpInfo.class.getSimpleName().equals(a(chain))) {
            return QidianCorpInfo.class;
        }
        return chain.proceed();
    }
}
