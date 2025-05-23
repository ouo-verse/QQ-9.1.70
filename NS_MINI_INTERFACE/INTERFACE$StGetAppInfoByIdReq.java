package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StGetAppInfoByIdReq extends MessageMicro<INTERFACE$StGetAppInfoByIdReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 50, 58}, new String[]{"extInfo", "appid", "needVersionInfo", "checkDevRight", "firstPath", "envVersion", "fromAppid"}, new Object[]{null, "", 0, 0, "", "", ""}, INTERFACE$StGetAppInfoByIdReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField appid = PBField.initString("");
    public final PBInt32Field needVersionInfo = PBField.initInt32(0);
    public final PBInt32Field checkDevRight = PBField.initInt32(0);
    public final PBStringField firstPath = PBField.initString("");
    public final PBStringField envVersion = PBField.initString("");
    public final PBStringField fromAppid = PBField.initString("");
}
