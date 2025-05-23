package nd2;

import com.tencent.mobileqq.data.entitymanager.FindTableNameInterceptorChain;
import com.tencent.mobileqq.data.entitymanager.Interceptor;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class j implements Interceptor<Class> {
    /* JADX INFO: Access modifiers changed from: protected */
    public String a(Interceptor.Chain chain) {
        if (chain instanceof FindTableNameInterceptorChain) {
            return ((FindTableNameInterceptorChain) chain).tableName;
        }
        return "";
    }
}
