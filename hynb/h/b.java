package hynb.h;

import com.huya.huyasdk.service.api.IUdbInfoService;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b extends hynb.j.b implements IUdbInfoService {

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, hynb.n.b> f406728a;

    public b() {
        HashMap hashMap = new HashMap();
        this.f406728a = hashMap;
        a aVar = new a();
        aVar.f406768a = "qq";
        aVar.f406769b = "huyasdk_qq_adr";
        aVar.f406773f = "adr_huyasdk_third";
        hashMap.put("huyasdk_qq_adr", aVar);
        a aVar2 = new a();
        aVar2.f406768a = "qq_test";
        aVar2.f406769b = "huyasdk_qq_adr_test";
        aVar2.f406773f = "adr_huyasdk_third_test";
        hashMap.put("huyasdk_qq_adr_test", aVar2);
    }

    @Override // com.huya.huyasdk.service.api.IUdbInfoService
    public hynb.n.b getUdbInfo(String str) {
        return this.f406728a.get(str);
    }
}
