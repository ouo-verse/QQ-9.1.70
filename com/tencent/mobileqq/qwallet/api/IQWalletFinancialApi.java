package com.tencent.mobileqq.qwallet.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qwallet/api/IQWalletFinancialApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getFinancialDynamicRedPointPathInterface", "Lcom/tencent/mobileqq/tianshu/data/BusinessInfoCheckUpdateItem$DynamicRedPointPathInterface;", "qwallet-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQWalletFinancialApi extends QRouteApi {
    @NotNull
    BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface getFinancialDynamicRedPointPathInterface();
}
