package com.tencent.icgame.trpcprotocol.qlive.livechatcheck;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveChatCheck$AdminMenu extends MessageMicro<LiveChatCheck$AdminMenu> {
    public static final int MENU_ID_FIELD_NUMBER = 1;
    public static final int MENU_MSG_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"menu_id", "menu_msg"}, new Object[]{0, ByteStringMicro.EMPTY}, LiveChatCheck$AdminMenu.class);
    public final PBUInt32Field menu_id = PBField.initUInt32(0);
    public final PBBytesField menu_msg = PBField.initBytes(ByteStringMicro.EMPTY);
}
