package com.tencent.mobileqq.guild;

import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public interface t {
    void closeGiftPanel();

    void getCoins();

    r getGiftPanelAction();

    com.tencent.mobileqq.qqgift.data.service.c getGiftSendReq(long j3, int i3);

    void sendGift(long j3, int i3, int i16);

    void toRechargePanel(String str);

    void toastSendError();

    void updateCoins(long j3, String str);

    void updateGiftPanel(List list);
}
