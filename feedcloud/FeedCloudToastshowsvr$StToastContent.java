package feedcloud;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudToastshowsvr$StToastContent extends MessageMicro<FeedCloudToastshowsvr$StToastContent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50, 58, 66, 74, 82}, new String[]{"title", "content", QCircleAlphaUserReporter.KEY_USER, "jumpInfo", WadlProxyConsts.CREATE_TIME, "cover", "closeButtonImg", "coverLayerAnimation", "rightIconAnimation", "toastBackgroundImg"}, new Object[]{"", "", null, null, 0L, null, null, null, null, null}, FeedCloudToastshowsvr$StToastContent.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public FeedCloudMeta$StUser user = new FeedCloudMeta$StUser();
    public FeedCloudToastshowsvr$StJumpInfo jumpInfo = new MessageMicro<FeedCloudToastshowsvr$StJumpInfo>() { // from class: feedcloud.FeedCloudToastshowsvr$StJumpInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"jumpType", "jumpLink"}, new Object[]{0, ""}, FeedCloudToastshowsvr$StJumpInfo.class);
        public final PBEnumField jumpType = PBField.initEnum(0);
        public final PBStringField jumpLink = PBField.initString("");
    };
    public final PBUInt64Field createTime = PBField.initUInt64(0);
    public FeedCloudMeta$StImage cover = new FeedCloudMeta$StImage();
    public FeedCloudMeta$StImage closeButtonImg = new FeedCloudMeta$StImage();
    public FeedCloudMeta$StAnimation coverLayerAnimation = new MessageMicro<FeedCloudMeta$StAnimation>() { // from class: feedcloud.FeedCloudMeta$StAnimation
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"width", "height", "animationUrl", MessageForQCircleFeed.MSG_QCIRCLE_FEED_LEY_BUSI_DATA}, new Object[]{0, 0, "", ByteStringMicro.EMPTY}, FeedCloudMeta$StAnimation.class);
        public final PBUInt32Field width = PBField.initUInt32(0);
        public final PBUInt32Field height = PBField.initUInt32(0);
        public final PBStringField animationUrl = PBField.initString("");
        public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public FeedCloudMeta$StAnimation rightIconAnimation = new MessageMicro<FeedCloudMeta$StAnimation>() { // from class: feedcloud.FeedCloudMeta$StAnimation
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"width", "height", "animationUrl", MessageForQCircleFeed.MSG_QCIRCLE_FEED_LEY_BUSI_DATA}, new Object[]{0, 0, "", ByteStringMicro.EMPTY}, FeedCloudMeta$StAnimation.class);
        public final PBUInt32Field width = PBField.initUInt32(0);
        public final PBUInt32Field height = PBField.initUInt32(0);
        public final PBStringField animationUrl = PBField.initString("");
        public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public FeedCloudToastshowsvr$StToastBackgroundImg toastBackgroundImg = new MessageMicro<FeedCloudToastshowsvr$StToastBackgroundImg>() { // from class: feedcloud.FeedCloudToastshowsvr$StToastBackgroundImg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 21}, new String[]{"backgroundImg", "cornerRadius"}, new Object[]{null, Float.valueOf(0.0f)}, FeedCloudToastshowsvr$StToastBackgroundImg.class);
        public FeedCloudMeta$StImage backgroundImg = new FeedCloudMeta$StImage();
        public final PBFloatField cornerRadius = PBField.initFloat(0.0f);
    };
}
