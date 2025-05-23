package feedcloud;

import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$StDoTopReq extends MessageMicro<FeedCloudWrite$StDoTopReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 50, 56}, new String[]{"extInfo", MiniChatConstants.MINI_APP_TOP_TYPE, "feed", "comment", "from", "busiReqData", "src"}, new Object[]{null, 0, null, null, 0, ByteStringMicro.EMPTY, 0}, FeedCloudWrite$StDoTopReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBUInt32Field topType = PBField.initUInt32(0);
    public FeedCloudMeta$StFeed feed = new FeedCloudMeta$StFeed();
    public FeedCloudMeta$StComment comment = new FeedCloudMeta$StComment();
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field src = PBField.initInt32(0);
}
