package com.tencent.pb.now;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class FeedsProtocol$GetLivingAnchorListRsp extends MessageMicro<FeedsProtocol$GetLivingAnchorListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32}, new String[]{"living_list", "result", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "total"}, new Object[]{null, 0, ByteStringMicro.EMPTY, 0}, FeedsProtocol$GetLivingAnchorListRsp.class);
    public final PBRepeatMessageField<FeedsProtocol$LivingAnchorInfo> living_list = PBField.initRepeatMessage(FeedsProtocol$LivingAnchorInfo.class);
    public final PBInt32Field result = PBField.initInt32(0);
    public final PBBytesField errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field total = PBField.initUInt32(0);
}
