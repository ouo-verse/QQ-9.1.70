package com.tencent.trpcprotocol.qqva.vipdata.userdata;

import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class userdata$UserData extends MessageMicro<userdata$UserData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50, 58, 66, 72, 80, 98}, new String[]{"splendid", "nameplate", "ts", "number_items", MiniConst.WxMiniAppInfoConst.EXTRA_ICON, "colour_nick", "love_chat_frame_info", "addon", "vip_bitflag", "face_maskid", "number_items_long"}, new Object[]{null, null, 0L, null, null, null, null, null, 0L, 0, null}, userdata$UserData.class);
    public userdata$splendidInfo splendid = new MessageMicro<userdata$splendidInfo>() { // from class: com.tencent.trpcprotocol.qqva.vipdata.userdata.userdata$splendidInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBoolField isSplendidface = PBField.initBool(false);
        public final PBInt64Field nvalue = PBField.initInt64(0);
        public final PBBoolField isSplendidsummarycard = PBField.initBool(false);
        public final PBInt32Field avatar_type = PBField.initInt32(0);
        public final PBInt32Field face_itemid = PBField.initInt32(0);

        static {
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"isSplendidface", "nvalue", "isSplendidsummarycard", "avatar_type", "face_itemid"}, new Object[]{bool, 0L, bool, 0, 0}, userdata$splendidInfo.class);
        }
    };
    public userdata$NameplateInfo nameplate = new userdata$NameplateInfo();

    /* renamed from: ts, reason: collision with root package name */
    public final PBInt64Field f381646ts = PBField.initInt64(0);
    public final PBRepeatMessageField<userdata$NumberItem> number_items = PBField.initRepeatMessage(userdata$NumberItem.class);
    public userdata$AppIcon app_icon = new MessageMicro<userdata$AppIcon>() { // from class: com.tencent.trpcprotocol.qqva.vipdata.userdata.userdata$AppIcon
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"icon_id"}, new Object[]{0}, userdata$AppIcon.class);
        public final PBInt32Field icon_id = PBField.initInt32(0);
    };
    public userdata$ColourNickInfo colour_nick = new userdata$ColourNickInfo();
    public userdata$LoveChatFrameInfo love_chat_frame_info = new MessageMicro<userdata$LoveChatFrameInfo>() { // from class: com.tencent.trpcprotocol.qqva.vipdata.userdata.userdata$LoveChatFrameInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"itemid"}, new Object[]{0}, userdata$LoveChatFrameInfo.class);
        public final PBInt32Field itemid = PBField.initInt32(0);
    };
    public userdata$Addon addon = new MessageMicro<userdata$Addon>() { // from class: com.tencent.trpcprotocol.qqva.vipdata.userdata.userdata$Addon
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"itemid", "islogo"}, new Object[]{0, Boolean.FALSE}, userdata$Addon.class);
        public final PBInt32Field itemid = PBField.initInt32(0);
        public final PBBoolField islogo = PBField.initBool(false);
    };
    public final PBUInt64Field vip_bitflag = PBField.initUInt64(0);
    public final PBInt32Field face_maskid = PBField.initInt32(0);
    public final PBRepeatMessageField<userdata$NumberItem> number_items_long = PBField.initRepeatMessage(userdata$NumberItem.class);
}
