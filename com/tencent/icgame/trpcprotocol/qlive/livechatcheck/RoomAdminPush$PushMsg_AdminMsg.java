package com.tencent.icgame.trpcprotocol.qlive.livechatcheck;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;

/* loaded from: classes7.dex */
public final class RoomAdminPush$PushMsg_AdminMsg extends MessageMicro<RoomAdminPush$PushMsg_AdminMsg> {
    public static final int MSG_FIELD_NUMBER = 2;
    public static final int MSG_TYPE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{QQHealthReportApiImpl.MSG_TYPE_KEY, "msg"}, new Object[]{0, ByteStringMicro.EMPTY}, RoomAdminPush$PushMsg_AdminMsg.class);
    public final PBUInt32Field msg_type = PBField.initUInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBBytesField f116237msg = PBField.initBytes(ByteStringMicro.EMPTY);
}
