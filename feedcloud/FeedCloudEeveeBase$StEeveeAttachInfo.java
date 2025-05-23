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
public final class FeedCloudEeveeBase$StEeveeAttachInfo extends MessageMicro<FeedCloudEeveeBase$StEeveeAttachInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42}, new String[]{"key", "value", MessageForQCircleFeed.MSG_QCIRCLE_FEED_LEY_BUSI_DATA, "tag", "uid"}, new Object[]{"", "", ByteStringMicro.EMPTY, 0, ""}, FeedCloudEeveeBase$StEeveeAttachInfo.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField value = PBField.initString("");
    public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field tag = PBField.initUInt32(0);
    public final PBStringField uid = PBField.initString("");
}
