package com.tencent.qqnt.chats.api;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH&J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H&J\u0012\u0010\u000f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\b\u0010\u0010\u001a\u00020\nH&J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0011H&J\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H&J\"\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u0004H&J\b\u0010\u001c\u001a\u00020\u001bH&J\b\u0010\u001e\u001a\u00020\u001dH&\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqnt/chats/api/IStrangerChatsApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "tinyId", "", "isTop", "hasTop", "top", "Lcom/tencent/qqnt/chats/api/c;", "callback", "", "doSetTopOrNot", "notifyChatsListTopChanged", "Lcom/tencent/qqnt/chats/api/e;", "listener", "setTopSetUpdateListener", "fetchSetTopList", "Lcom/tencent/qqnt/chats/api/d;", "fetchOneSetTopStatus", "", com.tencent.luggage.wxa.c8.c.G, "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "reportMenuOpenExpose", "ev", "clearSingle", "reportChatItemImplEvent", "Lcom/tencent/qqnt/chats/main/vm/datasource/preprocess/c;", "createContactInfoPreProcessor", "Lcom/tencent/qqnt/chats/main/vm/datasource/preprocess/d;", "createContactListResortProcessor", "chats_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IStrangerChatsApi extends QRouteApi {
    @NotNull
    com.tencent.qqnt.chats.main.vm.datasource.preprocess.c createContactInfoPreProcessor();

    @NotNull
    com.tencent.qqnt.chats.main.vm.datasource.preprocess.d createContactListResortProcessor();

    void doSetTopOrNot(@NotNull String tinyId, boolean top, @Nullable c callback);

    void fetchOneSetTopStatus(@NotNull String tinyId, @NotNull d callback);

    void fetchSetTopList();

    boolean hasTop();

    boolean isTop(@NotNull String tinyId);

    void notifyChatsListTopChanged(@NotNull String tinyId, boolean top);

    void reportChatItemImplEvent(@NotNull String ev5, @NotNull g item, boolean clearSingle);

    void reportMenuOpenExpose(int pos, @NotNull g item);

    void setTopSetUpdateListener(@Nullable e listener);
}
