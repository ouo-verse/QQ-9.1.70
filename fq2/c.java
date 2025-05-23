package fq2;

import VipRecommend.MQQ.CommPayInfo;
import VipRecommend.MQQ.UserInfo;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c extends BaseProtocolCoder {
    @Override // com.tencent.common.app.BaseProtocolCoder
    public String[] cmdHeaderPrefix() {
        return new String[]{"VipPayLogicServer"};
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public Object decode(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if (!"VipPayLogicServer.getCommPayInfo ".equals(toServiceMsg.getServiceCmd()) || fromServiceMsg == null) {
            return null;
        }
        UniPacket uniPacket = new UniPacket(true);
        try {
            uniPacket.setEncodeName("utf-8");
            uniPacket.decode(fromServiceMsg.getWupBuffer());
            return (CommPayInfo) uniPacket.getByClass("payInfo", new CommPayInfo());
        } catch (RuntimeException e16) {
            e16.printStackTrace();
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public boolean encodeReqMsg(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        uniPacket.setServantName("MQQ.VipPayLogicServer.VipPayLogicObj");
        uniPacket.setFuncName("getCommPayInfo");
        uniPacket.put(ITVKPlayerEventListener.KEY_USER_INFO, (UserInfo) toServiceMsg.extraData.getSerializable("VIPRecommendPayRequest"));
        return true;
    }
}
