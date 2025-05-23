package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StLive extends MessageMicro<FeedCloudMeta$StLive> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 56, 66, 74}, new String[]{QZoneDTLoginReporter.SCHEMA, "room", "liveExtInfo", "liveBytesExtInfo", "liveJumpButton", "liveStatusButton", "isDisplayStaticCover", "liveDisplayText", "liveStatusCornerPendent"}, new Object[]{"", null, null, null, null, null, Boolean.FALSE, "", null}, FeedCloudMeta$StLive.class);
    public final PBStringField schema = PBField.initString("");
    public FeedCloudMeta$RoomInfoData room = new FeedCloudMeta$RoomInfoData();
    public final PBRepeatMessageField<FeedCloudCommon$Entry> liveExtInfo = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
    public final PBRepeatMessageField<FeedCloudCommon$BytesEntry> liveBytesExtInfo = PBField.initRepeatMessage(FeedCloudCommon$BytesEntry.class);
    public FeedCloudMeta$StFeedButton liveJumpButton = new FeedCloudMeta$StFeedButton();
    public FeedCloudMeta$StFeedButton liveStatusButton = new FeedCloudMeta$StFeedButton();
    public final PBBoolField isDisplayStaticCover = PBField.initBool(false);
    public final PBStringField liveDisplayText = PBField.initString("");
    public FeedCloudMeta$StFeedButton liveStatusCornerPendent = new FeedCloudMeta$StFeedButton();
}
