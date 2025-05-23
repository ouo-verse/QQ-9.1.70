package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes28.dex */
public final class FeedCloudWrite$StDoPushReq extends MessageMicro<FeedCloudWrite$StDoPushReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40, 50, 56, 64, 72}, new String[]{"extInfo", "feed", "comboCount", "push", "from", "busiReqData", "pushType", "src", "push_version"}, new Object[]{null, null, 0, null, 0, ByteStringMicro.EMPTY, 0, 0, 0}, FeedCloudWrite$StDoPushReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public FeedCloudMeta$StFeed feed = new FeedCloudMeta$StFeed();
    public final PBInt32Field comboCount = PBField.initInt32(0);
    public FeedCloudMeta$StPushList push = new FeedCloudMeta$StPushList();
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field pushType = PBField.initInt32(0);
    public final PBInt32Field src = PBField.initInt32(0);
    public final PBInt32Field push_version = PBField.initInt32(0);
}
