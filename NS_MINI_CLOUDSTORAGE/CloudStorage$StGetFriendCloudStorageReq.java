package NS_MINI_CLOUDSTORAGE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CloudStorage$StGetFriendCloudStorageReq extends MessageMicro<CloudStorage$StGetFriendCloudStorageReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"ext", "appid", "keyList"}, new Object[]{null, "", ""}, CloudStorage$StGetFriendCloudStorageReq.class);
    public COMM.StCommonExt ext = new COMM.StCommonExt();
    public final PBStringField appid = PBField.initString("");
    public final PBRepeatField<String> keyList = PBField.initRepeat(PBStringField.__repeatHelper__);
}
