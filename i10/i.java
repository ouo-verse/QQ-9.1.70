package i10;

import UserGrowth.stSimpleGetFeedListReq;
import UserGrowth.stSimpleGetFeedListRsp;
import com.tencent.biz.pubaccount.weishi.util.WeishiLinkUtil;
import com.tencent.biz.pubaccount.weishi.util.bb;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes38.dex */
public class i extends com.tencent.biz.pubaccount.weishi.net.j<stSimpleGetFeedListRsp> {
    public i(String str, byte b16, byte b17, ArrayList<String> arrayList, int i3, String str2, String str3, String str4, String str5) {
        super("SimpleGetFeedList", i3);
        stSimpleGetFeedListReq stsimplegetfeedlistreq = new stSimpleGetFeedListReq();
        stsimplegetfeedlistreq.attach_info = str;
        stsimplegetfeedlistreq.isrefresh = b16;
        stsimplegetfeedlistreq.isfirst = b17;
        stsimplegetfeedlistreq.channel_info = "from_android_qq";
        stsimplegetfeedlistreq.context_feedids = arrayList;
        stsimplegetfeedlistreq.scene = i3;
        stsimplegetfeedlistreq.gdt_args = str2;
        stsimplegetfeedlistreq.rowkey = str3;
        stsimplegetfeedlistreq.session = str4;
        stsimplegetfeedlistreq.push_info = str5;
        stsimplegetfeedlistreq.linkStragetyArgs = WeishiLinkUtil.i();
        stsimplegetfeedlistreq.qqNum = bb.y();
        stsimplegetfeedlistreq.feedsVideoType = new HashMap();
        this.f80984m = stsimplegetfeedlistreq;
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.j
    public String j() {
        if (this.S == 8) {
            return com.tencent.biz.pubaccount.weishi.config.experiment.e.c().b();
        }
        return super.j();
    }
}
