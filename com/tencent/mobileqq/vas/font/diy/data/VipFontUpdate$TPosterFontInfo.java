package com.tencent.mobileqq.vas.font.diy.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes20.dex */
public final class VipFontUpdate$TPosterFontInfo extends MessageMicro<VipFontUpdate$TPosterFontInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"i32_font_id", "u64_ts"}, new Object[]{0, 0L}, VipFontUpdate$TPosterFontInfo.class);
    public final PBInt32Field i32_font_id = PBField.initInt32(0);
    public final PBUInt64Field u64_ts = PBField.initUInt64(0);
}
