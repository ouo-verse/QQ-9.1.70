package com.tencent.qqnt.aio.adapter.api.impl;

import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqnt.aio.adapter.api.IReportControllerApi;
import kotlin.Metadata;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002Jr\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/ReportControllerApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IReportControllerApi;", "()V", "reportWith898", "", "app", "Lmqq/app/AppRuntime;", "mainAction", "", "toUin", "subAction", "actionName", IProfileCardConst.KEY_FROM_TYPE, "", "result", "r2", "r3", "r4", "r5", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ReportControllerApiImpl implements IReportControllerApi {
    @Override // com.tencent.qqnt.aio.adapter.api.IReportControllerApi
    public void reportWith898(AppRuntime app, String mainAction, String toUin, String subAction, String actionName, int fromType, int result, String r26, String r36, String r46, String r56) {
        ReportController.o(app, "dc00898", mainAction, toUin, subAction, actionName, fromType, result, r26, r36, r46, r56);
    }
}
