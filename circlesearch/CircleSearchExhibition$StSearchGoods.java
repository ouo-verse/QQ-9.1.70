package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$StSearchGoods extends MessageMicro<CircleSearchExhibition$StSearchGoods> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 82}, new String[]{"title", "items", "more", "ext_info"}, new Object[]{"", null, "", null}, CircleSearchExhibition$StSearchGoods.class);
    public final PBStringField title = PBField.initString("");
    public final PBRepeatMessageField<CircleSearchExhibition$StSearchSmallItem> items = PBField.initRepeatMessage(CircleSearchExhibition$StSearchSmallItem.class);
    public final PBStringField more = PBField.initString("");
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
}
