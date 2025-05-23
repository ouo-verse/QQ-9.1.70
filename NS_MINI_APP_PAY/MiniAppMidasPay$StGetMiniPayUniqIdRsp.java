package NS_MINI_APP_PAY;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class MiniAppMidasPay$StGetMiniPayUniqIdRsp extends MessageMicro<MiniAppMidasPay$StGetMiniPayUniqIdRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "id"}, new Object[]{null, ""}, MiniAppMidasPay$StGetMiniPayUniqIdRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f24944id = PBField.initString("");
}
