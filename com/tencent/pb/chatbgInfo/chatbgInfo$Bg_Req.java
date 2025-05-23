package com.tencent.pb.chatbgInfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class chatbgInfo$Bg_Req extends MessageMicro<chatbgInfo$Bg_Req> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"cmd", "packet_seq", "comm", "reqcmd_0x01"}, new Object[]{0, 0L, null, null}, chatbgInfo$Bg_Req.class);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBUInt64Field packet_seq = PBField.initUInt64(0);
    public chatbgInfo$Platform_Comm_Req comm = new MessageMicro<chatbgInfo$Platform_Comm_Req>() { // from class: com.tencent.pb.chatbgInfo.chatbgInfo$Platform_Comm_Req
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"ImPlat", TPReportKeys.Common.COMMON_OS_VERSION, "mqqver"}, new Object[]{0L, "", ""}, chatbgInfo$Platform_Comm_Req.class);
        public final PBInt64Field ImPlat = PBField.initInt64(0);
        public final PBStringField osver = PBField.initString("");
        public final PBStringField mqqver = PBField.initString("");
    };
    public chatbgInfo$Bg_CheckAuth_Req reqcmd_0x01 = new MessageMicro<chatbgInfo$Bg_CheckAuth_Req>() { // from class: com.tencent.pb.chatbgInfo.chatbgInfo$Bg_CheckAuth_Req
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"IdList", "BgEffectList"}, new Object[]{0, 0}, chatbgInfo$Bg_CheckAuth_Req.class);
        public final PBRepeatField<Integer> BgEffectList;
        public final PBRepeatField<Integer> IdList;

        {
            PBInt32Field pBInt32Field = PBInt32Field.__repeatHelper__;
            this.IdList = PBField.initRepeat(pBInt32Field);
            this.BgEffectList = PBField.initRepeat(pBInt32Field);
        }
    };
}
