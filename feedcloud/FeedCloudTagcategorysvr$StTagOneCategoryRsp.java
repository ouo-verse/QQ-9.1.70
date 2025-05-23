package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudTagcategorysvr$StTagOneCategoryRsp extends MessageMicro<FeedCloudTagcategorysvr$StTagOneCategoryRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"categoryInfo", "nextPage"}, new Object[]{null, 0}, FeedCloudTagcategorysvr$StTagOneCategoryRsp.class);
    public FeedCloudTagcategorysvr$StTagCategoryInfo categoryInfo = new MessageMicro<FeedCloudTagcategorysvr$StTagCategoryInfo>() { // from class: feedcloud.FeedCloudTagcategorysvr$StTagCategoryInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"categoryName", "tagList", "nextPage"}, new Object[]{"", null, 0}, FeedCloudTagcategorysvr$StTagCategoryInfo.class);
        public final PBStringField categoryName = PBField.initString("");
        public final PBRepeatMessageField<FeedCloudMeta$StTagInfo> tagList = PBField.initRepeatMessage(FeedCloudMeta$StTagInfo.class);
        public final PBInt32Field nextPage = PBField.initInt32(0);
    };
    public final PBInt32Field nextPage = PBField.initInt32(0);
}
