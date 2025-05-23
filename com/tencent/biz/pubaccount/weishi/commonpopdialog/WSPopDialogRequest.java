package com.tencent.biz.pubaccount.weishi.commonpopdialog;

import UserGrowth.stGetUserPopWindowsReq;
import UserGrowth.stGetUserPopWindowsRsp;
import com.tencent.biz.pubaccount.weishi.net.common.g;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/commonpopdialog/WSPopDialogRequest;", "Lcom/tencent/biz/pubaccount/weishi/net/common/g;", "LUserGrowth/stGetUserPopWindowsRsp;", "Ljava/lang/Class;", "getRspClass", "<init>", "()V", "Companion", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSPopDialogRequest extends g<stGetUserPopWindowsRsp> {
    private static final String CMD = "GetUserPopWindows";

    public WSPopDialogRequest() {
        super(CMD);
        this.req = new stGetUserPopWindowsReq();
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public Class<stGetUserPopWindowsRsp> getRspClass() {
        return stGetUserPopWindowsRsp.class;
    }
}
