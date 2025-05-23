package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudTagcategorysvr$StTagCategoryInfoReq extends MessageMicro<FeedCloudTagcategorysvr$StTagCategoryInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"TagNames", "ReqType", "appID"}, new Object[]{"", 0, 0}, FeedCloudTagcategorysvr$StTagCategoryInfoReq.class);
    public final PBRepeatField<String> TagNames = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBEnumField ReqType = PBField.initEnum(0);
    public final PBInt32Field appID = PBField.initInt32(0);
}
