package feedcloud;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StOperation extends MessageMicro<FeedCloudMeta$StOperation> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50, 58, 66}, new String[]{"opType", "opUser", "opTime", "comment", "like", MessageForQCircleFeed.MSG_QCIRCLE_FEED_LEY_BUSI_DATA, "busiTranparent", WadlProxyConsts.KEY_JUMP_URL}, new Object[]{0, null, 0L, null, null, ByteStringMicro.EMPTY, null, ""}, FeedCloudMeta$StOperation.class);
    public final PBUInt32Field opType = PBField.initUInt32(0);
    public FeedCloudMeta$StUser opUser = new FeedCloudMeta$StUser();
    public final PBUInt64Field opTime = PBField.initUInt64(0);
    public FeedCloudMeta$StComment comment = new FeedCloudMeta$StComment();
    public FeedCloudMeta$StLike like = new FeedCloudMeta$StLike();
    public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<FeedCloudCommon$BytesEntry> busiTranparent = PBField.initRepeatMessage(FeedCloudCommon$BytesEntry.class);
    public final PBStringField jumpUrl = PBField.initString("");
}
