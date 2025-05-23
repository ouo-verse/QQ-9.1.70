package com.tencent.icgame.trpcprotocol.qlive.livechatcheck;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveChatCheck$AdminMenuListRsp extends MessageMicro<LiveChatCheck$AdminMenuListRsp> {
    public static final int MENU_LIST_FIELD_NUMBER = 2;
    public static final int SOURCE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"source", "menu_list"}, new Object[]{0, null}, LiveChatCheck$AdminMenuListRsp.class);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBRepeatMessageField<LiveChatCheck$AdminMenu> menu_list = PBField.initRepeatMessage(LiveChatCheck$AdminMenu.class);
}
