package NS_MINI_APP_PAY;

import NS_COMM.COMM;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class MiniAppMidasPay$StCheckGamePayReq extends MessageMicro<MiniAppMidasPay$StCheckGamePayReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"extInfo", "openid", "appid", "prepay_id", "bill_no", PreloadTRTCPlayerParams.KEY_SIG}, new Object[]{null, "", "", "", "", ""}, MiniAppMidasPay$StCheckGamePayReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField openid = PBField.initString("");
    public final PBStringField appid = PBField.initString("");
    public final PBStringField prepay_id = PBField.initString("");
    public final PBStringField bill_no = PBField.initString("");
    public final PBStringField sig = PBField.initString("");
}
