package NS_MINI_SHARE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class MiniProgramShare$StGetMiniAppPathReq extends MessageMicro<MiniProgramShare$StGetMiniAppPathReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50, 58}, new String[]{"extInfo", "main_appid", "appid", "path", "miniAppType", "webURL", "content"}, new Object[]{null, "", "", "", 0, "", ""}, MiniProgramShare$StGetMiniAppPathReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField main_appid = PBField.initString("");
    public final PBStringField appid = PBField.initString("");
    public final PBStringField path = PBField.initString("");
    public final PBInt32Field miniAppType = PBField.initInt32(0);
    public final PBStringField webURL = PBField.initString("");
    public final PBStringField content = PBField.initString("");
}
