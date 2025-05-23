package com.tencent.mobileqq.app;

import QQWalletPay.ReqCheckChangePwdAuth;
import Wallet.AuthCodeReq;
import Wallet.GetPasswordReq;
import Wallet.GetPasswordRsp;
import Wallet.PfaFriendRqt;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.PatternLockUtils;
import cooperation.qwallet.plugin.impl.QWalletHelperDelegate;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QWalletAuthHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private boolean f194975d;

    /* renamed from: e, reason: collision with root package name */
    private QQAppInterface f194976e;

    protected QWalletAuthHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f194975d = false;
            this.f194976e = qQAppInterface;
        }
    }

    public void D2(ReqCheckChangePwdAuth reqCheckChangePwdAuth) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) reqCheckChangePwdAuth);
            return;
        }
        if (reqCheckChangePwdAuth == null) {
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f194976e.getCurrentAccountUin(), "QQWalletPayAuthServer.checkChangePwdAuth");
        toServiceMsg.extraData.putSerializable("ReqCheckChangePwdAuth", reqCheckChangePwdAuth);
        super.send(toServiceMsg);
        if (QLog.isColorLevel()) {
            QLog.d("Q.qwallet.auth.AuthHandler", 2, "sendCheckModifyPassReq: on send--cmd=QQWalletPayAuthServer.checkChangePwdAuth");
        }
    }

    public void E2(AuthCodeReq authCodeReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) authCodeReq);
            return;
        }
        if (authCodeReq == null) {
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f194976e.getCurrentAccountUin(), "VacThirdCodeSvc.fetchCodes");
        toServiceMsg.extraData.putSerializable("AuthCodeReq", authCodeReq);
        super.send(toServiceMsg);
        if (QLog.isColorLevel()) {
            QLog.d("Q.qwallet.auth.AuthHandler", 2, "sendGetAuthCode: on send--cmd=VacThirdCodeSvc.fetchCodes");
        }
    }

    public void F2(PfaFriendRqt pfaFriendRqt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) pfaFriendRqt);
            return;
        }
        if (pfaFriendRqt == null) {
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f194976e.getCurrentAccountUin(), "QWalletPfa.RecFriend");
        toServiceMsg.extraData.putSerializable("PfaFriendRqt", pfaFriendRqt);
        super.send(toServiceMsg);
        if (QLog.isColorLevel()) {
            QLog.d("Q.qwallet.auth.AuthHandler", 2, "sendGetRecentList: on send--cmd=QWalletPfa.RecFriend");
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Class) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return cl.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        GetPasswordRsp getPasswordRsp;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (toServiceMsg != null && fromServiceMsg != null) {
            boolean isSuccess = fromServiceMsg.isSuccess();
            String serviceCmd = toServiceMsg.getServiceCmd();
            if (TextUtils.isEmpty(serviceCmd)) {
                return;
            }
            if (serviceCmd.compareTo("QQWalletPayAuthServer.checkChangePwdAuth") == 0) {
                super.notifyUI(1, isSuccess, obj);
                return;
            }
            if (serviceCmd.compareTo("WalletGestureSvc.GetPassword") == 0) {
                if (obj != null && (obj instanceof GetPasswordRsp)) {
                    getPasswordRsp = (GetPasswordRsp) obj;
                } else {
                    getPasswordRsp = null;
                }
                if (isSuccess && getPasswordRsp != null && getPasswordRsp.ret == 0) {
                    PatternLockUtils.setSyncPatternLockState(this.f194976e.getApp(), this.f194976e.getCurrentAccountUin(), false);
                    if (!TextUtils.isEmpty(getPasswordRsp.password)) {
                        str = MD5.toMD5(QWalletHelperDelegate.getQWDevId() + getPasswordRsp.password);
                    } else {
                        str = "";
                    }
                    PatternLockUtils.setPWD(this.f194976e.getApp(), this.f194976e.getCurrentAccountUin(), str);
                    PatternLockUtils.setPWDType(this.f194976e.getApp(), this.f194976e.getCurrentAccountUin(), getPasswordRsp.passwordType);
                    PatternLockUtils.setCheckIntervalTime(this.f194976e.getApp(), this.f194976e.getCurrentAccountUin(), getPasswordRsp.checkInterval);
                    PatternLockUtils.setForgroundIntervalTime(this.f194976e.getApp(), this.f194976e.getCurrentAccountUin(), getPasswordRsp.passInterval);
                } else if (this.f194975d && NetworkUtil.isNetSupport(this.f194976e.getApp())) {
                    this.f194975d = false;
                    GetPasswordReq getPasswordReq = new GetPasswordReq();
                    getPasswordReq.MQOS = "Android";
                    getPasswordReq.MQVersion = com.tencent.mobileqq.utils.ah.Q(this.f194976e.getApp());
                    ToServiceMsg toServiceMsg2 = new ToServiceMsg("mobileqq.service", this.f194976e.getCurrentAccountUin(), "WalletGestureSvc.GetPassword");
                    toServiceMsg2.extraData.putSerializable("GetPasswordReq", getPasswordReq);
                    super.send(toServiceMsg2);
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.qwallet.auth.AuthHandler", 2, "RetrySendGetPasswordReq: on send--cmd=WalletGestureSvc.GetPassword");
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("Q.qwallet.auth.AuthHandler", 2, "sendGetPasswordReq: onReceive isSuccess:" + isSuccess);
                    return;
                }
                return;
            }
            if (serviceCmd.compareTo("VacThirdCodeSvc.fetchCodes") == 0) {
                super.notifyUI(4, isSuccess, obj);
            } else if (serviceCmd.compareTo("QWalletPfa.RecFriend") == 0) {
                super.notifyUI(5, isSuccess, obj);
            }
        }
    }
}
