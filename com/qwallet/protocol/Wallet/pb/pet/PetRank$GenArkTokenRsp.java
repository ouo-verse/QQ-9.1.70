package com.qwallet.protocol.Wallet.pb.pet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes3.dex */
public final class PetRank$GenArkTokenRsp extends MessageMicro<PetRank$GenArkTokenRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"sign", "title", "cover_image", "url"}, new Object[]{"", "", "", ""}, PetRank$GenArkTokenRsp.class);
    public final PBStringField sign = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField cover_image = PBField.initString("");
    public final PBStringField url = PBField.initString("");
}
