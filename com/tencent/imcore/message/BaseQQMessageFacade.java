package com.tencent.imcore.message;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.collection.QQConcurrentHashMap;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msg.api.IMessageRecordFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.DeprecatedMethodInvokeReport;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.Manager;
import msf.msgsvc.msg_svc$PbC2CReadedReportReq;
import msf.msgsvc.msg_svc$PbDiscussReadedReportReq;
import msf.msgsvc.msg_svc$PbGroupReadedReportReq;
import msf.msgsvc.msg_svc$PbMsgReadedReportReq;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class BaseQQMessageFacade extends Observable implements Manager {
    static IPatchRedirector $redirector_;
    private final Object C;
    protected ak D;
    private final Vector<b> E;
    public final AtomicInteger F;
    public final ConcurrentHashMap<Integer, List<MessageRecord>> G;
    public final ConcurrentHashMap<String, Boolean> H;

    /* renamed from: d, reason: collision with root package name */
    private final BaseQQAppInterface f116348d;

    /* renamed from: e, reason: collision with root package name */
    public final QQConcurrentHashMap<String, Message> f116349e;

    /* renamed from: f, reason: collision with root package name */
    public QQConcurrentHashMap<String, Boolean> f116350f;

    /* renamed from: h, reason: collision with root package name */
    public Handler f116351h;

    /* renamed from: i, reason: collision with root package name */
    private final SparseArray<BaseMessageManager> f116352i;

    /* renamed from: m, reason: collision with root package name */
    public MsgNotifyManager f116353m;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f116357a;

        /* renamed from: b, reason: collision with root package name */
        public int f116358b;

        /* renamed from: c, reason: collision with root package name */
        public Object f116359c;

        /* renamed from: d, reason: collision with root package name */
        public int f116360d;

        public a(String str, int i3, int i16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16), obj);
                return;
            }
            this.f116357a = str;
            this.f116360d = i3;
            this.f116358b = i16;
            this.f116359c = obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class b implements Observer {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private Observer f116361d;

        public b(Observer observer) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) observer);
            } else {
                this.f116361d = observer;
            }
        }

        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) observable, obj);
                return;
            }
            Observer observer = this.f116361d;
            if (observer == null) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            observer.update(observable, obj);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (currentTimeMillis2 > 16) {
                QLog.d("Q.msg.QQMessageFacade", 1, observer + " update with: o = [" + observable + "], arg = [" + obj + "], costTime=[" + currentTimeMillis2 + "]ms");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseQQMessageFacade(BaseQQAppInterface baseQQAppInterface, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, baseQQAppInterface, Boolean.valueOf(z16));
            return;
        }
        this.f116352i = new SparseArray<>();
        this.C = new Object();
        this.E = new Vector<>();
        this.F = new AtomicInteger(0);
        this.G = new ConcurrentHashMap<>();
        this.H = new ConcurrentHashMap<>();
        this.f116348d = baseQQAppInterface;
        this.f116351h = new Handler(Looper.getMainLooper());
        this.f116349e = new QQConcurrentHashMap<>(Business.Conversation, "ConversationMsgInfo");
        this.D = new ak();
    }

    private boolean A(ConversationInfo conversationInfo) {
        Iterator<com.tencent.imcore.message.core.d> it = this.D.v().iterator();
        while (it.hasNext()) {
            if (it.next().a(conversationInfo)) {
                return true;
            }
        }
        return false;
    }

    private void C0(msg_svc$PbMsgReadedReportReq msg_svc_pbmsgreadedreportreq, ConversationInfo conversationInfo, long j3) {
        if (!conversationInfo.uin.matches("^\\d+$")) {
            return;
        }
        msg_svc$PbGroupReadedReportReq msg_svc_pbgroupreadedreportreq = new msg_svc$PbGroupReadedReportReq();
        msg_svc_pbgroupreadedreportreq.group_code.set(Long.valueOf(conversationInfo.uin).longValue());
        msg_svc_pbgroupreadedreportreq.last_read_seq.set(j3);
        msg_svc_pbmsgreadedreportreq.grp_read_report.add(msg_svc_pbgroupreadedreportreq);
    }

    private IMessageFacadeService H() {
        return (IMessageFacadeService) QRoute.api(IMessageFacadeService.class);
    }

    private String J(String str, int i3) {
        return ao.f(str, i3);
    }

    private void S0(StringBuilder sb5, msg_svc$PbMsgReadedReportReq msg_svc_pbmsgreadedreportreq, ConversationInfo conversationInfo) {
        H().setSubaccountAssistantReaded(this.f116348d, sb5, msg_svc_pbmsgreadedreportreq, conversationInfo);
    }

    private msg_svc$PbC2CReadedReportReq d0(StringBuilder sb5, msg_svc$PbC2CReadedReportReq msg_svc_pbc2creadedreportreq, ConversationInfo conversationInfo, int i3) {
        msg_svc$PbC2CReadedReportReq.UinPairReadInfo uinPairReadInfo = new msg_svc$PbC2CReadedReportReq.UinPairReadInfo();
        String str = conversationInfo.uin;
        if (1006 == conversationInfo.type) {
            str = H().getUinByPhoneNum(this.f116348d, conversationInfo.uin);
        }
        if (TextUtils.isEmpty(str)) {
            return msg_svc_pbc2creadedreportreq;
        }
        uinPairReadInfo.peer_uin.set(Long.valueOf(str).longValue());
        sb5.append("{C2C:");
        sb5.append(Long.valueOf(str));
        sb5.append(conversationInfo.type);
        sb5.append("}");
        uinPairReadInfo.last_read_time.set(i3);
        if (msg_svc_pbc2creadedreportreq == null) {
            msg_svc_pbc2creadedreportreq = new msg_svc$PbC2CReadedReportReq();
        }
        msg_svc_pbc2creadedreportreq.pair_info.add(uinPairReadInfo);
        return msg_svc_pbc2creadedreportreq;
    }

    private msg_svc$PbC2CReadedReportReq e0(boolean z16, StringBuilder sb5, msg_svc$PbC2CReadedReportReq msg_svc_pbc2creadedreportreq, MessageRecord messageRecord) {
        if (ao.F(messageRecord.senderuin)) {
            List<MessageRecord> Q = Q(messageRecord.senderuin, messageRecord.istroop);
            if (Q != null && !Q.isEmpty()) {
                for (MessageRecord messageRecord2 : Q) {
                    R0(messageRecord2.senderuin, messageRecord2.istroop, true, z16);
                    msg_svc$PbC2CReadedReportReq.UinPairReadInfo uinPairReadInfo = new msg_svc$PbC2CReadedReportReq.UinPairReadInfo();
                    uinPairReadInfo.peer_uin.set(Long.valueOf(messageRecord2.senderuin).longValue());
                    uinPairReadInfo.last_read_time.set((int) messageRecord2.time);
                    if (msg_svc_pbc2creadedreportreq == null) {
                        msg_svc_pbc2creadedreportreq = new msg_svc$PbC2CReadedReportReq();
                    }
                    msg_svc_pbc2creadedreportreq.pair_info.add(uinPairReadInfo);
                }
            }
        } else {
            P0(messageRecord.senderuin, messageRecord.istroop, messageRecord.getConfessTopicId(), true, z16);
            msg_svc$PbC2CReadedReportReq.UinPairReadInfo uinPairReadInfo2 = new msg_svc$PbC2CReadedReportReq.UinPairReadInfo();
            uinPairReadInfo2.peer_uin.set(Long.valueOf(messageRecord.senderuin).longValue());
            uinPairReadInfo2.last_read_time.set((int) messageRecord.time);
            if (msg_svc_pbc2creadedreportreq == null) {
                msg_svc_pbc2creadedreportreq = new msg_svc$PbC2CReadedReportReq();
            }
            msg_svc_pbc2creadedreportreq.pair_info.add(uinPairReadInfo2);
            sb5.append("{MSGBOX:");
            sb5.append(messageRecord.frienduin);
            sb5.append("}");
        }
        return msg_svc_pbc2creadedreportreq;
    }

    private msg_svc$PbC2CReadedReportReq f0(boolean z16, StringBuilder sb5, msg_svc$PbC2CReadedReportReq msg_svc_pbc2creadedreportreq, ConversationInfo conversationInfo) {
        int i3 = conversationInfo.type;
        if (1044 == i3) {
            return msg_svc_pbc2creadedreportreq;
        }
        List<MessageRecord> Q = Q(conversationInfo.uin, i3);
        if (Q == null) {
            return msg_svc_pbc2creadedreportreq;
        }
        for (int size = Q.size() - 1; size >= 0; size--) {
            MessageRecord messageRecord = Q.get(size);
            if (messageRecord != null) {
                msg_svc_pbc2creadedreportreq = e0(z16, sb5, msg_svc_pbc2creadedreportreq, messageRecord);
            }
        }
        return msg_svc_pbc2creadedreportreq;
    }

    private void o(int i3, List<MessageRecord> list, boolean z16, boolean z17, boolean z18) {
        com.tencent.imcore.message.facade.g gVar = (com.tencent.imcore.message.facade.g) ((Map) H().getMsgAddCompleteObserverProvider().get()).get(Integer.valueOf(i3));
        if (gVar != null) {
            gVar.a(this, list, z16, z17, z18);
        }
    }

    private b u(Observer observer) {
        Iterator<b> it = this.E.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && observer.equals(next.f116361d)) {
                return next;
            }
        }
        return null;
    }

    private BaseMessageManager v(int i3) {
        MsgPool I = S(i3).I();
        BaseMessageManager baseMessageManager = H().getMsgManagerProvider(this.f116348d, I).get().get(Integer.valueOf(i3));
        if (baseMessageManager == null) {
            return new C2CMessageManager(this.f116348d, I);
        }
        return baseMessageManager;
    }

    private void x(List<MessageRecord> list, BaseMessageManager.a aVar, boolean z16) {
        Iterator it = ((List) H().getMsgAddEndProcessorProvider().get()).iterator();
        while (it.hasNext()) {
            ((com.tencent.imcore.message.facade.a) it.next()).a(this, this.f116348d, list, aVar, z16);
        }
    }

    private void y(MessageRecord messageRecord) {
        Iterator<com.tencent.imcore.message.facade.b> it = H().getAddMultiMsgInnerProcessorProvider().get().iterator();
        while (it.hasNext()) {
            it.next().a(this.f116348d, messageRecord);
        }
    }

    private void y0(msg_svc$PbC2CReadedReportReq msg_svc_pbc2creadedreportreq, msg_svc$PbMsgReadedReportReq msg_svc_pbmsgreadedreportreq) {
        if (msg_svc_pbc2creadedreportreq != null) {
            byte[] F0 = H().getMsgHandlerMsgCache(this.f116348d).F0();
            if (F0 != null) {
                msg_svc_pbc2creadedreportreq.sync_cookie.set(ByteStringMicro.copyFrom(F0));
            }
            msg_svc_pbmsgreadedreportreq.c2c_read_report.set(msg_svc_pbc2creadedreportreq);
        }
    }

    private void z(MessageRecord messageRecord) {
        Iterator it = ((List) H().getRealSendProcessorProvider().get()).iterator();
        while (it.hasNext()) {
            ((com.tencent.imcore.message.facade.e) it.next()).a(this.f116348d, messageRecord);
        }
    }

    public boolean A0(String str, int i3, int i16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Boolean) iPatchRedirector.redirect((short) 36, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3))).booleanValue();
        }
        if (ao.s(i16) && ad.D(i16) && S(i3).w(str, i3, j3) != null) {
            return true;
        }
        return false;
    }

    public void B(String str, Collection<MessageRecord> collection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, (Object) this, (Object) str, (Object) collection);
            return;
        }
        if (collection != null) {
            p0("------------" + str + "--------------" + collection.size(), "");
            return;
        }
        p0("------------" + str + "-------------- is null", "");
    }

    public void B0(List<? extends MessageRecord> list, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, this, list, Boolean.valueOf(z16));
        } else if (list.size() != 0) {
            F(list.get(0).istroop).Z(list, true, z16);
        }
    }

    public MessageRecord C(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 78, (Object) this, (Object) messageRecord);
        }
        if (messageRecord.longMsgIndex == 0) {
            return messageRecord;
        }
        List<MessageRecord> p16 = S(messageRecord.istroop).p(messageRecord.frienduin, messageRecord.istroop);
        if (p16 != null && !p16.isEmpty()) {
            for (int size = p16.size() - 1; size >= 0; size--) {
                MessageRecord messageRecord2 = p16.get(size);
                if (ao.D(messageRecord2, messageRecord)) {
                    int i3 = messageRecord2.longMsgIndex;
                    if (i3 == 0) {
                        return messageRecord2;
                    }
                    if (i3 < messageRecord.longMsgIndex) {
                        messageRecord = messageRecord2;
                    }
                }
            }
            return messageRecord;
        }
        return messageRecord;
    }

    public List<MessageRecord> D(String str, int i3, int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (List) iPatchRedirector.redirect((short) 15, this, str, Integer.valueOf(i3), iArr);
        }
        return S(i3).n(str, i3, 5000, iArr);
    }

    public void D0(MessageRecord messageRecord, BusinessObserver businessObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            iPatchRedirector.redirect((short) 75, (Object) this, (Object) messageRecord, (Object) businessObserver);
        } else {
            E0(messageRecord, businessObserver, false);
        }
    }

    public List<MessageRecord> E(String str, int i3, int[] iArr, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (List) iPatchRedirector.redirect((short) 16, this, str, Integer.valueOf(i3), iArr, Integer.valueOf(i16));
        }
        return S(i3).n(str, i3, i16, iArr);
    }

    public void E0(MessageRecord messageRecord, BusinessObserver businessObserver, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            iPatchRedirector.redirect((short) 76, this, messageRecord, businessObserver, Boolean.valueOf(z16));
            return;
        }
        DeprecatedMethodInvokeReport.d("Message", "QQMessageFacade.sendMessage", messageRecord.toString());
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            ThreadManagerV2.post(new Runnable(messageRecord, businessObserver, z16) { // from class: com.tencent.imcore.message.BaseQQMessageFacade.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ MessageRecord f116354d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ BusinessObserver f116355e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ boolean f116356f;

                {
                    this.f116354d = messageRecord;
                    this.f116355e = businessObserver;
                    this.f116356f = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, BaseQQMessageFacade.this, messageRecord, businessObserver, Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        BaseQQMessageFacade.this.F0(this.f116354d, this.f116355e, this.f116356f);
                    } catch (RuntimeException e16) {
                        QLog.e("Q.msg.QQMessageFacade", 1, "smr error :", e16);
                        throw e16;
                    }
                }
            }, 10, null, false);
        } else {
            F0(messageRecord, businessObserver, z16);
        }
    }

    public BaseMessageManager F(int i3) {
        BaseMessageManager baseMessageManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BaseMessageManager) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        synchronized (this.C) {
            baseMessageManager = this.f116352i.get(i3);
            if (baseMessageManager == null) {
                baseMessageManager = v(i3);
                this.f116352i.put(i3, baseMessageManager);
            }
        }
        return baseMessageManager;
    }

    public void F0(MessageRecord messageRecord, BusinessObserver businessObserver, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            iPatchRedirector.redirect((short) 77, this, messageRecord, businessObserver, Boolean.valueOf(z16));
            return;
        }
        z(messageRecord);
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.QQMessageFacade", 2, "sendMessage: mr_uinType:" + messageRecord.istroop + " mr_msgType:" + messageRecord.msgtype);
        }
        try {
            if (messageRecord.msgUid == 0) {
                messageRecord.msgUid = com.tencent.mobileqq.service.message.s.f(com.tencent.mobileqq.service.message.s.a());
            }
            for (com.tencent.imcore.message.facade.f fVar : (List) H().getMsgSenderProvider().get()) {
                if (fVar.a(messageRecord)) {
                    fVar.b(this.f116348d, messageRecord, businessObserver, z16);
                    return;
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.msg.QQMessageFacade", 2, "sendMessage ERROR:" + e16.getMessage(), e16);
            }
        }
    }

    public ConversationFacade G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (ConversationFacade) iPatchRedirector.redirect((short) 37, (Object) this);
        }
        return H().getConversationFacade(this.f116348d);
    }

    public msg_svc$PbMsgReadedReportReq G0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 90)) {
            return (msg_svc$PbMsgReadedReportReq) iPatchRedirector.redirect((short) 90, (Object) this, z16);
        }
        Set<ConversationInfo> e16 = H().getConversationProxy(this.f116348d).e();
        msg_svc$PbC2CReadedReportReq msg_svc_pbc2creadedreportreq = null;
        if (e16 == null || e16.isEmpty()) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        msg_svc$PbMsgReadedReportReq msg_svc_pbmsgreadedreportreq = new msg_svc$PbMsgReadedReportReq();
        for (ConversationInfo conversationInfo : e16) {
            if (ConversationFacade.Q(conversationInfo) > 0 && G().i0(conversationInfo.uin, conversationInfo.type) && !A(conversationInfo)) {
                if (i0(conversationInfo.uin, conversationInfo.type)) {
                    msg_svc_pbc2creadedreportreq = f0(z16, sb5, msg_svc_pbc2creadedreportreq, conversationInfo);
                } else {
                    int i3 = conversationInfo.type;
                    if (7000 == i3) {
                        S0(sb5, msg_svc_pbmsgreadedreportreq, conversationInfo);
                    } else if (z16 || i3 != 1008 || !h0(conversationInfo)) {
                        int i16 = conversationInfo.type;
                        if (1006 != i16 && (!ao.r(i16) || Long.valueOf(conversationInfo.uin).longValue() <= 10000)) {
                            int i17 = conversationInfo.type;
                            if (3000 == i17) {
                                R0(conversationInfo.uin, i17, true, z16);
                                long X = X(conversationInfo.uin, conversationInfo.type);
                                if (X == -1) {
                                    break;
                                }
                                msg_svc$PbDiscussReadedReportReq msg_svc_pbdiscussreadedreportreq = new msg_svc$PbDiscussReadedReportReq();
                                msg_svc_pbdiscussreadedreportreq.conf_uin.set(Long.valueOf(conversationInfo.uin).longValue());
                                msg_svc_pbdiscussreadedreportreq.last_read_seq.set(X);
                                msg_svc_pbmsgreadedreportreq.dis_read_report.add(msg_svc_pbdiscussreadedreportreq);
                            } else if (1 == i17 && !H().isTroopMark(this.f116348d, conversationInfo.uin, conversationInfo.type)) {
                                R0(conversationInfo.uin, conversationInfo.type, true, z16);
                                H().setReadedForHCTopic(this.f116348d, conversationInfo.uin);
                                long X2 = X(conversationInfo.uin, conversationInfo.type);
                                if (X2 == -1) {
                                    break;
                                }
                                C0(msg_svc_pbmsgreadedreportreq, conversationInfo, X2);
                            }
                        } else {
                            int i18 = conversationInfo.type;
                            if (10007 == i18) {
                                msg_svc_pbc2creadedreportreq = T0(z16, msg_svc_pbc2creadedreportreq, conversationInfo);
                            } else if (i18 == 1036) {
                                continue;
                            } else {
                                R0(conversationInfo.uin, i18, true, z16);
                                long X3 = X(conversationInfo.uin, conversationInfo.type);
                                if (X3 == -1) {
                                    break;
                                }
                                msg_svc_pbc2creadedreportreq = d0(sb5, msg_svc_pbc2creadedreportreq, conversationInfo, (int) X3);
                            }
                        }
                    }
                }
            }
        }
        y0(msg_svc_pbc2creadedreportreq, msg_svc_pbmsgreadedreportreq);
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.QQMessageFacade", 2, "<ReadReport_All>setAllReaded: " + sb5.toString());
        }
        return msg_svc_pbmsgreadedreportreq;
    }

    public boolean H0(String str, int i3, List<MessageRecord> list, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return ((Boolean) iPatchRedirector.redirect((short) 66, this, str, Integer.valueOf(i3), list, Boolean.valueOf(z16))).booleanValue();
        }
        if (list != null && list.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.w("Q.msg.QQMessageFacade", 2, "refresh C2C autopull step 0 , FAIL! , timestamp = " + System.currentTimeMillis());
            }
            return false;
        }
        this.H.put(J(str, i3), Boolean.TRUE);
        List<MessageRecord> l3 = S(i3).l(str, i3);
        if (l3 == null || l3.isEmpty()) {
            return false;
        }
        if (!z16) {
            S(i3).s();
        }
        p0("refresh C2C autopull, size = " + l3.size(), ", timestamp = " + System.currentTimeMillis());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Message I(long j3, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return (Message) iPatchRedirector.redirect((short) 60, this, Long.valueOf(j3), list);
        }
        for (int i3 = 0; list != null && i3 < list.size(); i3++) {
            MessageRecord messageRecord = list.get(i3);
            if (messageRecord != null && messageRecord.uniseq > j3) {
                Message message = new Message();
                message.frienduin = messageRecord.frienduin;
                message.istroop = messageRecord.istroop;
                message.time = messageRecord.time;
                message.isread = messageRecord.isread;
                w(message);
                return message;
            }
        }
        return null;
    }

    public msg_svc$PbMsgReadedReportReq I0(String str, int i3, boolean z16) {
        boolean z17;
        StringBuilder sb5;
        StringBuilder sb6;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 89)) {
            return (msg_svc$PbMsgReadedReportReq) iPatchRedirector.redirect((short) 89, this, str, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!i0(str, i3)) {
            return null;
        }
        J0(str, i3);
        List<MessageRecord> Q = Q(str, i3);
        if (Q == null) {
            return null;
        }
        StringBuilder sb7 = new StringBuilder();
        msg_svc$PbMsgReadedReportReq msg_svc_pbmsgreadedreportreq = new msg_svc$PbMsgReadedReportReq();
        int size = Q.size() - 1;
        msg_svc$PbC2CReadedReportReq msg_svc_pbc2creadedreportreq = null;
        while (size >= 0) {
            MessageRecord messageRecord = Q.get(size);
            if (messageRecord == null) {
                z17 = z18;
                sb5 = sb7;
            } else if (ao.F(messageRecord.senderuin)) {
                List<MessageRecord> Q2 = Q(messageRecord.senderuin, messageRecord.istroop);
                if (Q2 != null && !Q2.isEmpty()) {
                    for (MessageRecord messageRecord2 : Q2) {
                        if (messageRecord2 != null) {
                            if (G().R(messageRecord2.senderuin, messageRecord2.istroop) > 0) {
                                R0(messageRecord2.senderuin, messageRecord2.istroop, false, z16);
                                msg_svc$PbC2CReadedReportReq.UinPairReadInfo uinPairReadInfo = new msg_svc$PbC2CReadedReportReq.UinPairReadInfo();
                                sb6 = sb7;
                                uinPairReadInfo.peer_uin.set(Long.valueOf(messageRecord2.senderuin).longValue());
                                uinPairReadInfo.last_read_time.set((int) messageRecord2.time);
                                if (msg_svc_pbc2creadedreportreq == null) {
                                    msg_svc_pbc2creadedreportreq = new msg_svc$PbC2CReadedReportReq();
                                }
                                msg_svc_pbc2creadedreportreq.pair_info.add(uinPairReadInfo);
                            } else {
                                sb6 = sb7;
                            }
                            sb7 = sb6;
                        }
                    }
                }
                sb5 = sb7;
                z17 = true;
            } else {
                StringBuilder sb8 = sb7;
                if (ao.w(messageRecord.senderuin)) {
                    if (G().R(messageRecord.senderuin, messageRecord.istroop) > 0) {
                        O0(messageRecord.senderuin, messageRecord.istroop);
                    }
                    IMessageFacadeService H = H();
                    z17 = true;
                    H.reportMsgBoxRead(this.f116348d, 1, null);
                    H.reportMsgBoxRead(this.f116348d, 2, null);
                } else {
                    z17 = true;
                    if (G().R(messageRecord.senderuin, messageRecord.istroop) > 0) {
                        R0(messageRecord.senderuin, messageRecord.istroop, false, z16);
                        msg_svc$PbC2CReadedReportReq.UinPairReadInfo uinPairReadInfo2 = new msg_svc$PbC2CReadedReportReq.UinPairReadInfo();
                        uinPairReadInfo2.peer_uin.set(Long.valueOf(messageRecord.senderuin).longValue());
                        uinPairReadInfo2.last_read_time.set((int) messageRecord.time);
                        if (msg_svc_pbc2creadedreportreq == null) {
                            msg_svc_pbc2creadedreportreq = new msg_svc$PbC2CReadedReportReq();
                        }
                        msg_svc_pbc2creadedreportreq.pair_info.add(uinPairReadInfo2);
                        sb5 = sb8;
                        sb5.append("{MSGBOX:");
                        sb5.append(messageRecord.senderuin);
                        sb5.append("}");
                    }
                }
                sb5 = sb8;
            }
            size--;
            sb7 = sb5;
            z18 = z17;
        }
        StringBuilder sb9 = sb7;
        if (msg_svc_pbc2creadedreportreq != null) {
            byte[] F0 = H().getMsgHandlerMsgCache(this.f116348d).F0();
            if (F0 != null) {
                msg_svc_pbc2creadedreportreq.sync_cookie.set(ByteStringMicro.copyFrom(F0));
            }
            msg_svc_pbmsgreadedreportreq.c2c_read_report.set(msg_svc_pbc2creadedreportreq);
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.QQMessageFacade", 2, "<ReadReport_LBS>setLbsFriendReaded: " + sb9.toString());
                QLog.d(LogTag.MSGBOX, 2, "setBoxMsgReaded[cost:" + (System.currentTimeMillis() - currentTimeMillis) + "]");
            }
            return msg_svc_pbmsgreadedreportreq;
        }
        return null;
    }

    public void J0(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) str, i3);
        } else {
            F(i3).d0(str, i3, false, false);
        }
    }

    public Message K(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return (Message) iPatchRedirector.redirect((short) 59, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (i3 == 1033 || i3 == 1034) {
            i17 = 1;
        }
        com.tencent.imcore.message.facade.c cVar = (com.tencent.imcore.message.facade.c) ((Map) H().getLastMsgGetterProvider().get()).get(Integer.valueOf(i17));
        if (cVar != null) {
            return cVar.a(this, this.f116348d, str, i3, i16);
        }
        return new Message();
    }

    public void K0(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 88)) {
            iPatchRedirector.redirect((short) 88, (Object) this, obj);
        } else {
            setChanged();
            notifyObservers(obj);
        }
    }

    public Message L(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return (Message) iPatchRedirector.redirect((short) 61, (Object) this, (Object) str, i3);
        }
        com.tencent.imcore.message.facade.c cVar = (com.tencent.imcore.message.facade.c) ((Map) H().getLastMsgGetterProvider().get()).get(2);
        if (cVar != null) {
            return cVar.a(this, this.f116348d, str, i3, 0);
        }
        return null;
    }

    public synchronized void L0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            iPatchRedirector.redirect((short) 85, (Object) this);
        } else {
            super.setChanged();
        }
    }

    public MessageRecord M(String str, int i3, long j3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 47, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16));
        }
        return S(i3).G(str, i3, j3, i16);
    }

    public void M0(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, this, str, Integer.valueOf(i3), Long.valueOf(j3));
        } else {
            F(i3).g0(str, i3, j3, false);
        }
    }

    public List<MessageRecord> N(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (List) iPatchRedirector.redirect((short) 18, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return S(i3).n(str, i3, i16, null);
    }

    public void N0(String str, int i3, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, this, str, Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z16));
        } else {
            F(i3).g0(str, i3, j3, z16);
        }
    }

    public List<MessageRecord> O(String str, int i3, long j3, int i16, long j16, int[] iArr, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (List) iPatchRedirector.redirect((short) 17, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Long.valueOf(j16), iArr, Integer.valueOf(i17));
        }
        return S(i3).Z(str, i3, j3, i16, j16, i17, iArr);
    }

    public void O0(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) str, i3);
        } else {
            R0(str, i3, true, false);
        }
    }

    public MessageRecord P(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 24, this, str, Integer.valueOf(i3), Long.valueOf(j3));
        }
        return S(i3).H(str, i3, j3);
    }

    public void P0(String str, int i3, int i16, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Boolean.valueOf(z17));
        } else {
            F(i3).i0(str, i3, z16, z17, i16);
        }
    }

    public List<MessageRecord> Q(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            return (List) iPatchRedirector.redirect((short) 70, (Object) this, (Object) str, i3);
        }
        return S(i3).p(str, i3);
    }

    public String R(Context context, MessageRecord messageRecord, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 102)) {
            return (String) iPatchRedirector.redirect((short) 102, this, context, messageRecord, Boolean.valueOf(z16));
        }
        Message message = new Message();
        MessageRecord.copyMessageRecordBaseField(message, messageRecord);
        message.emoRecentMsg = null;
        message.fileType = -1;
        w(message);
        return H().trimName(message.nickName, 0.4f);
    }

    public void R0(String str, int i3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
        } else {
            F(i3).h0(str, i3, z16, z17);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f S(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (f) iPatchRedirector.redirect((short) 19, (Object) this, i3);
        }
        return H().getMessageProxy(this.f116348d, i3);
    }

    public String T(Context context, MessageRecord messageRecord, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 100)) {
            return (String) iPatchRedirector.redirect((short) 100, this, context, messageRecord, Boolean.valueOf(z16));
        }
        return "";
    }

    protected msg_svc$PbC2CReadedReportReq T0(boolean z16, msg_svc$PbC2CReadedReportReq msg_svc_pbc2creadedreportreq, ConversationInfo conversationInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 97)) {
            return (msg_svc$PbC2CReadedReportReq) iPatchRedirector.redirect((short) 97, this, Boolean.valueOf(z16), msg_svc_pbc2creadedreportreq, conversationInfo);
        }
        return H().setTempGameMsgReaded(this.f116348d, this, z16, msg_svc_pbc2creadedreportreq, conversationInfo);
    }

    public MsgSummary U(Context context, MessageRecord messageRecord, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 98)) {
            return (MsgSummary) iPatchRedirector.redirect((short) 98, this, context, messageRecord, Boolean.valueOf(z16));
        }
        return H().getMsgSummaryForTroop(this.f116348d, this, context, messageRecord, z16);
    }

    public void U0(String str, int i3, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 96)) {
            iPatchRedirector.redirect((short) 96, this, str, Integer.valueOf(i3), messageRecord);
        } else {
            S(i3).w0(str, i3, messageRecord);
        }
    }

    public String V(Context context, MessageRecord messageRecord, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 99)) {
            return (String) iPatchRedirector.redirect((short) 99, this, context, messageRecord, Boolean.valueOf(z16));
        }
        return "";
    }

    public void V0(String str, int i3, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
        } else {
            W0(str, i3, j3, j16, null);
        }
    }

    public String W(Context context, MessageRecord messageRecord, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 101)) {
            return (String) iPatchRedirector.redirect((short) 101, this, context, messageRecord, Boolean.valueOf(z16));
        }
        return "";
    }

    public void W0(String str, int i3, long j3, long j16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), str2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.QQMessageFacade", 2, "updateC2CMsgTimeByUniseq: peerUin = " + str + " type = " + i3 + " uniseq = " + j3 + " time = " + j16);
        }
        F(i3).l0(str, i3, S(i3).x0(str, i3, j3, j16, str2), 3);
    }

    public long X(String str, int i3) {
        List<MessageRecord> Q;
        List<MessageRecord> p16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            return ((Long) iPatchRedirector.redirect((short) 71, (Object) this, (Object) str, i3)).longValue();
        }
        if (i3 != 1 && i3 != 3000 && i3 != 1026) {
            if (ao.r(i3) && (p16 = S(i3).p(str, i3)) != null && !p16.isEmpty()) {
                for (int size = p16.size() - 1; size >= 0; size--) {
                    MessageRecord messageRecord = p16.get(size);
                    if (!com.tencent.mobileqq.service.message.remote.a.c(messageRecord.issend)) {
                        return messageRecord.time;
                    }
                }
            }
            return -1L;
        }
        IMessageFacadeService H = H();
        Message lastMessage = H.getMessageFacade(this.f116348d).getLastMessage(str, i3);
        long j3 = lastMessage.shmsgseq;
        if (lastMessage.isLongMsg() && (Q = H.getMessageFacade(this.f116348d).Q(str, i3)) != null && Q.size() > 0) {
            return Math.max(j3, Q.get(Q.size() - 1).shmsgseq);
        }
        return j3;
    }

    public void X0(String str, int i3, long j3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 93)) {
            iPatchRedirector.redirect((short) 93, this, str, Integer.valueOf(i3), Long.valueOf(j3), str2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgContent: peerUin = " + str + " type = " + i3 + " uniseq = " + j3);
        }
        F(i3).l0(str, i3, S(i3).A0(str, i3, j3, str2), 2);
    }

    public ak Y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return (ak) iPatchRedirector.redirect((short) 56, (Object) this);
        }
        return this.D;
    }

    public void Y0(String str, int i3, long j3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 94)) {
            iPatchRedirector.redirect((short) 94, this, str, Integer.valueOf(i3), Long.valueOf(j3), bArr);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgContentByUniSeq: peerUin = " + str + " type = " + i3 + " uniseq = " + j3);
        }
        F(i3).l0(str, i3, S(i3).B0(str, i3, j3, bArr), 2);
    }

    public void Z0(String str, int i3, long j3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 91)) {
            iPatchRedirector.redirect((short) 91, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        QLog.i("Q.msg.QQMessageFacade", 1, "updateMsgExtraFlagByUniseq: peerUin = " + MsfSdkUtils.getShortUin(str) + " type = " + i3 + " uniseq = " + j3);
        F(i3).l0(str, i3, S(i3).C0(str, i3, j3, i16, i17), 3);
    }

    public void a(MessageRecord messageRecord, BusinessObserver businessObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            iPatchRedirector.redirect((short) 72, (Object) this, (Object) messageRecord, (Object) businessObserver);
        } else {
            b(messageRecord, businessObserver, false);
        }
    }

    public MessageRecord a0(String str, int i3, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 22, this, str, Integer.valueOf(i3), messageRecord);
        }
        return S(i3).K(str, i3, messageRecord);
    }

    public void a1(String str, int i3, long j3, String str2, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 92)) {
            iPatchRedirector.redirect((short) 92, this, str, Integer.valueOf(i3), Long.valueOf(j3), str2, obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgFieldByUniseq: peerUin = " + str + " type = " + i3 + " uniseq = " + j3 + " fieldName = " + str2 + " fieldValue = " + obj);
        }
        F(i3).l0(str, i3, S(i3).D0(str, i3, j3, str2, obj), 3);
    }

    @Override // java.util.Observable
    public synchronized void addObserver(Observer observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 105)) {
            iPatchRedirector.redirect((short) 105, (Object) this, (Object) observer);
            return;
        }
        if (observer == null) {
            return;
        }
        if (u(observer) != null) {
            QLog.d("Q.msg.QQMessageFacade", 1, "addObserver() called with: o = [" + observer + "], contains");
            return;
        }
        b bVar = new b(observer);
        super.addObserver(bVar);
        this.E.addElement(bVar);
    }

    public void b(MessageRecord messageRecord, BusinessObserver businessObserver, boolean z16) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            iPatchRedirector.redirect((short) 73, this, messageRecord, businessObserver, Boolean.valueOf(z16));
            return;
        }
        if (messageRecord != null && (str = messageRecord.frienduin) != null && str.length() >= 2) {
            if (QLog.isColorLevel()) {
                QLog.d("SendMsgBtn", 2, " addAndSendMessage addSendMessage start currenttime:" + System.currentTimeMillis());
            }
            com.tencent.imcore.message.facade.add.g.a(messageRecord);
            com.tencent.mobileqq.tianjige.f.b().g(messageRecord.telemetryTracerKey, "AddMessage", null);
            m(messageRecord);
            if (QLog.isColorLevel()) {
                QLog.d("SendMsgBtn", 2, " addAndSendMessage addSendMessage end and sendMessage start currenttime:" + System.currentTimeMillis());
            }
            com.tencent.mobileqq.tianjige.f.b().g(messageRecord.telemetryTracerKey, "SendMessage", null);
            E0(messageRecord, businessObserver, z16);
            if (QLog.isColorLevel()) {
                QLog.d("SendMsgBtn", 2, " addAndSendMessage sendMessage end currenttime:" + System.currentTimeMillis());
            }
        }
    }

    public MessageRecord b0(String str, int i3, MessageRecord messageRecord, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 23, this, str, Integer.valueOf(i3), messageRecord, list);
        }
        return S(i3).L(str, i3, messageRecord, list);
    }

    public void c(MessageRecord messageRecord, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) messageRecord, (Object) str);
        } else {
            d(messageRecord, str, false, true, true, true);
        }
    }

    public String c0(String str, long j3, long j16, long j17, int i3, boolean z16) {
        String str2;
        String str3;
        String str4;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 103)) {
            return (String) iPatchRedirector.redirect((short) 103, this, str, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        String str5 = "select * from " + str;
        String str6 = null;
        if (j3 >= 0) {
            str2 = String.format(" time >= %d and time <= %d ", Long.valueOf(j3), Long.valueOf(j16));
        } else {
            str2 = null;
        }
        if (j17 >= 0) {
            str3 = String.format(" _id >= %d ", Long.valueOf(j17));
        } else {
            str3 = null;
        }
        if (z16) {
            i16 = -1000;
        }
        if (i16 == -1000) {
            str4 = " msgtype = " + i16;
        } else {
            str4 = null;
        }
        if (str2 != null) {
            str6 = " where " + str2;
        }
        if (str3 != null) {
            if (str6 != null) {
                str6 = str6 + " and " + str3;
            } else {
                str6 = " where " + str3;
            }
        }
        if (str4 != null) {
            if (str6 != null) {
                str6 = str6 + " and " + str4;
            } else {
                str6 = " where " + str4;
            }
        }
        if (str6 != null) {
            str5 = str5 + str6;
        }
        if (i3 > 0) {
            return str5 + (" order by _id limit " + i3);
        }
        return str5;
    }

    public void c1(String str, int i3, MessageRecord messageRecord, ContentValues contentValues, int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 95)) {
            iPatchRedirector.redirect((short) 95, this, str, Integer.valueOf(i3), messageRecord, contentValues, iArr);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgFieldsByUniseq mr=" + messageRecord);
        }
        S(i3).F0(str, i3, messageRecord.uniseq, contentValues);
        if (iArr == null) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgFieldsByUniseq null == reasons");
                return;
            }
            return;
        }
        for (int i16 : iArr) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgFieldsByUniseq reason=" + i16);
            }
            F(i3).l0(str, i3, messageRecord, i16);
        }
    }

    public void d(MessageRecord messageRecord, String str, boolean z16, boolean z17, boolean z18, boolean z19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, messageRecord, str, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19));
            return;
        }
        EntityManager createEntityManager = this.f116348d.getEntityManagerFactory(str).createEntityManager();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(messageRecord);
            l(arrayList, createEntityManager, z16, z17, z18, z19);
            setChanged();
            com.tencent.imcore.message.facade.add.g.a(messageRecord);
            notifyObservers(messageRecord);
            l0(arrayList);
        } finally {
            createEntityManager.close();
        }
    }

    @Override // java.util.Observable
    public synchronized void deleteObserver(Observer observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 106)) {
            iPatchRedirector.redirect((short) 106, (Object) this, (Object) observer);
            return;
        }
        b u16 = u(observer);
        if (u16 != null) {
            super.deleteObserver(u16);
            this.E.removeElement(u16);
        } else {
            QLog.d("Q.msg.QQMessageFacade", 1, "deleteObserver() called with: o = [" + observer + "], NOT contains");
        }
    }

    @Override // java.util.Observable
    public synchronized void deleteObservers() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 107)) {
            iPatchRedirector.redirect((short) 107, (Object) this);
        } else {
            super.deleteObservers();
            this.E.removeAllElements();
        }
    }

    public void e(ArrayList<MessageRecord> arrayList, String str, boolean z16) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, arrayList, str, Boolean.valueOf(z16));
            return;
        }
        EntityManager createEntityManager = this.f116348d.getEntityManagerFactory(str).createEntityManager();
        if (!z16) {
            z17 = true;
        } else {
            z17 = false;
        }
        try {
            l(arrayList, createEntityManager, z16, z17, true, true);
            if (z16 && arrayList != null && !arrayList.isEmpty()) {
                S(arrayList.get(0).istroop).d(arrayList, null);
            }
            o(2, arrayList, false, false, false);
        } finally {
            createEntityManager.close();
        }
    }

    public void f(ArrayList<MessageRecord> arrayList, String str, boolean z16, boolean z17) {
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, arrayList, str, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        EntityManager createEntityManager = this.f116348d.getEntityManagerFactory(str).createEntityManager();
        if (!z16) {
            z18 = true;
        } else {
            z18 = false;
        }
        try {
            l(arrayList, createEntityManager, z16, z18, z17, true);
            if (z16 && arrayList != null && !arrayList.isEmpty()) {
                S(arrayList.get(0).istroop).d(arrayList, null);
            }
            o(3, arrayList, false, z17, false);
        } finally {
            createEntityManager.close();
        }
    }

    public void g(ArrayList<MessageRecord> arrayList, String str, boolean z16, boolean z17, boolean z18) {
        boolean z19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, arrayList, str, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
            return;
        }
        EntityManager createEntityManager = this.f116348d.getEntityManagerFactory(str).createEntityManager();
        if (!z16) {
            z19 = true;
        } else {
            z19 = false;
        }
        try {
            l(arrayList, createEntityManager, z16, z19, z17, true);
            if (z16 && arrayList != null && !arrayList.isEmpty()) {
                S(arrayList.get(0).istroop).d(arrayList, null);
            }
            o(3, arrayList, false, z17, z18);
        } finally {
            createEntityManager.close();
        }
    }

    public void g0(String str, int i3, List<MessageRecord> list, List<MessageRecord> list2, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, this, str, Integer.valueOf(i3), list, list2, bundle);
        } else {
            F(i3).B(str, i3, list, list2, bundle);
        }
    }

    public Message getLastMessage(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return (Message) iPatchRedirector.redirect((short) 58, (Object) this, (Object) str, i3);
        }
        com.tencent.imcore.message.facade.c cVar = (com.tencent.imcore.message.facade.c) ((Map) H().getLastMsgGetterProvider().get()).get(0);
        if (cVar != null) {
            return cVar.a(this, this.f116348d, str, i3, 0);
        }
        return new Message();
    }

    public void h(List<MessageRecord> list, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) list, (Object) str);
        } else {
            i(list, str, true);
        }
    }

    protected boolean h0(ConversationInfo conversationInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            return ((Boolean) iPatchRedirector.redirect((short) 80, (Object) this, (Object) conversationInfo)).booleanValue();
        }
        return H().isBelongServiceAccountFolder(this.f116348d, conversationInfo.uin);
    }

    public void i(List<MessageRecord> list, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, list, str, Boolean.valueOf(z16));
            return;
        }
        EntityManager createEntityManager = this.f116348d.getEntityManagerFactory().createEntityManager();
        try {
            l(list, createEntityManager, false, true, true, z16);
            createEntityManager.close();
            o(0, list, z16, false, false);
        } catch (Throwable th5) {
            createEntityManager.close();
            throw th5;
        }
    }

    boolean i0(String str, int i3) {
        return ao.z(str, i3);
    }

    public void j(List<MessageRecord> list, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) list, (Object) str);
            return;
        }
        EntityManager createEntityManager = this.f116348d.getEntityManagerFactory(str).createEntityManager();
        try {
            l(list, createEntityManager, true, false, true, true);
            createEntityManager.close();
            o(1, list, false, false, false);
        } catch (Throwable th5) {
            createEntityManager.close();
            throw th5;
        }
    }

    public boolean j0(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return ((Boolean) iPatchRedirector.redirect((short) 57, (Object) this, (Object) str, i3)).booleanValue();
        }
        String tableName = MessageRecord.getTableName(str, i3);
        StringBuilder sb5 = new StringBuilder(1024);
        sb5.append("select count() as counter, 'x' as msgData from ");
        sb5.append(tableName);
        sb5.append(" where issend=0 and isValid=1 and msgtype ");
        sb5.append(ao.k());
        List<Entity> rawQuery = DBMethodProxy.rawQuery(this.f116348d.getEntityManagerFactory().createEntityManager(), Message.class, sb5.toString(), null);
        if (rawQuery == null || rawQuery.size() <= 0 || ((Message) rawQuery.get(0)).counter <= 0) {
            return false;
        }
        return true;
    }

    public void k(MessageRecord messageRecord) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            iPatchRedirector.redirect((short) 74, (Object) this, (Object) messageRecord);
            return;
        }
        if (messageRecord != null && (str = messageRecord.frienduin) != null && str.length() >= 2) {
            if (QLog.isColorLevel()) {
                QLog.d("SendMsgBtn", 2, " addAndSendMessage addSendMessage start currenttime:" + System.currentTimeMillis());
            }
            com.tencent.imcore.message.facade.add.g.a(messageRecord);
            m(messageRecord);
            if (QLog.isColorLevel()) {
                QLog.d("SendMsgBtn", 2, " addAndSendMessage addSendMessage end and sendMessage start currenttime:" + System.currentTimeMillis());
            }
        }
    }

    public boolean k0(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return ((Boolean) iPatchRedirector.redirect((short) 51, (Object) this, (Object) messageRecord)).booleanValue();
        }
        Message lastMessage = getLastMessage(messageRecord.frienduin, messageRecord.istroop);
        if (ao.r(messageRecord.istroop)) {
            if (messageRecord.msgUid == lastMessage.msgUid && messageRecord.shmsgseq == lastMessage.shmsgseq) {
                return true;
            }
        } else if (messageRecord.shmsgseq == lastMessage.shmsgseq) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(List<MessageRecord> list, EntityManager entityManager, boolean z16, boolean z17, boolean z18, boolean z19) {
        long j3;
        char c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 6;
        char c17 = 4;
        char c18 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, list, entityManager, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19));
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            p0(String.format("addMultiMessagesInner size = %s, sync = %s, saveToDB = %s, needUpdateUnread = %s, needAddAIO = %s ", Integer.valueOf(list.size()), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19)), null);
        }
        if (!list.isEmpty()) {
            MessageRecord messageRecord = list.get(0);
            DeprecatedMethodInvokeReport.d("Message", "QQMessageFacade.addMultiMessagesInner", DeprecatedMethodInvokeReport.b.a(messageRecord.istroop, messageRecord.frienduin, messageRecord.msgtype, messageRecord.getClass().getSimpleName()));
        }
        BaseMessageManager.a aVar = new BaseMessageManager.a(this.f116348d);
        long size = list.size();
        for (MessageRecord messageRecord2 : list) {
            y(messageRecord2);
            if (messageRecord2.msgtype == -2029) {
                Object[] objArr = new Object[i3];
                objArr[c18] = "onReceiveGrapTips, uniseq:";
                j3 = currentTimeMillis;
                objArr[1] = Long.valueOf(messageRecord2.uniseq);
                objArr[2] = " uin:";
                objArr[3] = messageRecord2.frienduin;
                objArr[c17] = " type:";
                c16 = 5;
                objArr[5] = Integer.valueOf(messageRecord2.istroop);
                QLog.d("VideoRedBag", 1, objArr);
            } else {
                j3 = currentTimeMillis;
                c16 = 5;
            }
            F(messageRecord2.istroop).a(messageRecord2, entityManager, z16, z17, z18, z19, aVar);
            size = size;
            currentTimeMillis = j3;
            i3 = 6;
            c17 = 4;
            c18 = 0;
        }
        x(list, aVar, z18);
        MsgAutoMonitorUtil.getInstance().addAddMsgTime(System.currentTimeMillis() - currentTimeMillis, size);
    }

    public void l0(List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 87)) {
            iPatchRedirector.redirect((short) 87, (Object) this, (Object) list);
            return;
        }
        Iterator it = ((List) H().getMsgNotifyProcessProvider().get()).iterator();
        while (it.hasNext()) {
            ((com.tencent.imcore.message.facade.d) it.next()).a(this.f116348d, list);
        }
    }

    public void m(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) messageRecord);
        } else {
            n(messageRecord, com.tencent.mobileqq.service.message.e.Q0);
        }
    }

    public void m0(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            iPatchRedirector.redirect((short) 69, (Object) this, (Object) str, i3);
            return;
        }
        a aVar = new a(str, i3, 0, null);
        setChanged();
        notifyObservers(aVar);
    }

    public void n(MessageRecord messageRecord, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) messageRecord, i3);
            return;
        }
        EntityManager createEntityManager = this.f116348d.getEntityManagerFactory().createEntityManager();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(messageRecord);
            l(arrayList, createEntityManager, false, true, true, true);
            if (QLog.isColorLevel()) {
                QLog.d("sendmsg", 2, String.format("addSendMessage key = %d %s %d", Long.valueOf(messageRecord.uniseq), messageRecord.frienduin, Integer.valueOf(messageRecord.istroop)));
            }
            ((com.tencent.mobileqq.service.message.e) this.f116348d.getMsgCache()).L(messageRecord, i3);
            setChanged();
            notifyObservers(messageRecord);
        } finally {
            createEntityManager.close();
        }
    }

    public MessageRecord n0(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 79, (Object) this, (Object) message);
        }
        MessageRecord createMsgRecordFromDB = ((IMessageRecordFactory) QRoute.api(IMessageRecordFactory.class)).createMsgRecordFromDB(message.msgtype, message.msgData, message.extLong, message.extStr, message.istroop);
        MessageRecord.copyMessageRecordBaseField(createMsgRecordFromDB, message);
        if (createMsgRecordFromDB instanceof ChatMessage) {
            ((ChatMessage) createMsgRecordFromDB).parse();
        }
        return createMsgRecordFromDB;
    }

    @Override // java.util.Observable
    public void notifyObservers(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
            iPatchRedirector.redirect((short) 86, (Object) this, obj);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        super.notifyObservers(obj);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.QQMessageFacade", 2, "notifyObservers() called with: data = [" + obj + "], costTime = [" + currentTimeMillis2 + "]");
        }
        MsgAutoMonitorUtil msgAutoMonitorUtil = MsgAutoMonitorUtil.getInstance();
        if (msgAutoMonitorUtil != null) {
            msgAutoMonitorUtil.addMsgObserverTime(currentTimeMillis2);
            msgAutoMonitorUtil.addMsgObserverNotifyNum();
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            iPatchRedirector.redirect((short) 84, (Object) this);
            return;
        }
        QQConcurrentHashMap<String, Message> qQConcurrentHashMap = this.f116349e;
        if (qQConcurrentHashMap != null) {
            qQConcurrentHashMap.clear();
        }
        QQConcurrentHashMap<String, Boolean> qQConcurrentHashMap2 = this.f116350f;
        if (qQConcurrentHashMap2 != null) {
            qQConcurrentHashMap2.clear();
        }
        this.f116353m.ondestory();
        deleteObservers();
    }

    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this);
            return;
        }
        String tableName = new RecentUser().getTableName();
        String[] strArr = {"uin", "type"};
        SQLiteDatabase writableDatabase = this.f116348d.getWritableDatabase();
        if (writableDatabase == null) {
            return;
        }
        Cursor query = writableDatabase.query(tableName, strArr, null, null, null, null);
        if (query != null) {
            try {
                query.moveToFirst();
                for (int i3 = 0; i3 < query.getCount(); i3++) {
                    r(query.getString(0), query.getInt(1), false, true);
                    query.moveToNext();
                }
            } finally {
                query.close();
            }
        }
        if (query != null) {
        }
    }

    public void p0(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, (Object) this, (Object) str, (Object) str2);
        } else if (QLog.isColorLevel()) {
            QLog.d("Q.msg.QQMessageFacade", 2, str);
        }
    }

    public int q(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return ((Integer) iPatchRedirector.redirect((short) 52, (Object) this, (Object) str, i3)).intValue();
        }
        return r(str, i3, true, true);
    }

    public List<MessageRecord> q0(String str, int i3, long j3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (List) iPatchRedirector.redirect((short) 32, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16));
        }
        return S(i3).Q(str, i3, j3, i16);
    }

    public int r(String str, int i3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return ((Integer) iPatchRedirector.redirect((short) 53, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17))).intValue();
        }
        return F(i3).f(str, i3, z16, z17);
    }

    public List<MessageRecord> r0(String str, int i3, long j3, int i16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (List) iPatchRedirector.redirect((short) 35, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), str2);
        }
        return S(i3).V(str, i3, j3, i16, str2);
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, (Object) this);
        } else {
            G().l(false, true);
        }
    }

    public MessageRecord s0(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 28, this, str, Integer.valueOf(i3), Long.valueOf(j3));
        }
        return S(i3).f0(str, i3, j3);
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, (Object) this);
        } else {
            G().l(true, true);
        }
    }

    public List<MessageRecord> t0(String str, int i3, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (List) iPatchRedirector.redirect((short) 27, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
        }
        return S(i3).g0(str, i3, j3, j16);
    }

    public MessageRecord u0(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 29, this, str, Integer.valueOf(i3), Long.valueOf(j3));
        }
        return S(i3).h0(str, i3, j3);
    }

    public List<MessageRecord> v0(String str, int i3, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (List) iPatchRedirector.redirect((short) 30, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
        }
        return S(i3).i0(str, i3, j3, j16);
    }

    public void w(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this, (Object) message);
            return;
        }
        try {
            F(message.istroop).h(message);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.QQMessageFacade", 2, "decodeMsg ERROR", th5);
            }
        }
    }

    public MessageRecord w0(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 25, this, str, Integer.valueOf(i3), Long.valueOf(j3));
        }
        return S(i3).j0(str, i3, j3);
    }

    public List<MessageRecord> x0(String str, int i3, List<Long> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (List) iPatchRedirector.redirect((short) 26, this, str, Integer.valueOf(i3), list);
        }
        return S(i3).k0(str, i3, list);
    }

    public void z0(MessageRecord messageRecord, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, this, messageRecord, Boolean.valueOf(z16));
        } else {
            F(messageRecord.istroop).V(messageRecord, true, z16);
        }
    }

    public BaseQQMessageFacade(BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseQQAppInterface);
            return;
        }
        this.f116352i = new SparseArray<>();
        this.C = new Object();
        this.E = new Vector<>();
        this.F = new AtomicInteger(0);
        this.G = new ConcurrentHashMap<>();
        this.H = new ConcurrentHashMap<>();
        this.f116348d = baseQQAppInterface;
        this.f116351h = new Handler(Looper.getMainLooper());
        Business business = Business.Conversation;
        this.f116349e = new QQConcurrentHashMap<>(business, "ConversationMsgInfo");
        this.f116350f = new QQConcurrentHashMap<>(business, "ConversationRefreshAction");
        this.f116353m = new MsgNotifyManager(baseQQAppInterface);
        this.D = new ak();
    }
}
