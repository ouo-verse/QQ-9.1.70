package com.tencent.mobileqq.qqlive.callback.room;

import com.tencent.mobileqq.qqlive.callback.BaseCallback;
import com.tencent.mobileqq.qqlive.data.room.LiveAudienceInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface LiveRoomRankCallback extends BaseCallback {
    void onSuccess(long j3, List<LiveAudienceInfo> list, long j16);
}
