package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudTagbasesvr$StEditTagBaseInfoRsp extends MessageMicro<FeedCloudTagbasesvr$StEditTagBaseInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"editInfos"}, new Object[]{null}, FeedCloudTagbasesvr$StEditTagBaseInfoRsp.class);
    public final PBRepeatMessageField<FeedCloudTagbasesvr$StEditTagInfo> editInfos = PBField.initRepeatMessage(FeedCloudTagbasesvr$StEditTagInfo.class);
}
