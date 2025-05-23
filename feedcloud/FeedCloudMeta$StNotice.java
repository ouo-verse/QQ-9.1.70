package feedcloud;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StNotice extends MessageMicro<FeedCloudMeta$StNotice> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiData;
    public final PBBytesField busiReport;
    public FeedCloudMeta$StFollowRecomInfo followRecom;
    public FeedCloudMeta$StImage image;
    public final PBStringField message;
    public final PBRepeatField<Integer> opMask;
    public final PBStringField subMessage;
    public final PBStringField summary;
    public final PBStringField title;
    public final PBStringField typeName;
    public final PBRepeatMessageField<FeedCloudMeta$StUser> vecUser;
    public final PBStringField feedId = PBField.initString("");
    public final PBUInt32Field noticeType = PBField.initUInt32(0);
    public final PBUInt64Field createTime = PBField.initUInt64(0);
    public FeedCloudMeta$StOperation operation = new FeedCloudMeta$StOperation();
    public FeedCloudMeta$StFeed feed = new FeedCloudMeta$StFeed();

    static {
        String[] strArr = {"feedId", "noticeType", WadlProxyConsts.CREATE_TIME, QCircleDaTongConstant.ElementParamValue.OPERATION, "feed", MessageForQCircleFeed.MSG_QCIRCLE_FEED_LEY_BUSI_DATA, "message", "vecUser", "subMessage", "summary", "busiReport", "opMask", "typeName", "title", "followRecom", "image"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 50, 58, 66, 74, 82, 90, 96, 106, 114, 122, 130}, strArr, new Object[]{"", 0, 0L, null, null, byteStringMicro, "", null, "", "", byteStringMicro, 0, "", "", null, null}, FeedCloudMeta$StNotice.class);
    }

    public FeedCloudMeta$StNotice() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.busiData = PBField.initBytes(byteStringMicro);
        this.message = PBField.initString("");
        this.vecUser = PBField.initRepeatMessage(FeedCloudMeta$StUser.class);
        this.subMessage = PBField.initString("");
        this.summary = PBField.initString("");
        this.busiReport = PBField.initBytes(byteStringMicro);
        this.opMask = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
        this.typeName = PBField.initString("");
        this.title = PBField.initString("");
        this.followRecom = new FeedCloudMeta$StFollowRecomInfo();
        this.image = new FeedCloudMeta$StImage();
    }
}
