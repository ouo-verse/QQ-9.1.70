package com.tencent.biz.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class clientbusilogic$GetRefuseMsgSettingResponse extends MessageMicro<clientbusilogic$GetRefuseMsgSettingResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rsp"}, new Object[]{null}, clientbusilogic$GetRefuseMsgSettingResponse.class);
    public Rsp rsp = new Rsp();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Rsp extends MessageMicro<Rsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"ret_info", "is_refuse"}, new Object[]{null, 0}, Rsp.class);
        public clientbusilogic$RetInfo ret_info = new clientbusilogic$RetInfo();
        public final PBUInt32Field is_refuse = PBField.initUInt32(0);
    }
}
