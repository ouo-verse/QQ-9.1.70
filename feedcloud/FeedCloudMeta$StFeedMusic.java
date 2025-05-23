package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StFeedMusic extends MessageMicro<FeedCloudMeta$StFeedMusic> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50, 58, 64, 72, 82, 88, 98, 104, 114}, new String[]{"ID", "MID", "musicName", "scene", "cover", "playUrl", "singerName", "startPos", "endPos", "authorUser", "status", "sameMusicGuideButton", "show_mask", "bgms"}, new Object[]{0L, "", "", 0, null, "", "", 0, 0, null, 0, null, 0, null}, FeedCloudMeta$StFeedMusic.class);
    public final PBInt64Field ID = PBField.initInt64(0);
    public final PBStringField MID = PBField.initString("");
    public final PBStringField musicName = PBField.initString("");
    public final PBUInt32Field scene = PBField.initUInt32(0);
    public FeedCloudMeta$StImage cover = new FeedCloudMeta$StImage();
    public final PBStringField playUrl = PBField.initString("");
    public final PBStringField singerName = PBField.initString("");
    public final PBInt32Field startPos = PBField.initInt32(0);
    public final PBInt32Field endPos = PBField.initInt32(0);
    public FeedCloudMeta$StUser authorUser = new FeedCloudMeta$StUser();
    public final PBInt32Field status = PBField.initInt32(0);
    public FeedCloudMeta$StSameMusicGuide sameMusicGuideButton = new FeedCloudMeta$StSameMusicGuide();
    public final PBRepeatField<Integer> show_mask = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatMessageField<FeedCloudMeta$StBgm> bgms = PBField.initRepeatMessage(FeedCloudMeta$StBgm.class);
}
