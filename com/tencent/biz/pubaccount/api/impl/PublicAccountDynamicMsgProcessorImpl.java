package com.tencent.biz.pubaccount.api.impl;

import com.tencent.biz.pubaccount.api.IPublicAccountDynamicMsgProcessor;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;

/* loaded from: classes32.dex */
public class PublicAccountDynamicMsgProcessorImpl implements IPublicAccountDynamicMsgProcessor {
    private com.tencent.biz.pubaccount.i processor;

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDynamicMsgProcessor
    public IPublicAccountDynamicMsgProcessor init(AppInterface appInterface, BusinessHandler businessHandler) {
        if ((appInterface instanceof QQAppInterface) && (businessHandler instanceof MessageHandler)) {
            this.processor = new com.tencent.biz.pubaccount.i((QQAppInterface) appInterface, (MessageHandler) businessHandler);
        }
        return this;
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDynamicMsgProcessor
    public void processHistoryMsg(long j3, List<msg_comm$Msg> list) {
        com.tencent.biz.pubaccount.i iVar = this.processor;
        if (iVar != null) {
            iVar.a1(j3, list);
        }
    }
}
