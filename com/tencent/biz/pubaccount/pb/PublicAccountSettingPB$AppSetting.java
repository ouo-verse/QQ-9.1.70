package com.tencent.biz.pubaccount.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes32.dex */
public final class PublicAccountSettingPB$AppSetting extends MessageMicro<PublicAccountSettingPB$AppSetting> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"forever_msg_switch", "official_account_pos", "official_account_mute"}, new Object[]{0, 0L, 0}, PublicAccountSettingPB$AppSetting.class);
    public final PBUInt32Field forever_msg_switch = PBField.initUInt32(0);
    public final PBUInt64Field official_account_pos = PBField.initUInt64(0);
    public final PBUInt32Field official_account_mute = PBField.initUInt32(0);
}
