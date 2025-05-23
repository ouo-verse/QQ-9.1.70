package feedcloud;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudUsersettings$GetUsersettingsRsp extends MessageMicro<FeedCloudUsersettings$GetUsersettingsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"result", WidgetCacheConstellationData.INTERVAL, "msgs", "attachInfos"}, new Object[]{null, null, null, null}, FeedCloudUsersettings$GetUsersettingsRsp.class);
    public FeedCloudUsersettings$Result result = new MessageMicro<FeedCloudUsersettings$Result>() { // from class: feedcloud.FeedCloudUsersettings$Result
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"retCode", "msg"}, new Object[]{0, ""}, FeedCloudUsersettings$Result.class);
        public final PBInt32Field retCode = PBField.initInt32(0);

        /* renamed from: msg, reason: collision with root package name */
        public final PBStringField f398478msg = PBField.initString("");
    };
    public FeedCloudUsersettings$Interval interval = new FeedCloudUsersettings$Interval();
    public final PBRepeatMessageField<FeedCloudUsersettings$SettingsInfo> msgs = PBField.initRepeatMessage(FeedCloudUsersettings$SettingsInfo.class);
    public final PBRepeatMessageField<FeedCloudUsersettings$Entry> attachInfos = PBField.initRepeatMessage(FeedCloudUsersettings$Entry.class);
}
