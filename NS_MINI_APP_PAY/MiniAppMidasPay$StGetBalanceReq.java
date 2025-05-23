package NS_MINI_APP_PAY;

import NS_COMM.COMM;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class MiniAppMidasPay$StGetBalanceReq extends MessageMicro<MiniAppMidasPay$StGetBalanceReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 50}, new String[]{"extInfo", "openid", "appid", PreloadTRTCPlayerParams.KEY_SIG}, new Object[]{null, "", "", ""}, MiniAppMidasPay$StGetBalanceReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField openid = PBField.initString("");
    public final PBStringField appid = PBField.initString("");
    public final PBStringField sig = PBField.initString("");
}
