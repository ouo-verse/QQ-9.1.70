package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudAigcsvr$Model extends MessageMicro<FeedCloudAigcsvr$Model> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"model", "custom_param"}, new Object[]{"", null}, FeedCloudAigcsvr$Model.class);
    public final PBStringField model = PBField.initString("");
    public FeedCloudAigcsvr$CustomParam custom_param = new FeedCloudAigcsvr$CustomParam();
}
