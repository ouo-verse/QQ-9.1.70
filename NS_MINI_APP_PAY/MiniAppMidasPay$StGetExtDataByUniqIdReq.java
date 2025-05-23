package NS_MINI_APP_PAY;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class MiniAppMidasPay$StGetExtDataByUniqIdReq extends MessageMicro<MiniAppMidasPay$StGetExtDataByUniqIdReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"extInfo", "appId", "id"}, new Object[]{null, "", ""}, MiniAppMidasPay$StGetExtDataByUniqIdReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField appId = PBField.initString("");

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f24943id = PBField.initString("");
}
