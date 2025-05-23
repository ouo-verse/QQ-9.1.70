package NS_MINI_APP_PAY;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class MiniAppMidasPay$StGetPayForFriendInfoRsp extends MessageMicro<MiniAppMidasPay$StGetPayForFriendInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50, 58, 64, 72, 80, 90, 98, 106}, new String[]{"extInfo", "hostUin", "hostNick", "hostAvatar", "starCurrency", "goodsDesc", "goodsPicUrl", "tradeStatus", "expireAfter", "sandboxEnv", "friendUin", "friendNick", "friendAvatar"}, new Object[]{null, "", "", "", 0L, "", "", 1, 0, 0, "", "", ""}, MiniAppMidasPay$StGetPayForFriendInfoRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField hostUin = PBField.initString("");
    public final PBStringField hostNick = PBField.initString("");
    public final PBStringField hostAvatar = PBField.initString("");
    public final PBInt64Field starCurrency = PBField.initInt64(0);
    public final PBStringField goodsDesc = PBField.initString("");
    public final PBStringField goodsPicUrl = PBField.initString("");
    public final PBEnumField tradeStatus = PBField.initEnum(1);
    public final PBInt32Field expireAfter = PBField.initInt32(0);
    public final PBInt32Field sandboxEnv = PBField.initInt32(0);
    public final PBStringField friendUin = PBField.initString("");
    public final PBStringField friendNick = PBField.initString("");
    public final PBStringField friendAvatar = PBField.initString("");
}
