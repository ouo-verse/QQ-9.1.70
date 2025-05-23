package com.tencent.mobileqq.qqlive.callback.room;

import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.data.room.RoomAudienceInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface RoomAudienceInfoListener {
    void onAudienceEnterRoom(LiveMessageData.SpeakerInfo speakerInfo);

    void onRecAudienceInfo(RoomAudienceInfo roomAudienceInfo);
}
