package i10;

import UserGrowth.stReportItem;
import UserGrowth.stWeishiReportReq;
import UserGrowth.stWeishiReportRsp;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes38.dex */
public class j extends com.tencent.biz.pubaccount.weishi.net.j<stWeishiReportRsp> {
    public j(ArrayList<stReportItem> arrayList) {
        super("WeishiReport");
        this.f80984m = new stWeishiReportReq(arrayList);
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.j
    public boolean q() {
        return false;
    }
}
