package com.tencent.qqnt.search.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.SearchChatSummaryItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchMsgItem;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\bg\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&J\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/search/api/ISearchConvertAPI;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchChatSummaryItem;", "searchMsg", "", "getSearchMsgCount", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMsgItem;", "msgItem", "", "", "splitKeyword", "", "getMsgHighLight", "qqsearch-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface ISearchConvertAPI extends QRouteApi {
    /* synthetic */ int getChatType(@NotNull Object obj);

    @Nullable
    /* synthetic */ CharSequence getDescription(@NotNull Object obj, @NotNull String str, @Nullable String str2, @NotNull List<String> list);

    @Nullable
    /* synthetic */ String getKeyword(@NotNull Object obj);

    @NotNull
    CharSequence getMsgHighLight(@NotNull SearchMsgItem msgItem, @NotNull List<String> splitKeyword);

    @Nullable
    /* synthetic */ String getPeerUid(@NotNull Object obj);

    int getSearchMsgCount(@NotNull SearchChatSummaryItem searchMsg);

    @Nullable
    /* synthetic */ CharSequence getSubTitle(@NotNull Object obj);

    @Nullable
    /* synthetic */ CharSequence getTitle(@NotNull Object obj);

    /* synthetic */ boolean interestedIn(@NotNull Object obj);
}
