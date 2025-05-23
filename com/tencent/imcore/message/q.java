package com.tencent.imcore.message;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;
import msf.msgcomm.msg_comm$MsgHead;
import msf.msgcomm.msg_comm$UinPairMsg;

/* compiled from: P */
/* loaded from: classes7.dex */
public class q {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private msg_comm$UinPairMsg f116707a;

    /* renamed from: b, reason: collision with root package name */
    private long f116708b;

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<MessageRecord> f116709c;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<msg_comm$Msg> f116710d;

    /* renamed from: e, reason: collision with root package name */
    private StringBuilder f116711e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.service.message.a f116712f;

    /* renamed from: g, reason: collision with root package name */
    private int f116713g;

    /* renamed from: h, reason: collision with root package name */
    private i f116714h;

    public q(i iVar, msg_comm$UinPairMsg msg_comm_uinpairmsg, long j3, ArrayList<MessageRecord> arrayList, ArrayList<msg_comm$Msg> arrayList2, StringBuilder sb5, com.tencent.mobileqq.service.message.a aVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, iVar, msg_comm_uinpairmsg, Long.valueOf(j3), arrayList, arrayList2, sb5, aVar, Integer.valueOf(i3));
            return;
        }
        this.f116707a = msg_comm_uinpairmsg;
        this.f116708b = j3;
        this.f116709c = arrayList;
        this.f116710d = arrayList2;
        this.f116711e = sb5;
        this.f116712f = aVar;
        this.f116713g = i3;
        this.f116714h = iVar;
    }

    private static void a(com.tencent.mobileqq.service.message.a aVar, ArrayList<MessageRecord> arrayList, i iVar, long j3, long j16, List<MessageRecord> list) {
        i.f116677y.e(iVar, arrayList, j3, j16, list, aVar);
    }

    private long b(long j3, long j16) {
        return i.f116677y.a(this.f116714h.f116342a, j16, j3, this.f116707a.peer_uin.get(), this.f116707a);
    }

    public q c() {
        msg_comm$Msg msg_comm_msg;
        msg_comm$MsgHead msg_comm_msghead;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (q) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        try {
            msg_comm_msg = this.f116710d.get(this.f116713g);
            msg_comm_msghead = msg_comm_msg.msg_head.get();
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeC2CMessage error,", e16);
            }
        }
        if (!msg_comm_msg.msg_head.has()) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.C2CMessageProcessor", 2, "<---decodeC2CMessagePackage: msgList[" + this.f116713g + "] : msg doesn't has msgHead.");
            }
            return this;
        }
        long j3 = msg_comm_msghead.to_uin.get();
        long j16 = msg_comm_msghead.from_uin.get();
        long j17 = msg_comm_msghead.from_uin.get();
        long j18 = msg_comm_msghead.msg_time.get();
        if (j18 > this.f116708b) {
            z16 = false;
        } else {
            z16 = true;
        }
        boolean z17 = z16;
        long b16 = b(j3, j17);
        com.tencent.mobileqq.service.message.a aVar = this.f116712f;
        aVar.f286162q = true;
        aVar.f286167v = String.valueOf(b16);
        if (i.J(this.f116711e, this.f116713g, z16, j18, b16, this.f116714h.f116342a)) {
            return this;
        }
        com.tencent.mobileqq.service.message.a aVar2 = this.f116712f;
        aVar2.f286154i = z16;
        aVar2.f286338a = b16;
        aVar2.f286161p = z17;
        a(this.f116712f, this.f116709c, this.f116714h, j16, b16, this.f116714h.L(msg_comm_msg, aVar2));
        return this;
    }
}
