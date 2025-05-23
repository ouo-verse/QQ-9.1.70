package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YesGameInfoOuterClass$GameConfigRoomChat extends MessageMicro<YesGameInfoOuterClass$GameConfigRoomChat> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"head_bg", "bg_hue", "recv_msg", "send_msg", "text_normal_hue", "text_weak_hue", "text_stress_hue"}, new Object[]{"", "", null, null, "", "", ""}, YesGameInfoOuterClass$GameConfigRoomChat.class);
    public final PBStringField head_bg = PBField.initString("");
    public final PBRepeatField<String> bg_hue = PBField.initRepeat(PBStringField.__repeatHelper__);
    public YesGameInfoOuterClass$GameConfigRoomChatMsg recv_msg = new MessageMicro<YesGameInfoOuterClass$GameConfigRoomChatMsg>() { // from class: com.tencent.icgame.trpc.yes.common.YesGameInfoOuterClass$GameConfigRoomChatMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"bubble_hue", "bubble_text_hue", "at_text_hue", "nick_text_hue", "role_nick_text_hue"}, new Object[]{"", "", "", "", ""}, YesGameInfoOuterClass$GameConfigRoomChatMsg.class);
        public final PBStringField bubble_hue = PBField.initString("");
        public final PBStringField bubble_text_hue = PBField.initString("");
        public final PBStringField at_text_hue = PBField.initString("");
        public final PBStringField nick_text_hue = PBField.initString("");
        public final PBStringField role_nick_text_hue = PBField.initString("");
    };
    public YesGameInfoOuterClass$GameConfigRoomChatMsg send_msg = new MessageMicro<YesGameInfoOuterClass$GameConfigRoomChatMsg>() { // from class: com.tencent.icgame.trpc.yes.common.YesGameInfoOuterClass$GameConfigRoomChatMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"bubble_hue", "bubble_text_hue", "at_text_hue", "nick_text_hue", "role_nick_text_hue"}, new Object[]{"", "", "", "", ""}, YesGameInfoOuterClass$GameConfigRoomChatMsg.class);
        public final PBStringField bubble_hue = PBField.initString("");
        public final PBStringField bubble_text_hue = PBField.initString("");
        public final PBStringField at_text_hue = PBField.initString("");
        public final PBStringField nick_text_hue = PBField.initString("");
        public final PBStringField role_nick_text_hue = PBField.initString("");
    };
    public final PBStringField text_normal_hue = PBField.initString("");
    public final PBStringField text_weak_hue = PBField.initString("");
    public final PBStringField text_stress_hue = PBField.initString("");
}
