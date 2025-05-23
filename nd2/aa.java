package nd2;

import com.tencent.mobileqq.data.entitymanager.Interceptor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ArrayUtils;

/* compiled from: P */
/* loaded from: classes16.dex */
public class aa extends j {

    /* renamed from: a, reason: collision with root package name */
    private final String[] f419963a = {"android_metadata", "sqlite_sequence"};

    /* renamed from: b, reason: collision with root package name */
    private final String[] f419964b = {"msg_sync_log", "msg_upgrade_log"};

    @Override // com.tencent.mobileqq.data.entitymanager.Interceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Class intercept(Interceptor.Chain<Class> chain) {
        String a16 = a(chain);
        if (!ArrayUtils.contains(this.f419963a, a16) && !ArrayUtils.contains(this.f419964b, a16)) {
            return chain.proceed();
        }
        if (QLog.isColorLevel()) {
            QLog.d("SystemOrNoEntityInterceptor", 2, "check table with " + a16 + " is system or no entity table");
            return null;
        }
        return null;
    }
}
