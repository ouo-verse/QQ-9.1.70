package com.qwallet.activity.sso;

import Wallet.GetPasswordReq;
import Wallet.GetPasswordRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import mqq.app.Packet;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c extends QWalletBaseProtocol {
    @Override // com.qwallet.activity.sso.QWalletBaseProtocol
    public String b() {
        return null;
    }

    @Override // com.qwallet.activity.sso.QWalletBaseProtocol
    public String d() {
        return "WalletGestureSvc.GetPassword";
    }

    @Override // com.qwallet.activity.sso.QWalletBaseProtocol
    public int f() {
        return 3;
    }

    @Override // com.qwallet.activity.sso.QWalletBaseProtocol
    public HashMap<String, Object> g(Object... objArr) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("req", objArr[0]);
        return hashMap;
    }

    @Override // com.qwallet.activity.sso.QWalletBaseProtocol
    public Class<?> h() {
        return GetPasswordRsp.class;
    }

    @Override // com.qwallet.activity.sso.QWalletBaseProtocol
    public int i() {
        return 3;
    }

    @Override // com.qwallet.activity.sso.QWalletBaseProtocol
    public void j(ToServiceMsg toServiceMsg, Packet packet) {
        GetPasswordReq getPasswordReq = (GetPasswordReq) toServiceMsg.getAttribute("req");
        packet.setServantName("Wallet.GesturePasswordServer.GesturePasswordObj");
        packet.setFuncName("GetPassword");
        packet.addRequestPacket("req", getPasswordReq);
    }

    @Override // com.qwallet.activity.sso.QWalletBaseProtocol
    public Object l(FromServiceMsg fromServiceMsg) {
        if (fromServiceMsg == null) {
            return null;
        }
        return (GetPasswordRsp) Packet.decodePacket(fromServiceMsg.getWupBuffer(), "rsp", new GetPasswordRsp());
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
