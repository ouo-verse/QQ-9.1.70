package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StNoticeCategoryReport extends MessageMicro<FeedCloudMeta$StNoticeCategoryReport> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"entrance_name", "psv_task_id", "busiReport"}, new Object[]{"", "", ByteStringMicro.EMPTY}, FeedCloudMeta$StNoticeCategoryReport.class);
    public final PBStringField entrance_name = PBField.initString("");
    public final PBStringField psv_task_id = PBField.initString("");
    public final PBBytesField busiReport = PBField.initBytes(ByteStringMicro.EMPTY);
}
