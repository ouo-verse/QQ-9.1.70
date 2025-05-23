package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network;

import c45.e;
import com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J0\u0010\b\u001a\u00020\u0007\"\b\b\u0000\u0010\u0003*\u00020\u0002\"\b\b\u0001\u0010\u0004*\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005H&J \u0010\f\u001a\u00020\u0007\"\b\b\u0000\u0010\t*\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/IQZAegisListener;", "", "Lc45/e;", "BusiReq", "BusiRsp", "Lcom/tencent/hippykotlin/demo/pages/foundation/module/BasePbRequest;", "req", "", "onBeforeRequest", "Rsp", "Lcom/tencent/hippykotlin/demo/pages/foundation/module/PbResponse;", "rsp", "onBeforeResponse", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public interface IQZAegisListener {
    <BusiReq extends e, BusiRsp extends e> void onBeforeRequest(BasePbRequest<BusiReq, BusiRsp> req);

    <Rsp extends e> void onBeforeResponse(PbResponse<Rsp> rsp);
}
