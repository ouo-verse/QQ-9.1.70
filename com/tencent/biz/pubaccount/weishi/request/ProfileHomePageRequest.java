package com.tencent.biz.pubaccount.weishi.request;

import UserGrowth.stGetPersonalInfoReq;
import UserGrowth.stGetPersonalInfoRsp;
import com.tencent.biz.pubaccount.weishi.net.common.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/request/ProfileHomePageRequest;", "Lcom/tencent/biz/pubaccount/weishi/net/common/g;", "LUserGrowth/stGetPersonalInfoRsp;", "Ljava/lang/Class;", "getRspClass", "", "pid", "<init>", "(Ljava/lang/String;)V", "Companion", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class ProfileHomePageRequest extends g<stGetPersonalInfoRsp> {
    private static final String CMD = "GetPersonalInfo";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileHomePageRequest(String pid) {
        super(CMD, 10015);
        Intrinsics.checkNotNullParameter(pid, "pid");
        this.req = new stGetPersonalInfoReq(pid);
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public Class<stGetPersonalInfoRsp> getRspClass() {
        return stGetPersonalInfoRsp.class;
    }
}
