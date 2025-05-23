package i10;

import UserGrowth.stFeedOpInfo;
import UserGrowth.stGetFeedIconOpReq;
import UserGrowth.stGetFeedIconOpRsp;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes38.dex */
public class e extends com.tencent.biz.pubaccount.weishi.net.j<stGetFeedIconOpRsp> {
    public e(stFeedOpInfo stfeedopinfo, ArrayList<stFeedOpInfo> arrayList, ArrayList<stFeedOpInfo> arrayList2) {
        super("GetFeedIconOp", 10011);
        stGetFeedIconOpReq stgetfeediconopreq = new stGetFeedIconOpReq();
        stgetfeediconopreq.opInfo = stfeedopinfo;
        stgetfeediconopreq.preOpInfos = arrayList;
        stgetfeediconopreq.postOpInfos = arrayList2;
        this.f80984m = stgetfeediconopreq;
    }
}
