package com.tencent.pb.profilecard;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class VaProfileGate$GetSplendidRsp extends MessageMicro<VaProfileGate$GetSplendidRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField is_gray = PBField.initBool(false);
    public final PBBoolField is_on = PBField.initBool(false);
    public final PBRepeatMessageField<VaProfileGate$SplendidItem> splendid_list = PBField.initRepeatMessage(VaProfileGate$SplendidItem.class);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBUInt32Field value_n = PBField.initUInt32(0);
    public final PBStringField jump_url = PBField.initString("");

    static {
        String[] strArr = {"is_gray", "is_on", "splendid_list", WidgetCacheConstellationData.NUM, "value_n", "jump_url"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 50}, strArr, new Object[]{bool, bool, null, 0, 0, ""}, VaProfileGate$GetSplendidRsp.class);
    }
}
