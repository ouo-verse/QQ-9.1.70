package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes.dex */
public final class INTERFACE$StBatchQueryAppInfoByPathReq extends MessageMicro<INTERFACE$StBatchQueryAppInfoByPathReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "appPaths"}, new Object[]{null, null}, INTERFACE$StBatchQueryAppInfoByPathReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<INTERFACE$StAppPath> appPaths = PBField.initRepeatMessage(INTERFACE$StAppPath.class);
}
