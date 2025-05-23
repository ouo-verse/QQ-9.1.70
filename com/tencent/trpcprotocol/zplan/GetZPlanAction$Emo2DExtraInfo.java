package com.tencent.trpcprotocol.zplan;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.tvkplayer.report.capability.decode.TVKDeviceDecodeCapabilityReportConstant;

/* loaded from: classes27.dex */
public final class GetZPlanAction$Emo2DExtraInfo extends MessageMicro<GetZPlanAction$Emo2DExtraInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"male_zip_url", "female_zip_url", TVKDeviceDecodeCapabilityReportConstant.DECODING_CAPABILITY_PARAM_FRAME_RATE}, new Object[]{"", "", 0}, GetZPlanAction$Emo2DExtraInfo.class);
    public final PBStringField male_zip_url = PBField.initString("");
    public final PBStringField female_zip_url = PBField.initString("");
    public final PBUInt32Field frame_rate = PBField.initUInt32(0);
}
