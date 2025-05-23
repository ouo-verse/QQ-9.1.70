package NS_CERTIFIED_ACCOUNT_READ;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StUser;
import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountRead$StGetAccountInfoRsp extends MessageMicro<CertifiedAccountRead$StGetAccountInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"extInfo", QCircleAlphaUserReporter.KEY_USER, "verifyState"}, new Object[]{null, null, 0}, CertifiedAccountRead$StGetAccountInfoRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public CertifiedAccountMeta$StUser user = new CertifiedAccountMeta$StUser();
    public final PBUInt32Field verifyState = PBField.initUInt32(0);
}
