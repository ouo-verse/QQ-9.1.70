package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StContentAccelerateReq extends MessageMicro<INTERFACE$StContentAccelerateReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42}, new String[]{"extInfo", "appid", "dataUrl", "needCode", "reqHeaders"}, new Object[]{null, "", "", 0, null}, INTERFACE$StContentAccelerateReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField appid = PBField.initString("");
    public final PBStringField dataUrl = PBField.initString("");
    public final PBInt32Field needCode = PBField.initInt32(0);
    public final PBRepeatMessageField<COMM.Entry> reqHeaders = PBField.initRepeatMessage(COMM.Entry.class);
}
