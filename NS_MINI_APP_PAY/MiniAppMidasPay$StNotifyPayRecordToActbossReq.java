package NS_MINI_APP_PAY;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class MiniAppMidasPay$StNotifyPayRecordToActbossReq extends MessageMicro<MiniAppMidasPay$StNotifyPayRecordToActbossReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "uin"}, new Object[]{null, ""}, MiniAppMidasPay$StNotifyPayRecordToActbossReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField uin = PBField.initString("");
}
