package NS_MINI_APP_PAY;

import NS_COMM.COMM;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class MiniAppMidasPay$StGameQueryPayReq extends MessageMicro<MiniAppMidasPay$StGameQueryPayReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"extInfo", "prepayId", PreloadTRTCPlayerParams.KEY_SIG}, new Object[]{null, "", ""}, MiniAppMidasPay$StGameQueryPayReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField prepayId = PBField.initString("");
    public final PBStringField sig = PBField.initString("");
}
