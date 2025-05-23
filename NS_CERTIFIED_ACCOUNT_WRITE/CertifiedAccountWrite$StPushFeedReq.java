package NS_CERTIFIED_ACCOUNT_WRITE;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StPushSet;
import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes.dex */
public final class CertifiedAccountWrite$StPushFeedReq extends MessageMicro<CertifiedAccountWrite$StPushFeedReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "pFeed"}, new Object[]{null, null}, CertifiedAccountWrite$StPushFeedReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public CertifiedAccountMeta$StPushSet pFeed = new CertifiedAccountMeta$StPushSet();
}
