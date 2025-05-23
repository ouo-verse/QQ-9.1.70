package com.tencent.mobileqq.qqlive.api.report.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.report.IQQLiveCallMainServiceApi;
import com.tencent.mobileqq.qqlive.base.ipc.QQLiveClientQIPCModule;
import com.tencent.qqlive.common.report.constant.QQLiveQualityReportData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/report/impl/QQLiveCallMainServiceApiImpl;", "Lcom/tencent/mobileqq/qqlive/api/report/IQQLiveCallMainServiceApi;", "()V", "qualityReport", "", "dcid", "", "builder", "Lcom/tencent/qqlive/common/report/constant/QQLiveQualityReportData$Builder;", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class QQLiveCallMainServiceApiImpl implements IQQLiveCallMainServiceApi {
    static IPatchRedirector $redirector_;

    public QQLiveCallMainServiceApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.report.IQQLiveCallMainServiceApi
    public void qualityReport(int dcid, @NotNull QQLiveQualityReportData.Builder builder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, dcid, (Object) builder);
        } else {
            Intrinsics.checkNotNullParameter(builder, "builder");
            QQLiveClientQIPCModule.INSTANCE.c().qualityReport(dcid, builder);
        }
    }
}
