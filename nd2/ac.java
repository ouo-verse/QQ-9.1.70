package nd2;

import com.tencent.mobileqq.data.entitymanager.Interceptor;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vashealth.api.IQQHealthApi;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ac extends j {
    @Override // com.tencent.mobileqq.data.entitymanager.Interceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Class intercept(Interceptor.Chain<Class> chain) {
        Class<? extends Entity> tracePointDataClass = ((IQQHealthApi) QRoute.api(IQQHealthApi.class)).getTracePointDataClass();
        if (tracePointDataClass.getSimpleName().equals(a(chain))) {
            return tracePointDataClass;
        }
        return chain.proceed();
    }
}
