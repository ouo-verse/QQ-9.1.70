package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes28.dex */
public final class FeedCloudWrite$StDoFeedCloudProxyReq extends MessageMicro<FeedCloudWrite$StDoFeedCloudProxyReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32}, new String[]{"extInfo", "proxyType", "proxyInfo", "notifyAfterSec"}, new Object[]{null, 0, null, Boolean.FALSE}, FeedCloudWrite$StDoFeedCloudProxyReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBInt32Field proxyType = PBField.initInt32(0);
    public FeedCloudMeta$StProxyInfo proxyInfo = new FeedCloudMeta$StProxyInfo();
    public final PBBoolField notifyAfterSec = PBField.initBool(false);
}
