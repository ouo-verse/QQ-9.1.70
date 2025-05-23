package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StBatchGetUserInfoReq extends MessageMicro<INTERFACE$StBatchGetUserInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"extInfo", "appid", "lang", "openIds"}, new Object[]{null, "", "", ""}, INTERFACE$StBatchGetUserInfoReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField appid = PBField.initString("");
    public final PBStringField lang = PBField.initString("");
    public final PBRepeatField<String> openIds = PBField.initRepeat(PBStringField.__repeatHelper__);
}
