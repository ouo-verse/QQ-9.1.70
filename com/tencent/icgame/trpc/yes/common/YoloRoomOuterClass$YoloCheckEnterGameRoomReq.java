package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloRoomOuterClass$YoloCheckEnterGameRoomReq extends MessageMicro<YoloRoomOuterClass$YoloCheckEnterGameRoomReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{AudienceReportConst.ROOM_ID}, new Object[]{0L}, YoloRoomOuterClass$YoloCheckEnterGameRoomReq.class);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
}
