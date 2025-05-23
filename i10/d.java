package i10;

import NS_KING_INTERFACE.stGetFeedCommentListV2Req;
import UserGrowth.stQQGetFeedCommentListV2Req;
import UserGrowth.stQQGetFeedCommentListV2Rsp;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d extends com.tencent.biz.pubaccount.weishi.net.j<stQQGetFeedCommentListV2Rsp> {
    public d(String str, String str2, int i3, String str3, String str4) {
        super("QQGetFeedCommentListV2", 10003);
        this.f80984m = new stQQGetFeedCommentListV2Req(new stGetFeedCommentListV2Req(str, str2, "", 0, "", i3, str3, str4, TextUtils.isEmpty(str) ? 1 : 0));
    }
}
