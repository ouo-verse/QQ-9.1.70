package NS_CERTIFIED_ACCOUNT_WRITE;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StUser;
import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountWrite$StDoTipOffReq extends MessageMicro<CertifiedAccountWrite$StDoTipOffReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 42, 50, 56}, new String[]{"extInfo", "reasonId", "reasonText", "tipOffType", QCircleAlphaUserReporter.KEY_USER, "feed", "feedbackType"}, new Object[]{null, 1, "", 0, null, null, 0}, CertifiedAccountWrite$StDoTipOffReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBEnumField reasonId = PBField.initEnum(1);
    public final PBStringField reasonText = PBField.initString("");
    public final PBUInt32Field tipOffType = PBField.initUInt32(0);
    public CertifiedAccountMeta$StUser user = new CertifiedAccountMeta$StUser();
    public CertifiedAccountMeta$StFeed feed = new CertifiedAccountMeta$StFeed();
    public final PBUInt32Field feedbackType = PBField.initUInt32(0);
}
