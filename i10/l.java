package i10;

import UserGrowth.stGetAllABTestPolicyReq;
import UserGrowth.stGetAllABTestPolicyRsp;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.common.app.BaseApplicationImpl;

/* compiled from: P */
/* loaded from: classes38.dex */
public class l extends com.tencent.biz.pubaccount.weishi.net.j<stGetAllABTestPolicyRsp> {
    public l(String str) {
        super("GetAllABTestPolicy", 10009);
        stGetAllABTestPolicyReq stgetallabtestpolicyreq = new stGetAllABTestPolicyReq();
        stgetallabtestpolicyreq.uin = str;
        stgetallabtestpolicyreq.hasInstalledWeishi = com.tencent.biz.qqstory.utils.l.c(BaseApplicationImpl.getApplication());
        this.f80984m = stgetallabtestpolicyreq;
        x.j("WSGetABTestPolicyRequest", "[WSGetABTestPolicyRequest] uin:" + stgetallabtestpolicyreq.uin + ", hasInstalledWeishi:" + stgetallabtestpolicyreq.hasInstalledWeishi);
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.j
    public boolean q() {
        return false;
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.j
    public boolean t() {
        return false;
    }
}
