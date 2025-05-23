package com.tencent.trpcprotocol.qlive.livechatcheck;

import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes27.dex */
public final class RoomAdminPush$PushMsg_SetAdmin extends MessageMicro<RoomAdminPush$PushMsg_SetAdmin> {
    public static final int MSG_FIELD_NUMBER = 1;
    public static final int RIGHTS_MASK_FIELD_NUMBER = 2;
    public static final int SET_ADMIN_FIELD_NUMBER = 3;
    public static final int SIG_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__;

    /* renamed from: msg, reason: collision with root package name */
    public final PBBytesField f381593msg;
    public final PBUInt64Field rights_mask;
    public final PBBoolField set_admin;
    public final PBBytesField sig;

    static {
        String[] strArr = {"msg", "rights_mask", "set_admin", PreloadTRTCPlayerParams.KEY_SIG};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, strArr, new Object[]{byteStringMicro, 0L, Boolean.FALSE, byteStringMicro}, RoomAdminPush$PushMsg_SetAdmin.class);
    }

    public RoomAdminPush$PushMsg_SetAdmin() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.f381593msg = PBField.initBytes(byteStringMicro);
        this.rights_mask = PBField.initUInt64(0L);
        this.set_admin = PBField.initBool(false);
        this.sig = PBField.initBytes(byteStringMicro);
    }
}
