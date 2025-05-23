package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetPublishPageRecomTagListRsp extends MessageMicro<FeedCloudRead$StGetPublishPageRecomTagListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"tagInfos", "attachInfo", "isOver"}, new Object[]{null, "", 0}, FeedCloudRead$StGetPublishPageRecomTagListRsp.class);
    public final PBRepeatMessageField<FeedCloudMeta$StTagInfo> tagInfos = PBField.initRepeatMessage(FeedCloudMeta$StTagInfo.class);
    public final PBStringField attachInfo = PBField.initString("");
    public final PBInt32Field isOver = PBField.initInt32(0);
}
