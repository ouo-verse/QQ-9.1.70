package feedcloud;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StReply extends MessageMicro<FeedCloudMeta$StReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50, 58, 64, 72, 82, 88, 96, 106, 114, 122, 128, 136, 146, 154, 162}, new String[]{"id", "postUser", WadlProxyConsts.CREATE_TIME, "content", "targetUser", MessageForQCircleFeed.MSG_QCIRCLE_FEED_LEY_BUSI_DATA, "likeInfo", "typeFlag", "modifyflag", "atUinList", "typeFlag2", "createTimeNs", "storeExtInfo", "thirdId", "targetReplyID", "sourceType", "state", "expressionInfo", "replyFeed", "replyPic"}, new Object[]{"", null, 0L, "", null, ByteStringMicro.EMPTY, null, 0, 0, "", 0, 0L, null, "", "", 0, 0, null, null, null}, FeedCloudMeta$StReply.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f398460id = PBField.initString("");
    public FeedCloudMeta$StUser postUser = new FeedCloudMeta$StUser();
    public final PBUInt64Field createTime = PBField.initUInt64(0);
    public final PBStringField content = PBField.initString("");
    public FeedCloudMeta$StUser targetUser = new FeedCloudMeta$StUser();
    public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudMeta$StLike likeInfo = new FeedCloudMeta$StLike();
    public final PBUInt32Field typeFlag = PBField.initUInt32(0);
    public final PBUInt32Field modifyflag = PBField.initUInt32(0);
    public final PBRepeatField<String> atUinList = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field typeFlag2 = PBField.initUInt32(0);
    public final PBUInt64Field createTimeNs = PBField.initUInt64(0);
    public final PBRepeatMessageField<FeedCloudCommon$Entry> storeExtInfo = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
    public final PBStringField thirdId = PBField.initString("");
    public final PBStringField targetReplyID = PBField.initString("");
    public final PBUInt32Field sourceType = PBField.initUInt32(0);
    public final PBRepeatField<Integer> state = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    public FeedCloudMeta$ExpressionInfo expressionInfo = new FeedCloudMeta$ExpressionInfo();
    public FeedCloudMeta$StFeedAbstract replyFeed = new FeedCloudMeta$StFeedAbstract();
    public FeedCloudMeta$StImage replyPic = new FeedCloudMeta$StImage();
}
