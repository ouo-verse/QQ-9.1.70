package com.tencent.qzone.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class QZoneOfficialAccount$GetMessageListRsp extends MessageMicro<QZoneOfficialAccount$GetMessageListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42}, new String[]{"ext_info", "message_list", "attach_info", "is_finish", "bottom_menu"}, new Object[]{null, null, "", Boolean.FALSE, null}, QZoneOfficialAccount$GetMessageListRsp.class);
    public QZoneBase$CommonExt ext_info = new QZoneBase$CommonExt();
    public final PBRepeatMessageField<QZoneOfficialAccountBase$Message> message_list = PBField.initRepeatMessage(QZoneOfficialAccountBase$Message.class);
    public final PBStringField attach_info = PBField.initString("");
    public final PBBoolField is_finish = PBField.initBool(false);
    public QZoneOfficialAccountBase$BottomMenu bottom_menu = new QZoneOfficialAccountBase$BottomMenu();
}
