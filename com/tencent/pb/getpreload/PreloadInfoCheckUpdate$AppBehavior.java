package com.tencent.pb.getpreload;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class PreloadInfoCheckUpdate$AppBehavior extends MessageMicro<PreloadInfoCheckUpdate$AppBehavior> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"appid", "click_num", "click_red_num", "red_state"}, new Object[]{0, 0, 0, 0}, PreloadInfoCheckUpdate$AppBehavior.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBInt32Field click_num = PBField.initInt32(0);
    public final PBInt32Field click_red_num = PBField.initInt32(0);
    public final PBInt32Field red_state = PBField.initInt32(0);
}
