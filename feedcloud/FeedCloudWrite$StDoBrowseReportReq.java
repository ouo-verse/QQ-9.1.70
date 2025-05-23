package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$StDoBrowseReportReq extends MessageMicro<FeedCloudWrite$StDoBrowseReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 82}, new String[]{"vv_count", "feed_ids", "source", "trans_info"}, new Object[]{0, "", 0, ByteStringMicro.EMPTY}, FeedCloudWrite$StDoBrowseReportReq.class);
    public final PBInt32Field vv_count = PBField.initInt32(0);
    public final PBRepeatField<String> feed_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBEnumField source = PBField.initEnum(0);
    public final PBBytesField trans_info = PBField.initBytes(ByteStringMicro.EMPTY);
}
