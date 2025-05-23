package com.tencent.protofile;

import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class groupMngTransInfo$JoinGroupTransInfo extends MessageMicro<groupMngTransInfo$JoinGroupTransInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"business_id", "self_introduction_switch", CGNonAgeReport.EVENT_CHANNEL}, new Object[]{ByteStringMicro.EMPTY, 0, null}, groupMngTransInfo$JoinGroupTransInfo.class);
    public final PBBytesField business_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field self_introduction_switch = PBField.initUInt32(0);
    public groupMngTransInfo$ChannelInfo channel_info = new groupMngTransInfo$ChannelInfo();
}
