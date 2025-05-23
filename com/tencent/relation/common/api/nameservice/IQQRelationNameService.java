package com.tencent.relation.common.api.nameservice;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.api.y;
import com.tencent.relation.common.bean.nameservice.a;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/relation/common/api/nameservice/IQQRelationNameService;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/relation/common/bean/nameservice/a;", "configBlock", "", "nameWithConfig", "Lcom/tencent/qqnt/kernel/api/y;", "getProfileService", "relation-common-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQQRelationNameService extends QRouteApi {
    @Nullable
    y getProfileService();

    @Nullable
    String nameWithConfig(@NotNull a configBlock);
}
