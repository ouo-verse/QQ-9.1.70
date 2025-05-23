package com.tencent.biz.pubaccount.weishi.share.ark;

import UserGrowth.stSendarkMsgReq;
import UserGrowth.stSendarkMsgRsp;
import com.tencent.biz.pubaccount.weishi.net.common.g;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B7\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\u0005\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/share/ark/WSSendArkMsgRequest;", "Lcom/tencent/biz/pubaccount/weishi/net/common/g;", "LUserGrowth/stSendarkMsgRsp;", "Ljava/lang/Class;", "getRspClass", "", QQBrowserActivity.KEY_MSG_TYPE, "", "uin", "troopUin", "", "sharePid", "shareFeedId", "shareType", "<init>", "(IJJLjava/lang/String;Ljava/lang/String;I)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSSendArkMsgRequest extends g<stSendarkMsgRsp> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WSSendArkMsgRequest(int i3, long j3, long j16, String sharePid, String shareFeedId, int i16) {
        super(stSendarkMsgReq.WNS_COMMAND, 10020);
        Intrinsics.checkNotNullParameter(sharePid, "sharePid");
        Intrinsics.checkNotNullParameter(shareFeedId, "shareFeedId");
        stSendarkMsgReq stsendarkmsgreq = new stSendarkMsgReq();
        stsendarkmsgreq.msgType = i3;
        stsendarkmsgreq.receiveUin = j3;
        stsendarkmsgreq.groupCode = j16;
        stsendarkmsgreq.ark = null;
        stsendarkmsgreq.sharePid = sharePid;
        stsendarkmsgreq.shareFeedid = shareFeedId;
        stsendarkmsgreq.shareType = i16;
        this.req = stsendarkmsgreq;
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public Class<stSendarkMsgRsp> getRspClass() {
        return stSendarkMsgRsp.class;
    }
}
