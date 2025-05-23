package com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_info;

import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECOrderInfo$LabelInfo extends MessageMicro<ECOrderInfo$LabelInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48, 58, 66, 72, 82}, new String[]{"background_color", "text_color", "text", "pic_url", "width", "height", "pic_token", "text_prefix", "text_style_type", LayoutAttrDefine.BorderColor}, new Object[]{"", "", "", "", 0, 0, "", "", 0, ""}, ECOrderInfo$LabelInfo.class);
    public final PBStringField background_color = PBField.initString("");
    public final PBStringField text_color = PBField.initString("");
    public final PBStringField text = PBField.initString("");
    public final PBStringField text_prefix = PBField.initString("");
    public final PBUInt32Field text_style_type = PBField.initUInt32(0);
    public final PBStringField border_color = PBField.initString("");
    public final PBStringField pic_url = PBField.initString("");
    public final PBInt32Field width = PBField.initInt32(0);
    public final PBInt32Field height = PBField.initInt32(0);
    public final PBStringField pic_token = PBField.initString("");
}
