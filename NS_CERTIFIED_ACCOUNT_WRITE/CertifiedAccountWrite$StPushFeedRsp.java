package NS_CERTIFIED_ACCOUNT_WRITE;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StPushSet;
import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes.dex */
public final class CertifiedAccountWrite$StPushFeedRsp extends MessageMicro<CertifiedAccountWrite$StPushFeedRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"extInfo", "pFeed", "pushFeedResult"}, new Object[]{null, null, 0}, CertifiedAccountWrite$StPushFeedRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public CertifiedAccountMeta$StPushSet pFeed = new CertifiedAccountMeta$StPushSet();
    public final PBUInt32Field pushFeedResult = PBField.initUInt32(0);
}
