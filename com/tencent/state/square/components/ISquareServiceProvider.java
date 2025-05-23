package com.tencent.state.square.components;

import com.tencent.state.IVasBaseServiceProvider;
import com.tencent.state.square.api.ISquareFriendService;
import com.tencent.state.square.api.ISquareMonitorService;
import com.tencent.state.square.api.ISquareMusicService;
import com.tencent.state.square.api.ISquarePttMessageService;
import com.tencent.state.square.invite.ISquareInviteManager;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\tH&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/state/square/components/ISquareServiceProvider;", "Lcom/tencent/state/IVasBaseServiceProvider;", "getFriendService", "Lcom/tencent/state/square/api/ISquareFriendService;", "getInviteManager", "Lcom/tencent/state/square/invite/ISquareInviteManager;", "getMonitorService", "Lcom/tencent/state/square/api/ISquareMonitorService;", "getMusicService", "Lcom/tencent/state/square/api/ISquareMusicService;", "getPttMessageService", "Lcom/tencent/state/square/api/ISquarePttMessageService;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface ISquareServiceProvider extends IVasBaseServiceProvider {
    ISquareFriendService getFriendService();

    ISquareInviteManager getInviteManager();

    ISquareMonitorService getMonitorService();

    ISquareMusicService getMusicService();

    ISquarePttMessageService getPttMessageService();
}
