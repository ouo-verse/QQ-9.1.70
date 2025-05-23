package com.tencent.mobileqq.reminder.biz;

import Wallet.AcsAckMsgReq;
import Wallet.AcsAckMsgRsp;
import Wallet.AcsBatchSubNoticeReq;
import Wallet.AcsBatchSubNoticeRsp;
import Wallet.AcsDelMsgReq;
import Wallet.AcsDelMsgRsp;
import Wallet.AcsGetMsgListReq;
import Wallet.AcsGetMsgListRsp;
import Wallet.AcsGetMsgReq;
import Wallet.AcsGetMsgRsp;
import Wallet.AcsHead;
import Wallet.AcsPullMsgReq;
import Wallet.AcsPullMsgRsp;
import Wallet.AcsQueryReq;
import Wallet.AcsQueryRsp;
import Wallet.AcsSubNoticeReq;
import Wallet.AcsSubNoticeRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.reminder.util.QQReminderUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.gift.QZoneCheckSendGiftServlet;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QQReminderServlet extends MSFServlet {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static final String f280927d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31570);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f280927d = QQReminderServlet.class.getSimpleName();
        }
    }

    public QQReminderServlet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static AcsHead a(AppRuntime appRuntime) {
        AcsHead acsHead = new AcsHead();
        acsHead.model = DeviceInfoMonitor.getModel();
        acsHead.platform = "Android";
        acsHead.version = QQReminderUtil.q(appRuntime);
        return acsHead;
    }

    private void b(Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        try {
            AcsAckMsgRsp acsAckMsgRsp = (AcsAckMsgRsp) Packet.decodePacket(fromServiceMsg.getWupBuffer(), "rsp", new AcsAckMsgRsp());
            bundle.putSerializable("req", intent.getSerializableExtra("req"));
            if (acsAckMsgRsp != null) {
                bundle.putSerializable("rsp", acsAckMsgRsp);
                notifyObserver(intent, 2004, fromServiceMsg.isSuccess(), bundle, null);
            } else {
                notifyObserver(intent, 2004, false, bundle, null);
            }
        } catch (Exception unused) {
            notifyObserver(intent, 2004, false, bundle, null);
        }
    }

    private void c(Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        try {
            AcsBatchSubNoticeRsp acsBatchSubNoticeRsp = (AcsBatchSubNoticeRsp) Packet.decodePacket(fromServiceMsg.getWupBuffer(), "rsp", new AcsBatchSubNoticeRsp());
            bundle.putSerializable("req", intent.getSerializableExtra("req"));
            if (acsBatchSubNoticeRsp != null) {
                bundle.putSerializable("rsp", acsBatchSubNoticeRsp);
                notifyObserver(intent, 2007, fromServiceMsg.isSuccess(), bundle, null);
            } else {
                notifyObserver(intent, 2007, false, bundle, null);
            }
        } catch (Exception unused) {
            notifyObserver(intent, 2007, false, bundle, null);
        }
    }

    private void d(Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        try {
            AcsDelMsgRsp acsDelMsgRsp = (AcsDelMsgRsp) Packet.decodePacket(fromServiceMsg.getWupBuffer(), "rsp", new AcsDelMsgRsp());
            bundle.putSerializable("req", intent.getSerializableExtra("req"));
            if (acsDelMsgRsp != null) {
                bundle.putSerializable("rsp", acsDelMsgRsp);
                notifyObserver(intent, 2001, fromServiceMsg.isSuccess(), bundle, null);
            } else {
                notifyObserver(intent, 2001, false, bundle, null);
            }
        } catch (Exception unused) {
            notifyObserver(intent, 2001, false, bundle, null);
        }
    }

    private void e(Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        try {
            AcsGetMsgRsp acsGetMsgRsp = (AcsGetMsgRsp) Packet.decodePacket(fromServiceMsg.getWupBuffer(), "rsp", new AcsGetMsgRsp());
            bundle.putSerializable("req", intent.getSerializableExtra("req"));
            if (acsGetMsgRsp != null) {
                bundle.putSerializable("rsp", acsGetMsgRsp);
                notifyObserver(intent, 2005, fromServiceMsg.isSuccess(), bundle, null);
            } else {
                notifyObserver(intent, 2005, false, bundle, null);
            }
        } catch (Exception unused) {
            notifyObserver(intent, 2005, false, bundle, null);
        }
    }

    private void f(Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        try {
            AcsPullMsgRsp acsPullMsgRsp = (AcsPullMsgRsp) Packet.decodePacket(fromServiceMsg.getWupBuffer(), "rsp", new AcsPullMsgRsp());
            bundle.putSerializable("req", intent.getSerializableExtra("req"));
            if (acsPullMsgRsp != null) {
                bundle.putSerializable("rsp", acsPullMsgRsp);
                notifyObserver(intent, 2003, fromServiceMsg.isSuccess(), bundle, null);
            } else {
                notifyObserver(intent, 2003, false, bundle, null);
            }
        } catch (Exception unused) {
            notifyObserver(intent, 2003, false, bundle, null);
        }
    }

    private void g(Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        try {
            AcsGetMsgListRsp acsGetMsgListRsp = (AcsGetMsgListRsp) Packet.decodePacket(fromServiceMsg.getWupBuffer(), "rsp", new AcsGetMsgListRsp());
            bundle.putSerializable("req", intent.getSerializableExtra("req"));
            if (acsGetMsgListRsp != null) {
                bundle.putSerializable("rsp", acsGetMsgListRsp);
                notifyObserver(intent, 2000, fromServiceMsg.isSuccess(), bundle, null);
            } else {
                notifyObserver(intent, 2000, false, bundle, null);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            bundle.putSerializable("req", intent.getSerializableExtra("req"));
            notifyObserver(intent, 2000, false, bundle, null);
        }
    }

    private void h(Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        try {
            AcsQueryRsp acsQueryRsp = (AcsQueryRsp) Packet.decodePacket(fromServiceMsg.getWupBuffer(), "rsp", new AcsQueryRsp());
            bundle.putSerializable("req", intent.getSerializableExtra("req"));
            if (acsQueryRsp != null) {
                bundle.putSerializable("rsp", acsQueryRsp);
                notifyObserver(intent, 2006, fromServiceMsg.isSuccess(), bundle, null);
            } else {
                notifyObserver(intent, 2006, false, bundle, null);
            }
        } catch (Exception unused) {
            notifyObserver(intent, 2006, false, bundle, null);
        }
    }

    private void i(Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        try {
            AcsSubNoticeRsp acsSubNoticeRsp = (AcsSubNoticeRsp) Packet.decodePacket(fromServiceMsg.getWupBuffer(), "rsp", new AcsSubNoticeRsp());
            bundle.putSerializable("req", intent.getSerializableExtra("req"));
            if (acsSubNoticeRsp != null) {
                bundle.putSerializable("rsp", acsSubNoticeRsp);
                notifyObserver(intent, 2002, fromServiceMsg.isSuccess(), bundle, null);
            } else {
                notifyObserver(intent, 2002, false, bundle, null);
            }
        } catch (Exception unused) {
            notifyObserver(intent, 2002, false, bundle, null);
        }
    }

    private void j(Bundle bundle, Packet packet) {
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", bundle.getString("account"), "NoticeSvr.AckMsg");
        AcsAckMsgReq acsAckMsgReq = (AcsAckMsgReq) bundle.getSerializable("req");
        packet.setServantName("Wallet.NoticeAccessServer.NoticeAccessObj");
        packet.setFuncName("AckMsg");
        packet.addRequestPacket("req", acsAckMsgReq);
        packet.setSSOCommand(toServiceMsg.getServiceCmd());
        packet.setTimeout(15000L);
        if (!toServiceMsg.isNeedCallback()) {
            packet.setNoResponse();
        }
    }

    private void k(Bundle bundle, Packet packet) {
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", bundle.getString("account"), "NoticeSvr.BatchSubNotice");
        AcsBatchSubNoticeReq acsBatchSubNoticeReq = (AcsBatchSubNoticeReq) bundle.getSerializable("req");
        packet.setServantName("Wallet.NoticeAccessServer.NoticeAccessObj");
        packet.setFuncName("BatchSubNotice");
        packet.addRequestPacket("req", acsBatchSubNoticeReq);
        packet.setSSOCommand(toServiceMsg.getServiceCmd());
        packet.setTimeout(15000L);
        if (!toServiceMsg.isNeedCallback()) {
            packet.setNoResponse();
        }
    }

    private void l(Bundle bundle, Packet packet) {
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", bundle.getString("account"), "NoticeSvr.DelMsg");
        AcsDelMsgReq acsDelMsgReq = (AcsDelMsgReq) bundle.getSerializable("req");
        packet.setServantName("Wallet.NoticeAccessServer.NoticeAccessObj");
        packet.setFuncName("DelMsg");
        packet.addRequestPacket("req", acsDelMsgReq);
        packet.setSSOCommand(toServiceMsg.getServiceCmd());
        packet.setTimeout(15000L);
        if (!toServiceMsg.isNeedCallback()) {
            packet.setNoResponse();
        }
    }

    private void m(Bundle bundle, Packet packet) {
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", bundle.getString("account"), "NoticeSvr.GetMsg");
        AcsGetMsgReq acsGetMsgReq = (AcsGetMsgReq) bundle.getSerializable("req");
        packet.setServantName("Wallet.NoticeAccessServer.NoticeAccessObj");
        packet.setFuncName("GetMsg");
        packet.addRequestPacket("req", acsGetMsgReq);
        packet.setSSOCommand(toServiceMsg.getServiceCmd());
        packet.setTimeout(15000L);
        if (!toServiceMsg.isNeedCallback()) {
            packet.setNoResponse();
        }
    }

    private void n(Bundle bundle, Packet packet) {
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", bundle.getString("account"), "NoticeSvr.Query");
        AcsQueryReq acsQueryReq = (AcsQueryReq) bundle.getSerializable("req");
        packet.setServantName("Wallet.NoticeAccessServer.NoticeAccessObj");
        packet.setFuncName("Query");
        packet.addRequestPacket("req", acsQueryReq);
        packet.setSSOCommand(toServiceMsg.getServiceCmd());
        packet.setTimeout(15000L);
        if (!toServiceMsg.isNeedCallback()) {
            packet.setNoResponse();
        }
    }

    private void o(Bundle bundle, Packet packet) {
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", bundle.getString("account"), "NoticeSvr.GetMsgList");
        AcsGetMsgListReq acsGetMsgListReq = (AcsGetMsgListReq) bundle.getSerializable("req");
        packet.setServantName("Wallet.NoticeAccessServer.NoticeAccessObj");
        packet.setFuncName("GetMsgList");
        packet.addRequestPacket("req", acsGetMsgListReq);
        packet.setSSOCommand(toServiceMsg.getServiceCmd());
        packet.setTimeout(15000L);
        if (!toServiceMsg.isNeedCallback()) {
            packet.setNoResponse();
        }
    }

    private void p(Bundle bundle, Packet packet) {
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", bundle.getString("account"), "NoticeSvr.PullMsg");
        AcsPullMsgReq acsPullMsgReq = (AcsPullMsgReq) bundle.getSerializable("req");
        packet.setServantName("Wallet.NoticeAccessServer.NoticeAccessObj");
        packet.setFuncName("PullMsg");
        packet.addRequestPacket("req", acsPullMsgReq);
        packet.setSSOCommand(toServiceMsg.getServiceCmd());
        packet.setTimeout(15000L);
        if (!toServiceMsg.isNeedCallback()) {
            packet.setNoResponse();
        }
    }

    private void q(Bundle bundle, Packet packet) {
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", bundle.getString("account"), "NoticeSvr.SubNotice");
        AcsSubNoticeReq acsSubNoticeReq = (AcsSubNoticeReq) bundle.getSerializable("req");
        packet.setServantName("Wallet.NoticeAccessServer.NoticeAccessObj");
        packet.setFuncName("SubNotice");
        packet.addRequestPacket("req", acsSubNoticeReq);
        packet.setSSOCommand(toServiceMsg.getServiceCmd());
        packet.setTimeout(15000L);
        if (!toServiceMsg.isNeedCallback()) {
            packet.setNoResponse();
        }
    }

    @Override // mqq.app.Servlet
    public void notifyObserver(Intent intent, int i3, boolean z16, Bundle bundle, Class<? extends BusinessObserver> cls) {
        BusinessObserver observer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, intent, Integer.valueOf(i3), Boolean.valueOf(z16), bundle, cls);
            return;
        }
        if (intent.getIntExtra(QZoneCheckSendGiftServlet.PARAM_REQ_TYPE, 0) == 0) {
            super.notifyObserver(intent, i3, z16, bundle, cls);
        } else if ((intent instanceof NewIntent) && (observer = ((NewIntent) intent).getObserver()) != null) {
            ThreadManagerV2.executeOnSubThread(new Runnable(observer, i3, z16, bundle) { // from class: com.tencent.mobileqq.reminder.biz.QQReminderServlet.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ BusinessObserver f280928d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f280929e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ boolean f280930f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ Bundle f280931h;

                {
                    this.f280928d = observer;
                    this.f280929e = i3;
                    this.f280930f = z16;
                    this.f280931h = bundle;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, QQReminderServlet.this, observer, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        this.f280928d.onReceive(this.f280929e, this.f280930f, this.f280931h);
                    }
                }
            });
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (QLog.isColorLevel()) {
            QLog.i(f280927d, 2, "cmd: " + serviceCmd + " ");
        }
        if (serviceCmd == null) {
            return;
        }
        if (serviceCmd.equals("NoticeSvr.GetMsgList")) {
            g(intent, fromServiceMsg);
            return;
        }
        if (serviceCmd.equals("NoticeSvr.DelMsg")) {
            d(intent, fromServiceMsg);
            return;
        }
        if (serviceCmd.equals("NoticeSvr.SubNotice")) {
            i(intent, fromServiceMsg);
            return;
        }
        if (serviceCmd.equals("NoticeSvr.PullMsg")) {
            f(intent, fromServiceMsg);
            return;
        }
        if (serviceCmd.equals("NoticeSvr.AckMsg")) {
            b(intent, fromServiceMsg);
            return;
        }
        if (serviceCmd.equals("NoticeSvr.GetMsg")) {
            e(intent, fromServiceMsg);
        } else if (serviceCmd.equals("NoticeSvr.Query")) {
            h(intent, fromServiceMsg);
        } else if (serviceCmd.equals("NoticeSvr.BatchSubNotice")) {
            c(intent, fromServiceMsg);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        switch (extras.getInt(QZoneCheckSendGiftServlet.PARAM_REQ_TYPE, 0)) {
            case 2000:
                o(extras, packet);
                return;
            case 2001:
                l(extras, packet);
                return;
            case 2002:
                q(extras, packet);
                return;
            case 2003:
                p(extras, packet);
                return;
            case 2004:
                j(extras, packet);
                return;
            case 2005:
                m(extras, packet);
                return;
            case 2006:
                n(extras, packet);
                return;
            case 2007:
                k(extras, packet);
                return;
            default:
                return;
        }
    }
}
