package com.tencent.imcore.message;

import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.message.ProcessorObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import msf.msgcomm.msg_comm$Msg;
import msf.msgsvc.msg_svc$PbMsgReadedReportReq;

/* loaded from: classes7.dex */
public abstract class BaseMessageProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static int f116325e;

    /* renamed from: f, reason: collision with root package name */
    public static int f116326f;

    /* renamed from: g, reason: collision with root package name */
    public static int f116327g;

    /* renamed from: h, reason: collision with root package name */
    public static int f116328h;

    /* renamed from: i, reason: collision with root package name */
    public static int f116329i;

    /* renamed from: j, reason: collision with root package name */
    public static int f116330j;

    /* renamed from: k, reason: collision with root package name */
    public static int f116331k;

    /* renamed from: l, reason: collision with root package name */
    public static int f116332l;

    /* renamed from: m, reason: collision with root package name */
    public static int f116333m;

    /* renamed from: n, reason: collision with root package name */
    public static int f116334n;

    /* renamed from: o, reason: collision with root package name */
    public static int f116335o;

    /* renamed from: p, reason: collision with root package name */
    public static int f116336p;

    /* renamed from: q, reason: collision with root package name */
    public static int f116337q;

    /* renamed from: r, reason: collision with root package name */
    public static int f116338r;

    /* renamed from: s, reason: collision with root package name */
    public static int f116339s;

    /* renamed from: t, reason: collision with root package name */
    public static int f116340t;

    /* renamed from: u, reason: collision with root package name */
    private static b f116341u;

    /* renamed from: a, reason: collision with root package name */
    protected AppInterface f116342a;

    /* renamed from: b, reason: collision with root package name */
    protected BaseMessageHandler f116343b;

    /* renamed from: c, reason: collision with root package name */
    protected IMessageFacade f116344c;

    /* renamed from: d, reason: collision with root package name */
    private List<ProcessorObserver> f116345d;

    /* loaded from: classes7.dex */
    class a implements c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ msg_svc$PbMsgReadedReportReq f116346a;

        a(msg_svc$PbMsgReadedReportReq msg_svc_pbmsgreadedreportreq) {
            this.f116346a = msg_svc_pbmsgreadedreportreq;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BaseMessageProcessor.this, (Object) msg_svc_pbmsgreadedreportreq);
            }
        }

        @Override // com.tencent.imcore.message.BaseMessageProcessor.c
        public ToServiceMsg a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ToServiceMsg) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            ToServiceMsg createToServiceMsg = BaseMessageProcessor.this.f116343b.createToServiceMsg("PbMessageSvc.PbMsgReadedReport");
            createToServiceMsg.putWupBuffer(this.f116346a.toByteArray());
            createToServiceMsg.setEnableFastResend(true);
            return createToServiceMsg;
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        boolean a(AppRuntime appRuntime, MessageRecord messageRecord, boolean z16);
    }

    /* loaded from: classes7.dex */
    public interface c {
        ToServiceMsg a();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36649);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
            return;
        }
        f116325e = 1;
        f116326f = 2;
        f116327g = 3;
        f116328h = 4;
        f116329i = 5;
        f116330j = 6;
        f116331k = 1;
        f116332l = 2;
        f116333m = 3;
        f116334n = 1;
        f116335o = 2;
        f116336p = 3;
        f116337q = -1;
        f116338r = -2;
        f116339s = 1;
        f116340t = 2;
        s.a();
    }

    public BaseMessageProcessor(AppInterface appInterface, BaseMessageHandler baseMessageHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface, (Object) baseMessageHandler);
            return;
        }
        this.f116345d = new ArrayList();
        this.f116342a = appInterface;
        this.f116343b = baseMessageHandler;
        if (appInterface.isLogin()) {
            this.f116344c = (IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "");
        }
    }

    private Boolean i(List<msg_comm$Msg> list, Boolean bool, StringBuilder sb5, Set<String> set, msg_comm$Msg msg_comm_msg) {
        if (!msg_comm_msg.msg_head.has()) {
            return bool;
        }
        String e16 = e(msg_comm_msg);
        if (set.contains(e16)) {
            bool = Boolean.TRUE;
            if (QLog.isColorLevel()) {
                sb5.append("< duplicatedMsg:");
                sb5.append(e16);
                sb5.append(" >");
            }
        } else {
            set.add(e16);
            list.add(msg_comm_msg);
        }
        return bool;
    }

    private boolean k(boolean z16, boolean z17, boolean z18, c cVar, long j3) {
        if (!z16) {
            ToServiceMsg a16 = cVar.a();
            if (a16 == null) {
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "processRequest cmd=" + a16.getServiceCmd() + ",reqSeq=" + j3);
            }
            x(a16, j3, z17, z18);
            return true;
        }
        return false;
    }

    private void q(boolean z16, boolean z17, c cVar, long j3, long j16, SendMessageHandler sendMessageHandler) {
        for (int i3 = 0; i3 < 9; i3++) {
            sendMessageHandler.d(new SendMessageHandler.SendMessageRunnable(cVar, j3, j16, z16, z17) { // from class: com.tencent.imcore.message.BaseMessageProcessor.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ c G;
                final /* synthetic */ long H;
                final /* synthetic */ long I;
                final /* synthetic */ boolean J;
                final /* synthetic */ boolean K;

                {
                    this.G = cVar;
                    this.H = j3;
                    this.I = j16;
                    this.J = z16;
                    this.K = z17;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, BaseMessageProcessor.this, cVar, Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16), Boolean.valueOf(z17));
                    }
                }

                @Override // com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable, java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    ToServiceMsg a16 = this.G.a();
                    if (a16 == null) {
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageProcessor", 2, "prepareRetryRunnable cmd=" + a16.getServiceCmd() + ",reqSeq=" + this.H + " timeout: " + this.f307281e + " retryIndex:" + this.D);
                    }
                    a16.extraData.putLong(WadlProxyConsts.PARAM_TIME_OUT, this.f307281e);
                    a16.extraData.putLong("startTime", this.I);
                    a16.extraData.putInt("retryIndex", this.D);
                    a16.setTimeout(this.f307281e);
                    BaseMessageProcessor.this.x(a16, this.H, this.J, this.K);
                }
            });
        }
    }

    private void v(SendMessageHandler sendMessageHandler) {
        long j3;
        for (int i3 = 0; i3 < 3; i3++) {
            int i16 = 3 - i3;
            if (i3 == 0) {
                j3 = 480000;
            } else {
                j3 = ((i16 * 480000) / 3) - (i3 * 2000);
            }
            sendMessageHandler.f((480000 * i3) / 3, j3, "period");
        }
    }

    public static void y(b bVar) {
        f116341u = bVar;
    }

    public void a(ProcessorObserver processorObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) processorObserver);
            return;
        }
        synchronized (this.f116345d) {
            this.f116345d.add(processorObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ToServiceMsg toServiceMsg, ArrayList<MessageRecord> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) toServiceMsg, (Object) arrayList);
            return;
        }
        if (toServiceMsg == null || arrayList == null || !toServiceMsg.extraData.getBoolean("used_new_register_proxy", false)) {
            return;
        }
        Iterator<MessageRecord> it = arrayList.iterator();
        while (it.hasNext()) {
            MessageRecord next = it.next();
            if (next != null) {
                next.fromRegisterProxy = true;
            }
        }
    }

    public void c(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), Long.valueOf(j3));
        }
    }

    public AppInterface d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (AppInterface) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.f116342a;
    }

    protected String e(msg_comm$Msg msg_comm_msg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this, (Object) msg_comm_msg);
        }
        return String.valueOf(msg_comm_msg.hashCode());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean g(MessageRecord messageRecord, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, this, messageRecord, Boolean.valueOf(z16))).booleanValue();
        }
        return f116341u.a(this.f116342a, messageRecord, z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Pair<Boolean, StringBuilder> h(List<msg_comm$Msg> list, List<msg_comm$Msg> list2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Pair) iPatchRedirector.redirect((short) 12, (Object) this, (Object) list, (Object) list2);
        }
        if (list != null && list.size() != 0) {
            Boolean bool = Boolean.FALSE;
            StringBuilder sb5 = new StringBuilder();
            HashSet hashSet = new HashSet();
            Iterator<msg_comm$Msg> it = list.iterator();
            Boolean bool2 = bool;
            while (it.hasNext()) {
                bool2 = i(list2, bool2, sb5, hashSet, it.next());
            }
            return new Pair<>(bool2, sb5);
        }
        return new Pair<>(Boolean.FALSE, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(List<MessageRecord> list, ArrayList<MessageRecord> arrayList, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, list, arrayList, Boolean.valueOf(z16));
            return;
        }
        if (list.size() > 0) {
            for (MessageRecord messageRecord : list) {
                if (!g(messageRecord, z16)) {
                    arrayList.add(messageRecord);
                }
            }
        }
    }

    public void l(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        synchronized (this.f116345d) {
            Iterator<ProcessorObserver> it = this.f116345d.iterator();
            while (it.hasNext()) {
                it.next().onReceiveBusinessMessage(i3, z16, obj);
            }
        }
    }

    public void m(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        synchronized (this.f116345d) {
            Iterator<ProcessorObserver> it = this.f116345d.iterator();
            while (it.hasNext()) {
                it.next().onReceiveBusinessResp(i3, z16, obj);
            }
        }
    }

    public void n(String str, boolean z16, int i3, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, str, Boolean.valueOf(z16), Integer.valueOf(i3), Boolean.valueOf(z17), Boolean.valueOf(z18));
            return;
        }
        synchronized (this.f116345d) {
            Iterator<ProcessorObserver> it = this.f116345d.iterator();
            while (it.hasNext()) {
                it.next().onReceiveNewMessage(getClass().getSimpleName(), str, z16, i3, z17, z18);
            }
        }
    }

    public ag o(int i3, MsgInfo msgInfo, SvcReqPushMsg svcReqPushMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ag) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), msgInfo, svcReqPushMsg);
        }
        return null;
    }

    public void p(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, toServiceMsg, fromServiceMsg, obj);
        }
    }

    public void r(int i3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), toServiceMsg, fromServiceMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(boolean z16, boolean z17, boolean z18, long j3, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Long.valueOf(j3), cVar);
            return;
        }
        if (j3 == 0) {
            int i3 = MobileQQServiceBase.seq;
            MobileQQServiceBase.seq = i3 + 1;
            j3 = i3;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (k(z16, z17, z18, cVar, j3)) {
            return;
        }
        SendMessageHandler sendMessageHandler = new SendMessageHandler();
        this.f116343b.addToQueue(j3, sendMessageHandler);
        q(z17, z18, cVar, j3, currentTimeMillis, sendMessageHandler);
        v(sendMessageHandler);
    }

    public void t(int i3, Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) objArr);
        }
    }

    public void u(int i3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), toServiceMsg, fromServiceMsg);
        }
    }

    public void w(msg_svc$PbMsgReadedReportReq msg_svc_pbmsgreadedreportreq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) msg_svc_pbmsgreadedreportreq);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "sendMsgReadConfirm");
        }
        s(true, true, false, 0L, new a(msg_svc_pbmsgreadedreportreq));
    }

    protected void x(ToServiceMsg toServiceMsg, long j3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, toServiceMsg, Long.valueOf(j3), Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        toServiceMsg.extraData.putLong("msgSeq", j3);
        if (z16) {
            if (z17) {
                toServiceMsg.setNeedRemindSlowNetwork(true);
            }
            this.f116343b.sendPbReq(toServiceMsg);
            return;
        }
        this.f116343b.send(toServiceMsg);
    }
}
