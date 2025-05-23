package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StCode2SessionKeyRsp extends MessageMicro<INTERFACE$StCode2SessionKeyRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"extInfo", "ret", "openid", "sessionKey", "unionid"}, new Object[]{null, null, "", "", ""}, INTERFACE$StCode2SessionKeyRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public COMM.Result ret = new COMM.Result();
    public final PBStringField openid = PBField.initString("");
    public final PBStringField sessionKey = PBField.initString("");
    public final PBStringField unionid = PBField.initString("");
}
