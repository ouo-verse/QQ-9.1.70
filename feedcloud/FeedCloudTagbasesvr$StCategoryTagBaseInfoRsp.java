package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudTagbasesvr$StCategoryTagBaseInfoRsp extends MessageMicro<FeedCloudTagbasesvr$StCategoryTagBaseInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"infos"}, new Object[]{null}, FeedCloudTagbasesvr$StCategoryTagBaseInfoRsp.class);
    public final PBRepeatMessageField<FeedCloudTagbasesvr$StCategoryTag> infos = PBField.initRepeatMessage(FeedCloudTagbasesvr$StCategoryTag.class);
}
