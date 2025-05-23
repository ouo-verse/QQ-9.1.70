package NS_MINI_AD;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MiniAppAd$SpecifiedAdsItem extends MessageMicro<MiniAppAd$SpecifiedAdsItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"aid", "creative_id", "prefetch_timestamp"}, new Object[]{0L, 0L, 0}, MiniAppAd$SpecifiedAdsItem.class);
    public final PBUInt64Field aid = PBField.initUInt64(0);
    public final PBUInt64Field creative_id = PBField.initUInt64(0);
    public final PBUInt32Field prefetch_timestamp = PBField.initUInt32(0);
}
