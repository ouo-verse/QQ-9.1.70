package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* loaded from: classes.dex */
public final class CircleSearchExhibition$StSearchPublisher extends MessageMicro<CircleSearchExhibition$StSearchPublisher> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 82}, new String[]{"items", "ext_info"}, new Object[]{null, null}, CircleSearchExhibition$StSearchPublisher.class);
    public final PBRepeatMessageField<CircleSearchExhibition$StSearchSmallItem> items = PBField.initRepeatMessage(CircleSearchExhibition$StSearchSmallItem.class);
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
}
