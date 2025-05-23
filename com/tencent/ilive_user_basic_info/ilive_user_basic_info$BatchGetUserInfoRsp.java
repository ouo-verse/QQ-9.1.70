package com.tencent.ilive_user_basic_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class ilive_user_basic_info$BatchGetUserInfoRsp extends MessageMicro<ilive_user_basic_info$BatchGetUserInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"userinfo_list", "result"}, new Object[]{null, 0}, ilive_user_basic_info$BatchGetUserInfoRsp.class);
    public final PBRepeatMessageField<ilive_user_basic_info$UserInfo> userinfo_list = PBField.initRepeatMessage(ilive_user_basic_info$UserInfo.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
}
