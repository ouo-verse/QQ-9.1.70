package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StEveryoneSearchInfo extends MessageMicro<FeedCloudMeta$StEveryoneSearchInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42}, new String[]{"suggestion_words", "plan_type", "plan_time_value", "plan_page_value", "trans_info"}, new Object[]{"", 0, 0, 0, ""}, FeedCloudMeta$StEveryoneSearchInfo.class);
    public final PBRepeatField<String> suggestion_words = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBEnumField plan_type = PBField.initEnum(0);
    public final PBInt32Field plan_time_value = PBField.initInt32(0);
    public final PBInt32Field plan_page_value = PBField.initInt32(0);
    public final PBStringField trans_info = PBField.initString("");
}
