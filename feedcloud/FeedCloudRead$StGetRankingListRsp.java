package feedcloud;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqnt.chats.api.impl.ChatsRevealApiImpl;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetRankingListRsp extends MessageMicro<FeedCloudRead$StGetRankingListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 50, 56, 66, 74, 800, 808}, new String[]{"extInfo", "items", "startTime", "endTime", "busiRspData", "hostUinRank", "isActiveRank", "liteDialog", "hostNick", "cursor", PictureConst.KEY_HAS_MORE}, new Object[]{null, null, 0, 0, ByteStringMicro.EMPTY, null, 0, null, "", 0, Boolean.FALSE}, FeedCloudRead$StGetRankingListRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<FeedCloudMeta$StRankingItem> items = PBField.initRepeatMessage(FeedCloudMeta$StRankingItem.class);
    public final PBUInt32Field startTime = PBField.initUInt32(0);
    public final PBUInt32Field endTime = PBField.initUInt32(0);
    public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudMeta$StRankingItem hostUinRank = new MessageMicro<FeedCloudMeta$StRankingItem>() { // from class: feedcloud.FeedCloudMeta$StRankingItem
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 48, 56, 66}, new String[]{QCircleAlphaUserReporter.KEY_USER, "relation", LocalPhotoFaceInfo.SCORE, "grade", MessageForQCircleFeed.MSG_QCIRCLE_FEED_LEY_BUSI_DATA, "rankNo", "inTopicList", "show_info"}, new Object[]{null, null, 0L, 0, ByteStringMicro.EMPTY, 0, 0, null}, FeedCloudMeta$StRankingItem.class);
        public FeedCloudMeta$StUser user = new FeedCloudMeta$StUser();
        public FeedCloudMeta$StRelationInfo relation = new FeedCloudMeta$StRelationInfo();
        public final PBInt64Field score = PBField.initInt64(0);
        public final PBInt32Field grade = PBField.initInt32(0);
        public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBInt32Field rankNo = PBField.initInt32(0);
        public final PBInt32Field inTopicList = PBField.initInt32(0);
        public FeedCloudMeta$RankH5ShowInfo show_info = new MessageMicro<FeedCloudMeta$RankH5ShowInfo>() { // from class: feedcloud.FeedCloudMeta$RankH5ShowInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"cover_url", "feed_id", ChatsRevealApiImpl.KEY_JUMP_SCHEME}, new Object[]{"", "", ""}, FeedCloudMeta$RankH5ShowInfo.class);
            public final PBStringField cover_url = PBField.initString("");
            public final PBStringField feed_id = PBField.initString("");
            public final PBStringField jump_schema = PBField.initString("");
        };
    };
    public final PBInt32Field isActiveRank = PBField.initInt32(0);
    public FeedCloudMeta$CovenantLiteDialog liteDialog = new FeedCloudMeta$CovenantLiteDialog();
    public final PBStringField hostNick = PBField.initString("");
    public final PBInt32Field cursor = PBField.initInt32(0);
    public final PBBoolField has_more = PBField.initBool(false);
}
