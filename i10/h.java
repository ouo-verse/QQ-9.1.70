package i10;

import UserGrowth.stQQGroupDetailReq;
import UserGrowth.stQQGroupDetailRsp;
import com.tencent.biz.pubaccount.weishi.util.x;

/* compiled from: P */
/* loaded from: classes38.dex */
public class h extends com.tencent.biz.pubaccount.weishi.net.j<stQQGroupDetailRsp> {
    public h(String str, String str2) {
        super("QQGroupDetail");
        stQQGroupDetailReq stqqgroupdetailreq = new stQQGroupDetailReq();
        stqqgroupdetailreq.groupId = str;
        stqqgroupdetailreq.posterPersonId = str2;
        this.f80984m = stqqgroupdetailreq;
        this.T = 15000L;
        x.f("QQGroupDetailRequest", "QQGroupDetailRequest  = " + stqqgroupdetailreq.toString());
    }
}
