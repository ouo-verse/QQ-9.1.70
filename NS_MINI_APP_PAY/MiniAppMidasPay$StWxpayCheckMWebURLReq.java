package NS_MINI_APP_PAY;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class MiniAppMidasPay$StWxpayCheckMWebURLReq extends MessageMicro<MiniAppMidasPay$StWxpayCheckMWebURLReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"extInfo", "mweb_url", "appid"}, new Object[]{null, "", ""}, MiniAppMidasPay$StWxpayCheckMWebURLReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField mweb_url = PBField.initString("");
    public final PBStringField appid = PBField.initString("");
}
