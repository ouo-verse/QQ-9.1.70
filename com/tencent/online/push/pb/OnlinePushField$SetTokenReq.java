package com.tencent.online.push.pb;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountConfigUtilImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class OnlinePushField$SetTokenReq extends MessageMicro<OnlinePushField$SetTokenReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field bind_uin_notify_switch;
    public final PBStringField dev_type;
    public final PBStringField empty_sound;
    public final PBInt32Field enter_version;
    public final PBUInt32Field group_pro_switch;
    public final PBInt64Field ios_version;
    public final PBBytesField new_token;
    public final PBBytesField new_voip_token;
    public final PBInt32Field notify_switch;
    public final PBStringField os_version;
    public final PBInt32Field photo_push;
    public final PBBytesField profile_id;
    public final PBInt32Field push_msg;
    public final PBInt32Field push_qzone;
    public final PBStringField push_sound;
    public final PBInt32Field scenes;
    public final PBRepeatField<Integer> token_id;
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBInt64Field vendor_type;
    public final PBStringField video_sound;
    public final PBInt32Field voip_flag;
    public final PBRepeatField<Integer> voip_token;

    static {
        String[] strArr = {"uin", "voip_token", "token_id", "new_token", "new_voip_token", "voip_flag", "photo_push", "scenes", "push_msg", "push_qzone", "push_sound", "empty_sound", PublicAccountConfigUtilImpl.CONFIG_VIDEO_SOUND, "enter_version", "group_pro_switch", "dev_type", "os_version", "notify_switch", "bind_uin_notify_switch", "profile_id", "vendor_type", "ios_version"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{1360008, 1360016, 1360024, 1360034, 1360042, 1360048, 1360056, 1360064, 1360072, 1360080, 1360090, 1360098, 1360106, 1360112, 1360120, 1360130, 1360138, 1360144, 1360152, 1360162, 1360168, 1360176}, strArr, new Object[]{0L, 0, 0, byteStringMicro, byteStringMicro, 0, 0, 0, 0, 0, "", "", "", 0, 0, "", "", 0, 0, byteStringMicro, 0L, 0L}, OnlinePushField$SetTokenReq.class);
    }

    public OnlinePushField$SetTokenReq() {
        PBInt32Field pBInt32Field = PBInt32Field.__repeatHelper__;
        this.voip_token = PBField.initRepeat(pBInt32Field);
        this.token_id = PBField.initRepeat(pBInt32Field);
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.new_token = PBField.initBytes(byteStringMicro);
        this.new_voip_token = PBField.initBytes(byteStringMicro);
        this.voip_flag = PBField.initInt32(0);
        this.photo_push = PBField.initInt32(0);
        this.scenes = PBField.initInt32(0);
        this.push_msg = PBField.initInt32(0);
        this.push_qzone = PBField.initInt32(0);
        this.push_sound = PBField.initString("");
        this.empty_sound = PBField.initString("");
        this.video_sound = PBField.initString("");
        this.enter_version = PBField.initInt32(0);
        this.group_pro_switch = PBField.initUInt32(0);
        this.dev_type = PBField.initString("");
        this.os_version = PBField.initString("");
        this.notify_switch = PBField.initInt32(0);
        this.bind_uin_notify_switch = PBField.initInt32(0);
        this.profile_id = PBField.initBytes(byteStringMicro);
        this.vendor_type = PBField.initInt64(0L);
        this.ios_version = PBField.initInt64(0L);
    }
}
