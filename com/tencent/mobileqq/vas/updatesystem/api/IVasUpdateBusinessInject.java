package com.tencent.mobileqq.vas.updatesystem.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0018\u00010\u0003H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/vas/updatesystem/api/IVasUpdateBusinessInject;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getInjectList", "", "Lcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness;", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasUpdateBusinessInject extends QRouteApi {
    @Nullable
    List<QQVasUpdateBusiness<?>> getInjectList();
}
