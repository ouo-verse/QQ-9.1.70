package hynb.f;

import com.huya.huyasdk.service.api.ILoginService;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b extends hynb.j.b implements ILoginService {
    @Override // com.huya.huyasdk.service.api.ILoginService
    public long getLoginUid() {
        return a.f406701h.b();
    }

    @Override // com.huya.huyasdk.service.api.ILoginService
    public String getToken() {
        return a.f406701h.c();
    }

    @Override // com.huya.huyasdk.service.api.ILoginService
    public void init(hynb.n.b bVar) {
        a.f406701h.a(bVar);
    }

    @Override // com.huya.huyasdk.service.api.ILoginService
    public boolean isLogin() {
        return a.f406701h.e();
    }
}
