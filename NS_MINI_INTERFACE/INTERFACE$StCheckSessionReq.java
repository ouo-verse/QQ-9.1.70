package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StCheckSessionReq extends MessageMicro<INTERFACE$StCheckSessionReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"ext", "appid"}, new Object[]{null, ""}, INTERFACE$StCheckSessionReq.class);
    public COMM.StCommonExt ext = new COMM.StCommonExt();
    public final PBStringField appid = PBField.initString("");
}
