package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.troop.api.ILaunchTroopSysMsgUIUtilApi;

/* loaded from: classes3.dex */
public final class qav_rtc_push_online$PushOnlineMsg extends MessageMicro<qav_rtc_push_online$PushOnlineMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 56, 64}, new String[]{"to_uin", ShortVideoConstants.FROM_UIN, ILaunchTroopSysMsgUIUtilApi.KEY_PUSH_TYPE, "push_msg", "video_msg_type", "origin_to_uin", "origin_from_uin"}, new Object[]{0L, 0L, 0, null, 0, 0L, 0L}, qav_rtc_push_online$PushOnlineMsg.class);
    public final PBUInt64Field from_uin;
    public final PBUInt64Field origin_from_uin;
    public final PBRepeatField<Long> origin_to_uin;
    public qav_rtc_push_online$PushMsg push_msg;
    public final PBEnumField push_type;
    public final PBRepeatField<Long> to_uin;
    public final PBUInt32Field video_msg_type;

    public qav_rtc_push_online$PushOnlineMsg() {
        PBUInt64Field pBUInt64Field = PBUInt64Field.__repeatHelper__;
        this.to_uin = PBField.initRepeat(pBUInt64Field);
        this.from_uin = PBField.initUInt64(0L);
        this.push_type = PBField.initEnum(0);
        this.push_msg = new qav_rtc_push_online$PushMsg();
        this.video_msg_type = PBField.initUInt32(0);
        this.origin_to_uin = PBField.initRepeat(pBUInt64Field);
        this.origin_from_uin = PBField.initUInt64(0L);
    }
}
