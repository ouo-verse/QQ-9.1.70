package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StSearchGoods extends MessageMicro<FeedCloudRead$StSearchGoods> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 82}, new String[]{"title", "items", "more", "ext_info"}, new Object[]{"", null, "", null}, FeedCloudRead$StSearchGoods.class);
    public final PBStringField title = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudRead$StSearchSmallItem> items = PBField.initRepeatMessage(FeedCloudRead$StSearchSmallItem.class);
    public final PBStringField more = PBField.initString("");
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
}
