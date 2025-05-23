package com.tencent.mobileqq.selectfriend.api;

import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0006H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/api/ISelectNtSaveRecentUserApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "onSaveRecentUser", "Lcom/tencent/mobileqq/data/RecentUser;", "recentUser", "forceUpdateParcelData", "", "shouldAddToList", "needFilter", "qq_selectfriend_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISelectNtSaveRecentUserApi extends QRouteApi {
    @Nullable
    RecentUser onSaveRecentUser(@NotNull RecentUser recentUser, boolean forceUpdateParcelData);

    boolean shouldAddToList(@NotNull RecentUser recentUser, boolean needFilter);
}
