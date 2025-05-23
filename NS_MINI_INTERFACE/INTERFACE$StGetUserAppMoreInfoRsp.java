package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StGetUserAppMoreInfoRsp extends MessageMicro<INTERFACE$StGetUserAppMoreInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "appMoreInfoList"}, new Object[]{null, null}, INTERFACE$StGetUserAppMoreInfoRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<INTERFACE$StApiAppMoreInfo> appMoreInfoList = PBField.initRepeatMessage(INTERFACE$StApiAppMoreInfo.class);
}
