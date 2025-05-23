package com.tencent.mobileqq.icgame.api.message;

import com.tencent.mobileqq.icgame.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;

/* loaded from: classes15.dex */
public interface IQQLivePushCmdService extends IQQLiveModule {
    void registerHighPriorityListener(int i3, IQQCmdPushCallback iQQCmdPushCallback);

    void registerLivePushChannel(int i3, IQQCmdPushCallback iQQCmdPushCallback);

    void registerLowPriorityListener(int i3, IQQCmdPushCallback iQQCmdPushCallback);

    void unRegisterHighPriorityListener(int i3, IQQCmdPushCallback iQQCmdPushCallback);

    void unRegisterLivePushChannel(IQQCmdPushCallback iQQCmdPushCallback);

    void unRegisterLowPriorityListener(int i3, IQQCmdPushCallback iQQCmdPushCallback);
}
