package com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common;

import com.qzone.component.cache.database.table.photo.PhotoQualityInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECOrderCommon$CommentMapping extends MessageMicro<ECOrderCommon$CommentMapping> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"sku_id", "comment_id", PhotoQualityInfo.QUALITY_SCORE, "logistics_score", "seller_score"}, new Object[]{"", "", 0, 0, 0}, ECOrderCommon$CommentMapping.class);
    public final PBStringField sku_id = PBField.initString("");
    public final PBStringField comment_id = PBField.initString("");
    public final PBInt32Field quality_score = PBField.initInt32(0);
    public final PBInt32Field logistics_score = PBField.initInt32(0);
    public final PBInt32Field seller_score = PBField.initInt32(0);
}
