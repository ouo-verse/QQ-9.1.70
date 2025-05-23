package NS_CERTIFIED_ACCOUNT;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountMeta$StNotice extends MessageMicro<CertifiedAccountMeta$StNotice> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42}, new String[]{"feedId", "noticeType", WadlProxyConsts.CREATE_TIME, QCircleDaTongConstant.ElementParamValue.OPERATION, "feed"}, new Object[]{"", 0, 0L, null, null}, CertifiedAccountMeta$StNotice.class);
    public final PBStringField feedId = PBField.initString("");
    public final PBUInt32Field noticeType = PBField.initUInt32(0);
    public final PBUInt64Field createTime = PBField.initUInt64(0);
    public CertifiedAccountMeta$StOperation operation = new MessageMicro<CertifiedAccountMeta$StOperation>() { // from class: NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StOperation
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42}, new String[]{"opType", "opUser", "opTime", "comment", "like"}, new Object[]{0, null, 0L, null, null}, CertifiedAccountMeta$StOperation.class);
        public final PBUInt32Field opType = PBField.initUInt32(0);
        public CertifiedAccountMeta$StUser opUser = new CertifiedAccountMeta$StUser();
        public final PBUInt64Field opTime = PBField.initUInt64(0);
        public CertifiedAccountMeta$StComment comment = new CertifiedAccountMeta$StComment();
        public CertifiedAccountMeta$StLike like = new CertifiedAccountMeta$StLike();
    };
    public CertifiedAccountMeta$StFeed feed = new CertifiedAccountMeta$StFeed();
}
