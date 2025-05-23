package com.tencent.mobileqq.app;

import android.os.Handler;
import android.os.Looper;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.Timer;
import java.util.TimerTask;
import msf.msgsvc.msg_svc$PbSendMsgReq;
import tencent.im.msg.im_msg_head$InstCtrl;
import tencent.im.msg.im_msg_head$InstInfo;
import tencent.im.s2c.msgtype0x211.submsgtype0x9.C2CType0x211_SubC2CType0x9$MsgBody;

/* loaded from: classes11.dex */
public class PrinterStatusHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private boolean f194922d;

    /* renamed from: e, reason: collision with root package name */
    private Timer f194923e;

    /* renamed from: f, reason: collision with root package name */
    private int f194924f;

    /* renamed from: h, reason: collision with root package name */
    private QQAppInterface f194925h;

    /* renamed from: i, reason: collision with root package name */
    private bs f194926i;

    /* renamed from: m, reason: collision with root package name */
    private cq f194927m;

    /* loaded from: classes11.dex */
    class a extends bs {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PrinterStatusHandler.this);
            }
        }

        @Override // com.tencent.mobileqq.app.bs
        protected void onSelfPcOnlineStatusUpdateNotify(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                PrinterStatusHandler.this.J2();
            }
        }
    }

    /* loaded from: classes11.dex */
    class b extends cq {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PrinterStatusHandler.this);
            }
        }

        @Override // com.tencent.mobileqq.app.cq
        protected void c(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                PrinterStatusHandler.this.J2();
            }
        }
    }

    public PrinterStatusHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f194922d = false;
        this.f194923e = null;
        this.f194924f = 0;
        this.f194926i = new a();
        this.f194927m = new b();
        this.f194925h = qQAppInterface;
        qQAppInterface.addObserver(this.f194926i);
        this.f194925h.addObserver(this.f194927m);
        J2();
    }

    private ToServiceMsg L2(boolean z16, long j3, String str, int i3, int i16, int i17, byte[] bArr, long j16) {
        ToServiceMsg createToServiceMsg = createToServiceMsg(BaseConstants.CMD_MSG_PBSENDMSG);
        createToServiceMsg.extraData.putInt("SEND_MSG_CMD_MSG_TYPE", 1);
        createToServiceMsg.extraData.putInt("ROUNTING_TYPE", 13);
        createToServiceMsg.extraData.putBoolean("ISFROM_DATALINE", true);
        createToServiceMsg.extraData.putInt("DATALINE_CMD", i17);
        createToServiceMsg.addAttribute("cookie", Long.valueOf(j3));
        createToServiceMsg.addAttribute("sendFromNative", Boolean.valueOf(z16));
        createToServiceMsg.extraData.putInt("DATALINE_TRYINDEX", 0);
        long genMsgUid = FileManagerUtil.genMsgUid();
        long genMsgSeq = FileManagerUtil.genMsgSeq();
        com.tencent.mobileqq.service.message.ac acVar = new com.tencent.mobileqq.service.message.ac();
        acVar.f286177a = i16;
        acVar.f286178b = bArr;
        msg_svc$PbSendMsgReq a16 = com.tencent.mobileqq.service.message.p.a(this.f194925h, 13, str, acVar, genMsgSeq, com.tencent.mobileqq.service.message.s.g(genMsgUid));
        im_msg_head$InstInfo im_msg_head_instinfo = new im_msg_head$InstInfo();
        im_msg_head_instinfo.uint32_apppid.set(1);
        im_msg_head_instinfo.uint32_instid.set(0);
        im_msg_head_instinfo.enum_device_type.set(1);
        im_msg_head_instinfo.setHasFlag(true);
        a16.routing_head.trans_0x211.inst_ctrl.rpt_msg_send_to_inst.add(im_msg_head_instinfo);
        im_msg_head$InstInfo im_msg_head_instinfo2 = new im_msg_head$InstInfo();
        im_msg_head_instinfo2.uint32_apppid.set(1001);
        im_msg_head_instinfo2.uint32_instid.set(AppSetting.f());
        im_msg_head_instinfo2.enum_device_type.set(2);
        im_msg_head_instinfo2.setHasFlag(true);
        im_msg_head$InstCtrl im_msg_head_instctrl = a16.routing_head.trans_0x211.inst_ctrl;
        im_msg_head_instctrl.msg_from_inst = im_msg_head_instinfo2;
        im_msg_head_instctrl.setHasFlag(true);
        createToServiceMsg.putWupBuffer(a16.toByteArray());
        sendPbReq(createToServiceMsg);
        return createToServiceMsg;
    }

    public void G2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        RegisterProxySvcPackHandler registerProxySvcPackHandler = (RegisterProxySvcPackHandler) this.f194925h.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER);
        if (registerProxySvcPackHandler.P2() != 0 && registerProxySvcPackHandler.R2() == 1) {
            C2CType0x211_SubC2CType0x9$MsgBody c2CType0x211_SubC2CType0x9$MsgBody = new C2CType0x211_SubC2CType0x9$MsgBody();
            c2CType0x211_SubC2CType0x9$MsgBody.str_service.set("printer");
            c2CType0x211_SubC2CType0x9$MsgBody.uint32_CMD.set(5);
            this.f194924f++;
            K2(this.f194924f, this.f194925h.getCurrentAccountUin(), 529, 9, 1021, c2CType0x211_SubC2CType0x9$MsgBody.toByteArray(), 0L);
        }
    }

    public boolean H2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.f194922d;
    }

    public void I2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("dataline.Printer", 2, "received a cmd=" + fromServiceMsg.getServiceCmd());
        }
        if (toServiceMsg.extraData.getInt("ROUNTING_TYPE") == 13 && toServiceMsg.extraData.getBoolean("ISFROM_DATALINE") && fromServiceMsg.getResultCode() != 1000) {
            int i3 = toServiceMsg.extraData.getInt("DATALINE_TRYINDEX");
            if (QLog.isColorLevel()) {
                QLog.d("dataline.Printer", 2, "<PbSendMsg><R><---handle0x211C2CMessageError, retry = " + i3);
            }
            if (i3 < 3) {
                toServiceMsg.extraData.putInt("DATALINE_TRYINDEX", i3 + 1);
                sendPbReq(toServiceMsg);
            }
        }
    }

    public void J2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        RegisterProxySvcPackHandler registerProxySvcPackHandler = (RegisterProxySvcPackHandler) this.f194925h.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER);
        if (registerProxySvcPackHandler.P2() != 0 && registerProxySvcPackHandler.R2() == 1) {
            if (this.f194923e == null) {
                TimerTask timerTask = new TimerTask() { // from class: com.tencent.mobileqq.app.PrinterStatusHandler.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PrinterStatusHandler.this);
                        }
                    }

                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        ReportController.o(PrinterStatusHandler.this.f194925h, "CliOper", "", "", "0X8004023", "0X8004023", 0, 0, "", "", "", "");
                        if (PrinterStatusHandler.this.f194923e != null) {
                            PrinterStatusHandler.this.f194923e.cancel();
                            PrinterStatusHandler.this.f194923e = null;
                        }
                    }
                };
                BaseTimer baseTimer = new BaseTimer();
                this.f194923e = baseTimer;
                baseTimer.schedule(timerTask, 30000L);
                C2CType0x211_SubC2CType0x9$MsgBody c2CType0x211_SubC2CType0x9$MsgBody = new C2CType0x211_SubC2CType0x9$MsgBody();
                c2CType0x211_SubC2CType0x9$MsgBody.str_service.set("printer");
                c2CType0x211_SubC2CType0x9$MsgBody.uint32_CMD.set(1);
                this.f194924f++;
                K2(this.f194924f, this.f194925h.getCurrentAccountUin(), 529, 9, 1021, c2CType0x211_SubC2CType0x9$MsgBody.toByteArray(), 0L);
                return;
            }
            return;
        }
        this.f194922d = false;
        notifyUI(12, false, null);
    }

    public ToServiceMsg K2(long j3, String str, int i3, int i16, int i17, byte[] bArr, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), bArr, Long.valueOf(j16));
        }
        return L2(true, j3, str, i3, i16, i17, bArr, j16);
    }

    public void M2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        Timer timer = this.f194923e;
        if (timer != null) {
            timer.cancel();
            this.f194923e = null;
        }
        this.f194922d = z16;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Class) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return k.class;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        bs bsVar = this.f194926i;
        if (bsVar != null) {
            this.f194925h.removeObserver(bsVar);
            this.f194926i = null;
        }
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (!BaseConstants.CMD_MSG_PBSENDMSG.equals(fromServiceMsg.getServiceCmd())) {
            if (QLog.isColorLevel()) {
                QLog.d("dataline.Printer", 2, "cmdfilter error=" + fromServiceMsg.getServiceCmd());
                return;
            }
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable(toServiceMsg, fromServiceMsg, obj) { // from class: com.tencent.mobileqq.app.PrinterStatusHandler.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ ToServiceMsg f194928d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ FromServiceMsg f194929e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ Object f194930f;

                {
                    this.f194928d = toServiceMsg;
                    this.f194929e = fromServiceMsg;
                    this.f194930f = obj;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, PrinterStatusHandler.this, toServiceMsg, fromServiceMsg, obj);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        PrinterStatusHandler.this.I2(this.f194928d, this.f194929e, this.f194930f);
                    }
                }
            });
        } else {
            I2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
