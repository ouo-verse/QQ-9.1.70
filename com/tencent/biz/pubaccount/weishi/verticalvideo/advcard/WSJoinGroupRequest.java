package com.tencent.biz.pubaccount.weishi.verticalvideo.advcard;

import UserGrowth.stJoinGroupReq;
import UserGrowth.stJoinGroupRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/WSJoinGroupRequest;", "Lcom/tencent/biz/pubaccount/weishi/net/common/g;", "LUserGrowth/stJoinGroupRsp;", "Ljava/lang/Class;", "getRspClass", "", "qqGroupNum", "groupPid", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSJoinGroupRequest extends com.tencent.biz.pubaccount.weishi.net.common.g<stJoinGroupRsp> {
    private static final String CMD_STRING = "JoinGroup";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WSJoinGroupRequest(String qqGroupNum, String groupPid) {
        super(new stJoinGroupReq(qqGroupNum, groupPid), CMD_STRING);
        Intrinsics.checkNotNullParameter(qqGroupNum, "qqGroupNum");
        Intrinsics.checkNotNullParameter(groupPid, "groupPid");
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public Class<stJoinGroupRsp> getRspClass() {
        return stJoinGroupRsp.class;
    }
}
