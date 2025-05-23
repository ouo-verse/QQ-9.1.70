package com.qwallet.protocol.Wallet.hb;

import com.heytap.databaseengine.type.DeviceType;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes3.dex */
public final class ElementPB$RegElement extends MessageMicro<ElementPB$RegElement> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50, 56, 66, 74}, new String[]{"name", "cre_id", "cre_date", "cre_type", DeviceType.DeviceCategory.MOBILE, "job", "sex", "addr", "trans"}, new Object[]{"", "", null, 0, "", "", 0, null, null}, ElementPB$RegElement.class);
    public final PBStringField name = PBField.initString("");
    public final PBStringField cre_id = PBField.initString("");
    public ElementPB$CreDate cre_date = new ElementPB$CreDate();
    public final PBEnumField cre_type = PBField.initEnum(0);
    public final PBStringField mobile = PBField.initString("");
    public final PBStringField job = PBField.initString("");
    public final PBInt32Field sex = PBField.initInt32(0);
    public ElementPB$Addr addr = new ElementPB$Addr();
    public final PBRepeatMessageField<ElementPB$TransInfo> trans = PBField.initRepeatMessage(ElementPB$TransInfo.class);
}
