package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudTagcategorysvr$StAddBlackTagNameReq extends MessageMicro<FeedCloudTagcategorysvr$StAddBlackTagNameReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"tagName", "tagToken"}, new Object[]{"", ""}, FeedCloudTagcategorysvr$StAddBlackTagNameReq.class);
    public final PBStringField tagName = PBField.initString("");
    public final PBStringField tagToken = PBField.initString("");
}
