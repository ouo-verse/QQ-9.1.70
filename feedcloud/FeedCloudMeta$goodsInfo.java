package feedcloud;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$goodsInfo extends MessageMicro<FeedCloudMeta$goodsInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50, 58, 64, 74, 82, 88, 98}, new String[]{"isGoodsCmt", "goodsID", "goodsType", "goodsURL", "media_product_id", "saas_product_id", "product_type", WadlProxyConsts.CHANNEL, PictureConst.KEY_CATEGORY_ID, "category_name", "real_goods_type", "original_url"}, new Object[]{0, "", 0, "", "", "", "", 0, "", "", 0, ""}, FeedCloudMeta$goodsInfo.class);
    public final PBUInt32Field isGoodsCmt = PBField.initUInt32(0);
    public final PBStringField goodsID = PBField.initString("");
    public final PBUInt32Field goodsType = PBField.initUInt32(0);
    public final PBStringField goodsURL = PBField.initString("");
    public final PBStringField media_product_id = PBField.initString("");
    public final PBStringField saas_product_id = PBField.initString("");
    public final PBStringField product_type = PBField.initString("");
    public final PBUInt32Field channel = PBField.initUInt32(0);
    public final PBStringField category_id = PBField.initString("");
    public final PBStringField category_name = PBField.initString("");
    public final PBUInt32Field real_goods_type = PBField.initUInt32(0);
    public final PBStringField original_url = PBField.initString("");
}
