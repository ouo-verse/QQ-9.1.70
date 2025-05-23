package com.tencent.ilive_user_basic_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class ilive_user_basic_info$GetDisplayMinMedalLevelRsp extends MessageMicro<ilive_user_basic_info$GetDisplayMinMedalLevelRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"medal_id", "result"}, new Object[]{0, 0}, ilive_user_basic_info$GetDisplayMinMedalLevelRsp.class);
    public final PBUInt32Field medal_id = PBField.initUInt32(0);
    public final PBUInt32Field result = PBField.initUInt32(0);
}
