package NS_MINI_APP_PAY;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class MiniAppMidasPay$StCheckGamePayRsp extends MessageMicro<MiniAppMidasPay$StCheckGamePayRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"extInfo", "pay_state", "pay_time", "app_remark"}, new Object[]{null, 0, 0L, ""}, MiniAppMidasPay$StCheckGamePayRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt32Field pay_state = PBField.initInt32(0);
    public final PBInt64Field pay_time = PBField.initInt64(0);
    public final PBStringField app_remark = PBField.initString("");
}
