package com.tencent.icgame.trpcprotocol.qlive.livechatcheck;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveChatCheck$SetChatStatusReq extends MessageMicro<LiveChatCheck$SetChatStatusReq> {
    public static final int ALLOW_CHAT_FIELD_NUMBER = 3;
    public static final int ANCHOR_UIN_FIELD_NUMBER = 1;
    public static final int MENU_ID_FIELD_NUMBER = 5;
    public static final int ROOM_FIELD_NUMBER = 4;
    public static final int UIN_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"anchor_uin", "uin", "allow_chat", "room", "menu_id"}, new Object[]{0L, 0L, Boolean.FALSE, 0L, 0}, LiveChatCheck$SetChatStatusReq.class);
    public final PBUInt64Field anchor_uin = PBField.initUInt64(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBBoolField allow_chat = PBField.initBool(false);
    public final PBUInt64Field room = PBField.initUInt64(0);
    public final PBUInt32Field menu_id = PBField.initUInt32(0);
}
