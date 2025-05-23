package com.tencent.qqnt.aio.helper;

import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import kotlin.Deprecated;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/aio/helper/dd;", "Lcom/tencent/aio/main/businesshelper/h;", "", "getId", "", "getTag", "", "interestedIn", "state", "", "onMoveToState", "Lmqq/app/AppRuntime;", "a", "()Lmqq/app/AppRuntime;", "app", "<init>", "()V", "d", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes34.dex */
public final class dd implements com.tencent.aio.main.businesshelper.h {
    private final AppRuntime a() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350686x0;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "QWalletAIOHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onCreate(com.tencent.aio.main.businesshelper.b bVar) {
        h.a.a(this, bVar);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{4};
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        AppRuntime a16;
        IQWalletConfigService iQWalletConfigService;
        if (state != 4 || (a16 = a()) == null || (iQWalletConfigService = (IQWalletConfigService) a16.getRuntimeService(IQWalletConfigService.class, "")) == null) {
            return;
        }
        iQWalletConfigService.tryRequestAllConfig();
    }
}
