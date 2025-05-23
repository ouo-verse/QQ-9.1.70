package com.tencent.pb.vipfontupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class VipFontUpdate$TDiyFontReq extends MessageMicro<VipFontUpdate$TDiyFontReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_font_req_info"}, new Object[]{null}, VipFontUpdate$TDiyFontReq.class);
    public final PBRepeatMessageField<TDiyFontReqInfo> rpt_font_req_info = PBField.initRepeatMessage(TDiyFontReqInfo.class);

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class TDiyFontReqInfo extends MessageMicro<TDiyFontReqInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"u64_uin", "i32_font_id"}, new Object[]{0L, 0}, TDiyFontReqInfo.class);
        public final PBUInt64Field u64_uin = PBField.initUInt64(0);
        public final PBInt32Field i32_font_id = PBField.initInt32(0);
    }
}
