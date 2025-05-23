package com.tencent.mobileqq.troop.troopmember;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmember/ITroopMemberSpecialCareApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "isSpecialCare", "", "memberUin", "", "(Ljava/lang/String;)Ljava/lang/Boolean;", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes19.dex */
public interface ITroopMemberSpecialCareApi extends QRouteApi {
    @Nullable
    Boolean isSpecialCare(@NotNull String memberUin);
}
