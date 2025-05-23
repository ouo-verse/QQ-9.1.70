package com.qwallet.protocol.Wallet.hb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;

/* loaded from: classes3.dex */
public final class ElementPB$PreCheckRegElementReq extends MessageMicro<ElementPB$PreCheckRegElementReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{DTConstants.TAG.ELEMENT}, new Object[]{null}, ElementPB$PreCheckRegElementReq.class);
    public ElementPB$RegElement element = new ElementPB$RegElement();
}
