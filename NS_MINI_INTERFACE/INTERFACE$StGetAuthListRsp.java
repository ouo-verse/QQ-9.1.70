package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StGetAuthListRsp extends MessageMicro<INTERFACE$StGetAuthListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"extInfo", "auths", QCircleDaTongConstant.ElementParamValue.SETTINGS}, new Object[]{null, null, null}, INTERFACE$StGetAuthListRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<INTERFACE$StUserAuthInfo> auths = PBField.initRepeatMessage(INTERFACE$StUserAuthInfo.class);
    public final PBRepeatMessageField<INTERFACE$StUserSettingInfo> settings = PBField.initRepeatMessage(INTERFACE$StUserSettingInfo.class);
}
