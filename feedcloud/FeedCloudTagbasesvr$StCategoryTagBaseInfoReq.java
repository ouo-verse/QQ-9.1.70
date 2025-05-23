package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudTagbasesvr$StCategoryTagBaseInfoReq extends MessageMicro<FeedCloudTagbasesvr$StCategoryTagBaseInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"filters", "search"}, new Object[]{null, ""}, FeedCloudTagbasesvr$StCategoryTagBaseInfoReq.class);
    public final PBRepeatMessageField<FeedCloudTagbasesvr$StCategoryFilter> filters = PBField.initRepeatMessage(FeedCloudTagbasesvr$StCategoryFilter.class);
    public final PBStringField search = PBField.initString("");
}
