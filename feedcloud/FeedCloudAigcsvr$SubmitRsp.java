package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudAigcsvr$SubmitRsp extends MessageMicro<FeedCloudAigcsvr$SubmitRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"task_id", "image"}, new Object[]{"", null}, FeedCloudAigcsvr$SubmitRsp.class);
    public final PBStringField task_id = PBField.initString("");
    public FeedCloudAigcsvr$Image image = new FeedCloudAigcsvr$Image();
}
