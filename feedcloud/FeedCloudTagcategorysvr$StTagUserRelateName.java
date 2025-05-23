package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudTagcategorysvr$StTagUserRelateName extends MessageMicro<FeedCloudTagcategorysvr$StTagUserRelateName> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"type", "tagNames"}, new Object[]{1, ""}, FeedCloudTagcategorysvr$StTagUserRelateName.class);
    public final PBEnumField type = PBField.initEnum(1);
    public final PBRepeatField<String> tagNames = PBField.initRepeat(PBStringField.__repeatHelper__);
}
