package com.tencent.mobileqq.guild.feed.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/IGuildFeedRefreshApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "doFeedTroopRefresh", "", "forceRefresh", "", "forceSortByHot", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes13.dex */
public interface IGuildFeedRefreshApi extends QRouteApi {
    void doFeedTroopRefresh(boolean forceRefresh, boolean forceSortByHot);
}
