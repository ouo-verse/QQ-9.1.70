package com.tencent.mobileqq.mini.server.request;

import com.tencent.mobileqq.mini.server.BaseMiniAppSSORequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.trpcprotocol.minigame.basicaudit.ReportLaunchEventReq;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/mini/server/request/ReportLaunchEventRequest;", "Lcom/tencent/mobileqq/mini/server/BaseMiniAppSSORequest;", "reportData", "", "(Ljava/lang/String;)V", "getCmd", "getRequestData", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class ReportLaunchEventRequest implements BaseMiniAppSSORequest {
    private final String reportData;

    public ReportLaunchEventRequest(String reportData) {
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        this.reportData = reportData;
    }

    @Override // com.tencent.mobileqq.mini.server.BaseMiniAppSSORequest
    public String getCmd() {
        return "miniapp.trpc.minigame.operationadminbasicsaudit.VersionAuditClientReport.ReportLaunchEvent";
    }

    @Override // com.tencent.mobileqq.mini.server.BaseMiniAppSSORequest
    public byte[] getRequestData() {
        ReportLaunchEventReq reportLaunchEventReq = new ReportLaunchEventReq();
        PBBytesField pBBytesField = reportLaunchEventReq.report_data;
        byte[] bytes = this.reportData.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        pBBytesField.set(ByteStringMicro.copyFrom(bytes));
        byte[] byteArray = reportLaunchEventReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        return byteArray;
    }
}
