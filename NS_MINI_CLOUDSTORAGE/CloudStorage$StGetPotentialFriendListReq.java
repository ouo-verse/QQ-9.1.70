package NS_MINI_CLOUDSTORAGE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class CloudStorage$StGetPotentialFriendListReq extends MessageMicro<CloudStorage$StGetPotentialFriendListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"ext", "appid"}, new Object[]{null, ""}, CloudStorage$StGetPotentialFriendListReq.class);
    public COMM.StCommonExt ext = new COMM.StCommonExt();
    public final PBStringField appid = PBField.initString("");
}
