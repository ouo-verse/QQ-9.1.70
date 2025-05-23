package com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class CommonMobileConfQueryReq extends MessageMicro<CommonMobileConfQueryReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"commonReq", "reqConfList"}, new Object[]{null, null}, CommonMobileConfQueryReq.class);
    public CommonReq commonReq = new CommonReq();
    public final PBRepeatMessageField<MobileConfReq> reqConfList = PBField.initRepeatMessage(MobileConfReq.class);
}
