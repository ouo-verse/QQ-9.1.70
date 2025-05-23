package NS_MINI_APP_PAY;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class MiniAppMidasPay$StWalletPayB2CReq extends MessageMicro<MiniAppMidasPay$StWalletPayB2CReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 64}, new String[]{"extInfo", "mch_id", "trade_no", "appid", "openid", "uin", "total_fee", "check_real_name"}, new Object[]{null, "", "", "", "", "", "", 0}, MiniAppMidasPay$StWalletPayB2CReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField mch_id = PBField.initString("");
    public final PBStringField trade_no = PBField.initString("");
    public final PBStringField appid = PBField.initString("");
    public final PBStringField openid = PBField.initString("");
    public final PBStringField uin = PBField.initString("");
    public final PBStringField total_fee = PBField.initString("");
    public final PBInt32Field check_real_name = PBField.initInt32(0);
}
