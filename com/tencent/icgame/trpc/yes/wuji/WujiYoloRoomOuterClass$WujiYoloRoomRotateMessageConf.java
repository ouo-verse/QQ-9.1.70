package com.tencent.icgame.trpc.yes.wuji;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WujiYoloRoomOuterClass$WujiYoloRoomRotateMessageConf extends MessageMicro<WujiYoloRoomOuterClass$WujiYoloRoomRotateMessageConf> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"room_type", RemoteMessageConst.MSGTYPE, "message_tpl", "show_time"}, new Object[]{0, 0, "", 0}, WujiYoloRoomOuterClass$WujiYoloRoomRotateMessageConf.class);
    public final PBInt32Field room_type = PBField.initInt32(0);
    public final PBInt32Field message_type = PBField.initInt32(0);
    public final PBStringField message_tpl = PBField.initString("");
    public final PBInt32Field show_time = PBField.initInt32(0);
}
