package feedcloud;

import com.tencent.gamecenter.wadl.sdk.app.WadlConstant;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StTagOperateInfo extends MessageMicro<FeedCloudMeta$StTagOperateInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 56, 64, 74, 80, 88, 96, 106, 114, 120, 130, 138, 144, 152, 162, 170, 178, 186, 192, 200, 208, 216}, new String[]{"createUser", "coverURL", "desc", "backgroundURL", "bannerURL", "bannerSkipLink", "activityStartTime", "activityEndTime", "recommendReason", WadlConstant.SIGN_IS_WHITE, "beWhiteStartTime", "beWhiteEndTime", "publishSchema", "activityInfo", "recommendType", "materialInfo", "cateFilterInfos", "isSendAudit", "priorityAdvIDs", "versionLimit", "versionLink", "topicBannerResourceID", "effectTopicBannerResourceID", "isForceBidChallengeSticker", "isAutoChallenge", "isForceBidUpdateTime", "isForceBidExpire"}, new Object[]{"", "", "", "", "", "", 0L, 0L, "", 0, 0L, 0L, "", null, 0, null, null, 0, 0, "", "", "", "", 0, 0, 0L, 0}, FeedCloudMeta$StTagOperateInfo.class);
    public final PBStringField createUser = PBField.initString("");
    public final PBStringField coverURL = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBStringField backgroundURL = PBField.initString("");
    public final PBStringField bannerURL = PBField.initString("");
    public final PBStringField bannerSkipLink = PBField.initString("");
    public final PBInt64Field activityStartTime = PBField.initInt64(0);
    public final PBInt64Field activityEndTime = PBField.initInt64(0);
    public final PBStringField recommendReason = PBField.initString("");
    public final PBInt32Field isWhite = PBField.initInt32(0);
    public final PBInt64Field beWhiteStartTime = PBField.initInt64(0);
    public final PBInt64Field beWhiteEndTime = PBField.initInt64(0);
    public final PBStringField publishSchema = PBField.initString("");
    public FeedCloudMeta$ActivityInfo activityInfo = new MessageMicro<FeedCloudMeta$ActivityInfo>() { // from class: feedcloud.FeedCloudMeta$ActivityInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"isRunning", "text", "joinSchema", "activityID"}, new Object[]{Boolean.FALSE, "", "", 0L}, FeedCloudMeta$ActivityInfo.class);
        public final PBBoolField isRunning = PBField.initBool(false);
        public final PBStringField text = PBField.initString("");
        public final PBStringField joinSchema = PBField.initString("");
        public final PBInt64Field activityID = PBField.initInt64(0);
    };
    public final PBInt32Field recommendType = PBField.initInt32(0);
    public final PBRepeatMessageField<FeedCloudMeta$MaterialInfo> materialInfo = PBField.initRepeatMessage(FeedCloudMeta$MaterialInfo.class);
    public final PBRepeatMessageField<FeedCloudMeta$CateInfo> cateFilterInfos = PBField.initRepeatMessage(FeedCloudMeta$CateInfo.class);
    public final PBInt32Field isSendAudit = PBField.initInt32(0);
    public final PBRepeatField<Integer> priorityAdvIDs = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBStringField versionLimit = PBField.initString("");
    public final PBStringField versionLink = PBField.initString("");
    public final PBStringField topicBannerResourceID = PBField.initString("");
    public final PBStringField effectTopicBannerResourceID = PBField.initString("");
    public final PBInt32Field isForceBidChallengeSticker = PBField.initInt32(0);
    public final PBInt32Field isAutoChallenge = PBField.initInt32(0);
    public final PBInt64Field isForceBidUpdateTime = PBField.initInt64(0);
    public final PBInt32Field isForceBidExpire = PBField.initInt32(0);
}
