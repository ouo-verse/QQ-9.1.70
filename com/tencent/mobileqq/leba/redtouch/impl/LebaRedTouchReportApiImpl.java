package com.tencent.mobileqq.leba.redtouch.impl;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.leba.redtouch.ILebaRedTouchReportApi;
import com.tencent.mobileqq.leba.redtouch.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/leba/redtouch/impl/LebaRedTouchReportApiImpl;", "Lcom/tencent/mobileqq/leba/redtouch/ILebaRedTouchReportApi;", "()V", "reportLevelOneRedInfo", "", "appInfo", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", AdMetricTag.Report.TYPE, "", "isInMoreFragment", "", "appid", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class LebaRedTouchReportApiImpl implements ILebaRedTouchReportApi {
    static IPatchRedirector $redirector_;

    public LebaRedTouchReportApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.leba.redtouch.ILebaRedTouchReportApi
    public void reportLevelOneRedInfo(int appid, int reportType, boolean isInMoreFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            a.f240739a.b(appid, reportType, isInMoreFragment);
        } else {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(appid), Integer.valueOf(reportType), Boolean.valueOf(isInMoreFragment));
        }
    }

    @Override // com.tencent.mobileqq.leba.redtouch.ILebaRedTouchReportApi
    public void reportLevelOneRedInfo(@NotNull BusinessInfoCheckUpdate.AppInfo appInfo, int reportType, boolean isInMoreFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appInfo, Integer.valueOf(reportType), Boolean.valueOf(isInMoreFragment));
        } else {
            Intrinsics.checkNotNullParameter(appInfo, "appInfo");
            a.f240739a.c(appInfo, reportType, isInMoreFragment);
        }
    }
}
