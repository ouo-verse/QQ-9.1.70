package nd2;

import com.tencent.mobileqq.data.RouterMsgRecord;
import com.tencent.mobileqq.data.entitymanager.Interceptor;

/* compiled from: P */
/* loaded from: classes16.dex */
public class z extends j {
    @Override // com.tencent.mobileqq.data.entitymanager.Interceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Class intercept(Interceptor.Chain<Class> chain) {
        if (a(chain).startsWith(RouterMsgRecord.tableBasicName())) {
            return RouterMsgRecord.class;
        }
        return chain.proceed();
    }
}
