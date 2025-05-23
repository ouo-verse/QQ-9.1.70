package com.tencent.trpcprotocol.qlive.livechatcheck;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes27.dex */
public final class RoomAdminPush$PushMsg_KickOutSomebody extends MessageMicro<RoomAdminPush$PushMsg_KickOutSomebody> {
    public static final int MSG_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg"}, new Object[]{ByteStringMicro.EMPTY}, RoomAdminPush$PushMsg_KickOutSomebody.class);

    /* renamed from: msg, reason: collision with root package name */
    public final PBBytesField f381591msg = PBField.initBytes(ByteStringMicro.EMPTY);
}
