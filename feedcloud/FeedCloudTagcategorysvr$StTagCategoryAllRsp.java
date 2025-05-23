package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudTagcategorysvr$StTagCategoryAllRsp extends MessageMicro<FeedCloudTagcategorysvr$StTagCategoryAllRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"categoryList"}, new Object[]{null}, FeedCloudTagcategorysvr$StTagCategoryAllRsp.class);
    public final PBRepeatMessageField<FeedCloudTagcategorysvr$StTagCategoryInfo> categoryList = PBField.initRepeatMessage(FeedCloudTagcategorysvr$StTagCategoryInfo.class);
}
