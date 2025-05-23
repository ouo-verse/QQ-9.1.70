package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class INTERFACE$StGetPhoneNumberReq extends MessageMicro<INTERFACE$StGetPhoneNumberReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "appId"}, new Object[]{null, ""}, INTERFACE$StGetPhoneNumberReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField appId = PBField.initString("");
}
