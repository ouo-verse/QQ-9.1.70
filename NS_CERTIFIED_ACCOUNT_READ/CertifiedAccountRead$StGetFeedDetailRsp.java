package NS_CERTIFIED_ACCOUNT_READ;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StShare;
import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountRead$StGetFeedDetailRsp extends MessageMicro<CertifiedAccountRead$StGetFeedDetailRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 58}, new String[]{"extInfo", "detailUrl", "feed", "vecRcmdFeed", "share", "isFinish", "adAttchInfo"}, new Object[]{null, "", null, null, null, 0, ""}, CertifiedAccountRead$StGetFeedDetailRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField detailUrl = PBField.initString("");
    public CertifiedAccountMeta$StFeed feed = new CertifiedAccountMeta$StFeed();
    public final PBRepeatMessageField<CertifiedAccountMeta$StFeed> vecRcmdFeed = PBField.initRepeatMessage(CertifiedAccountMeta$StFeed.class);
    public CertifiedAccountMeta$StShare share = new CertifiedAccountMeta$StShare();
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public final PBStringField adAttchInfo = PBField.initString("");
}
