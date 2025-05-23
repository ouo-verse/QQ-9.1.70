package com.tencent.icgame.trpc.yes.common;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloRoomOuterClass$YoloRoomRotateMessage extends MessageMicro<YoloRoomOuterClass$YoloRoomRotateMessage> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40}, new String[]{RemoteMessageConst.MSGTYPE, "message_time", "message_tpl", "label", "show_time"}, new Object[]{0, 0, "", null, 0}, YoloRoomOuterClass$YoloRoomRotateMessage.class);
    public final PBInt32Field message_type = PBField.initInt32(0);
    public final PBUInt32Field message_time = PBField.initUInt32(0);
    public final PBStringField message_tpl = PBField.initString("");
    public final PBRepeatMessageField<YoloRoomOuterClass$RotateMessageLabel> label = PBField.initRepeatMessage(YoloRoomOuterClass$RotateMessageLabel.class);
    public final PBInt32Field show_time = PBField.initInt32(0);
}
