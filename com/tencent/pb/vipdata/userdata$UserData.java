package com.tencent.pb.vipdata;

import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class userdata$UserData extends MessageMicro<userdata$UserData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50, 58, 66, 72, 80, 98}, new String[]{"splendid", "nameplate", "ts", "number_items", MiniConst.WxMiniAppInfoConst.EXTRA_ICON, "colour_nick", "love_chat_frame_info", "addon", "vip_bitflag", "face_maskid", "number_items_long"}, new Object[]{null, null, 0L, null, null, null, null, null, 0L, 0, null}, userdata$UserData.class);
    public userdata$splendidInfo splendid = new userdata$splendidInfo();
    public userdata$NameplateInfo nameplate = new userdata$NameplateInfo();

    /* renamed from: ts, reason: collision with root package name */
    public final PBInt64Field f342178ts = PBField.initInt64(0);
    public final PBRepeatMessageField<userdata$NumberItem> number_items = PBField.initRepeatMessage(userdata$NumberItem.class);
    public userdata$AppIcon app_icon = new userdata$AppIcon();
    public userdata$ColourNickInfo colour_nick = new userdata$ColourNickInfo();
    public userdata$LoveChatFrameInfo love_chat_frame_info = new userdata$LoveChatFrameInfo();
    public userdata$Addon addon = new userdata$Addon();
    public final PBUInt64Field vip_bitflag = PBField.initUInt64(0);
    public final PBInt32Field face_maskid = PBField.initInt32(0);
    public final PBRepeatMessageField<userdata$NumberItem> number_items_long = PBField.initRepeatMessage(userdata$NumberItem.class);
}
