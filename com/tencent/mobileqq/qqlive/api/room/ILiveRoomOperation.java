package com.tencent.mobileqq.qqlive.api.room;

import com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface ILiveRoomOperation {
    void sendMessage(String str, ArrayList<LiveMessageData.ExtData> arrayList, IQQLiveMessageCallback iQQLiveMessageCallback, int i3);
}
