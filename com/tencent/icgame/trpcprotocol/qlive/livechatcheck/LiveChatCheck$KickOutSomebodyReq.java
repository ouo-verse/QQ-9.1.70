package com.tencent.icgame.trpcprotocol.qlive.livechatcheck;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveChatCheck$KickOutSomebodyReq extends MessageMicro<LiveChatCheck$KickOutSomebodyReq> {
    public static final int ADMIN_TINYID_FIELD_NUMBER = 4;
    public static final int ADMIN_UIN_FIELD_NUMBER = 3;
    public static final int CLIENT_TYPE_FIELD_NUMBER = 8;
    public static final int MASTER_TINYID_FIELD_NUMBER = 2;
    public static final int MASTER_UIN_FIELD_NUMBER = 1;
    public static final int MENU_ID_FIELD_NUMBER = 9;
    public static final int ROOM_ID_FIELD_NUMBER = 7;
    public static final int TARGET_TINYID_FIELD_NUMBER = 6;
    public static final int TARGET_UIN_FIELD_NUMBER = 5;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72}, new String[]{"master_uin", "master_tinyid", "admin_uin", "admin_tinyid", "target_uin", "target_tinyid", AudienceReportConst.ROOM_ID, AudienceReportConst.CLIENT_TYPE, "menu_id"}, new Object[]{0L, 0L, 0L, 0L, 0L, 0L, 0L, 0, 0}, LiveChatCheck$KickOutSomebodyReq.class);
    public final PBUInt64Field master_uin = PBField.initUInt64(0);
    public final PBUInt64Field master_tinyid = PBField.initUInt64(0);
    public final PBUInt64Field admin_uin = PBField.initUInt64(0);
    public final PBUInt64Field admin_tinyid = PBField.initUInt64(0);
    public final PBUInt64Field target_uin = PBField.initUInt64(0);
    public final PBUInt64Field target_tinyid = PBField.initUInt64(0);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public final PBUInt32Field client_type = PBField.initUInt32(0);
    public final PBUInt32Field menu_id = PBField.initUInt32(0);
}
