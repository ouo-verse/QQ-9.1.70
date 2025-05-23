package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$GuildInfo extends MessageMicro<FeedCloudRead$GuildInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"guildId", "icon", "name", "redirectText", "redirectUrl"}, new Object[]{0L, "", "", "", ""}, FeedCloudRead$GuildInfo.class);
    public final PBUInt64Field guildId = PBField.initUInt64(0);
    public final PBStringField icon = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField redirectText = PBField.initString("");
    public final PBStringField redirectUrl = PBField.initString("");
}
