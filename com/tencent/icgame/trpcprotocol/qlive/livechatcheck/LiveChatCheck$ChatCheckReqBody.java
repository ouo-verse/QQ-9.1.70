package com.tencent.icgame.trpcprotocol.qlive.livechatcheck;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveChatCheck$ChatCheckReqBody extends MessageMicro<LiveChatCheck$ChatCheckReqBody> {
    public static final int ISADMIN_REQ_FIELD_NUMBER = 5;
    public static final int ISKICKOUT_REQ_FIELD_NUMBER = 8;
    public static final int KICKOUT_REQ_FIELD_NUMBER = 7;
    public static final int LISTADMIN_REQ_FIELD_NUMBER = 6;
    public static final int QUERY_REQ_FIELD_NUMBER = 3;
    public static final int ROOMADMIN_REQ_FIELD_NUMBER = 4;
    public static final int SET_REQ_FIELD_NUMBER = 2;
    public static final int SUBMCD_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66}, new String[]{"submcd", "set_req", "query_req", "roomadmin_req", "isadmin_req", "listadmin_req", "kickout_req", "iskickout_req"}, new Object[]{0, null, null, null, null, null, null, null}, LiveChatCheck$ChatCheckReqBody.class);
    public final PBUInt32Field submcd = PBField.initUInt32(0);
    public LiveChatCheck$SetChatStatusReq set_req = new LiveChatCheck$SetChatStatusReq();
    public LiveChatCheck$QueryChatStatusReq query_req = new LiveChatCheck$QueryChatStatusReq();
    public LiveChatCheck$SetRoomAdminReq roomadmin_req = new LiveChatCheck$SetRoomAdminReq();
    public LiveChatCheck$IsRoomAdminReq isadmin_req = new LiveChatCheck$IsRoomAdminReq();
    public LiveChatCheck$ListRoomAdminReq listadmin_req = new MessageMicro<LiveChatCheck$ListRoomAdminReq>() { // from class: com.tencent.icgame.trpcprotocol.qlive.livechatcheck.LiveChatCheck$ListRoomAdminReq
        public static final int MASTER_TINYID_FIELD_NUMBER = 2;
        public static final int MASTER_UIN_FIELD_NUMBER = 1;
        public static final int ROOM_ID_FIELD_NUMBER = 3;
        public static final int STATE_FIELD_NUMBER = 4;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"master_uin", "master_tinyid", AudienceReportConst.ROOM_ID, "state"}, new Object[]{0L, 0L, 0L, 0}, LiveChatCheck$ListRoomAdminReq.class);
        public final PBUInt64Field master_uin = PBField.initUInt64(0);
        public final PBUInt64Field master_tinyid = PBField.initUInt64(0);
        public final PBUInt64Field room_id = PBField.initUInt64(0);
        public final PBUInt32Field state = PBField.initUInt32(0);
    };
    public LiveChatCheck$KickOutSomebodyReq kickout_req = new LiveChatCheck$KickOutSomebodyReq();
    public LiveChatCheck$IsKickOutReq iskickout_req = new MessageMicro<LiveChatCheck$IsKickOutReq>() { // from class: com.tencent.icgame.trpcprotocol.qlive.livechatcheck.LiveChatCheck$IsKickOutReq
        public static final int MASTER_TINYID_FIELD_NUMBER = 2;
        public static final int ROOMID_FIELD_NUMBER = 1;
        public static final int TARGET_TINYID_FIELD_NUMBER = 4;
        public static final int TARGET_UIN_FIELD_NUMBER = 3;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"roomid", "master_tinyid", "target_uin", "target_tinyid"}, new Object[]{0L, 0L, 0L, 0L}, LiveChatCheck$IsKickOutReq.class);
        public final PBUInt64Field roomid = PBField.initUInt64(0);
        public final PBUInt64Field master_tinyid = PBField.initUInt64(0);
        public final PBUInt64Field target_uin = PBField.initUInt64(0);
        public final PBUInt64Field target_tinyid = PBField.initUInt64(0);
    };
}
