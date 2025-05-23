package com.qwallet.protocol.Wallet.hb;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes3.dex */
public final class ElementPB$Addr extends MessageMicro<ElementPB$Addr> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"nationality", "province", "city", TtmlNode.TAG_REGION, "address"}, new Object[]{"", "", "", "", ""}, ElementPB$Addr.class);
    public final PBStringField nationality = PBField.initString("");
    public final PBStringField province = PBField.initString("");
    public final PBStringField city = PBField.initString("");
    public final PBStringField region = PBField.initString("");
    public final PBStringField address = PBField.initString("");
}
