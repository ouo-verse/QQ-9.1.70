package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProRecommendLiveChannel extends Serializable {
    IGProRecommendCoverInfo getCover();

    IGProLiveRoomInfo getLiveChannel();

    ArrayList<IGProRecommendMsg> getMsgList();

    String toString();
}
