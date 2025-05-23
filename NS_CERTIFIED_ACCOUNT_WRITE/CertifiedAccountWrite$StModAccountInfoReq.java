package NS_CERTIFIED_ACCOUNT_WRITE;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StUser;
import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountWrite$StModAccountInfoReq extends MessageMicro<CertifiedAccountWrite$StModAccountInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"extInfo", QCircleAlphaUserReporter.KEY_USER, "modField"}, new Object[]{null, null, 0}, CertifiedAccountWrite$StModAccountInfoReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public CertifiedAccountMeta$StUser user = new CertifiedAccountMeta$StUser();
    public final PBUInt32Field modField = PBField.initUInt32(0);
}
