package com.tencent.mobileqq.ecshop.report.api.impl;

import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.ecshop.report.api.IEcshopReportApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqshop.report.a;
import com.tencent.mobileqq.qqshop.report.beacon.b;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062&\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\bj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\tH\u0016J \u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/ecshop/report/api/impl/EcshopReportApiImpl;", "Lcom/tencent/mobileqq/ecshop/report/api/IEcshopReportApi;", "()V", "doReportBeacon", "", "opName", "", "inputParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "reportSetTopOrCancleSetTop", "uinType", "", "uin", "isSetTop", "", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class EcshopReportApiImpl implements IEcshopReportApi {
    static IPatchRedirector $redirector_;

    public EcshopReportApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.ecshop.report.api.IEcshopReportApi
    public void doReportBeacon(@NotNull String opName, @NotNull HashMap<String, String> inputParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) opName, (Object) inputParams);
            return;
        }
        Intrinsics.checkNotNullParameter(opName, "opName");
        Intrinsics.checkNotNullParameter(inputParams, "inputParams");
        b.f274709a.b(opName, inputParams);
    }

    @Override // com.tencent.mobileqq.ecshop.report.api.IEcshopReportApi
    public void reportSetTopOrCancleSetTop(int uinType, @NotNull String uin, boolean isSetTop) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(uinType), uin, Boolean.valueOf(isSetTop));
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (uinType == 1008 && Intrinsics.areEqual(IPublicAccountUtil.UIN_FOR_SHOP, uin)) {
            a aVar = a.f274706a;
            if (isSetTop) {
                str = "1";
            } else {
                str = "0";
            }
            aVar.d(str);
        }
    }
}
