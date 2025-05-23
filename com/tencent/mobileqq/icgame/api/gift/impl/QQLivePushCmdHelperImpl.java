package com.tencent.mobileqq.icgame.api.gift.impl;

import com.tencent.mobileqq.icgame.api.gift.IQQLivePushCmdHelper;
import com.tencent.mobileqq.icgame.data.gift.GiftMessage;
import com.tencent.qphone.base.util.QLog;
import cz0.a;

/* loaded from: classes15.dex */
public class QQLivePushCmdHelperImpl implements IQQLivePushCmdHelper {
    private static final String TAG = "ICGameGiftHelper";

    @Override // com.tencent.mobileqq.icgame.api.gift.IQQLivePushCmdHelper
    public GiftMessage covertPushDataToGiftMessage(int i3, int i16, byte[] bArr) throws Throwable {
        a c16 = a.c(bArr);
        if (c16.f392433a != i16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "get HIGH_PRIORITY_MESSAGE but not gift");
                return null;
            }
            return null;
        }
        sy0.a c17 = sy0.a.c(c16.f392435c);
        GiftMessage giftMessage = new GiftMessage();
        giftMessage.giftID = c17.f434945b;
        giftMessage.giftNum = c17.f434947d;
        giftMessage.giftType = c17.f434944a;
        giftMessage.materialID = c17.f434950g;
        giftMessage.sender = c17.f434948e;
        giftMessage.senderNick = c17.f434949f;
        giftMessage.effectLevel = c17.f434951h;
        giftMessage.giftName = c17.f434946c;
        giftMessage.senderHead = c17.f434952i;
        giftMessage.receiverNick = c17.f434953j;
        giftMessage.receiverHead = c17.f434954k;
        giftMessage.comboSeq = c17.f434955l;
        giftMessage.allComboCnt = c17.f434956m;
        giftMessage.comboOver = c17.f434957n;
        giftMessage.liveExtMsg = c17.f434958o;
        giftMessage.receiver = c17.f434959p;
        giftMessage.giftPrice = c17.f434960q;
        giftMessage.batchSendCnt = c17.f434961r;
        return giftMessage;
    }

    @Override // com.tencent.mobileqq.icgame.api.gift.IQQLivePushCmdHelper
    public int getGiftPushSubCmd(String str) {
        return 16;
    }

    @Override // com.tencent.mobileqq.icgame.api.gift.IQQLivePushCmdHelper
    public int[] getHighPriorityPushCmd(String str) {
        return new int[]{167, 235};
    }

    @Override // com.tencent.mobileqq.icgame.api.gift.IQQLivePushCmdHelper
    public int[] getLowPriorityPushCmd(String str) {
        return new int[]{234, 263};
    }
}
