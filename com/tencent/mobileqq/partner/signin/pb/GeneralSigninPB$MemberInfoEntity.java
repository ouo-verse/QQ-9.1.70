package com.tencent.mobileqq.partner.signin.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class GeneralSigninPB$MemberInfoEntity extends MessageMicro<GeneralSigninPB$MemberInfoEntity> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", null}, GeneralSigninPB$MemberInfoEntity.class);
    public final PBStringField key = PBField.initString("");
    public GeneralSigninPB$MemberInfo value = new MessageMicro<GeneralSigninPB$MemberInfo>() { // from class: com.tencent.mobileqq.partner.signin.pb.GeneralSigninPB$MemberInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"uid", "uin"}, new Object[]{"", ""}, GeneralSigninPB$MemberInfo.class);
        public final PBStringField uid = PBField.initString("");
        public final PBStringField uin = PBField.initString("");
    };
}
