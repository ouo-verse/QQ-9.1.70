package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StExternalMedalWallInfo extends MessageMicro<FeedCloudMeta$StExternalMedalWallInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField needRedPoint = PBField.initBool(false);
    public final PBRepeatMessageField<FeedCloudMeta$StMedalInfo> medalInfos = PBField.initRepeatMessage(FeedCloudMeta$StMedalInfo.class);
    public final PBStringField medalWallJumpUrl = PBField.initString("");
    public final PBBoolField needShowEntrance = PBField.initBool(false);
    public final PBRepeatMessageField<FeedCloudMeta$StMedalInfo> myNewMedalInfos = PBField.initRepeatMessage(FeedCloudMeta$StMedalInfo.class);
    public final PBRepeatMessageField<FeedCloudMeta$StMedalInfo> officialNewMedalInfos = PBField.initRepeatMessage(FeedCloudMeta$StMedalInfo.class);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50}, new String[]{"needRedPoint", "medalInfos", "medalWallJumpUrl", "needShowEntrance", "myNewMedalInfos", "officialNewMedalInfos"}, new Object[]{bool, null, "", bool, null, null}, FeedCloudMeta$StExternalMedalWallInfo.class);
    }
}
