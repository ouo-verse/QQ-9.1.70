package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StCheckNavigateRightRsp extends MessageMicro<INTERFACE$StCheckNavigateRightRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"extInfo", "actionCode", "skipLocalCheck", "wording"}, new Object[]{null, 0, 0, ""}, INTERFACE$StCheckNavigateRightRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt32Field actionCode = PBField.initInt32(0);
    public final PBInt32Field skipLocalCheck = PBField.initInt32(0);
    public final PBStringField wording = PBField.initString("");
}
