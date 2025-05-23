package i10;

import UserGrowth.stNotificationReq;
import UserGrowth.stNotificationRsp;
import com.tencent.biz.pubaccount.weishi.util.WeishiLinkUtil;
import com.tencent.biz.pubaccount.weishi.util.x;

/* compiled from: P */
/* loaded from: classes38.dex */
public class g extends com.tencent.biz.pubaccount.weishi.net.j<stNotificationRsp> {
    public g(String str) {
        super("Notification", 4);
        stNotificationReq stnotificationreq = new stNotificationReq();
        stnotificationreq.linkStrategyArgs = WeishiLinkUtil.i();
        stnotificationreq.push_info = str;
        this.f80984m = stnotificationreq;
        x.b("NotificationRequest", "stNotificationReq = " + stnotificationreq.toString());
    }
}
