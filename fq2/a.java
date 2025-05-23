package fq2;

import QQWalletPay.ReqCheckChangePwdAuth;
import QQWalletPay.RespCheckChangePwdAuth;
import Wallet.AuthCodeReq;
import Wallet.AuthCodeRsp;
import Wallet.GetPasswordReq;
import Wallet.GetPasswordRsp;
import Wallet.PfaFriendRqt;
import Wallet.PfaFriendRsp;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends BaseProtocolCoder {

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f400323d = {"QQWalletPayAuthServer", "AdvRuleSvrCmd", "WalletGestureSvc", "VacThirdCodeSvc", "QWalletPfa"};

    private Object a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if (fromServiceMsg == null) {
            return null;
        }
        UniPacket uniPacket = new UniPacket(true);
        try {
            uniPacket.setEncodeName("utf-8");
            uniPacket.decode(fromServiceMsg.getWupBuffer());
            return (AuthCodeRsp) uniPacket.getByClass("rsp", new AuthCodeRsp());
        } catch (RuntimeException e16) {
            if (QLog.isDevelopLevel()) {
                QLog.d("Q.qwallet.auth.AuthService", 4, "decodeGetAuthCode error:" + e16.getMessage());
            }
            return null;
        } catch (Exception e17) {
            if (QLog.isDevelopLevel()) {
                QLog.d("Q.qwallet.auth.AuthService", 4, "decodeGetAuthCode error:" + e17.getMessage());
            }
            return null;
        }
    }

    private Object b(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if (fromServiceMsg == null) {
            return null;
        }
        UniPacket uniPacket = new UniPacket(true);
        try {
            uniPacket.setEncodeName("utf-8");
            uniPacket.decode(fromServiceMsg.getWupBuffer());
            return (GetPasswordRsp) uniPacket.getByClass("rsp", new GetPasswordRsp());
        } catch (RuntimeException e16) {
            if (QLog.isDevelopLevel()) {
                QLog.d("Q.qwallet.auth.AuthService", 4, "decodeGetPasswordWUP error:" + e16.getMessage());
            }
            return null;
        } catch (Exception e17) {
            if (QLog.isDevelopLevel()) {
                QLog.d("Q.qwallet.auth.AuthService", 4, "decodeGetPasswordWUP error:" + e17.getMessage());
            }
            return null;
        }
    }

    private Object c(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if (fromServiceMsg == null) {
            return null;
        }
        UniPacket uniPacket = new UniPacket(true);
        try {
            uniPacket.setEncodeName("utf-8");
            uniPacket.decode(fromServiceMsg.getWupBuffer());
            return (PfaFriendRsp) uniPacket.getByClass("rsp", new PfaFriendRsp());
        } catch (RuntimeException e16) {
            if (QLog.isDevelopLevel()) {
                QLog.d("Q.qwallet.auth.AuthService", 4, "decodeGetRecentList error:" + e16.getMessage());
            }
            return null;
        } catch (Exception e17) {
            if (QLog.isDevelopLevel()) {
                QLog.d("Q.qwallet.auth.AuthService", 4, "decodeGetRecentList error:" + e17.getMessage());
            }
            return null;
        }
    }

    private Object d(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if (fromServiceMsg == null) {
            return null;
        }
        UniPacket uniPacket = new UniPacket(true);
        try {
            uniPacket.setEncodeName("utf-8");
            uniPacket.decode(fromServiceMsg.getWupBuffer());
            return (RespCheckChangePwdAuth) uniPacket.getByClass("resp", new RespCheckChangePwdAuth());
        } catch (RuntimeException e16) {
            if (QLog.isDevelopLevel()) {
                QLog.d("Q.qwallet.auth.AuthService", 4, "decodeModifyPassAuthWUP error:" + e16.getMessage());
            }
            return null;
        } catch (Exception e17) {
            if (QLog.isDevelopLevel()) {
                QLog.d("Q.qwallet.auth.AuthService", 4, "decodeModifyPassAuthWUP error:" + e17.getMessage());
            }
            return null;
        }
    }

    private boolean e(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        uniPacket.setServantName("VAC.AuthCodeCoroServer.AuthCodeCoroObj");
        uniPacket.setFuncName("fetchCodes");
        uniPacket.put("req", (AuthCodeReq) toServiceMsg.extraData.getSerializable("AuthCodeReq"));
        return true;
    }

    private boolean f(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        uniPacket.setServantName("Wallet.GesturePasswordServer.GesturePasswordObj");
        uniPacket.setFuncName("GetPassword");
        uniPacket.put("req", (GetPasswordReq) toServiceMsg.extraData.getSerializable("GetPasswordReq"));
        return true;
    }

    private boolean g(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        uniPacket.setServantName("Wallet.WalletFriendQueryServer.WalletFriendObj");
        uniPacket.setFuncName("QueryRecommendFriend");
        uniPacket.put("rqt", (PfaFriendRqt) toServiceMsg.extraData.getSerializable("PfaFriendRqt"));
        return true;
    }

    private boolean h(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        uniPacket.setServantName("MQQ.OpenPayServer.QQWalletPayAuthObj");
        uniPacket.setFuncName("checkChangePwdAuth");
        uniPacket.put("req", (ReqCheckChangePwdAuth) toServiceMsg.extraData.getSerializable("ReqCheckChangePwdAuth"));
        return true;
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public String[] cmdHeaderPrefix() {
        return f400323d;
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public Object decode(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        String serviceCmd = toServiceMsg.getServiceCmd();
        if (TextUtils.isEmpty(serviceCmd)) {
            return null;
        }
        if (serviceCmd.compareTo("QQWalletPayAuthServer.checkChangePwdAuth") == 0) {
            return d(toServiceMsg, fromServiceMsg);
        }
        if (serviceCmd.compareTo("WalletGestureSvc.GetPassword") == 0) {
            return b(toServiceMsg, fromServiceMsg);
        }
        if (serviceCmd.compareTo("VacThirdCodeSvc.fetchCodes") == 0) {
            return a(toServiceMsg, fromServiceMsg);
        }
        if (serviceCmd.compareTo("QWalletPfa.RecFriend") != 0) {
            return null;
        }
        return c(toServiceMsg, fromServiceMsg);
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public boolean encodeReqMsg(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        String serviceCmd = toServiceMsg.getServiceCmd();
        if (TextUtils.isEmpty(serviceCmd)) {
            return false;
        }
        if (serviceCmd.compareTo("QQWalletPayAuthServer.checkChangePwdAuth") == 0) {
            return h(toServiceMsg, uniPacket);
        }
        if (serviceCmd.compareTo("WalletGestureSvc.GetPassword") == 0) {
            return f(toServiceMsg, uniPacket);
        }
        if (serviceCmd.compareTo("VacThirdCodeSvc.fetchCodes") == 0) {
            return e(toServiceMsg, uniPacket);
        }
        if (serviceCmd.compareTo("QWalletPfa.RecFriend") != 0) {
            return false;
        }
        return g(toServiceMsg, uniPacket);
    }
}
