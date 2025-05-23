package com.tencent.icgame.trpcprotocol.qlive.livechatcheck;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveChatCheck$IsRoomAdminRsp extends MessageMicro<LiveChatCheck$IsRoomAdminRsp> {
    public static final int IS_ADMIN_FIELD_NUMBER = 1;
    public static final int MASTER_UIN_FIELD_NUMBER = 4;
    public static final int MSG_FIELD_NUMBER = 3;
    public static final int RETCODE_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"is_admin", "retcode", "msg", "master_uin"}, new Object[]{Boolean.FALSE, 0, ByteStringMicro.EMPTY, 0L}, LiveChatCheck$IsRoomAdminRsp.class);
    public final PBBoolField is_admin = PBField.initBool(false);
    public final PBInt32Field retcode = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBBytesField f116231msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field master_uin = PBField.initUInt64(0);
}
