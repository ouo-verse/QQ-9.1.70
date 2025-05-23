package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudTagbasesvr$StGetTagBaseInfoRsp extends MessageMicro<FeedCloudTagbasesvr$StGetTagBaseInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"tagBaseInfos"}, new Object[]{null}, FeedCloudTagbasesvr$StGetTagBaseInfoRsp.class);
    public final PBRepeatMessageField<FeedCloudTagbasesvr$StTagBaseInfo> tagBaseInfos = PBField.initRepeatMessage(FeedCloudTagbasesvr$StTagBaseInfo.class);
}
