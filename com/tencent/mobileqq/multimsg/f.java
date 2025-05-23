package com.tencent.mobileqq.multimsg;

import android.text.TextUtils;
import com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.utils.HwStatisticMgr;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.pic.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.manager.Manager;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f implements Manager {
    static IPatchRedirector $redirector_;
    private static byte[] C;

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f251595i;

    /* renamed from: m, reason: collision with root package name */
    public static boolean f251596m;

    /* renamed from: d, reason: collision with root package name */
    public boolean f251597d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f251598e;

    /* renamed from: f, reason: collision with root package name */
    private QQAppInterface f251599f;

    /* renamed from: h, reason: collision with root package name */
    private long f251600h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements ad {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f251601d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ MessageRecord f251602e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f251603f;

        a(QQAppInterface qQAppInterface, MessageRecord messageRecord, boolean z16) {
            this.f251601d = qQAppInterface;
            this.f251602e = messageRecord;
            this.f251603f = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, f.this, qQAppInterface, messageRecord, Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.mobileqq.pic.ad
        public MessageRecord g(im_msg_body$RichText im_msg_body_richtext) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (MessageRecord) iPatchRedirector.redirect((short) 2, (Object) this, (Object) im_msg_body_richtext);
            }
            return null;
        }

        @Override // com.tencent.mobileqq.pic.ad
        public void q(ad.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
                return;
            }
            try {
                if (aVar.f258597a == 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("StructLongTextMsg", 2, "step3: sendLongTextMsg pack upload cost: " + (System.currentTimeMillis() - f.this.f251600h) + ",mResid:" + aVar.f258602f);
                    }
                    StructMsgForGeneralShare Y = ChatActivityFacade.Y(this.f251601d.getApp().getApplicationContext(), this.f251602e, this.f251601d.getCurrentNickname());
                    Y.mResid = aVar.f258602f;
                    Y.mFileName = String.valueOf(this.f251602e.uniseq);
                    Y.multiMsgFlag = 1;
                    MessageForLongTextMsg messageForLongTextMsg = (MessageForLongTextMsg) q.d(MessageRecord.MSG_TYPE_STRUCT_LONG_TEXT);
                    messageForLongTextMsg.structingMsg = Y;
                    MessageRecord messageRecord = this.f251602e;
                    messageForLongTextMsg.frienduin = messageRecord.frienduin;
                    messageForLongTextMsg.istroop = messageRecord.istroop;
                    messageForLongTextMsg.selfuin = messageRecord.selfuin;
                    messageForLongTextMsg.senderuin = messageRecord.senderuin;
                    messageForLongTextMsg.isread = messageRecord.isread;
                    messageForLongTextMsg.time = messageRecord.time;
                    messageForLongTextMsg.msgseq = messageRecord.msgseq;
                    messageForLongTextMsg.msgUid = messageRecord.msgUid;
                    messageForLongTextMsg.shmsgseq = messageRecord.shmsgseq;
                    messageForLongTextMsg.issend = messageRecord.issend;
                    messageForLongTextMsg.uniseq = messageRecord.uniseq;
                    messageForLongTextMsg.mAnimFlag = true;
                    messageForLongTextMsg.mNewAnimFlag = true;
                    messageForLongTextMsg.longMsgCount = 1;
                    messageForLongTextMsg.longMsgIndex = 0;
                    messageForLongTextMsg.longMsgId = (short) messageRecord.shmsgseq;
                    messageForLongTextMsg.saveExtInfoToExtStr("long_text_msg_resid", aVar.f258602f);
                    if (com.tencent.biz.anonymous.a.m(this.f251602e)) {
                        com.tencent.biz.anonymous.a.h().a(messageForLongTextMsg);
                    }
                    this.f251601d.getMessageFacade().E0(messageForLongTextMsg, null, this.f251603f);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("StructLongTextMsg", 2, "MessageForReplyText upload multi msg pack failed, result.errStr=" + aVar.f258598b + ",result.errStr=" + aVar.f258599c);
                }
                f.c(this.f251601d, this.f251602e);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("StructLongTextMsg", 2, "MessageForReplyText upload multi msg pack failed, catch exception", e16);
                }
                f.c(this.f251601d, this.f251602e);
            }
        }

        @Override // com.tencent.mobileqq.pic.ad
        public void r(ad.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements ad {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f251605d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ MessageRecord f251606e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f251607f;

        b(QQAppInterface qQAppInterface, MessageRecord messageRecord, boolean z16) {
            this.f251605d = qQAppInterface;
            this.f251606e = messageRecord;
            this.f251607f = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, f.this, qQAppInterface, messageRecord, Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.mobileqq.pic.ad
        public MessageRecord g(im_msg_body$RichText im_msg_body_richtext) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (MessageRecord) iPatchRedirector.redirect((short) 4, (Object) this, (Object) im_msg_body_richtext);
            }
            return null;
        }

        @Override // com.tencent.mobileqq.pic.ad
        public void q(ad.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
                return;
            }
            try {
                if (aVar.f258597a == 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("StructLongTextMsg", 2, "step3: sendLongTextMsg pack upload cost: " + (System.currentTimeMillis() - f.this.f251600h) + ",mResid:" + aVar.f258602f);
                    }
                    StructMsgForGeneralShare Y = ChatActivityFacade.Y(this.f251605d.getApp().getApplicationContext(), this.f251606e, this.f251605d.getCurrentNickname());
                    Y.mResid = aVar.f258602f;
                    Y.mFileName = String.valueOf(this.f251606e.uniseq);
                    Y.multiMsgFlag = 1;
                    MessageForLongTextMsg messageForLongTextMsg = (MessageForLongTextMsg) this.f251606e;
                    messageForLongTextMsg.structingMsg = Y;
                    messageForLongTextMsg.saveExtInfoToExtStr("long_text_msg_resid", aVar.f258602f);
                    this.f251605d.getMessageFacade().E0(this.f251606e, null, this.f251607f);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("StructLongTextMsg", 2, "upload multi msg pack failed, result.errStr=" + aVar.f258598b + ",result.errStr=" + aVar.f258599c);
                }
                f.c(this.f251605d, this.f251606e);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("StructLongTextMsg", 2, "upload multi msg pack failed, catch exception", e16);
                }
                f.c(this.f251605d, this.f251606e);
            }
        }

        @Override // com.tencent.mobileqq.pic.ad
        public void r(ad.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class c implements com.tencent.mobileqq.pic.c {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f251609d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f251610e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f251611f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f251612h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f251613i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ long f251614m;

        c(QQAppInterface qQAppInterface, String str, int i3, long j3, boolean z16, long j16) {
            this.f251609d = qQAppInterface;
            this.f251610e = str;
            this.f251611f = i3;
            this.f251612h = j3;
            this.f251613i = z16;
            this.f251614m = j16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, qQAppInterface, str, Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z16), Long.valueOf(j16));
            }
        }

        @Override // com.tencent.mobileqq.pic.c
        public void a(int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            }
        }

        /* JADX WARN: Can't wrap try/catch for region: R(13:8|(2:9|10)|(3:78|79|(16:81|82|83|(2:157|158)|85|86|(24:90|91|(2:95|(1:97))|98|(5:100|101|102|103|104)(3:146|147|148)|105|106|(1:108)|136|137|(9:141|120|(1:130)(1:123)|124|(1:126)|127|128|63|64)|110|(3:112|113|114)(1:134)|115|(2:117|(1:119))|120|(0)|130|124|(0)|127|128|63|64)|150|(1:154)|155|124|(0)|127|128|63|64))|12|13|14|15|16|(3:18|(8:20|(1:22)|23|24|25|26|(3:28|29|30)(1:67)|31)(1:72)|32)(1:73)|33|(7:35|36|37|38|39|40|41)|63|64) */
        /* JADX WARN: Can't wrap try/catch for region: R(14:8|9|10|(3:78|79|(16:81|82|83|(2:157|158)|85|86|(24:90|91|(2:95|(1:97))|98|(5:100|101|102|103|104)(3:146|147|148)|105|106|(1:108)|136|137|(9:141|120|(1:130)(1:123)|124|(1:126)|127|128|63|64)|110|(3:112|113|114)(1:134)|115|(2:117|(1:119))|120|(0)|130|124|(0)|127|128|63|64)|150|(1:154)|155|124|(0)|127|128|63|64))|12|13|14|15|16|(3:18|(8:20|(1:22)|23|24|25|26|(3:28|29|30)(1:67)|31)(1:72)|32)(1:73)|33|(7:35|36|37|38|39|40|41)|63|64) */
        /* JADX WARN: Code restructure failed: missing block: B:109:0x0125, code lost:
        
            if (r9.istroop != 1) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x036d, code lost:
        
            r1 = r27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x0375, code lost:
        
            r1 = r27;
            r2 = r15;
            r9 = r17;
            r4 = r18;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:126:0x027f A[Catch: Exception -> 0x02a6, TryCatch #8 {Exception -> 0x02a6, blocks: (B:114:0x017c, B:115:0x0198, B:117:0x019e, B:119:0x01a4, B:120:0x01c0, B:123:0x01cf, B:124:0x0279, B:126:0x027f, B:127:0x029c, B:130:0x01ee, B:150:0x0237, B:152:0x0248, B:154:0x024c, B:155:0x026b), top: B:86:0x0080 }] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0383  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x03d9  */
        /* JADX WARN: Type inference failed for: r11v9, types: [com.tencent.mobileqq.app.message.MultiMsgProxy] */
        /* JADX WARN: Type inference failed for: r15v19 */
        /* JADX WARN: Type inference failed for: r15v2, types: [java.util.HashMap] */
        /* JADX WARN: Type inference failed for: r15v20 */
        /* JADX WARN: Type inference failed for: r15v24 */
        /* JADX WARN: Type inference failed for: r15v25 */
        /* JADX WARN: Type inference failed for: r15v3 */
        /* JADX WARN: Type inference failed for: r15v4 */
        /* JADX WARN: Type inference failed for: r15v5 */
        @Override // com.tencent.mobileqq.pic.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void h(c.a aVar) {
            String str;
            MessageRecord messageRecord;
            ?? hashMap;
            com.tencent.mobileqq.troop.data.c cVar;
            ArrayList<MessageRecord> L;
            String str2;
            String str3;
            int i3;
            MessageRecord messageRecord2;
            Object obj;
            Object obj2;
            c.a aVar2 = aVar;
            String str4 = "msg_expired";
            String str5 = ",errStr:";
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar2);
                return;
            }
            if (aVar2.f258654a == 0) {
                try {
                } catch (Exception unused) {
                    aVar2 = aVar;
                    str = ",cost:";
                    messageRecord = null;
                    if (messageRecord instanceof MessageForLongTextMsg) {
                    }
                    if (QLog.isColorLevel()) {
                    }
                    ((f) this.f251609d.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER)).d(this.f251609d, this.f251611f, aVar2.f258654a, 1);
                }
                if (aVar2.f258659f != null) {
                    hashMap = new HashMap();
                    MessageRecord P = this.f251609d.getMessageFacade().P(this.f251610e, this.f251611f, this.f251612h);
                    try {
                        if (QLog.isColorLevel()) {
                            try {
                                QLog.d("StructLongTextMsg", 2, "requestDownloadLongTextMsg mr:" + P.toString());
                            } catch (Exception unused2) {
                                messageRecord = P;
                                str = ",cost:";
                                if (messageRecord instanceof MessageForLongTextMsg) {
                                }
                                if (QLog.isColorLevel()) {
                                }
                                ((f) this.f251609d.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER)).d(this.f251609d, this.f251611f, aVar2.f258654a, 1);
                            }
                        }
                        cVar = new com.tencent.mobileqq.troop.data.c();
                        cVar.f294892b = P.istroop;
                        L = this.f251609d.getProxyManager().k().L(aVar2.f258659f, hashMap, null, cVar);
                        try {
                        } catch (Exception unused3) {
                            aVar2 = aVar;
                            messageRecord = P;
                            str4 = hashMap;
                            str = str2;
                            str5 = str3;
                            if (messageRecord instanceof MessageForLongTextMsg) {
                            }
                            if (QLog.isColorLevel()) {
                            }
                            ((f) this.f251609d.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER)).d(this.f251609d, this.f251611f, aVar2.f258654a, 1);
                        }
                    } catch (Exception unused4) {
                        aVar2 = aVar;
                    }
                    if (L != null && L.size() == 1) {
                        int i16 = 0;
                        if (L.get(0).msgtype != -1000 && L.get(0).msgtype != -1051) {
                            if (L.get(0).msgtype == -1035) {
                                i16 = 0;
                            }
                        }
                        if (L.get(i16).msgtype == -1035) {
                            messageRecord2 = L.get(i16);
                            MessageRecord.copyMessageRecordStatusField(messageRecord2, P);
                            messageRecord2.selfuin = P.selfuin;
                            messageRecord2.frienduin = P.frienduin;
                            messageRecord2.senderuin = P.senderuin;
                            messageRecord2.istroop = P.istroop;
                            messageRecord2.msgId = P.msgId;
                            str2 = ",cost:";
                            str3 = ",errStr:";
                            try {
                                this.f251609d.getMessageFacade().T1(P.frienduin, P.istroop, P.uniseq);
                                ((MixedMsgManager) this.f251609d.getManager(QQManagerFactory.MIXED_MSG_MANAGER)).u(true, this.f251611f);
                                i3 = 0;
                            } catch (Exception unused5) {
                                messageRecord = P;
                                str = str2;
                                str5 = str3;
                                if (messageRecord instanceof MessageForLongTextMsg) {
                                }
                                if (QLog.isColorLevel()) {
                                }
                                ((f) this.f251609d.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER)).d(this.f251609d, this.f251611f, aVar2.f258654a, 1);
                            }
                        } else {
                            str2 = ",cost:";
                            str3 = ",errStr:";
                            try {
                                P.f203106msg = L.get(i16).f203106msg;
                                P.saveExtInfoToExtStr("long_text_recv_state", "1");
                                P.removeExtInfoToExtStr("long_text_msg_resid");
                                i3 = 0;
                                messageRecord2 = null;
                            } catch (Exception unused6) {
                                aVar2 = aVar;
                                messageRecord = P;
                                str = str2;
                                str5 = str3;
                                if (messageRecord instanceof MessageForLongTextMsg) {
                                }
                                if (QLog.isColorLevel()) {
                                }
                                ((f) this.f251609d.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER)).d(this.f251609d, this.f251611f, aVar2.f258654a, 1);
                            }
                        }
                        if (L.get(i3).istroop == 1) {
                        }
                        if (L.get(0).istroop != 3000 || P.istroop != 3000) {
                            obj = "msg_expired";
                            if (L.get(0).msgtype != -1035 && messageRecord2 != null) {
                                this.f251609d.getMessageFacade().c(messageRecord2, this.f251609d.getAccount());
                                this.f251609d.getMsgHandler().notifyUI(1000, true, this.f251610e);
                                hashMap = obj;
                            } else {
                                this.f251609d.getMessageFacade().X0(this.f251610e, this.f251611f, this.f251612h, P.f203106msg);
                                this.f251609d.getMessageFacade().a1(this.f251610e, this.f251611f, this.f251612h, AppConstants.Key.COLUMN_EXT_STR, P.extStr);
                                this.f251609d.getMsgHandler().notifyUI(999, true, this.f251610e);
                                hashMap = obj;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("StructLongTextMsg", 2, "requestDownloadLongTextMsg onDownload success end! cost:" + (System.currentTimeMillis() - this.f251614m));
                            }
                            ((MessageForLongTextMsg) P).loading = false;
                            aVar2 = aVar;
                            ((f) this.f251609d.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER)).d(this.f251609d, this.f251611f, aVar2.f258654a, 1);
                        }
                        cVar.f294893c.j(14, this.f251612h);
                        cVar.f294893c.j(25, this.f251612h);
                        String str6 = P.frienduin;
                        long C = this.f251609d.getConversationFacade().C(str6, P.istroop);
                        if (QLog.isColorLevel()) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("requestDownloadLongTextMsg update MessageInfo-- groupUin:");
                            sb5.append(str6);
                            sb5.append("lastSeq:");
                            sb5.append(C);
                            sb5.append(",shMsgSeq:");
                            obj2 = "msg_expired";
                            sb5.append(P.shmsgseq);
                            sb5.append(",msgInfo.hasFlag:");
                            sb5.append(cVar.h());
                            QLog.d("StructLongTextMsg", 2, sb5.toString());
                        } else {
                            obj2 = "msg_expired";
                        }
                        obj = obj2;
                        if (P.shmsgseq > C) {
                            obj = obj2;
                            if (cVar.h()) {
                                P.mMessageInfo = cVar;
                                BaseMessageManagerForTroopAndDisc baseMessageManagerForTroopAndDisc = (BaseMessageManagerForTroopAndDisc) this.f251609d.getMessageFacade().F(1);
                                ArrayList<MessageRecord> arrayList = new ArrayList<>();
                                arrayList.add(P);
                                baseMessageManagerForTroopAndDisc.D0(str6, arrayList);
                                obj = obj2;
                            }
                        }
                        if (L.get(0).msgtype != -1035) {
                        }
                        this.f251609d.getMessageFacade().X0(this.f251610e, this.f251611f, this.f251612h, P.f203106msg);
                        this.f251609d.getMessageFacade().a1(this.f251610e, this.f251611f, this.f251612h, AppConstants.Key.COLUMN_EXT_STR, P.extStr);
                        this.f251609d.getMsgHandler().notifyUI(999, true, this.f251610e);
                        hashMap = obj;
                        if (QLog.isColorLevel()) {
                        }
                        ((MessageForLongTextMsg) P).loading = false;
                        aVar2 = aVar;
                        ((f) this.f251609d.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER)).d(this.f251609d, this.f251611f, aVar2.f258654a, 1);
                    }
                    hashMap = "msg_expired";
                    str2 = ",cost:";
                    str3 = ",errStr:";
                    ((MessageForLongTextMsg) P).loading = false;
                    if (i.l() && this.f251613i) {
                        P.saveExtInfoToExtStr("long_msg_download", "1");
                        this.f251609d.getMessageFacade().a1(this.f251610e, this.f251611f, this.f251612h, AppConstants.Key.COLUMN_EXT_STR, P.extStr);
                    }
                    this.f251609d.getMsgHandler().notifyUI(999, true, this.f251610e);
                    if (QLog.isColorLevel()) {
                    }
                    ((MessageForLongTextMsg) P).loading = false;
                    aVar2 = aVar;
                    ((f) this.f251609d.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER)).d(this.f251609d, this.f251611f, aVar2.f258654a, 1);
                }
            }
            hashMap = "msg_expired";
            str2 = ",cost:";
            str3 = ",errStr:";
            messageRecord = this.f251609d.getMessageFacade().P(this.f251610e, this.f251611f, this.f251612h);
            if (messageRecord instanceof MessageForLongTextMsg) {
                ((MessageForLongTextMsg) messageRecord).loading = false;
                if (i.l()) {
                    if (this.f251613i) {
                        messageRecord.saveExtInfoToExtStr("long_msg_download", "1");
                    }
                    aVar2 = aVar;
                    try {
                        if (Integer.toString(196).equals(aVar2.f258656c)) {
                            str4 = hashMap;
                            try {
                                messageRecord.saveExtInfoToExtStr(str4, "1");
                            } catch (Exception unused7) {
                                str = str2;
                                str5 = str3;
                                if (messageRecord instanceof MessageForLongTextMsg) {
                                    ((MessageForLongTextMsg) messageRecord).loading = false;
                                    if (i.l()) {
                                        if (this.f251613i) {
                                            messageRecord.saveExtInfoToExtStr("long_msg_download", "1");
                                        }
                                        if (aVar2 != null && Integer.toString(196).equals(aVar2.f258656c)) {
                                            messageRecord.saveExtInfoToExtStr(str4, "1");
                                        }
                                        this.f251609d.getMessageFacade().a1(this.f251610e, this.f251611f, this.f251612h, AppConstants.Key.COLUMN_EXT_STR, messageRecord.extStr);
                                    }
                                    this.f251609d.getMsgHandler().notifyUI(999, true, this.f251610e);
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d("StructLongTextMsg", 2, "requestDownloadLongTextMsg onDownload exception! resultCode:" + aVar2.f258654a + ",errCode: " + aVar2.f258655b + str5 + aVar2.f258656c + str + (System.currentTimeMillis() - this.f251614m));
                                }
                                ((f) this.f251609d.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER)).d(this.f251609d, this.f251611f, aVar2.f258654a, 1);
                            }
                        } else {
                            str4 = hashMap;
                        }
                        this.f251609d.getMessageFacade().a1(this.f251610e, this.f251611f, this.f251612h, AppConstants.Key.COLUMN_EXT_STR, messageRecord.extStr);
                    } catch (Exception unused8) {
                        str4 = hashMap;
                        str = str2;
                        str5 = str3;
                        if (messageRecord instanceof MessageForLongTextMsg) {
                        }
                        if (QLog.isColorLevel()) {
                        }
                        ((f) this.f251609d.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER)).d(this.f251609d, this.f251611f, aVar2.f258654a, 1);
                    }
                } else {
                    aVar2 = aVar;
                    str4 = hashMap;
                }
                this.f251609d.getMsgHandler().notifyUI(999, true, this.f251610e);
            } else {
                aVar2 = aVar;
                str4 = hashMap;
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("requestDownloadLongTextMsg onDownload failed! resultCode:");
                sb6.append(aVar2.f258654a);
                sb6.append(",errCode: ");
                sb6.append(aVar2.f258655b);
                str5 = str3;
                try {
                    sb6.append(str5);
                    sb6.append(aVar2.f258656c);
                    str = str2;
                } catch (Exception unused9) {
                    str = str2;
                }
                try {
                    sb6.append(str);
                    sb6.append(System.currentTimeMillis() - this.f251614m);
                    QLog.d("StructLongTextMsg", 2, sb6.toString());
                } catch (Exception unused10) {
                    if (messageRecord instanceof MessageForLongTextMsg) {
                    }
                    if (QLog.isColorLevel()) {
                    }
                    ((f) this.f251609d.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER)).d(this.f251609d, this.f251611f, aVar2.f258654a, 1);
                }
            }
            ((f) this.f251609d.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER)).d(this.f251609d, this.f251611f, aVar2.f258654a, 1);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73172);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        f251595i = new int[]{0, 1, 3000};
        f251596m = true;
        C = new byte[0];
    }

    public f(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f251597d = false;
        this.f251598e = false;
        this.f251599f = qQAppInterface;
    }

    public static void c(QQAppInterface qQAppInterface, MessageRecord messageRecord) {
        messageRecord.extraflag = 32768;
        qQAppInterface.getMsgCache().G1(messageRecord.frienduin, messageRecord.istroop, messageRecord.uniseq);
        ((MessageHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(MessageHandler.k3(messageRecord.istroop), false, new Object[]{messageRecord.frienduin, Integer.valueOf(messageRecord.istroop), -1, null, 0L, Long.valueOf(messageRecord.uniseq)});
    }

    public static void g(QQAppInterface qQAppInterface, String str, int i3, long j3, String str2, boolean z16) {
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("StructLongTextMsg", 2, "requestDownloadLongTextMsg begin! touin:" + str + ",touinType:" + i3 + ",uniseq:" + j3 + ",fileKey:" + str2);
        }
        MultiMsgManager.w().N(qQAppInterface, str2, qQAppInterface.getCurrentAccountUin(), str, str, i3, j3, 1035, new c(qQAppInterface, str, i3, j3, z16, currentTimeMillis));
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return 1;
    }

    public void d(QQAppInterface qQAppInterface, int i3, int i16, int i17) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, qQAppInterface, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        if (!com.tencent.mobileqq.service.message.j.a(qQAppInterface, 1000)) {
            return;
        }
        if (i16 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_resultCode", String.valueOf(i16));
        hashMap.put("param_uin", qQAppInterface.getCurrentAccountUin());
        hashMap.put("param_isTroop", String.valueOf(i3));
        if (i17 != 1) {
            if (i17 == 2) {
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(qQAppInterface.getCurrentAccountUin(), StatisticCollector.LTEXT_MANUAL_PULL_RESULT, z16, 0L, 0L, hashMap, "");
                return;
            }
            return;
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(qQAppInterface.getCurrentAccountUin(), StatisticCollector.LTEXT_AUTO_PULL_RESULT, z16, 0L, 0L, hashMap, "");
    }

    public void e(QQAppInterface qQAppInterface, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) qQAppInterface, (Object) messageRecord);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("StructLongTextMsg", 2, "reportReceiveLongMsg  istroop=" + messageRecord.istroop + " issend=" + messageRecord.issend + " msgType=" + messageRecord.msgtype + " longMsgCount=" + messageRecord.longMsgCount + " longMsgId=" + messageRecord.longMsgId + " longMsgIndex=" + messageRecord.longMsgIndex);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_istroop", String.valueOf(messageRecord.istroop));
        hashMap.put("param_issend", String.valueOf(messageRecord.issend));
        hashMap.put("param_msgtype", String.valueOf(messageRecord.msgtype));
        hashMap.put("param_isAnonymous", String.valueOf(com.tencent.biz.anonymous.a.m(messageRecord)));
        if (messageRecord.msgtype == -1051) {
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(qQAppInterface.getCurrentAccountUin(), StatisticCollector.LTEXT_NEW_RECEIVE_RESULT, true, 0L, 0L, hashMap, "");
        } else if (messageRecord.isLongMsg()) {
            hashMap.put("param_longMsgCount", String.valueOf(messageRecord.longMsgCount));
            hashMap.put("param_longMsgId", String.valueOf(messageRecord.longMsgId));
            hashMap.put("param_longMsgIndex", String.valueOf(messageRecord.longMsgIndex));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(qQAppInterface.getCurrentAccountUin(), StatisticCollector.LTEXT_OLD_RECEIVE_RESULT, true, 0L, 0L, hashMap, "");
        }
    }

    public void f(String str, int i3, long j3, int i16, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Long.valueOf(j16));
            return;
        }
        try {
            MessageRecord H = this.f251599f.getMessageProxy(i3).H(str, i3, j3);
            if (H != null) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("param_istroop", String.valueOf(H.istroop));
                hashMap.put("param_msgtype", String.valueOf(H.msgtype));
                hashMap.put("param_replycode", String.valueOf(i16));
                hashMap.put(HwStatisticMgr.KEY_CTIMECOST, String.valueOf(j16));
                hashMap.put("param_isAnonymous", String.valueOf(com.tencent.biz.anonymous.a.m(H)));
                if (H.msgtype == -1051) {
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f251599f.getCurrentAccountUin(), StatisticCollector.LTEXT_NEW_SEND_RESULT, true, 0L, 0L, hashMap, "");
                } else if (H.isLongMsg() && !this.f251599f.getMsgCache().t1(H)) {
                    hashMap.put("param_longMsgCount", String.valueOf(H.longMsgCount));
                    hashMap.put("param_longMsgId", String.valueOf(H.longMsgId));
                    hashMap.put("param_longMsgIndex", String.valueOf(H.longMsgIndex));
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f251599f.getCurrentAccountUin(), StatisticCollector.LTEXT_OLD_SEND_RESULT, true, 0L, 0L, hashMap, "");
                } else {
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("StructLongTextMsg", 2, "reportSendLongMsg  peerUin:" + str + " istroop=" + H.istroop + " issend=" + H.issend + " msgType=" + H.msgtype + " longMsgCount=" + H.longMsgCount + " longMsgId=" + H.longMsgId + " longMsgIndex=" + H.longMsgIndex + " replyCost=" + i16 + " cost=" + j16);
                }
            }
        } catch (Exception e16) {
            QLog.d("StructLongTextMsg", 1, "longmsg send report error!", e16);
        }
    }

    public void h(QQAppInterface qQAppInterface, MessageRecord messageRecord, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, qQAppInterface, messageRecord, Boolean.valueOf(z16));
        } else if (messageRecord instanceof MessageForReplyText) {
            i(qQAppInterface, messageRecord, z16, new a(qQAppInterface, messageRecord, z16));
        } else {
            i(qQAppInterface, messageRecord, z16, new b(qQAppInterface, messageRecord, z16));
        }
    }

    public void i(QQAppInterface qQAppInterface, MessageRecord messageRecord, boolean z16, ad adVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, qQAppInterface, messageRecord, Boolean.valueOf(z16), adVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("StructLongTextMsg", 4, " sendLongTextMsg start");
        }
        if (messageRecord == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("StructLongTextMsg", 2, "step1: sendLongTextMsg saveMessage start currenttime:" + System.currentTimeMillis());
        }
        if (messageRecord instanceof ChatMessage) {
            ((ChatMessage) messageRecord).mPendantAnimatable = true;
        }
        if (!z16 || TextUtils.isEmpty(messageRecord.extStr)) {
            messageRecord.saveExtInfoToExtStr("long_text_recv_state", "0");
            qQAppInterface.getMessageFacade().m(messageRecord);
            if (QLog.isColorLevel()) {
                QLog.d("StructLongTextMsg", 2, "saveLongTextMsg reSend:" + z16 + ",extStr:" + messageRecord.extStr);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("StructLongTextMsg", 2, "step2: sendLongTextMsg saveMessage end and pack longTextMsg start currenttime:" + System.currentTimeMillis());
        }
        byte[] s16 = qQAppInterface.getProxyManager().k().s(messageRecord);
        if (s16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("StructLongTextMsg", 2, "step2: sendLongTextMsg pack failed! packData is null.............................");
            }
            messageRecord.extraflag = 32768;
            qQAppInterface.getMsgCache().G1(messageRecord.frienduin, messageRecord.istroop, messageRecord.uniseq);
            ((MessageHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(MessageHandler.k3(messageRecord.istroop), false, new Object[]{messageRecord.frienduin, Integer.valueOf(messageRecord.istroop), -1, null, 0L, Long.valueOf(messageRecord.uniseq)});
            return;
        }
        this.f251600h = System.currentTimeMillis();
        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
        String str = messageRecord.frienduin;
        boolean j3 = j(qQAppInterface, s16, currentAccountUin, str, str, messageRecord.istroop, messageRecord.uniseq, 1035, adVar);
        if (j3) {
            if (QLog.isColorLevel()) {
                QLog.d("StructLongTextMsg", 2, "sendLongTextMsg successful, uploadLongTextMsgPkg start!");
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("StructLongTextMsg", 2, "sendLongTextMsg failed! isSuccess:" + j3);
            }
            c(qQAppInterface, messageRecord);
        }
    }

    public boolean j(QQAppInterface qQAppInterface, byte[] bArr, String str, String str2, String str3, int i3, long j3, int i16, ad adVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, qQAppInterface, bArr, str, str2, str3, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), adVar)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("StructLongTextMsg", 2, "[sendLongTextMsg]data.length = " + bArr.length);
        }
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mIsUp = true;
        transferRequest.mFileType = FileMsg.TRANSFILE_TYPE_MULTIMSG;
        transferRequest.multiMsgType = 1;
        transferRequest.toSendData = bArr;
        transferRequest.mSelfUin = str;
        transferRequest.mPeerUin = str2;
        transferRequest.mSecondId = str3;
        transferRequest.mUinType = i3;
        transferRequest.mUniseq = j3;
        transferRequest.mBusiType = i16;
        transferRequest.mUpCallBack = adVar;
        transferRequest.upMsgBusiType = b();
        ((ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(transferRequest);
        return true;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }
}
