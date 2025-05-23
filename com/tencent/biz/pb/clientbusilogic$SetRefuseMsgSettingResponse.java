package com.tencent.biz.pb;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class clientbusilogic$SetRefuseMsgSettingResponse extends MessageMicro<clientbusilogic$SetRefuseMsgSettingResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rsp"}, new Object[]{null}, clientbusilogic$SetRefuseMsgSettingResponse.class);
    public Rsp rsp = new Rsp();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Rsp extends MessageMicro<Rsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"ret_info"}, new Object[]{null}, Rsp.class);
        public clientbusilogic$RetInfo ret_info = new clientbusilogic$RetInfo();
    }
}
