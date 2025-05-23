package i10;

import UserGrowth.stFriendFeedReq;
import UserGrowth.stFriendFeedRsp;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c extends com.tencent.biz.pubaccount.weishi.net.j<stFriendFeedRsp> {
    public c(String str) {
        super("FriendFeed", 10006);
        stFriendFeedReq stfriendfeedreq = new stFriendFeedReq();
        stfriendfeedreq.attachInfo = str;
        this.f80984m = stfriendfeedreq;
    }
}
