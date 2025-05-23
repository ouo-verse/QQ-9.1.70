package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes28.dex */
public final class FeedCloudWrite$StDoFeedCloudProxyRsp extends MessageMicro<FeedCloudWrite$StDoFeedCloudProxyRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "proxyInfo"}, new Object[]{null, null}, FeedCloudWrite$StDoFeedCloudProxyRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public FeedCloudMeta$StProxyInfo proxyInfo = new FeedCloudMeta$StProxyInfo();
}
