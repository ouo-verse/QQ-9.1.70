package com.tencent.mobileqq.qqlive.callback.room.audience;

import com.tencent.mobileqq.qqlive.data.room.realtime.LiveRealTimeInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface GetRoomInfoCallback {
    void onFailed(int i3, String str);

    void onSuccess(LiveRealTimeInfo liveRealTimeInfo);
}
