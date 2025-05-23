package com.tencent.state;

import com.tencent.state.square.api.ISquareBaseMessageService;
import com.tencent.state.square.api.ISquarePushService;
import com.tencent.state.square.invite.ISelectFriendCallback;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\n\u0010\t\u001a\u0004\u0018\u00010\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/state/IVasBaseServiceProvider;", "", "addSelectFriendCallback", "", "observer", "Lcom/tencent/state/square/invite/ISelectFriendCallback;", "deleteSelectFriendCallback", "getMessageService", "Lcom/tencent/state/square/api/ISquareBaseMessageService;", "getPushService", "Lcom/tencent/state/square/api/ISquarePushService;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface IVasBaseServiceProvider {
    void addSelectFriendCallback(ISelectFriendCallback observer);

    void deleteSelectFriendCallback(ISelectFriendCallback observer);

    ISquareBaseMessageService getMessageService();

    ISquarePushService getPushService();
}
