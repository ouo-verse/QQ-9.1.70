package com.tencent.imcore.message.ext.codec.decoder.pbelement;

import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.api.IPublicAccountMsgExtMrg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;
import tencent.im.msg.im_msg_body$Elem;

/* compiled from: P */
/* loaded from: classes7.dex */
public class LifeOnlineElemDecoder extends af {
    static IPatchRedirector $redirector_;

    public LifeOnlineElemDecoder() {
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
        d(list, list2, sb5, msg_comm_msg, cVar);
        return false;
    }

    @Override // com.tencent.imcore.message.core.codec.a
    public boolean b(im_msg_body$Elem im_msg_body_elem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) im_msg_body_elem)).booleanValue();
        }
        return im_msg_body_elem.life_online.has();
    }

    public void d(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.troop.data.c cVar) {
        im_msg_body$Elem im_msg_body_elem;
        int i3;
        int i16;
        Object obj;
        String str;
        String str2;
        String str3;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        String str4;
        String str5;
        String str6;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, list, list2, sb5, msg_comm_msg, cVar);
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        MessageHandler msgHandler = qQAppInterface.getMsgHandler();
        Iterator<im_msg_body$Elem> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                im_msg_body_elem = it.next();
                if (im_msg_body_elem.life_online.has()) {
                    break;
                }
            } else {
                im_msg_body_elem = null;
                break;
            }
        }
        if (im_msg_body_elem == null) {
            return;
        }
        if (im_msg_body_elem.life_online.has() && im_msg_body_elem.life_online.uint32_ack.has() && im_msg_body_elem.life_online.uint32_ack.get() == 1) {
            ((IPublicAccountManager) QRoute.api(IPublicAccountManager.class)).sendMsgArriveReceipt(BaseApplication.getContext(), msgHandler.Q, im_msg_body_elem.life_online.uint64_unique_id.has() ? im_msg_body_elem.life_online.uint64_unique_id.get() : 0L, im_msg_body_elem.life_online.uint32_op.has() ? im_msg_body_elem.life_online.uint32_op.get() : 0L, msg_comm_msg.msg_head.from_uin.has() ? msg_comm_msg.msg_head.from_uin.get() : 0L, msg_comm_msg.msg_head.to_uin.has() ? msg_comm_msg.msg_head.to_uin.get() : 0L, 1, null);
        }
        long j3 = im_msg_body_elem.life_online.uint64_unique_id.has() ? im_msg_body_elem.life_online.uint64_unique_id.get() : 0L;
        boolean z27 = im_msg_body_elem.life_online.uint64_bitmap.has() && (im_msg_body_elem.life_online.uint64_bitmap.get() & 1) == 1;
        boolean z28 = im_msg_body_elem.life_online.uint64_bitmap.has() && (im_msg_body_elem.life_online.uint64_bitmap.get() & 4) == 4;
        boolean z29 = im_msg_body_elem.life_online.uint64_bitmap.has() && (im_msg_body_elem.life_online.uint64_bitmap.get() & 64) == 64;
        boolean z36 = im_msg_body_elem.life_online.uint64_bitmap.has() && (im_msg_body_elem.life_online.uint64_bitmap.get() & 2048) == 2048;
        int i18 = (int) ((im_msg_body_elem.life_online.uint64_bitmap.get() & 384) >> 7);
        int i19 = (int) ((im_msg_body_elem.life_online.uint64_bitmap.get() & 1536) >> 9);
        if (z28) {
            obj = "null";
            z16 = im_msg_body_elem.life_online.uint64_bitmap.has() && (im_msg_body_elem.life_online.uint64_bitmap.get() & 8) == 8;
            z17 = im_msg_body_elem.life_online.uint64_bitmap.has() && (im_msg_body_elem.life_online.uint64_bitmap.get() & 16) == 16;
            z18 = im_msg_body_elem.life_online.uint64_bitmap.has() && (im_msg_body_elem.life_online.uint64_bitmap.get() & 32) == 32;
            if (im_msg_body_elem.life_online.gdt_imp_data.has()) {
                str5 = im_msg_body_elem.life_online.gdt_imp_data.get().toStringUtf8();
                str6 = "";
            } else {
                str5 = "";
                str6 = str5;
            }
            if (im_msg_body_elem.life_online.gdt_cli_data.has()) {
                str3 = im_msg_body_elem.life_online.gdt_cli_data.get().toStringUtf8();
                i16 = i19;
            } else {
                i16 = i19;
                str3 = str6;
            }
            if (im_msg_body_elem.life_online.view_id.has()) {
                str6 = im_msg_body_elem.life_online.view_id.get().toStringUtf8();
            }
            i3 = i18;
            if (str5.length() > 100) {
                i17 = 0;
                str5 = str5.substring(0, 100);
            } else {
                i17 = 0;
            }
            String str7 = str5;
            if (str3.length() > 100) {
                str3 = str3.substring(i17, 100);
            }
            str2 = str6;
            str = str7;
        } else {
            i3 = i18;
            i16 = i19;
            obj = "null";
            if (QLog.isColorLevel()) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("isAdArriveMsg is false, uint64_bitmap value is: ");
                sb6.append(im_msg_body_elem.life_online.uint64_bitmap.has() ? Long.valueOf(im_msg_body_elem.life_online.uint64_bitmap.get()) : obj);
                QLog.d("LifeOnlineElemDecoder", 2, sb6.toString());
            }
            str = "";
            str2 = str;
            str3 = str2;
            z16 = false;
            z17 = false;
            z18 = false;
        }
        if (im_msg_body_elem.life_online.uint64_bitmap.has() && (im_msg_body_elem.life_online.uint64_bitmap.get() & 4096) == 4096) {
            z19 = z29;
            z26 = true;
        } else {
            z19 = z29;
            z26 = false;
        }
        if ((z26 || (msg_comm_msg.msg_head.from_uin.has() && msg_comm_msg.msg_head.from_uin.get() == 1579646438)) && !list2.isEmpty()) {
            list2.get(0).saveExtInfoToExtStr("kandian_replace_subscribe_msg", "1");
        }
        if (z36) {
            if (!list2.isEmpty()) {
                list2.get(0).saveExtInfoToExtStr("recent_list_advertisement_message", "1");
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append("isRecentAd, uint64_bitmap value is: ");
                sb7.append(im_msg_body_elem.life_online.uint64_bitmap.has() ? Long.valueOf(im_msg_body_elem.life_online.uint64_bitmap.get()) : obj);
                QLog.d("LifeOnlineElemDecoder", 2, sb7.toString());
            }
            str4 = str;
            ThreadManager.getSubThreadHandler().postDelayed(new Runnable(qQAppInterface) { // from class: com.tencent.imcore.message.ext.codec.decoder.pbelement.LifeOnlineElemDecoder.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ QQAppInterface f116624d;

                {
                    this.f116624d = qQAppInterface;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LifeOnlineElemDecoder.this, (Object) qQAppInterface);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ((IPublicAccountManager) QRoute.api(IPublicAccountManager.class)).preloadWebProcess(this.f116624d);
                    }
                }
            }, 1000L);
        } else {
            str4 = str;
        }
        if (!list2.isEmpty()) {
            list2.get(0).extLong |= 1;
            list2.get(0).saveExtInfoToExtStr("pa_msgHasRead", "false");
            list2.get(0).saveExtInfoToExtStr("pa_msgId", String.valueOf(j3));
            list2.get(0).saveExtInfoToExtStr(IPublicAccountMsgExtMrg.PA_SHOULD_REPORT, String.valueOf(z27));
            if (z28) {
                list2.get(0).saveExtInfoToExtStr("isAdMsg", "1");
                list2.get(0).saveExtInfoToExtStr("ad_msgHasRead", "false");
                list2.get(0).saveExtInfoToExtStr("gdt_msgClick", str3);
                list2.get(0).saveExtInfoToExtStr("gdt_msgImp", str4);
                list2.get(0).saveExtInfoToExtStr("gdt_singleAd", z16 ? "1" : "0");
                list2.get(0).saveExtInfoToExtStr("gdt_mulAd", z17 ? "1" : "0");
                list2.get(0).saveExtInfoToExtStr("gdt_followAd", z18 ? "1" : "0");
                list2.get(0).saveExtInfoToExtStr("is_AdArrive_Msg", "1");
                list2.get(0).saveExtInfoToExtStr("gdt_view_id", str2);
            }
        }
        if (z19 && !list2.isEmpty()) {
            int i26 = 0;
            for (im_msg_body$Elem im_msg_body_elem2 : list) {
                if (im_msg_body_elem2.pub_acc_info.uint32_is_inter_num.has()) {
                    i26 = im_msg_body_elem2.pub_acc_info.uint32_is_inter_num.get();
                }
            }
            MessageRecord messageRecord = list2.get(0);
            messageRecord.saveExtInfoToExtStr("welcome_msg", "true");
            if (i26 != 2 && ((messageRecord instanceof MessageForText) || (messageRecord instanceof MessageForLongMsg))) {
                ThreadManagerV2.executeOnSubThread(new Runnable(msgHandler, msg_comm_msg) { // from class: com.tencent.imcore.message.ext.codec.decoder.pbelement.LifeOnlineElemDecoder.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ MessageHandler f116625d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ msg_comm$Msg f116626e;

                    {
                        this.f116625d = msgHandler;
                        this.f116626e = msg_comm_msg;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, LifeOnlineElemDecoder.this, msgHandler, msg_comm_msg);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            ((IPublicAccountHandler) this.f116625d.Q.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT)).getAIOHistoryMsg(String.valueOf(this.f116626e.msg_head.from_uin.get()), 0L, 1);
                        }
                    }
                });
            }
        }
        if (list2.isEmpty()) {
            return;
        }
        list2.get(0).saveExtInfoToExtStr("public_account_msg_unread_flag", String.valueOf(i3));
        list2.get(0).saveExtInfoToExtStr("public_account_msg_extra_info_type", String.valueOf(i16));
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
