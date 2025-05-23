package circlesearch;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StFeed;
import qqcircle.QQCircleRead$CircleDetail;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$StResultRsp extends MessageMicro<CircleSearchExhibition$StResultRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40, 50, 56, 66, 72, 82, 88, 98, 106, 114}, new String[]{"ext_info", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "tags_end", "schools", "schools_end", "companys", "companys_end", "users", "users_end", "feeds", "feeds_end", "tags_more_url", "users_more_url", "correction_info"}, new Object[]{null, null, 0, null, 0, null, 0, null, 0, null, 0, "", "", null}, CircleSearchExhibition$StResultRsp.class);
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<CircleSearchExhibition$StExhTag> tags = PBField.initRepeatMessage(CircleSearchExhibition$StExhTag.class);
    public final PBUInt32Field tags_end = PBField.initUInt32(0);
    public final PBRepeatMessageField<QQCircleRead$CircleDetail> schools = PBField.initRepeatMessage(QQCircleRead$CircleDetail.class);
    public final PBUInt32Field schools_end = PBField.initUInt32(0);
    public final PBRepeatMessageField<QQCircleRead$CircleDetail> companys = PBField.initRepeatMessage(QQCircleRead$CircleDetail.class);
    public final PBUInt32Field companys_end = PBField.initUInt32(0);
    public final PBRepeatMessageField<CircleSearchExhibition$StExhUser> users = PBField.initRepeatMessage(CircleSearchExhibition$StExhUser.class);
    public final PBUInt32Field users_end = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedCloudMeta$StFeed> feeds = PBField.initRepeatMessage(FeedCloudMeta$StFeed.class);
    public final PBUInt32Field feeds_end = PBField.initUInt32(0);
    public final PBStringField tags_more_url = PBField.initString("");
    public final PBStringField users_more_url = PBField.initString("");
    public CircleSearchExhibition$CorrectionInfo correction_info = new CircleSearchExhibition$CorrectionInfo();
}
