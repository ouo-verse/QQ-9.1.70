package feedcloud;

import com.tencent.luggage.wxa.uf.n;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StTagInfo extends MessageMicro<FeedCloudMeta$StTagInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 56, 66, 72, 80, 90, 96, 104, 112, 122, 128, 138, 144, 152, 160, 170, 178, 186, 192, n.CTRL_INDEX, 802}, new String[]{"tagId", "tagName", "tagDec", "userList", "feedList", "tagTotalUser", "tagTotalFeed", "tagWording", "tagType", "followState", "shareInfo", "isTop", "isSelected", "userViewHistory", "medal", "status", "optInfo", "tagBaseStatus", "isRecommend", "tagViewHistory", "operateIconUrl", "tagChallengeData", "busiReport", "nature", "tagReport", "tagIconUrl"}, new Object[]{"", "", "", null, null, 0, 0, "", 0, 0, null, 0, 0, 0L, null, 0, null, 0, 0, 0L, "", null, ByteStringMicro.EMPTY, 0, "", ""}, FeedCloudMeta$StTagInfo.class);
    public final PBStringField tagId = PBField.initString("");
    public final PBStringField tagName = PBField.initString("");
    public final PBStringField tagDec = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudMeta$StUser> userList = PBField.initRepeatMessage(FeedCloudMeta$StUser.class);
    public final PBRepeatMessageField<FeedCloudMeta$StFeedAbstract> feedList = PBField.initRepeatMessage(FeedCloudMeta$StFeedAbstract.class);
    public final PBUInt32Field tagTotalUser = PBField.initUInt32(0);
    public final PBUInt32Field tagTotalFeed = PBField.initUInt32(0);
    public final PBStringField tagWording = PBField.initString("");
    public final PBUInt32Field tagType = PBField.initUInt32(0);
    public final PBUInt32Field followState = PBField.initUInt32(0);
    public FeedCloudMeta$StShare shareInfo = new FeedCloudMeta$StShare();
    public final PBUInt32Field isTop = PBField.initUInt32(0);
    public final PBUInt32Field isSelected = PBField.initUInt32(0);
    public final PBInt64Field userViewHistory = PBField.initInt64(0);
    public FeedCloudMeta$StTagMedalInfo medal = new FeedCloudMeta$StTagMedalInfo();
    public final PBUInt32Field status = PBField.initUInt32(0);
    public FeedCloudMeta$StTagOperateInfo optInfo = new FeedCloudMeta$StTagOperateInfo();
    public final PBUInt32Field tagBaseStatus = PBField.initUInt32(0);
    public final PBInt32Field isRecommend = PBField.initInt32(0);
    public final PBInt64Field tagViewHistory = PBField.initInt64(0);
    public final PBStringField operateIconUrl = PBField.initString("");
    public FeedCloudMeta$StTagChallenge tagChallengeData = new FeedCloudMeta$StTagChallenge();
    public final PBBytesField busiReport = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field nature = PBField.initUInt32(0);
    public final PBStringField tagReport = PBField.initString("");
    public final PBStringField tagIconUrl = PBField.initString("");
}
