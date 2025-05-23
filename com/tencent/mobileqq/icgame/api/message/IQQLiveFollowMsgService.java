package com.tencent.mobileqq.icgame.api.message;

import com.tencent.mobileqq.icgame.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveReceiveFollowListener;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface IQQLiveFollowMsgService extends IQQLiveModule {
    void addFollowMessageListener(IQQLiveReceiveFollowListener iQQLiveReceiveFollowListener);

    void addFollowRoomListener(IQQLiveReceiveFollowListener iQQLiveReceiveFollowListener);

    void checkFollowAnchor(long j3, IQQLiveCheckFollowCallback iQQLiveCheckFollowCallback);

    void delFollowMessageListener(IQQLiveReceiveFollowListener iQQLiveReceiveFollowListener);

    void delFollowRoomListener(IQQLiveReceiveFollowListener iQQLiveReceiveFollowListener);

    void followAnchor(long j3, long j16, IQQLiveFollowCallback iQQLiveFollowCallback);

    void unFollowAnchor(long j3, long j16, IQQLiveFollowCallback iQQLiveFollowCallback);
}
