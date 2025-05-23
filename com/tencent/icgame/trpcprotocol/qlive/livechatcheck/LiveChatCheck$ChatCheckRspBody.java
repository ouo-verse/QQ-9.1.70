package com.tencent.icgame.trpcprotocol.qlive.livechatcheck;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveChatCheck$ChatCheckRspBody extends MessageMicro<LiveChatCheck$ChatCheckRspBody> {
    public static final int ISADMIN_RSP_FIELD_NUMBER = 6;
    public static final int ISKICKOUT_RSP_FIELD_NUMBER = 9;
    public static final int KICKOUT_RSP_FIELD_NUMBER = 8;
    public static final int LISTADMIN_RSP_FIELD_NUMBER = 7;
    public static final int QUERY_RSP_FIELD_NUMBER = 4;
    public static final int RESULT_FIELD_NUMBER = 2;
    public static final int ROOMADMIN_RSP_FIELD_NUMBER = 5;
    public static final int SET_RSP_FIELD_NUMBER = 3;
    public static final int SUBMCD_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 66, 74}, new String[]{"submcd", "result", "set_rsp", "query_rsp", "roomadmin_rsp", "isadmin_rsp", "listadmin_rsp", "kickout_rsp", "iskickout_rsp"}, new Object[]{0, 0, null, null, null, null, null, null, null}, LiveChatCheck$ChatCheckRspBody.class);
    public final PBUInt32Field submcd = PBField.initUInt32(0);
    public final PBSInt32Field result = PBField.initSInt32(0);
    public LiveChatCheck$SetChatStatusRsp set_rsp = new LiveChatCheck$SetChatStatusRsp();
    public LiveChatCheck$QueryChatStatusRsp query_rsp = new LiveChatCheck$QueryChatStatusRsp();
    public LiveChatCheck$SetRoomAdminRsp roomadmin_rsp = new LiveChatCheck$SetRoomAdminRsp();
    public LiveChatCheck$IsRoomAdminRsp isadmin_rsp = new LiveChatCheck$IsRoomAdminRsp();
    public LiveChatCheck$ListRoomAdminRsp listadmin_rsp = new MessageMicro<LiveChatCheck$ListRoomAdminRsp>() { // from class: com.tencent.icgame.trpcprotocol.qlive.livechatcheck.LiveChatCheck$ListRoomAdminRsp
        public static final int ADMINS_FIELD_NUMBER = 2;
        public static final int ADMIN_LIMIT_FIELD_NUMBER = 1;
        public static final int IS_MASTER_IN_ROOM_FIELD_NUMBER = 5;
        public static final int MSG_FIELD_NUMBER = 4;
        public static final int RETCODE_FIELD_NUMBER = 3;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40}, new String[]{"admin_limit", "admins", "retcode", "msg", "is_master_in_room"}, new Object[]{0, null, 0, ByteStringMicro.EMPTY, Boolean.FALSE}, LiveChatCheck$ListRoomAdminRsp.class);
        public final PBUInt32Field admin_limit = PBField.initUInt32(0);
        public final PBRepeatMessageField<LiveChatCheck$AdminDetail> admins = PBField.initRepeatMessage(LiveChatCheck$AdminDetail.class);
        public final PBInt32Field retcode = PBField.initInt32(0);

        /* renamed from: msg, reason: collision with root package name */
        public final PBBytesField f116233msg = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBoolField is_master_in_room = PBField.initBool(false);
    };
    public LiveChatCheck$KickOutSomebodyRsp kickout_rsp = new LiveChatCheck$KickOutSomebodyRsp();
    public LiveChatCheck$IsKickOutRsp iskickout_rsp = new MessageMicro<LiveChatCheck$IsKickOutRsp>() { // from class: com.tencent.icgame.trpcprotocol.qlive.livechatcheck.LiveChatCheck$IsKickOutRsp
        public static final int BLOCK_EXPIRES_TIME_FIELD_NUMBER = 3;
        public static final int ERR_MSG_FIELD_NUMBER = 2;
        public static final int IS_KICKOUT_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"is_kickout", "err_msg", "block_expires_time"}, new Object[]{0, "", 0}, LiveChatCheck$IsKickOutRsp.class);
        public final PBUInt32Field is_kickout = PBField.initUInt32(0);
        public final PBStringField err_msg = PBField.initString("");
        public final PBUInt32Field block_expires_time = PBField.initUInt32(0);
    };
}
