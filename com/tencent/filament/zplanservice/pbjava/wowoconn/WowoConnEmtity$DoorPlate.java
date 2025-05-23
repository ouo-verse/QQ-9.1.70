package com.tencent.filament.zplanservice.pbjava.wowoconn;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes6.dex */
public final class WowoConnEmtity$DoorPlate extends MessageMicro<WowoConnEmtity$DoorPlate> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"icon_res", "text_bg_res", "doorplate_text", "icon_url"}, new Object[]{"", "", null, ""}, WowoConnEmtity$DoorPlate.class);
    public final PBStringField icon_res = PBField.initString("");
    public final PBStringField text_bg_res = PBField.initString("");
    public WowoConnEmtity$TextDesc doorplate_text = new WowoConnEmtity$TextDesc();
    public final PBStringField icon_url = PBField.initString("");
}
