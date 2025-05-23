package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$MessageInfo extends MessageMicro<FeedCloudMeta$MessageInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 58}, new String[]{"msgTime", "msgRandom", "msgSeq", "clientSeq", "chatType", "peerUID", "senderUID"}, new Object[]{0L, 0L, 0L, 0L, 0, "", ""}, FeedCloudMeta$MessageInfo.class);
    public final PBInt64Field msgTime = PBField.initInt64(0);
    public final PBInt64Field msgRandom = PBField.initInt64(0);
    public final PBInt64Field msgSeq = PBField.initInt64(0);
    public final PBInt64Field clientSeq = PBField.initInt64(0);
    public final PBInt32Field chatType = PBField.initInt32(0);
    public final PBStringField peerUID = PBField.initString("");
    public final PBStringField senderUID = PBField.initString("");
}
