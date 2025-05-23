package com.tencent.ilive_user_basic_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class ilive_user_basic_info$UserInfo extends MessageMicro<ilive_user_basic_info$UserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uin", "basic_info", "extra_info"}, new Object[]{0L, null, null}, ilive_user_basic_info$UserInfo.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public ilive_user_basic_info$UserBasicInfo basic_info = new MessageMicro<ilive_user_basic_info$UserBasicInfo>() { // from class: com.tencent.ilive_user_basic_info.ilive_user_basic_info$UserBasicInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uin"}, new Object[]{0L}, ilive_user_basic_info$UserBasicInfo.class);
        public final PBUInt64Field uin = PBField.initUInt64(0);
    };
    public ilive_user_basic_info$UserExtraInfo extra_info = new ilive_user_basic_info$UserExtraInfo();
}
