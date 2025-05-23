package fq2;

import PayMQQ.UniPayRequest;
import PayMQQ.UniPayResponse;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b extends BaseProtocolCoder {
    @Override // com.tencent.common.app.BaseProtocolCoder
    public String[] cmdHeaderPrefix() {
        return new String[]{"VipSTCheckServer"};
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public Object decode(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if (fromServiceMsg == null) {
            return null;
        }
        UniPacket uniPacket = new UniPacket(true);
        try {
            uniPacket.setEncodeName("utf-8");
            uniPacket.decode(fromServiceMsg.getWupBuffer());
            return (UniPayResponse) uniPacket.getByClass("stResponse", new UniPayResponse());
        } catch (RuntimeException | Exception unused) {
            return null;
        }
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public boolean encodeReqMsg(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        uniPacket.setServantName("MQQ.VipSTCheckServer.VipSTCheckObj");
        uniPacket.setFuncName("mobileUniPayCheck");
        uniPacket.put("stRequest", (UniPayRequest) toServiceMsg.extraData.getSerializable("UniPayRequest"));
        return true;
    }
}
