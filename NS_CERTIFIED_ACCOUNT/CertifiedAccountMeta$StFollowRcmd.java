package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountMeta$StFollowRcmd extends MessageMicro<CertifiedAccountMeta$StFollowRcmd> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{QCircleAlphaUserReporter.KEY_USER, "feedList", "reason", "fansCount"}, new Object[]{null, null, "", 0}, CertifiedAccountMeta$StFollowRcmd.class);
    public CertifiedAccountMeta$StUser user = new CertifiedAccountMeta$StUser();
    public final PBRepeatMessageField<CertifiedAccountMeta$StFeed> feedList = PBField.initRepeatMessage(CertifiedAccountMeta$StFeed.class);
    public final PBStringField reason = PBField.initString("");
    public final PBUInt32Field fansCount = PBField.initUInt32(0);
}
