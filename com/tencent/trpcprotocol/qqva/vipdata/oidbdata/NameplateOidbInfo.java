package com.tencent.trpcprotocol.qqva.vipdata.oidbdata;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class NameplateOidbInfo extends MessageMicro<NameplateOidbInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"nameplate_type", "nameplate_id", "level", "diy_nameplate_ids"}, new Object[]{0, 0, 0, 0}, NameplateOidbInfo.class);
    public final PBInt32Field nameplate_type = PBField.initInt32(0);
    public final PBInt32Field nameplate_id = PBField.initInt32(0);
    public final PBInt32Field level = PBField.initInt32(0);
    public final PBRepeatField<Integer> diy_nameplate_ids = PBField.initRepeat(PBInt32Field.__repeatHelper__);
}
