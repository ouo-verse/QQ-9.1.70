package com.tencent.mobileqq.mini.server.request;

import com.tencent.mobileqq.mini.server.BaseMiniAppSSORequest;
import com.tencent.trpcprotocol.minigame.pc_guide.CustomPushMsg;
import com.tencent.trpcprotocol.minigame.pc_guide.PCGuideConfirmReq;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/mini/server/request/PCGuideConfirmRequest;", "Lcom/tencent/mobileqq/mini/server/BaseMiniAppSSORequest;", "appId", "", "title", "imageUrl", "fromCP", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getCmd", "getRequestData", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class PCGuideConfirmRequest implements BaseMiniAppSSORequest {
    private final String appId;
    private final boolean fromCP;
    private final String imageUrl;
    private final String title;

    public PCGuideConfirmRequest(String appId, String str, String str2, boolean z16) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        this.appId = appId;
        this.title = str;
        this.imageUrl = str2;
        this.fromCP = z16;
    }

    @Override // com.tencent.mobileqq.mini.server.BaseMiniAppSSORequest
    public String getCmd() {
        return "miniapp.trpc.minigame.pc_guide.PcGuide.PCGuideConfirm";
    }

    @Override // com.tencent.mobileqq.mini.server.BaseMiniAppSSORequest
    public byte[] getRequestData() {
        PCGuideConfirmReq pCGuideConfirmReq = new PCGuideConfirmReq();
        pCGuideConfirmReq.appid.set(this.appId);
        if (this.title != null || this.imageUrl != null) {
            CustomPushMsg customPushMsg = new CustomPushMsg();
            customPushMsg.title.set(this.title);
            customPushMsg.cover.set(this.imageUrl);
            pCGuideConfirmReq.push_msg.set(customPushMsg);
        }
        pCGuideConfirmReq.src.set(this.fromCP ? 1 : 0);
        byte[] byteArray = pCGuideConfirmReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        return byteArray;
    }
}
