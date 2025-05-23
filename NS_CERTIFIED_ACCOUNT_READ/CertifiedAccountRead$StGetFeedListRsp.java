package NS_CERTIFIED_ACCOUNT_READ;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StUser;
import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountRead$StGetFeedListRsp extends MessageMicro<CertifiedAccountRead$StGetFeedListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50, 58}, new String[]{"extInfo", "vecFeed", "isFinish", QCircleAlphaUserReporter.KEY_USER, "adAttchInfo", "hotLive", "livePageInfo"}, new Object[]{null, null, 0, null, "", null, ""}, CertifiedAccountRead$StGetFeedListRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<CertifiedAccountMeta$StFeed> vecFeed = PBField.initRepeatMessage(CertifiedAccountMeta$StFeed.class);
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public CertifiedAccountMeta$StUser user = new CertifiedAccountMeta$StUser();
    public final PBStringField adAttchInfo = PBField.initString("");
    public final PBRepeatMessageField<CertifiedAccountMeta$StFeed> hotLive = PBField.initRepeatMessage(CertifiedAccountMeta$StFeed.class);
    public final PBStringField livePageInfo = PBField.initString("");
}
