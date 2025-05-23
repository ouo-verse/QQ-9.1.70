package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ClientReq extends JceStruct {
    static ClientUinConfReq cache_stClientUinConfReq;
    static GetServerListReq cache_stGetServerListReq;
    static GetResourceReqV2 cache_stResourceReqV2;
    static SDKUpgradeReq cache_stSDKUpgradeReq;
    static SDKConfReq cache_stSdkConfReq;
    static ReqUserInfo cache_stUserInfo;
    public int iCmdType;
    public ClientUinConfReq stClientUinConfReq;
    public GetServerListReq stGetServerListReq;
    public GetResourceReqV2 stResourceReqV2;
    public SDKUpgradeReq stSDKUpgradeReq;
    public SDKConfReq stSdkConfReq;
    public ReqUserInfo stUserInfo;

    public ClientReq() {
        this.iCmdType = 0;
        this.stSDKUpgradeReq = null;
        this.stSdkConfReq = null;
        this.stGetServerListReq = null;
        this.stUserInfo = null;
        this.stResourceReqV2 = null;
        this.stClientUinConfReq = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iCmdType = jceInputStream.read(this.iCmdType, 1, true);
        if (cache_stSDKUpgradeReq == null) {
            cache_stSDKUpgradeReq = new SDKUpgradeReq();
        }
        this.stSDKUpgradeReq = (SDKUpgradeReq) jceInputStream.read((JceStruct) cache_stSDKUpgradeReq, 2, false);
        if (cache_stSdkConfReq == null) {
            cache_stSdkConfReq = new SDKConfReq();
        }
        this.stSdkConfReq = (SDKConfReq) jceInputStream.read((JceStruct) cache_stSdkConfReq, 3, false);
        if (cache_stGetServerListReq == null) {
            cache_stGetServerListReq = new GetServerListReq();
        }
        this.stGetServerListReq = (GetServerListReq) jceInputStream.read((JceStruct) cache_stGetServerListReq, 4, false);
        if (cache_stUserInfo == null) {
            cache_stUserInfo = new ReqUserInfo();
        }
        this.stUserInfo = (ReqUserInfo) jceInputStream.read((JceStruct) cache_stUserInfo, 5, false);
        if (cache_stResourceReqV2 == null) {
            cache_stResourceReqV2 = new GetResourceReqV2();
        }
        this.stResourceReqV2 = (GetResourceReqV2) jceInputStream.read((JceStruct) cache_stResourceReqV2, 6, false);
        if (cache_stClientUinConfReq == null) {
            cache_stClientUinConfReq = new ClientUinConfReq();
        }
        this.stClientUinConfReq = (ClientUinConfReq) jceInputStream.read((JceStruct) cache_stClientUinConfReq, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iCmdType, 1);
        SDKUpgradeReq sDKUpgradeReq = this.stSDKUpgradeReq;
        if (sDKUpgradeReq != null) {
            jceOutputStream.write((JceStruct) sDKUpgradeReq, 2);
        }
        SDKConfReq sDKConfReq = this.stSdkConfReq;
        if (sDKConfReq != null) {
            jceOutputStream.write((JceStruct) sDKConfReq, 3);
        }
        GetServerListReq getServerListReq = this.stGetServerListReq;
        if (getServerListReq != null) {
            jceOutputStream.write((JceStruct) getServerListReq, 4);
        }
        ReqUserInfo reqUserInfo = this.stUserInfo;
        if (reqUserInfo != null) {
            jceOutputStream.write((JceStruct) reqUserInfo, 5);
        }
        GetResourceReqV2 getResourceReqV2 = this.stResourceReqV2;
        if (getResourceReqV2 != null) {
            jceOutputStream.write((JceStruct) getResourceReqV2, 6);
        }
        ClientUinConfReq clientUinConfReq = this.stClientUinConfReq;
        if (clientUinConfReq != null) {
            jceOutputStream.write((JceStruct) clientUinConfReq, 7);
        }
    }

    public ClientReq(int i3, SDKUpgradeReq sDKUpgradeReq, SDKConfReq sDKConfReq, GetServerListReq getServerListReq, ReqUserInfo reqUserInfo, GetResourceReqV2 getResourceReqV2, ClientUinConfReq clientUinConfReq) {
        this.iCmdType = i3;
        this.stSDKUpgradeReq = sDKUpgradeReq;
        this.stSdkConfReq = sDKConfReq;
        this.stGetServerListReq = getServerListReq;
        this.stUserInfo = reqUserInfo;
        this.stResourceReqV2 = getResourceReqV2;
        this.stClientUinConfReq = clientUinConfReq;
    }
}
