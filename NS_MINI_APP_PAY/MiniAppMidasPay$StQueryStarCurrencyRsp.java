package NS_MINI_APP_PAY;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class MiniAppMidasPay$StQueryStarCurrencyRsp extends MessageMicro<MiniAppMidasPay$StQueryStarCurrencyRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"extInfo", "remainder", "rechargeNum", "offerid"}, new Object[]{null, 0, 0, ""}, MiniAppMidasPay$StQueryStarCurrencyRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt32Field remainder = PBField.initInt32(0);
    public final PBInt32Field rechargeNum = PBField.initInt32(0);
    public final PBStringField offerid = PBField.initString("");
}
