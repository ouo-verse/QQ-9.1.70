package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$TofuFeed extends MessageMicro<FeedCloudRead$TofuFeed> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"url", "is_pic", "jump"}, new Object[]{"", Boolean.FALSE, ""}, FeedCloudRead$TofuFeed.class);
    public final PBStringField url = PBField.initString("");
    public final PBBoolField is_pic = PBField.initBool(false);
    public final PBStringField jump = PBField.initString("");
}
