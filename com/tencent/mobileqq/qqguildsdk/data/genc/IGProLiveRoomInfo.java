package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.IGProRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.ILiveRoomAnchorInfo;
import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProLiveRoomInfo extends Serializable {
    ILiveRoomAnchorInfo getAnchorInfo();

    String getChannelId();

    String getChannelName();

    String getCloseTips();

    int getCloseType();

    boolean getIsActive();

    int getLiveType();

    int getPlatform();

    IGProProgramInfo getProgramInfo();

    long getQueryId();

    IGProRoomInfo getRoomInfo();

    IGProLiveStreamInfo getStreamInfo();

    String toString();
}
