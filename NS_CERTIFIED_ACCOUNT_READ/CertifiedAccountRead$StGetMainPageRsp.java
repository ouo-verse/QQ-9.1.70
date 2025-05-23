package NS_CERTIFIED_ACCOUNT_READ;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StMessageStatus;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StPushSet;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StQQGroup;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StShare;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StUser;
import NS_COMM.COMM;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* loaded from: classes.dex */
public final class CertifiedAccountRead$StGetMainPageRsp extends MessageMicro<CertifiedAccountRead$StGetMainPageRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 50, 56, 66, 74, 80, 88, 98, 106, 114}, new String[]{"extInfo", QCircleAlphaUserReporter.KEY_USER, QFSSearchBaseRequest.EXTRA_KEY_FEED_COUNT, "fansCount", "followCount", "vecFeed", "isFinish", "share", "vecGroup", "ytdFansCount", "viewTotalCount", "pushFeed", "messStatus", "jumpURLs"}, new Object[]{null, null, 0, 0, 0, null, 0, null, null, 0L, 0L, null, null, null}, CertifiedAccountRead$StGetMainPageRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public CertifiedAccountMeta$StUser user = new CertifiedAccountMeta$StUser();
    public final PBUInt32Field feedCount = PBField.initUInt32(0);
    public final PBUInt32Field fansCount = PBField.initUInt32(0);
    public final PBUInt32Field followCount = PBField.initUInt32(0);
    public final PBRepeatMessageField<CertifiedAccountMeta$StFeed> vecFeed = PBField.initRepeatMessage(CertifiedAccountMeta$StFeed.class);
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public CertifiedAccountMeta$StShare share = new CertifiedAccountMeta$StShare();
    public final PBRepeatMessageField<CertifiedAccountMeta$StQQGroup> vecGroup = PBField.initRepeatMessage(CertifiedAccountMeta$StQQGroup.class);
    public final PBUInt64Field ytdFansCount = PBField.initUInt64(0);
    public final PBUInt64Field viewTotalCount = PBField.initUInt64(0);
    public CertifiedAccountMeta$StPushSet pushFeed = new CertifiedAccountMeta$StPushSet();
    public CertifiedAccountMeta$StMessageStatus messStatus = new CertifiedAccountMeta$StMessageStatus();
    public CertifiedAccountRead$StMainPageJumpH5URL jumpURLs = new CertifiedAccountRead$StMainPageJumpH5URL();
}
