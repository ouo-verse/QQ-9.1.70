package com.tencent.qqnt.chats.core.ui;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J \u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/chats/core/ui/IChatsListVBInterface;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "chatListHighLightItem", "", "chatType", "", "peerUid", "", "guildId", "chatListIsInVisibleIndex", "", "chats_view_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IChatsListVBInterface extends QRouteApi {
    void chatListHighLightItem(int chatType, @NotNull String peerUid, @NotNull String guildId);

    boolean chatListIsInVisibleIndex(int chatType, @NotNull String peerUid, @NotNull String guildId);
}
