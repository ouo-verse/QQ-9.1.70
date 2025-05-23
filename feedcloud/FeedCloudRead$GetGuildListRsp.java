package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$GetGuildListRsp extends MessageMicro<FeedCloudRead$GetGuildListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"guilds", "createUrl"}, new Object[]{null, ""}, FeedCloudRead$GetGuildListRsp.class);
    public final PBRepeatMessageField<FeedCloudRead$GuildInfo> guilds = PBField.initRepeatMessage(FeedCloudRead$GuildInfo.class);
    public final PBStringField createUrl = PBField.initString("");
}
