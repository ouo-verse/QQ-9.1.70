package NS_MINI_APP_PAY;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class MiniAppMidasPay$StGamePayReq extends MessageMicro<MiniAppMidasPay$StGamePayReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48, 56, 64, 72, 80}, new String[]{"extInfo", "appId", "prepayId", "starCurrency", "balanceAmount", "topupAmount", "payChannel", "sandboxEnv", "reason", "sdkType"}, new Object[]{null, "", "", 0, 0, 0, 0, 0, 0, 0}, MiniAppMidasPay$StGamePayReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField appId = PBField.initString("");
    public final PBStringField prepayId = PBField.initString("");
    public final PBInt32Field starCurrency = PBField.initInt32(0);
    public final PBInt32Field balanceAmount = PBField.initInt32(0);
    public final PBInt32Field topupAmount = PBField.initInt32(0);
    public final PBInt32Field payChannel = PBField.initInt32(0);
    public final PBInt32Field sandboxEnv = PBField.initInt32(0);
    public final PBInt32Field reason = PBField.initInt32(0);
    public final PBInt32Field sdkType = PBField.initInt32(0);
}
