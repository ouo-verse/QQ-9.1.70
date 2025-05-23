package NS_MINI_APP_PAY;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class MiniAppMidasPay$StMiniPayRsp extends MessageMicro<MiniAppMidasPay$StMiniPayRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42}, new String[]{"extInfo", "bill_no", "balance", "used_gen_amt", "trade_id"}, new Object[]{null, "", 0, 0, ""}, MiniAppMidasPay$StMiniPayRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField bill_no = PBField.initString("");
    public final PBInt32Field balance = PBField.initInt32(0);
    public final PBInt32Field used_gen_amt = PBField.initInt32(0);
    public final PBStringField trade_id = PBField.initString("");
}
