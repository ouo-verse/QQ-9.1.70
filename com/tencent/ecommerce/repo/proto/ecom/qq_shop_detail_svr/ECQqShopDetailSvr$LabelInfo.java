package com.tencent.ecommerce.repo.proto.ecom.qq_shop_detail_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQqShopDetailSvr$LabelInfo extends MessageMicro<ECQqShopDetailSvr$LabelInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"background_color", "text_color", "text", "pic_url"}, new Object[]{"", "", "", ""}, ECQqShopDetailSvr$LabelInfo.class);
    public final PBStringField background_color = PBField.initString("");
    public final PBStringField text_color = PBField.initString("");
    public final PBStringField text = PBField.initString("");
    public final PBStringField pic_url = PBField.initString("");
}
