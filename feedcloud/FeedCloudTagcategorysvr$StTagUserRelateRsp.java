package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudTagcategorysvr$StTagUserRelateRsp extends MessageMicro<FeedCloudTagcategorysvr$StTagUserRelateRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"names"}, new Object[]{null}, FeedCloudTagcategorysvr$StTagUserRelateRsp.class);
    public final PBRepeatMessageField<FeedCloudTagcategorysvr$StTagUserRelateName> names = PBField.initRepeatMessage(FeedCloudTagcategorysvr$StTagUserRelateName.class);
}
