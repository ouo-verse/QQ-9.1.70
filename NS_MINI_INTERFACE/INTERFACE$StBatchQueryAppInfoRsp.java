package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StBatchQueryAppInfoRsp extends MessageMicro<INTERFACE$StBatchQueryAppInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "appInfos"}, new Object[]{null, null}, INTERFACE$StBatchQueryAppInfoRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<INTERFACE$StApiAppInfo> appInfos = PBField.initRepeatMessage(INTERFACE$StApiAppInfo.class);
}
