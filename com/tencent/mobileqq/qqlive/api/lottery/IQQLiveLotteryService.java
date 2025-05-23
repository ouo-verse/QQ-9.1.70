package com.tencent.mobileqq.qqlive.api.lottery;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.lottery.IQQLiveHideLotteryCallback;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IQQLiveLotteryService extends IQQLiveModule {
    void notifyHideLotteryResult(String str, String str2, String str3);

    void registerHideLottery(IQQLiveHideLotteryCallback iQQLiveHideLotteryCallback);

    void unRegisterHideLottery(IQQLiveHideLotteryCallback iQQLiveHideLotteryCallback);
}
