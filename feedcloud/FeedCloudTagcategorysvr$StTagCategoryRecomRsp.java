package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudTagcategorysvr$StTagCategoryRecomRsp extends MessageMicro<FeedCloudTagcategorysvr$StTagCategoryRecomRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"tagList", "toast", "jumpURL", "recomType"}, new Object[]{null, "", "", 0}, FeedCloudTagcategorysvr$StTagCategoryRecomRsp.class);
    public final PBRepeatMessageField<FeedCloudMeta$StTagInfo> tagList = PBField.initRepeatMessage(FeedCloudMeta$StTagInfo.class);
    public final PBStringField toast = PBField.initString("");
    public final PBStringField jumpURL = PBField.initString("");
    public final PBEnumField recomType = PBField.initEnum(0);
}
