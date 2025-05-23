package com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page;

import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ASDBottomBarAttr extends k {
    public OperationPrivilege operationPrivilege;
    public ASDReportModel reportModel;
    public AfterSalesDetailRspModel rspModel;

    public final OperationPrivilege getOperationPrivilege() {
        OperationPrivilege operationPrivilege = this.operationPrivilege;
        if (operationPrivilege != null) {
            return operationPrivilege;
        }
        Intrinsics.throwUninitializedPropertyAccessException("operationPrivilege");
        return null;
    }

    public final AfterSalesDetailRspModel getRspModel() {
        AfterSalesDetailRspModel afterSalesDetailRspModel = this.rspModel;
        if (afterSalesDetailRspModel != null) {
            return afterSalesDetailRspModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rspModel");
        return null;
    }
}
