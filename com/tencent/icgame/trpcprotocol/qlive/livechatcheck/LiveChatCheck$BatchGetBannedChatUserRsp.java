package com.tencent.icgame.trpcprotocol.qlive.livechatcheck;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveChatCheck$BatchGetBannedChatUserRsp extends MessageMicro<LiveChatCheck$BatchGetBannedChatUserRsp> {
    public static final int IS_END_FIELD_NUMBER = 5;
    public static final int MASTER_TINYID_FIELD_NUMBER = 2;
    public static final int MSG_FIELD_NUMBER = 7;
    public static final int RETCODE_FIELD_NUMBER = 6;
    public static final int ROOMID_FIELD_NUMBER = 1;
    public static final int SUM_FIELD_NUMBER = 4;
    public static final int USERLIST_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 48, 58}, new String[]{"roomid", "master_tinyid", "userlist", "sum", "is_end", "retcode", "msg"}, new Object[]{0L, 0L, null, 0, 0, 0, ByteStringMicro.EMPTY}, LiveChatCheck$BatchGetBannedChatUserRsp.class);
    public final PBUInt64Field roomid = PBField.initUInt64(0);
    public final PBUInt64Field master_tinyid = PBField.initUInt64(0);
    public final PBRepeatMessageField<LiveChatCheck$RoomUserInfo> userlist = PBField.initRepeatMessage(LiveChatCheck$RoomUserInfo.class);
    public final PBUInt32Field sum = PBField.initUInt32(0);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBInt32Field retcode = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBBytesField f116228msg = PBField.initBytes(ByteStringMicro.EMPTY);
}
