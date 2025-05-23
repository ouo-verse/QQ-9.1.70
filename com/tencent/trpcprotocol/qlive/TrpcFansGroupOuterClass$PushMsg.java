package com.tencent.trpcprotocol.qlive;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes27.dex */
public final class TrpcFansGroupOuterClass$PushMsg extends MessageMicro<TrpcFansGroupOuterClass$PushMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 50, 58, 64, 74}, new String[]{"uid", "nick", "anchor_uid", "anchor_nick", AudienceReportConst.ROOM_ID, "content", "icon", "fans_level", "group_name"}, new Object[]{0L, "", 0L, "", 0L, "", "", 0, ""}, TrpcFansGroupOuterClass$PushMsg.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBStringField nick = PBField.initString("");
    public final PBUInt64Field anchor_uid = PBField.initUInt64(0);
    public final PBStringField anchor_nick = PBField.initString("");
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public final PBStringField content = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBUInt32Field fans_level = PBField.initUInt32(0);
    public final PBStringField group_name = PBField.initString("");
}
