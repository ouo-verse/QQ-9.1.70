package com.tencent.icgame.trpcprotocol.qlive.livechatcheck;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveChatCheck$SetRoomLinkMicFbdStateReq extends MessageMicro<LiveChatCheck$SetRoomLinkMicFbdStateReq> {
    public static final int ANCHOR_UID_FIELD_NUMBER = 2;
    public static final int FBD_REASON_FIELD_NUMBER = 5;
    public static final int MANAGER_UID_FIELD_NUMBER = 1;
    public static final int OP_FIELD_NUMBER = 4;
    public static final int ROOM_ID_FIELD_NUMBER = 6;
    public static final int USER_UID_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48}, new String[]{"manager_uid", "anchor_uid", "user_uid", "op", "fbd_reason", AudienceReportConst.ROOM_ID}, new Object[]{0L, 0L, 0L, 0, 0, 0L}, LiveChatCheck$SetRoomLinkMicFbdStateReq.class);
    public final PBUInt64Field manager_uid = PBField.initUInt64(0);
    public final PBUInt64Field anchor_uid = PBField.initUInt64(0);
    public final PBUInt64Field user_uid = PBField.initUInt64(0);

    /* renamed from: op, reason: collision with root package name */
    public final PBUInt32Field f116236op = PBField.initUInt32(0);
    public final PBUInt32Field fbd_reason = PBField.initUInt32(0);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
}
