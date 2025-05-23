package com.tencent.imcore.message.ext.codec.decoder.pbelement;

import com.tencent.biz.bmqq.protocol.Crm$CrmCCNotify;
import com.tencent.biz.bmqq.protocol.Crm$GrayMsg;
import com.tencent.biz.bmqq.protocol.Crm$QidianGroupMsg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body$CrmElem;
import tencent.im.msg.im_msg_body$Elem;

/* compiled from: P */
/* loaded from: classes7.dex */
public class f extends af {
    static IPatchRedirector $redirector_;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.pbelement.af, com.tencent.imcore.message.core.codec.a
    public boolean a(List<im_msg_body$Elem> list, msg_comm$Msg msg_comm_msg, List<MessageRecord> list2, StringBuilder sb5, boolean z16, boolean z17, com.tencent.mobileqq.troop.data.c cVar, com.tencent.mobileqq.service.message.ab abVar, com.tencent.mobileqq.service.message.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, list, msg_comm_msg, list2, sb5, Boolean.valueOf(z16), Boolean.valueOf(z17), cVar, abVar, aVar)).booleanValue();
        }
        for (im_msg_body$Elem im_msg_body_elem : list) {
            if (b(im_msg_body_elem)) {
                f(im_msg_body_elem, list2, sb5, msg_comm_msg, abVar);
            }
        }
        return false;
    }

    @Override // com.tencent.imcore.message.core.codec.a
    public boolean b(im_msg_body$Elem im_msg_body_elem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) im_msg_body_elem)).booleanValue();
        }
        return im_msg_body_elem.crm_elem.has();
    }

    void d(QQAppInterface qQAppInterface, im_msg_body$CrmElem im_msg_body_crmelem, List<MessageRecord> list, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.service.message.ab abVar) {
        MessageRecord messageRecord;
        MessageRecord messageRecord2;
        Crm$CrmCCNotify crm$CrmCCNotify = new Crm$CrmCCNotify();
        MessageHandler msgHandler = qQAppInterface.getMsgHandler();
        try {
            crm$CrmCCNotify.mergeFrom(im_msg_body_crmelem.crm_buf.get().toByteArray());
            int i3 = crm$CrmCCNotify.crm_flag.get();
            if (i3 == 8 && crm$CrmCCNotify.qidian_group_msg.has()) {
                Crm$QidianGroupMsg crm$QidianGroupMsg = crm$CrmCCNotify.qidian_group_msg.get();
                int i16 = crm$QidianGroupMsg.uint32_group_task_id.get();
                int i17 = crm$QidianGroupMsg.uint32_group_msg_type.get();
                long j3 = crm$QidianGroupMsg.uint64_kfuin.get();
                int i18 = crm$QidianGroupMsg.uint32_show_tip.get();
                String str = crm$QidianGroupMsg.str_tip_text.get();
                if (!list.isEmpty() && (messageRecord2 = list.get(0)) != null) {
                    messageRecord2.mQidianTaskId = i16;
                    messageRecord2.mQidianMasterUin = j3;
                    messageRecord2.mIsShowQidianTips = i18;
                    messageRecord2.mQidianTipText = str;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("CrmFlagsElemDecoder", 2, String.format("received qidian bulk message taskId: %d, msgType: %d", Integer.valueOf(i16), Integer.valueOf(i17)));
                }
                com.tencent.mobileqq.service.message.p.I(msg_comm_msg.msg_head.from_uin.get(), msg_comm_msg.msg_head.msg_seq.get(), msg_comm_msg.msg_head.msg_uid.get(), msg_comm_msg.msg_head.msg_type.get(), msgHandler.getApp());
                if (i16 != 0) {
                    QidianHandler qidianHandler = (QidianHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("action", "receive");
                    jSONObject.put("fromUin", String.valueOf(msg_comm_msg.msg_head.from_uin.get()));
                    jSONObject.put("toUin", qQAppInterface.getCurrentAccountUin());
                    jSONObject.put(com.heytap.mcssdk.a.a.f36094d, String.valueOf(i16));
                    jSONObject.put("clickURL", "");
                    jSONObject.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
                    qidianHandler.q3(jSONObject.toString(), String.valueOf(msg_comm_msg.msg_head.from_uin.get()), "", 10009, 0);
                }
            }
            if (i3 == 11 && crm$CrmCCNotify.msg_gray_msg.has()) {
                Crm$GrayMsg crm$GrayMsg = crm$CrmCCNotify.msg_gray_msg.get();
                int i19 = crm$GrayMsg.uint32_type.get();
                String str2 = crm$GrayMsg.str_text.get();
                long j16 = crm$GrayMsg.uint64_from_uin.get();
                int i26 = msg_comm_msg.msg_head.msg_seq.get();
                long j17 = msg_comm_msg.msg_head.msg_uid.get();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(i26);
                sb5.append(j17);
                if (QLog.isColorLevel()) {
                    QLog.d("CrmFlagsElemDecoder", 2, String.format("received qidian gray msg type: %d, tips: %s, fromUin: %d", Integer.valueOf(i19), str2, Long.valueOf(j16)));
                }
                com.tencent.qidian.util.b.b(qQAppInterface, String.valueOf(j16), str2, 1024, sb5.toString());
            }
            if (crm$CrmCCNotify.str_check_id.has()) {
                com.tencent.qidian.util.b.f(qQAppInterface, list, msg_comm_msg, abVar, crm$CrmCCNotify);
            }
            if (abVar != null && abVar.f286173a == 1024 && crm$CrmCCNotify.str_ext_nick_name.has()) {
                String str3 = crm$CrmCCNotify.str_ext_nick_name.get();
                if (list.isEmpty() || (messageRecord = list.get(0)) == null) {
                    return;
                }
                messageRecord.saveExtInfoToExtStr("qidian_ext_nick_name", str3);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("CrmFlagsElemDecoder", 2, "receive ccNotify but throw exception " + e16.getMessage());
            }
        }
    }

    void e(int i3, List<MessageRecord> list, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.service.message.ab abVar, MessageHandler messageHandler) {
        if (!list.isEmpty()) {
            list.get(0).saveExtInfoToExtStr("crmelem_qidian_flag", i3 + "");
        }
        String currentAccountUin = messageHandler.Q.getCurrentAccountUin();
        String valueOf = String.valueOf(msg_comm_msg.msg_head.from_uin.get());
        if (!currentAccountUin.equals(valueOf)) {
            QidianManager qidianManager = (QidianManager) messageHandler.Q.getManager(QQManagerFactory.QIDIAN_MANAGER);
            if (!qidianManager.f342666d.containsKey(valueOf)) {
                qidianManager.j0(new BmqqAccountType(valueOf, 1));
            }
        }
        if (abVar != null && abVar.f286173a == 1024) {
            abVar.f286173a = 1025;
        }
    }

    public void f(im_msg_body$Elem im_msg_body_elem, List<MessageRecord> list, StringBuilder sb5, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.service.message.ab abVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, im_msg_body_elem, list, sb5, msg_comm_msg, abVar);
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        MessageHandler msgHandler = qQAppInterface.getMsgHandler();
        im_msg_body$CrmElem im_msg_body_crmelem = im_msg_body_elem.crm_elem.get();
        if (im_msg_body_crmelem != null) {
            int i3 = im_msg_body_crmelem.uint32_qidian_flag.get();
            if (QLog.isColorLevel()) {
                sb5.append("has uint32_qidian_flag:");
                sb5.append(i3);
                sb5.append(";");
            }
            if (i3 == 1) {
                e(i3, list, msg_comm_msg, abVar, msgHandler);
            }
            if (im_msg_body_crmelem.crm_buf.has()) {
                d(qQAppInterface, im_msg_body_crmelem, list, msg_comm_msg, abVar);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            sb5.append("has crmElem, but crmElem is null");
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.pbelement.af, com.tencent.imcore.message.core.codec.a
    public int getPriority() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return -1000;
    }
}
