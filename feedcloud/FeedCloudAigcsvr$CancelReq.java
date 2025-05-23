package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudAigcsvr$CancelReq extends MessageMicro<FeedCloudAigcsvr$CancelReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"task_ids"}, new Object[]{""}, FeedCloudAigcsvr$CancelReq.class);
    public final PBRepeatField<String> task_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
}
