package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudMeta$StPromoteInfo extends MessageMicro<FeedCloudMeta$StPromoteInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"usePromoteTicket", "ticketJumpUrl", "ticketID"}, new Object[]{Boolean.FALSE, "", ""}, FeedCloudMeta$StPromoteInfo.class);
    public final PBBoolField usePromoteTicket = PBField.initBool(false);
    public final PBStringField ticketJumpUrl = PBField.initString("");
    public final PBStringField ticketID = PBField.initString("");
}
