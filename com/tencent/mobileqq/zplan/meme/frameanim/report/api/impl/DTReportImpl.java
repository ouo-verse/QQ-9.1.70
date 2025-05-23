package com.tencent.mobileqq.zplan.meme.frameanim.report.api.impl;

import com.tencent.mobileqq.zplan.meme.frameanim.report.api.IDTReport;
import com.tencent.mobileqq.zplan.meme.frameanim.report.datong.DaTongReport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0006H\u0016J(\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/frameanim/report/api/impl/DTReportImpl;", "Lcom/tencent/mobileqq/zplan/meme/frameanim/report/api/IDTReport;", "()V", "reportErrorBubble", "", "uin", "", "businessId", "", "sessionId", "", "code", "msg", "reportStaticImage", "updateToDate", "", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class DTReportImpl implements IDTReport {
    @Override // com.tencent.mobileqq.zplan.meme.frameanim.report.api.IDTReport
    public void reportErrorBubble(String uin, int businessId, long sessionId, int code, String msg2) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        DaTongReport.f334065a.h(uin, businessId, sessionId, code, msg2);
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.report.api.IDTReport
    public void reportStaticImage(String uin, int businessId, long sessionId, boolean updateToDate) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        DaTongReport.f334065a.k(uin, businessId, sessionId, updateToDate);
    }
}
