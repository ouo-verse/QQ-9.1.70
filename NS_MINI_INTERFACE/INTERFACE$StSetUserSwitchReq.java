package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StSetUserSwitchReq extends MessageMicro<INTERFACE$StSetUserSwitchReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"extInfo", "key", "value"}, new Object[]{null, "", 0}, INTERFACE$StSetUserSwitchReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField key = PBField.initString("");
    public final PBInt32Field value = PBField.initInt32(0);
}
