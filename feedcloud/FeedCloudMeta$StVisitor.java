package feedcloud;

import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StVisitor extends MessageMicro<FeedCloudMeta$StVisitor> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50, 58}, new String[]{"viewCount", MessageForQCircleFeed.MSG_QCIRCLE_FEED_LEY_BUSI_DATA, "recomCount", "viewDesc", "yesterday_desc", "advice_desc", "advice_content"}, new Object[]{0, ByteStringMicro.EMPTY, 0, "", "", "", ""}, FeedCloudMeta$StVisitor.class);
    public final PBUInt32Field viewCount = PBField.initUInt32(0);
    public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field recomCount = PBField.initUInt32(0);
    public final PBStringField viewDesc = PBField.initString("");
    public final PBStringField yesterday_desc = PBField.initString("");
    public final PBStringField advice_desc = PBField.initString("");
    public final PBStringField advice_content = PBField.initString("");
}
