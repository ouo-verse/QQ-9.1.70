package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.tvkplayer.report.capability.spatialaudio.TVKDeviceSpatialAudioCapabilityReportConstant;

/* loaded from: classes3.dex */
public final class HardWareCodecSSO$PowerInfo extends MessageMicro<HardWareCodecSSO$PowerInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"mark", TVKDeviceSpatialAudioCapabilityReportConstant.SPATIAL_AUDIO_CAPABILITY_PARAM_SURPPORT, "max_width", "max_height"}, new Object[]{0L, Boolean.FALSE, 0L, 0L}, HardWareCodecSSO$PowerInfo.class);
    public final PBUInt64Field mark = PBField.initUInt64(0);
    public final PBBoolField support = PBField.initBool(false);
    public final PBUInt64Field max_width = PBField.initUInt64(0);
    public final PBUInt64Field max_height = PBField.initUInt64(0);
}
