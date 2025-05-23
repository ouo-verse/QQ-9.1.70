package com.tencent.icgame.trpcprotocol.qlive.livechatcheck;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveChatCheck$GetRoomLinkMicFbdStateReq extends MessageMicro<LiveChatCheck$GetRoomLinkMicFbdStateReq> {
    public static final int ANCHOR_UID_FIELD_NUMBER = 1;
    public static final int ROOM_ID_FIELD_NUMBER = 3;
    public static final int USER_UID_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"anchor_uid", "user_uid", AudienceReportConst.ROOM_ID}, new Object[]{0L, 0L, 0L}, LiveChatCheck$GetRoomLinkMicFbdStateReq.class);
    public final PBUInt64Field anchor_uid = PBField.initUInt64(0);
    public final PBUInt64Field user_uid = PBField.initUInt64(0);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
}
