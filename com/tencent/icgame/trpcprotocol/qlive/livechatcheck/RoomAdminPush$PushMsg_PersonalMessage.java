package com.tencent.icgame.trpcprotocol.qlive.livechatcheck;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;

/* loaded from: classes7.dex */
public final class RoomAdminPush$PushMsg_PersonalMessage extends MessageMicro<RoomAdminPush$PushMsg_PersonalMessage> {
    public static final int MSG_FIELD_NUMBER = 2;
    public static final int MSG_TYPE_FIELD_NUMBER = 3;
    public static final int UID_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uid", "msg", QQHealthReportApiImpl.MSG_TYPE_KEY}, new Object[]{0L, ByteStringMicro.EMPTY, 0}, RoomAdminPush$PushMsg_PersonalMessage.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBBytesField f116239msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field msg_type = PBField.initUInt32(0);
}
