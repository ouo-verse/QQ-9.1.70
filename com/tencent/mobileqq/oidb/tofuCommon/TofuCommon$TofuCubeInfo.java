package com.tencent.mobileqq.oidb.tofuCommon;

import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class TofuCommon$TofuCubeInfo extends MessageMicro<TofuCommon$TofuCubeInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 50, 58, 66, 74}, new String[]{MessageForUniteGrayTip.KEY_UINT64_BUSI_ID, "uint64_uin", "string_busi_uuid", "uint32_style", "busi_desc", "busi_detail", "string_backgroud", "string_resource", "string_busi_ext"}, new Object[]{0L, 0L, "", 0, null, null, "", "", ""}, TofuCommon$TofuCubeInfo.class);
    public final PBUInt64Field uint64_busi_id = PBField.initUInt64(0);
    public final PBRepeatField<Long> uint64_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBStringField string_busi_uuid = PBField.initString("");
    public final PBUInt32Field uint32_style = PBField.initUInt32(0);
    public TofuCommon$Content busi_desc = new TofuCommon$Content();
    public final PBRepeatMessageField<TofuCommon$Content> busi_detail = PBField.initRepeatMessage(TofuCommon$Content.class);
    public final PBStringField string_backgroud = PBField.initString("");
    public final PBStringField string_resource = PBField.initString("");
    public final PBStringField string_busi_ext = PBField.initString("");
}
