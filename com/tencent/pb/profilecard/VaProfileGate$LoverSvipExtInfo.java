package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class VaProfileGate$LoverSvipExtInfo extends MessageMicro<VaProfileGate$LoverSvipExtInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"iIconType", "sMaterialId", "sDiyContents"}, new Object[]{0, "", ""}, VaProfileGate$LoverSvipExtInfo.class);
    public final PBInt32Field iIconType = PBField.initInt32(0);
    public final PBStringField sMaterialId = PBField.initString("");
    public final PBRepeatField<String> sDiyContents = PBField.initRepeat(PBStringField.__repeatHelper__);
}
