package com.tencent.qzone.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class QZoneOfficialAccountBase$BottomMenu extends MessageMicro<QZoneOfficialAccountBase$BottomMenu> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"menu_list"}, new Object[]{null}, QZoneOfficialAccountBase$BottomMenu.class);
    public final PBRepeatMessageField<QZoneOfficialAccountBase$MenuItem> menu_list = PBField.initRepeatMessage(QZoneOfficialAccountBase$MenuItem.class);
}
