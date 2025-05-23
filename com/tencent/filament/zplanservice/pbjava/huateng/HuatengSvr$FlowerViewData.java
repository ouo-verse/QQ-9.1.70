package com.tencent.filament.zplanservice.pbjava.huateng;

import com.tencent.filament.zplanservice.pbjava.wowoconn.WowoConnEmtity$TextDesc;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class HuatengSvr$FlowerViewData extends MessageMicro<HuatengSvr$FlowerViewData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"field_res", "flower_res", "msg_res", "bubbles"}, new Object[]{"", "", "", null}, HuatengSvr$FlowerViewData.class);
    public final PBStringField field_res = PBField.initString("");
    public final PBStringField flower_res = PBField.initString("");
    public final PBStringField msg_res = PBField.initString("");
    public final PBRepeatMessageField<WowoConnEmtity$TextDesc> bubbles = PBField.initRepeatMessage(WowoConnEmtity$TextDesc.class);
}
