package com.tencent.qzone.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class QZoneOfficialAccountBase$InnerMessage extends MessageMicro<QZoneOfficialAccountBase$InnerMessage> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"inner_msg_type", "template_type", "cell_list", "ext_info"}, new Object[]{0, 0, null, null}, QZoneOfficialAccountBase$InnerMessage.class);
    public final PBInt32Field inner_msg_type = PBField.initInt32(0);
    public final PBInt32Field template_type = PBField.initInt32(0);
    public final PBRepeatMessageField<QZoneOfficialAccountBase$AnyCell> cell_list = PBField.initRepeatMessage(QZoneOfficialAccountBase$AnyCell.class);
    public final PBRepeatMessageField<QZoneOfficialAccountBase$MapExtraInfo> ext_info = PBField.initRepeatMessage(QZoneOfficialAccountBase$MapExtraInfo.class);
}
