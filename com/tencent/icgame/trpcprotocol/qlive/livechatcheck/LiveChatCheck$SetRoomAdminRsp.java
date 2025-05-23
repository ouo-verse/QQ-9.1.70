package com.tencent.icgame.trpcprotocol.qlive.livechatcheck;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveChatCheck$SetRoomAdminRsp extends MessageMicro<LiveChatCheck$SetRoomAdminRsp> {
    public static final int MAX_ALLOW_ADMIN_FIELD_NUMBER = 2;
    public static final int MSG_FIELD_NUMBER = 3;
    public static final int RETCODE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"retcode", "max_allow_admin", "msg"}, new Object[]{0, 0, ByteStringMicro.EMPTY}, LiveChatCheck$SetRoomAdminRsp.class);
    public final PBInt32Field retcode = PBField.initInt32(0);
    public final PBUInt32Field max_allow_admin = PBField.initUInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBBytesField f116235msg = PBField.initBytes(ByteStringMicro.EMPTY);
}
