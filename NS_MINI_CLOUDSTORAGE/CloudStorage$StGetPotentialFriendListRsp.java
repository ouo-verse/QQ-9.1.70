package NS_MINI_CLOUDSTORAGE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes.dex */
public final class CloudStorage$StGetPotentialFriendListRsp extends MessageMicro<CloudStorage$StGetPotentialFriendListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"ext", "data"}, new Object[]{null, null}, CloudStorage$StGetPotentialFriendListRsp.class);
    public COMM.StCommonExt ext = new COMM.StCommonExt();
    public final PBRepeatMessageField<CloudStorage$StUserGameData> data = PBField.initRepeatMessage(CloudStorage$StUserGameData.class);
}
