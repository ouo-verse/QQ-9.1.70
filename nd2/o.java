package nd2;

import com.tencent.mobileqq.data.PrinterItemMsgRecord;
import com.tencent.mobileqq.data.entitymanager.Interceptor;

/* compiled from: P */
/* loaded from: classes16.dex */
public class o extends j {
    @Override // com.tencent.mobileqq.data.entitymanager.Interceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Class intercept(Interceptor.Chain<Class> chain) {
        if (PrinterItemMsgRecord.tableName().equals(a(chain))) {
            return PrinterItemMsgRecord.class;
        }
        return chain.proceed();
    }
}
