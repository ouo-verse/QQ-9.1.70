package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudTagbasesvr$StCategoryFilter extends MessageMicro<FeedCloudTagbasesvr$StCategoryFilter> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40}, new String[]{"tagCategory", "pageSize", "pageCurrent", "sort", "sortType"}, new Object[]{"", 0, 0, 0, 0}, FeedCloudTagbasesvr$StCategoryFilter.class);
    public final PBStringField tagCategory = PBField.initString("");
    public final PBInt32Field pageSize = PBField.initInt32(0);
    public final PBInt32Field pageCurrent = PBField.initInt32(0);
    public final PBEnumField sort = PBField.initEnum(0);
    public final PBEnumField sortType = PBField.initEnum(0);
}
