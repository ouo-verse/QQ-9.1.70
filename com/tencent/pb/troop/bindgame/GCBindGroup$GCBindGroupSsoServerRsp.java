package com.tencent.pb.troop.bindgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqmini.sdk.launcher.model.CrashRtInfoHolder;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class GCBindGroup$GCBindGroupSsoServerRsp extends MessageMicro<GCBindGroup$GCBindGroupSsoServerRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"ret", "msg", "bind_info", "card_info", "memeber_info"}, new Object[]{0, "", null, null, null}, GCBindGroup$GCBindGroupSsoServerRsp.class);
    public final PBInt32Field ret = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f342174msg = PBField.initString("");
    public GCBindGroup$QQBindInfo bind_info = new GCBindGroup$QQBindInfo();
    public GCBindGroup$QQCardDynamicInfo card_info = new MessageMicro<GCBindGroup$QQCardDynamicInfo>() { // from class: com.tencent.pb.troop.bindgame.GCBindGroup$QQCardDynamicInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"dynamic_info", "dynamic_cnt", "newest_time"}, new Object[]{"", 0, 0L}, GCBindGroup$QQCardDynamicInfo.class);
        public final PBStringField dynamic_info = PBField.initString("");
        public final PBInt32Field dynamic_cnt = PBField.initInt32(0);
        public final PBUInt64Field newest_time = PBField.initUInt64(0);
    };
    public GCBindGroup$QQCardMemberInfo memeber_info = new MessageMicro<GCBindGroup$QQCardMemberInfo>() { // from class: com.tencent.pb.troop.bindgame.GCBindGroup$QQCardMemberInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{CrashRtInfoHolder.BeaconKey.GAME_NAME, "level_name", "level_icon", "game_font_color", "game_background_color", "game_url", "desc_info"}, new Object[]{"", "", "", "", "", "", ""}, GCBindGroup$QQCardMemberInfo.class);
        public final PBStringField game_name = PBField.initString("");
        public final PBStringField level_name = PBField.initString("");
        public final PBStringField level_icon = PBField.initString("");
        public final PBStringField game_font_color = PBField.initString("");
        public final PBStringField game_background_color = PBField.initString("");
        public final PBStringField game_url = PBField.initString("");
        public final PBRepeatField<String> desc_info = PBField.initRepeat(PBStringField.__repeatHelper__);
    };
}
