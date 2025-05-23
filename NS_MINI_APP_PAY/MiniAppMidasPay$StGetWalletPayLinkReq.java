package NS_MINI_APP_PAY;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class MiniAppMidasPay$StGetWalletPayLinkReq extends MessageMicro<MiniAppMidasPay$StGetWalletPayLinkReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"extInfo", "prepayId", "appid"}, new Object[]{null, "", ""}, MiniAppMidasPay$StGetWalletPayLinkReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField prepayId = PBField.initString("");
    public final PBStringField appid = PBField.initString("");
}
