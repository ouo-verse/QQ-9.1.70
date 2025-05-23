package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$StDoOpBypassBeatReq extends MessageMicro<FeedCloudWrite$StDoOpBypassBeatReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 66}, new String[]{"actionType", "subActionType", "feedID", "commentID", "replyID", "barrageID", "commentPosterID", "commentFeedID"}, new Object[]{0, 0, "", "", "", "", "", ""}, FeedCloudWrite$StDoOpBypassBeatReq.class);
    public final PBInt32Field actionType = PBField.initInt32(0);
    public final PBInt32Field subActionType = PBField.initInt32(0);
    public final PBStringField feedID = PBField.initString("");
    public final PBStringField commentID = PBField.initString("");
    public final PBStringField replyID = PBField.initString("");
    public final PBStringField barrageID = PBField.initString("");
    public final PBStringField commentPosterID = PBField.initString("");
    public final PBStringField commentFeedID = PBField.initString("");
}
