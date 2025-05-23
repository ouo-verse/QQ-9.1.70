package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudTagcategorysvr$StTagOneCategoryReq extends MessageMicro<FeedCloudTagcategorysvr$StTagOneCategoryReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"categoryName", "reqPage"}, new Object[]{"", 0}, FeedCloudTagcategorysvr$StTagOneCategoryReq.class);
    public final PBStringField categoryName = PBField.initString("");
    public final PBInt32Field reqPage = PBField.initInt32(0);
}
