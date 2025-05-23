package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$GuildDisplayInfo extends MessageMicro<FeedCloudRead$GuildDisplayInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"guildID", "guildName", "guildHead", "guildHotnessText", "joinSignature", "guildUserHeads", "schemaURL"}, new Object[]{"", "", "", "", "", "", ""}, FeedCloudRead$GuildDisplayInfo.class);
    public final PBStringField guildID = PBField.initString("");
    public final PBStringField guildName = PBField.initString("");
    public final PBStringField guildHead = PBField.initString("");
    public final PBStringField guildHotnessText = PBField.initString("");
    public final PBStringField joinSignature = PBField.initString("");
    public final PBRepeatField<String> guildUserHeads = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField schemaURL = PBField.initString("");
}
