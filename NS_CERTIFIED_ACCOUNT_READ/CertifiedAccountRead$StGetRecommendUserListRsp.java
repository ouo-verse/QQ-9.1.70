package NS_CERTIFIED_ACCOUNT_READ;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StEntry;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StUser;
import NS_COMM.COMM;
import com.qq.e.comm.constants.TangramHippyConstants;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountRead$StGetRecommendUserListRsp extends MessageMicro<CertifiedAccountRead$StGetRecommendUserListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 48, 56, 66}, new String[]{"extInfo", "vecUser", "totalNum", "isFinish", "entry", WadlProxyConsts.NOTICE_COUNT, TangramHippyConstants.EXP_TYPE, "vecUserWithFeed"}, new Object[]{null, null, 0, 0, null, 0, 0, null}, CertifiedAccountRead$StGetRecommendUserListRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<CertifiedAccountMeta$StUser> vecUser = PBField.initRepeatMessage(CertifiedAccountMeta$StUser.class);
    public final PBUInt32Field totalNum = PBField.initUInt32(0);
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public CertifiedAccountMeta$StEntry entry = new CertifiedAccountMeta$StEntry();
    public final PBUInt32Field noticeCount = PBField.initUInt32(0);
    public final PBUInt32Field expType = PBField.initUInt32(0);
    public final PBRepeatMessageField<CertifiedAccountMeta$StFeed> vecUserWithFeed = PBField.initRepeatMessage(CertifiedAccountMeta$StFeed.class);
}
