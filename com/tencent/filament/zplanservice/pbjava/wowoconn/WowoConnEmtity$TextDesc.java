package com.tencent.filament.zplanservice.pbjava.wowoconn;

import com.tencent.ditto.widget.DittoTextArea;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class WowoConnEmtity$TextDesc extends MessageMicro<WowoConnEmtity$TextDesc> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40, 50}, new String[]{"text", "color", "font_size", DittoTextArea.FONT_FAMILY, "font_style", "image_size"}, new Object[]{"", "", 0, "", 0, null}, WowoConnEmtity$TextDesc.class);
    public final PBStringField text = PBField.initString("");
    public final PBStringField color = PBField.initString("");
    public final PBUInt32Field font_size = PBField.initUInt32(0);
    public final PBStringField font_family = PBField.initString("");
    public final PBEnumField font_style = PBField.initEnum(0);
    public WowoConnEmtity$ImageSize image_size = new WowoConnEmtity$ImageSize();
}
