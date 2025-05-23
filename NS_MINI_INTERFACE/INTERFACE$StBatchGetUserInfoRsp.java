package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StBatchGetUserInfoRsp extends MessageMicro<INTERFACE$StBatchGetUserInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", QCircleAlphaUserReporter.KEY_USER}, new Object[]{null, null}, INTERFACE$StBatchGetUserInfoRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<INTERFACE$StApiUserInfo> user = PBField.initRepeatMessage(INTERFACE$StApiUserInfo.class);
}
