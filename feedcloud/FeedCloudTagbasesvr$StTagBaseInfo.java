package feedcloud;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudTagbasesvr$StTagBaseInfo extends MessageMicro<FeedCloudTagbasesvr$StTagBaseInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128, 136}, new String[]{"tagName", "categoryChilds", "tagChilds", "relates", "parents", "status", "type", "tagNameId", WadlProxyConsts.CREATE_TIME, "userViewYesterday", "userViewHistory", "userPublishYesterday", "userPublishHistory", "showPublishHistory", "feedPublishHistory", "updateMillTime", "categoryIndex"}, new Object[]{"", "", "", "", "", 0, 0, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L}, FeedCloudTagbasesvr$StTagBaseInfo.class);
    public final PBRepeatField<String> categoryChilds;
    public final PBInt64Field categoryIndex;
    public final PBInt64Field createTime;
    public final PBInt64Field feedPublishHistory;
    public final PBRepeatField<String> parents;
    public final PBRepeatField<String> relates;
    public final PBInt64Field showPublishHistory;
    public final PBEnumField status;
    public final PBRepeatField<String> tagChilds;
    public final PBStringField tagName = PBField.initString("");
    public final PBInt64Field tagNameId;
    public final PBEnumField type;
    public final PBInt64Field updateMillTime;
    public final PBInt64Field userPublishHistory;
    public final PBInt64Field userPublishYesterday;
    public final PBInt64Field userViewHistory;
    public final PBInt64Field userViewYesterday;

    public FeedCloudTagbasesvr$StTagBaseInfo() {
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
    }
}
