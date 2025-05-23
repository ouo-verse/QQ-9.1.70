package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StSearchTagInfo extends MessageMicro<FeedCloudRead$StSearchTagInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"tagList", "attachInfo", "isOver", "correction_info"}, new Object[]{null, "", 0, null}, FeedCloudRead$StSearchTagInfo.class);
    public final PBRepeatMessageField<FeedCloudMeta$StTagInfo> tagList = PBField.initRepeatMessage(FeedCloudMeta$StTagInfo.class);
    public final PBStringField attachInfo = PBField.initString("");
    public final PBInt32Field isOver = PBField.initInt32(0);
    public FeedCloudRead$StCorrectionInfo correction_info = new FeedCloudRead$StCorrectionInfo();
}
