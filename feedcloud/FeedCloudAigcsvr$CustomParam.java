package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudAigcsvr$CustomParam extends MessageMicro<FeedCloudAigcsvr$CustomParam> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"icon_url", "description"}, new Object[]{"", ""}, FeedCloudAigcsvr$CustomParam.class);
    public final PBStringField icon_url = PBField.initString("");
    public final PBStringField description = PBField.initString("");
}
