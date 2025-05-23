package NS_MINI_APP_PAY;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class MiniAppMidasPay$StGamePrePayRsp extends MessageMicro<MiniAppMidasPay$StGamePrePayRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"extInfo", "prepayId", "token"}, new Object[]{null, "", ""}, MiniAppMidasPay$StGamePrePayRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField prepayId = PBField.initString("");
    public final PBStringField token = PBField.initString("");
}
