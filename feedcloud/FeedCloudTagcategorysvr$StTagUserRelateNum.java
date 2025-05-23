package feedcloud;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudTagcategorysvr$StTagUserRelateNum extends MessageMicro<FeedCloudTagcategorysvr$StTagUserRelateNum> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"type", WidgetCacheConstellationData.NUM}, new Object[]{1, 0}, FeedCloudTagcategorysvr$StTagUserRelateNum.class);
    public final PBEnumField type = PBField.initEnum(1);
    public final PBInt32Field num = PBField.initInt32(0);
}
