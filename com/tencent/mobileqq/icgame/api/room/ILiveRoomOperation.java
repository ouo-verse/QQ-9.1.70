package com.tencent.mobileqq.icgame.api.room;

import com.tencent.mobileqq.icgame.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback;
import java.util.ArrayList;
import t22.a;
import t22.b;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface ILiveRoomOperation {
    void getRoomAnnounce(long j3, a aVar);

    void sendFloatHeart(boolean z16, String str);

    void sendFloatHeartEnd();

    void sendMessage(String str, ArrayList<LiveMessageData.ExtData> arrayList, IQQLiveMessageCallback iQQLiveMessageCallback);

    void setRoomAnnounce(long j3, long j16, String str, b bVar);
}
