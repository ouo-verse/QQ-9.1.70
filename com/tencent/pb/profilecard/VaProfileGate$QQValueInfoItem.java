package com.tencent.pb.profilecard;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class VaProfileGate$QQValueInfoItem extends MessageMicro<VaProfileGate$QQValueInfoItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 42, 48, 58, 66}, new String[]{LocalPhotoFaceInfo.SCORE, "level", "trend", "url", "on_off", "material_id", "qqvalue_ext_info"}, new Object[]{0, 0, 0, "", 0, "", null}, VaProfileGate$QQValueInfoItem.class);
    public final PBInt32Field score = PBField.initInt32(0);
    public final PBInt32Field level = PBField.initInt32(0);
    public final PBInt32Field trend = PBField.initInt32(0);
    public final PBStringField url = PBField.initString("");
    public final PBInt32Field on_off = PBField.initInt32(0);
    public final PBStringField material_id = PBField.initString("");
    public final PBRepeatMessageField<VaProfileGate$QQValueExtInfo> qqvalue_ext_info = PBField.initRepeatMessage(VaProfileGate$QQValueExtInfo.class);
}
