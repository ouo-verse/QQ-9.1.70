package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$FilterGroup extends MessageMicro<FeedCloudRead$FilterGroup> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"name", "choices"}, new Object[]{"", ""}, FeedCloudRead$FilterGroup.class);
    public final PBStringField name = PBField.initString("");
    public final PBRepeatField<String> choices = PBField.initRepeat(PBStringField.__repeatHelper__);
}
