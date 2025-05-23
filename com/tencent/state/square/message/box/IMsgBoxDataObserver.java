package com.tencent.state.square.message.box;

import com.tencent.state.square.api.SquareBaseMessageRecord;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0003H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0007H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/state/square/message/box/IMsgBoxDataObserver;", "", "onDataInsert", "", "data", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "index", "", "onDataRemove", "onDataSetChange", "onDataUpdate", "onNewMessageCome", "onTotalUnreadNumChange", "unreadNum", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IMsgBoxDataObserver {
    void onDataInsert(SquareBaseMessageRecord data, int index);

    void onDataRemove(SquareBaseMessageRecord data, int index);

    void onDataSetChange();

    void onDataUpdate(SquareBaseMessageRecord data, int index);

    void onNewMessageCome(SquareBaseMessageRecord data);

    void onTotalUnreadNumChange(int unreadNum);
}
