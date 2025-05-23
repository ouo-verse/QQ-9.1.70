package com.tencent.mobileqq.icgame.room.gift;

import com.tencent.mobileqq.icgame.data.gift.GiftMessage;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    public static com.tencent.mobileqq.qqgift.mvvm.business.anim.a a(GiftMessage giftMessage) {
        if (giftMessage == null) {
            QLog.e("ICGameGiftAnimDataUtil", 1, "covert but giftMessage is null");
            return null;
        }
        com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar = new com.tencent.mobileqq.qqgift.mvvm.business.anim.a();
        aVar.f264910a = giftMessage.giftID;
        aVar.f264911b = giftMessage.giftType;
        aVar.f264913d = giftMessage.giftName;
        aVar.f264914e = giftMessage.materialID;
        if (giftMessage.giftNum == 0) {
            giftMessage.giftNum = 1;
        }
        aVar.f264915f = giftMessage.giftNum;
        aVar.f264918i = giftMessage.sender;
        aVar.f264919j = giftMessage.senderNick;
        aVar.f264922m = giftMessage.senderHead;
        aVar.f264921l = giftMessage.receiverNick;
        aVar.f264923n = giftMessage.receiverHead;
        aVar.f264924o = giftMessage.effectLevel;
        aVar.f264925p = giftMessage.comboSeq;
        aVar.f264926q = giftMessage.allComboCnt;
        aVar.f264912c = giftMessage.giftPrice;
        aVar.f264917h = giftMessage.batchSendCnt;
        return aVar;
    }
}
