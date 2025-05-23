package com.tencent.trpcprotocol.qqexpand.userConfig.userConfig;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes27.dex */
public final class UserConfig$SetPrefOptionsReq extends MessageMicro<UserConfig$SetPrefOptionsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"tag_id", "pref_ids"}, new Object[]{0, 0}, UserConfig$SetPrefOptionsReq.class);
    public final PBUInt32Field tag_id = PBField.initUInt32(0);
    public final PBRepeatField<Integer> pref_ids = PBField.initRepeat(PBEnumField.__repeatHelper__);
}
