package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class MessageOuterClass$GiftMsg extends MessageMicro<MessageOuterClass$GiftMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40, 50, 56, 66, 72, 80, 88, 96, 106, 114, 120}, new String[]{"recv_user_id", "gift_id", "total_num", "bill_no", "base_num", QZoneDTLoginReporter.SCHEMA, AudienceReportConst.ROOM_ID, "gift_name", "combo_seq", "scene_id", "gift_type", "combo_cnt", "client_str", "send_user_id_list", "gift_material_id"}, new Object[]{null, 0, 0, "", 0, "", 0L, "", 0, 0, 0, 0, "", null, 0}, MessageOuterClass$GiftMsg.class);
    public CommonOuterClass$QQUserId recv_user_id = new CommonOuterClass$QQUserId();
    public final PBInt32Field gift_id = PBField.initInt32(0);
    public final PBInt32Field total_num = PBField.initInt32(0);
    public final PBStringField bill_no = PBField.initString("");
    public final PBInt32Field base_num = PBField.initInt32(0);
    public final PBStringField schema = PBField.initString("");
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public final PBStringField gift_name = PBField.initString("");
    public final PBUInt32Field combo_seq = PBField.initUInt32(0);
    public final PBUInt32Field scene_id = PBField.initUInt32(0);
    public final PBUInt32Field gift_type = PBField.initUInt32(0);
    public final PBUInt32Field combo_cnt = PBField.initUInt32(0);
    public final PBStringField client_str = PBField.initString("");
    public final PBRepeatMessageField<CommonOuterClass$QQUserId> send_user_id_list = PBField.initRepeatMessage(CommonOuterClass$QQUserId.class);
    public final PBInt32Field gift_material_id = PBField.initInt32(0);
}
