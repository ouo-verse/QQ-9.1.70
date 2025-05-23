package com.tencent.mobileqq.qqlive.callback.gift;

import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;

/* loaded from: classes17.dex */
public interface OnPresentGiftCallback {
    void onFail(int i3, String str);

    void onPresentGift(GiftMessage giftMessage);

    void onPresentGiftFail(GiftMessage giftMessage);
}
