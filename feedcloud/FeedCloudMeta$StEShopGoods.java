package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StEShopGoods extends MessageMicro<FeedCloudMeta$StEShopGoods> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"total", "goodsInfos", "eshopPlatformInfo"}, new Object[]{0, null, null}, FeedCloudMeta$StEShopGoods.class);
    public final PBInt32Field total = PBField.initInt32(0);
    public final PBRepeatMessageField<FeedCloudMeta$StEShopGoodsInfo> goodsInfos = PBField.initRepeatMessage(FeedCloudMeta$StEShopGoodsInfo.class);
    public FeedCloudMeta$StEShopPlatformInfo eshopPlatformInfo = new FeedCloudMeta$StEShopPlatformInfo();
}
