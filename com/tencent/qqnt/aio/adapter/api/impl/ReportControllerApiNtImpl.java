package com.tencent.qqnt.aio.adapter.api.impl;

import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IReportControllerApi;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002Jr\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/ReportControllerApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IReportControllerApi;", "()V", "reportWith898", "", "app", "Lmqq/app/AppRuntime;", "mainAction", "", "toUin", "subAction", "actionName", IProfileCardConst.KEY_FROM_TYPE, "", "result", "r2", "r3", "r4", "r5", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class ReportControllerApiNtImpl implements IReportControllerApi {
    static IPatchRedirector $redirector_;

    public ReportControllerApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IReportControllerApi
    public void reportWith898(@Nullable AppRuntime app, @Nullable String mainAction, @Nullable String toUin, @Nullable String subAction, @Nullable String actionName, int fromType, int result, @Nullable String r26, @Nullable String r36, @Nullable String r46, @Nullable String r56) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, app, mainAction, toUin, subAction, actionName, Integer.valueOf(fromType), Integer.valueOf(result), r26, r36, r46, r56);
        }
    }
}
