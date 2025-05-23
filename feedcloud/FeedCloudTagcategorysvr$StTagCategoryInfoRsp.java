package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudTagcategorysvr$StTagCategoryInfoRsp extends MessageMicro<FeedCloudTagcategorysvr$StTagCategoryInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"tagInfos"}, new Object[]{null}, FeedCloudTagcategorysvr$StTagCategoryInfoRsp.class);
    public final PBRepeatMessageField<FeedCloudMeta$StTagInfo> tagInfos = PBField.initRepeatMessage(FeedCloudMeta$StTagInfo.class);
}
