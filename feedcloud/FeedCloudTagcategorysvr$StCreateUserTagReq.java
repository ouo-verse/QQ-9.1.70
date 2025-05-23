package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudTagcategorysvr$StCreateUserTagReq extends MessageMicro<FeedCloudTagcategorysvr$StCreateUserTagReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"tagName", "tagType", "appID"}, new Object[]{"", 0, 0}, FeedCloudTagcategorysvr$StCreateUserTagReq.class);
    public final PBStringField tagName = PBField.initString("");
    public final PBEnumField tagType = PBField.initEnum(0);
    public final PBInt32Field appID = PBField.initInt32(0);
}
