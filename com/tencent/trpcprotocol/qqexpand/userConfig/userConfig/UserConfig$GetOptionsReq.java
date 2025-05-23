package com.tencent.trpcprotocol.qqexpand.userConfig.userConfig;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class UserConfig$GetOptionsReq extends MessageMicro<UserConfig$GetOptionsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"optionIDs", "Uin"}, new Object[]{0, 0L}, UserConfig$GetOptionsReq.class);
    public final PBRepeatField<Integer> optionIDs = PBField.initRepeat(PBEnumField.__repeatHelper__);
    public final PBUInt64Field Uin = PBField.initUInt64(0);
}
