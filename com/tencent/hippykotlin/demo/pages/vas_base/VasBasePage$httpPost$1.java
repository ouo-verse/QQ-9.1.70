package com.tencent.hippykotlin.demo.pages.vas_base;

import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import cooperation.qzone.util.WnsNetworkConst;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage", f = "VasBasePage.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}, l = {WnsNetworkConst.NETWORK_DISABLE, TVKQQLiveAssetPlayerMsg.PLAYER_INFO_CGI_REQUEST, TVKQQLiveAssetPlayerMsg.PLAYER_INFO_CGI_RESPONSE}, m = "httpPost", n = {"this", "url", "params", "reqHeaders", "isUnpackResp", "this", "url", "params", "reqHeaders", "cookie", "isUnpackResp", "this", "url", "params", "reqHeaders", "cookie", "userAgent", "isUnpackResp"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0"})
/* loaded from: classes33.dex */
public final class VasBasePage$httpPost$1 extends ContinuationImpl {
    public VasBasePage L$0;
    public String L$1;
    public e L$2;
    public e L$3;
    public String L$4;
    public String L$5;
    public boolean Z$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ VasBasePage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasBasePage$httpPost$1(VasBasePage vasBasePage, Continuation<? super VasBasePage$httpPost$1> continuation) {
        super(continuation);
        this.this$0 = vasBasePage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.httpPost(null, null, null, false, null, this);
    }
}
