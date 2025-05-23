package com.tencent.qzone.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class QZoneOfficialAccountBase$CellBotton extends MessageMicro<QZoneOfficialAccountBase$CellBotton> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"botton_list"}, new Object[]{null}, QZoneOfficialAccountBase$CellBotton.class);
    public final PBRepeatMessageField<QZoneOfficialAccountBase$Botton> botton_list = PBField.initRepeatMessage(QZoneOfficialAccountBase$Botton.class);
}
