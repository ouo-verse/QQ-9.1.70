package com.tencent.icgame.trpcprotocol.qlive.livechatcheck;

import com.tencent.autotemplate.extra.PreDetect;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveChatCheck$AdminDetail extends MessageMicro<LiveChatCheck$AdminDetail> {
    public static final int ADMIN_TINYID_FIELD_NUMBER = 2;
    public static final int ADMIN_UIN_FIELD_NUMBER = 1;
    public static final int FACE_FIELD_NUMBER = 4;
    public static final int FACE_URL_FIELD_NUMBER = 7;
    public static final int GENDER_FIELD_NUMBER = 6;
    public static final int IS_ADMIN_IN_ROOM_FIELD_NUMBER = 8;
    public static final int NICKNAME_FIELD_NUMBER = 3;
    public static final int SIGN_FIELD_NUMBER = 5;
    static final MessageMicro.FieldMap __fieldMap__;

    /* renamed from: face, reason: collision with root package name */
    public final PBBytesField f116227face;
    public final PBBytesField face_url;
    public final PBBoolField gender;
    public final PBBoolField is_admin_in_room;
    public final PBBytesField nickname;
    public final PBBytesField sign;
    public final PBUInt64Field admin_uin = PBField.initUInt64(0);
    public final PBUInt64Field admin_tinyid = PBField.initUInt64(0);

    static {
        String[] strArr = {"admin_uin", "admin_tinyid", "nickname", PreDetect.FACE_DETECT, "sign", "gender", "face_url", "is_admin_in_room"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 48, 58, 64}, strArr, new Object[]{0L, 0L, byteStringMicro, byteStringMicro, byteStringMicro, bool, byteStringMicro, bool}, LiveChatCheck$AdminDetail.class);
    }

    public LiveChatCheck$AdminDetail() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.nickname = PBField.initBytes(byteStringMicro);
        this.f116227face = PBField.initBytes(byteStringMicro);
        this.sign = PBField.initBytes(byteStringMicro);
        this.gender = PBField.initBool(false);
        this.face_url = PBField.initBytes(byteStringMicro);
        this.is_admin_in_room = PBField.initBool(false);
    }
}
