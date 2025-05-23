package com.tencent.mobileqq.qqlive.api.message;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;

/* loaded from: classes17.dex */
public interface IQQLivePushCmdService extends IQQLiveModule {
    void registerHighPriorityListener(int i3, IQQCmdPushCallback iQQCmdPushCallback);

    void registerLivePushChannel(int i3, IQQCmdPushCallback iQQCmdPushCallback);

    void registerLowPriorityListener(int i3, IQQCmdPushCallback iQQCmdPushCallback);

    void unRegisterHighPriorityListener(int i3, IQQCmdPushCallback iQQCmdPushCallback);

    void unRegisterLivePushChannel(IQQCmdPushCallback iQQCmdPushCallback);

    void unRegisterLowPriorityListener(int i3, IQQCmdPushCallback iQQCmdPushCallback);
}
