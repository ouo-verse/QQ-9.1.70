package com.tencent.qqnt.ntrelation.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes22.dex */
public final class ProfileUpdateMsg$UpdateMsg extends MessageMicro<ProfileUpdateMsg$UpdateMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 160002}, new String[]{"action", "datas"}, new Object[]{null, null}, ProfileUpdateMsg$UpdateMsg.class);
    public final PBRepeatMessageField<ProfileUpdateMsg$Action> action = PBField.initRepeatMessage(ProfileUpdateMsg$Action.class);
    public final PBRepeatMessageField<ProfileUpdateMsg$UpdateData> datas = PBField.initRepeatMessage(ProfileUpdateMsg$UpdateData.class);
}
