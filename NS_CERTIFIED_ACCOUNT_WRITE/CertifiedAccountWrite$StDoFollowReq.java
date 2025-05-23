package NS_CERTIFIED_ACCOUNT_WRITE;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StUser;
import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vas.ipc.VasLiveIPCModule;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountWrite$StDoFollowReq extends MessageMicro<CertifiedAccountWrite$StDoFollowReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"extInfo", VasLiveIPCModule.KEY_FOLLOW_TYPE, QCircleAlphaUserReporter.KEY_USER}, new Object[]{null, 0, null}, CertifiedAccountWrite$StDoFollowReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field followType = PBField.initUInt32(0);
    public CertifiedAccountMeta$StUser user = new CertifiedAccountMeta$StUser();
}
