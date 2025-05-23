package cooperation.qwallet.plugin.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qwallet.plugin.ICorpReq;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes28.dex */
public class CorpReq extends BaseReq {
    public static final int CORPREQ_TYPE_AVATAR = 12;
    public static final int CORPREQ_TYPE_DELETEOB = 6;
    public static final int CORPREQ_TYPE_FACEFILEPATH = 1;
    public static final int CORPREQ_TYPE_GET_ENCRYPTION = 8;
    public static final int CORPREQ_TYPE_INVOKE_FORWARD = 9;
    public static final int CORPREQ_TYPE_INVOKE_SENDHB = 13;
    public static final int CORPREQ_TYPE_ISFRIEND = 2;
    public static final int CORPREQ_TYPE_OPEN_AIO = 10;
    public static final int CORPREQ_TYPE_PUT_ENCRYPTION = 7;
    public static final int CORPREQ_TYPE_TENWATCH = 4;
    public static final int CORPREQ_TYPE_TROOP_NICKNAME = 11;
    public static int corpReqType;
    public static Bundle encryptionData;
    public int channel;
    public Bundle data;
    public int faceType;
    public String groupId;
    private ICorpReq mICorpReq = (ICorpReq) QRoute.api(ICorpReq.class);
    public String memUin;
    public ArrayList<String> memUinArrayList;
    public int subType;
    public String troopUin;
    public String uin;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface ICallBack {
        void callBack(Bundle bundle);
    }

    @Override // cooperation.qwallet.plugin.ipc.BaseReq, cooperation.qwallet.plugin.ipc.BaseIpc
    public void fromBundle(Bundle bundle) {
        super.fromBundle(bundle);
        corpReqType = bundle.getInt("_qwallet_ipc_CorpReq_corpReqType");
        this.faceType = bundle.getInt("_qwallet_ipc_CorpReq_faceType");
        this.uin = bundle.getString("_qwallet_ipc_CorpReq_uin");
        this.subType = bundle.getInt("_qwallet_ipc_CorpReq_subType");
        this.groupId = bundle.getString("_qwallet_ipc_CorpReq_groupId");
        this.channel = bundle.getInt("_qwallet_ipc_CorpReq_channel");
        this.troopUin = bundle.getString("_qwallet_ipc_CorpReq_troopUin");
        this.memUin = bundle.getString("_qwallet_ipc_CorpReq_memUin");
        this.memUinArrayList = bundle.getStringArrayList("_qwallet_ipc_CorpReq_memUinArrayList");
        this.data = bundle.getBundle("_qwallet_ipc_CorpReq_data");
        if (corpReqType == 7) {
            encryptionData = bundle.getBundle("_qwallet_ipc_CorpReq_encryptionData");
        }
    }

    @Override // cooperation.qwallet.plugin.ipc.BaseReq
    public void onReceive() {
        int i3 = corpReqType;
        if (i3 == 4) {
            this.mICorpReq.onTenWatch(this.data);
            return;
        }
        if (i3 == 8) {
            doCallback(this.mICorpReq.onGetEncryption());
            return;
        }
        if (i3 == 8) {
            doCallback(this.mICorpReq.onGetEncryption());
            return;
        }
        if (i3 == 9) {
            Bundle callForwardPage = this.mICorpReq.callForwardPage(this.data, this.fromReceiver);
            if (callForwardPage != null) {
                doCallback(callForwardPage);
                return;
            }
            return;
        }
        if (i3 == 10) {
            this.mICorpReq.openAio(this.data);
            return;
        }
        if (i3 == 11) {
            doCallback(this.mICorpReq.getGroupNickname(this.data));
            return;
        }
        if (i3 == 12) {
            Bundle avatar = this.mICorpReq.getAvatar(this.data, new ICallBack() { // from class: cooperation.qwallet.plugin.ipc.CorpReq.1
                @Override // cooperation.qwallet.plugin.ipc.CorpReq.ICallBack
                public void callBack(Bundle bundle) {
                    CorpReq.this.doCallback(bundle);
                }
            });
            if (avatar != null) {
                doCallback(avatar);
                return;
            }
            return;
        }
        if (i3 == 13) {
            doCallback(this.mICorpReq.callSendHbPage(this.data, this.fromReceiver));
        } else {
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: cooperation.qwallet.plugin.ipc.CorpReq.2
                @Override // java.lang.Runnable
                public void run() {
                    int i16 = CorpReq.corpReqType;
                    if (i16 != 1) {
                        if (i16 != 2) {
                            if (i16 == 6) {
                                CorpReq.this.mICorpReq.deleteUserNickOB();
                                return;
                            }
                            return;
                        } else {
                            CorpReq corpReq = CorpReq.this;
                            corpReq.doCallback(corpReq.mICorpReq.onIsFriend(CorpReq.this.uin));
                            return;
                        }
                    }
                    CorpReq corpReq2 = CorpReq.this;
                    ICorpReq iCorpReq = corpReq2.mICorpReq;
                    CorpReq corpReq3 = CorpReq.this;
                    corpReq2.doCallback(iCorpReq.onGetFaceFilePath(corpReq3.faceType, corpReq3.uin, corpReq3.subType));
                }
            });
        }
    }

    @Override // cooperation.qwallet.plugin.ipc.BaseReq, cooperation.qwallet.plugin.ipc.BaseIpc
    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putInt("_qwallet_ipc_CorpReq_corpReqType", corpReqType);
        bundle.putInt("_qwallet_ipc_CorpReq_faceType", this.faceType);
        bundle.putString("_qwallet_ipc_CorpReq_uin", this.uin);
        bundle.putInt("_qwallet_ipc_CorpReq_subType", this.subType);
        bundle.putString("_qwallet_ipc_CorpReq_groupId", this.groupId);
        bundle.putInt("_qwallet_ipc_CorpReq_channel", this.channel);
        bundle.putString("_qwallet_ipc_CorpReq_troopUin", this.troopUin);
        bundle.putString("_qwallet_ipc_CorpReq_memUin", this.memUin);
        bundle.putStringArrayList("_qwallet_ipc_CorpReq_memUinArrayList", this.memUinArrayList);
        bundle.putBundle("_qwallet_ipc_CorpReq_data", this.data);
        bundle.putBundle("_qwallet_ipc_CorpReq_encryptionData", encryptionData);
    }
}
