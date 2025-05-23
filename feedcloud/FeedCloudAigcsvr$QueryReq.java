package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudAigcsvr$QueryReq extends MessageMicro<FeedCloudAigcsvr$QueryReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"task_id"}, new Object[]{""}, FeedCloudAigcsvr$QueryReq.class);
    public final PBStringField task_id = PBField.initString("");
}
