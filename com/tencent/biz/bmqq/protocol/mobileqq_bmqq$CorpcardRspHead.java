package com.tencent.biz.bmqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class mobileqq_bmqq$CorpcardRspHead extends MessageMicro<mobileqq_bmqq$CorpcardRspHead> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rspHead"}, new Object[]{null}, mobileqq_bmqq$CorpcardRspHead.class);
    public mobileqq_bmqq$HRTXHead rspHead = new mobileqq_bmqq$HRTXHead();
}
