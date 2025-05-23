package com.tencent.mobileqq.weiyun.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes20.dex */
public final class WeiyunPB$PwdQueryMsgRsp extends MessageMicro<WeiyunPB$PwdQueryMsgRsp> {
    public static final int PWD_OPEN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"pwd_open"}, new Object[]{Boolean.FALSE}, WeiyunPB$PwdQueryMsgRsp.class);
    public final PBBoolField pwd_open = PBField.initBool(false);
}
