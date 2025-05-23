package feedcloud;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tianshu.QQCircleTianShu$RspEntry;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StLiteBanner extends MessageMicro<FeedCloudMeta$StLiteBanner> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField jumpAuth;
    public final PBBytesField original_ad;
    public final PBStringField thumbURL;
    public final PBRepeatMessageField<FeedCloudMeta$StUser> vecUser;
    public FeedCloudMeta$StImage icon = new FeedCloudMeta$StImage();
    public final PBStringField title = PBField.initString("");
    public final PBStringField jumpUrl = PBField.initString("");
    public final PBStringField activityID = PBField.initString("");
    public final PBStringField jsonStyle = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudCommon$Entry> extInfo = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
    public final PBStringField summary = PBField.initString("");
    public final PBInt32Field business_type = PBField.initInt32(0);
    public final PBRepeatMessageField<FeedCloudMeta$StFeedButton> button = PBField.initRepeatMessage(FeedCloudMeta$StFeedButton.class);
    public final PBEnumField style_type = PBField.initEnum(0);
    public QQCircleTianShu$RspEntry tianshuEntry = new QQCircleTianShu$RspEntry();
    public FeedCloudMeta$StImage picture = new FeedCloudMeta$StImage();
    public FeedCloudMeta$StImage postPicture = new FeedCloudMeta$StImage();
    public final PBInt64Field stylePlayTime = PBField.initInt64(0);
    public final PBUInt32Field startActionIndex = PBField.initUInt32(0);

    static {
        String[] strArr = {"icon", "title", WadlProxyConsts.KEY_JUMP_URL, "activityID", "jsonStyle", "extInfo", "summary", "business_type", "button", "style_type", "tianshuEntry", "picture", "postPicture", "stylePlayTime", "startActionIndex", "jumpAuth", "vecUser", "original_ad", "thumbURL"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 64, 74, 80, 90, 98, 106, 112, 120, 130, 138, 146, 154}, strArr, new Object[]{null, "", "", "", "", null, "", 0, null, 0, null, null, null, 0L, 0, byteStringMicro, null, byteStringMicro, ""}, FeedCloudMeta$StLiteBanner.class);
    }

    public FeedCloudMeta$StLiteBanner() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.jumpAuth = PBField.initBytes(byteStringMicro);
        this.vecUser = PBField.initRepeatMessage(FeedCloudMeta$StUser.class);
        this.original_ad = PBField.initBytes(byteStringMicro);
        this.thumbURL = PBField.initString("");
    }
}
