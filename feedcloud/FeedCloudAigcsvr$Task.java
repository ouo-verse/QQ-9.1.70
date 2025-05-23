package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudAigcsvr$Task extends MessageMicro<FeedCloudAigcsvr$Task> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"task_id", "task_status", "image"}, new Object[]{"", 0, null}, FeedCloudAigcsvr$Task.class);
    public final PBStringField task_id = PBField.initString("");
    public final PBUInt32Field task_status = PBField.initUInt32(0);
    public FeedCloudAigcsvr$Image image = new FeedCloudAigcsvr$Image();
}
