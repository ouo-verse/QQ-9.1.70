package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class INTERFACE$StDelPhoneNumbersReq extends MessageMicro<INTERFACE$StDelPhoneNumbersReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"extInfo", "appId", "purePhoneNumber"}, new Object[]{null, "", ""}, INTERFACE$StDelPhoneNumbersReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField appId = PBField.initString("");
    public final PBStringField purePhoneNumber = PBField.initString("");
}
