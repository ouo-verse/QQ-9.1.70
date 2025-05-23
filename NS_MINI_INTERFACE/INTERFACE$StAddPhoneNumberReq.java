package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.mini.servlet.MiniAppAddPhoneNumberServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class INTERFACE$StAddPhoneNumberReq extends MessageMicro<INTERFACE$StAddPhoneNumberReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40}, new String[]{"extInfo", "appId", "purePhoneNumber", "countryCode", MiniAppAddPhoneNumberServlet.KEY_IS_SAVE}, new Object[]{null, "", "", "", 0}, INTERFACE$StAddPhoneNumberReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField appId = PBField.initString("");
    public final PBStringField purePhoneNumber = PBField.initString("");
    public final PBStringField countryCode = PBField.initString("");
    public final PBInt32Field isSave = PBField.initInt32(0);
}
