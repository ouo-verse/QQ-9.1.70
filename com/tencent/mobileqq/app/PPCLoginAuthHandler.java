package com.tencent.mobileqq.app;

import android.os.Build;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pb.ppcloginauth.PPCLoginAuth$comering_req;
import com.tencent.pb.ppcloginauth.PPCLoginAuth$plat_info;
import com.tencent.pb.ppcloginauth.PPCLoginAuth$req;
import com.tencent.pb.ppcloginauth.PPCLoginAuth$rsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes11.dex */
public class PPCLoginAuthHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected QQAppInterface f194888d;

    /* renamed from: e, reason: collision with root package name */
    private long f194889e;

    protected PPCLoginAuthHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f194889e = 0L;
            this.f194888d = qQAppInterface;
        }
    }

    protected void D2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            PPCLoginAuth$rsp pPCLoginAuth$rsp = new PPCLoginAuth$rsp();
            try {
                pPCLoginAuth$rsp.mergeFrom((byte[]) obj);
                if (pPCLoginAuth$rsp.ret.get() == 0 && pPCLoginAuth$rsp.rspcmd_0x01.get().ret.get() != 0) {
                    this.f194888d.execute(new Runnable() { // from class: com.tencent.mobileqq.app.PPCLoginAuthHandler.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PPCLoginAuthHandler.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            QQAppInterface qQAppInterface = PPCLoginAuthHandler.this.f194888d;
                            EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory(qQAppInterface.getCurrentAccountUin()).createEntityManager();
                            ExtensionInfo extensionInfo = (ExtensionInfo) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) ExtensionInfo.class, PPCLoginAuthHandler.this.f194888d.getAccount());
                            if (extensionInfo != null) {
                                extensionInfo.commingRingId = 0L;
                                createEntityManager.update(extensionInfo);
                            } else {
                                ExtensionInfo extensionInfo2 = new ExtensionInfo();
                                extensionInfo2.uin = PPCLoginAuthHandler.this.f194888d.getAccount();
                                createEntityManager.persist(extensionInfo2);
                            }
                            createEntityManager.close();
                        }
                    });
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public void E2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QQAppInterface qQAppInterface = this.f194888d;
        EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory(qQAppInterface.getCurrentAccountUin()).createEntityManager();
        ExtensionInfo extensionInfo = (ExtensionInfo) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) ExtensionInfo.class, this.f194888d.getAccount());
        createEntityManager.close();
        if (extensionInfo != null) {
            long j3 = extensionInfo.commingRingId;
            if (j3 != 0) {
                this.f194889e = j3;
                F2();
            }
        }
    }

    public void F2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        String currentAccountUin = this.f194888d.getCurrentAccountUin();
        PPCLoginAuth$plat_info pPCLoginAuth$plat_info = new PPCLoginAuth$plat_info();
        pPCLoginAuth$plat_info.implat.set(109L);
        pPCLoginAuth$plat_info.mqqver.set(AppSetting.f99554n);
        pPCLoginAuth$plat_info.osver.set(Build.VERSION.RELEASE);
        PPCLoginAuth$comering_req pPCLoginAuth$comering_req = new PPCLoginAuth$comering_req();
        pPCLoginAuth$comering_req.f342169id.set(String.valueOf(this.f194889e));
        PPCLoginAuth$req pPCLoginAuth$req = new PPCLoginAuth$req();
        pPCLoginAuth$req.comm.set(pPCLoginAuth$plat_info);
        pPCLoginAuth$req.reqcmd_0x01.set(pPCLoginAuth$comering_req);
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", currentAccountUin, "Loginauth.1");
        toServiceMsg.putWupBuffer(pPCLoginAuth$req.toByteArray());
        sendPbReq(toServiceMsg);
        if (QLog.isColorLevel()) {
            QLog.i("PPCLoginAuthHandler", 2, "sendPbReq called. req=" + pPCLoginAuth$req.toString());
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
        } else if ("Loginauth.1".equals(fromServiceMsg.getServiceCmd())) {
            if (QLog.isColorLevel()) {
                QLog.i("PPCLoginAuthHandler", 2, "onReceive called.");
            }
            D2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
