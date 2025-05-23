package i10;

import UserGrowth.stGetTabsReq;
import UserGrowth.stGetTabsRsp;
import com.tencent.biz.pubaccount.weishi.util.x;

/* compiled from: P */
/* loaded from: classes38.dex */
public class f extends com.tencent.biz.pubaccount.weishi.net.j<stGetTabsRsp> {
    public f() {
        super("GetTabs", 10010);
        stGetTabsReq stgettabsreq = new stGetTabsReq();
        this.f80984m = stgettabsreq;
        x.f("GetTabsRequest", "stGetTabsReq  = " + stgettabsreq.toString());
    }
}
