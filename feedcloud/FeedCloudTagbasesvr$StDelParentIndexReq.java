package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudTagbasesvr$StDelParentIndexReq extends MessageMicro<FeedCloudTagbasesvr$StDelParentIndexReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"tagParentName", "categoryIndex", "tagIndex", "fakeDel"}, new Object[]{"", 0, 0, Boolean.FALSE}, FeedCloudTagbasesvr$StDelParentIndexReq.class);
    public final PBStringField tagParentName = PBField.initString("");
    public final PBInt32Field categoryIndex = PBField.initInt32(0);
    public final PBInt32Field tagIndex = PBField.initInt32(0);
    public final PBBoolField fakeDel = PBField.initBool(false);
}
