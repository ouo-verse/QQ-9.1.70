package i10;

import UserGrowth.stFollowFeedsReq;
import UserGrowth.stFollowFeedsRsp;
import com.tencent.biz.pubaccount.weishi.util.x;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b extends com.tencent.biz.pubaccount.weishi.net.j<stFollowFeedsRsp> {
    public b(String str, boolean z16, boolean z17, String str2, int i3) {
        super("FollowFeeds", i3);
        stFollowFeedsReq stfollowfeedsreq = new stFollowFeedsReq();
        stfollowfeedsreq.attatch_info = str;
        stfollowfeedsreq.is_refresh = z17;
        stfollowfeedsreq.is_first = z16;
        stfollowfeedsreq.push_info = str2;
        stfollowfeedsreq.scene = i3;
        this.f80984m = stfollowfeedsreq;
        x.f("FollowRequest", stfollowfeedsreq.toString());
    }
}
