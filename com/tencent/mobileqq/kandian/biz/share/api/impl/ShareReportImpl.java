package com.tencent.mobileqq.kandian.biz.share.api.impl;

import com.tencent.mobileqq.kandian.biz.share.api.IShareReport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import x62.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/share/api/impl/ShareReportImpl;", "Lcom/tencent/mobileqq/kandian/biz/share/api/IShareReport;", "()V", "value", "", "uinType", "getUinType", "()Ljava/lang/String;", "setUinType", "(Ljava/lang/String;)V", "reportResult", "", "success", "", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class ShareReportImpl implements IShareReport {
    @Override // com.tencent.mobileqq.kandian.biz.share.api.IShareReport
    public String getUinType() {
        return a.f447299a.b();
    }

    @Override // com.tencent.mobileqq.kandian.biz.share.api.IShareReport
    public void reportResult(boolean success) {
        a.f447299a.c(success);
    }

    @Override // com.tencent.mobileqq.kandian.biz.share.api.IShareReport
    public void setUinType(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        a.f447299a.d(value);
    }
}
