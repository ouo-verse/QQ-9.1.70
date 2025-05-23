package com.tencent.trpcprotocol.qqva;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class midasPayCoinb$BuyGoodsRsp extends MessageMicro<midasPayCoinb$BuyGoodsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"code", "msg", "token", "url_params"}, new Object[]{0, "", "", ""}, midasPayCoinb$BuyGoodsRsp.class);
    public final PBInt32Field code = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f381633msg = PBField.initString("");
    public final PBStringField token = PBField.initString("");
    public final PBStringField url_params = PBField.initString("");
}
