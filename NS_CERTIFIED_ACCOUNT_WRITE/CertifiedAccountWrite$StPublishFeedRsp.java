package NS_CERTIFIED_ACCOUNT_WRITE;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes.dex */
public final class CertifiedAccountWrite$StPublishFeedRsp extends MessageMicro<CertifiedAccountWrite$StPublishFeedRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "feed"}, new Object[]{null, null}, CertifiedAccountWrite$StPublishFeedRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public CertifiedAccountMeta$StFeed feed = new CertifiedAccountMeta$StFeed();
}
