package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class EmosmPb$SubCmd0x3ReqFetchBq extends MessageMicro<EmosmPb$SubCmd0x3ReqFetchBq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> rpt_bytes_bqid;
    public final PBRepeatField<ByteStringMicro> rpt_new_itemid;
    public final PBUInt32Field uint32_tab_id = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_tab_id", "rpt_bytes_bqid", "rpt_new_itemid"}, new Object[]{0, byteStringMicro, byteStringMicro}, EmosmPb$SubCmd0x3ReqFetchBq.class);
    }

    public EmosmPb$SubCmd0x3ReqFetchBq() {
        PBBytesField pBBytesField = PBBytesField.__repeatHelper__;
        this.rpt_bytes_bqid = PBField.initRepeat(pBBytesField);
        this.rpt_new_itemid = PBField.initRepeat(pBBytesField);
    }
}
