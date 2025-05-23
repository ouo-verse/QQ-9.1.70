package com.tencent.biz.pubaccount.weishi.request.newreq;

import UserGrowth.stDeepLinkReportReq;
import UserGrowth.stDeepLinkReportRsp;
import com.tencent.biz.pubaccount.weishi.net.common.g;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/request/newreq/WSDeepLinkRequest;", "Lcom/tencent/biz/pubaccount/weishi/net/common/g;", "LUserGrowth/stDeepLinkReportRsp;", "Ljava/lang/Class;", "getRspClass", "", QZoneDTLoginReporter.SCHEMA, "<init>", "(Ljava/lang/String;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSDeepLinkRequest extends g<stDeepLinkReportRsp> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WSDeepLinkRequest(String schema) {
        super(stDeepLinkReportReq.WNS_COMMAND);
        Intrinsics.checkNotNullParameter(schema, "schema");
        this.req = new stDeepLinkReportReq(schema);
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public Class<stDeepLinkReportRsp> getRspClass() {
        return stDeepLinkReportRsp.class;
    }
}
