package nd2;

import com.tencent.mobileqq.data.entitymanager.Interceptor;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

/* compiled from: P */
/* loaded from: classes16.dex */
public class i extends j {
    @Override // com.tencent.mobileqq.data.entitymanager.Interceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Class intercept(Interceptor.Chain<Class> chain) {
        if ("mr_fileManager".equals(a(chain))) {
            return FileManagerEntity.class;
        }
        return chain.proceed();
    }
}
