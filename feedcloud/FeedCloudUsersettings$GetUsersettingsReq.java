package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudUsersettings$GetUsersettingsReq extends MessageMicro<FeedCloudUsersettings$GetUsersettingsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42}, new String[]{"traceid", "qua", "appID", "visitScene", "attachInfos"}, new Object[]{"", "", 0, 0, null}, FeedCloudUsersettings$GetUsersettingsReq.class);
    public final PBStringField traceid = PBField.initString("");
    public final PBStringField qua = PBField.initString("");
    public final PBEnumField appID = PBField.initEnum(0);
    public final PBEnumField visitScene = PBField.initEnum(0);
    public final PBRepeatMessageField<FeedCloudUsersettings$Entry> attachInfos = PBField.initRepeatMessage(FeedCloudUsersettings$Entry.class);
}
