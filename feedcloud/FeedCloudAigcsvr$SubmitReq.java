package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudAigcsvr$SubmitReq extends MessageMicro<FeedCloudAigcsvr$SubmitReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"model", "image"}, new Object[]{"", null}, FeedCloudAigcsvr$SubmitReq.class);
    public final PBStringField model = PBField.initString("");
    public FeedCloudAigcsvr$Image image = new FeedCloudAigcsvr$Image();
}
