package com.tencent.biz.pubaccount.weishi.request.newreq;

import UserGrowth.stGetSubjectMsgDetailReq;
import UserGrowth.stGetSubjectMsgDetailRsp;
import com.tencent.biz.pubaccount.weishi.net.common.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/request/newreq/WSMsgDetailRequest;", "Lcom/tencent/biz/pubaccount/weishi/net/common/g;", "LUserGrowth/stGetSubjectMsgDetailRsp;", "Ljava/lang/Class;", "getRspClass", "", "attachInfo", "Ljava/lang/String;", "", "subjectID", "I", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSMsgDetailRequest extends g<stGetSubjectMsgDetailRsp> {
    public static final String CMD_STRING = "GetSubjectMsgDetail";
    private String attachInfo;
    private int subjectID;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WSMsgDetailRequest(String attachInfo, int i3) {
        super(CMD_STRING);
        Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
        this.attachInfo = attachInfo;
        this.subjectID = i3;
        this.req = new stGetSubjectMsgDetailReq(attachInfo, i3);
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public Class<stGetSubjectMsgDetailRsp> getRspClass() {
        return stGetSubjectMsgDetailRsp.class;
    }
}
