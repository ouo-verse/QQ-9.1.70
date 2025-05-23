package com.tencent.icgame.trpcprotocol.qlive.livechatcheck;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveChatCheck$RoomUserInfo extends MessageMicro<LiveChatCheck$RoomUserInfo> {
    public static final int FACE_URL_FIELD_NUMBER = 1;
    public static final int GENDER_FIELD_NUMBER = 3;
    public static final int NICK_NAME_FIELD_NUMBER = 2;
    public static final int OP_TIME_FIELD_NUMBER = 4;
    public static final int UID_FIELD_NUMBER = 5;
    public static final int USER_EXTRA_INFO_FIELD_NUMBER = 6;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField face_url;
    public final PBBoolField gender;
    public final PBBytesField nick_name;
    public final PBUInt64Field op_time;
    public final PBUInt64Field uid;
    public LiveChatCheck$UserExtraInfo user_extra_info;

    static {
        String[] strArr = {"face_url", IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, "gender", "op_time", "uid", "user_extra_info"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 50}, strArr, new Object[]{byteStringMicro, byteStringMicro, Boolean.FALSE, 0L, 0L, null}, LiveChatCheck$RoomUserInfo.class);
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.tencent.icgame.trpcprotocol.qlive.livechatcheck.LiveChatCheck$UserExtraInfo] */
    public LiveChatCheck$RoomUserInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.face_url = PBField.initBytes(byteStringMicro);
        this.nick_name = PBField.initBytes(byteStringMicro);
        this.gender = PBField.initBool(false);
        this.op_time = PBField.initUInt64(0L);
        this.uid = PBField.initUInt64(0L);
        this.user_extra_info = new MessageMicro<LiveChatCheck$UserExtraInfo>() { // from class: com.tencent.icgame.trpcprotocol.qlive.livechatcheck.LiveChatCheck$UserExtraInfo
            public static final int MEDAL_INFO_LIST_FIELD_NUMBER = 2;
            public static final int UIN_FIELD_NUMBER = 1;
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uin", "medal_info_list"}, new Object[]{0L, null}, LiveChatCheck$UserExtraInfo.class);
            public final PBUInt64Field uin = PBField.initUInt64(0);
            public final PBRepeatMessageField<LiveChatCheck$MedalInfo> medal_info_list = PBField.initRepeatMessage(LiveChatCheck$MedalInfo.class);
        };
    }
}
