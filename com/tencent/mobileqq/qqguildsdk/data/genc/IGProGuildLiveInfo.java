package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.IGProRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.ILiveRoomAnchorInfo;
import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProGuildLiveInfo extends Serializable {
    ILiveRoomAnchorInfo getAnchorInfo();

    String getErrMsg();

    int getLiveType();

    int getPlatform();

    long getQueryId();

    int getQueryIdType();

    int getResultCode();

    IGProRoomInfo getRoomInfo();

    IGProLiveStreamInfo getStreamInfo();

    String toString();
}
