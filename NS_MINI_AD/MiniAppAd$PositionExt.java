package NS_MINI_AD;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes.dex */
public final class MiniAppAd$PositionExt extends MessageMicro<MiniAppAd$PositionExt> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42}, new String[]{"share_info", "deep_link_version", "get_ad_type", "specified_ads", "sub_position_id"}, new Object[]{null, 0, 0, null, ""}, MiniAppAd$PositionExt.class);
    public MiniAppAd$ShareInfo share_info = new MiniAppAd$ShareInfo();
    public final PBUInt32Field deep_link_version = PBField.initUInt32(0);
    public final PBEnumField get_ad_type = PBField.initEnum(0);
    public final PBRepeatMessageField<MiniAppAd$SpecifiedAdsItem> specified_ads = PBField.initRepeatMessage(MiniAppAd$SpecifiedAdsItem.class);
    public final PBStringField sub_position_id = PBField.initString("");
}
