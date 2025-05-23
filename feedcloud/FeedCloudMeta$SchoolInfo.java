package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$SchoolInfo extends MessageMicro<FeedCloudMeta$SchoolInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"id", "name", "category", "comeFrom", "approvalStatus"}, new Object[]{"", "", 0, 0L, 0L}, FeedCloudMeta$SchoolInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f398445id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBUInt32Field category = PBField.initUInt32(0);
    public final PBUInt64Field comeFrom = PBField.initUInt64(0);
    public final PBUInt64Field approvalStatus = PBField.initUInt64(0);
}
