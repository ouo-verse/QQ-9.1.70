package com.qwallet.activity.sso;

import com.qwallet.protocol.Wallet.OpenPay.ReqGetPuinInfo;
import com.qwallet.protocol.Wallet.OpenPay.RespGetPuinInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import mqq.app.Packet;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends QWalletBaseProtocol {
    @Override // com.qwallet.activity.sso.QWalletBaseProtocol
    public String b() {
        return null;
    }

    @Override // com.qwallet.activity.sso.QWalletBaseProtocol
    public String d() {
        return "OpenPayServer.getPuinInfoV2";
    }

    @Override // com.qwallet.activity.sso.QWalletBaseProtocol
    public int f() {
        return 4;
    }

    @Override // com.qwallet.activity.sso.QWalletBaseProtocol
    public HashMap<String, Object> g(Object... objArr) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("req", objArr[0]);
        return hashMap;
    }

    @Override // com.qwallet.activity.sso.QWalletBaseProtocol
    public Class<?> h() {
        return RespGetPuinInfo.class;
    }

    @Override // com.qwallet.activity.sso.QWalletBaseProtocol
    public int i() {
        return 4;
    }

    @Override // com.qwallet.activity.sso.QWalletBaseProtocol
    public void j(ToServiceMsg toServiceMsg, Packet packet) {
        ReqGetPuinInfo reqGetPuinInfo = (ReqGetPuinInfo) toServiceMsg.getAttribute("req");
        packet.setServantName("MQQ.OpenPayServer.OpenPayObj");
        packet.setFuncName("getPuinInfoV2");
        packet.addRequestPacket("req", reqGetPuinInfo);
    }

    @Override // com.qwallet.activity.sso.QWalletBaseProtocol
    public Object l(FromServiceMsg fromServiceMsg) {
        if (fromServiceMsg == null) {
            return null;
        }
        return (RespGetPuinInfo) Packet.decodePacket(fromServiceMsg.getWupBuffer(), "resp", new RespGetPuinInfo());
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
