package NS_CERTIFIED_ACCOUNT_READ;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StMessageStatus;
import NS_COMM.COMM;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountRead$StGetFollowFeedsRsp extends MessageMicro<CertifiedAccountRead$StGetFollowFeedsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 50, 66}, new String[]{"extInfo", "feeds", "isFinish", WadlProxyConsts.NOTICE_COUNT, "messStatus", "careLive", "livePageInfo"}, new Object[]{null, null, 0, 0, null, null, ""}, CertifiedAccountRead$StGetFollowFeedsRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<CertifiedAccountMeta$StFeed> feeds = PBField.initRepeatMessage(CertifiedAccountMeta$StFeed.class);
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public final PBUInt32Field noticeCount = PBField.initUInt32(0);
    public CertifiedAccountMeta$StMessageStatus messStatus = new CertifiedAccountMeta$StMessageStatus();
    public final PBRepeatMessageField<CertifiedAccountMeta$StFeed> careLive = PBField.initRepeatMessage(CertifiedAccountMeta$StFeed.class);
    public final PBStringField livePageInfo = PBField.initString("");
}
