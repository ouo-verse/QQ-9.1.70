package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProAVRoomOptPushInfo extends Serializable {
    String getChannelId();

    String getDelRoomId();

    String getGuildId();

    int getOptType();

    IGProAVRoomAddUpInfo getRoomAddUpInfo();

    IGProAVShowMsgInfo getShowInfo();

    String getSwitchRoomId();
}
