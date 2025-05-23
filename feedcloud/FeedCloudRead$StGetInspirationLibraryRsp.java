package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetInspirationLibraryRsp extends MessageMicro<FeedCloudRead$StGetInspirationLibraryRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"tagList", "recommendIconUrl"}, new Object[]{null, ""}, FeedCloudRead$StGetInspirationLibraryRsp.class);
    public final PBRepeatMessageField<FeedCloudMeta$StTagInfo> tagList = PBField.initRepeatMessage(FeedCloudMeta$StTagInfo.class);
    public final PBStringField recommendIconUrl = PBField.initString("");
}
