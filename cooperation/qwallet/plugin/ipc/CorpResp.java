package cooperation.qwallet.plugin.ipc;

import android.os.Bundle;

/* compiled from: P */
/* loaded from: classes28.dex */
public class CorpResp extends BaseResp {
    public int callForwardRet;
    public int corpReqType;
    public Bundle encryptionData;
    public String faceFilePath;
    public boolean isFriend;
    public String memNick;
    public String memUin;
    public String troopMemNickJson;
    public String troopUin;
    public String userNick;

    @Override // cooperation.qwallet.plugin.ipc.BaseIpc
    public void fromBundle(Bundle bundle) {
        super.fromBundle(bundle);
        this.corpReqType = bundle.getInt("_qwallet_ipc_CorpResp_corpReqType");
        this.faceFilePath = bundle.getString("_qwallet_ipc_CorpReq_faceFilePath");
        this.isFriend = bundle.getBoolean("_qwallet_ipc_CorpReq_isFriend");
        this.userNick = bundle.getString("_qwallet_ipc_CorpReq_userNick");
        this.troopUin = bundle.getString("_qwallet_ipc_CorpReq_troopUin");
        this.memUin = bundle.getString("_qwallet_ipc_CorpReq_memUin");
        this.memNick = bundle.getString("_qwallet_ipc_CorpReq_memNick");
        this.troopMemNickJson = bundle.getString("_qwallet_ipc_CorpReq_troopMemNickJson");
        this.encryptionData = bundle.getBundle("_qwallet_ipc_CorpReq_encryptionData");
    }

    @Override // cooperation.qwallet.plugin.ipc.BaseIpc
    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putInt("_qwallet_ipc_CorpResp_corpReqType", this.corpReqType);
        bundle.putString("_qwallet_ipc_CorpReq_faceFilePath", this.faceFilePath);
        bundle.putBoolean("_qwallet_ipc_CorpReq_isFriend", this.isFriend);
        bundle.putString("_qwallet_ipc_CorpReq_userNick", this.userNick);
        bundle.putString("_qwallet_ipc_CorpReq_troopUin", this.troopUin);
        bundle.putString("_qwallet_ipc_CorpReq_memUin", this.memUin);
        bundle.putString("_qwallet_ipc_CorpReq_memNick", this.memNick);
        bundle.putString("_qwallet_ipc_CorpReq_troopMemNickJson", this.troopMemNickJson);
        bundle.putBundle("_qwallet_ipc_CorpReq_encryptionData", this.encryptionData);
    }
}
