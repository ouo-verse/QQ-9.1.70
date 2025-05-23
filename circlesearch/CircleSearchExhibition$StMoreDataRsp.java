package circlesearch;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StFeed;
import qqcircle.QQCircleRead$CircleDetail;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$StMoreDataRsp extends MessageMicro<CircleSearchExhibition$StMoreDataRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 50, 58, 64}, new String[]{"ext_info", "type", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "schools", "companys", "users", "feeds", "is_end"}, new Object[]{null, 0, null, null, null, null, null, 0}, CircleSearchExhibition$StMoreDataRsp.class);
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBRepeatMessageField<CircleSearchExhibition$StExhTag> tags = PBField.initRepeatMessage(CircleSearchExhibition$StExhTag.class);
    public final PBRepeatMessageField<QQCircleRead$CircleDetail> schools = PBField.initRepeatMessage(QQCircleRead$CircleDetail.class);
    public final PBRepeatMessageField<QQCircleRead$CircleDetail> companys = PBField.initRepeatMessage(QQCircleRead$CircleDetail.class);
    public final PBRepeatMessageField<CircleSearchExhibition$StExhUser> users = PBField.initRepeatMessage(CircleSearchExhibition$StExhUser.class);
    public final PBRepeatMessageField<FeedCloudMeta$StFeed> feeds = PBField.initRepeatMessage(FeedCloudMeta$StFeed.class);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
}
