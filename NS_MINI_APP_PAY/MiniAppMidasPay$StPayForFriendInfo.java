package NS_MINI_APP_PAY;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class MiniAppMidasPay$StPayForFriendInfo extends MessageMicro<MiniAppMidasPay$StPayForFriendInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 56, 66}, new String[]{"appid", "prepayId", "hostUin", "goodsDesc", "goodsPicUrl", "sandboxEnv", "friendUin"}, new Object[]{"", "", "", "", "", 0, ""}, MiniAppMidasPay$StPayForFriendInfo.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField prepayId = PBField.initString("");
    public final PBStringField hostUin = PBField.initString("");
    public final PBStringField goodsDesc = PBField.initString("");
    public final PBStringField goodsPicUrl = PBField.initString("");
    public final PBInt32Field sandboxEnv = PBField.initInt32(0);
    public final PBStringField friendUin = PBField.initString("");
}
