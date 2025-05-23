package NS_MINI_APP_PAY;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class MiniAppMidasPay$StMiniCheckOfferIdRsp extends MessageMicro<MiniAppMidasPay$StMiniCheckOfferIdRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"extInfo", "result", "firstRefer", "firstVia"}, new Object[]{null, 0, "", ""}, MiniAppMidasPay$StMiniCheckOfferIdRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt32Field result = PBField.initInt32(0);
    public final PBStringField firstRefer = PBField.initString("");
    public final PBStringField firstVia = PBField.initString("");
}
