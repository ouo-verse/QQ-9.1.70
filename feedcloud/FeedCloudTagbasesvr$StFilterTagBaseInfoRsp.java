package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudTagbasesvr$StFilterTagBaseInfoRsp extends MessageMicro<FeedCloudTagbasesvr$StFilterTagBaseInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"filteredTags"}, new Object[]{null}, FeedCloudTagbasesvr$StFilterTagBaseInfoRsp.class);
    public final PBRepeatMessageField<FeedCloudTagbasesvr$StTagBaseInfo> filteredTags = PBField.initRepeatMessage(FeedCloudTagbasesvr$StTagBaseInfo.class);
}
