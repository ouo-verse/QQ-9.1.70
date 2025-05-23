package feedcloud;

import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StVideo extends MessageMicro<FeedCloudMeta$StVideo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField fileId = PBField.initString("");
    public final PBUInt32Field fileSize = PBField.initUInt32(0);
    public final PBUInt32Field duration = PBField.initUInt32(0);
    public final PBUInt32Field width = PBField.initUInt32(0);
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBStringField playUrl = PBField.initString("");
    public final PBUInt32Field transStatus = PBField.initUInt32(0);
    public final PBUInt32Field videoPrior = PBField.initUInt32(0);
    public final PBUInt32Field videoRate = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedCloudMeta$StVideoUrl> vecVideoUrl = PBField.initRepeatMessage(FeedCloudMeta$StVideoUrl.class);
    public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field approvalStatus = PBField.initUInt32(0);
    public final PBUInt32Field videoSource = PBField.initUInt32(0);
    public final PBUInt32Field mediaQualityRank = PBField.initUInt32(0);
    public final PBFloatField mediaQualityScore = PBField.initFloat(0.0f);
    public final PBStringField videoMD5 = PBField.initString("");
    public final PBUInt32Field isQuic = PBField.initUInt32(0);
    public final PBEnumField orientation = PBField.initEnum(0);
    public final PBRepeatMessageField<FeedCloudMeta$StMaterialDataNew> materialList = PBField.initRepeatMessage(FeedCloudMeta$StMaterialDataNew.class);
    public FeedCloudMeta$StSingleVideoUrlAttachOption attachOption = new FeedCloudMeta$StSingleVideoUrlAttachOption();
    public FeedCloudMeta$StVideoAdaptInfo videoAdaptInfo = new MessageMicro<FeedCloudMeta$StVideoAdaptInfo>() { // from class: feedcloud.FeedCloudMeta$StVideoAdaptInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"audioInfo"}, new Object[]{null}, FeedCloudMeta$StVideoAdaptInfo.class);
        public FeedCloudMeta$StAudioInfo audioInfo = new MessageMicro<FeedCloudMeta$StAudioInfo>() { // from class: feedcloud.FeedCloudMeta$StAudioInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"inputI", "inputTP", "inputLRA", "inputThresh", "targetOffset"}, new Object[]{"", "", "", "", ""}, FeedCloudMeta$StAudioInfo.class);
            public final PBStringField inputI = PBField.initString("");
            public final PBStringField inputTP = PBField.initString("");
            public final PBStringField inputLRA = PBField.initString("");
            public final PBStringField inputThresh = PBField.initString("");
            public final PBStringField targetOffset = PBField.initString("");
        };
    };
    public final PBStringField videoComposeSourceInfo = PBField.initString("");
    public final PBBoolField canLowFormat = PBField.initBool(false);
    public final PBBoolField is_block = PBField.initBool(false);
    public final PBBoolField is_delete = PBField.initBool(false);

    static {
        String[] strArr = {"fileId", "fileSize", "duration", "width", "height", "playUrl", "transStatus", "videoPrior", "videoRate", "vecVideoUrl", MessageForQCircleFeed.MSG_QCIRCLE_FEED_LEY_BUSI_DATA, "approvalStatus", "videoSource", "mediaQualityRank", "mediaQualityScore", "videoMD5", "isQuic", "orientation", "materialList", "attachOption", "videoAdaptInfo", "videoComposeSourceInfo", "canLowFormat", "is_block", "is_delete"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 50, 56, 64, 72, 82, 90, 96, 104, 112, 125, 130, 136, 144, 154, 162, 170, 178, 184, 192, 200}, strArr, new Object[]{"", 0, 0, 0, 0, "", 0, 0, 0, null, ByteStringMicro.EMPTY, 0, 0, 0, Float.valueOf(0.0f), "", 0, 0, null, null, null, "", bool, bool, bool}, FeedCloudMeta$StVideo.class);
    }
}
