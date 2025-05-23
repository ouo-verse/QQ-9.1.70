package NS_MINI_CLOUDSTORAGE;

import NS_COMM.COMM;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CloudStorage$StSetUserCloudStorageReq extends MessageMicro<CloudStorage$StSetUserCloudStorageReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"ext", "appid", "openid", CommonConstant.KEY_ACCESS_TOKEN, "signature", "sigMethod", "KVDataList"}, new Object[]{null, "", "", "", "", "", null}, CloudStorage$StSetUserCloudStorageReq.class);
    public COMM.StCommonExt ext = new COMM.StCommonExt();
    public final PBStringField appid = PBField.initString("");
    public final PBStringField openid = PBField.initString("");
    public final PBStringField accessToken = PBField.initString("");
    public final PBStringField signature = PBField.initString("");
    public final PBStringField sigMethod = PBField.initString("");
    public final PBRepeatMessageField<CloudStorage$StKVData> KVDataList = PBField.initRepeatMessage(CloudStorage$StKVData.class);
}
