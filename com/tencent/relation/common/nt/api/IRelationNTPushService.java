package com.tencent.relation.common.nt.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/relation/common/nt/api/IRelationNTPushService;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getRelationNTPushSwitch", "", "registerRelationNTPush", "", "unRegisterRelationNTPush", "relation-common-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IRelationNTPushService extends QRouteApi {
    boolean getRelationNTPushSwitch();

    void registerRelationNTPush();

    void unRegisterRelationNTPush();
}
