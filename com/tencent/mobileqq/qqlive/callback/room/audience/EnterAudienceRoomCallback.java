package com.tencent.mobileqq.qqlive.callback.room.audience;

import com.tencent.mobileqq.qqlive.data.room.LiveInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface EnterAudienceRoomCallback {
    void onFailed(int i3, String str);

    void onSuccess(LiveInfo liveInfo);
}
