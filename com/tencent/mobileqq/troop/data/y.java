package com.tencent.mobileqq.troop.data;

import PushNotifyPack.GroupMsgReadedNotify;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc$PbGetGroupMsgResp;
import msf.msgsvc.msg_svc$PbGroupReadedReportReq;
import msf.msgsvc.msg_svc$PbMsgReadedReportReq;

/* compiled from: P */
/* loaded from: classes19.dex */
public class y extends com.tencent.imcore.message.e {
    static IPatchRedirector $redirector_;

    /* renamed from: v, reason: collision with root package name */
    public static a f295008v;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        void a(String str, msg_svc$PbGetGroupMsgResp msg_svc_pbgetgroupmsgresp, int i3, y yVar);

        void b(GroupMsgReadedNotify groupMsgReadedNotify, y yVar);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45747);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            com.tencent.imcore.message.s.a();
        }
    }

    public y(AppInterface appInterface, BaseMessageHandler baseMessageHandler) {
        super(appInterface, baseMessageHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface, (Object) baseMessageHandler);
        }
    }

    public static void B(a aVar) {
        f295008v = aVar;
    }

    public void A(GroupMsgReadedNotify groupMsgReadedNotify) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) groupMsgReadedNotify);
            return;
        }
        String valueOf = String.valueOf(groupMsgReadedNotify.lGroupCode);
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.TroopMessageProcessor", 2, "GroupMsgReadedNotify lGroupCode is " + groupMsgReadedNotify.lGroupCode + ", lMemberSeq  is " + groupMsgReadedNotify.lMemberSeq);
        }
        Object[] C0 = ((com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache()).C0(valueOf);
        if (C0 != null && C0.length > 0 && ((Long) C0[0]).longValue() < groupMsgReadedNotify.lMemberSeq) {
            ((com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache()).t(valueOf, new Object[]{Long.valueOf(groupMsgReadedNotify.lMemberSeq), Long.valueOf(groupMsgReadedNotify.lGroupMsgSeq)});
        }
        ((IMessageFacade) this.f116342a.getRuntimeService(IMessageFacade.class, "")).setReadFrom(valueOf, 1, groupMsgReadedNotify.lMemberSeq);
        if (groupMsgReadedNotify.lMemberSeq >= 0) {
            ((IMessageFacade) this.f116342a.getRuntimeService(IMessageFacade.class, "")).removeNotification(valueOf, 1);
        }
        f295008v.b(groupMsgReadedNotify, this);
    }

    @Override // com.tencent.imcore.message.BaseMessageProcessor
    public void c(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        super.c(str, i3, j3);
        if (!str.matches("^\\d+$")) {
            return;
        }
        msg_svc$PbMsgReadedReportReq msg_svc_pbmsgreadedreportreq = new msg_svc$PbMsgReadedReportReq();
        msg_svc$PbGroupReadedReportReq msg_svc_pbgroupreadedreportreq = new msg_svc$PbGroupReadedReportReq();
        msg_svc_pbgroupreadedreportreq.group_code.set(Long.parseLong(str));
        msg_svc_pbgroupreadedreportreq.last_read_seq.set(j3);
        msg_svc_pbmsgreadedreportreq.grp_read_report.add(msg_svc_pbgroupreadedreportreq);
        w(msg_svc_pbmsgreadedreportreq);
    }

    @Override // com.tencent.imcore.message.BaseMessageProcessor
    public void r(int i3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), toServiceMsg, fromServiceMsg);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageProcessor
    public void t(int i3, Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) objArr);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageProcessor
    public void u(int i3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), toServiceMsg, fromServiceMsg);
        }
    }

    public void z(String str, msg_svc$PbGetGroupMsgResp msg_svc_pbgetgroupmsgresp, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, msg_svc_pbgetgroupmsgresp, Integer.valueOf(i3));
        } else {
            f295008v.a(str, msg_svc_pbgetgroupmsgresp, i3, this);
        }
    }
}
