package com.qwallet.activity.sso;

import com.qwallet.protocol.Wallet.PatternLock.SetPasswordReq;
import com.qwallet.protocol.Wallet.PatternLock.SetPasswordRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import mqq.app.Packet;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d extends QWalletBaseProtocol {
    @Override // com.qwallet.activity.sso.QWalletBaseProtocol
    public String b() {
        return null;
    }

    @Override // com.qwallet.activity.sso.QWalletBaseProtocol
    public String d() {
        return "WalletGestureSvc.SetPassword";
    }

    @Override // com.qwallet.activity.sso.QWalletBaseProtocol
    public int f() {
        return 2;
    }

    @Override // com.qwallet.activity.sso.QWalletBaseProtocol
    public HashMap<String, Object> g(Object... objArr) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("req", objArr[0]);
        return hashMap;
    }

    @Override // com.qwallet.activity.sso.QWalletBaseProtocol
    public Class<?> h() {
        return SetPasswordRsp.class;
    }

    @Override // com.qwallet.activity.sso.QWalletBaseProtocol
    public int i() {
        return 2;
    }

    @Override // com.qwallet.activity.sso.QWalletBaseProtocol
    public void j(ToServiceMsg toServiceMsg, Packet packet) {
        SetPasswordReq setPasswordReq = (SetPasswordReq) toServiceMsg.getAttribute("req");
        packet.setServantName("Wallet.GesturePasswordServer.GesturePasswordObj");
        packet.setFuncName("SetPassword");
        packet.addRequestPacket("req", setPasswordReq);
    }

    @Override // com.qwallet.activity.sso.QWalletBaseProtocol
    public Object l(FromServiceMsg fromServiceMsg) {
        if (fromServiceMsg == null) {
            return null;
        }
        return (SetPasswordRsp) Packet.decodePacket(fromServiceMsg.getWupBuffer(), "rsp", new SetPasswordRsp());
    }

    @Override // com.qwallet.activity.sso.QWalletBaseProtocol
    public boolean m() {
        return false;
    }

    @Override // com.qwallet.activity.sso.QWalletBaseProtocol
    public Object r(JSONObject jSONObject) throws Exception {
        return null;
    }
}
