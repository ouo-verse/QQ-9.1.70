package com.tencent.icgame.trpcprotocol.qlive.livechatcheck;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveChatCheck$IsRoomAdminReq extends MessageMicro<LiveChatCheck$IsRoomAdminReq> {
    public static final int ADMIN_TINYID_FIELD_NUMBER = 4;
    public static final int ADMIN_UIN_FIELD_NUMBER = 3;
    public static final int MASTER_TINYID_FIELD_NUMBER = 2;
    public static final int MASTER_UIN_FIELD_NUMBER = 1;
    public static final int ROOM_ID_FIELD_NUMBER = 5;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"master_uin", "master_tinyid", "admin_uin", "admin_tinyid", AudienceReportConst.ROOM_ID}, new Object[]{0L, 0L, 0L, 0L, 0L}, LiveChatCheck$IsRoomAdminReq.class);
    public final PBUInt64Field master_uin = PBField.initUInt64(0);
    public final PBUInt64Field master_tinyid = PBField.initUInt64(0);
    public final PBUInt64Field admin_uin = PBField.initUInt64(0);
    public final PBUInt64Field admin_tinyid = PBField.initUInt64(0);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
}
