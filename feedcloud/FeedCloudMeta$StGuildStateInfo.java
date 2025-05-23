package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StGuildStateInfo extends MessageMicro<FeedCloudMeta$StGuildStateInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 82}, new String[]{"guild_id", "type", "state", "jump_url", "icon_url", "around_url", "report_data"}, new Object[]{0L, 0, 0, "", "", "", ""}, FeedCloudMeta$StGuildStateInfo.class);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt32Field state = PBField.initUInt32(0);
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField icon_url = PBField.initString("");
    public final PBStringField around_url = PBField.initString("");
    public final PBStringField report_data = PBField.initString("");
}
