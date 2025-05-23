package com.tencent.mobileqq.qqlive.callback.gift;

import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface ReceiveGiftMessageListener {
    void onError(int i3, String str);

    void onGiftMessageReceive(GiftMessage giftMessage);
}
