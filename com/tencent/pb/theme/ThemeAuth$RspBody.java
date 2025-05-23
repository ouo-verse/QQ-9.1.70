package com.tencent.pb.theme;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ThemeAuth$RspBody extends MessageMicro<ThemeAuth$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uint32_sub_cmd", "msg_subcmd0x1_rsp_auth", "msg_subcmd0x2_rsp_check", "msg_subcmd0x3_rsp_set"}, new Object[]{0, null, null, null}, ThemeAuth$RspBody.class);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public ThemeAuth$SubCmd0x1RspAuth msg_subcmd0x1_rsp_auth = new ThemeAuth$SubCmd0x1RspAuth();
    public ThemeAuth$SubCmd0x2RspCheck msg_subcmd0x2_rsp_check = new ThemeAuth$SubCmd0x2RspCheck();
    public ThemeAuth$SubCmd0x3RspSet msg_subcmd0x3_rsp_set = new ThemeAuth$SubCmd0x3RspSet();
}
