package com.tencent.qqnt.search;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.SearchChatSummaryItem;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/search/ISearchConvertAPI;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchChatSummaryItem;", "searchMsg", "", "getSearchMsgCount", "search_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface ISearchConvertAPI extends QRouteApi {
    /* synthetic */ int getChatType(@NotNull Object obj);

    @Nullable
    /* synthetic */ CharSequence getDescription(@NotNull Object obj);

    @Nullable
    /* synthetic */ String getKeyword(@NotNull Object obj);

    @Nullable
    /* synthetic */ String getPeerUid(@NotNull Object obj);

    @Nullable
    /* synthetic */ Long getPeerUin(@NotNull Object obj);

    int getSearchMsgCount(@NotNull SearchChatSummaryItem searchMsg);

    @Nullable
    /* synthetic */ CharSequence getSubTitle(@NotNull Object obj);

    @Nullable
    /* synthetic */ CharSequence getTitle(@NotNull Object obj);

    /* synthetic */ boolean interestedIn(@NotNull Object obj);
}
