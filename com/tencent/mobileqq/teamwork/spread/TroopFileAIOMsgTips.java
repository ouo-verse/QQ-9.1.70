package com.tencent.mobileqq.teamwork.spread;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.tendoc.TencentDocTipsConfigProcessor;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.teamwork.spread.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TroopFileAIOMsgTips extends a {
    public TroopFileAIOMsgTips(QQAppInterface qQAppInterface, ChatMessage chatMessage, ConfigSetting configSetting) {
        super(qQAppInterface, chatMessage, configSetting);
    }

    @Override // com.tencent.mobileqq.teamwork.spread.a
    protected String a() {
        return ((MessageForTroopFile) this.f292379d).fileName;
    }

    @Override // com.tencent.mobileqq.teamwork.spread.a
    protected void b(final a.InterfaceC8642a interfaceC8642a) {
        if (QLog.isColorLevel()) {
            QLog.i("TroopFileAIOMsgTips", 1, "getWordsList by TroopFile[" + System.currentTimeMillis() + "]");
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.teamwork.spread.TroopFileAIOMsgTips.1
            @Override // java.lang.Runnable
            public void run() {
                long j3;
                if (QLog.isColorLevel()) {
                    QLog.i("TroopFileAIOMsgTips", 1, "sub Thread getWordsList by TroopFile[" + System.currentTimeMillis() + "]");
                }
                long K0 = com.tencent.mobileqq.service.message.e.K0();
                ArrayList arrayList = new ArrayList();
                List<MessageRecord> O = TroopFileAIOMsgTips.this.f292376a.getMessageFacade().O(TroopFileAIOMsgTips.this.f292377b, 1, Long.MAX_VALUE, 3, Long.MAX_VALUE, new int[]{MessageRecord.MSG_TYPE_TROOP_OBJ_MSG}, TencentDocTipsConfigProcessor.a().d());
                if (O != null && O.size() != 0) {
                    if (QLog.isColorLevel()) {
                        QLog.i("TroopFileAIOMsgTips", 1, "current AIO msg count[" + O.size() + "]");
                    }
                    long a16 = TencentDocTipsConfigProcessor.a().a() * 3600;
                    int i3 = 0;
                    while (i3 < O.size()) {
                        MessageRecord messageRecord = O.get(i3);
                        if (!(messageRecord instanceof MessageForTroopFile)) {
                            j3 = K0;
                        } else {
                            TroopFileAIOMsgTips troopFileAIOMsgTips = TroopFileAIOMsgTips.this;
                            j3 = K0;
                            if (troopFileAIOMsgTips.f292379d.uniseq != messageRecord.uniseq && new TroopFileAIOMsgTips(troopFileAIOMsgTips.f292376a, (ChatMessage) messageRecord, troopFileAIOMsgTips.f292380e).c()) {
                                MessageForTroopFile messageForTroopFile = (MessageForTroopFile) messageRecord;
                                if (j3 - messageForTroopFile.time <= a16) {
                                    arrayList.add(messageForTroopFile.fileName);
                                }
                            }
                        }
                        i3++;
                        K0 = j3;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("TroopFileAIOMsgTips", 1, "find file msg count[" + arrayList.size() + "]");
                    }
                    interfaceC8642a.a(arrayList);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("TroopFileAIOMsgTips", 1, "current AIO has not File,peerType[" + TroopFileAIOMsgTips.this.f292378c + "]");
                }
                interfaceC8642a.a(arrayList);
            }
        }, 8, null, true);
    }
}
