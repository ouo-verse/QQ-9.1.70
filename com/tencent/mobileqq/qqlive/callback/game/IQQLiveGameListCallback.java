package com.tencent.mobileqq.qqlive.callback.game;

import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomGameInfo;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IQQLiveGameListCallback {
    void onError(int i3, String str);

    void onSuccess(ArrayList<QQLiveAnchorRoomGameInfo> arrayList);
}
