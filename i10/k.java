package i10;

import UserGrowth.eConfigBit;
import UserGrowth.stUserConfigReq;
import UserGrowth.stUserConfigRsp;

/* compiled from: P */
/* loaded from: classes38.dex */
public class k extends com.tencent.biz.pubaccount.weishi.net.j<stUserConfigRsp> {
    public k(eConfigBit econfigbit) {
        super("UserConfig", 10005);
        stUserConfigReq stuserconfigreq = new stUserConfigReq();
        stuserconfigreq.config_set = econfigbit.value();
        this.f80984m = stuserconfigreq;
    }
}
