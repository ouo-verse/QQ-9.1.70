package NS_MINI_APP_PAY;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class MiniAppMidasPay$StNotifyIdePayResultReq extends MessageMicro<MiniAppMidasPay$StNotifyIdePayResultReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48}, new String[]{"extInfo", "appId", "id", "amt", "scene", "result"}, new Object[]{null, "", "", 0, 0, 0}, MiniAppMidasPay$StNotifyIdePayResultReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField appId = PBField.initString("");

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f24951id = PBField.initString("");
    public final PBInt32Field amt = PBField.initInt32(0);
    public final PBInt32Field scene = PBField.initInt32(0);
    public final PBInt32Field result = PBField.initInt32(0);
}
