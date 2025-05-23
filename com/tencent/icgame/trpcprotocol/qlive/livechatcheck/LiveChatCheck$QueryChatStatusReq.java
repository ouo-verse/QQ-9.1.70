package com.tencent.icgame.trpcprotocol.qlive.livechatcheck;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveChatCheck$QueryChatStatusReq extends MessageMicro<LiveChatCheck$QueryChatStatusReq> {
    public static final int ANCHOR_UIN_FIELD_NUMBER = 1;
    public static final int ROOM_FIELD_NUMBER = 3;
    public static final int UIN_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"anchor_uin", "uin", "room"}, new Object[]{0L, 0L, 0L}, LiveChatCheck$QueryChatStatusReq.class);
    public final PBUInt64Field anchor_uin = PBField.initUInt64(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt64Field room = PBField.initUInt64(0);
}
