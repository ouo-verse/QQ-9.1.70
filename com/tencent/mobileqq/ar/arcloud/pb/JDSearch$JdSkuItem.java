package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class JDSearch$JdSkuItem extends MessageMicro<JDSearch$JdSkuItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"detail_url", "image_url", "sku_id", "sku_name", "sku_price"}, new Object[]{"", "", "", "", ""}, JDSearch$JdSkuItem.class);
    public final PBStringField detail_url = PBField.initString("");
    public final PBStringField image_url = PBField.initString("");
    public final PBStringField sku_id = PBField.initString("");
    public final PBStringField sku_name = PBField.initString("");
    public final PBStringField sku_price = PBField.initString("");
}
