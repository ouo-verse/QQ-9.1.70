package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StSetUserAppTopReq extends MessageMicro<INTERFACE$StSetUserAppTopReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 56}, new String[]{"extInfo", "appId", "putTop", "verType", "oldIdx", "newIdx", "fromNewDownload"}, new Object[]{null, "", 0, 0, 0, 0, 0}, INTERFACE$StSetUserAppTopReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField appId = PBField.initString("");
    public final PBUInt32Field putTop = PBField.initUInt32(0);
    public final PBEnumField verType = PBField.initEnum(0);
    public final PBInt32Field oldIdx = PBField.initInt32(0);
    public final PBInt32Field newIdx = PBField.initInt32(0);
    public final PBInt32Field fromNewDownload = PBField.initInt32(0);
}
