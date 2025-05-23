package com.tencent.mobileqq.service.message.codec.decoder;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;
import msf.msgcomm.msg_comm$MsgHead;

/* compiled from: P */
/* loaded from: classes18.dex */
public class l implements d<MessageHandler> {
    static IPatchRedirector $redirector_;

    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private long c(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, boolean z16, boolean z17, boolean z18) {
        if (QLog.isColorLevel()) {
            QLog.d("TroopSystemMessageDecoder", 2, "<---decodeC2CMsgPkg_GroupSys");
        }
        long j3 = 0;
        if (msg_comm_msg.msg_body.has() && msg_comm_msg.msg_body.get().msg_content.has()) {
            Long.valueOf(messageHandler.Q.getCurrentAccountUin()).longValue();
            msg_comm_msg.msg_head.get().from_uin.get();
            msg_comm_msg.msg_head.get().msg_type.get();
            byte[] byteArray = msg_comm_msg.msg_body.get().msg_content.get().toByteArray();
            if (byteArray != null && byteArray.length > 0) {
                j3 = PkgTools.getLongData(byteArray, 0);
            }
            msg_comm$MsgHead msg_comm_msghead = msg_comm_msg.msg_head.get();
            if (msg_comm_msghead != null) {
                String str = msg_comm_msghead.group_name.get();
                if (QLog.isColorLevel()) {
                    QLog.d("TroopSystemMessageDecoder.sysnick", 2, "TroopCode:" + j3 + "TroopName:" + str);
                }
                if (((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getTroopInfoFromCache(String.valueOf(j3)) == null) {
                    TroopInfo troopInfo = new TroopInfo(j3);
                    troopInfo.troopname = str;
                    troopInfo.troopNameFromNT = str;
                    ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).saveTroopInCache(troopInfo);
                }
            }
            return j3;
        }
        if (QLog.isColorLevel()) {
            QLog.e("TroopSystemMessageDecoder", 2, "<---decodeC2CMsgPkg_GroupSys return null:hasBody:" + msg_comm_msg.msg_body.has() + ",hasMsgContent" + msg_comm_msg.msg_body.get().msg_content.has() + ",isReaded:" + z16 + "syncOther:" + z17);
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.service.message.codec.decoder.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, List<MessageRecord> list, com.tencent.mobileqq.service.message.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, messageHandler, msg_comm_msg, list, aVar);
            return;
        }
        msg_comm$MsgHead msg_comm_msghead = msg_comm_msg.msg_head.get();
        msg_comm_msghead.from_uin.get();
        msg_comm_msghead.msg_time.get();
        int i3 = msg_comm_msghead.msg_type.get();
        if (i3 != 85 && i3 != 36) {
            z16 = false;
        }
        if (QLog.isDebugVersion()) {
            QLog.d("TroopSystemMessageDecoder", 4, "[decode] isProxyMsg:" + aVar.f286156k + ", needAddTipsToAIO:" + z16);
        }
        aVar.f286338a = AppConstants.SYSTEM_MSG_UIN_LONGVALUE;
        c(messageHandler, msg_comm_msg, aVar.f286154i, aVar.f286159n, aVar.f286157l);
    }
}
