package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$StDoCommentRsp extends MessageMicro<FeedCloudWrite$StDoCommentRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"extInfo", "comment", "busiRspData"}, new Object[]{null, null, ByteStringMicro.EMPTY}, FeedCloudWrite$StDoCommentRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public FeedCloudMeta$StComment comment = new FeedCloudMeta$StComment();
    public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
}
