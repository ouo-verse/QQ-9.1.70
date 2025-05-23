package com.tencent.mobileqq.qqlive.api.gift;

import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IQQLivePushCmdHelper extends QRouteApi {
    public static final int GIFT_MESSAGE_CMD_GUILD = 16;
    public static final int GIFT_MESSAGE_CMD_QQLIVE = 16;
    public static final int HIGH_PRIORITY_MESSAGE_CMD_GUILD = 232;
    public static final int HIGH_PRIORITY_MESSAGE_CMD_NOW_QQLIVE = 235;
    public static final int HIGH_PRIORITY_MESSAGE_CMD_QQLIVE = 167;
    public static final int LOW_PRIORITY_MESSAGE_CMD_GUILD = 233;
    public static final int LOW_PRIORITY_MESSAGE_CMD_NOW_QQLIVE = 263;
    public static final int LOW_PRIORITY_MESSAGE_CMD_QQLIVE = 234;

    GiftMessage covertPushDataToGiftMessage(int i3, int i16, byte[] bArr) throws Throwable;

    int getGiftPushSubCmd(String str);

    int[] getHighPriorityPushCmd(String str);

    int[] getLowPriorityPushCmd(String str);
}
