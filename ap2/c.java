package ap2;

import com.tencent.mobileqq.config.ai;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public String f26682a = null;

    public static c a(ai[] aiVarArr) {
        String str;
        c cVar = new c();
        if (aiVarArr != null && aiVarArr.length > 0) {
            str = aiVarArr[0].f202268b;
        } else {
            str = null;
        }
        cVar.f26682a = str;
        QLog.i("search_manager_configSearchConfigBean", 1, "parse content=" + str);
        return cVar;
    }
}
