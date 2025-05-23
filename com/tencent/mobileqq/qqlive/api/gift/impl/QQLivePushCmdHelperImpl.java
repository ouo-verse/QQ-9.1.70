package com.tencent.mobileqq.qqlive.api.gift.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.gift.IQQLivePushCmdHelper;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.qphone.base.util.QLog;
import gp4.a;
import mt3.e;

/* loaded from: classes17.dex */
public class QQLivePushCmdHelperImpl implements IQQLivePushCmdHelper {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QQLiveGiftHelper";

    public QQLivePushCmdHelperImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.gift.IQQLivePushCmdHelper
    public GiftMessage covertPushDataToGiftMessage(int i3, int i16, byte[] bArr) throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (GiftMessage) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), bArr);
        }
        a c16 = a.c(bArr);
        if (c16.f403047a != i16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "get HIGH_PRIORITY_MESSAGE but not gift");
                return null;
            }
            return null;
        }
        e c17 = e.c(c16.f403049c);
        GiftMessage giftMessage = new GiftMessage();
        giftMessage.giftID = c17.f417551b;
        giftMessage.giftNum = c17.f417553d;
        giftMessage.giftType = c17.f417550a;
        giftMessage.materialID = c17.f417556g;
        giftMessage.sender = c17.f417554e;
        giftMessage.senderNick = c17.f417555f;
        giftMessage.effectLevel = c17.f417557h;
        giftMessage.giftName = c17.f417552c;
        giftMessage.senderHead = c17.f417558i;
        giftMessage.receiverNick = c17.f417559j;
        giftMessage.receiverHead = c17.f417560k;
        giftMessage.comboSeq = c17.f417561l;
        giftMessage.allComboCnt = c17.f417562m;
        giftMessage.comboOver = c17.f417563n;
        giftMessage.liveExtMsg = c17.f417564o;
        giftMessage.receiver = c17.f417565p;
        giftMessage.giftPrice = c17.f417566q;
        giftMessage.batchSendCnt = c17.f417567r;
        return giftMessage;
    }

    @Override // com.tencent.mobileqq.qqlive.api.gift.IQQLivePushCmdHelper
    public int getGiftPushSubCmd(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).intValue();
        }
        com.tencent.mobileqq.qqlive.business.a.f271158a.equals(str);
        return 16;
    }

    @Override // com.tencent.mobileqq.qqlive.api.gift.IQQLivePushCmdHelper
    public int[] getHighPriorityPushCmd(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (int[]) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        if (com.tencent.mobileqq.qqlive.business.a.f271158a.equals(str)) {
            return new int[]{232};
        }
        return new int[]{167, 235};
    }

    @Override // com.tencent.mobileqq.qqlive.api.gift.IQQLivePushCmdHelper
    public int[] getLowPriorityPushCmd(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (int[]) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        if (com.tencent.mobileqq.qqlive.business.a.f271158a.equals(str)) {
            return new int[]{233};
        }
        return new int[]{234, 263};
    }
}
