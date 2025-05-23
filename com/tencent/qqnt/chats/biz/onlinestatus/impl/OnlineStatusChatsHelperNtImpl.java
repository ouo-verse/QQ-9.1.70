package com.tencent.qqnt.chats.biz.onlinestatus.impl;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.qqnt.chats.biz.onlinestatus.IOnlineStatusChatsHelper;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J,\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/chats/biz/onlinestatus/impl/OnlineStatusChatsHelperNtImpl;", "Lcom/tencent/qqnt/chats/biz/onlinestatus/IOnlineStatusChatsHelper;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "canOnlineStatusRevealShow", "", "event", "", "", "map", "", "addDTReportParams", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class OnlineStatusChatsHelperNtImpl implements IOnlineStatusChatsHelper {
    @Override // com.tencent.qqnt.chats.biz.onlinestatus.IOnlineStatusChatsHelper
    public void addDTReportParams(@NotNull String event, @NotNull g item, @NotNull Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(map, "map");
    }

    @Override // com.tencent.qqnt.chats.biz.onlinestatus.IOnlineStatusChatsHelper
    public boolean canOnlineStatusRevealShow(@NotNull g item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return false;
    }
}
