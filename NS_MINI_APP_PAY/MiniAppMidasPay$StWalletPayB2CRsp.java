package NS_MINI_APP_PAY;

import NS_COMM.COMM;
import com.huawei.hms.adapter.internal.CommonCode;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class MiniAppMidasPay$StWalletPayB2CRsp extends MessageMicro<MiniAppMidasPay$StWalletPayB2CRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"extInfo", "retcode", "retmsg", "mch_id", "trade_no", CommonCode.MapKey.TRANSACTION_ID, "transaction_state"}, new Object[]{null, "", "", "", "", "", ""}, MiniAppMidasPay$StWalletPayB2CRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField retcode = PBField.initString("");
    public final PBStringField retmsg = PBField.initString("");
    public final PBStringField mch_id = PBField.initString("");
    public final PBStringField trade_no = PBField.initString("");
    public final PBStringField transaction_id = PBField.initString("");
    public final PBStringField transaction_state = PBField.initString("");
}
