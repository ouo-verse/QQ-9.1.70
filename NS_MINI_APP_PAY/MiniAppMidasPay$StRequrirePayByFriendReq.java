package NS_MINI_APP_PAY;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class MiniAppMidasPay$StRequrirePayByFriendReq extends MessageMicro<MiniAppMidasPay$StRequrirePayByFriendReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 42, 50, 56}, new String[]{"extInfo", "appid", "prepayId", "goodsDesc", "goodsPicUrl", "sandboxEnv"}, new Object[]{null, "", "", "", "", 0}, MiniAppMidasPay$StRequrirePayByFriendReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField appid = PBField.initString("");
    public final PBStringField prepayId = PBField.initString("");
    public final PBStringField goodsDesc = PBField.initString("");
    public final PBStringField goodsPicUrl = PBField.initString("");
    public final PBInt32Field sandboxEnv = PBField.initInt32(0);
}
