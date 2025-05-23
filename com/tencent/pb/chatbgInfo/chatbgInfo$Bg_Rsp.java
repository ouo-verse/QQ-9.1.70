package com.tencent.pb.chatbgInfo;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class chatbgInfo$Bg_Rsp extends MessageMicro<chatbgInfo$Bg_Rsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 50}, new String[]{"ret", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "cmd", "packet_seq", "comm", "rspcmd_0x01"}, new Object[]{0L, "", 0, 0L, null, null}, chatbgInfo$Bg_Rsp.class);
    public final PBInt64Field ret = PBField.initInt64(0);
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBUInt64Field packet_seq = PBField.initUInt64(0);
    public chatbgInfo$Platform_Comm_Rsp comm = new MessageMicro<chatbgInfo$Platform_Comm_Rsp>() { // from class: com.tencent.pb.chatbgInfo.chatbgInfo$Platform_Comm_Rsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], chatbgInfo$Platform_Comm_Rsp.class);
    };
    public chatbgInfo$Bg_CheckAuth_Rsp rspcmd_0x01 = new chatbgInfo$Bg_CheckAuth_Rsp();
}
