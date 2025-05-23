package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabControlReporter;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.logic.TabDataHandler;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.s2c.msgtype0x210.submsgtype0x146.submsgtype0x146$MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x146.submsgtype0x146$TabData;

/* compiled from: P */
/* loaded from: classes7.dex */
public class s implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void b(byte[] bArr) {
        submsgtype0x146$MsgBody submsgtype0x146_msgbody = new submsgtype0x146$MsgBody();
        try {
            submsgtype0x146_msgbody.mergeFrom(bArr);
            int i3 = submsgtype0x146_msgbody.uint32_push_from.get();
            if (i3 != 1 && i3 != 2 && i3 != 3) {
                QLog.d("SubType0x146", 1, "unknown push from : ", Integer.valueOf(i3));
                return;
            }
            int i16 = submsgtype0x146_msgbody.uint32_push_type.get();
            if (i16 != 1 && i16 != 2) {
                QLog.d("SubType0x146", 1, "unknown push type : ", Integer.valueOf(i16));
                return;
            }
            MobileQQ mobileQQ = MobileQQ.getMobileQQ();
            if (mobileQQ == null) {
                QLog.d("SubType0x146", 1, "mobileQQ is null");
                return;
            }
            AppRuntime waitAppRuntime = mobileQQ.waitAppRuntime(null);
            if (!(waitAppRuntime instanceof AppInterface)) {
                QLog.d("SubType0x146", 1, "appRuntime not appInterface : ", waitAppRuntime);
                return;
            }
            QLog.d("SubType0x146", 1, "start notify update main tab");
            AppInterface appInterface = (AppInterface) waitAppRuntime;
            com.tencent.mobileqq.activity.home.al c16 = c(submsgtype0x146_msgbody);
            String currentUin = waitAppRuntime.getCurrentUin();
            TabControlReporter.h(c16.f182856d, c16.f182853a, c16.f182854b, currentUin);
            TabDataHelper.updateTabSwitchByPush(mobileQQ, currentUin, c16);
            ((TabDataHandler) appInterface.getBusinessHandler(TabDataHandler.class.getName())).notifyUI(0, true, null);
            List<com.tencent.mobileqq.activity.home.aj> a16 = com.tencent.mobileqq.activity.home.t.c().a();
            QLog.d("SubType0x146", 1, "start notify callback, callback size : ", Integer.valueOf(a16.size()));
            Iterator<com.tencent.mobileqq.activity.home.aj> it = a16.iterator();
            while (it.hasNext()) {
                it.next().a(c16);
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.d("SubType0x146", 1, "submsgtype0x146.MsgBody decode error : ", e16);
        }
    }

    private com.tencent.mobileqq.activity.home.al c(submsgtype0x146$MsgBody submsgtype0x146_msgbody) {
        submsgtype0x146$TabData submsgtype0x146_tabdata = submsgtype0x146_msgbody.tab_data.get();
        com.tencent.mobileqq.activity.home.al alVar = new com.tencent.mobileqq.activity.home.al();
        alVar.f182856d = submsgtype0x146_msgbody.uint32_push_from.get();
        alVar.f182857e = submsgtype0x146_msgbody.uint32_push_type.get();
        alVar.f182859g = submsgtype0x146_msgbody.bytes_content.get().toByteArray();
        alVar.f182855c = submsgtype0x146_tabdata.first_show.get();
        int i3 = submsgtype0x146_tabdata.tab_id.get();
        alVar.f182853a = i3;
        alVar.f182854b = submsgtype0x146_tabdata.tab_status.get();
        alVar.f182858f = d(i3);
        return alVar;
    }

    private String d(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return null;
                    }
                    return TabDataHelper.TAB_META_DREAM;
                }
                return TabDataHelper.TAB_RIJ;
            }
            return "GUILD";
        }
        return TabDataHelper.TAB_NEW_WORLD;
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        QLog.d("SubType0x146", 1, "start decode");
        b(bArr);
        return null;
    }
}
