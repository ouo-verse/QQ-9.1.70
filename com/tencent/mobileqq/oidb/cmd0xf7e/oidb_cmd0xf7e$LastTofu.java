package com.tencent.mobileqq.oidb.cmd0xf7e;

import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class oidb_cmd0xf7e$LastTofu extends MessageMicro<oidb_cmd0xf7e$LastTofu> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{MessageForUniteGrayTip.KEY_UINT64_BUSI_ID, "string_busi_uuid", "delete_flag"}, new Object[]{0L, "", 0L}, oidb_cmd0xf7e$LastTofu.class);
    public final PBUInt64Field uint64_busi_id = PBField.initUInt64(0);
    public final PBStringField string_busi_uuid = PBField.initString("");
    public final PBUInt64Field delete_flag = PBField.initUInt64(0);
}
