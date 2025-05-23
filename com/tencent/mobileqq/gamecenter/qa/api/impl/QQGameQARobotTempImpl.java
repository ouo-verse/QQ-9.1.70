package com.tencent.mobileqq.gamecenter.qa.api.impl;

import com.tencent.gamecenter.common.util.l;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.qa.api.IQQGameQARobotTemp;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQGameQARobotTempImpl implements IQQGameQARobotTemp {
    @Override // com.tencent.mobileqq.gamecenter.qa.api.IQQGameQARobotTemp
    public void reportMessageReach(MessageRecord messageRecord) {
        if ((messageRecord instanceof MessageForArkApp) && messageRecord.istroop == 0 && l.g(messageRecord.senderuin)) {
            l.n(messageRecord.senderuin, "61402", "913209", null, l.l(((MessageForArkApp) messageRecord).ark_app_message));
        }
    }
}
