package com.tencent.qqnt.avatar;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/avatar/IAvatarOutboundApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "uin", "uid", "Lcom/tencent/qqnt/avatar/c;", "getOutboundInfo", "avatar_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAvatarOutboundApi extends QRouteApi {
    @Nullable
    c getOutboundInfo(@NotNull String uin, @NotNull String uid);
}
