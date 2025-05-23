package com.qwallet.protocol.Wallet.hb;

import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes3.dex */
public final class ElementPB$CheckAddressReq extends MessageMicro<ElementPB$CheckAddressReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"addr"}, new Object[]{null}, ElementPB$CheckAddressReq.class);
    public ElementPB$Addr addr = new ElementPB$Addr();
}
