package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudTagbasesvr$StChangeTagOrderReq extends MessageMicro<FeedCloudTagbasesvr$StChangeTagOrderReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"tagParentName", "tagName", "orderChange"}, new Object[]{"", "", 0}, FeedCloudTagbasesvr$StChangeTagOrderReq.class);
    public final PBStringField tagParentName = PBField.initString("");
    public final PBStringField tagName = PBField.initString("");
    public final PBInt32Field orderChange = PBField.initInt32(0);
}
