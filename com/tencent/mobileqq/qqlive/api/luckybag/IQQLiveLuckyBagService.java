package com.tencent.mobileqq.qqlive.api.luckybag;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.luckybag.ReceiveLuckyBagMessageListener;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IQQLiveLuckyBagService extends IQQLiveModule {
    void addReceiveGiftMessageListener(ReceiveLuckyBagMessageListener receiveLuckyBagMessageListener);

    void delReceiveGiftMessageListener(ReceiveLuckyBagMessageListener receiveLuckyBagMessageListener);
}
