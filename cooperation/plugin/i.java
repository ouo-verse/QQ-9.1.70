package cooperation.plugin;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes28.dex */
public class i implements com.tencent.mobileqq.qroute.module.b {

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, com.tencent.mobileqq.qroute.module.a> f390318a = new ConcurrentHashMap<>();

    @Override // com.tencent.mobileqq.qroute.module.b
    public com.tencent.mobileqq.qroute.module.a a(String str) {
        if (str != null && !"".endsWith(str)) {
            com.tencent.mobileqq.qroute.module.a aVar = this.f390318a.get(str);
            if (aVar == null) {
                synchronized (this.f390318a) {
                    aVar = this.f390318a.get(str);
                    if (aVar == null) {
                        aVar = new k(str);
                        this.f390318a.put(str, aVar);
                    }
                }
            }
            return aVar;
        }
        return null;
    }
}
