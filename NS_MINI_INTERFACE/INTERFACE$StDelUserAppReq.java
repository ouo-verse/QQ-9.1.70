package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StDelUserAppReq extends MessageMicro<INTERFACE$StDelUserAppReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48}, new String[]{"extInfo", "appId", "verType", "isRecommend", "source", "noDelTop"}, new Object[]{null, "", 0, 0, 0, 0}, INTERFACE$StDelUserAppReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField appId = PBField.initString("");
    public final PBEnumField verType = PBField.initEnum(0);
    public final PBInt32Field isRecommend = PBField.initInt32(0);
    public final PBInt32Field source = PBField.initInt32(0);
    public final PBInt32Field noDelTop = PBField.initInt32(0);
}
