package com.tencent.mobileqq.troop.org.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class oidb_0x496$Robot extends MessageMicro<oidb_0x496$Robot> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 48, 58}, new String[]{"version", "uin_range", "fire_keywords", "start_keywords", "end_keywords", "session_timeout", "subscribe_categories"}, new Object[]{0, null, "", "", "", 0, null}, oidb_0x496$Robot.class);
    public final PBRepeatField<String> end_keywords;
    public final PBRepeatField<String> fire_keywords;
    public final PBUInt32Field session_timeout;
    public final PBRepeatField<String> start_keywords;
    public final PBRepeatMessageField<oidb_0x496$RobotSubscribeCategory> subscribe_categories;
    public final PBUInt32Field version = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0x496$UinRange> uin_range = PBField.initRepeatMessage(oidb_0x496$UinRange.class);

    public oidb_0x496$Robot() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.fire_keywords = PBField.initRepeat(pBStringField);
        this.start_keywords = PBField.initRepeat(pBStringField);
        this.end_keywords = PBField.initRepeat(pBStringField);
        this.session_timeout = PBField.initUInt32(0);
        this.subscribe_categories = PBField.initRepeatMessage(oidb_0x496$RobotSubscribeCategory.class);
    }
}
