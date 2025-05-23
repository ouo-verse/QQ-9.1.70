package com.tencent.icgame.trpcprotocol.qlive.livechatcheck;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveChatCheck$SetChatStatusRsp extends MessageMicro<LiveChatCheck$SetChatStatusRsp> {
    public static final int ALLOW_CHAT_FIELD_NUMBER = 4;
    public static final int ANCHOR_UIN_FIELD_NUMBER = 1;
    public static final int MSG_FIELD_NUMBER = 5;
    public static final int RESULT_FIELD_NUMBER = 3;
    public static final int UIN_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"anchor_uin", "uin", "result", "allow_chat", "msg"}, new Object[]{0L, 0L, 0, Boolean.FALSE, ByteStringMicro.EMPTY}, LiveChatCheck$SetChatStatusRsp.class);
    public final PBUInt64Field anchor_uin = PBField.initUInt64(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBSInt32Field result = PBField.initSInt32(0);
    public final PBBoolField allow_chat = PBField.initBool(false);

    /* renamed from: msg, reason: collision with root package name */
    public final PBBytesField f116234msg = PBField.initBytes(ByteStringMicro.EMPTY);
}
