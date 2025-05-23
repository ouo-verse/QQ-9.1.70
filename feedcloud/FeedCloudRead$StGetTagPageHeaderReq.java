package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetTagPageHeaderReq extends MessageMicro<FeedCloudRead$StGetTagPageHeaderReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"tagID", "tagName"}, new Object[]{"", ""}, FeedCloudRead$StGetTagPageHeaderReq.class);
    public final PBStringField tagID = PBField.initString("");
    public final PBStringField tagName = PBField.initString("");
}
