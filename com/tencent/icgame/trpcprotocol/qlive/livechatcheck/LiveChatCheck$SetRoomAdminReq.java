package com.tencent.icgame.trpcprotocol.qlive.livechatcheck;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveChatCheck$SetRoomAdminReq extends MessageMicro<LiveChatCheck$SetRoomAdminReq> {
    public static final int ADMIN_TINYID_FIELD_NUMBER = 4;
    public static final int ADMIN_UIN_FIELD_NUMBER = 3;
    public static final int CLIENT_TYPE_FIELD_NUMBER = 7;
    public static final int MASTER_TINYID_FIELD_NUMBER = 2;
    public static final int MASTER_UIN_FIELD_NUMBER = 1;
    public static final int RIGHTS_MASK_FIELD_NUMBER = 6;
    public static final int ROOM_ID_FIELD_NUMBER = 8;
    public static final int SET_ADMIN_FIELD_NUMBER = 5;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64}, new String[]{"master_uin", "master_tinyid", "admin_uin", "admin_tinyid", "set_admin", "rights_mask", AudienceReportConst.CLIENT_TYPE, AudienceReportConst.ROOM_ID}, new Object[]{0L, 0L, 0L, 0L, Boolean.FALSE, 0L, 0, 0L}, LiveChatCheck$SetRoomAdminReq.class);
    public final PBUInt64Field master_uin = PBField.initUInt64(0);
    public final PBUInt64Field master_tinyid = PBField.initUInt64(0);
    public final PBUInt64Field admin_uin = PBField.initUInt64(0);
    public final PBUInt64Field admin_tinyid = PBField.initUInt64(0);
    public final PBBoolField set_admin = PBField.initBool(false);
    public final PBUInt64Field rights_mask = PBField.initUInt64(0);
    public final PBUInt32Field client_type = PBField.initUInt32(0);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
}
