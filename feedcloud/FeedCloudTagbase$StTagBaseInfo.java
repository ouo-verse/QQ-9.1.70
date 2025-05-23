package feedcloud;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudTagbase$StTagBaseInfo extends MessageMicro<FeedCloudTagbase$StTagBaseInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128, 136, 146, 152, 160, 168, 176, 184, 192, 200, 208, 216, 226, 232, 242, 250}, new String[]{"tagName", "categoryChilds", "tagChilds", "relates", "parents", "status", "type", "tagNameId", WadlProxyConsts.CREATE_TIME, "userViewYesterday", "userViewHistory", "userPublishYesterday", "userPublishHistory", "showPublishHistory", "feedPublishHistory", "updateMillTime", "categoryIndex", "optInfo", "isRecommend", "userLikeYesterday", "userLikeHistory", "userCmtYesterday", "userCmtHistory", "userPushYesterday", "userPushHistory", "exposureCountImmediate", "publishCountImmediate", "tagId", "nature", "tabId", "yuhengTagConfig"}, new Object[]{"", "", "", "", "", 0, 0, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, "", 0, "", null}, FeedCloudTagbase$StTagBaseInfo.class);
    public final PBRepeatField<String> categoryChilds;
    public final PBInt64Field categoryIndex;
    public final PBInt64Field createTime;
    public final PBInt64Field exposureCountImmediate;
    public final PBInt64Field feedPublishHistory;
    public final PBInt32Field isRecommend;
    public final PBEnumField nature;
    public FeedCloudMeta$StTagOperateInfo optInfo;
    public final PBRepeatField<String> parents;
    public final PBInt64Field publishCountImmediate;
    public final PBRepeatField<String> relates;
    public final PBInt64Field showPublishHistory;
    public final PBEnumField status;
    public final PBStringField tabId;
    public final PBRepeatField<String> tagChilds;
    public final PBStringField tagId;
    public final PBStringField tagName = PBField.initString("");
    public final PBInt64Field tagNameId;
    public final PBEnumField type;
    public final PBInt64Field updateMillTime;
    public final PBInt64Field userCmtHistory;
    public final PBInt64Field userCmtYesterday;
    public final PBInt64Field userLikeHistory;
    public final PBInt64Field userLikeYesterday;
    public final PBInt64Field userPublishHistory;
    public final PBInt64Field userPublishYesterday;
    public final PBInt64Field userPushHistory;
    public final PBInt64Field userPushYesterday;
    public final PBInt64Field userViewHistory;
    public final PBInt64Field userViewYesterday;
    public FeedCloudTagbase$YuhengTagOperateConfig yuhengTagConfig;

    /* JADX WARN: Type inference failed for: r0v2, types: [feedcloud.FeedCloudTagbase$YuhengTagOperateConfig] */
    public FeedCloudTagbase$StTagBaseInfo() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.categoryChilds = PBField.initRepeat(pBStringField);
        this.tagChilds = PBField.initRepeat(pBStringField);
        this.relates = PBField.initRepeat(pBStringField);
        this.parents = PBField.initRepeat(pBStringField);
        this.status = PBField.initEnum(0);
        this.type = PBField.initEnum(0);
        this.tagNameId = PBField.initInt64(0L);
        this.createTime = PBField.initInt64(0L);
        this.userViewYesterday = PBField.initInt64(0L);
        this.userViewHistory = PBField.initInt64(0L);
        this.userPublishYesterday = PBField.initInt64(0L);
        this.userPublishHistory = PBField.initInt64(0L);
        this.showPublishHistory = PBField.initInt64(0L);
        this.feedPublishHistory = PBField.initInt64(0L);
        this.updateMillTime = PBField.initInt64(0L);
        this.categoryIndex = PBField.initInt64(0L);
        this.optInfo = new FeedCloudMeta$StTagOperateInfo();
        this.isRecommend = PBField.initInt32(0);
        this.userLikeYesterday = PBField.initInt64(0L);
        this.userLikeHistory = PBField.initInt64(0L);
        this.userCmtYesterday = PBField.initInt64(0L);
        this.userCmtHistory = PBField.initInt64(0L);
        this.userPushYesterday = PBField.initInt64(0L);
        this.userPushHistory = PBField.initInt64(0L);
        this.exposureCountImmediate = PBField.initInt64(0L);
        this.publishCountImmediate = PBField.initInt64(0L);
        this.tagId = PBField.initString("");
        this.nature = PBField.initEnum(0);
        this.tabId = PBField.initString("");
        this.yuhengTagConfig = new MessageMicro<FeedCloudTagbase$YuhengTagOperateConfig>() { // from class: feedcloud.FeedCloudTagbase$YuhengTagOperateConfig
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"aggregatePageButtonType"}, new Object[]{0}, FeedCloudTagbase$YuhengTagOperateConfig.class);
            public final PBInt32Field aggregatePageButtonType = PBField.initInt32(0);
        };
    }
}
