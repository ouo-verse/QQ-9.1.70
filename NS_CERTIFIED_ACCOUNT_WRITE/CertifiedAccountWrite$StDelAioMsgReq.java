package NS_CERTIFIED_ACCOUNT_WRITE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountWrite$StDelAioMsgReq extends MessageMicro<CertifiedAccountWrite$StDelAioMsgReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "vecMsgId"}, new Object[]{null, ""}, CertifiedAccountWrite$StDelAioMsgReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatField<String> vecMsgId = PBField.initRepeat(PBStringField.__repeatHelper__);
}
