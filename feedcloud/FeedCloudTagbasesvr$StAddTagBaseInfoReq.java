package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudTagbasesvr$StAddTagBaseInfoReq extends MessageMicro<FeedCloudTagbasesvr$StAddTagBaseInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"tagParentName", "tagName"}, new Object[]{"", ""}, FeedCloudTagbasesvr$StAddTagBaseInfoReq.class);
    public final PBStringField tagParentName = PBField.initString("");
    public final PBStringField tagName = PBField.initString("");
}
