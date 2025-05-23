package com.qwallet.activity.sso;

import Wallet.GetSignV2Req;
import Wallet.GetSignV2Rsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import mqq.app.Packet;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b extends QWalletBaseProtocol {
    @Override // com.qwallet.activity.sso.QWalletBaseProtocol
    public String b() {
        return null;
    }

    @Override // com.qwallet.activity.sso.QWalletBaseProtocol
    public String d() {
        return "WalletGestureSvc.GetSignV2";
    }

    @Override // com.qwallet.activity.sso.QWalletBaseProtocol
    public int f() {
        return 5;
    }

    @Override // com.qwallet.activity.sso.QWalletBaseProtocol
    public HashMap<String, Object> g(Object... objArr) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("req", objArr[0]);
        return hashMap;
    }

    @Override // com.qwallet.activity.sso.QWalletBaseProtocol
    public Class<?> h() {
        return GetSignV2Rsp.class;
    }

    @Override // com.qwallet.activity.sso.QWalletBaseProtocol
    public int i() {
        return 5;
    }

    @Override // com.qwallet.activity.sso.QWalletBaseProtocol
    public void j(ToServiceMsg toServiceMsg, Packet packet) {
        GetSignV2Req getSignV2Req = (GetSignV2Req) toServiceMsg.getAttribute("req");
        packet.setServantName("Wallet.GesturePasswordServer.GesturePasswordObj");
        packet.setFuncName("GetSignV2");
        packet.addRequestPacket("req", getSignV2Req);
    }

    @Override // com.qwallet.activity.sso.QWalletBaseProtocol
    public Object l(FromServiceMsg fromServiceMsg) {
        if (fromServiceMsg == null) {
            return null;
        }
        return (GetSignV2Rsp) Packet.decodePacket(fromServiceMsg.getWupBuffer(), "rsp", new GetSignV2Rsp());
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
