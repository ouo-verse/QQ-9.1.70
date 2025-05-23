package com.tencent.mobileqq.qqlive.callback.follow;

import com.tencent.mobileqq.qqlive.data.follow.FollowPushMessage;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IQQLiveReceiveFollowListener {
    void onFail(int i3, String str);

    void onFollowReceive(FollowPushMessage followPushMessage);
}
