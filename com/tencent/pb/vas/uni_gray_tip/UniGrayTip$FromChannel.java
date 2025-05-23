package com.tencent.pb.vas.uni_gray_tip;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class UniGrayTip$FromChannel extends MessageMicro<UniGrayTip$FromChannel> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{WadlProxyConsts.CHANNEL, "fromUin"}, new Object[]{0, ""}, UniGrayTip$FromChannel.class);
    public final PBUInt32Field channel = PBField.initUInt32(0);
    public final PBStringField fromUin = PBField.initString("");
}
