package com.tencent.mobileqq.qqlive.api.gift;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IQQLiveGiftService extends IQQLiveModule {
    void addReceiveGiftMessageListener(ReceiveGiftMessageListener receiveGiftMessageListener);

    void delReceiveGiftMessageListener(ReceiveGiftMessageListener receiveGiftMessageListener);
}
