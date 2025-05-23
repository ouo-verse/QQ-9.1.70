package NS_MINI_CLOUDSTORAGE;

import NS_COMM.COMM;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CloudStorage$StRemoveUserCloudStorageReq extends MessageMicro<CloudStorage$StRemoveUserCloudStorageReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"ext", "appid", "openid", CommonConstant.KEY_ACCESS_TOKEN, "signature", "sigMethod", "keyList"}, new Object[]{null, "", "", "", "", "", ""}, CloudStorage$StRemoveUserCloudStorageReq.class);
    public COMM.StCommonExt ext = new COMM.StCommonExt();
    public final PBStringField appid = PBField.initString("");
    public final PBStringField openid = PBField.initString("");
    public final PBStringField accessToken = PBField.initString("");
    public final PBStringField signature = PBField.initString("");
    public final PBStringField sigMethod = PBField.initString("");
    public final PBRepeatField<String> keyList = PBField.initRepeat(PBStringField.__repeatHelper__);
}
