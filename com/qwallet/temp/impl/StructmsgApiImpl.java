package com.qwallet.temp.impl;

import com.qwallet.temp.IStructmsgApi;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.h;
import com.tencent.mobileqq.structmsg.view.d;
import com.tencent.mobileqq.structmsg.view.v;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class StructmsgApiImpl implements IStructmsgApi {
    @Override // com.qwallet.temp.IStructmsgApi
    public String getBirthdayReminder(MessageRecord messageRecord) {
        AbsStructMsg absStructMsg;
        if (!(messageRecord instanceof MessageForStructing) || (absStructMsg = ((MessageForStructing) messageRecord).structingMsg) == null) {
            return null;
        }
        return absStructMsg.mBirthReminder;
    }

    @Override // com.qwallet.temp.IStructmsgApi
    public void handleStructMsgElement(MessageRecord messageRecord) {
        MessageForStructing messageForStructing = (MessageForStructing) messageRecord;
        List<AbsStructMsgElement> structMsgItemLists = ((StructMsgForGeneralShare) messageForStructing.structingMsg).getStructMsgItemLists();
        if (structMsgItemLists == null || structMsgItemLists.size() <= 0) {
            return;
        }
        Iterator<AbsStructMsgElement> it = structMsgItemLists.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof v) {
                it.remove();
            }
        }
        com.tencent.mobileqq.structmsg.a c16 = h.c(0);
        c16.m(new d());
        c16.P0 = messageForStructing.structingMsg;
        structMsgItemLists.add(c16);
        com.tencent.mobileqq.structmsg.a c17 = h.c(31);
        c17.P0 = messageForStructing.structingMsg;
        structMsgItemLists.add(c17);
        messageForStructing.saveExtInfoToExtStr("wallet_ad_msg", "1");
    }

    @Override // com.qwallet.temp.IStructmsgApi
    public boolean instanceofMessageForStructing(Object obj) {
        return obj instanceof MessageForStructing;
    }

    @Override // com.qwallet.temp.IStructmsgApi
    public void notifyAdExposureCheckersDestroy() {
        Iterator<AdExposureChecker> it = v.f290686b1.iterator();
        while (it.hasNext()) {
            AdExposureChecker next = it.next();
            next.onActivityDestroy();
            next.setCallback(null);
        }
        v.f290686b1.clear();
        v.f290685a1 = null;
    }

    @Override // com.qwallet.temp.IStructmsgApi
    public void notifyAdExposureCheckersPause() {
        Iterator<AdExposureChecker> it = v.f290686b1.iterator();
        while (it.hasNext()) {
            it.next().onActivityPause();
        }
    }

    @Override // com.qwallet.temp.IStructmsgApi
    public void notifyAdExposureCheckersResume() {
        Iterator<AdExposureChecker> it = v.f290686b1.iterator();
        while (it.hasNext()) {
            it.next().onActivityResume();
        }
    }
}
